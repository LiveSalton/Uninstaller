package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.zzp;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbs {
    private long a;

    @GuardedBy("lock")
    private long b = Long.MIN_VALUE;
    private final Object c = new Object();

    public zzbs(long j) {
        this.a = j;
    }

    public final boolean a() {
        synchronized (this.c) {
            long b = zzp.j().b();
            if (this.b + this.a > b) {
                return false;
            }
            this.b = b;
            return true;
        }
    }

    public final void a(long j) {
        synchronized (this.c) {
            this.a = j;
        }
    }
}
