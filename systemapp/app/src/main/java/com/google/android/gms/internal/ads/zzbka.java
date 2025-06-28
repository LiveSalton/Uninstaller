package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbka implements zzepf<zzbjv> {
    private final zzeps<Context> a;
    private final zzeps<Executor> b;
    private final zzeps<ScheduledExecutorService> c;
    private final zzeps<zzdnj> d;
    private final zzeps<zzdmu> e;
    private final zzeps<zzdrx> f;
    private final zzeps<zzdnv> g;
    private final zzeps<View> h;
    private final zzeps<zzef> i;
    private final zzeps<zzacg> j;
    private final zzeps<zzacl> k;

    private zzbka(zzeps<Context> zzepsVar, zzeps<Executor> zzepsVar2, zzeps<ScheduledExecutorService> zzepsVar3, zzeps<zzdnj> zzepsVar4, zzeps<zzdmu> zzepsVar5, zzeps<zzdrx> zzepsVar6, zzeps<zzdnv> zzepsVar7, zzeps<View> zzepsVar8, zzeps<zzef> zzepsVar9, zzeps<zzacg> zzepsVar10, zzeps<zzacl> zzepsVar11) {
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
        this.k = zzepsVar11;
    }

    public static zzbka a(zzeps<Context> zzepsVar, zzeps<Executor> zzepsVar2, zzeps<ScheduledExecutorService> zzepsVar3, zzeps<zzdnj> zzepsVar4, zzeps<zzdmu> zzepsVar5, zzeps<zzdrx> zzepsVar6, zzeps<zzdnv> zzepsVar7, zzeps<View> zzepsVar8, zzeps<zzef> zzepsVar9, zzeps<zzacg> zzepsVar10, zzeps<zzacl> zzepsVar11) {
        return new zzbka(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4, zzepsVar5, zzepsVar6, zzepsVar7, zzepsVar8, zzepsVar9, zzepsVar10, zzepsVar11);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbjv(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b(), this.g.b(), this.h.b(), this.i.b(), this.j.b(), this.k.b());
    }
}
