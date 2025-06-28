package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzpm {
    private byte[] a;
    private int b;
    private int c;
    private int d = 0;

    public zzpm(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.c = i;
        this.b = i2;
        e();
    }

    public final void a(int i) {
        int i2 = this.c;
        this.c += i / 8;
        this.d += i % 8;
        if (this.d > 7) {
            this.c++;
            this.d -= 8;
        }
        while (true) {
            i2++;
            if (i2 <= this.c) {
                if (c(i2)) {
                    this.c++;
                    i2 += 2;
                }
            } else {
                e();
                return;
            }
        }
    }

    public final boolean a() {
        return b(1) == 1;
    }

    public final int b(int i) {
        int i2;
        int i3;
        if (i == 0) {
            return 0;
        }
        int i4 = i / 8;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = c(this.c + 1) ? this.c + 2 : this.c + 1;
            if (this.d != 0) {
                i3 = ((this.a[i7] & 255) >>> (8 - this.d)) | ((this.a[this.c] & 255) << this.d);
            } else {
                i3 = this.a[this.c];
            }
            i -= 8;
            i5 |= (255 & i3) << i;
            this.c = i7;
        }
        if (i > 0) {
            int i8 = this.d + i;
            byte b = (byte) (255 >> (8 - i));
            int i9 = c(this.c + 1) ? this.c + 2 : this.c + 1;
            if (i8 > 8) {
                i2 = (b & (((255 & this.a[i9]) >> (16 - i8)) | ((this.a[this.c] & 255) << (i8 - 8)))) | i5;
                this.c = i9;
            } else {
                i2 = (b & ((255 & this.a[this.c]) >> (8 - i8))) | i5;
                if (i8 == 8) {
                    this.c = i9;
                }
            }
            i5 = i2;
            this.d = i8 % 8;
        }
        e();
        return i5;
    }

    public final int b() {
        return d();
    }

    public final int c() {
        int d = d();
        return (d % 2 == 0 ? -1 : 1) * ((d + 1) / 2);
    }

    private final int d() {
        int i = 0;
        while (!a()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? b(i) : 0);
    }

    private final boolean c(int i) {
        return 2 <= i && i < this.b && this.a[i] == 3 && this.a[i + (-2)] == 0 && this.a[i - 1] == 0;
    }

    private final void e() {
        zzpc.b(this.c >= 0 && this.d >= 0 && this.d < 8 && (this.c < this.b || (this.c == this.b && this.d == 0)));
    }
}
