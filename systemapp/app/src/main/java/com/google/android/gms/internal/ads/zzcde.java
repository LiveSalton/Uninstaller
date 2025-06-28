package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcde implements zzepf<zzcda> {
    private final zzeps<zzf> a;
    private final zzeps<zzdnn> b;
    private final zzeps<zzcci> c;
    private final zzeps<zzcce> d;
    private final zzeps<zzcdi> e;
    private final zzeps<zzcdq> f;
    private final zzeps<Executor> g;
    private final zzeps<Executor> h;
    private final zzeps<zzcbz> i;

    private zzcde(zzeps<zzf> zzepsVar, zzeps<zzdnn> zzepsVar2, zzeps<zzcci> zzepsVar3, zzeps<zzcce> zzepsVar4, zzeps<zzcdi> zzepsVar5, zzeps<zzcdq> zzepsVar6, zzeps<Executor> zzepsVar7, zzeps<Executor> zzepsVar8, zzeps<zzcbz> zzepsVar9) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
        this.f = zzepsVar6;
        this.g = zzepsVar7;
        this.h = zzepsVar8;
        this.i = zzepsVar9;
    }

    public static zzcde a(zzeps<zzf> zzepsVar, zzeps<zzdnn> zzepsVar2, zzeps<zzcci> zzepsVar3, zzeps<zzcce> zzepsVar4, zzeps<zzcdi> zzepsVar5, zzeps<zzcdq> zzepsVar6, zzeps<Executor> zzepsVar7, zzeps<Executor> zzepsVar8, zzeps<zzcbz> zzepsVar9) {
        return new zzcde(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4, zzepsVar5, zzepsVar6, zzepsVar7, zzepsVar8, zzepsVar9);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcda(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b(), this.g.b(), this.h.b(), this.i.b());
    }
}
