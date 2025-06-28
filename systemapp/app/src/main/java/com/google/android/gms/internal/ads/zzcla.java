package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcla implements zzepf<zzckv> {
    private final zzeps<Executor> a;
    private final zzeps<zzaze> b;
    private final zzeps<Context> c;
    private final zzeps<zzazh> d;

    public zzcla(zzeps<Executor> zzepsVar, zzeps<zzaze> zzepsVar2, zzeps<Context> zzepsVar3, zzeps<zzazh> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzckv(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
