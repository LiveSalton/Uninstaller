package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzpo implements zzpg {
    private boolean a;
    private long b;
    private long c;
    private zzhv d = zzhv.a;

    public final void a() {
        if (this.a) {
            return;
        }
        this.c = SystemClock.elapsedRealtime();
        this.a = true;
    }

    public final void b() {
        if (this.a) {
            a(w());
            this.a = false;
        }
    }

    public final void a(long j) {
        this.b = j;
        if (this.a) {
            this.c = SystemClock.elapsedRealtime();
        }
    }

    public final void a(zzpg zzpgVar) {
        a(zzpgVar.w());
        this.d = zzpgVar.x();
    }

    @Override // com.google.android.gms.internal.ads.zzpg
    public final long w() {
        long j = this.b;
        if (!this.a) {
            return j;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.c;
        if (this.d.b == 1.0f) {
            return j + zzhb.b(elapsedRealtime);
        }
        return j + this.d.a(elapsedRealtime);
    }

    @Override // com.google.android.gms.internal.ads.zzpg
    public final zzhv a(zzhv zzhvVar) {
        if (this.a) {
            a(w());
        }
        this.d = zzhvVar;
        return zzhvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpg
    public final zzhv x() {
        return this.d;
    }
}
