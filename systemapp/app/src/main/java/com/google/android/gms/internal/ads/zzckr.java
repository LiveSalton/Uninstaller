package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzckr implements zzepf<zzckq> {
    private final zzeps<zzckv> a;
    private final zzeps<Executor> b;

    public zzckr(zzeps<zzckv> zzepsVar, zzeps<Executor> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzckq(this.a.b(), this.b.b());
    }
}
