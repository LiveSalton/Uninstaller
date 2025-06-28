package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcti implements zzepf<zzctg> {
    private final zzeps<Context> a;
    private final zzeps<zzazh> b;
    private final zzeps<zzbzx> c;
    private final zzeps<Executor> d;

    public zzcti(zzeps<Context> zzepsVar, zzeps<zzazh> zzepsVar2, zzeps<zzbzx> zzepsVar3, zzeps<Executor> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzctg(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
