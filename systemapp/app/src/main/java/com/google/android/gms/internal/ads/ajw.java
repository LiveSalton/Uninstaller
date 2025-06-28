package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class ajw<O> implements zzdyo<O> {
    private final /* synthetic */ zzdqx a;
    private final /* synthetic */ zzdrg b;

    ajw(zzdrg zzdrgVar, zzdqx zzdqxVar) {
        this.b = zzdrgVar;
        this.a = zzdqxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(O o) {
        zzdrm zzdrmVar;
        zzdrmVar = this.b.a.d;
        zzdrmVar.c(this.a);
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        zzdrm zzdrmVar;
        zzdrmVar = this.b.a.d;
        zzdrmVar.a(this.a, th);
    }
}
