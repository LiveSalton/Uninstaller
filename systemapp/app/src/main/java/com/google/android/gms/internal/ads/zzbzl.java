package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbzl implements zzepf<Set<zzbxy<zzbru>>> {
    private final zzbzc a;
    private final zzeps<zzbqu> b;

    private zzbzl(zzbzc zzbzcVar, zzeps<zzbqu> zzepsVar) {
        this.a = zzbzcVar;
        this.b = zzepsVar;
    }

    public static zzbzl a(zzbzc zzbzcVar, zzeps<zzbqu> zzepsVar) {
        return new zzbzl(zzbzcVar, zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(this.a.a(this.b.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
