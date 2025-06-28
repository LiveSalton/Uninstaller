package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbvt implements zzepf<zzbvr> {
    private final zzeps<Set<zzbxy<zzbvs>>> a;

    private zzbvt(zzeps<Set<zzbxy<zzbvs>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbvt a(zzeps<Set<zzbxy<zzbvs>>> zzepsVar) {
        return new zzbvt(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbvr(this.a.b());
    }
}
