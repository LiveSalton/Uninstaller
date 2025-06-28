package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdzb {
    public static Executor a() {
        return anf.INSTANCE;
    }

    public static zzdzc a(ExecutorService executorService) {
        return executorService instanceof zzdzc ? (zzdzc) executorService : executorService instanceof ScheduledExecutorService ? new anv((ScheduledExecutorService) executorService) : new ans(executorService);
    }

    static Executor a(Executor executor, zzdxo<?> zzdxoVar) {
        zzdvv.a(executor);
        zzdvv.a(zzdxoVar);
        return executor == anf.INSTANCE ? executor : new ant(executor, zzdxoVar);
    }
}
