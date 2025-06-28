package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public final class DeviceProperties {
    private static Boolean a;
    private static Boolean b;
    private static Boolean c;
    private static Boolean d;

    private DeviceProperties() {
    }

    @KeepForSdk
    @TargetApi(20)
    public static boolean a(Context context) {
        return a(context.getPackageManager());
    }

    @KeepForSdk
    @TargetApi(20)
    public static boolean a(PackageManager packageManager) {
        if (a == null) {
            a = Boolean.valueOf(PlatformVersion.f() && packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return a.booleanValue();
    }

    @KeepForSdk
    @TargetApi(26)
    public static boolean b(Context context) {
        if (!a(context)) {
            return false;
        }
        if (PlatformVersion.i()) {
            return f(context) && !PlatformVersion.j();
        }
        return true;
    }

    @KeepForSdk
    @TargetApi(21)
    public static boolean c(Context context) {
        return f(context);
    }

    @TargetApi(21)
    private static boolean f(Context context) {
        if (b == null) {
            b = Boolean.valueOf(PlatformVersion.g() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return b.booleanValue();
    }

    @KeepForSdk
    public static boolean d(Context context) {
        if (c == null) {
            PackageManager packageManager = context.getPackageManager();
            c = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services"));
        }
        return c.booleanValue();
    }

    public static boolean e(Context context) {
        if (d == null) {
            d = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return d.booleanValue();
    }
}
