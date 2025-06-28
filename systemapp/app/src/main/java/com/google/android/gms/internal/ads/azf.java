package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
final class azf {
    private final zzpn a = new zzpn(8);
    private int b;

    public final boolean a(zzjz zzjzVar) throws IOException, InterruptedException {
        long c = zzjzVar.c();
        long j = 1024;
        if (c != -1 && c <= 1024) {
            j = c;
        }
        int i = (int) j;
        zzjzVar.c(this.a.a, 0, 4);
        long j2 = this.a.j();
        this.b = 4;
        while (j2 != 440786851) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == i) {
                return false;
            }
            zzjzVar.c(this.a.a, 0, 1);
            j2 = (this.a.a[0] & 255) | ((j2 << 8) & (-256));
        }
        long b = b(zzjzVar);
        long j3 = this.b;
        if (b == Long.MIN_VALUE || (c != -1 && j3 + b >= c)) {
            return false;
        }
        while (true) {
            long j4 = j3 + b;
            if (this.b >= j4) {
                return ((long) this.b) == j4;
            }
            if (b(zzjzVar) == Long.MIN_VALUE) {
                return false;
            }
            long b2 = b(zzjzVar);
            if (b2 < 0 || b2 > 2147483647L) {
                break;
            }
            if (b2 != 0) {
                zzjzVar.c((int) b2);
                this.b = (int) (this.b + b2);
            }
        }
        return false;
    }

    private final long b(zzjz zzjzVar) throws IOException, InterruptedException {
        int i = 0;
        zzjzVar.c(this.a.a, 0, 1);
        int i2 = this.a.a[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        zzjzVar.c(this.a.a, 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.a.a[i] & 255) + (i5 << 8);
        }
        this.b += i4 + 1;
        return i5;
    }
}
