package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdfg implements zzepf<zzdfd> {
    private final zzeps<zzdzc> a;
    private final zzeps<Context> b;

    private zzdfg(zzeps<zzdzc> zzepsVar, zzeps<Context> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzdfg a(zzeps<zzdzc> zzepsVar, zzeps<Context> zzepsVar2) {
        return new zzdfg(zzepsVar, zzepsVar2);
    }

    public static zzdfd a(zzdzc zzdzcVar, Context context) {
        return new zzdfd(zzdzcVar, context);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a.b(), this.b.b());
    }
}
