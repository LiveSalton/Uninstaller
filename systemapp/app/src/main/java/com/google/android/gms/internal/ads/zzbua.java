package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbua extends zzbwk<zzbue> {
    private final ScheduledExecutorService a;
    private final Clock b;

    @GuardedBy("this")
    private long c;

    @GuardedBy("this")
    private long d;

    @GuardedBy("this")
    private boolean e;

    @GuardedBy("this")
    private ScheduledFuture<?> f;

    public zzbua(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.c = -1L;
        this.d = -1L;
        this.e = false;
        this.a = scheduledExecutorService;
        this.b = clock;
    }

    public final synchronized void a() {
        if (!this.e) {
            if (this.f != null && !this.f.isCancelled()) {
                this.f.cancel(true);
                this.d = this.c - this.b.b();
            } else {
                this.d = -1L;
            }
            this.e = true;
        }
    }

    public final synchronized void b() {
        if (this.e) {
            if (this.d > 0 && this.f.isCancelled()) {
                a(this.d);
            }
            this.e = false;
        }
    }

    public final synchronized void c() {
        this.e = false;
        a(0L);
    }

    public final synchronized void a(int i) {
        if (i <= 0) {
            return;
        }
        long millis = TimeUnit.SECONDS.toMillis(i);
        if (!this.e) {
            if (this.b.b() > this.c || this.c - this.b.b() > millis) {
                a(millis);
            }
        } else {
            if (this.d <= 0 || millis >= this.d) {
                millis = this.d;
            }
            this.d = millis;
        }
    }

    private final synchronized void a(long j) {
        if (this.f != null && !this.f.isDone()) {
            this.f.cancel(true);
        }
        this.c = this.b.b() + j;
        this.f = this.a.schedule(new nu(this), j, TimeUnit.MILLISECONDS);
    }

    public final void d() {
        a(nt.a);
    }
}
