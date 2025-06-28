package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzckg implements zzbrz, zzbtj, zzbui {
    private final zzcko a;
    private final zzckv b;

    public zzckg(zzcko zzckoVar, zzckv zzckvVar) {
        this.a = zzckoVar;
        this.b = zzckvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void a() {
        this.a.a().put("action", "loaded");
        this.b.a(this.a.a());
    }

    @Override // com.google.android.gms.internal.ads.zzbrz
    public final void a_(zzve zzveVar) {
        this.a.a().put("action", "ftl");
        this.a.a().put("ftl", String.valueOf(zzveVar.a));
        this.a.a().put("ed", zzveVar.c);
        this.b.a(this.a.a());
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void a(zzatl zzatlVar) {
        this.a.a(zzatlVar.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void a(zzdnj zzdnjVar) {
        this.a.a(zzdnjVar);
    }
}
