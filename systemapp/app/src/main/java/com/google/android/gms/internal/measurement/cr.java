package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
final class cr {
    private static final cs a;

    public static boolean a(byte[] bArr) {
        return a.a(bArr, 0, bArr.length);
    }

    public static int b(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static int b(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static int b(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static boolean a(byte[] bArr, int i, int i2) {
        return a.a(bArr, i, i2);
    }

    public static int c(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                return b(b);
            case 1:
                return b(b, bArr[i]);
            case 2:
                return b(b, bArr[i], bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }

    static {
        cs ctVar;
        if ((co.a() && co.b()) && !ad.a()) {
            ctVar = new cv();
        } else {
            ctVar = new ct();
        }
        a = ctVar;
    }
}
