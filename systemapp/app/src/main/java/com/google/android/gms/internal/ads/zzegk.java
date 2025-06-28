package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzegk implements zzehr {
    private static final ThreadLocal<Cipher> a = new art();
    private final SecretKeySpec b;
    private final int c;
    private final int d;

    public zzegk(byte[] bArr, int i) throws GeneralSecurityException {
        zzeic.a(bArr.length);
        this.b = new SecretKeySpec(bArr, "AES");
        this.d = a.get().getBlockSize();
        if (i < 12 || i > this.d) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.c = i;
    }

    @Override // com.google.android.gms.internal.ads.zzehr
    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length > Integer.MAX_VALUE - this.c) {
            int i = Integer.MAX_VALUE - this.c;
            StringBuilder sb = new StringBuilder(43);
            sb.append("plaintext length can not exceed ");
            sb.append(i);
            throw new GeneralSecurityException(sb.toString());
        }
        byte[] bArr2 = new byte[this.c + bArr.length];
        byte[] a2 = zzehx.a(this.c);
        System.arraycopy(a2, 0, bArr2, 0, this.c);
        int length = bArr.length;
        int i2 = this.c;
        Cipher cipher = a.get();
        byte[] bArr3 = new byte[this.d];
        System.arraycopy(a2, 0, bArr3, 0, this.c);
        cipher.init(1, this.b, new IvParameterSpec(bArr3));
        if (cipher.doFinal(bArr, 0, length, bArr2, i2) != length) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        return bArr2;
    }
}
