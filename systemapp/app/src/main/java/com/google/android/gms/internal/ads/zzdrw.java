package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdrw implements zzepf<ajy> {
    private final zzeps<Set<zzbxy<zzdru>>> a;

    private zzdrw(zzeps<Set<zzbxy<zzdru>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzdrw a(zzeps<Set<zzbxy<zzdru>>> zzepsVar) {
        return new zzdrw(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new ajy(this.a.b());
    }
}
