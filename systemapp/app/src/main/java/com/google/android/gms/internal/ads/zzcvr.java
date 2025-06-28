package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcvr implements zzepf<zzcvo> {
    private final zzeps<Context> a;
    private final zzeps<Executor> b;
    private final zzeps<zzchf> c;

    public zzcvr(zzeps<Context> zzepsVar, zzeps<Executor> zzepsVar2, zzeps<zzchf> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcvo(this.a.b(), this.b.b(), this.c.b());
    }
}
