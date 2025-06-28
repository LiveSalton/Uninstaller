package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcxh implements zzepf<zzcxi> {
    private final zzeps<Context> a;
    private final zzeps<zzwt> b;
    private final zzeps<zzdnn> c;
    private final zzeps<zzbme> d;

    public zzcxh(zzeps<Context> zzepsVar, zzeps<zzwt> zzepsVar2, zzeps<zzdnn> zzepsVar3, zzeps<zzbme> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcxi(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
