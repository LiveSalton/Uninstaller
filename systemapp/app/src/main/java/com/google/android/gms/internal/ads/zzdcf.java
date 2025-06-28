package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdcf implements zzepf<zzdbw<zzdfp>> {
    private final zzeps<aek> a;
    private final zzeps<Clock> b;

    public zzdcf(zzeps<aek> zzepsVar, zzeps<Clock> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzdbw) zzepl.a(new zzdbw(this.a.b(), zzact.a.a().longValue(), this.b.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
