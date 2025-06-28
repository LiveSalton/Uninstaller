package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdez implements zzepf<zzdex> {
    private final zzeps<zzdzc> a;
    private final zzeps<Context> b;
    private final zzeps<zzazh> c;

    private zzdez(zzeps<zzdzc> zzepsVar, zzeps<Context> zzepsVar2, zzeps<zzazh> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzdez a(zzeps<zzdzc> zzepsVar, zzeps<Context> zzepsVar2, zzeps<zzazh> zzepsVar3) {
        return new zzdez(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdex(this.a.b(), this.b.b(), this.c.b());
    }
}
