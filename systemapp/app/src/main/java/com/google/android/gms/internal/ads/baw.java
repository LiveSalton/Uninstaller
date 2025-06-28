package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class baw {
    private int i;
    private int j;
    private int k;
    private int l;
    private zzhp q;
    private int a = 1000;
    private int[] b = new int[this.a];
    private long[] c = new long[this.a];
    private long[] f = new long[this.a];
    private int[] e = new int[this.a];
    private int[] d = new int[this.a];
    private zzkg[] g = new zzkg[this.a];
    private zzhp[] h = new zzhp[this.a];
    private long m = Long.MIN_VALUE;
    private long n = Long.MIN_VALUE;
    private boolean p = true;
    private boolean o = true;

    public final void a() {
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.i = 0;
        this.o = true;
    }

    public final void b() {
        this.m = Long.MIN_VALUE;
        this.n = Long.MIN_VALUE;
    }

    public final int c() {
        return this.j + this.i;
    }

    public final synchronized boolean d() {
        return this.i != 0;
    }

    public final synchronized zzhp e() {
        if (this.p) {
            return null;
        }
        return this.q;
    }

    public final synchronized long f() {
        return Math.max(this.m, this.n);
    }

    public final synchronized int a(zzhr zzhrVar, zzjl zzjlVar, boolean z, boolean z2, zzhp zzhpVar, zznj zznjVar) {
        if (!d()) {
            if (z2) {
                zzjlVar.a(4);
                return -4;
            }
            if (this.q == null || (!z && this.q == zzhpVar)) {
                return -3;
            }
            zzhrVar.a = this.q;
            return -5;
        }
        if (!z && this.h[this.k] == zzhpVar) {
            if (zzjlVar.b == null) {
                return -3;
            }
            zzjlVar.c = this.f[this.k];
            zzjlVar.a(this.e[this.k]);
            zznjVar.a = this.d[this.k];
            zznjVar.b = this.c[this.k];
            zznjVar.d = this.g[this.k];
            this.m = Math.max(this.m, zzjlVar.c);
            this.i--;
            this.k++;
            this.j++;
            if (this.k == this.a) {
                this.k = 0;
            }
            zznjVar.c = this.i > 0 ? this.c[this.k] : zznjVar.b + zznjVar.a;
            return -4;
        }
        zzhrVar.a = this.h[this.k];
        return -5;
    }

    public final synchronized long g() {
        if (!d()) {
            return -1L;
        }
        int i = ((this.k + this.i) - 1) % this.a;
        this.k = (this.k + this.i) % this.a;
        this.j += this.i;
        this.i = 0;
        return this.c[i] + this.d[i];
    }

    public final synchronized long a(long j, boolean z) {
        if (d() && j >= this.f[this.k]) {
            if (j > this.n && !z) {
                return -1L;
            }
            int i = this.k;
            int i2 = 0;
            int i3 = -1;
            while (i != this.l && this.f[i] <= j) {
                if ((this.e[i] & 1) != 0) {
                    i3 = i2;
                }
                i = (i + 1) % this.a;
                i2++;
            }
            if (i3 == -1) {
                return -1L;
            }
            this.k = (this.k + i3) % this.a;
            this.j += i3;
            this.i -= i3;
            return this.c[this.k];
        }
        return -1L;
    }

    public final synchronized boolean a(zzhp zzhpVar) {
        if (zzhpVar == null) {
            this.p = true;
            return false;
        }
        this.p = false;
        if (zzpt.a(zzhpVar, this.q)) {
            return false;
        }
        this.q = zzhpVar;
        return true;
    }

    public final synchronized void a(long j, int i, long j2, int i2, zzkg zzkgVar) {
        if (this.o) {
            if ((i & 1) == 0) {
                return;
            } else {
                this.o = false;
            }
        }
        zzpc.b(!this.p);
        a(j);
        this.f[this.l] = j;
        this.c[this.l] = j2;
        this.d[this.l] = i2;
        this.e[this.l] = i;
        this.g[this.l] = zzkgVar;
        this.h[this.l] = this.q;
        this.b[this.l] = 0;
        this.i++;
        if (this.i == this.a) {
            int i3 = this.a + 1000;
            int[] iArr = new int[i3];
            long[] jArr = new long[i3];
            long[] jArr2 = new long[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            zzkg[] zzkgVarArr = new zzkg[i3];
            zzhp[] zzhpVarArr = new zzhp[i3];
            int i4 = this.a - this.k;
            System.arraycopy(this.c, this.k, jArr, 0, i4);
            System.arraycopy(this.f, this.k, jArr2, 0, i4);
            System.arraycopy(this.e, this.k, iArr2, 0, i4);
            System.arraycopy(this.d, this.k, iArr3, 0, i4);
            System.arraycopy(this.g, this.k, zzkgVarArr, 0, i4);
            System.arraycopy(this.h, this.k, zzhpVarArr, 0, i4);
            System.arraycopy(this.b, this.k, iArr, 0, i4);
            int i5 = this.k;
            System.arraycopy(this.c, 0, jArr, i4, i5);
            System.arraycopy(this.f, 0, jArr2, i4, i5);
            System.arraycopy(this.e, 0, iArr2, i4, i5);
            System.arraycopy(this.d, 0, iArr3, i4, i5);
            System.arraycopy(this.g, 0, zzkgVarArr, i4, i5);
            System.arraycopy(this.h, 0, zzhpVarArr, i4, i5);
            System.arraycopy(this.b, 0, iArr, i4, i5);
            this.c = jArr;
            this.f = jArr2;
            this.e = iArr2;
            this.d = iArr3;
            this.g = zzkgVarArr;
            this.h = zzhpVarArr;
            this.b = iArr;
            this.k = 0;
            this.l = this.a;
            this.i = this.a;
            this.a = i3;
            return;
        }
        this.l++;
        if (this.l == this.a) {
            this.l = 0;
        }
    }

    public final synchronized void a(long j) {
        this.n = Math.max(this.n, j);
    }
}
