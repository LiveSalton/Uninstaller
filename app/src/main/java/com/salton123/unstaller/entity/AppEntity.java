package com.salton123.unstaller.entity;

import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/14 6:00 PM
 * ModifyTime: 6:00 PM
 * Description:
 */
public class AppEntity {
    public String mAppName; // 应用名
    public Drawable mIcon = null;// 图标
    public String mSize;// 大小: MB
    public PackageInfo appInfo;
    public boolean isChecked = false;

    public AppEntity(PackageInfo appInfo) {
        this.appInfo = appInfo;
    }
}
