package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class awe {
    public static boolean d(byte b) {
        return b >= 0;
    }

    public static boolean e(byte b) {
        return b < -32;
    }

    public static boolean f(byte b) {
        return b < -16;
    }

    private static boolean g(byte b) {
        return b > -65;
    }

    public static void b(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    public static void b(byte b, byte b2, char[] cArr, int i) throws zzeks {
        if (b < -62 || g(b2)) {
            throw zzeks.i();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & 63));
    }

    public static void b(byte b, byte b2, byte b3, char[] cArr, int i) throws zzeks {
        if (g(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || g(b3)))) {
            throw zzeks.i();
        }
        cArr[i] = (char) (((b & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63));
    }

    public static void b(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws zzeks {
        if (g(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || g(b3) || g(b4)) {
            throw zzeks.i();
        }
        int i2 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
        cArr[i] = (char) (55232 + (i2 >>> 10));
        cArr[i + 1] = (char) (56320 + (i2 & 1023));
    }
}
