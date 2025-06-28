package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdkq implements zzepf<zzdkl<zzchf, zzchc>> {
    private final zzeps<Context> a;
    private final zzeps<zzdpa> b;
    private final zzeps<zzdpr> c;

    public zzdkq(zzeps<Context> zzepsVar, zzeps<zzdpa> zzepsVar2, zzeps<zzdpr> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        Object zzdkdVar;
        Context b = this.a.b();
        zzdpa b2 = this.b.b();
        zzdpr b3 = this.c.b();
        if (((Integer) zzwq.e().a(zzabf.dz)).intValue() > 0) {
            zzdpu a = b3.a(zzdpj.Rewarded, b, b2, new agn(new zzdjk()));
            zzdkdVar = new zzdjp(new zzdkc(new zzdkd()), new zzdju(a.a, zzazj.a), a.b, zzazj.a);
        } else {
            zzdkdVar = new zzdkd();
        }
        return (zzdkl) zzepl.a(zzdkdVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
