package com.salton123.unstaller;

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

    public List<AppEntity> getInstalledPackages() {
        if (mPackageInfos == null) {
            return preloadAppList();
        }
        return mPackageInfos;
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
                    pList.add(new AppEntity(item));
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

    static int backupCount;

    public void wrapApplist(final IWrapProgress iWrapProgress) {
        if (mPackageInfos == null) {
            XLog.i("PreloadCore", "isValidData == false");
            getInstalledPackages();
        } else {
            backupCount = 0;
            final PackageManager packageManager = XApp.getInstance().getPackageManager();//获取包管理者
            for (int i = 0; i < mPackageInfos.size(); i++) {
                final AppEntity entity = mPackageInfos.get(i);
                PreloadCore.INSTANCE.mThreadPool.submit(new Callable<Boolean>() {
                    @Override
                    public Boolean call() {
                        try {
                            String dir = entity.appInfo.applicationInfo.publicSourceDir;
                            long byteSize = new File(dir).length();

                            String sizeStr = Utils.getSize(byteSize) + "M  " + Utils.getTime(entity.appInfo.lastUpdateTime);
                            Drawable drawable = entity.appInfo.applicationInfo.loadIcon(packageManager);
                            entity.mIcon = drawable;
                            entity.mSize = sizeStr;
                            entity.mAppName = ((String) entity.appInfo.applicationInfo.loadLabel(packageManager)).trim();
                            XLog.i("PreloadCore", "sizeStr =" + sizeStr);
                            return drawable != null;
                        } catch (Exception e) {
                            XLog.e(this, e.getMessage());
                        } finally {
                            backupCount++;
                            if (iWrapProgress != null) {
                                iWrapProgress.onProgress(backupCount, mPackageInfos.size());
                            }
                        }
                        return false;
                    }
                });
            }
        }
    }

    public interface IWrapProgress {
        void onProgress(int current, int total);
    }

}
