package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcsu implements zzepf<zzcsq> {
    private final zzeps<zzbna> a;
    private final zzeps<zzcrw> b;
    private final zzeps<zzbrx> c;
    private final zzeps<ScheduledExecutorService> d;
    private final zzeps<zzdzc> e;

    public zzcsu(zzeps<zzbna> zzepsVar, zzeps<zzcrw> zzepsVar2, zzeps<zzbrx> zzepsVar3, zzeps<ScheduledExecutorService> zzepsVar4, zzeps<zzdzc> zzepsVar5) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcsq(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b());
    }
}
