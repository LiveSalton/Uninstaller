package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzdra<E> {
    private static final zzdyz<?> a = zzdyr.a((Object) null);
    private final zzdzc b;
    private final ScheduledExecutorService c;
    private final zzdrm<E> d;

    public zzdra(zzdzc zzdzcVar, ScheduledExecutorService scheduledExecutorService, zzdrm<E> zzdrmVar) {
        this.b = zzdzcVar;
        this.c = scheduledExecutorService;
        this.d = zzdrmVar;
    }

    protected abstract String b(E e);

    public final zzdre a(E e) {
        return new zzdre(this, e);
    }

    public final <I> zzdrg<I> a(E e, zzdyz<I> zzdyzVar) {
        return new zzdrg<>(this, e, zzdyzVar, Collections.singletonList(zzdyzVar), zzdyzVar);
    }

    public final zzdrc a(E e, zzdyz<?>... zzdyzVarArr) {
        return new zzdrc(this, e, Arrays.asList(zzdyzVarArr));
    }
}
