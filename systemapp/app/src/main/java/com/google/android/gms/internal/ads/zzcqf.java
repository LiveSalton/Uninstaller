package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcqf implements zzepf<zzcqe> {
    private final zzeps<Context> a;
    private final zzeps<zzbqz> b;
    private final zzeps<zzcpx> c;
    private final zzeps<zzcpr> d;

    private zzcqf(zzeps<Context> zzepsVar, zzeps<zzbqz> zzepsVar2, zzeps<zzcpx> zzepsVar3, zzeps<zzcpr> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    public static zzcqf a(zzeps<Context> zzepsVar, zzeps<zzbqz> zzepsVar2, zzeps<zzcpx> zzepsVar3, zzeps<zzcpr> zzepsVar4) {
        return new zzcqf(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcqe(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
