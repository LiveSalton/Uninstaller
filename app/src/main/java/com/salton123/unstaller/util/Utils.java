package com.salton123.unstaller.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;

import com.salton123.unstaller.PreloadCore;
import com.salton123.unstaller.entity.AppInfo;

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

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * 开发工具类
 */
public class Utils {

    private static final String PASSWORD_ENC_SECRET = "1234567890123456";
    public static String KEY = "";//全局搜索的关键

    public static List<AppInfo> getAppList(Context context) {

        List<AppInfo> list = new ArrayList<AppInfo>();// 声明并实例化1个集合
        PackageManager pm = context.getPackageManager();//获取包管理者
        List<PackageInfo> pList = pm.getInstalledPackages(0);// 获取所有的应用程序集合
        // 循环遍历
        for (int i = 0; i < pList.size(); i++) {
            PackageInfo packageInfo = pList.get(i);// 获取每一个应用的信息

            if (isThirdPartyApp(packageInfo.applicationInfo)
                    // 不能包含本应用(不删除自己)
                    && !packageInfo.packageName.equals(context.getPackageName())) {

                // 从右边装到左边
                AppInfo appInfo = new AppInfo();
                appInfo.mPackageName = packageInfo.packageName;
                appInfo.mVersionName = packageInfo.versionName;
                appInfo.mVersionCode = packageInfo.versionCode;
                appInfo.mFirstInstallTime = packageInfo.firstInstallTime;
                appInfo.mLastUpdateTime = packageInfo.lastUpdateTime;
                // 程序名称
                appInfo.mAppName = ((String) packageInfo.applicationInfo.loadLabel(pm)).trim();
                // 过渡
                appInfo.mApplicationInfo = packageInfo.applicationInfo;
                // 这行代码在运行时解除注释
                //appInfo.mIcon = packageInfo.mApplicationInfo.loadIcon(pm);
                // 计算应用的空间
                //publicSourceDir 是app的安装路径（文件夹）
                String dir = packageInfo.applicationInfo.publicSourceDir;
                appInfo.mPath = dir;
                long byteSize = new File(dir).length();
                appInfo.mByteSize = byteSize;// 1024*1024 Byte字节
                appInfo.mSize = getSize(byteSize);// 1MB

                list.add(appInfo);// 添加到集合
            }// if

        }

        return list;
    }

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
     * @param appInfo
     * @return
     */
    public static boolean isThirdPartyApp(ApplicationInfo appInfo) {
        boolean flag = false;
        if ((appInfo.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) {
            // 可更新的系统应用
            flag = true;
        } else if ((appInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
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

    public static List<AppInfo> getSearchResult(List<AppInfo> list, String keyword) {
        //返回实体集合
        List<AppInfo> searchResultList = new ArrayList<AppInfo>();
        //循环遍历
        for (int i = 0; i < list.size(); i++) {
            AppInfo app = list.get(i);//拿到单个的实体类
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
                android.os.Process.myPid(),
                Process.myUid()) == PackageManager.PERMISSION_GRANTED;
    }

    public static String encryptPassword(String clearText) {
        try {
            DESKeySpec keySpec = new DESKeySpec(PASSWORD_ENC_SECRET.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            String encrypedPwd = Base64.encodeToString(cipher.doFinal(clearText.getBytes("UTF-8")), Base64.DEFAULT);
            return encrypedPwd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clearText;
    }

    /**
     * 解密
     **/
    public static String decryptPassword(String encryptedPwd) {
        try {
            DESKeySpec keySpec = new DESKeySpec(PASSWORD_ENC_SECRET.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);
            byte[] encryptedWithoutB64 = Base64.decode(encryptedPwd, Base64.DEFAULT);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainTextPwdBytes = cipher.doFinal(encryptedWithoutB64);
            return new String(plainTextPwdBytes);
        } catch (Exception e) {
        }
        return encryptedPwd;
    }
}
