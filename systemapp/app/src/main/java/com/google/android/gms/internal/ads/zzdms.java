package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdms {
    private final Clock a;
    private final Object b = new Object();

    @GuardedBy("lock")
    private volatile int c = aii.a;
    private volatile long d = 0;

    public zzdms(Clock clock) {
        this.a = clock;
    }

    private final void a(int i, int i2) {
        d();
        long a = this.a.a();
        synchronized (this.b) {
            if (this.c != i) {
                return;
            }
            this.c = i2;
            if (this.c == aii.c) {
                this.d = a;
            }
        }
    }

    private final void d() {
        long a = this.a.a();
        synchronized (this.b) {
            if (this.c == aii.c) {
                if (this.d + ((Long) zzwq.e().a(zzabf.dg)).longValue() <= a) {
                    this.c = aii.a;
                }
            }
        }
    }

    public final void a(boolean z) {
        if (z) {
            a(aii.a, aii.b);
        } else {
            a(aii.b, aii.a);
        }
    }

    public final boolean a() {
        boolean z;
        synchronized (this.b) {
            d();
            z = this.c == aii.b;
        }
        return z;
    }

    public final boolean b() {
        boolean z;
        synchronized (this.b) {
            d();
            z = this.c == aii.c;
        }
        return z;
    }

    public final void c() {
        a(aii.b, aii.c);
    }
}
