package com.salton123.uninstaller.entity;

import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/14 6:00 PM
 * ModifyTime: 6:00 PM
 * Description:
 */
public class AppEntity {
    public String mAppName = ""; // 应用名
    public Drawable mIcon = null;// 图标
    public String mSize = "";// 大小: MB
    public String mVersionName = ""; // 版本名称
    public PackageInfo appInfo;
    public boolean isChecked = false;
    public String mPath = "";

    public AppEntity(PackageInfo appInfo) {
        this.appInfo = appInfo;
        if (appInfo != null && appInfo.versionName != null) {
            this.mVersionName = appInfo.versionName;
        }
    }
    
    /**
     * 获取应用大小（字节）
     */
    public long getSize() {
        if (appInfo != null && appInfo.applicationInfo != null) {
            try {
                File apkFile = new File(appInfo.applicationInfo.sourceDir);
                return apkFile.length();
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }
    
    /**
     * 获取格式化的大小字符串
     */
    public String getSizeString() {
        if (!mSize.isEmpty()) {
            return mSize;
        }
        
        long sizeInBytes = getSize();
        if (sizeInBytes == 0) {
            return "未知";
        }
        
        // 转换为合适的单位
        if (sizeInBytes < 1024) {
            return sizeInBytes + " B";
        } else if (sizeInBytes < 1024 * 1024) {
            return String.format(Locale.getDefault(), "%.1f KB", sizeInBytes / 1024.0);
        } else if (sizeInBytes < 1024 * 1024 * 1024) {
            return String.format(Locale.getDefault(), "%.1f MB", sizeInBytes / (1024.0 * 1024.0));
        } else {
            return String.format(Locale.getDefault(), "%.1f GB", sizeInBytes / (1024.0 * 1024.0 * 1024.0));
        }
    }
    
    /**
     * 获取应用安装时间
     */
    public long getInstallTime() {
        if (appInfo != null) {
            return appInfo.firstInstallTime;
        }
        return 0;
    }
    
    /**
     * 获取格式化的安装时间字符串
     */
    public String getInstallTimeString() {
        long installTime = getInstallTime();
        if (installTime == 0) {
            return "未知";
        }
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        return formatter.format(new Date(installTime));
    }
}
