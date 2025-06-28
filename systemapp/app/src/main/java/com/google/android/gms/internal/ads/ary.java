package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class ary implements zzehr {
    private static final int[] b = b(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});
    int[] a;
    private final int c;

    ary(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.a = b(bArr);
        this.c = i;
    }

    private static int a(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    abstract int a();

    abstract int[] a(int[] iArr, int i);

    @Override // com.google.android.gms.internal.ads.zzehr
    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length > Integer.MAX_VALUE - a()) {
            throw new GeneralSecurityException("plaintext too long");
        }
        ByteBuffer allocate = ByteBuffer.allocate(a() + bArr.length);
        a(allocate, bArr);
        return allocate.array();
    }

    final void a(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() - a() < bArr.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        byte[] a = zzehx.a(a());
        byteBuffer.put(a);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        int remaining = wrap.remaining();
        int i = (remaining / 64) + 1;
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer a2 = a(a, this.c + i2);
            if (i2 == i - 1) {
                zzegr.a(byteBuffer, wrap, a2, remaining % 64);
            } else {
                zzegr.a(byteBuffer, wrap, a2, 64);
            }
        }
    }

    final ByteBuffer a(byte[] bArr, int i) {
        int[] a = a(b(bArr), i);
        int[] iArr = (int[]) a.clone();
        a(iArr);
        for (int i2 = 0; i2 < a.length; i2++) {
            a[i2] = a[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(a, 0, 16);
        return order;
    }

    static void a(int[] iArr, int[] iArr2) {
        System.arraycopy(b, 0, iArr, 0, b.length);
        System.arraycopy(iArr2, 0, iArr, b.length, 8);
    }

    static void a(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            a(iArr, 0, 4, 8, 12);
            a(iArr, 1, 5, 9, 13);
            a(iArr, 2, 6, 10, 14);
            a(iArr, 3, 7, 11, 15);
            a(iArr, 0, 5, 10, 15);
            a(iArr, 1, 6, 11, 12);
            a(iArr, 2, 7, 8, 13);
            a(iArr, 3, 4, 9, 14);
        }
    }

    private static void a(int[] iArr, int i, int i2, int i3, int i4) {
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = a(iArr[i4] ^ iArr[i], 16);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = a(iArr[i2] ^ iArr[i3], 12);
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = a(iArr[i] ^ iArr[i4], 8);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = a(iArr[i2] ^ iArr[i3], 7);
    }

    private static int[] b(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }
}
