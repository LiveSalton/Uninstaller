package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
final class atc extends zzejj {
    private final byte[] e;
    private final boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;

    /* JADX INFO: Access modifiers changed from: private */
    atc(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.l = Integer.MAX_VALUE;
        this.e = bArr;
        this.g = i2 + i;
        this.i = i;
        this.j = this.i;
        this.f = z;
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final int a() throws IOException {
        if (t()) {
            this.k = 0;
            return 0;
        }
        this.k = v();
        if ((this.k >>> 3) == 0) {
            throw zzeks.d();
        }
        return this.k;
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final void a(int i) throws zzeks {
        if (this.k != i) {
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
                        byte[] bArr = this.e;
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
                f(8);
                return true;
            case 2:
                f(v());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                f(4);
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
            String str = new String(this.e, this.i, v, zzekk.a);
            this.i += v;
            return str;
        }
        if (v == 0) {
            return "";
        }
        if (v < 0) {
            throw zzeks.b();
        }
        throw zzeks.a();
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final String k() throws IOException {
        int v = v();
        if (v > 0 && v <= this.g - this.i) {
            String b = awc.b(this.e, this.i, v);
            this.i += v;
            return b;
        }
        if (v == 0) {
            return "";
        }
        if (v <= 0) {
            throw zzeks.b();
        }
        throw zzeks.a();
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final zzeiu l() throws IOException {
        byte[] bArr;
        int v = v();
        if (v > 0 && v <= this.g - this.i) {
            zzeiu a = zzeiu.a(this.e, this.i, v);
            this.i += v;
            return a;
        }
        if (v == 0) {
            return zzeiu.a;
        }
        if (v > 0 && v <= this.g - this.i) {
            int i = this.i;
            this.i += v;
            bArr = Arrays.copyOfRange(this.e, i, this.i);
        } else {
            if (v > 0) {
                throw zzeks.a();
            }
            if (v == 0) {
                bArr = zzekk.b;
            } else {
                throw zzeks.b();
            }
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
            byte[] r1 = r5.e
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.atc.v():int");
    }

    private final long w() throws IOException {
        int i;
        long j;
        long j2;
        long j3;
        int i2 = this.i;
        if (this.g != i2) {
            byte[] bArr = this.e;
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
            throw zzeks.a();
        }
        byte[] bArr = this.e;
        this.i = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long y() throws IOException {
        int i = this.i;
        if (this.g - i < 8) {
            throw zzeks.a();
        }
        byte[] bArr = this.e;
        this.i = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final int c(int i) throws zzeks {
        if (i < 0) {
            throw zzeks.b();
        }
        int u = i + u();
        int i2 = this.l;
        if (u > i2) {
            throw zzeks.a();
        }
        this.l = u;
        z();
        return i2;
    }

    private final void z() {
        this.g += this.h;
        int i = this.g - this.j;
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
        return this.i == this.g;
    }

    @Override // com.google.android.gms.internal.ads.zzejj
    public final int u() {
        return this.i - this.j;
    }

    private final byte A() throws IOException {
        if (this.i == this.g) {
            throw zzeks.a();
        }
        byte[] bArr = this.e;
        int i = this.i;
        this.i = i + 1;
        return bArr[i];
    }

    private final void f(int i) throws IOException {
        if (i >= 0 && i <= this.g - this.i) {
            this.i += i;
        } else {
            if (i < 0) {
                throw zzeks.b();
            }
            throw zzeks.a();
        }
    }

    /* synthetic */ atc(byte[] bArr, int i, int i2, boolean z, ata ataVar) {
        this(bArr, i, i2, z);
    }
}
