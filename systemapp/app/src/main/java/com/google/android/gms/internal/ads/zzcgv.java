package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcgv implements zzepf<zzcgu> {
    private final zzeps<Context> a;
    private final zzeps<Executor> b;
    private final zzeps<zzef> c;
    private final zzeps<zzazh> d;
    private final zzeps<com.google.android.gms.ads.internal.zzb> e;
    private final zzeps<zzbed> f;
    private final zzeps<zzcqo> g;
    private final zzeps<zzdrz> h;
    private final zzeps<zzckq> i;

    public zzcgv(zzeps<Context> zzepsVar, zzeps<Executor> zzepsVar2, zzeps<zzef> zzepsVar3, zzeps<zzazh> zzepsVar4, zzeps<com.google.android.gms.ads.internal.zzb> zzepsVar5, zzeps<zzbed> zzepsVar6, zzeps<zzcqo> zzepsVar7, zzeps<zzdrz> zzepsVar8, zzeps<zzckq> zzepsVar9) {
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

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcgu(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b(), this.g.b(), this.h.b(), this.i.b());
    }
}
