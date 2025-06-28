package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzdyi<V> extends anm<V> {
    zzdyi() {
    }

    public static <V> zzdyi<V> c(zzdyz<V> zzdyzVar) {
        return zzdyzVar instanceof zzdyi ? (zzdyi) zzdyzVar : new anh(zzdyzVar);
    }

    public final <X extends Throwable> zzdyi<V> a(Class<X> cls, zzdvm<? super X, ? extends V> zzdvmVar, Executor executor) {
        amr amrVar = new amr(this, cls, zzdvmVar);
        a((Runnable) amrVar, zzdzb.a(executor, amrVar));
        return amrVar;
    }

    public final <X extends Throwable> zzdyi<V> a(Class<X> cls, zzdyb<? super X, ? extends V> zzdybVar, Executor executor) {
        amp ampVar = new amp(this, cls, zzdybVar);
        a((Runnable) ampVar, zzdzb.a(executor, ampVar));
        return ampVar;
    }

    public final zzdyi<V> a(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (zzdyi) zzdyr.a(this, j, timeUnit, scheduledExecutorService);
    }

    public final <T> zzdyi<T> a(zzdyb<? super V, T> zzdybVar, Executor executor) {
        zzdvv.a(executor);
        amu amuVar = new amu(this, zzdybVar);
        a((Runnable) amuVar, zzdzb.a(executor, amuVar));
        return amuVar;
    }

    public final <T> zzdyi<T> a(zzdvm<? super V, T> zzdvmVar, Executor executor) {
        zzdvv.a(zzdvmVar);
        amt amtVar = new amt(this, zzdvmVar);
        a((Runnable) amtVar, zzdzb.a(executor, amtVar));
        return amtVar;
    }
}
