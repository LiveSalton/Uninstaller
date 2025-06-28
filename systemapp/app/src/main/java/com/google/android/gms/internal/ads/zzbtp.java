package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbtp implements zzepf<zzbtn> {
    private final zzeps<Set<zzbxy<zzbto>>> a;

    private zzbtp(zzeps<Set<zzbxy<zzbto>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbtp a(zzeps<Set<zzbxy<zzbto>>> zzepsVar) {
        return new zzbtp(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbtn(this.a.b());
    }
}
