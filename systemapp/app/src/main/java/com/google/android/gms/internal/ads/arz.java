package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;

/* compiled from: source */
/* loaded from: classes.dex */
final class arz extends ary {
    arz(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    @Override // com.google.android.gms.internal.ads.ary
    final int a() {
        return 12;
    }

    @Override // com.google.android.gms.internal.ads.ary
    final int[] a(int[] iArr, int i) {
        if (iArr.length != 3) {
            throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length << 5)));
        }
        int[] iArr2 = new int[16];
        ary.a(iArr2, this.a);
        iArr2[12] = i;
        System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
        return iArr2;
    }
}
