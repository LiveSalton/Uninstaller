package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class asa implements zzdzt {
    private final ary a;
    private final ary b;

    public asa(byte[] bArr) throws InvalidKeyException {
        this.a = a(bArr, 1);
        this.b = a(bArr, 0);
    }

    abstract ary a(byte[] bArr, int i) throws InvalidKeyException;

    @Override // com.google.android.gms.internal.ads.zzdzt
    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > (Integer.MAX_VALUE - this.a.a()) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + this.a.a() + 16);
        if (allocate.remaining() < bArr.length + this.a.a() + 16) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        int position = allocate.position();
        this.a.a(allocate, bArr);
        allocate.position(position);
        byte[] bArr3 = new byte[this.a.a()];
        allocate.get(bArr3);
        allocate.limit(allocate.limit() - 16);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArr4 = new byte[32];
        this.b.a(bArr3, 0).get(bArr4);
        int length = bArr2.length % 16 == 0 ? bArr2.length : (bArr2.length + 16) - (bArr2.length % 16);
        int remaining = allocate.remaining();
        int i = remaining % 16;
        int i2 = (i == 0 ? remaining : (remaining + 16) - i) + length;
        ByteBuffer order = ByteBuffer.allocate(i2 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(bArr2);
        order.position(length);
        order.put(allocate);
        order.position(i2);
        order.putLong(bArr2.length);
        order.putLong(remaining);
        byte[] a = asc.a(bArr4, order.array());
        allocate.limit(allocate.limit() + 16);
        allocate.put(a);
        return allocate.array();
    }
}
