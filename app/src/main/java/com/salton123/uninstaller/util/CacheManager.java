package com.salton123.uninstaller.util;

import android.content.Context;
import android.os.Environment;

import com.salton123.log.XLog;

import java.io.File;
import java.math.BigDecimal;

/**
 * 缓存管理工具类，用于清除缓存和计算缓存大小
 */
public class CacheManager {

    private static final String TAG = "CacheManager";

    /**
     * 获取缓存大小
     * @param context 上下文
     * @return 格式化后的缓存大小字符串，如"2.5MB"
     */
    public static String getTotalCacheSize(Context context) {
        try {
            long cacheSize = getFolderSize(context.getCacheDir());
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    cacheSize += getFolderSize(externalCacheDir);
                }
                
                // 添加备份文件夹大小
                File backupDir = getBackupDir(context);
                if (backupDir != null && backupDir.exists()) {
                    cacheSize += getFolderSize(backupDir);
                }
            }
            return formatFileSize(cacheSize);
        } catch (Exception e) {
            XLog.e(TAG, "Failed to get cache size");
            return "0KB";
        }
    }

    /**
     * 清除所有缓存
     * @param context 上下文
     * @return 是否清除成功
     */
    public static boolean clearAllCache(Context context) {
        try {
            deleteDir(context.getCacheDir());
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    deleteDir(externalCacheDir);
                }
                
                // 清除备份文件夹
                File backupDir = getBackupDir(context);
                if (backupDir != null && backupDir.exists()) {
                    deleteDir(backupDir);
                }
            }
            return true;
        } catch (Exception e) {
            XLog.e(TAG, "Failed to clear cache");
            return false;
        }
    }

    /**
     * 删除文件夹
     * @param dir 文件夹
     * @return 是否删除成功
     */
    private static boolean deleteDir(File dir) {
        if (dir == null || !dir.exists()) {
            return false;
        }
        if (dir.isDirectory()) {
            File[] children = dir.listFiles();
            if (children != null) {
                for (File child : children) {
                    boolean success = deleteDir(child);
                    if (!success) {
                        return false;
                    }
                }
            }
        }
        // 目录下的内容都删除后，删除目录本身
        return dir.delete();
    }

    /**
     * 获取文件夹大小
     * @param file 文件或文件夹
     * @return 文件或文件夹的大小，单位为字节
     * @throws Exception 可能发生的异常
     */
    private static long getFolderSize(File file) throws Exception {
        long size = 0;
        if (file == null || !file.exists()) {
            return size;
        }
        
        if (file.isDirectory()) {
            File[] fileList = file.listFiles();
            if (fileList != null) {
                for (File f : fileList) {
                    size += getFolderSize(f);
                }
            }
        } else {
            size = file.length();
        }
        return size;
    }

    /**
     * 格式化文件大小
     * @param size 文件大小，单位为字节
     * @return 格式化后的文件大小字符串
     */
    private static String formatFileSize(long size) {
        BigDecimal fileSize = new BigDecimal(size);
        BigDecimal kbDivisor = new BigDecimal(1024);
        BigDecimal mbDivisor = new BigDecimal(1048576); // 1024 * 1024
        BigDecimal gbDivisor = new BigDecimal(1073741824); // 1024 * 1024 * 1024
        
        if (size == 0) {
            return "0KB";
        }
        
        if (size < kbDivisor.longValue()) {
            // 如果小于1KB，返回大小为B
            return fileSize + "B";
        } else if (size < mbDivisor.longValue()) {
            // 如果小于1MB，返回大小为KB
            return fileSize.divide(kbDivisor, 2, BigDecimal.ROUND_HALF_UP) + "KB";
        } else if (size < gbDivisor.longValue()) {
            // 如果小于1GB，返回大小为MB
            return fileSize.divide(mbDivisor, 2, BigDecimal.ROUND_HALF_UP) + "MB";
        } else {
            // 如果大于等于1GB，返回大小为GB
            return fileSize.divide(gbDivisor, 2, BigDecimal.ROUND_HALF_UP) + "GB";
        }
    }
    
    /**
     * 获取备份目录
     * @param context 上下文
     * @return 备份目录文件对象
     */
    private static File getBackupDir(Context context) {
        String backupPath = BackupManager.getBackupPath(context);
        if (backupPath != null) {
            return new File(backupPath);
        }
        return null;
    }
}