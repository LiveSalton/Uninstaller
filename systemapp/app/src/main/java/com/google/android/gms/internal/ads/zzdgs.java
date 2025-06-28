package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdgs implements zzepf<zzdgq> {
    private final zzeps<zzth> a;
    private final zzeps<zzdzc> b;
    private final zzeps<Context> c;

    public zzdgs(zzeps<zzth> zzepsVar, zzeps<zzdzc> zzepsVar2, zzeps<Context> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdgq(this.a.b(), this.b.b(), this.c.b());
    }
}
