package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class abg implements zzcyn<zzboc> {
    private final /* synthetic */ zzcyh a;

    abg(zzcyh zzcyhVar) {
        this.a = zzcyhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyn
    public final void a() {
        synchronized (this.a) {
            zzcyh.a(this.a, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyn
    public final /* synthetic */ void a(zzboc zzbocVar) {
        zzboc zzbocVar2 = zzbocVar;
        synchronized (this.a) {
            zzcyh.a(this.a, false);
            this.a.c = zzbocVar2.k();
            zzbocVar2.d_();
        }
    }
}
