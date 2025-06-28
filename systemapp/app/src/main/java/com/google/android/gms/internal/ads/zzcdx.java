package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcdx implements zzbsm {
    private final zzcce a;
    private final zzcci b;

    public zzcdx(zzcce zzcceVar, zzcci zzcciVar) {
        this.a = zzcceVar;
        this.b = zzcciVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final void b() {
        if (this.a.x() == null) {
            return;
        }
        zzbdv w = this.a.w();
        zzbdv v = this.a.v();
        if (w == null) {
            w = v != null ? v : null;
        }
        if (!this.b.d() || w == null) {
            return;
        }
        w.a("onSdkImpression", new androidx.b.a());
    }
}
