package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class mg implements zzdyo<zzboi> {
    private final /* synthetic */ zzdyo a;
    private final /* synthetic */ zzboj b;

    mg(zzboj zzbojVar, zzdyo zzdyoVar) {
        this.b = zzbojVar;
        this.a = zzdyoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        this.a.a(th);
        this.b.c();
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(zzboi zzboiVar) {
        this.b.a(zzboiVar.a, this.a);
    }
}
