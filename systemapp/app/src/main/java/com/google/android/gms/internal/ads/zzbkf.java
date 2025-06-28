package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbkf implements zzepf<zzbkg> {
    private final zzeps<Context> a;
    private final zzeps<zzqr> b;

    private zzbkf(zzeps<Context> zzepsVar, zzeps<zzqr> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzbkf a(zzeps<Context> zzepsVar, zzeps<zzqr> zzepsVar2) {
        return new zzbkf(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbkg(this.a.b(), this.b.b());
    }
}
