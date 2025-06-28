package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class aie implements zzcyn<zzchc> {
    private final /* synthetic */ zzdmi a;

    aie(zzdmi zzdmiVar) {
        this.a = zzdmiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyn
    public final void a() {
        synchronized (this.a) {
            this.a.f = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyn
    public final /* synthetic */ void a(zzchc zzchcVar) {
        zzchc zzchcVar2;
        zzchc zzchcVar3 = zzchcVar;
        synchronized (this.a) {
            this.a.f = zzchcVar3;
            zzchcVar2 = this.a.f;
            zzchcVar2.d_();
        }
    }
}
