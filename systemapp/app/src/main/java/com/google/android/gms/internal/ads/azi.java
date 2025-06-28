package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
final class azi {
    private static final long[] a = {128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] b = new byte[8];
    private int c;
    private int d;

    public final void a() {
        this.c = 0;
        this.d = 0;
    }

    public final long a(zzjz zzjzVar, boolean z, boolean z2, int i) throws IOException, InterruptedException {
        if (this.c == 0) {
            if (!zzjzVar.a(this.b, 0, 1, z)) {
                return -1L;
            }
            this.d = a(this.b[0] & 255);
            if (this.d == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.c = 1;
        }
        if (this.d > i) {
            this.c = 0;
            return -2L;
        }
        if (this.d != 1) {
            zzjzVar.b(this.b, 1, this.d - 1);
        }
        this.c = 0;
        return a(this.b, this.d, z2);
    }

    public final int b() {
        return this.d;
    }

    public static int a(int i) {
        for (int i2 = 0; i2 < a.length; i2++) {
            if ((a[i2] & i) != 0) {
                return i2 + 1;
            }
        }
        return -1;
    }

    public static long a(byte[] bArr, int i, boolean z) {
        long j = bArr[0] & 255;
        if (z) {
            j &= ~a[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (bArr[i2] & 255);
        }
        return j;
    }
}
