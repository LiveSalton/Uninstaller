package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcqc implements zzdru {
    private final zzcpx a;

    zzcqc(zzcpx zzcpxVar) {
        this.a = zzcpxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void a(zzdrl zzdrlVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void b(zzdrl zzdrlVar, String str) {
        if (((Boolean) zzwq.e().a(zzabf.ds)).booleanValue() && zzdrl.RENDERER == zzdrlVar) {
            this.a.b(zzp.j().b());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void a(zzdrl zzdrlVar, String str, Throwable th) {
        if (((Boolean) zzwq.e().a(zzabf.ds)).booleanValue() && zzdrl.RENDERER == zzdrlVar && this.a.c() != 0) {
            this.a.c(zzp.j().b() - this.a.c());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void c(zzdrl zzdrlVar, String str) {
        if (((Boolean) zzwq.e().a(zzabf.ds)).booleanValue() && zzdrl.RENDERER == zzdrlVar && this.a.c() != 0) {
            this.a.c(zzp.j().b() - this.a.c());
        }
    }
}
