package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbll extends zzboc {
    private final View c;
    private final zzbdv d;
    private final zzdmx e;
    private final int f;
    private final boolean g;
    private final boolean h;
    private zzsm i;
    private final zzble j;

    zzbll(zzbob zzbobVar, View view, zzbdv zzbdvVar, zzdmx zzdmxVar, int i, boolean z, boolean z2, zzble zzbleVar) {
        super(zzbobVar);
        this.c = view;
        this.d = zzbdvVar;
        this.e = zzdmxVar;
        this.f = i;
        this.g = z;
        this.h = z2;
        this.j = zzbleVar;
    }

    public final zzdmx a() {
        return zzdns.a(this.b.q, this.e);
    }

    public final View c_() {
        return this.c;
    }

    public final int c() {
        return this.f;
    }

    public final boolean d() {
        return this.g;
    }

    public final boolean e() {
        return this.h;
    }

    public final boolean f() {
        return (this.d == null || this.d.z() == null || !this.d.z().b()) ? false : true;
    }

    public final boolean g() {
        return this.d != null && this.d.B();
    }

    public final void a(zzsc zzscVar) {
        if (this.d != null) {
            this.d.a(zzscVar);
        }
    }

    public final void a(zzsm zzsmVar) {
        this.i = zzsmVar;
    }

    public final zzsm h() {
        return this.i;
    }

    public final void a(long j, int i) {
        this.j.a(j, i);
    }
}
