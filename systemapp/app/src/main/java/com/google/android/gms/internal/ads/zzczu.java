package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzczu implements zzepf<zzczs> {
    private final zzeps<Executor> a;
    private final zzeps<zzcmx> b;

    public zzczu(zzeps<Executor> zzepsVar, zzeps<zzcmx> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzczs(this.a.b(), this.b.b());
    }
}
