package com.jumobile.manager.systemapp.util;

import android.util.Log;

/* compiled from: source */
/* loaded from: classes.dex */
public class SmartUtils {
    private static boolean a = false;

    public static native byte[] getBytes(byte[] bArr);

    public static native String getString(String str);

    public static boolean a() {
        if (!a) {
            try {
                System.loadLibrary("smartutils");
                a = true;
            } catch (UnsatisfiedLinkError e) {
                Log.w("SmartUtils", "load NativeUtils Library failed", e);
            }
        }
        return a;
    }
}
