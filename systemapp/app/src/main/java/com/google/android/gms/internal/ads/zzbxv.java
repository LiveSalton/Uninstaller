package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbxv implements zzepf<zzbxu> {
    private final zzeps<Set<zzbxy<zzbxr>>> a;

    private zzbxv(zzeps<Set<zzbxy<zzbxr>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbxv a(zzeps<Set<zzbxy<zzbxr>>> zzepsVar) {
        return new zzbxv(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbxu(this.a.b());
    }
}
