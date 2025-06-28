package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcvl implements zzepf<zzcve> {
    private final zzeps<Context> a;
    private final zzeps<zzazh> b;
    private final zzeps<zzdnn> c;
    private final zzeps<Executor> d;
    private final zzeps<zzchf> e;
    private final zzeps<zzchp> f;

    public zzcvl(zzeps<Context> zzepsVar, zzeps<zzazh> zzepsVar2, zzeps<zzdnn> zzepsVar3, zzeps<Executor> zzepsVar4, zzeps<zzchf> zzepsVar5, zzeps<zzchp> zzepsVar6) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
        this.f = zzepsVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcve(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b());
    }
}
