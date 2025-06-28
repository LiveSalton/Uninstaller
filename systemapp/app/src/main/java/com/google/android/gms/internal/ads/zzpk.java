package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzpk {
    private byte[] a;
    private int b;
    private int c;
    private int d;

    public zzpk() {
    }

    public zzpk(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private zzpk(byte[] bArr, int i) {
        this.a = bArr;
        this.d = i;
    }

    public final int a(int i) {
        int i2;
        int i3;
        boolean z = false;
        if (i == 0) {
            return 0;
        }
        int i4 = i / 8;
        int i5 = i;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            if (this.c != 0) {
                i3 = ((this.a[this.b + 1] & 255) >>> (8 - this.c)) | ((this.a[this.b] & 255) << this.c);
            } else {
                i3 = this.a[this.b];
            }
            i5 -= 8;
            i6 |= (255 & i3) << i5;
            this.b++;
        }
        if (i5 > 0) {
            int i8 = this.c + i5;
            byte b = (byte) (255 >> (8 - i5));
            if (i8 > 8) {
                i2 = (b & (((this.a[this.b] & 255) << (i8 - 8)) | ((255 & this.a[this.b + 1]) >> (16 - i8)))) | i6;
                this.b++;
            } else {
                i2 = (b & ((this.a[this.b] & 255) >> (8 - i8))) | i6;
                if (i8 == 8) {
                    this.b++;
                }
            }
            i6 = i2;
            this.c = i8 % 8;
        }
        if (this.b >= 0 && this.c >= 0 && this.c < 8 && (this.b < this.d || (this.b == this.d && this.c == 0))) {
            z = true;
        }
        zzpc.b(z);
        return i6;
    }
}
