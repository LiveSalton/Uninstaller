package com.salton123.uninstaller.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;

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
     * 判断应用是否是第三方应用
     *
     * @param applicationInfo
     * @return
     */
    public static boolean isThirdPartyApp(ApplicationInfo applicationInfo) {
        boolean flag = false;
        if ((applicationInfo.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) {
            // 可更新的系统应用
            flag = true;
        } else if ((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
            // 非系统应用(第三方:用户自己安装)
            flag = true;
        }
        return flag;
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
        long kb = 1024;
        long mb = 1024 * kb;
        long gb = 1024 * mb;
        if (length < kb) {
            return String.format("%dB", (int) length);
        } else if (length < mb) {
            return String.format("%.2fKB", length / kb);
        } else if (length < gb) {
            return String.format("%.2fMB", length / mb);
        } else {
            return String.format("%.2fGB", length / gb);
        }
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
     * copy file
     *
     * @param sourceFilePath
     * @param destFilePath
     * @return
     * @throws RuntimeException if an error occurs while operator FileOutputStream
     */
    public static boolean copyFile(String sourceFilePath, String destFilePath) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(sourceFilePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException occurred. ", e);
        }
        return writeFile(destFilePath, inputStream);
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

}
