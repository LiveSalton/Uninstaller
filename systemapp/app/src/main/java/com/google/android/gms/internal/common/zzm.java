package com.google.android.gms.internal.common;

import android.os.Build;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzm {
    private static volatile boolean a = !a();
    private static boolean b = false;

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
