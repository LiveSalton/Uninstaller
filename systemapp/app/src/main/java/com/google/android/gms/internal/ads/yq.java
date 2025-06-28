package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class yq implements zzdyo<zzbme> {
    private final /* synthetic */ zzcsq a;

    yq(zzcsq zzcsqVar) {
        this.a = zzcsqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        zzbna zzbnaVar;
        zzbrx zzbrxVar;
        zzbnaVar = this.a.a;
        zzve a = zzbnaVar.b().a(th);
        zzbrxVar = this.a.d;
        zzbrxVar.a_(a);
        zzdob.a(a.a, th, "DelayedBannerAd.onFailure");
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(zzbme zzbmeVar) {
        zzbmeVar.d_();
    }
}
