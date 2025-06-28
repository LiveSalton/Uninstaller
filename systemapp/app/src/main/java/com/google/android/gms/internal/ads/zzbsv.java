package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbsv implements zzepf<zzbso> {
    private final zzeps<Set<zzbxy<zzbsp>>> a;

    private zzbsv(zzeps<Set<zzbxy<zzbsp>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbsv a(zzeps<Set<zzbxy<zzbsp>>> zzepsVar) {
        return new zzbsv(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbso(this.a.b());
    }
}
