package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzegl implements zzdzt {
    private static final ThreadLocal<Cipher> a = new arv();
    private static final ThreadLocal<Cipher> b = new aru();
    private final byte[] c;
    private final byte[] d;
    private final SecretKeySpec e;
    private final int f;

    public zzegl(byte[] bArr, int i) throws GeneralSecurityException {
        if (i != 12 && i != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.f = i;
        zzeic.a(bArr.length);
        this.e = new SecretKeySpec(bArr, "AES");
        Cipher cipher = a.get();
        cipher.init(1, this.e);
        this.c = a(cipher.doFinal(new byte[16]));
        this.d = a(this.c);
    }

    private static byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            int i2 = i + 1;
            bArr2[i] = (byte) ((bArr[i] << 1) ^ ((bArr[i2] & 255) >>> 7));
            i = i2;
        }
        bArr2[15] = (byte) ((bArr[15] << 1) ^ ((bArr[0] & 128) != 0 ? 135 : 0));
        return bArr2;
    }

    private final byte[] a(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(b(bArr3, this.c));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        byte[] bArr4 = doFinal;
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                bArr4[i5] = (byte) (bArr4[i5] ^ bArr[(i2 + i4) + i5]);
            }
            bArr4 = cipher.doFinal(bArr4);
            i4 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = b(copyOfRange, this.c);
        } else {
            byte[] copyOf = Arrays.copyOf(this.d, 16);
            for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(b(bArr4, bArr2));
    }

    @Override // com.google.android.gms.internal.ads.zzdzt
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > (Integer.MAX_VALUE - this.f) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[this.f + bArr.length + 16];
        byte[] a2 = zzehx.a(this.f);
        System.arraycopy(a2, 0, bArr3, 0, this.f);
        Cipher cipher = a.get();
        cipher.init(1, this.e);
        byte[] a3 = a(cipher, 0, a2, 0, a2.length);
        byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
        byte[] a4 = a(cipher, 1, bArr4, 0, bArr4.length);
        Cipher cipher2 = b.get();
        cipher2.init(1, this.e, new IvParameterSpec(a3));
        cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.f);
        byte[] a5 = a(cipher, 2, bArr3, this.f, bArr.length);
        int length = bArr.length + this.f;
        for (int i = 0; i < 16; i++) {
            bArr3[length + i] = (byte) ((a4[i] ^ a3[i]) ^ a5[i]);
        }
        return bArr3;
    }
}
