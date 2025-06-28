package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcfg implements zzepf<zzcfc> {
    private final zzeps<Executor> a;
    private final zzeps<zzces> b;

    public zzcfg(zzeps<Executor> zzepsVar, zzeps<zzces> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcfc(this.a.b(), this.b.b());
    }
}
