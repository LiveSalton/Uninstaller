package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzao extends Exception {
    private final zzy a;
    private long b;

    public zzao() {
        this.a = null;
    }

    public zzao(zzy zzyVar) {
        this.a = zzyVar;
    }

    public zzao(String str) {
        super(str);
        this.a = null;
    }

    public zzao(Throwable th) {
        super(th);
        this.a = null;
    }

    final void a(long j) {
        this.b = j;
    }
}
