package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzckb implements zzepf<zzcka> {
    private final zzeps<zzts> a;
    private final zzeps<Map<zzdrl, zzckc>> b;

    private zzckb(zzeps<zzts> zzepsVar, zzeps<Map<zzdrl, zzckc>> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzckb a(zzeps<zzts> zzepsVar, zzeps<Map<zzdrl, zzckc>> zzepsVar2) {
        return new zzckb(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcka(this.a.b(), this.b.b());
    }
}
