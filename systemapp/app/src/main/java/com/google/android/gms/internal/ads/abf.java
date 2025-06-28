package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class abf implements zzcyn<zzbyx> {
    private final /* synthetic */ zzcyg a;

    abf(zzcyg zzcygVar) {
        this.a = zzcygVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyn
    public final void a() {
        synchronized (this.a) {
            this.a.g = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyn
    public final /* synthetic */ void a(zzbyx zzbyxVar) {
        zzbyx zzbyxVar2;
        zzbyx zzbyxVar3 = zzbyxVar;
        synchronized (this.a) {
            this.a.g = zzbyxVar3;
            zzbyxVar2 = this.a.g;
            zzbyxVar2.d_();
        }
    }
}
