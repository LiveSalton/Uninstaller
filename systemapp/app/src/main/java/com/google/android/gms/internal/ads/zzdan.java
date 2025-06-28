package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdan implements zzepf<zzdal> {
    private final zzeps<zzdbw<zzdfp>> a;
    private final zzeps<zzdnn> b;
    private final zzeps<Context> c;
    private final zzeps<zzayg> d;

    private zzdan(zzeps<zzdbw<zzdfp>> zzepsVar, zzeps<zzdnn> zzepsVar2, zzeps<Context> zzepsVar3, zzeps<zzayg> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    public static zzdan a(zzeps<zzdbw<zzdfp>> zzepsVar, zzeps<zzdnn> zzepsVar2, zzeps<Context> zzepsVar3, zzeps<zzayg> zzepsVar4) {
        return new zzdan(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdal(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
