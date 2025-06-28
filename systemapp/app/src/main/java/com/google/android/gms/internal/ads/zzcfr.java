package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcfr implements zzepf<zzcfo> {
    private final zzeps<Executor> a;
    private final zzeps<zzbkr> b;
    private final zzeps<zzbxx> c;

    public zzcfr(zzeps<Executor> zzepsVar, zzeps<zzbkr> zzepsVar2, zzeps<zzbxx> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcfo(this.a.b(), this.b.b(), this.c.b());
    }
}
