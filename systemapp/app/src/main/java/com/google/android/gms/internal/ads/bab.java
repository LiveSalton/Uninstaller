package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class bab {
    public azr a;
    public long b;
    public long c;
    public long d;
    public int e;
    public int f;
    public long[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public long[] k;
    public boolean[] l;
    public boolean m;
    public boolean[] n;
    public zzlr o;
    public int p;
    public zzpn q;
    public boolean r;
    public long s;

    bab() {
    }

    public final void a(int i) {
        if (this.q == null || this.q.c() < i) {
            this.q = new zzpn(i);
        }
        this.p = i;
        this.m = true;
        this.r = true;
    }

    public final long b(int i) {
        return this.k[i] + this.j[i];
    }
}
