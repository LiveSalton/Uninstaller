package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdcv implements zzepf<zzdct> {
    private final zzeps<Context> a;
    private final zzeps<zzdzc> b;

    private zzdcv(zzeps<Context> zzepsVar, zzeps<zzdzc> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzdcv a(zzeps<Context> zzepsVar, zzeps<zzdzc> zzepsVar2) {
        return new zzdcv(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdct(this.a.b(), this.b.b());
    }
}
