package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdcc implements zzepf<zzdbw<zzdbr>> {
    private final zzeps<zzdbq> a;
    private final zzeps<Clock> b;

    public zzdcc(zzeps<zzdbq> zzepsVar, zzeps<Clock> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzdbw) zzepl.a(new zzdbw(this.a.b(), 10000L, this.b.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
