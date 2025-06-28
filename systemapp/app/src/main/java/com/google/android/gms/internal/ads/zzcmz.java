package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcmz implements zzepf<zzcmx> {
    private final zzeps<ScheduledExecutorService> a;
    private final zzeps<zzdzc> b;
    private final zzeps<zzcnw> c;
    private final zzeps<zzcou> d;

    public zzcmz(zzeps<ScheduledExecutorService> zzepsVar, zzeps<zzdzc> zzepsVar2, zzeps<zzcnw> zzepsVar3, zzeps<zzcou> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcmx(this.a.b(), this.b.b(), this.c.b(), zzepg.b(this.d));
    }
}
