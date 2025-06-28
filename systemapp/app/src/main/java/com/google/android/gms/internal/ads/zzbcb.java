package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbcb implements zzht {
    private final zzor a;
    private long b;
    private long c;
    private long d;
    private long e;
    private int f;
    private boolean g;

    zzbcb() {
        this(15000, 30000, 2500L, 5000L);
    }

    private zzbcb(int i, int i2, long j, long j2) {
        this.a = new zzor(true, 65536);
        this.b = 15000000L;
        this.c = 30000000L;
        this.d = 2500000L;
        this.e = 5000000L;
    }

    @Override // com.google.android.gms.internal.ads.zzht
    public final void a() {
        a(false);
    }

    @Override // com.google.android.gms.internal.ads.zzht
    public final void a(zzhy[] zzhyVarArr, zznq zznqVar, zzoe zzoeVar) {
        this.f = 0;
        for (int i = 0; i < zzhyVarArr.length; i++) {
            if (zzoeVar.a(i) != null) {
                this.f += zzpt.b(zzhyVarArr[i].a());
            }
        }
        this.a.a(this.f);
    }

    @Override // com.google.android.gms.internal.ads.zzht
    public final void b() {
        a(true);
    }

    @Override // com.google.android.gms.internal.ads.zzht
    public final void c() {
        a(true);
    }

    @Override // com.google.android.gms.internal.ads.zzht
    public final zzol d() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzht
    public final synchronized boolean a(long j, boolean z) {
        long j2;
        try {
            j2 = z ? this.e : this.d;
        } catch (Throwable th) {
            throw th;
        }
        return j2 <= 0 || j >= j2;
    }

    @Override // com.google.android.gms.internal.ads.zzht
    public final synchronized boolean a(long j) {
        boolean z = false;
        char c = j > this.c ? (char) 0 : j < this.b ? (char) 2 : (char) 1;
        boolean z2 = this.a.e() >= this.f;
        if (c == 2 || (c == 1 && this.g && !z2)) {
            z = true;
        }
        this.g = z;
        return this.g;
    }

    public final synchronized void a(int i) {
        this.b = i * 1000;
    }

    public final synchronized void b(int i) {
        this.c = i * 1000;
    }

    public final synchronized void c(int i) {
        this.d = i * 1000;
    }

    public final synchronized void d(int i) {
        this.e = i * 1000;
    }

    @VisibleForTesting
    private final void a(boolean z) {
        this.f = 0;
        this.g = false;
        if (z) {
            this.a.d();
        }
    }
}
