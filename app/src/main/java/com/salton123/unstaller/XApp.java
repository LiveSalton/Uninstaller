package com.salton123.unstaller;

import android.app.Application;

import com.salton123.log.XLog;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/9 6:52 PM
 * ModifyTime: 6:52 PM
 * Description:
 */
public class XApp extends Application {
    private static Application mInstance;

    public static Application getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        XLog.e(this, "time app init =" + System.currentTimeMillis());
        super.onCreate();
        mInstance = this;
        PreloadCore.INSTANCE.getInstalledPackages();
    }
}
