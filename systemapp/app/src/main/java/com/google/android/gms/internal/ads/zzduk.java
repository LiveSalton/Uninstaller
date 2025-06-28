package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzduk extends Exception {
    private final int a;

    public zzduk(int i, String str) {
        super(str);
        this.a = i;
    }

    public zzduk(int i, Throwable th) {
        super(th);
        this.a = i;
    }

    public final int a() {
        return this.a;
    }
}
