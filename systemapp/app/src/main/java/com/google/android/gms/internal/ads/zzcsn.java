package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcsn implements zzepf<zzcsm> {
    private final zzeps<Context> a;
    private final zzeps<Executor> b;
    private final zzeps<zzbzx> c;
    private final zzeps<zzdms> d;

    public zzcsn(zzeps<Context> zzepsVar, zzeps<Executor> zzepsVar2, zzeps<zzbzx> zzepsVar3, zzeps<zzdms> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcsm(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
