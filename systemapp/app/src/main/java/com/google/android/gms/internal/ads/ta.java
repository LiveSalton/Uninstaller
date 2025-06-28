package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
final class ta implements zzp, com.google.android.gms.ads.internal.overlay.zzu, zzagy, zzaha, zzva {
    private zzva a;
    private zzagy b;
    private zzp c;
    private zzaha d;
    private com.google.android.gms.ads.internal.overlay.zzu e;

    private ta() {
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final synchronized void e() {
        if (this.a != null) {
            this.a.e();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void a(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        if (this.c != null) {
            this.c.a(zzlVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void f_() {
        if (this.c != null) {
            this.c.f_();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void b_() {
        if (this.c != null) {
            this.c.b_();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void g_() {
        if (this.c != null) {
            this.c.g_();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void e_() {
        if (this.c != null) {
            this.c.e_();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzu
    public final synchronized void a() {
        if (this.e != null) {
            this.e.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzagy
    public final synchronized void a(String str, Bundle bundle) {
        if (this.b != null) {
            this.b.a(str, bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaha
    public final synchronized void a(String str, String str2) {
        if (this.d != null) {
            this.d.a(str, str2);
        }
    }

    public final synchronized void a(zzva zzvaVar, zzagy zzagyVar, zzp zzpVar, zzaha zzahaVar, com.google.android.gms.ads.internal.overlay.zzu zzuVar) {
        this.a = zzvaVar;
        this.b = zzagyVar;
        this.c = zzpVar;
        this.d = zzahaVar;
        this.e = zzuVar;
    }

    /* synthetic */ ta(sx sxVar) {
        this();
    }
}
