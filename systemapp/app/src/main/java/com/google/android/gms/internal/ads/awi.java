package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class awi extends awd {
    awi() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0085, code lost:
    
        if (com.google.android.gms.internal.ads.avz.a(r25, r8) > (-65)) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x00c9, code lost:
    
        if (com.google.android.gms.internal.ads.avz.a(r25, r8) > (-65)) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0059, code lost:
    
        if (com.google.android.gms.internal.ads.avz.a(r25, r8) > (-65)) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x017f, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0123, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.ads.awd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int a(int r24, byte[] r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.awi.a(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.ads.awd
    final String b(byte[] bArr, int i, int i2) throws zzeks {
        boolean d;
        boolean d2;
        boolean e;
        boolean f;
        boolean d3;
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte a = avz.a(bArr, i);
            d3 = awe.d(a);
            if (!d3) {
                break;
            }
            i++;
            awe.b(a, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte a2 = avz.a(bArr, i);
            d = awe.d(a2);
            if (d) {
                int i7 = i5 + 1;
                awe.b(a2, cArr, i5);
                while (i6 < i3) {
                    byte a3 = avz.a(bArr, i6);
                    d2 = awe.d(a3);
                    if (!d2) {
                        break;
                    }
                    i6++;
                    awe.b(a3, cArr, i7);
                    i7++;
                }
                i = i6;
                i5 = i7;
            } else {
                e = awe.e(a2);
                if (!e) {
                    f = awe.f(a2);
                    if (f) {
                        if (i6 < i3 - 1) {
                            int i8 = i6 + 1;
                            awe.b(a2, avz.a(bArr, i6), avz.a(bArr, i8), cArr, i5);
                            i = i8 + 1;
                            i5++;
                        } else {
                            throw zzeks.i();
                        }
                    } else {
                        if (i6 >= i3 - 2) {
                            throw zzeks.i();
                        }
                        int i9 = i6 + 1;
                        byte a4 = avz.a(bArr, i6);
                        int i10 = i9 + 1;
                        awe.b(a2, a4, avz.a(bArr, i9), avz.a(bArr, i10), cArr, i5);
                        i = i10 + 1;
                        i5 = i5 + 1 + 1;
                    }
                } else if (i6 < i3) {
                    awe.b(a2, avz.a(bArr, i6), cArr, i5);
                    i = i6 + 1;
                    i5++;
                } else {
                    throw zzeks.i();
                }
            }
        }
        return new String(cArr, 0, i5);
    }

    @Override // com.google.android.gms.internal.ads.awd
    final int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        char charAt;
        long j = i;
        long j2 = i2 + j;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (i4 < length && (charAt = charSequence.charAt(i4)) < 128) {
            avz.a(bArr, j, (byte) charAt);
            i4++;
            j = 1 + j;
        }
        if (i4 == length) {
            return (int) j;
        }
        while (i4 < length) {
            char charAt3 = charSequence.charAt(i4);
            if (charAt3 < 128 && j < j2) {
                avz.a(bArr, j, (byte) charAt3);
                j++;
            } else if (charAt3 < 2048 && j <= j2 - 2) {
                long j3 = j + 1;
                avz.a(bArr, j, (byte) (960 | (charAt3 >>> 6)));
                j = j3 + 1;
                avz.a(bArr, j3, (byte) ((charAt3 & '?') | 128));
            } else {
                if ((charAt3 >= 55296 && 57343 >= charAt3) || j > j2 - 3) {
                    if (j <= j2 - 4) {
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char charAt4 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(charAt3, charAt4)) {
                                int codePoint = Character.toCodePoint(charAt3, charAt4);
                                long j4 = j + 1;
                                avz.a(bArr, j, (byte) (240 | (codePoint >>> 18)));
                                long j5 = j4 + 1;
                                avz.a(bArr, j4, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j6 = j5 + 1;
                                avz.a(bArr, j5, (byte) (((codePoint >>> 6) & 63) | 128));
                                j = j6 + 1;
                                avz.a(bArr, j6, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            }
                        } else {
                            i5 = i4;
                        }
                        throw new awf(i5 - 1, length);
                    }
                    if (55296 <= charAt3 && charAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                        throw new awf(i4, length);
                    }
                    StringBuilder sb2 = new StringBuilder(46);
                    sb2.append("Failed writing ");
                    sb2.append(charAt3);
                    sb2.append(" at index ");
                    sb2.append(j);
                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                }
                long j7 = j + 1;
                avz.a(bArr, j, (byte) (480 | (charAt3 >>> '\f')));
                long j8 = j7 + 1;
                avz.a(bArr, j7, (byte) (((charAt3 >>> 6) & 63) | 128));
                avz.a(bArr, j8, (byte) ((charAt3 & '?') | 128));
                j = j8 + 1;
            }
            i4++;
        }
        return (int) j;
    }

    private static int a(byte[] bArr, int i, long j, int i2) {
        int b;
        int b2;
        int b3;
        switch (i2) {
            case 0:
                b = awc.b(i);
                return b;
            case 1:
                b2 = awc.b(i, avz.a(bArr, j));
                return b2;
            case 2:
                b3 = awc.b(i, avz.a(bArr, j), avz.a(bArr, j + 1));
                return b3;
            default:
                throw new AssertionError();
        }
    }
}
