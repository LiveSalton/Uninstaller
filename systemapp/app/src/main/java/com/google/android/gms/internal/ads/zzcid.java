package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcid implements zzepf<zzchp> {
    private final zzeps<zzbed> a;
    private final zzeps<Context> b;
    private final zzeps<zzef> c;
    private final zzeps<zzacg> d;
    private final zzeps<zzazh> e;
    private final zzeps<com.google.android.gms.ads.internal.zzb> f;
    private final zzeps<zzts> g;
    private final zzeps<zzbua> h;
    private final zzeps<zzbyw> i;

    private zzcid(zzeps<zzbed> zzepsVar, zzeps<Context> zzepsVar2, zzeps<zzef> zzepsVar3, zzeps<zzacg> zzepsVar4, zzeps<zzazh> zzepsVar5, zzeps<com.google.android.gms.ads.internal.zzb> zzepsVar6, zzeps<zzts> zzepsVar7, zzeps<zzbua> zzepsVar8, zzeps<zzbyw> zzepsVar9) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
        this.f = zzepsVar6;
        this.g = zzepsVar7;
        this.h = zzepsVar8;
        this.i = zzepsVar9;
    }

    public static zzcid a(zzeps<zzbed> zzepsVar, zzeps<Context> zzepsVar2, zzeps<zzef> zzepsVar3, zzeps<zzacg> zzepsVar4, zzeps<zzazh> zzepsVar5, zzeps<com.google.android.gms.ads.internal.zzb> zzepsVar6, zzeps<zzts> zzepsVar7, zzeps<zzbua> zzepsVar8, zzeps<zzbyw> zzepsVar9) {
        return new zzcid(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4, zzepsVar5, zzepsVar6, zzepsVar7, zzepsVar8, zzepsVar9);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzchp(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b(), this.g.b(), this.h.b(), this.i.b());
    }
}
