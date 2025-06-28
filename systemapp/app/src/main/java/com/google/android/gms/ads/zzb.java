package com.google.android.gms.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: source */
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzb {
    public static AdSize a(int i, int i2, String str) {
        return new AdSize(i, i2, str);
    }

    public static AdSize a(int i, int i2) {
        AdSize adSize = new AdSize(i, i2);
        adSize.a(true);
        adSize.a(i2);
        return adSize;
    }

    public static boolean a(AdSize adSize) {
        return adSize.d();
    }

    public static boolean b(AdSize adSize) {
        return adSize.e();
    }

    public static int c(AdSize adSize) {
        return adSize.f();
    }
}
