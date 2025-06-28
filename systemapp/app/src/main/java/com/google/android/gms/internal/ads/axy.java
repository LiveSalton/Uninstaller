package com.google.android.gms.internal.ads;

import android.util.Log;

/* compiled from: source */
/* loaded from: classes.dex */
final class axy {
    public final zzmy a;
    public final Object b;
    public final int c;
    public final zznn[] d;
    public final long e;
    public int f;
    public long g;
    public boolean h;
    public boolean i;
    public boolean j;
    public axy k;
    public zzoj l;
    private final boolean[] m;
    private final zzhy[] n;
    private final zzhx[] o;
    private final zzoh p;
    private final zzht q;
    private final zzna r;
    private zzoj s;

    public axy(zzhy[] zzhyVarArr, zzhx[] zzhxVarArr, long j, zzoh zzohVar, zzht zzhtVar, zzna zznaVar, Object obj, int i, int i2, boolean z, long j2) {
        this.n = zzhyVarArr;
        this.o = zzhxVarArr;
        this.e = j;
        this.p = zzohVar;
        this.q = zzhtVar;
        this.r = zznaVar;
        this.b = zzpc.a(obj);
        this.c = i;
        this.f = i2;
        this.h = z;
        this.g = j2;
        this.d = new zznn[zzhyVarArr.length];
        this.m = new boolean[zzhyVarArr.length];
        this.a = zznaVar.a(i2, zzhtVar.d());
    }

    public final long a() {
        return this.e - this.g;
    }

    public final void a(int i, boolean z) {
        this.f = i;
        this.h = z;
    }

    public final boolean b() {
        if (this.i) {
            return !this.j || this.a.g() == Long.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c() throws com.google.android.gms.internal.ads.zzhe {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzoh r0 = r6.p
            com.google.android.gms.internal.ads.zzhx[] r1 = r6.o
            com.google.android.gms.internal.ads.zzmy r2 = r6.a
            com.google.android.gms.internal.ads.zznq r2 = r2.d()
            com.google.android.gms.internal.ads.zzoj r0 = r0.a(r1, r2)
            com.google.android.gms.internal.ads.zzoj r1 = r6.s
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L16
        L14:
            r1 = r3
            goto L28
        L16:
            r4 = r3
        L17:
            com.google.android.gms.internal.ads.zzoe r5 = r0.b
            int r5 = r5.a
            if (r4 >= r5) goto L27
            boolean r5 = r0.a(r1, r4)
            if (r5 != 0) goto L24
            goto L14
        L24:
            int r4 = r4 + 1
            goto L17
        L27:
            r1 = r2
        L28:
            if (r1 == 0) goto L2b
            return r3
        L2b:
            r6.l = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.axy.c():boolean");
    }

    public final long a(long j, boolean z) {
        return a(j, false, new boolean[this.n.length]);
    }

    public final long a(long j, boolean z, boolean[] zArr) {
        zzoe zzoeVar = this.l.b;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzoeVar.a) {
                break;
            }
            boolean[] zArr2 = this.m;
            if (z || !this.l.a(this.s, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long a = this.a.a(zzoeVar.a(), this.m, this.d, zArr, j);
        this.s = this.l;
        this.j = false;
        for (int i2 = 0; i2 < this.d.length; i2++) {
            if (this.d[i2] != null) {
                zzpc.b(zzoeVar.a(i2) != null);
                this.j = true;
            } else {
                zzpc.b(zzoeVar.a(i2) == null);
            }
        }
        this.q.a(this.n, this.l.a, zzoeVar);
        return a;
    }

    public final void d() {
        try {
            this.r.a(this.a);
        } catch (RuntimeException e) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e);
        }
    }
}
