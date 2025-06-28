package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzpn {
    public byte[] a;
    private int b;
    private int c;

    public zzpn() {
    }

    public zzpn(int i) {
        this.a = new byte[i];
        this.c = i;
    }

    public zzpn(byte[] bArr) {
        this.a = bArr;
        this.c = bArr.length;
    }

    public final void a(int i) {
        a(e() < i ? new byte[i] : this.a, i);
    }

    public final void a(byte[] bArr, int i) {
        this.a = bArr;
        this.c = i;
        this.b = 0;
    }

    public final void a() {
        this.b = 0;
        this.c = 0;
    }

    public final int b() {
        return this.c - this.b;
    }

    public final int c() {
        return this.c;
    }

    public final void b(int i) {
        zzpc.a(i >= 0 && i <= this.a.length);
        this.c = i;
    }

    public final int d() {
        return this.b;
    }

    public final int e() {
        if (this.a == null) {
            return 0;
        }
        return this.a.length;
    }

    public final void c(int i) {
        zzpc.a(i >= 0 && i <= this.c);
        this.b = i;
    }

    public final void d(int i) {
        c(this.b + i);
    }

    public final void a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.a, this.b, bArr, i, i2);
        this.b += i2;
    }

    public final int f() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & 255;
    }

    public final int g() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public final int h() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        int i2 = bArr[i] & 255;
        byte[] bArr2 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        return i2 | ((bArr2[i3] & 255) << 8);
    }

    public final short i() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        return (short) (i2 | (bArr2[i3] & 255));
    }

    public final long j() {
        byte[] bArr = this.a;
        this.b = this.b + 1;
        byte[] bArr2 = this.a;
        this.b = this.b + 1;
        long j = ((bArr[r1] & 255) << 24) | ((bArr2[r5] & 255) << 16);
        byte[] bArr3 = this.a;
        this.b = this.b + 1;
        long j2 = j | ((bArr3[r5] & 255) << 8);
        byte[] bArr4 = this.a;
        this.b = this.b + 1;
        return j2 | (255 & bArr4[r5]);
    }

    public final long k() {
        byte[] bArr = this.a;
        this.b = this.b + 1;
        byte[] bArr2 = this.a;
        this.b = this.b + 1;
        long j = (bArr[r1] & 255) | ((bArr2[r5] & 255) << 8);
        byte[] bArr3 = this.a;
        this.b = this.b + 1;
        long j2 = j | ((bArr3[r5] & 255) << 16);
        byte[] bArr4 = this.a;
        this.b = this.b + 1;
        return j2 | ((255 & bArr4[r5]) << 24);
    }

    public final int l() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        int i2 = (bArr[i] & 255) << 24;
        byte[] bArr2 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        int i4 = i2 | ((bArr2[i3] & 255) << 16);
        byte[] bArr3 = this.a;
        int i5 = this.b;
        this.b = i5 + 1;
        int i6 = i4 | ((bArr3[i5] & 255) << 8);
        byte[] bArr4 = this.a;
        int i7 = this.b;
        this.b = i7 + 1;
        return i6 | (bArr4[i7] & 255);
    }

    public final long m() {
        byte[] bArr = this.a;
        this.b = this.b + 1;
        byte[] bArr2 = this.a;
        this.b = this.b + 1;
        long j = ((bArr[r1] & 255) << 56) | ((bArr2[r5] & 255) << 48);
        byte[] bArr3 = this.a;
        this.b = this.b + 1;
        long j2 = j | ((bArr3[r5] & 255) << 40);
        byte[] bArr4 = this.a;
        this.b = this.b + 1;
        long j3 = j2 | ((bArr4[r5] & 255) << 32);
        byte[] bArr5 = this.a;
        this.b = this.b + 1;
        long j4 = j3 | ((bArr5[r5] & 255) << 24);
        byte[] bArr6 = this.a;
        this.b = this.b + 1;
        long j5 = j4 | ((bArr6[r5] & 255) << 16);
        byte[] bArr7 = this.a;
        this.b = this.b + 1;
        long j6 = j5 | ((bArr7[r5] & 255) << 8);
        byte[] bArr8 = this.a;
        this.b = this.b + 1;
        return j6 | (255 & bArr8[r5]);
    }

    public final int n() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        int i4 = i2 | (bArr2[i3] & 255);
        this.b += 2;
        return i4;
    }

    public final int o() {
        int l = l();
        if (l >= 0) {
            return l;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(l);
        throw new IllegalStateException(sb.toString());
    }

    public final long p() {
        long m = m();
        if (m >= 0) {
            return m;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(m);
        throw new IllegalStateException(sb.toString());
    }

    public final String e(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = (this.b + i) - 1;
        String str = new String(this.a, this.b, (i2 >= this.c || this.a[i2] != 0) ? i : i - 1);
        this.b += i;
        return str;
    }

    public final String q() {
        if (b() == 0) {
            return null;
        }
        int i = this.b;
        while (i < this.c && this.a[i] != 0) {
            i++;
        }
        String str = new String(this.a, this.b, i - this.b);
        this.b = i;
        if (this.b < this.c) {
            this.b++;
        }
        return str;
    }
}
