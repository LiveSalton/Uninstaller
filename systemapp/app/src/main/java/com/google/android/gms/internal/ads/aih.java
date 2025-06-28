package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class aih implements zzcyn<zzchc> {
    private final /* synthetic */ zzdmo a;

    aih(zzdmo zzdmoVar) {
        this.a = zzdmoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyn
    public final void a() {
        synchronized (this.a) {
            this.a.d = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyn
    public final /* synthetic */ void a(zzchc zzchcVar) {
        zzchc zzchcVar2;
        zzchc zzchcVar3 = zzchcVar;
        synchronized (this.a) {
            this.a.d = zzchcVar3;
            zzchcVar2 = this.a.d;
            zzchcVar2.d_();
        }
    }
}
