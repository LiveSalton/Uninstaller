package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbzv implements zzp {
    private final zzbtr a;
    private final zzbxu b;

    public zzbzv(zzbtr zzbtrVar, zzbxu zzbxuVar) {
        this.a = zzbtrVar;
        this.b = zzbxuVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void a(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        this.a.a(zzlVar);
        this.b.b();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void b_() {
        this.a.b_();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void g_() {
        this.a.g_();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void e_() {
        this.a.e_();
        this.b.a();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void f_() {
        this.a.f_();
    }
}
