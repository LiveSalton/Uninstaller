package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdys<V> {
    private final boolean a;
    private final zzdwm<zzdyz<? extends V>> b;

    private zzdys(boolean z, zzdwm<zzdyz<? extends V>> zzdwmVar) {
        this.a = z;
        this.b = zzdwmVar;
    }

    public final <C> zzdyz<C> a(Callable<C> callable, Executor executor) {
        return new ane(this.b, this.a, executor, callable);
    }

    /* synthetic */ zzdys(boolean z, zzdwm zzdwmVar, anj anjVar) {
        this(z, zzdwmVar);
    }
}
