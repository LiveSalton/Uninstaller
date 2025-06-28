package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdgo implements zzepf<zzdgk> {
    private final zzeps<zzayc> a;
    private final zzeps<Integer> b;
    private final zzeps<Context> c;
    private final zzeps<zzayg> d;
    private final zzeps<ScheduledExecutorService> e;
    private final zzeps<Executor> f;

    public zzdgo(zzeps<zzayc> zzepsVar, zzeps<Integer> zzepsVar2, zzeps<Context> zzepsVar3, zzeps<zzayg> zzepsVar4, zzeps<ScheduledExecutorService> zzepsVar5, zzeps<Executor> zzepsVar6) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
        this.f = zzepsVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdgk(this.a.b(), this.b.b().intValue(), this.c.b(), this.d.b(), this.e.b(), this.f.b());
    }
}
