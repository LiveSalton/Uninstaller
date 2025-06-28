package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzctv implements zzepf<zzctw> {
    private final zzeps<Context> a;
    private final zzeps<zzcat> b;
    private final zzeps<Executor> c;

    public zzctv(zzeps<Context> zzepsVar, zzeps<zzcat> zzepsVar2, zzeps<Executor> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzctw(this.a.b(), this.b.b(), this.c.b());
    }
}
