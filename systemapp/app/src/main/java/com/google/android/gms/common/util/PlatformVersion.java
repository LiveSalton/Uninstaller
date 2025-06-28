package com.google.android.gms.common.util;

import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: source */
@VisibleForTesting
@KeepForSdk
/* loaded from: classes.dex */
public final class PlatformVersion {
    private static Boolean a;

    private PlatformVersion() {
    }

    @KeepForSdk
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 15;
    }

    @KeepForSdk
    public static boolean b() {
        return Build.VERSION.SDK_INT >= 16;
    }

    @KeepForSdk
    public static boolean c() {
        return Build.VERSION.SDK_INT >= 17;
    }

    @KeepForSdk
    public static boolean d() {
        return Build.VERSION.SDK_INT >= 18;
    }

    @KeepForSdk
    public static boolean e() {
        return Build.VERSION.SDK_INT >= 19;
    }

    @KeepForSdk
    public static boolean f() {
        return Build.VERSION.SDK_INT >= 20;
    }

    @KeepForSdk
    public static boolean g() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @KeepForSdk
    public static boolean h() {
        return Build.VERSION.SDK_INT >= 23;
    }

    @KeepForSdk
    public static boolean i() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @KeepForSdk
    public static boolean j() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @KeepForSdk
    public static boolean k() {
        return Build.VERSION.SDK_INT >= 28;
    }

    @KeepForSdk
    public static boolean l() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @KeepForSdk
    public static boolean m() {
        boolean z = false;
        if (!l()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 30 && Build.VERSION.CODENAME.equals("REL")) {
            return true;
        }
        if (!(Build.VERSION.CODENAME.length() == 1 && Build.VERSION.CODENAME.charAt(0) >= 'R' && Build.VERSION.CODENAME.charAt(0) <= 'Z')) {
            return false;
        }
        if (a != null) {
            return a.booleanValue();
        }
        try {
            if ("google".equals(Build.BRAND) && !Build.ID.startsWith("RPP1") && !Build.ID.startsWith("RPP2") && Integer.parseInt(Build.VERSION.INCREMENTAL) >= 6301457) {
                z = true;
            }
            a = Boolean.valueOf(z);
        } catch (NumberFormatException unused) {
            a = true;
        }
        if (!a.booleanValue()) {
            Log.w("PlatformVersion", "Build version must be at least 6301457 to support R in gmscore");
        }
        return a.booleanValue();
    }
}
