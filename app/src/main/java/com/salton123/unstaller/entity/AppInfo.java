package com.salton123.unstaller.entity;

import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;

import com.salton123.unstaller.util.Utils;


/**
 * 实体类
 * 应用程序
 */
public class AppInfo {

    public String packageName;// 包名
    public String versionName;// 版本名
    public int versionCode;// 版本号
    public long firstInstallTime;// 第一次安装
    public long lastUpdateTime;// 最近一次安装
    public String appName; // 应用名
    public Drawable icon = null;// 图标
    public long byteSize;// 大小:字节(单位)
    public String size;// 大小: MB
    public boolean isChecked = false;
    public ApplicationInfo applicationInfo;
    public String path;

    @Override
    public String toString() {
        return ", appName='" + appName + "\n" +
                "packageName='" + packageName + "\n" +
                ", versionName='" + versionName + "\n" +
                ", versionCode=" + versionCode + "\n" +
                ", firstInstallTime=" + Utils.getTime(firstInstallTime) + "\n" +
                ", lastUpdateTime=" + Utils.getTime(lastUpdateTime) + "\n" +

                ", icon=" + icon + "\n" +
                ", byteSize=" + byteSize + "\n" +
                ", size='" + size + "\n" +

                "}-------------------------------------------\n";
    }

}
