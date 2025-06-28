package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcpx {
    private int a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;
    private final Object e = new Object();
    private final Object f = new Object();
    private final Object g = new Object();
    private final Object h = new Object();

    public final void a(int i) {
        synchronized (this.e) {
            this.a = i;
        }
    }

    public final int a() {
        int i;
        synchronized (this.e) {
            i = this.a;
        }
        return i;
    }

    public final void a(long j) {
        synchronized (this.f) {
            this.b = j;
        }
    }

    public final long b() {
        long j;
        synchronized (this.f) {
            j = this.b;
        }
        return j;
    }

    public final synchronized void b(long j) {
        synchronized (this.g) {
            this.c = j;
        }
    }

    public final synchronized long c() {
        long j;
        synchronized (this.g) {
            j = this.c;
        }
        return j;
    }

    public final synchronized void c(long j) {
        synchronized (this.h) {
            this.d = j;
        }
    }

    public final synchronized long d() {
        long j;
        synchronized (this.h) {
            j = this.d;
        }
        return j;
    }
}
