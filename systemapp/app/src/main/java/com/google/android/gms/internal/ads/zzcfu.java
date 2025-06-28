package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcfu implements zzepf<zzcff> {
    private final zzeps<zzdnn> a;
    private final zzeps<Executor> b;
    private final zzeps<zzchp> c;

    public zzcfu(zzeps<zzdnn> zzepsVar, zzeps<Executor> zzepsVar2, zzeps<zzchp> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcff(this.a.b(), this.b.b(), this.c.b());
    }
}
