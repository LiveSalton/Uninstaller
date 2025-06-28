package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzczl implements zzepf<zzcyx> {
    private final zzeps<zzbgm> a;
    private final zzeps<Context> b;
    private final zzeps<zzef> c;
    private final zzeps<zzazh> d;
    private final zzeps<zzdod<zzcgh>> e;
    private final zzeps<zzdzc> f;
    private final zzeps<ScheduledExecutorService> g;

    public zzczl(zzeps<zzbgm> zzepsVar, zzeps<Context> zzepsVar2, zzeps<zzef> zzepsVar3, zzeps<zzazh> zzepsVar4, zzeps<zzdod<zzcgh>> zzepsVar5, zzeps<zzdzc> zzepsVar6, zzeps<ScheduledExecutorService> zzepsVar7) {
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
        return new zzcyx(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b(), this.g.b());
    }
}
