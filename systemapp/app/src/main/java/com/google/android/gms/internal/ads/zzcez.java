package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcez implements zzepf<zzces> {
    private final zzeps<Context> a;
    private final zzeps<zzcej> b;
    private final zzeps<zzef> c;
    private final zzeps<zzazh> d;
    private final zzeps<com.google.android.gms.ads.internal.zzb> e;
    private final zzeps<zzts> f;
    private final zzeps<Executor> g;
    private final zzeps<zzdnn> h;
    private final zzeps<zzcff> i;
    private final zzeps<ScheduledExecutorService> j;

    public zzcez(zzeps<Context> zzepsVar, zzeps<zzcej> zzepsVar2, zzeps<zzef> zzepsVar3, zzeps<zzazh> zzepsVar4, zzeps<com.google.android.gms.ads.internal.zzb> zzepsVar5, zzeps<zzts> zzepsVar6, zzeps<Executor> zzepsVar7, zzeps<zzdnn> zzepsVar8, zzeps<zzcff> zzepsVar9, zzeps<ScheduledExecutorService> zzepsVar10) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
        this.f = zzepsVar6;
        this.g = zzepsVar7;
        this.h = zzepsVar8;
        this.i = zzepsVar9;
        this.j = zzepsVar10;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzces(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b(), this.g.b(), this.h.b(), this.i.b(), this.j.b());
    }
}
