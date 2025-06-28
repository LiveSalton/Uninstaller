package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbty implements zzepf<zzbtw> {
    private final zzeps<Set<zzbxy<zzbub>>> a;
    private final zzeps<zzdmu> b;

    private zzbty(zzeps<Set<zzbxy<zzbub>>> zzepsVar, zzeps<zzdmu> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzbty a(zzeps<Set<zzbxy<zzbub>>> zzepsVar, zzeps<zzdmu> zzepsVar2) {
        return new zzbty(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbtw(this.a.b(), this.b.b());
    }
}
