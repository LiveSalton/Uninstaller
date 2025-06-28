package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcrt implements zzepf<zzcrp> {
    private final zzeps<zzblg> a;
    private final zzeps<Context> b;
    private final zzeps<Executor> c;
    private final zzeps<zzchp> d;

    public zzcrt(zzeps<zzblg> zzepsVar, zzeps<Context> zzepsVar2, zzeps<Executor> zzepsVar3, zzeps<zzchp> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcrp(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
