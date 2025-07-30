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
            String fileName = backupFile.getName();
            String infoFileName = fileName.replace(BACKUP_FILE_EXTENSION, ".info");
            File infoFile = new File(backupFile.getParent(), infoFileName);
            
            BackupInfo info = new BackupInfo();
            info.backupFile = backupFile;
            info.backupFileName = fileName;
            info.backupTime = new Date(backupFile.lastModified());
            info.fileSize = backupFile.length();
            
            // 尝试从文件名解析基本信息
            if (fileName.contains("_v") && fileName.contains("_")) {
                String[] parts = fileName.split("_");
                if (parts.length >= 3) {
                    info.packageName = parts[0];
                    info.versionName = parts[1].substring(1); // 移除 'v' 前缀
                }
            }
            
            // 如果有信息文件，读取详细信息
            if (infoFile.exists()) {
                // 这里可以读取详细的备份信息
                info.hasDetailInfo = true;
            }
            
            return info;
        } catch (Exception e) {
            XLog.e(TAG, "解析备份文件失败: " + e.getMessage());
            return null;
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
    public static class BackupInfo {
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
