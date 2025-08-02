package com.salton123.uninstaller.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;

import androidx.core.content.FileProvider;

import com.salton123.log.XLog;
import com.salton123.uninstaller.entity.AppEntity;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 开发工具类
 */
public class Utils {

    private static final String PASSWORD_ENC_SECRET = "1234567890123456";
    public static String KEY = "";//全局搜索的关键

    /**
     * 字节--> Mb, 保留两位小数: 2.35M
     *
     * @param size
     * @return
     */
    public static String getSize(long size) {
        return new DecimalFormat("0.##").format(size * 1.0 / (1024 * 1024));
    }

    /**
     * 时间转化函数
     *
     * @param millis
     * @return
     */
    public static String getTime(long millis) {
        Date date = new Date(millis);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 判断应用是否是第三方应用（用户主动安装的应用）
     *
     * @param applicationInfo
     * @return
     */
    public static boolean isThirdPartyApp(ApplicationInfo applicationInfo) {
        // 检查是否是系统应用
        boolean isSystemApp = (applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
        
        // 检查是否是更新过的系统应用
        boolean isUpdatedSystemApp = (applicationInfo.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0;
        
        // 如果既不是系统应用也不是更新过的系统应用，则是用户安装的第三方应用
        return !isSystemApp && !isUpdatedSystemApp;
    }

    /**
     * 打开应用
     *
     * @param context
     * @param packageName
     * @return
     */
    public static boolean openPackage(Context context, String packageName) {

        // 系统调用
        try {
            Intent intent =// 获取可以启动该应用的意图
                    context.getPackageManager().getLaunchIntentForPackage(packageName);
            if (intent != null) {
                // 添加旗标-Flag
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//在新的进程里启动
                context.startActivity(intent);// 普通的发送
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 卸载应用
     *
     * @param context     上下文
     * @param packageName 包名
     * @param requestCode 请求码
     */
    public static void uninstallApk(Activity context,
                                    String packageName, int requestCode) {
        Uri packageURI = Uri.parse("package:" + packageName);
        Intent intent = new Intent(
                Intent.ACTION_DELETE,// 动作:删除
                packageURI // 所要删除程序的地址
        );
        context.startActivityForResult(intent, requestCode);
        //ForResult 等待返回值的发送(扔飞镖)
    }

    /**
     * 格式转换应用大小 单位"B,KB,MB,GB"
     */
    public static String getSize2(float length) {
        XLog.d("Utils", "getSize2 输入参数: " + length);
        long kb = 1024;
        long mb = 1024 * kb;
        long gb = 1024 * mb;
        String result;
        if (length < kb) {
            result = String.format("%dB", (int) length);
        } else if (length < mb) {
            result = String.format("%.2fKB", length / kb);
        } else if (length < gb) {
            result = String.format("%.2fMB", length / mb);
        } else {
            result = String.format("%.2fGB", length / gb);
        }
        XLog.d("Utils", "getSize2 输出结果: " + result);
        return result;
    }

    public static List<AppEntity> getSearchResult(List<AppEntity> list, String keyword) {
        //返回实体集合
        List<AppEntity> searchResultList = new ArrayList<>();
        //循环遍历
        for (int i = 0; i < list.size(); i++) {
            AppEntity app = list.get(i);//拿到单个的实体类
            //拿关键字和实体类比较
            if (app.mAppName.toLowerCase().contains(keyword.toLowerCase())) {
                searchResultList.add(app);//添加到结果集
            }
        }
        return searchResultList;
    }

    /**
     * copy file 增强版本
     *
     * @param sourceFilePath 源文件路径
     * @param destFilePath 目标文件路径
     * @return 是否复制成功
     */
    public static boolean copyFile(String sourceFilePath, String destFilePath) {
        if (TextUtils.isEmpty(sourceFilePath) || TextUtils.isEmpty(destFilePath)) {
            return false;
        }
        
        File sourceFile = new File(sourceFilePath);
        if (!sourceFile.exists() || !sourceFile.isFile() || !sourceFile.canRead()) {
            return false;
        }
        
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(sourceFilePath);
            // 检查文件大小，防止复制过大的文件
            long fileSize = sourceFile.length();
            if (fileSize <= 0) {
                return false;
            }
            
            // 确保目标目录存在
            File destFile = new File(destFilePath);
            File destDir = destFile.getParentFile();
            if (destDir != null && !destDir.exists()) {
                boolean created = destDir.mkdirs();
                if (!created) {
                    return false;
                }
            }
            
            return writeFile(destFilePath, inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeQuietly(inputStream);
        }
    }

    public static boolean writeFile(String filePath, InputStream stream, boolean append) {
        return writeFile(filePath != null ? new File(filePath) : null, stream, append);
    }

    public static boolean writeFile(String filePath, InputStream stream) {
        return writeFile(filePath, stream, false);
    }

    public static boolean writeFile(File file, InputStream stream, boolean append) {
        OutputStream o = null;
        try {
            makeDirs(file.getAbsolutePath());
            o = new FileOutputStream(file, append);
            byte data[] = new byte[1024];
            int length = -1;
            while ((length = stream.read(data)) != -1) {
                o.write(data, 0, length);
            }
            o.flush();
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException occurred. ", e);
        } catch (IOException e) {
            throw new RuntimeException("IOException occurred. ", e);
        } finally {
            closeQuietly(o);
            closeQuietly(stream);
        }
    }

    public static boolean makeDirs(String filePath) {
        String folderName = getFolderName(filePath);
        if (TextUtils.isEmpty(folderName)) {
            return false;
        }

        File folder = new File(folderName);
        return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
    }

    public static String getFolderName(String filePath) {

        if (TextUtils.isEmpty(filePath)) {
            return filePath;
        }

        int filePosi = filePath.lastIndexOf(File.separator);
        return (filePosi == -1) ? "" : filePath.substring(0, filePosi);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                // Ignored
            }
        }
    }

    public static boolean canWriteStorage(Context context) {
        return context.checkPermission(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Process.myPid(),
                Process.myUid()) == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean writeFile(String filePath, byte[] data) {
        try {
            File file = new File(filePath);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }
            
            java.io.FileOutputStream fos = new java.io.FileOutputStream(file);
            fos.write(data);
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * 读取文件内容为字符串
     */
    public static String readFile(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists() || !file.isFile()) {
                return null;
            }
            
            java.io.FileInputStream fis = new java.io.FileInputStream(file);
            java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
            
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, length);
            }
            
            fis.close();
            byte[] data = bos.toByteArray();
            bos.close();
            
            return new String(data, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取文件的Uri，兼容Android 7.0及以上版本
     * @param context 上下文
     * @param file 文件
     * @return 文件Uri
     */
    public static Uri getUriForFile(Context context, File file) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
        } else {
            return Uri.fromFile(file);
        }
    }
}
