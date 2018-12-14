package com.salton123.unstaller.entity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;

import com.salton123.unstaller.util.Utils;


/**
 * 实体类
 * 应用程序
 */
public class AppInfo extends PackageInfo {

    public String mAppName; // 应用名
    public Drawable mIcon = null;// 图标
    public String mSize;// 大小: MB

    public String mPackageName;// 包名
    public String mVersionName;// 版本名
    public int mVersionCode;// 版本号
    public long mFirstInstallTime;// 第一次安装
    public long mLastUpdateTime;// 最近一次安装
    public long mByteSize;// 大小:字节(单位)
    public boolean isChecked = false;
    public ApplicationInfo mApplicationInfo;
    public String mPath;

    @Override
    public String toString() {
        return ", mAppName='" + mAppName + "\n" +
                "mPackageName='" + mPackageName + "\n" +
                ", mVersionName='" + mVersionName + "\n" +
                ", mVersionCode=" + mVersionCode + "\n" +
                ", mFirstInstallTime=" + Utils.getTime(mFirstInstallTime) + "\n" +
                ", mLastUpdateTime=" + Utils.getTime(mLastUpdateTime) + "\n" +

                ", mIcon=" + mIcon + "\n" +
                ", mByteSize=" + mByteSize + "\n" +
                ", mSize='" + mSize + "\n" +

                "}-------------------------------------------\n";
    }

}
