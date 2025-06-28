package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class bac {
    public final int a;
    public final long[] b;
    public final int[] c;
    public final int d;
    public final long[] e;
    public final int[] f;

    public bac(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        zzpc.a(iArr.length == jArr2.length);
        zzpc.a(jArr.length == jArr2.length);
        zzpc.a(iArr2.length == jArr2.length);
        this.b = jArr;
        this.c = iArr;
        this.d = i;
        this.e = jArr2;
        this.f = iArr2;
        this.a = jArr.length;
    }

    public final int a(long j) {
        for (int a = zzpt.a(this.e, j, true, false); a >= 0; a--) {
            if ((this.f[a] & 1) != 0) {
                return a;
            }
        }
        return -1;
    }

    public final int b(long j) {
        for (int b = zzpt.b(this.e, j, true, false); b < this.e.length; b++) {
            if ((this.f[b] & 1) != 0) {
                return b;
            }
        }
        return -1;
    }
}
