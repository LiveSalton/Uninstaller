package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdbk implements zzepf<zzdbg> {
    private final zzeps<Context> a;
    private final zzeps<ScheduledExecutorService> b;
    private final zzeps<Executor> c;

    private zzdbk(zzeps<Context> zzepsVar, zzeps<ScheduledExecutorService> zzepsVar2, zzeps<Executor> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzdbk a(zzeps<Context> zzepsVar, zzeps<ScheduledExecutorService> zzepsVar2, zzeps<Executor> zzepsVar3) {
        return new zzdbk(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdbg(this.a.b(), this.b.b(), this.c.b());
    }
}
