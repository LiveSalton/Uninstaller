package com.salton123.uninstaller.entity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/14 6:00 PM
 * ModifyTime: 6:00 PM
 * Description:
 */
public class AppEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public String mAppName = ""; // 应用名
    public transient Drawable mIcon = null;// 图标 - 使用transient标记不序列化的字段
    public String mSize = "";// 大小: MB
    public String mVersionName = ""; // 版本名称
    public transient PackageInfo appInfo; // PackageInfo不可序列化，用transient标记
    public boolean isChecked = false;
    public String mPath = "";
    
    // 保存PackageInfo中需要的信息
    public String packageName;
    public long versionCode;
    public long firstInstallTime;
    public String sourceDir;

    public AppEntity(PackageInfo appInfo) {
        this.appInfo = appInfo;
        if (appInfo != null) {
            if (appInfo.versionName != null) {
                this.mVersionName = appInfo.versionName;
            }
            
            // 保存必要的信息用于序列化
            this.packageName = appInfo.packageName;
            this.versionCode = appInfo.getLongVersionCode();
            this.firstInstallTime = appInfo.firstInstallTime;
            
            if (appInfo.applicationInfo != null) {
                this.sourceDir = appInfo.applicationInfo.sourceDir;
            }
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
