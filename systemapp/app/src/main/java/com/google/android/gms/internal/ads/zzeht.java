package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeht implements zzedb {
    private final SecretKey a;
    private byte[] b;
    private byte[] c;

    private static Cipher a() throws GeneralSecurityException {
        return zzehh.a.a("AES/ECB/NoPadding");
    }

    public zzeht(byte[] bArr) throws GeneralSecurityException {
        zzeic.a(bArr.length);
        this.a = new SecretKeySpec(bArr, "AES");
        Cipher a = a();
        a.init(1, this.a);
        this.b = arx.a(a.doFinal(new byte[16]));
        this.c = arx.a(this.b);
    }

    @Override // com.google.android.gms.internal.ads.zzedb
    public final byte[] a(byte[] bArr, int i) throws GeneralSecurityException {
        byte[] a;
        if (i > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        Cipher a2 = a();
        a2.init(1, this.a);
        int max = Math.max(1, (int) Math.ceil(bArr.length / 16.0d));
        if ((max << 4) == bArr.length) {
            a = zzegr.a(bArr, (max - 1) << 4, this.b, 0, 16);
        } else {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) << 4, bArr.length);
            if (copyOfRange.length >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
            copyOf[copyOfRange.length] = Byte.MIN_VALUE;
            a = zzegr.a(copyOf, this.c);
        }
        byte[] bArr2 = new byte[16];
        for (int i2 = 0; i2 < max - 1; i2++) {
            bArr2 = a2.doFinal(zzegr.a(bArr2, 0, bArr, i2 << 4, 16));
        }
        return Arrays.copyOf(a2.doFinal(zzegr.a(a, bArr2)), i);
    }
}
