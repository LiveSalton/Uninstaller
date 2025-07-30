package com.salton123.uninstaller;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.salton123.uninstaller.entity.AppEntity;
import com.salton123.uninstaller.util.Utils;

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
    private List<AppEntity> mInstallPackagesInfos = new ArrayList<>();

    public List<AppEntity> preloadAppList() {
        Log.i("PreloadCore", "start preloadAppList time=" + System.currentTimeMillis());
        FutureTask task = new FutureTask<>(new Callable<List<AppEntity>>() {
            @Override
            public List<AppEntity> call() throws Exception {
                Log.i("PreloadCore", "start call time one=" + System.currentTimeMillis());
                PackageManager pm = XApp.getInstance().getPackageManager();//获取包管理者
                List<AppEntity> pList = new ArrayList<>();// 获取所有的应用程序集合
                
                try {
                    List<PackageInfo> installedPackages;
                    // Use PackageManager.MATCH_ALL flag for Android 15+
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                        installedPackages = pm.getInstalledPackages(PackageManager.GET_META_DATA | PackageManager.MATCH_ALL);
                    } else {
                        installedPackages = pm.getInstalledPackages(0);
                    }
                    Log.i("PreloadCore", "获取到的安装包数量: " + installedPackages.size());
                    
                    for (PackageInfo item : installedPackages) {
                        try {
                            AppEntity entity = new AppEntity(item);
                            if (Utils.isThirdPartyApp(item.applicationInfo)) {
                                if (!item.applicationInfo.packageName.equals(XApp.getInstance().getPackageName())) {
                                    pList.add(entity);
                                }
                            }
                        } catch (Exception e) {
                            Log.e("PreloadCore", "处理单个应用时出错: " + item.packageName, e);
                        }
                    }
                } catch (Exception e) {
                    Log.e("PreloadCore", "获取安装包列表时出错", e);
                }
                
                Log.i("PreloadCore", "筛选后的第三方应用数量: " + pList.size());
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
            mInstallPackagesInfos = (List<AppEntity>) task.get();
            Log.i("PreloadCore", "start get time=" + System.currentTimeMillis());
            return mInstallPackagesInfos;
        } catch (Exception e) {
            Log.e("PreloadCore", "preloadAppList执行出错", e);
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<AppEntity> getInstalledPackages() {
        return mInstallPackagesInfos;
    }
}