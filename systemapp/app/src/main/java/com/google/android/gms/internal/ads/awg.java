package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class awg extends awd {
    awg() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r13[r14] > (-65)) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x007e, code lost:
    
        if (r13[r14] > (-65)) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0043, code lost:
    
        if (r13[r14] > (-65)) goto L148;
     */
    @Override // com.google.android.gms.internal.ads.awd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int a(int r12, byte[] r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.awg.a(int, byte[], int, int):int");
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
            byte b = bArr[i];
            d3 = awe.d(b);
            if (!d3) {
                break;
            }
            i++;
            awe.b(b, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            d = awe.d(b2);
            if (d) {
                int i7 = i5 + 1;
                awe.b(b2, cArr, i5);
                while (i6 < i3) {
                    byte b3 = bArr[i6];
                    d2 = awe.d(b3);
                    if (!d2) {
                        break;
                    }
                    i6++;
                    awe.b(b3, cArr, i7);
                    i7++;
                }
                i = i6;
                i5 = i7;
            } else {
                e = awe.e(b2);
                if (!e) {
                    f = awe.f(b2);
                    if (f) {
                        if (i6 < i3 - 1) {
                            int i8 = i6 + 1;
                            awe.b(b2, bArr[i6], bArr[i8], cArr, i5);
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
                        byte b4 = bArr[i6];
                        int i10 = i9 + 1;
                        awe.b(b2, b4, bArr[i9], bArr[i10], cArr, i5);
                        i = i10 + 1;
                        i5 = i5 + 1 + 1;
                    }
                } else if (i6 < i3) {
                    awe.b(b2, bArr[i6], cArr, i5);
                    i = i6 + 1;
                    i5++;
                } else {
                    throw zzeks.i();
                }
            }
        }
        return new String(cArr, 0, i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r11 + r0;
     */
    @Override // com.google.android.gms.internal.ads.awd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int a(java.lang.CharSequence r9, byte[] r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.awg.a(java.lang.CharSequence, byte[], int, int):int");
    }
}
