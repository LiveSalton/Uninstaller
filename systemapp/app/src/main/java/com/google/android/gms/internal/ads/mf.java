package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class mf implements zzdyo<zzboc> {
    private final /* synthetic */ zzdyo a;
    private final /* synthetic */ zzboj b;

    mf(zzboj zzbojVar, zzdyo zzdyoVar) {
        this.b = zzbojVar;
        this.a = zzdyoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        this.b.c();
        this.a.a(th);
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(zzboc zzbocVar) {
        this.b.c();
        this.a.a((zzdyo) zzbocVar);
    }
}
