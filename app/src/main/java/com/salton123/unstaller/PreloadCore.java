package com.salton123.unstaller;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/14 9:52 AM
 * ModifyTime: 9:52 AM
 * Description: 30-40ms
 */
public enum PreloadCore {
    INSTANCE;
    private List<PackageInfo> mPackageInfos;

    public List<PackageInfo> getInstalledPackages() {
        if (mPackageInfos == null) {
            return preloadAppList();
        }
        return mPackageInfos;
    }

    public List<PackageInfo> preloadAppList() {
        Log.i("PreloadCore","start preloadAppList time="+System.currentTimeMillis());
        FutureTask task = new FutureTask<>(new Callable<List<PackageInfo>>() {
            @Override
            public List<PackageInfo> call() throws Exception {
                Log.i("PreloadCore","start call time one="+System.currentTimeMillis());
                PackageManager pm = XApp.getInstance().getPackageManager();//获取包管理者
                List<PackageInfo> pList = pm.getInstalledPackages(0);// 获取所有的应用程序集合
                Log.i("PreloadCore","start call time="+System.currentTimeMillis());
                return pList;
            }
        });
        Thread thread = new Thread(task);
        thread.setPriority(10);
        thread.start();
        try {
            mPackageInfos = (List<PackageInfo>) task.get();
            Log.i("PreloadCore","start get time="+System.currentTimeMillis());
            return mPackageInfos;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
