package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbzf implements zzepf<Set<zzbxy<zzbvz>>> {
    private final zzbzc a;
    private final zzeps<zzbqu> b;

    private zzbzf(zzbzc zzbzcVar, zzeps<zzbqu> zzepsVar) {
        this.a = zzbzcVar;
        this.b = zzepsVar;
    }

    public static zzbzf a(zzbzc zzbzcVar, zzeps<zzbqu> zzepsVar) {
        return new zzbzf(zzbzcVar, zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(Collections.singleton(zzbxy.a(this.b.b(), zzazj.f)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
