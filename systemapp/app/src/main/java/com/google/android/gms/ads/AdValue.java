package com.google.android.gms.ads;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class AdValue {
    private final int a;
    private final String b;
    private final long c;

    /* compiled from: source */
    @Retention(RetentionPolicy.SOURCE)
    public @interface PrecisionType {
    }

    private AdValue(int i, String str, long j) {
        this.a = i;
        this.b = str;
        this.c = j;
    }

    public static AdValue a(int i, String str, long j) {
        return new AdValue(i, str, j);
    }
}
