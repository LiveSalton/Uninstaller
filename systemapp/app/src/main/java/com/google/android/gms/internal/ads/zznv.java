package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public class zznv implements zzoc {
    private final zznr a;
    private final int b;
    private final int[] c;
    private final zzhp[] d;
    private final long[] e;
    private int f;

    public zznv(zznr zznrVar, int... iArr) {
        zzpc.b(iArr.length > 0);
        this.a = (zznr) zzpc.a(zznrVar);
        this.b = iArr.length;
        this.d = new zzhp[this.b];
        for (int i = 0; i < iArr.length; i++) {
            this.d[i] = zznrVar.a(iArr[i]);
        }
        Arrays.sort(this.d, new baz());
        this.c = new int[this.b];
        for (int i2 = 0; i2 < this.b; i2++) {
            this.c[i2] = zznrVar.a(this.d[i2]);
        }
        this.e = new long[this.b];
    }

    @Override // com.google.android.gms.internal.ads.zzoc
    public final zznr a() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzoc
    public final int b() {
        return this.c.length;
    }

    @Override // com.google.android.gms.internal.ads.zzoc
    public final zzhp a(int i) {
        return this.d[i];
    }

    @Override // com.google.android.gms.internal.ads.zzoc
    public final int b(int i) {
        return this.c[0];
    }

    public int hashCode() {
        if (this.f == 0) {
            this.f = (31 * System.identityHashCode(this.a)) + Arrays.hashCode(this.c);
        }
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zznv zznvVar = (zznv) obj;
        return this.a == zznvVar.a && Arrays.equals(this.c, zznvVar.c);
    }
}
