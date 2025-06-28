package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbnu implements zzepf<zzbnr> {
    private final zzeps<Context> a;
    private final zzeps<zzbdv> b;
    private final zzeps<zzdmu> c;
    private final zzeps<zzazh> d;

    public zzbnu(zzeps<Context> zzepsVar, zzeps<zzbdv> zzepsVar2, zzeps<zzdmu> zzepsVar3, zzeps<zzazh> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbnr(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
