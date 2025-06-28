package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
final class asc {
    private static long a(byte[] bArr, int i) {
        return (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16)) & 4294967295L;
    }

    private static long a(byte[] bArr, int i, int i2) {
        return (a(bArr, i) >> i2) & 67108863;
    }

    private static void a(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) (255 & j);
            i2++;
            j >>= 8;
        }
    }

    static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        long a = a(bArr, 0, 0) & 67108863;
        int i = 2;
        int i2 = 3;
        long a2 = a(bArr, 3, 2) & 67108611;
        long a3 = a(bArr, 6, 4) & 67092735;
        long a4 = a(bArr, 9, 6) & 66076671;
        long a5 = a(bArr, 12, 8) & 1048575;
        long j = a2 * 5;
        long j2 = a3 * 5;
        long j3 = a4 * 5;
        long j4 = a5 * 5;
        byte[] bArr3 = new byte[17];
        long j5 = 0;
        int i3 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        while (i3 < bArr2.length) {
            int min = Math.min(16, bArr2.length - i3);
            System.arraycopy(bArr2, i3, bArr3, 0, min);
            bArr3[min] = 1;
            if (min != 16) {
                Arrays.fill(bArr3, min + 1, 17, (byte) 0);
            }
            long a6 = j9 + a(bArr3, 0, 0);
            long a7 = j5 + a(bArr3, i2, i);
            long a8 = j6 + a(bArr3, 6, 4);
            long a9 = j7 + a(bArr3, 9, 6);
            long a10 = j8 + (a(bArr3, 12, 8) | (bArr3[16] << 24));
            long j10 = (a6 * a) + (a7 * j4) + (a8 * j3) + (a9 * j2) + (a10 * j);
            long j11 = (a6 * a2) + (a7 * a) + (a8 * j4) + (a9 * j3) + (a10 * j2);
            long j12 = (a6 * a3) + (a7 * a2) + (a8 * a) + (a9 * j4) + (a10 * j3);
            long j13 = (a6 * a4) + (a7 * a3) + (a8 * a2) + (a9 * a) + (a10 * j4);
            long j14 = j11 + (j10 >> 26);
            long j15 = j12 + (j14 >> 26);
            long j16 = j13 + (j15 >> 26);
            long j17 = (a6 * a5) + (a7 * a4) + (a8 * a3) + (a9 * a2) + (a10 * a) + (j16 >> 26);
            long j18 = (j10 & 67108863) + ((j17 >> 26) * 5);
            j5 = (j14 & 67108863) + (j18 >> 26);
            i3 += 16;
            j6 = j15 & 67108863;
            j7 = j16 & 67108863;
            j8 = j17 & 67108863;
            j9 = j18 & 67108863;
            i = 2;
            i2 = 3;
        }
        long j19 = j6 + (j5 >> 26);
        long j20 = j19 & 67108863;
        long j21 = j7 + (j19 >> 26);
        long j22 = j21 & 67108863;
        long j23 = j8 + (j21 >> 26);
        long j24 = j23 & 67108863;
        long j25 = j9 + ((j23 >> 26) * 5);
        long j26 = j25 & 67108863;
        long j27 = (j5 & 67108863) + (j25 >> 26);
        long j28 = j26 + 5;
        long j29 = j28 & 67108863;
        long j30 = (j28 >> 26) + j27;
        long j31 = j20 + (j30 >> 26);
        long j32 = j22 + (j31 >> 26);
        long j33 = (j24 + (j32 >> 26)) - 67108864;
        long j34 = j33 >> 63;
        long j35 = j26 & j34;
        long j36 = j27 & j34;
        long j37 = j20 & j34;
        long j38 = j22 & j34;
        long j39 = j24 & j34;
        long j40 = ~j34;
        long j41 = (j30 & 67108863 & j40) | j36;
        long j42 = (j31 & 67108863 & j40) | j37;
        long j43 = (j32 & 67108863 & j40) | j38;
        long j44 = (j33 & j40) | j39;
        long j45 = ((j41 << 26) | j35 | (j29 & j40)) & 4294967295L;
        long j46 = ((j41 >> 6) | (j42 << 20)) & 4294967295L;
        long j47 = ((j42 >> 12) | (j43 << 14)) & 4294967295L;
        long j48 = ((j43 >> 18) | (j44 << 8)) & 4294967295L;
        long a11 = j45 + a(bArr, 16);
        long j49 = a11 & 4294967295L;
        long a12 = j46 + a(bArr, 20) + (a11 >> 32);
        long j50 = a12 & 4294967295L;
        long a13 = j47 + a(bArr, 24) + (a12 >> 32);
        long j51 = a13 & 4294967295L;
        long a14 = (j48 + a(bArr, 28) + (a13 >> 32)) & 4294967295L;
        byte[] bArr4 = new byte[16];
        a(bArr4, j49, 0);
        a(bArr4, j50, 4);
        a(bArr4, j51, 8);
        a(bArr4, a14, 12);
        return bArr4;
    }
}
