package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
final class im implements zzp {
    private zzbdv a;
    private zzp b;

    public im(zzbdv zzbdvVar, zzp zzpVar) {
        this.a = zzbdvVar;
        this.b = zzpVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void b_() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void g_() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void e_() {
        if (this.b != null) {
            this.b.e_();
        }
        this.a.s();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void a(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        if (this.b != null) {
            this.b.a(zzlVar);
        }
        this.a.r();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void f_() {
        if (this.b != null) {
            this.b.f_();
        }
    }
}
