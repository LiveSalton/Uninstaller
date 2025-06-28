package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcrn implements zzepf<zzcrk> {
    private final zzeps<zzblp> a;
    private final zzeps<Context> b;
    private final zzeps<Executor> c;
    private final zzeps<zzchp> d;
    private final zzeps<zzdnn> e;
    private final zzeps<zzazh> f;

    public zzcrn(zzeps<zzblp> zzepsVar, zzeps<Context> zzepsVar2, zzeps<Executor> zzepsVar3, zzeps<zzchp> zzepsVar4, zzeps<zzdnn> zzepsVar5, zzeps<zzazh> zzepsVar6) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
        this.f = zzepsVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcrk(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b());
    }
}
