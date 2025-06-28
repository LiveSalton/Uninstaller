package com.salton123.uninstaller.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import com.salton123.log.XLog;
import com.salton123.uninstaller.entity.AppEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 应用管理工具类
 * 提供获取已安装应用、系统应用等功能
 */
public class AppManager {
    private static final String TAG = "AppManager";

    /**
     * 获取所有已安装的第三方应用
     */
    public static List<AppEntity> getInstalledApps(Context context) {
        List<AppEntity> appList = new ArrayList<>();
        PackageManager pm = context.getPackageManager();
        
        try {
            List<PackageInfo> packages = pm.getInstalledPackages(0);
            for (PackageInfo packageInfo : packages) {
                // 只获取第三方应用
                if (Utils.isThirdPartyApp(packageInfo.applicationInfo)) {
                    // 排除自己
                    if (!packageInfo.packageName.equals(context.getPackageName())) {
                        AppEntity entity = createAppEntity(packageInfo, pm);
                        if (entity != null) {
                            appList.add(entity);
                        }
                    }
                }
            }
        } catch (Exception e) {
            XLog.e(TAG, "Error getting installed apps: " + e.getMessage());
        }
        
        return appList;
    }

    /**
     * 获取所有系统应用
     */
    public static List<AppEntity> getSystemApps(Context context) {
        List<AppEntity> appList = new ArrayList<>();
        PackageManager pm = context.getPackageManager();
        
        try {
            List<PackageInfo> packages = pm.getInstalledPackages(0);
            for (PackageInfo packageInfo : packages) {
                // 只获取系统应用
                if (!Utils.isThirdPartyApp(packageInfo.applicationInfo)) {
                    AppEntity entity = createAppEntity(packageInfo, pm);
                    if (entity != null) {
                        appList.add(entity);
                    }
                }
            }
        } catch (Exception e) {
            XLog.e(TAG, "Error getting system apps: " + e.getMessage());
        }
        
        return appList;
    }

    /**
     * 创建应用实体对象
     */
    private static AppEntity createAppEntity(PackageInfo packageInfo, PackageManager pm) {
        try {
            AppEntity entity = new AppEntity(packageInfo);
            
            // 获取应用图标
            Drawable icon = packageInfo.applicationInfo.loadIcon(pm);
            entity.mIcon = icon;
            
            // 获取应用名称
            String appName = packageInfo.applicationInfo.loadLabel(pm).toString().trim();
            entity.mAppName = appName;
            
            // 获取应用大小
            String sourceDir = packageInfo.applicationInfo.publicSourceDir;
            if (sourceDir != null) {
                File apkFile = new File(sourceDir);
                long size = apkFile.length();
                entity.mSize = Utils.getSize(size);
                entity.mPath = sourceDir;
            }
            
            return entity;
        } catch (Exception e) {
            XLog.e(TAG, "Error creating app entity for " + packageInfo.packageName + ": " + e.getMessage());
            return null;
        }
    }

    /**
     * 检查应用是否已安装
     */
    public static boolean isAppInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /**
     * 获取应用信息
     */
    public static PackageInfo getAppInfo(Context context, String packageName) {
        try {
            return context.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            XLog.e(TAG, "App not found: " + packageName);
            return null;
        }
    }
} 