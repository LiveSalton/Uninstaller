package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbmm implements zzepf<zzbte> {
    private final zzbmh a;
    private final zzeps<Set<zzbxy<zzbtj>>> b;

    public zzbmm(zzbmh zzbmhVar, zzeps<Set<zzbxy<zzbtj>>> zzepsVar) {
        this.a = zzbmhVar;
        this.b = zzepsVar;
    }

    public static zzbte a(zzbmh zzbmhVar, Set<zzbxy<zzbtj>> set) {
        return (zzbte) zzepl.a(zzbmhVar.a(set), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a, this.b.b());
    }
}
