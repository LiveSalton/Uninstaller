package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeca implements zzdzt {
    private static final ThreadLocal<Cipher> a = new api();
    private final SecretKey b;

    public zzeca(byte[] bArr) throws GeneralSecurityException {
        zzeic.a(bArr.length);
        this.b = new SecretKeySpec(bArr, "AES");
    }

    @Override // com.google.android.gms.internal.ads.zzdzt
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + 12 + 16];
        byte[] a2 = zzehx.a(12);
        System.arraycopy(a2, 0, bArr3, 0, 12);
        a.get().init(1, this.b, a(a2, 0, a2.length));
        if (bArr2 != null && bArr2.length != 0) {
            a.get().updateAAD(bArr2);
        }
        int doFinal = a.get().doFinal(bArr, 0, bArr.length, bArr3, 12);
        if (doFinal != bArr.length + 16) {
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(doFinal - bArr.length)));
        }
        return bArr3;
    }

    private static AlgorithmParameterSpec a(byte[] bArr, int i, int i2) throws GeneralSecurityException {
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            return new GCMParameterSpec(128, bArr, 0, i2);
        } catch (ClassNotFoundException unused) {
            if (zzehz.a()) {
                return new IvParameterSpec(bArr, 0, i2);
            }
            throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
        }
    }
}
