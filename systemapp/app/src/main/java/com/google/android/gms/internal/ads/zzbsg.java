package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbsg implements zzepf<zzbsf> {
    private final zzeps<Set<zzbxy<zzbsi>>> a;

    private zzbsg(zzeps<Set<zzbxy<zzbsi>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbsg a(zzeps<Set<zzbxy<zzbsi>>> zzepsVar) {
        return new zzbsg(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbsf(this.a.b());
    }
}
