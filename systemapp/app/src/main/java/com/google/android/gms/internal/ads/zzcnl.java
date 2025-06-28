package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcnl implements zzepf<zzcnh> {
    private final zzeps<zzdnn> a;
    private final zzeps<zzcmd> b;
    private final zzeps<zzdzc> c;
    private final zzeps<ScheduledExecutorService> d;
    private final zzeps<zzcpx> e;

    private zzcnl(zzeps<zzdnn> zzepsVar, zzeps<zzcmd> zzepsVar2, zzeps<zzdzc> zzepsVar3, zzeps<ScheduledExecutorService> zzepsVar4, zzeps<zzcpx> zzepsVar5) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
    }

    public static zzcnl a(zzeps<zzdnn> zzepsVar, zzeps<zzcmd> zzepsVar2, zzeps<zzdzc> zzepsVar3, zzeps<ScheduledExecutorService> zzepsVar4, zzeps<zzcpx> zzepsVar5) {
        return new zzcnl(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4, zzepsVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcnh(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b());
    }
}
