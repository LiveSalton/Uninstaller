package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbq {
    public static int a(byte b) {
        return b < 0 ? b + 256 : b;
    }

    public static long a(ByteBuffer byteBuffer) {
        long j = byteBuffer.getInt();
        return j < 0 ? j + 4294967296L : j;
    }

    public static int b(ByteBuffer byteBuffer) {
        return 0 + (a(byteBuffer.get()) << 8) + a(byteBuffer.get());
    }

    public static long c(ByteBuffer byteBuffer) {
        long a = (a(byteBuffer) << 32) + 0;
        if (a < 0) {
            throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
        }
        return a + a(byteBuffer);
    }

    public static double d(ByteBuffer byteBuffer) {
        byteBuffer.get(new byte[4]);
        return ((((0 | ((r0[0] << 24) & (-16777216))) | ((r0[1] << 16) & 16711680)) | ((r0[2] << 8) & 65280)) | (r0[3] & 255)) / 65536.0d;
    }

    public static double e(ByteBuffer byteBuffer) {
        byteBuffer.get(new byte[4]);
        return ((((0 | ((r0[0] << 24) & (-16777216))) | ((r0[1] << 16) & 16711680)) | ((r0[2] << 8) & 65280)) | (r0[3] & 255)) / 1.073741824E9d;
    }

    public static String f(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
