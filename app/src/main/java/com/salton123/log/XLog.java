package com.salton123.log;

import android.util.Log;

/**
 * 简单的日志工具类
 */
public class XLog {
    private static final String TAG = "XLog";
    private static boolean DEBUG = true;

    public static void e(Object obj, String msg) {
        if (DEBUG) {
            Log.e(TAG, obj.getClass().getSimpleName() + ": " + msg);
        }
    }

    public static void d(Object obj, String msg) {
        if (DEBUG) {
            Log.d(TAG, obj.getClass().getSimpleName() + ": " + msg);
        }
    }

    public static void i(Object obj, String msg) {
        if (DEBUG) {
            Log.i(TAG, obj.getClass().getSimpleName() + ": " + msg);
        }
    }

    public static void w(Object obj, String msg) {
        if (DEBUG) {
            Log.w(TAG, obj.getClass().getSimpleName() + ": " + msg);
        }
    }
}
