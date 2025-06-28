package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
final class ays {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final short[] f;
    private int g;
    private short[] h;
    private int i;
    private short[] j;
    private int k;
    private short[] l;
    private int q;
    private int r;
    private int s;
    private int t;
    private int v;
    private int w;
    private int x;
    private int m = 0;
    private int n = 0;
    private int u = 0;
    private float o = 1.0f;
    private float p = 1.0f;

    public ays(int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = i / 400;
        this.d = i / 65;
        this.e = 2 * this.d;
        this.f = new short[this.e];
        this.g = this.e;
        this.h = new short[this.e * i2];
        this.i = this.e;
        this.j = new short[this.e * i2];
        this.k = this.e;
        this.l = new short[this.e * i2];
    }

    public final void a(float f) {
        this.o = f;
    }

    public final void b(float f) {
        this.p = f;
    }

    public final void a(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining() / this.b;
        int i = (this.b * remaining) << 1;
        b(remaining);
        shortBuffer.get(this.h, this.q * this.b, i / 2);
        this.q += remaining;
        c();
    }

    public final void b(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.b, this.r);
        shortBuffer.put(this.j, 0, this.b * min);
        this.r -= min;
        System.arraycopy(this.j, min * this.b, this.j, 0, this.r * this.b);
    }

    public final void a() {
        int i = this.q;
        int i2 = this.r + ((int) ((((i / (this.o / this.p)) + this.s) / this.p) + 0.5f));
        b((this.e * 2) + i);
        for (int i3 = 0; i3 < this.e * 2 * this.b; i3++) {
            this.h[(this.b * i) + i3] = 0;
        }
        this.q += 2 * this.e;
        c();
        if (this.r > i2) {
            this.r = i2;
        }
        this.q = 0;
        this.t = 0;
        this.s = 0;
    }

    public final int b() {
        return this.r;
    }

    private final void a(int i) {
        if (this.r + i > this.i) {
            this.i += (this.i / 2) + i;
            this.j = Arrays.copyOf(this.j, this.i * this.b);
        }
    }

    private final void b(int i) {
        if (this.q + i > this.g) {
            this.g += (this.g / 2) + i;
            this.h = Arrays.copyOf(this.h, this.g * this.b);
        }
    }

    private final void a(short[] sArr, int i, int i2) {
        a(i2);
        System.arraycopy(sArr, i * this.b, this.j, this.r * this.b, this.b * i2);
        this.r += i2;
    }

    private final void b(short[] sArr, int i, int i2) {
        int i3 = this.e / i2;
        int i4 = this.b * i2;
        int i5 = i * this.b;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                i7 += sArr[(i6 * i4) + i5 + i8];
            }
            this.f[i6] = (short) (i7 / i4);
        }
    }

    private final int a(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.b;
        int i5 = 1;
        int i6 = 0;
        int i7 = 255;
        int i8 = 0;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i8 < i5 * i2) {
                i8 = i2;
                i5 = i9;
            }
            if (i9 * i7 > i6 * i2) {
                i7 = i2;
                i6 = i9;
            }
            i2++;
        }
        this.w = i5 / i8;
        this.x = i6 / i7;
        return i8;
    }

    private final void c() {
        int i;
        int i2;
        int i3;
        int i4 = this.r;
        float f = this.o / this.p;
        double d = f;
        int i5 = 1;
        if (d > 1.00001d || d < 0.99999d) {
            if (this.q >= this.e) {
                int i6 = this.q;
                int i7 = 0;
                while (true) {
                    if (this.t > 0) {
                        int min = Math.min(this.e, this.t);
                        a(this.h, i7, min);
                        this.t -= min;
                        i7 += min;
                    } else {
                        short[] sArr = this.h;
                        int i8 = this.a > 4000 ? this.a / 4000 : i5;
                        if (this.b == i5 && i8 == i5) {
                            i = a(sArr, i7, this.c, this.d);
                        } else {
                            b(sArr, i7, i8);
                            int a = a(this.f, 0, this.c / i8, this.d / i8);
                            if (i8 != i5) {
                                int i9 = a * i8;
                                int i10 = i8 << 2;
                                int i11 = i9 - i10;
                                int i12 = i9 + i10;
                                if (i11 < this.c) {
                                    i11 = this.c;
                                }
                                if (i12 > this.d) {
                                    i12 = this.d;
                                }
                                if (this.b == i5) {
                                    i = a(sArr, i7, i11, i12);
                                } else {
                                    b(sArr, i7, i5);
                                    i = a(this.f, 0, i11, i12);
                                }
                            } else {
                                i = a;
                            }
                        }
                        int i13 = this.w;
                        int i14 = ((i13 == 0 || this.u == 0 || this.x > i13 * 3 || (i13 << 1) <= this.v * 3) ? 0 : i5) != 0 ? this.u : i;
                        this.v = this.w;
                        this.u = i;
                        if (d > 1.0d) {
                            short[] sArr2 = this.h;
                            if (f >= 2.0f) {
                                i3 = (int) (i14 / (f - 1.0f));
                            } else {
                                this.t = (int) ((i14 * (2.0f - f)) / (f - 1.0f));
                                i3 = i14;
                            }
                            a(i3);
                            int i15 = i3;
                            a(i3, this.b, this.j, this.r, sArr2, i7, sArr2, i7 + i14);
                            this.r += i15;
                            i7 += i14 + i15;
                        } else {
                            int i16 = i14;
                            int i17 = i7;
                            short[] sArr3 = this.h;
                            if (f < 0.5f) {
                                i2 = (int) ((i16 * f) / (1.0f - f));
                            } else {
                                this.t = (int) ((i16 * ((2.0f * f) - 1.0f)) / (1.0f - f));
                                i2 = i16;
                            }
                            int i18 = i16 + i2;
                            a(i18);
                            System.arraycopy(sArr3, this.b * i17, this.j, this.r * this.b, this.b * i16);
                            a(i2, this.b, this.j, this.r + i16, sArr3, i17 + i16, sArr3, i17);
                            this.r += i18;
                            i7 = i17 + i2;
                        }
                    }
                    if (this.e + i7 > i6) {
                        break;
                    } else {
                        i5 = 1;
                    }
                }
                int i19 = this.q - i7;
                System.arraycopy(this.h, i7 * this.b, this.h, 0, this.b * i19);
                this.q = i19;
            }
        } else {
            a(this.h, 0, this.q);
            this.q = 0;
        }
        if (this.p != 1.0f) {
            float f2 = this.p;
            if (this.r != i4) {
                int i20 = (int) (this.a / f2);
                int i21 = this.a;
                while (true) {
                    if (i20 <= 16384 && i21 <= 16384) {
                        break;
                    }
                    i20 /= 2;
                    i21 /= 2;
                }
                int i22 = this.r - i4;
                if (this.s + i22 > this.k) {
                    this.k += (this.k / 2) + i22;
                    this.l = Arrays.copyOf(this.l, this.k * this.b);
                }
                System.arraycopy(this.j, this.b * i4, this.l, this.s * this.b, this.b * i22);
                this.r = i4;
                this.s += i22;
                int i23 = 0;
                while (true) {
                    int i24 = 1;
                    if (i23 >= this.s - 1) {
                        break;
                    }
                    while ((this.m + i24) * i20 > this.n * i21) {
                        a(i24);
                        for (int i25 = 0; i25 < this.b; i25++) {
                            short[] sArr4 = this.j;
                            int i26 = (this.r * this.b) + i25;
                            short[] sArr5 = this.l;
                            int i27 = (this.b * i23) + i25;
                            short s = sArr5[i27];
                            short s2 = sArr5[i27 + this.b];
                            int i28 = this.n * i21;
                            int i29 = this.m * i20;
                            int i30 = (this.m + 1) * i20;
                            int i31 = i30 - i28;
                            int i32 = i30 - i29;
                            sArr4[i26] = (short) (((s * i31) + ((i32 - i31) * s2)) / i32);
                        }
                        i24 = 1;
                        this.n++;
                        this.r++;
                    }
                    this.m += i24;
                    if (this.m == i21) {
                        this.m = 0;
                        zzpc.b(this.n == i20);
                        this.n = 0;
                    }
                    i23++;
                }
                int i33 = this.s - 1;
                if (i33 != 0) {
                    System.arraycopy(this.l, this.b * i33, this.l, 0, (this.s - i33) * this.b);
                    this.s -= i33;
                }
            }
        }
    }

    private static void a(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }
}
