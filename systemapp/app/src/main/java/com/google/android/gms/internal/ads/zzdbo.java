package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdbo implements zzepf<zzdbm> {
    private final zzeps<zzdzc> a;
    private final zzeps<Context> b;

    private zzdbo(zzeps<zzdzc> zzepsVar, zzeps<Context> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzdbo a(zzeps<zzdzc> zzepsVar, zzeps<Context> zzepsVar2) {
        return new zzdbo(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdbm(this.a.b(), this.b.b());
    }
}
