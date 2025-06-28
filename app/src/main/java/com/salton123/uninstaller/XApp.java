package com.salton123.uninstaller;

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
        super.onCreate();
        XLog.e(this, "time app init =" + System.currentTimeMillis());
        mInstance = this;
        
        // 预加载应用列表
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    PreloadCore.INSTANCE.preloadAppList();
                    XLog.i(XApp.this, "App list preload completed");
                } catch (Exception e) {
                    XLog.e(XApp.this, "App list preload failed: " + e.getMessage());
                }
            }
        }).start();
    }
}
