package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdgi implements zzepf<zzdgg> {
    private final zzeps<zzato> a;
    private final zzeps<Context> b;
    private final zzeps<String> c;
    private final zzeps<zzdzc> d;

    public zzdgi(zzeps<zzato> zzepsVar, zzeps<Context> zzepsVar2, zzeps<String> zzepsVar3, zzeps<zzdzc> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdgg(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
