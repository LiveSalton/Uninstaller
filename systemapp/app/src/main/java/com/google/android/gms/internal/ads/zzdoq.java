package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdoq implements zzepf<zzdon> {
    private final zzeps<Context> a;
    private final zzeps<zzayq> b;

    private zzdoq(zzeps<Context> zzepsVar, zzeps<zzayq> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzdoq a(zzeps<Context> zzepsVar, zzeps<zzayq> zzepsVar2) {
        return new zzdoq(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdon(this.a.b(), this.b.b());
    }
}
