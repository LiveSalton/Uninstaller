package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdrt implements zzepf<zzdro> {
    private final zzeps<zzdzc> a;
    private final zzeps<ScheduledExecutorService> b;
    private final zzeps<ajy> c;

    private zzdrt(zzeps<zzdzc> zzepsVar, zzeps<ScheduledExecutorService> zzepsVar2, zzeps<ajy> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzdrt a(zzeps<zzdzc> zzepsVar, zzeps<ScheduledExecutorService> zzepsVar2, zzeps<ajy> zzepsVar3) {
        return new zzdrt(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdro(this.a.b(), this.b.b(), this.c.b());
    }
}
