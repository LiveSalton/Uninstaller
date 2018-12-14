package com.salton123.unstaller;

import android.app.Application;
import android.os.Environment;
import android.util.Log;

import com.salton123.unstaller.util.Utils;

import java.io.File;

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
        Log.e("calc","time app init ="+ System.currentTimeMillis());
        super.onCreate();
        mInstance = this;
        PreloadCore.INSTANCE.getInstalledPackages();
    }
}
