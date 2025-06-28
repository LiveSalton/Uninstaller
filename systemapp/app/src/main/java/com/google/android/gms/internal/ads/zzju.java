package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzju implements zzkf {
    private final int a;
    private final int[] b;
    private final long[] c;
    private final long[] d;
    private final long[] e;
    private final long f;

    public zzju(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        this.a = iArr.length;
        if (this.a > 0) {
            this.f = jArr2[this.a - 1] + jArr3[this.a - 1];
        } else {
            this.f = 0L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final long b() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final long a(long j) {
        return this.c[zzpt.a(this.e, j, true, true)];
    }
}
