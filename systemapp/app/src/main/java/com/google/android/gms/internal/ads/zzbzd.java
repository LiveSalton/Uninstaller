package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbzd implements zzepf<Set<zzbxy<zzbsi>>> {
    private final zzbzc a;
    private final zzeps<zzbqu> b;

    private zzbzd(zzbzc zzbzcVar, zzeps<zzbqu> zzepsVar) {
        this.a = zzbzcVar;
        this.b = zzepsVar;
    }

    public static zzbzd a(zzbzc zzbzcVar, zzeps<zzbqu> zzepsVar) {
        return new zzbzd(zzbzcVar, zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(Collections.singleton(zzbxy.a(this.b.b(), zzazj.f)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
