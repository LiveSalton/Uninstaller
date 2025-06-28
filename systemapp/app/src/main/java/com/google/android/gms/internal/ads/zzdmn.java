package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdmn implements zzepf<zzdmi> {
    private final zzeps<String> a;
    private final zzeps<zzdma> b;
    private final zzeps<Context> c;
    private final zzeps<zzdlf> d;
    private final zzeps<zzdni> e;

    public zzdmn(zzeps<String> zzepsVar, zzeps<zzdma> zzepsVar2, zzeps<Context> zzepsVar3, zzeps<zzdlf> zzepsVar4, zzeps<zzdni> zzepsVar5) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdmi(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b());
    }
}
