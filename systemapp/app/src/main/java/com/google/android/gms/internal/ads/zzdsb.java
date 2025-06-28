package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdsb implements zzepf<zzdrz> {
    private final zzeps<Executor> a;
    private final zzeps<zzaze> b;

    public zzdsb(zzeps<Executor> zzepsVar, zzeps<zzaze> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdrz(this.a.b(), this.b.b());
    }
}
