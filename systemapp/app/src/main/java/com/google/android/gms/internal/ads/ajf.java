package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
final class ajf {
    private final zzdqg b = new zzdqg();
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private final long a = zzp.j().a();
    private long c = this.a;

    public final void a() {
        this.c = zzp.j().a();
        this.d++;
    }

    public final void b() {
        this.e++;
        this.b.a = true;
    }

    public final void c() {
        this.f++;
        this.b.b++;
    }

    public final long d() {
        return this.a;
    }

    public final long e() {
        return this.c;
    }

    public final int f() {
        return this.d;
    }

    public final zzdqg g() {
        zzdqg zzdqgVar = (zzdqg) this.b.clone();
        zzdqg zzdqgVar2 = this.b;
        zzdqgVar2.a = false;
        zzdqgVar2.b = 0;
        return zzdqgVar;
    }

    public final String h() {
        return "Created: " + this.a + " Last accessed: " + this.c + " Accesses: " + this.d + "\nEntries retrieved: Valid: " + this.e + " Stale: " + this.f;
    }
}
