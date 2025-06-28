package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzhe extends Exception {
    private final int a;
    private final int b;

    public static zzhe a(Exception exc, int i) {
        return new zzhe(1, null, exc, i);
    }

    public static zzhe a(IOException iOException) {
        return new zzhe(0, null, iOException, -1);
    }

    static zzhe a(RuntimeException runtimeException) {
        return new zzhe(2, null, runtimeException, -1);
    }

    private zzhe(int i, String str, Throwable th, int i2) {
        super(null, th);
        this.a = i;
        this.b = i2;
    }
}
