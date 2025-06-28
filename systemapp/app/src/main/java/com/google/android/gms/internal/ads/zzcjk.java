package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcjk implements zzepf<Set<zzbxy<zzdru>>> {
    private final zzeps<Executor> a;
    private final zzeps<zzcka> b;

    private zzcjk(zzeps<Executor> zzepsVar, zzeps<zzcka> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzcjk a(zzeps<Executor> zzepsVar, zzeps<zzcka> zzepsVar2) {
        return new zzcjk(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        Set emptySet;
        Executor b = this.a.b();
        zzcka b2 = this.b.b();
        if (((Boolean) zzwq.e().a(zzabf.ct)).booleanValue()) {
            emptySet = Collections.singleton(new zzbxy(b2, b));
        } else {
            emptySet = Collections.emptySet();
        }
        return (Set) zzepl.a(emptySet, "Cannot return null from a non-@Nullable @Provides method");
    }
}
