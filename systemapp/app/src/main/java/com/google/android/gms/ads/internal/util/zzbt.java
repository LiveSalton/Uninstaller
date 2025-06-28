package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;

/* compiled from: source */
@TargetApi(17)
/* loaded from: classes.dex */
public final class zzbt {
    private static zzbt b;
    String a;

    public static zzbt a() {
        if (b == null) {
            b = new zzbt();
        }
        return b;
    }

    private zzbt() {
    }
}
