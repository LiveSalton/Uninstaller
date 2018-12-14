package com.salton123.log;

import android.util.Log;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/14 3:31 PM
 * ModifyTime: 3:31 PM
 * Description:
 */
public class XLog {

    public static void e(Object object, String msg) {
        Log.e(objClassName(object), msg);
    }

    public static void i(Object object, String msg) {
        Log.i(objClassName(object), msg);
    }

    public static String objClassName(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        } else {
            return obj.getClass().getSimpleName();
        }
    }
}
