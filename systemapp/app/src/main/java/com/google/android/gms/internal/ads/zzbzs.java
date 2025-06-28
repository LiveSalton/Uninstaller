package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbzs implements zzepf<Set<zzbxy<zzbxr>>> {
    private final zzeps<zzcaj> a;

    private zzbzs(zzeps<zzcaj> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbzs a(zzeps<zzcaj> zzepsVar) {
        return new zzbzs(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(Collections.singleton(zzbxy.a(this.a.b(), zzazj.f)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
