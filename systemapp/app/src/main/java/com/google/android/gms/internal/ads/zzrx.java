package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzrx extends zzrq {
    private MessageDigest b;

    @Override // com.google.android.gms.internal.ads.zzrq
    public final byte[] a(String str) {
        byte[] bArr;
        String[] split = str.split(" ");
        int i = 4;
        if (split.length == 1) {
            int a = zzru.a(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(a);
            bArr = allocate.array();
        } else if (split.length < 5) {
            byte[] bArr2 = new byte[split.length << 1];
            for (int i2 = 0; i2 < split.length; i2++) {
                int a2 = zzru.a(split[i2]);
                int i3 = (a2 >> 16) ^ (65535 & a2);
                byte[] bArr3 = {(byte) i3, (byte) (i3 >> 8)};
                int i4 = i2 << 1;
                bArr2[i4] = bArr3[0];
                bArr2[i4 + 1] = bArr3[1];
            }
            bArr = bArr2;
        } else {
            byte[] bArr4 = new byte[split.length];
            for (int i5 = 0; i5 < split.length; i5++) {
                int a3 = zzru.a(split[i5]);
                bArr4[i5] = (byte) ((a3 >> 24) ^ (((a3 & 255) ^ ((a3 >> 8) & 255)) ^ ((a3 >> 16) & 255)));
            }
            bArr = bArr4;
        }
        this.b = a();
        synchronized (this.a) {
            if (this.b == null) {
                return new byte[0];
            }
            this.b.reset();
            this.b.update(bArr);
            byte[] digest = this.b.digest();
            if (digest.length <= 4) {
                i = digest.length;
            }
            byte[] bArr5 = new byte[i];
            System.arraycopy(digest, 0, bArr5, 0, bArr5.length);
            return bArr5;
        }
    }
}
