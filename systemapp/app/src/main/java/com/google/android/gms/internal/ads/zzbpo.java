package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbpo implements zzbru, zzbsm, zzbtj, zzbui, zzva {
    private final Clock a;
    private final zzayf b;

    public zzbpo(Clock clock, zzayf zzayfVar) {
        this.a = clock;
        this.b = zzayfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void a(zzatl zzatlVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void a(zzauf zzaufVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void c() {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void f() {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void g() {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void h() {
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void e() {
        this.b.b();
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void a() {
        this.b.a(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final void b() {
        this.b.a();
    }

    public final void a(zzvk zzvkVar) {
        this.b.a(zzvkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void a(zzdnj zzdnjVar) {
        this.b.a(this.a.b());
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void d() {
        this.b.c();
    }

    public final String i() {
        return this.b.e();
    }
}
