package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
final class asf extends ary {
    asf(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    @Override // com.google.android.gms.internal.ads.ary
    final int a() {
        return 24;
    }

    @Override // com.google.android.gms.internal.ads.ary
    final int[] a(int[] iArr, int i) {
        if (iArr.length != 6) {
            throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length << 5)));
        }
        int[] iArr2 = new int[16];
        int[] iArr3 = new int[16];
        ary.a(iArr3, this.a);
        iArr3[12] = iArr[0];
        iArr3[13] = iArr[1];
        iArr3[14] = iArr[2];
        iArr3[15] = iArr[3];
        ary.a(iArr3);
        iArr3[4] = iArr3[12];
        iArr3[5] = iArr3[13];
        iArr3[6] = iArr3[14];
        iArr3[7] = iArr3[15];
        ary.a(iArr2, Arrays.copyOf(iArr3, 8));
        iArr2[12] = i;
        iArr2[13] = 0;
        iArr2[14] = iArr[4];
        iArr2[15] = iArr[5];
        return iArr2;
    }
}
