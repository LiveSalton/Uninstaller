package com.salton123.unstaller;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.salton123.log.XLog;
import com.salton123.unstaller.entity.AppEntity;
import com.salton123.unstaller.util.BackupManager;
import com.salton123.unstaller.util.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/14 9:52 AM
 * ModifyTime: 9:52 AM
 * Description: 30-40ms
 */
public enum PreloadCore {
    INSTANCE;
    public ExecutorService mThreadPool = Executors.newFixedThreadPool(8);

    private List<AppEntity> mPackageInfos;

    private List<AppEntity> mInstallPackagesInfos = new ArrayList<>();

    private List<AppEntity> mSystemPackagesInfos = new ArrayList<>();

    public List<AppEntity> getAllPackages() {
        if (mPackageInfos == null) {
            return preloadAppList();
        }
        return mPackageInfos;
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

    public List<AppEntity> preloadAppList() {
        Log.i("PreloadCore", "start preloadAppList time=" + System.currentTimeMillis());
        FutureTask task = new FutureTask<>(new Callable<List<AppEntity>>() {
            @Override
            public List<AppEntity> call() throws Exception {
                Log.i("PreloadCore", "start call time one=" + System.currentTimeMillis());
                PackageManager pm = XApp.getInstance().getPackageManager();//获取包管理者
                List<AppEntity> pList = new ArrayList<>();// 获取所有的应用程序集合
                for (PackageInfo item : pm.getInstalledPackages(0)) {
                    AppEntity entity = new AppEntity(item);
                    pList.add(entity);
                    if (isThirdPartyApp(item.applicationInfo)) {
                        mInstallPackagesInfos.add(entity);
                    } else {
                        mSystemPackagesInfos.add(entity);
                    }
                }
                Log.i("PreloadCore", "start call time=" + System.currentTimeMillis());
                return pList;
            }
        });
        //不采用线程池是因为要提高执行优先级和速度
        // mThreadPool.submit(task);
        Thread thread = new Thread(task);
        thread.setPriority(10);
        thread.start();
        try {
            mPackageInfos = (List<AppEntity>) task.get();
            Log.i("PreloadCore", "start get time=" + System.currentTimeMillis());
            return mPackageInfos;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<AppEntity> getInstalledPackages() {
        return mInstallPackagesInfos;
    }

    public List<AppEntity> getSystemPackages() {
        return mInstallPackagesInfos;
    }
}
