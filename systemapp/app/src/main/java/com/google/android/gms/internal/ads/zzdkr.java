package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdkr implements zzepf<zzdkl<zzblg, zzbll>> {
    private final zzeps<Context> a;
    private final zzeps<zzdpa> b;
    private final zzeps<zzdpr> c;

    public zzdkr(zzeps<Context> zzepsVar, zzeps<zzdpa> zzepsVar2, zzeps<zzdpr> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzdkl) zzepl.a(zzdkp.a(this.a.b(), this.b.b(), this.c.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
