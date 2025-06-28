package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzejj {
    int a;
    int b;
    int c;
    atd d;
    private boolean e;

    public static long a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    static zzejj a(byte[] bArr, int i, int i2, boolean z) {
        atc atcVar = new atc(bArr, i, i2, z);
        try {
            atcVar.c(i2);
            return atcVar;
        } catch (zzeks e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int e(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract int a() throws IOException;

    public abstract void a(int i) throws zzeks;

    public abstract double b() throws IOException;

    public abstract boolean b(int i) throws IOException;

    public abstract float c() throws IOException;

    public abstract int c(int i) throws zzeks;

    public abstract long d() throws IOException;

    public abstract void d(int i);

    public abstract long e() throws IOException;

    public abstract int f() throws IOException;

    public abstract long g() throws IOException;

    public abstract int h() throws IOException;

    public abstract boolean i() throws IOException;

    public abstract String j() throws IOException;

    public abstract String k() throws IOException;

    public abstract zzeiu l() throws IOException;

    public abstract int m() throws IOException;

    public abstract int n() throws IOException;

    public abstract int o() throws IOException;

    public abstract long p() throws IOException;

    public abstract int q() throws IOException;

    public abstract long r() throws IOException;

    abstract long s() throws IOException;

    public abstract boolean t() throws IOException;

    public abstract int u();

    /* JADX INFO: Access modifiers changed from: private */
    zzejj() {
        this.b = 100;
        this.c = Integer.MAX_VALUE;
        this.e = false;
    }

    /* synthetic */ zzejj(ata ataVar) {
        this();
    }
}
