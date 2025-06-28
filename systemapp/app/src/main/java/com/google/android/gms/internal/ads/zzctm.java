package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzctm implements zzepf<zzcth> {
    private final zzeps<Context> a;
    private final zzeps<zzbzx> b;

    public zzctm(zzeps<Context> zzepsVar, zzeps<zzbzx> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcth(this.a.b(), this.b.b());
    }
}
