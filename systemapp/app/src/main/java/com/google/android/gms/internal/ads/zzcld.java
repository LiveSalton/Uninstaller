package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcld {
    public static Set<zzbxy<zzbsp>> a(zzcln zzclnVar, Executor executor) {
        return a(zzclnVar, executor);
    }

    public static Set<zzbxy<AppEventListener>> b(zzcln zzclnVar, Executor executor) {
        return a(zzclnVar, executor);
    }

    public static Set<zzbxy<zzbtj>> c(zzcln zzclnVar, Executor executor) {
        return a(zzclnVar, executor);
    }

    public static Set<zzbxy<zzbrz>> d(zzcln zzclnVar, Executor executor) {
        return a(zzclnVar, executor);
    }

    public static Set<zzbxy<zzbru>> e(zzcln zzclnVar, Executor executor) {
        return a(zzclnVar, executor);
    }

    public static Set<zzbxy<zzbsm>> f(zzcln zzclnVar, Executor executor) {
        return a(zzclnVar, executor);
    }

    public static Set<zzbxy<zzva>> g(zzcln zzclnVar, Executor executor) {
        return a(zzclnVar, executor);
    }

    public static Set<zzbxy<zzdru>> h(zzcln zzclnVar, Executor executor) {
        return a(zzclnVar, executor);
    }

    public static Set<zzbxy<zzbui>> i(zzcln zzclnVar, Executor executor) {
        return a(zzclnVar, executor);
    }

    private static <T> Set<zzbxy<T>> a(T t, Executor executor) {
        if (zzada.a.a().booleanValue()) {
            return Collections.singleton(new zzbxy(t, executor));
        }
        return Collections.emptySet();
    }
}
