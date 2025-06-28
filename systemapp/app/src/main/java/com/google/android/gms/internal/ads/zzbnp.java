package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbnp implements zzepf<zzbnk> {
    private final zzeps<zzbob> a;
    private final zzeps<zzagd> b;
    private final zzeps<Runnable> c;
    private final zzeps<Executor> d;

    public zzbnp(zzeps<zzbob> zzepsVar, zzeps<zzagd> zzepsVar2, zzeps<Runnable> zzepsVar3, zzeps<Executor> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbnk(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
