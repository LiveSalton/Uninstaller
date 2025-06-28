package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdfm<T> implements zzepf<zzdfl<T>> {
    private final zzeps<Executor> a;
    private final zzeps<Set<zzdfi<? extends zzdfj<T>>>> b;

    private zzdfm(zzeps<Executor> zzepsVar, zzeps<Set<zzdfi<? extends zzdfj<T>>>> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static <T> zzdfm<T> a(zzeps<Executor> zzepsVar, zzeps<Set<zzdfi<? extends zzdfj<T>>>> zzepsVar2) {
        return new zzdfm<>(zzepsVar, zzepsVar2);
    }

    public static <T> zzdfl<T> a(Executor executor, Set<zzdfi<? extends zzdfj<T>>> set) {
        return new zzdfl<>(executor, set);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a.b(), this.b.b());
    }
}
