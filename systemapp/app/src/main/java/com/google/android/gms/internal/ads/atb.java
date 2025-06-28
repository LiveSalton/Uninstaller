package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final class atb extends zzejj {
    private final InputStream e;
    private final byte[] f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private ate m;

    /* JADX INFO: Access modifiers changed from: private */
    atb(InputStream inputStream, int i) {
        super();
        this.l = Integer.MAX_VALUE;
        this.m = null;
        zzekk.a(inputStream, "input");
        this.e = inputStream;
        this.f = new byte[4096];
        this.g = 0;
        this.i = 0;
        this.k = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final int a() throws IOException {
        if (t()) {
            this.j = 0;
            return 0;
        }
        this.j = v();
        if ((this.j >>> 3) == 0) {
            throw zzeks.d();
        }
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final void a(int i) throws zzeks {
        if (this.j != i) {
            throw zzeks.e();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final boolean b(int i) throws IOException {
        int a;
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.g - this.i >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.f;
                        int i3 = this.i;
                        this.i = i3 + 1;
                        if (bArr[i3] < 0) {
                            i2++;
                        }
                    }
                    throw zzeks.c();
                }
                while (i2 < 10) {
                    if (A() < 0) {
                        i2++;
                    }
                }
                throw zzeks.c();
                return true;
            case 1:
                j(8);
                return true;
            case 2:
                j(v());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                j(4);
                return true;
            default:
                throw zzeks.f();
        }
        do {
            a = a();
            if (a != 0) {
            }
            a(((i >>> 3) << 3) | 4);
            return true;
        } while (b(a));
        a(((i >>> 3) << 3) | 4);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final double b() throws IOException {
        return Double.longBitsToDouble(y());
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final float c() throws IOException {
        return Float.intBitsToFloat(x());
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final long d() throws IOException {
        return w();
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final long e() throws IOException {
        return w();
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final int f() throws IOException {
        return v();
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final long g() throws IOException {
        return y();
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final int h() throws IOException {
        return x();
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final boolean i() throws IOException {
        return w() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final String j() throws IOException {
        int v = v();
        if (v > 0 && v <= this.g - this.i) {
            String str = new String(this.f, this.i, v, zzekk.a);
            this.i += v;
            return str;
        }
        if (v == 0) {
            return "";
        }
        if (v <= this.g) {
            f(v);
            String str2 = new String(this.f, this.i, v, zzekk.a);
            this.i += v;
            return str2;
        }
        return new String(a(v, false), zzekk.a);
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final String k() throws IOException {
        byte[] a;
        int v = v();
        int i = this.i;
        int i2 = 0;
        if (v <= this.g - i && v > 0) {
            a = this.f;
            this.i = i + v;
            i2 = i;
        } else {
            if (v == 0) {
                return "";
            }
            if (v <= this.g) {
                f(v);
                a = this.f;
                this.i = v;
            } else {
                a = a(v, false);
            }
        }
        return awc.b(a, i2, v);
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final zzeiu l() throws IOException {
        int v = v();
        if (v <= this.g - this.i && v > 0) {
            zzeiu a = zzeiu.a(this.f, this.i, v);
            this.i += v;
            return a;
        }
        if (v == 0) {
            return zzeiu.a;
        }
        byte[] h = h(v);
        if (h != null) {
            return zzeiu.a(h);
        }
        int i = this.i;
        int i2 = this.g - this.i;
        this.k += this.g;
        this.i = 0;
        this.g = 0;
        List<byte[]> i3 = i(v - i2);
        byte[] bArr = new byte[v];
        System.arraycopy(this.f, i, bArr, 0, i2);
        for (byte[] bArr2 : i3) {
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            i2 += bArr2.length;
        }
        return zzeiu.b(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final int m() throws IOException {
        return v();
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final int n() throws IOException {
        return v();
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final int o() throws IOException {
        return x();
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final long p() throws IOException {
        return y();
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final int q() throws IOException {
        return e(v());
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final long r() throws IOException {
        return a(w());
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
    
        if (r1[r2] >= 0) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int v() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.i
            int r1 = r5.g
            if (r1 == r0) goto L6d
            byte[] r1 = r5.f
            int r2 = r0 + 1
            r0 = r1[r0]
            if (r0 < 0) goto L11
            r5.i = r2
            return r0
        L11:
            int r3 = r5.g
            int r3 = r3 - r2
            r4 = 9
            if (r3 < r4) goto L6d
            int r3 = r2 + 1
            r2 = r1[r2]
            int r2 = r2 << 7
            r0 = r0 ^ r2
            if (r0 >= 0) goto L24
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L6a
        L24:
            int r2 = r3 + 1
            r3 = r1[r3]
            int r3 = r3 << 14
            r0 = r0 ^ r3
            if (r0 < 0) goto L31
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2f:
            r3 = r2
            goto L6a
        L31:
            int r3 = r2 + 1
            r2 = r1[r2]
            int r2 = r2 << 21
            r0 = r0 ^ r2
            if (r0 >= 0) goto L3f
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            goto L6a
        L3f:
            int r2 = r3 + 1
            r3 = r1[r3]
            int r4 = r3 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r3 >= 0) goto L2f
            int r3 = r2 + 1
            r2 = r1[r2]
            if (r2 >= 0) goto L6a
            int r2 = r3 + 1
            r3 = r1[r3]
            if (r3 >= 0) goto L2f
            int r3 = r2 + 1
            r2 = r1[r2]
            if (r2 >= 0) goto L6a
            int r2 = r3 + 1
            r3 = r1[r3]
            if (r3 >= 0) goto L2f
            int r3 = r2 + 1
            r1 = r1[r2]
            if (r1 < 0) goto L6d
        L6a:
            r5.i = r3
            return r0
        L6d:
            long r0 = r5.s()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.atb.v():int");
    }

    private final long w() throws IOException {
        int i;
        long j;
        long j2;
        long j3;
        int i2 = this.i;
        if (this.g != i2) {
            byte[] bArr = this.f;
            int i3 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.i = i3;
                return b;
            }
            if (this.g - i3 >= 9) {
                int i4 = i3 + 1;
                int i5 = b ^ (bArr[i3] << 7);
                if (i5 >= 0) {
                    int i6 = i4 + 1;
                    int i7 = i5 ^ (bArr[i4] << 14);
                    if (i7 >= 0) {
                        long j4 = i7 ^ 16256;
                        i = i6;
                        j = j4;
                    } else {
                        i4 = i6 + 1;
                        int i8 = i7 ^ (bArr[i6] << 21);
                        if (i8 < 0) {
                            j3 = i8 ^ (-2080896);
                        } else {
                            long j5 = i8;
                            i = i4 + 1;
                            long j6 = (bArr[i4] << 28) ^ j5;
                            if (j6 >= 0) {
                                j = j6 ^ 266354560;
                            } else {
                                int i9 = i + 1;
                                long j7 = j6 ^ (bArr[i] << 35);
                                if (j7 < 0) {
                                    j2 = (-34093383808L) ^ j7;
                                } else {
                                    i = i9 + 1;
                                    long j8 = j7 ^ (bArr[i9] << 42);
                                    if (j8 >= 0) {
                                        j = j8 ^ 4363953127296L;
                                    } else {
                                        i9 = i + 1;
                                        long j9 = j8 ^ (bArr[i] << 49);
                                        if (j9 < 0) {
                                            j2 = (-558586000294016L) ^ j9;
                                        } else {
                                            i = i9 + 1;
                                            long j10 = (j9 ^ (bArr[i9] << 56)) ^ 71499008037633920L;
                                            if (j10 < 0) {
                                                i9 = i + 1;
                                                if (bArr[i] >= 0) {
                                                    j = j10;
                                                    i = i9;
                                                }
                                            } else {
                                                j = j10;
                                            }
                                        }
                                    }
                                }
                                j = j2;
                                i = i9;
                            }
                        }
                    }
                    this.i = i;
                    return j;
                }
                j3 = i5 ^ (-128);
                j = j3;
                i = i4;
                this.i = i;
                return j;
            }
        }
        return s();
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    final long s() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((A() & 128) == 0) {
                return j;
            }
        }
        throw zzeks.c();
    }

    private final int x() throws IOException {
        int i = this.i;
        if (this.g - i < 4) {
            f(4);
            i = this.i;
        }
        byte[] bArr = this.f;
        this.i = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long y() throws IOException {
        int i = this.i;
        if (this.g - i < 8) {
            f(8);
            i = this.i;
        }
        byte[] bArr = this.f;
        this.i = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final int c(int i) throws zzeks {
        if (i < 0) {
            throw zzeks.b();
        }
        int i2 = i + this.k + this.i;
        int i3 = this.l;
        if (i2 > i3) {
            throw zzeks.a();
        }
        this.l = i2;
        z();
        return i3;
    }

    private final void z() {
        this.g += this.h;
        int i = this.k + this.g;
        if (i > this.l) {
            this.h = i - this.l;
            this.g -= this.h;
        } else {
            this.h = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final void d(int i) {
        this.l = i;
        z();
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final boolean t() throws IOException {
        return this.i == this.g && !g(1);
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final int u() {
        return this.k + this.i;
    }

    private final void f(int i) throws IOException {
        if (g(i)) {
            return;
        }
        if (i > (this.c - this.k) - this.i) {
            throw zzeks.g();
        }
        throw zzeks.a();
    }

    private final boolean g(int i) throws IOException {
        while (this.i + i > this.g) {
            if (i > (this.c - this.k) - this.i || this.k + this.i + i > this.l) {
                return false;
            }
            int i2 = this.i;
            if (i2 > 0) {
                if (this.g > i2) {
                    System.arraycopy(this.f, i2, this.f, 0, this.g - i2);
                }
                this.k += i2;
                this.g -= i2;
                this.i = 0;
            }
            int read = this.e.read(this.f, this.g, Math.min(this.f.length - this.g, (this.c - this.k) - this.g));
            if (read == 0 || read < -1 || read > this.f.length) {
                String valueOf = String.valueOf(this.e.getClass());
                StringBuilder sb = new StringBuilder(91 + String.valueOf(valueOf).length());
                sb.append(valueOf);
                sb.append("#read(byte[]) returned invalid result: ");
                sb.append(read);
                sb.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb.toString());
            }
            if (read <= 0) {
                return false;
            }
            this.g += read;
            z();
            if (this.g >= i) {
                return true;
            }
        }
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("refillBuffer() called when ");
        sb2.append(i);
        sb2.append(" bytes were already available in buffer");
        throw new IllegalStateException(sb2.toString());
    }

    private final byte A() throws IOException {
        if (this.i == this.g) {
            f(1);
        }
        byte[] bArr = this.f;
        int i = this.i;
        this.i = i + 1;
        return bArr[i];
    }

    private final byte[] a(int i, boolean z) throws IOException {
        byte[] h = h(i);
        if (h != null) {
            return h;
        }
        int i2 = this.i;
        int i3 = this.g - this.i;
        this.k += this.g;
        this.i = 0;
        this.g = 0;
        List<byte[]> i4 = i(i - i3);
        byte[] bArr = new byte[i];
        System.arraycopy(this.f, i2, bArr, 0, i3);
        for (byte[] bArr2 : i4) {
            System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
            i3 += bArr2.length;
        }
        return bArr;
    }

    private final byte[] h(int i) throws IOException {
        if (i == 0) {
            return zzekk.b;
        }
        if (i < 0) {
            throw zzeks.b();
        }
        int i2 = this.k + this.i + i;
        if (i2 - this.c > 0) {
            throw zzeks.g();
        }
        if (i2 > this.l) {
            j((this.l - this.k) - this.i);
            throw zzeks.a();
        }
        int i3 = this.g - this.i;
        int i4 = i - i3;
        if (i4 >= 4096 && i4 > this.e.available()) {
            return null;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.f, this.i, bArr, 0, i3);
        this.k += this.g;
        this.i = 0;
        this.g = 0;
        while (i3 < bArr.length) {
            int read = this.e.read(bArr, i3, i - i3);
            if (read == -1) {
                throw zzeks.a();
            }
            this.k += read;
            i3 += read;
        }
        return bArr;
    }

    private final List<byte[]> i(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            byte[] bArr = new byte[Math.min(i, 4096)];
            int i2 = 0;
            while (i2 < bArr.length) {
                int read = this.e.read(bArr, i2, bArr.length - i2);
                if (read == -1) {
                    throw zzeks.a();
                }
                this.k += read;
                i2 += read;
            }
            i -= bArr.length;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void j(int i) throws IOException {
        if (i <= this.g - this.i && i >= 0) {
            this.i += i;
            return;
        }
        if (i < 0) {
            throw zzeks.b();
        }
        if (this.k + this.i + i > this.l) {
            j((this.l - this.k) - this.i);
            throw zzeks.a();
        }
        this.k += this.i;
        int i2 = this.g - this.i;
        this.g = 0;
        this.i = 0;
        while (i2 < i) {
            try {
                long j = i - i2;
                long skip = this.e.skip(j);
                if (skip >= 0 && skip <= j) {
                    if (skip == 0) {
                        break;
                    } else {
                        i2 += (int) skip;
                    }
                }
                String valueOf = String.valueOf(this.e.getClass());
                StringBuilder sb = new StringBuilder(92 + String.valueOf(valueOf).length());
                sb.append(valueOf);
                sb.append("#skip returned invalid result: ");
                sb.append(skip);
                sb.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb.toString());
            } finally {
                this.k += i2;
                z();
            }
        }
        if (i2 >= i) {
            return;
        }
        int i3 = this.g - this.i;
        this.i = this.g;
        f(1);
        while (true) {
            int i4 = i - i3;
            if (i4 > this.g) {
                i3 += this.g;
                this.i = this.g;
                f(1);
            } else {
                this.i = i4;
                return;
            }
        }
    }

    /* synthetic */ atb(InputStream inputStream, int i, ata ataVar) {
        this(inputStream, 4096);
    }
}
