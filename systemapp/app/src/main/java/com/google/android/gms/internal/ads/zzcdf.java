package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcdf implements zzepf<zzcdd> {
    private final zzeps<zzcgh> a;
    private final zzeps<Clock> b;

    public zzcdf(zzeps<zzcgh> zzepsVar, zzeps<Clock> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcdd(this.a.b(), this.b.b());
    }
}
