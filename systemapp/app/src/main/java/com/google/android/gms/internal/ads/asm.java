package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
final class asm {
    static int a(byte[] bArr, int i, asp aspVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return a(b, bArr, i2, aspVar);
        }
        aspVar.a = b;
        return i2;
    }

    static int a(int i, byte[] bArr, int i2, asp aspVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            aspVar.a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            aspVar.a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            aspVar.a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            aspVar.a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                aspVar.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int b(byte[] bArr, int i, asp aspVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            aspVar.b = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        aspVar.b = j2;
        return i3;
    }

    static int a(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static long b(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    static double c(byte[] bArr, int i) {
        return Double.longBitsToDouble(b(bArr, i));
    }

    static float d(byte[] bArr, int i) {
        return Float.intBitsToFloat(a(bArr, i));
    }

    static int c(byte[] bArr, int i, asp aspVar) throws zzeks {
        int a = a(bArr, i, aspVar);
        int i2 = aspVar.a;
        if (i2 < 0) {
            throw zzeks.b();
        }
        if (i2 == 0) {
            aspVar.c = "";
            return a;
        }
        aspVar.c = new String(bArr, a, i2, zzekk.a);
        return a + i2;
    }

    static int d(byte[] bArr, int i, asp aspVar) throws zzeks {
        int a = a(bArr, i, aspVar);
        int i2 = aspVar.a;
        if (i2 < 0) {
            throw zzeks.b();
        }
        if (i2 == 0) {
            aspVar.c = "";
            return a;
        }
        aspVar.c = awc.b(bArr, a, i2);
        return a + i2;
    }

    static int e(byte[] bArr, int i, asp aspVar) throws zzeks {
        int a = a(bArr, i, aspVar);
        int i2 = aspVar.a;
        if (i2 < 0) {
            throw zzeks.b();
        }
        if (i2 > bArr.length - a) {
            throw zzeks.a();
        }
        if (i2 == 0) {
            aspVar.c = zzeiu.a;
            return a;
        }
        aspVar.c = zzeiu.a(bArr, a, i2);
        return a + i2;
    }

    static int a(avd avdVar, byte[] bArr, int i, int i2, asp aspVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = a(i4, bArr, i3, aspVar);
            i4 = aspVar.a;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzeks.a();
        }
        Object a = avdVar.a();
        int i6 = i4 + i5;
        avdVar.a(a, bArr, i5, i6, aspVar);
        avdVar.c(a);
        aspVar.c = a;
        return i6;
    }

    static int a(avd avdVar, byte[] bArr, int i, int i2, int i3, asp aspVar) throws IOException {
        auo auoVar = (auo) avdVar;
        Object a = auoVar.a();
        int a2 = auoVar.a((auo) a, bArr, i, i2, i3, aspVar);
        auoVar.c((auo) a);
        aspVar.c = a;
        return a2;
    }

    static int a(int i, byte[] bArr, int i2, int i3, zzekp<?> zzekpVar, asp aspVar) {
        att attVar = (att) zzekpVar;
        int a = a(bArr, i2, aspVar);
        attVar.d(aspVar.a);
        while (a < i3) {
            int a2 = a(bArr, a, aspVar);
            if (i != aspVar.a) {
                break;
            }
            a = a(bArr, a2, aspVar);
            attVar.d(aspVar.a);
        }
        return a;
    }

    static int a(byte[] bArr, int i, zzekp<?> zzekpVar, asp aspVar) throws IOException {
        att attVar = (att) zzekpVar;
        int a = a(bArr, i, aspVar);
        int i2 = aspVar.a + a;
        while (a < i2) {
            a = a(bArr, a, aspVar);
            attVar.d(aspVar.a);
        }
        if (a != i2) {
            throw zzeks.a();
        }
        return a;
    }

    static int a(avd<?> avdVar, int i, byte[] bArr, int i2, int i3, zzekp<?> zzekpVar, asp aspVar) throws IOException {
        int a = a(avdVar, bArr, i2, i3, aspVar);
        zzekpVar.add(aspVar.c);
        while (a < i3) {
            int a2 = a(bArr, a, aspVar);
            if (i != aspVar.a) {
                break;
            }
            a = a(avdVar, bArr, a2, i3, aspVar);
            zzekpVar.add(aspVar.c);
        }
        return a;
    }

    static int a(int i, byte[] bArr, int i2, int i3, zzeni zzeniVar, asp aspVar) throws zzeks {
        if ((i >>> 3) == 0) {
            throw zzeks.d();
        }
        int i4 = i & 7;
        if (i4 != 5) {
            switch (i4) {
                case 0:
                    int b = b(bArr, i2, aspVar);
                    zzeniVar.a(i, Long.valueOf(aspVar.b));
                    return b;
                case 1:
                    zzeniVar.a(i, Long.valueOf(b(bArr, i2)));
                    return i2 + 8;
                case 2:
                    int a = a(bArr, i2, aspVar);
                    int i5 = aspVar.a;
                    if (i5 < 0) {
                        throw zzeks.b();
                    }
                    if (i5 > bArr.length - a) {
                        throw zzeks.a();
                    }
                    if (i5 == 0) {
                        zzeniVar.a(i, zzeiu.a);
                    } else {
                        zzeniVar.a(i, zzeiu.a(bArr, a, i5));
                    }
                    return a + i5;
                case 3:
                    zzeni b2 = zzeni.b();
                    int i6 = (i & (-8)) | 4;
                    int i7 = 0;
                    while (true) {
                        if (i2 < i3) {
                            int a2 = a(bArr, i2, aspVar);
                            int i8 = aspVar.a;
                            if (i8 != i6) {
                                i7 = i8;
                                i2 = a(i8, bArr, a2, i3, b2, aspVar);
                            } else {
                                i7 = i8;
                                i2 = a2;
                            }
                        }
                    }
                    if (i2 > i3 || i7 != i6) {
                        throw zzeks.h();
                    }
                    zzeniVar.a(i, b2);
                    return i2;
                default:
                    throw zzeks.d();
            }
        }
        zzeniVar.a(i, Integer.valueOf(a(bArr, i2)));
        return i2 + 4;
    }

    static int a(int i, byte[] bArr, int i2, int i3, asp aspVar) throws zzeks {
        if ((i >>> 3) == 0) {
            throw zzeks.d();
        }
        int i4 = i & 7;
        if (i4 == 5) {
            return i2 + 4;
        }
        switch (i4) {
            case 0:
                return b(bArr, i2, aspVar);
            case 1:
                return i2 + 8;
            case 2:
                return a(bArr, i2, aspVar) + aspVar.a;
            case 3:
                int i5 = (i & (-8)) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = a(bArr, i2, aspVar);
                    i6 = aspVar.a;
                    if (i6 == i5) {
                        if (i2 <= i3 || i6 != i5) {
                            throw zzeks.h();
                        }
                        return i2;
                    }
                    i2 = a(i6, bArr, i2, i3, aspVar);
                }
                if (i2 <= i3) {
                }
                throw zzeks.h();
            default:
                throw zzeks.d();
        }
    }
}
