package com.salton123.uninstaller.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;

import com.salton123.log.XLog;
import com.salton123.uninstaller.PreloadCore;
import com.salton123.uninstaller.entity.AppEntity;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * 应用备份和恢复管理器
 * 支持APK文件的备份和恢复功能
 */
public class BackupManager {

    private static final String TAG = "BackupManager";
    private static final String BACKUP_FOLDER_NAME = "UninstallerBackup";
    private static final String BACKUP_FILE_EXTENSION = ".apk.backup";
    
    // 取消标志
    private static volatile boolean isCancelled = false;
    // 当前运行的备份任务
    private static final List<Future<?>> runningTasks = new ArrayList<>();
    
    // 备份路径 - 始终使用应用专属外部存储目录，无需存储权限
    public static String getBackupPath(Context context) {
        // 使用应用专属外部存储目录，这不需要任何存储权限
        File backupDir = new File(context.getExternalFilesDir(null), BACKUP_FOLDER_NAME);
        
        // 确保目录存在
        if (!backupDir.exists()) {
            backupDir.mkdirs();
        }
        
        return backupDir.getAbsolutePath() + File.separator;
    }
    
    static int backupCount;
    static int successCount;
    static int failedCount;

    /**
     * 取消当前备份任务
     */
    public static void cancelBackup() {
        isCancelled = true;
        
        // 取消所有运行中的任务
        synchronized (runningTasks) {
            for (Future<?> task : runningTasks) {
                if (!task.isDone() && !task.isCancelled()) {
                    task.cancel(true);
                }
            }
            runningTasks.clear();
        }
        
        XLog.i(TAG, "备份任务已取消");
    }
    
    /**
     * 重置取消状态
     */
    public static void resetCancellation() {
        isCancelled = false;
        synchronized (runningTasks) {
            runningTasks.clear();
        }
    }

    /**
     * 备份应用列表
     */
    public static void toBackup(final List<AppEntity> toBackupData, final Context context, final IBackupProgress iBackup) {
        if (toBackupData == null || toBackupData.isEmpty()) {
            XLog.w(TAG, "No data to backup");
            if (iBackup != null) {
                iBackup.onBackupComplete(false, "没有要备份的应用", 0, 0);
            }
            return;
        }

        // 重置状态
        resetCancellation();
        backupCount = 0;
        successCount = 0;
        failedCount = 0;

        // 确保备份目录存在
        if (!ensureBackupDirectory(context)) {
            if (iBackup != null) {
                iBackup.onBackupComplete(false, "创建备份目录失败", 0, 0);
            }
            return;
        }
        
        int totalApps = toBackupData.size();
        
        // 准备阶段回调
        if (iBackup != null) {
            iBackup.onBackupPrepare(totalApps);
        }
        
        for (int i = 0; i < totalApps; i++) {
            if (isCancelled) {
                if (iBackup != null) {
                    iBackup.onBackupComplete(false, "备份已取消", successCount, failedCount);
                }
                return;
            }
            
            final AppEntity item = toBackupData.get(i);
            final int index = i;
            
            Future<?> future = PreloadCore.INSTANCE.mThreadPool.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() {
                    if (isCancelled) {
                        return false;
                    }
                    
                    try {
                        // 准备开始备份当前应用
                        if (iBackup != null) {
                            iBackup.onBackupStart(item, index + 1, totalApps);
                        }
                        
                        boolean result = backupSingleApp(item, context);
                        
                        synchronized (BackupManager.class) {
                            backupCount++;
                            if (result) {
                                successCount++;
                            } else {
                                failedCount++;
                            }
                            
                            if (iBackup != null) {
                                iBackup.onProgress(backupCount, totalApps, result, item.mAppName, item.appInfo.packageName);
                                
                                // 检查是否全部完成
                                if (backupCount >= totalApps) {
                                    String message = "备份完成，成功: " + successCount + "，失败: " + failedCount;
                                    iBackup.onBackupComplete(failedCount == 0, message, successCount, failedCount);
                                }
                            }
                        }
                        
                        return result;
                    } catch (Exception e) {
                        XLog.e(TAG, "Backup failed for " + item.mAppName + ": " + e.getMessage());
                        synchronized (BackupManager.class) {
                            backupCount++;
                            failedCount++;
                            
                            if (iBackup != null) {
                                iBackup.onProgress(backupCount, totalApps, false, item.mAppName, item.appInfo.packageName);
                                
                                if (backupCount >= totalApps) {
                                    String message = "备份完成，成功: " + successCount + "，失败: " + failedCount;
                                    iBackup.onBackupComplete(false, message, successCount, failedCount);
                                }
                            }
                        }
                        return false;
                    }
                }
            });
            
