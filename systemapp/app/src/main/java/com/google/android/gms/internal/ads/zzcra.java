package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcra implements zzepf<zzcqy> {
    private final zzeps<Context> a;
    private final zzeps<zzcqo> b;
    private final zzeps<zzaze> c;
    private final zzeps<zzckq> d;

    public zzcra(zzeps<Context> zzepsVar, zzeps<zzcqo> zzepsVar2, zzeps<zzaze> zzepsVar3, zzeps<zzckq> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcqy(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
