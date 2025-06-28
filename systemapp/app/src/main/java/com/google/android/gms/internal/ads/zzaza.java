package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzaza {
    public static void b(String str) {
        if (a(3)) {
            Log.d("Ads", str);
        }
    }

    public static void b(String str, Throwable th) {
        if (a(3)) {
            Log.d("Ads", str, th);
        }
    }

    public static void c(String str) {
        if (a(6)) {
            Log.e("Ads", str);
        }
    }

    public static void c(String str, Throwable th) {
        if (a(6)) {
            Log.e("Ads", str, th);
        }
    }

    public static void d(String str) {
        if (a(4)) {
            Log.i("Ads", str);
        }
    }

    public static void e(String str) {
        if (a(5)) {
            Log.w("Ads", str);
        }
    }

    public static void d(String str, Throwable th) {
        if (a(5)) {
            Log.w("Ads", str, th);
        }
    }

    @VisibleForTesting
    private static String a(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            return str;
        }
        int lineNumber = stackTrace[3].getLineNumber();
        StringBuilder sb = new StringBuilder(13 + String.valueOf(str).length());
        sb.append(str);
        sb.append(" @");
        sb.append(lineNumber);
        return sb.toString();
    }

    public static void e(String str, Throwable th) {
        if (a(5)) {
            if (th != null) {
                d(a(str), th);
            } else {
                e(a(str));
            }
        }
    }

    public static void f(String str) {
        e(str, null);
    }

    public static boolean a(int i) {
        return i >= 5 || Log.isLoggable("Ads", i);
    }
}
