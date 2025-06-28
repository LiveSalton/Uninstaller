package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzekk {
    public static final byte[] b;
    private static final ByteBuffer d;
    private static final zzejj e;
    static final Charset a = Charset.forName("UTF-8");
    private static final Charset c = Charset.forName("ISO-8859-1");

    public static int a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    static <T> T a(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    static <T> T a(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
        return t;
    }

    public static boolean a(byte[] bArr) {
        return awc.a(bArr);
    }

    public static String b(byte[] bArr) {
        return new String(bArr, a);
    }

    public static int c(byte[] bArr) {
        int length = bArr.length;
        int a2 = a(length, bArr, 0, length);
        if (a2 == 0) {
            return 1;
        }
        return a2;
    }

    static int a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }

    static boolean a(zzels zzelsVar) {
        if (!(zzelsVar instanceof zzeim)) {
            return false;
        }
        return false;
    }

    static Object a(Object obj, Object obj2) {
        return ((zzels) obj).u().a((zzels) obj2).f();
    }

    static {
        byte[] bArr = new byte[0];
        b = bArr;
        d = ByteBuffer.wrap(bArr);
        byte[] bArr2 = b;
        e = zzejj.a(bArr2, 0, bArr2.length, false);
    }
}
