package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdgb implements zzepf<zzdfw> {
    private final zzeps<zzayc> a;
    private final zzeps<Context> b;
    private final zzeps<ScheduledExecutorService> c;
    private final zzeps<Executor> d;

    public zzdgb(zzeps<zzayc> zzepsVar, zzeps<Context> zzepsVar2, zzeps<ScheduledExecutorService> zzepsVar3, zzeps<Executor> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdfw(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
