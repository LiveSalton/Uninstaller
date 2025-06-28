package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
final class ff {
    private final Object a;
    private volatile int b;
    private volatile long c;

    private ff() {
        this.a = new Object();
        this.b = fe.a;
        this.c = 0L;
    }

    public final void a() {
        long a = zzp.j().a();
        synchronized (this.a) {
            if (this.b == fe.b) {
                if (this.c + ((Long) zzwq.e().a(zzabf.dg)).longValue() <= a) {
                    this.b = fe.a;
                }
            }
        }
        long a2 = zzp.j().a();
        synchronized (this.a) {
            if (this.b != 2) {
                return;
            }
            this.b = 3;
            if (this.b == fe.b) {
                this.c = a2;
            }
        }
    }

    /* synthetic */ ff(fc fcVar) {
        this();
    }
}
