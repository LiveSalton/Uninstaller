package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdmj implements zzepf<zzdma> {
    private final zzeps<Context> a;
    private final zzeps<Executor> b;
    private final zzeps<zzbgm> c;
    private final zzeps<zzdkl<zzchf, zzchc>> d;
    private final zzeps<zzdlf> e;
    private final zzeps<zzdnp> f;
    private final zzeps<zzdni> g;

    public zzdmj(zzeps<Context> zzepsVar, zzeps<Executor> zzepsVar2, zzeps<zzbgm> zzepsVar3, zzeps<zzdkl<zzchf, zzchc>> zzepsVar4, zzeps<zzdlf> zzepsVar5, zzeps<zzdnp> zzepsVar6, zzeps<zzdni> zzepsVar7) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
        this.f = zzepsVar6;
        this.g = zzepsVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdma(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b(), this.g.b());
    }
}
