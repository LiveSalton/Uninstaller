package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.ann;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdyr extends anl {
    public static <V> zzdyz<V> a(@NullableDecl V v) {
        return v == null ? (zzdyz<V>) ann.a : new ann(v);
    }

    public static <V> zzdyz<V> a(Throwable th) {
        zzdvv.a(th);
        return new ann.a(th);
    }

    public static <O> zzdyz<O> a(zzdxz<O> zzdxzVar, Executor executor) {
        aoc aocVar = new aoc(zzdxzVar);
        executor.execute(aocVar);
        return aocVar;
    }

    public static <V, X extends Throwable> zzdyz<V> a(zzdyz<? extends V> zzdyzVar, Class<X> cls, zzdyb<? super X, ? extends V> zzdybVar, Executor executor) {
        return amq.a(zzdyzVar, cls, zzdybVar, executor);
    }

    public static <V> zzdyz<V> a(zzdyz<V> zzdyzVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return zzdyzVar.isDone() ? zzdyzVar : any.a(zzdyzVar, j, timeUnit, scheduledExecutorService);
    }

    public static <I, O> zzdyz<O> a(zzdyz<I> zzdyzVar, zzdyb<? super I, ? extends O> zzdybVar, Executor executor) {
        return ams.a(zzdyzVar, zzdybVar, executor);
    }

    public static <I, O> zzdyz<O> a(zzdyz<I> zzdyzVar, zzdvm<? super I, ? extends O> zzdvmVar, Executor executor) {
        return ams.a(zzdyzVar, zzdvmVar, executor);
    }

    public static <V> zzdyz<List<V>> a(Iterable<? extends zzdyz<? extends V>> iterable) {
        return new anc(zzdwm.a((Iterable) iterable), true);
    }

    @SafeVarargs
    public static <V> zzdys<V> a(zzdyz<? extends V>... zzdyzVarArr) {
        return new zzdys<>(false, zzdwm.a((Object[]) zzdyzVarArr), null);
    }

    public static <V> zzdys<V> b(Iterable<? extends zzdyz<? extends V>> iterable) {
        return new zzdys<>(false, zzdwm.a((Iterable) iterable), null);
    }

    @SafeVarargs
    public static <V> zzdys<V> b(zzdyz<? extends V>... zzdyzVarArr) {
        return new zzdys<>(true, zzdwm.a((Object[]) zzdyzVarArr), null);
    }

    public static <V> zzdys<V> c(Iterable<? extends zzdyz<? extends V>> iterable) {
        return new zzdys<>(true, zzdwm.a((Iterable) iterable), null);
    }

    public static <V> void a(zzdyz<V> zzdyzVar, zzdyo<? super V> zzdyoVar, Executor executor) {
        zzdvv.a(zzdyoVar);
        zzdyzVar.a(new ank(zzdyzVar, zzdyoVar), executor);
    }

    public static <V> V a(Future<V> future) throws ExecutionException {
        if (!future.isDone()) {
            throw new IllegalStateException(zzdwc.a("Future was expected to be done: %s", future));
        }
        return (V) zzdzs.a(future);
    }

    public static <V> V b(Future<V> future) {
        zzdvv.a(future);
        try {
            return (V) zzdzs.a(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new zzdyj((Error) cause);
            }
            throw new zzdzp(cause);
        }
    }
}