            synchronized (runningTasks) {
                runningTasks.add(future);
            }
        }
    }

    /**
     * 备份单个应用
     */
    private static boolean backupSingleApp(AppEntity app, Context context) {
        try {
            String sourceFilePath = app.mPath;
            if (sourceFilePath == null || sourceFilePath.isEmpty()) {
                sourceFilePath = app.appInfo.applicationInfo.publicSourceDir;
            }
            
            if (sourceFilePath == null) {
                XLog.e(TAG, "无法获取应用路径: " + app.mAppName);
                return false;
            }

            // 生成备份文件名
            String backupFileName = generateBackupFileName(app);
            String destPath = getBackupPath(context) + backupFileName;
            
            // 检查是否已存在相同包名和版本的备份，如果存在则删除旧备份
            deleteExistingBackup(app, context);
            
            // 执行文件复制
            boolean result = Utils.copyFile(sourceFilePath, destPath);
            
            if (result) {
                XLog.i(TAG, "备份成功: " + app.mAppName + " -> " + destPath);
                
                // 创建备份信息文件
                createBackupInfo(app, backupFileName, context);
            } else {
                XLog.e(TAG, "备份失败: " + app.mAppName);
            }
            
            return result;
        } catch (Exception e) {
            XLog.e(TAG, "备份应用出错: " + app.mAppName + " - " + e.getMessage());
            return false;
        }
    }

    /**
     * 检查并删除已存在的相同包名和版本的备份
     */
    private static void deleteExistingBackup(AppEntity app, Context context) {
        try {
            File backupDir = new File(getBackupPath(context));
            if (!backupDir.exists()) {
                return;
            }

            File[] files = backupDir.listFiles();
            if (files == null) {
                return;
            }

            String packageName = app.appInfo.packageName;
            String versionName = app.appInfo.versionName != null ? app.appInfo.versionName : "unknown";
            
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(BACKUP_FILE_EXTENSION)) {
                    // 解析文件名，检查包名和版本是否匹配
                    String fileName = file.getName();
                    // 文件名格式: appName_packageName_vversionName_timestamp.apk.backup
                    if (fileName.contains(packageName + "_v" + versionName + "_")) {
                        // 删除旧的备份文件
                        if (file.delete()) {
                            XLog.i(TAG, "删除旧备份文件: " + fileName);
                            
                            // 同时删除对应的info文件
                            String infoFileName = fileName.replace(BACKUP_FILE_EXTENSION, ".info");
                            File infoFile = new File(backupDir, infoFileName);
                            if (infoFile.exists()) {
                                infoFile.delete();
                                XLog.i(TAG, "删除旧备份信息文件: " + infoFileName);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            XLog.e(TAG, "检查和删除旧备份时出错: " + e.getMessage());
        }
    }

    /**
     * 生成备份文件名
     */
    private static String generateBackupFileName(AppEntity app) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
                .format(new Date());
        String packageName = app.appInfo.packageName;
        String versionName = app.appInfo.versionName != null ? app.appInfo.versionName : "unknown";
        String appName = app.mAppName != null ? app.mAppName : packageName;
        
        // 确保文件名有效，移除特殊字符
        appName = appName.replaceAll("[\\\\/:*?\"<>|]", "_");
        versionName = versionName.replaceAll("[\\\\/:*?\"<>|]", "_");
        
        return appName + "_" + packageName + "_v" + versionName + "_" + timestamp + BACKUP_FILE_EXTENSION;
    }
    
    /**
     * 检查文件路径是否可访问
     */
    private static boolean isFileAccessible(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return false;
        }
        
        File file = new File(filePath);
        return file.exists() && file.isFile() && file.canRead();
    }

    /**
     * 创建备份信息文件
     */
    private static void createBackupInfo(AppEntity app, String backupFileName, Context context) {
        try {
            String infoFileName = backupFileName.replace(BACKUP_FILE_EXTENSION, ".info");
            String infoFilePath = getBackupPath(context) + infoFileName;
            
            StringBuilder info = new StringBuilder();
            info.append("应用名称: ").append(app.mAppName).append("\n");
            info.append("包名: ").append(app.appInfo.packageName).append("\n");
            info.append("版本名称: ").append(app.appInfo.versionName).append("\n");
            info.append("版本号: ").append(app.appInfo.versionCode).append("\n");
            info.append("备份时间: ").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                    .format(new Date())).append("\n");
            info.append("原始路径: ").append(app.mPath).append("\n");
            info.append("备份文件: ").append(backupFileName).append("\n");
            
            Utils.writeFile(infoFilePath, info.toString().getBytes());
        } catch (Exception e) {
            XLog.e(TAG, "创建备份信息文件失败: " + e.getMessage());
        }
    }

    /**
     * 获取所有备份文件
     */
    public static List<BackupInfo> getBackupList(Context context) {
        List<BackupInfo> backupList = new ArrayList<>();
        
        File backupDir = new File(getBackupPath(context));
        if (!backupDir.exists()) {
            return backupList;
        }
        
        File[] files = backupDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(BACKUP_FILE_EXTENSION)) {
                    BackupInfo info = parseBackupFile(file);
                    if (info != null) {
                        backupList.add(info);
                    }
                }
            }
        }
        
        return backupList;
    }

    /**
     * 解析备份文件信息
     */
    private static BackupInfo parseBackupFile(File backupFile) {
        try {
            XLog.d(TAG, "开始解析备份文件: " + backupFile.getAbsolutePath());
            String fileName = backupFile.getName();
            String infoFileName = fileName.replace(BACKUP_FILE_EXTENSION, ".info");
            File infoFile = new File(backupFile.getParent(), infoFileName);
            
            BackupInfo info = new BackupInfo();
            info.backupFile = backupFile;
            info.backupFileName = fileName;
            info.backupTime = new Date(backupFile.lastModified());
            info.fileSize = backupFile.length();
            
            XLog.d(TAG, "基础信息 - 文件名: " + fileName + ", 文件大小: " + info.fileSize + ", 修改时间: " + info.backupTime);
            
            // 从信息文件读取详细信息（如果存在）
            if (infoFile.exists()) {
                XLog.d(TAG, "信息文件存在，开始解析: " + infoFile.getAbsolutePath());
                parseBackupInfoFile(infoFile, info);
            } else {
                XLog.d(TAG, "信息文件不存在，从文件名解析基本信息: " + infoFileName);
                // 尝试从文件名解析基本信息
                parseInfoFromFileName(fileName, info);
            }
            
            XLog.d(TAG, "解析完成: " + info.appName + ", " + info.packageName + ", " + info.versionName + ", " + info.fileSize);
            return info;
        } catch (Exception e) {
            XLog.e(TAG, "解析备份文件失败: " + e.getMessage());
            return null;
        }
    }

    /**
     * 从信息文件解析详细信息
     */
    private static void parseBackupInfoFile(File infoFile, BackupInfo info) {
        try {
            XLog.d(TAG, "开始解析备份信息文件: " + infoFile.getAbsolutePath());
            String content = Utils.readFile(infoFile.getAbsolutePath());
            XLog.d(TAG, "读取到的文件内容: " + content);
            if (content != null && !content.isEmpty()) {
                String[] lines = content.split("\n");
                for (String line : lines) {
                    XLog.d(TAG, "解析行内容: " + line);
                    if (line.startsWith("应用名称: ")) {
                        info.appName = line.substring("应用名称: ".length());
                        XLog.d(TAG, "解析到应用名称: " + info.appName);
                    } else if (line.startsWith("包名: ")) {
                        info.packageName = line.substring("包名: ".length());
                        XLog.d(TAG, "解析到包名: " + info.packageName);
                    } else if (line.startsWith("版本名称: ")) {
                        info.versionName = line.substring("版本名称: ".length());
                        XLog.d(TAG, "解析到版本名称: " + info.versionName);
                    } else if (line.startsWith("备份时间: ")) {
                        String timeStr = line.substring("备份时间: ".length());
                        XLog.d(TAG, "解析到备份时间字符串: " + timeStr);
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                            info.backupTime = sdf.parse(timeStr);
                            XLog.d(TAG, "解析到备份时间: " + info.backupTime);
                        } catch (Exception e) {
                            // 使用文件修改时间
                            info.backupTime = new Date(info.backupFile.lastModified());
                            XLog.d(TAG, "使用文件修改时间: " + info.backupTime);
                        }
                    }
                }
                info.hasDetailInfo = true;
                XLog.d(TAG, "信息文件解析完成");
            }
        } catch (Exception e) {
            XLog.e(TAG, "解析备份信息文件失败: " + e.getMessage());
        }
    }

    /**
     * 从文件名解析基本信息
     */
    private static void parseInfoFromFileName(String fileName, BackupInfo info) {
        try {
            XLog.d(TAG, "从文件名解析基本信息: " + fileName);
            // 文件名格式: appName_packageName_vversionName_timestamp.apk.backup
            // 移除扩展名
            String nameWithoutExt = fileName.replace(BACKUP_FILE_EXTENSION, "");
            XLog.d(TAG, "移除扩展名后: " + nameWithoutExt);
            
            // 按下划线分割
            String[] parts = nameWithoutExt.split("_");
            XLog.d(TAG, "分割后的部分数量: " + parts.length);
            for (int i = 0; i < parts.length; i++) {
                XLog.d(TAG, "部分[" + i + "]: " + parts[i]);
            }
            
            if (parts.length >= 4) {
                // 应用名称可能是多个部分组成，包名通常是倒数第三个，版本是倒数第二个
                info.packageName = parts[parts.length - 3];
                String versionPart = parts[parts.length - 2];
                if (versionPart.startsWith("v")) {
                    info.versionName = versionPart.substring(1);
                } else {
                    info.versionName = versionPart;
                }
                
                // 尝试重构应用名称（除了包名和版本的部分）
                StringBuilder appNameBuilder = new StringBuilder();
                for (int i = 0; i < parts.length - 3; i++) {
                    if (appNameBuilder.length() > 0) {
                        appNameBuilder.append("_");
                    }
                    appNameBuilder.append(parts[i]);
                }
                info.appName = appNameBuilder.toString();
                
                XLog.d(TAG, "解析结果 - 应用名称: " + info.appName + ", 包名: " + info.packageName + ", 版本: " + info.versionName);
            } else {
                XLog.d(TAG, "文件名部分不足4个，无法解析");
            }
        } catch (Exception e) {
            XLog.e(TAG, "从文件名解析信息失败: " + e.getMessage());
        }
    }

    /**
     * 恢复应用
     */
    public static void restoreApp(Context context, BackupInfo backupInfo) {
        try {
            File backupFile = backupInfo.backupFile;
            if (!backupFile.exists()) {
                XLog.e(TAG, "备份文件不存在: " + backupFile.getAbsolutePath());
                return;
            }

            // 创建临时APK文件用于安装
            String tempFileName = backupInfo.packageName + "_temp.apk";
            File tempDir = new File(context.getExternalCacheDir(), "restore");
            if (!tempDir.exists()) {
                tempDir.mkdirs();
            }
            
            File tempApkFile = new File(tempDir, tempFileName);
            
            // 复制备份文件到临时位置
            boolean copyResult = Utils.copyFile(backupFile.getAbsolutePath(), tempApkFile.getAbsolutePath());
            if (!copyResult) {
                XLog.e(TAG, "复制备份文件失败");
                return;
            }

            // 启动安装界面
            installApk(context, tempApkFile);
            
        } catch (Exception e) {
            XLog.e(TAG, "恢复应用失败: " + e.getMessage());
        }
    }

    /**
     * 安装APK文件
     */
    private static void installApk(Context context, File apkFile) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            
            // 对于Android 7.0及以上，我们需要设置文件权限
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                // 由于不能使用FileProvider，我们直接使用file URI
                // 注意：这在某些设备上可能不工作，但这是最简单的方案
                intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            } else {
                intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
            }
            
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            
            XLog.i(TAG, "启动APK安装: " + apkFile.getName());
        } catch (Exception e) {
            XLog.e(TAG, "启动APK安装失败: " + e.getMessage());
        }
    }

    /**
     * 删除备份文件
     */
    public static boolean deleteBackup(BackupInfo backupInfo) {
        try {
            boolean result = true;
            
            // 删除备份文件
            if (backupInfo.backupFile.exists()) {
                result &= backupInfo.backupFile.delete();
            }
            
            // 删除信息文件
            String infoFileName = backupInfo.backupFileName.replace(BACKUP_FILE_EXTENSION, ".info");
            File infoFile = new File(backupInfo.backupFile.getParent(), infoFileName);
            if (infoFile.exists()) {
                result &= infoFile.delete();
            }
            
            XLog.i(TAG, "删除备份: " + backupInfo.backupFileName + " - " + (result ? "成功" : "失败"));
            return result;
        } catch (Exception e) {
            XLog.e(TAG, "删除备份失败: " + e.getMessage());
            return false;
        }
    }

    /**
     * 确保备份目录存在
     */
    private static boolean ensureBackupDirectory(Context context) {
        File backupDir = new File(getBackupPath(context));
        if (!backupDir.exists()) {
            boolean created = backupDir.mkdirs();
            XLog.i(TAG, "创建备份目录: " + backupDir.getAbsolutePath() + " - " + (created ? "成功" : "失败"));
            return created;
        }
        return true;
    }

    /**
     * 获取备份目录大小
     */
    public static long getBackupDirectorySize(Context context) {
        File backupDir = new File(getBackupPath(context));
        return getDirectorySize(backupDir);
    }

    /**
     * 计算目录大小
     */
    private static long getDirectorySize(File dir) {
        long size = 0;
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        size += getDirectorySize(file);
                    } else {
                        size += file.length();
                    }
                }
            }
        }
        return size;
    }

    /**
     * 备份进度回调接口
     */
    public interface IBackupProgress {
        /**
         * 备份准备阶段
         * @param totalApps 总应用数
         */
        default void onBackupPrepare(int totalApps) {}
        
        /**
         * 开始备份某个应用
         * @param app 当前应用
         * @param current 当前索引
         * @param total 总数
         */
        default void onBackupStart(AppEntity app, int current, int total) {}
        
        /**
         * 备份进度更新
         * @param current 当前完成数量
         * @param total 总数量
         * @param isSuccess 当前应用是否备份成功
         * @param appName 应用名称
         * @param packageName 包名
         */
        void onProgress(int current, int total, boolean isSuccess, String appName, String packageName);
        
        /**
         * 原兼容方法
         */
        default void onProgress(int current, int total, boolean isSuccess, String appName) {
            onProgress(current, total, isSuccess, appName, "");
        }
        
        /**
         * 备份完成
         * @param success 是否全部成功
         * @param message 完成消息
         * @param successCount 成功数量
         * @param failedCount 失败数量
         */
        void onBackupComplete(boolean success, String message, int successCount, int failedCount);
        
        /**
         * 原兼容方法
         */
        default void onBackupComplete(boolean success, String message) {
            onBackupComplete(success, message, 0, 0);
        }
    }

    /**
     * 备份文件信息类
     */
    public static class BackupInfo implements Serializable {
        public File backupFile;
        public String backupFileName;
        public String packageName;
        public String appName;
        public String versionName;
        public Date backupTime;
        public long fileSize;
        public boolean hasDetailInfo;

        @Override
        public String toString() {
            return "BackupInfo{" +
                    "packageName='" + packageName + '\'' +
                    ", appName='" + appName + '\'' +
                    ", versionName='" + versionName + '\'' +
                    ", backupTime=" + backupTime +
                    ", fileSize=" + fileSize +
                    '}';
        }
    }
}
