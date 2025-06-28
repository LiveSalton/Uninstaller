package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdbs implements zzepf<zzdbq> {
    private final zzeps<zzdzc> a;
    private final zzeps<Context> b;

    public zzdbs(zzeps<zzdzc> zzepsVar, zzeps<Context> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdbq(this.a.b(), this.b.b());
    }
}
