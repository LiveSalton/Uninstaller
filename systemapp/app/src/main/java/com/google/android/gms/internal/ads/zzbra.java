package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbra implements zzepf<mo> {
    private final zzeps<Context> a;
    private final zzeps<zzdmu> b;
    private final zzeps<zzarq> c;

    private zzbra(zzeps<Context> zzepsVar, zzeps<zzdmu> zzepsVar2, zzeps<zzarq> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzbra a(zzeps<Context> zzepsVar, zzeps<zzdmu> zzepsVar2, zzeps<zzarq> zzepsVar3) {
        return new zzbra(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new mo(this.a.b(), this.b.b(), this.c.b());
    }
}
