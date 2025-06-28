package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
final class anv extends ans implements zzdzc, ScheduledExecutorService {
    private final ScheduledExecutorService a;

    anv(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.a = (ScheduledExecutorService) zzdvv.a(scheduledExecutorService);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        anw anwVar = new anw(runnable);
        return new anu(anwVar, this.a.scheduleWithFixedDelay(anwVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        anw anwVar = new anw(runnable);
        return new anu(anwVar, this.a.scheduleAtFixedRate(anwVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        aoc a = aoc.a(callable);
        return new anu(a, this.a.schedule(a, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        aoc a = aoc.a(runnable, (Object) null);
        return new anu(a, this.a.schedule(a, j, timeUnit));
    }
}
