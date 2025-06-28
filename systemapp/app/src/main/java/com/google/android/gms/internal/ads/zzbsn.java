package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbsn implements zzepf<zzbsl> {
    private final zzeps<Set<zzbxy<zzbsm>>> a;

    private zzbsn(zzeps<Set<zzbxy<zzbsm>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbsn a(zzeps<Set<zzbxy<zzbsm>>> zzepsVar) {
        return new zzbsn(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbsl(this.a.b());
    }
}
