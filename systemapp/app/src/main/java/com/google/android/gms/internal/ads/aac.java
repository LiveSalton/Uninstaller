package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class aac implements zzbtf {
    private boolean a = false;
    private final /* synthetic */ zzcrb b;
    private final /* synthetic */ zzazq c;
    private final /* synthetic */ zzcvy d;

    aac(zzcvy zzcvyVar, zzcrb zzcrbVar, zzazq zzazqVar) {
        this.d = zzcvyVar;
        this.b = zzcrbVar;
        this.c = zzazqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void a(int i) {
        if (this.a) {
            return;
        }
        b(new zzve(i, zzcvy.a(this.b.a, i), "undefined", null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void a(int i, String str) {
        if (this.a) {
            return;
        }
        this.a = true;
        if (str == null) {
            str = zzcvy.a(this.b.a, i);
        }
        b(new zzve(i, str, "undefined", null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void a(zzve zzveVar) {
        this.a = true;
        b(zzveVar);
    }

    private final void b(zzve zzveVar) {
        zzdok zzdokVar = zzdok.INTERNAL_ERROR;
        if (((Boolean) zzwq.e().a(zzabf.cK)).booleanValue()) {
            zzdokVar = zzdok.NO_FILL;
        }
        this.c.a(new zzcrd(zzdokVar, zzveVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void a() {
        this.c.b(null);
    }
}
