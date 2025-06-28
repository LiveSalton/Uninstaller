package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdou implements zzepf<zzdop> {
    private final zzeps<Context> a;
    private final zzeps<zzazh> b;
    private final zzeps<zzayg> c;

    public zzdou(zzeps<Context> zzepsVar, zzeps<zzazh> zzepsVar2, zzeps<zzayg> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdop(this.a.b(), this.b.b(), this.c.b());
    }
}
