package com.salton123.unstaller;

import android.app.Application;
import android.os.Environment;

import com.salton123.log.XLogConfig;
import com.salton123.unstaller.util.Utils;

import java.io.File;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/9 6:52 PM
 * ModifyTime: 6:52 PM
 * Description:
 */
public class XApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        String path = new File(Environment.getExternalStorageDirectory(), "salton").getPath();
        path = path + File.separator + getPackageName();
        XLogConfig.init(new XLogConfig.Builder()
                .whetherToSaveLog(Utils.canWriteStorage(this))
                .setSavePath(path)
                .build());
    }


}
