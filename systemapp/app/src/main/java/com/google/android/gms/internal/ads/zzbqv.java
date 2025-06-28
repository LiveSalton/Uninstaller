package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbqv implements zzepf<zzbqu> {
    private final zzeps<zzbsl> a;
    private final zzeps<zzdmu> b;
    private final zzeps<ScheduledExecutorService> c;
    private final zzeps<Executor> d;

    private zzbqv(zzeps<zzbsl> zzepsVar, zzeps<zzdmu> zzepsVar2, zzeps<ScheduledExecutorService> zzepsVar3, zzeps<Executor> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    public static zzbqv a(zzeps<zzbsl> zzepsVar, zzeps<zzdmu> zzepsVar2, zzeps<ScheduledExecutorService> zzepsVar3, zzeps<Executor> zzepsVar4) {
        return new zzbqv(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbqu(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
