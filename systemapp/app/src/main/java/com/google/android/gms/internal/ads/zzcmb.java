package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcmb implements zzepf<zzclp> {
    private final zzeps<Executor> a;
    private final zzeps<Context> b;
    private final zzeps<WeakReference<Context>> c;
    private final zzeps<Executor> d;
    private final zzeps<zzciq> e;
    private final zzeps<ScheduledExecutorService> f;
    private final zzeps<zzckz> g;
    private final zzeps<zzazh> h;

    public zzcmb(zzeps<Executor> zzepsVar, zzeps<Context> zzepsVar2, zzeps<WeakReference<Context>> zzepsVar3, zzeps<Executor> zzepsVar4, zzeps<zzciq> zzepsVar5, zzeps<ScheduledExecutorService> zzepsVar6, zzeps<zzckz> zzepsVar7, zzeps<zzazh> zzepsVar8) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
        this.f = zzepsVar6;
        this.g = zzepsVar7;
        this.h = zzepsVar8;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzclp(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b(), this.g.b(), this.h.b());
    }
}
