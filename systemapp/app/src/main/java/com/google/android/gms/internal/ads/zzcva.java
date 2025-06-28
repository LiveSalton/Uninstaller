package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcva implements zzepf<zzcuv> {
    private final zzeps<Context> a;
    private final zzeps<zzchf> b;

    public zzcva(zzeps<Context> zzepsVar, zzeps<zzchf> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcuv(this.a.b(), this.b.b());
    }
}
