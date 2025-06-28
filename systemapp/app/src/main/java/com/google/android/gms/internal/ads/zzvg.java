package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzvg extends zzww {
    private final AdListener a;

    public zzvg(AdListener adListener) {
        this.a = adListener;
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void a() {
        this.a.c();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void a(int i) {
        this.a.a(i);
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void a(zzve zzveVar) {
        this.a.a(zzveVar.b());
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void b() {
        this.a.d();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void c() {
        this.a.a();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void d() {
        this.a.b();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void e() {
        this.a.e();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void f() {
        this.a.f();
    }

    public final AdListener g() {
        return this.a;
    }
}
