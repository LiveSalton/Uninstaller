package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdfu implements zzepf<zzdfs> {
    private final zzeps<zzdzc> a;
    private final zzeps<Context> b;

    private zzdfu(zzeps<zzdzc> zzepsVar, zzeps<Context> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzdfu a(zzeps<zzdzc> zzepsVar, zzeps<Context> zzepsVar2) {
        return new zzdfu(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdfs(this.a.b(), this.b.b());
    }
}
