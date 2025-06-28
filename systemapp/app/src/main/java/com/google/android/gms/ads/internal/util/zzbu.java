package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.internal.ads.zzasn;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzdwf;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbu {
    @Deprecated
    public static <T> T a(Context context, Callable<T> callable) {
        try {
            return (T) a(callable);
        } catch (Throwable th) {
            zzaza.c("Unexpected exception.", th);
            zzasn.a(context).a(th, "StrictModeUtil.runWithLaxStrictMode");
            return null;
        }
    }

    public static <T> T a(zzdwf<T> zzdwfVar) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            return zzdwfVar.a();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    private static <T> T a(Callable<T> callable) throws Exception {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            return callable.call();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
