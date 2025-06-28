package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcgd implements zzepf<zzcgb> {
    private final zzeps<Context> a;
    private final zzeps<zzcce> b;
    private final zzeps<zzcda> c;
    private final zzeps<zzcbt> d;

    private zzcgd(zzeps<Context> zzepsVar, zzeps<zzcce> zzepsVar2, zzeps<zzcda> zzepsVar3, zzeps<zzcbt> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    public static zzcgd a(zzeps<Context> zzepsVar, zzeps<zzcce> zzepsVar2, zzeps<zzcda> zzepsVar3, zzeps<zzcbt> zzepsVar4) {
        return new zzcgd(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcgb(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
