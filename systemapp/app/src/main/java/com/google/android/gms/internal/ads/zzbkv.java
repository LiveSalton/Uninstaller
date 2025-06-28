package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbkv implements zzrl {
    private final ScheduledExecutorService a;
    private final Clock b;

    @GuardedBy("this")
    private ScheduledFuture<?> c;

    @GuardedBy("this")
    private long d = -1;

    @GuardedBy("this")
    private long e = -1;

    @GuardedBy("this")
    private Runnable f = null;

    @GuardedBy("this")
    private boolean g = false;

    public zzbkv(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.a = scheduledExecutorService;
        this.b = clock;
        zzp.f().a(this);
    }

    @Override // com.google.android.gms.internal.ads.zzrl
    public final void a(boolean z) {
        if (z) {
            b();
        } else {
            a();
        }
    }

    public final synchronized void a(int i, Runnable runnable) {
        this.f = runnable;
        long j = i;
        this.d = this.b.b() + j;
        this.c = this.a.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    @VisibleForTesting
    private final synchronized void a() {
        if (!this.g) {
            if (this.c != null && !this.c.isDone()) {
                this.c.cancel(true);
                this.e = this.d - this.b.b();
            } else {
                this.e = -1L;
            }
            this.g = true;
        }
    }

    @VisibleForTesting
    private final synchronized void b() {
        if (this.g) {
            if (this.e > 0 && this.c != null && this.c.isCancelled()) {
                this.c = this.a.schedule(this.f, this.e, TimeUnit.MILLISECONDS);
            }
            this.g = false;
        }
    }
}
