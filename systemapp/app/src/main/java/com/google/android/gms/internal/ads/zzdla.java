package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdla implements zzepf<zzdkv> {
    private final zzeps<Context> a;
    private final zzeps<Executor> b;
    private final zzeps<zzbgm> c;
    private final zzeps<zzcxq> d;
    private final zzeps<zzdlf> e;
    private final zzeps<zzdnp> f;

    public zzdla(zzeps<Context> zzepsVar, zzeps<Executor> zzepsVar2, zzeps<zzbgm> zzepsVar3, zzeps<zzcxq> zzepsVar4, zzeps<zzdlf> zzepsVar5, zzeps<zzdnp> zzepsVar6) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
        this.f = zzepsVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdkv(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b());
    }
}
