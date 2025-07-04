package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzehc {
    private ECPublicKey a;

    public zzehc(ECPublicKey eCPublicKey) {
        this.a = eCPublicKey;
    }

    public final zzehb a(String str, byte[] bArr, byte[] bArr2, int i, zzehf zzehfVar) throws GeneralSecurityException {
        byte[] bArr3;
        KeyPair a = zzehe.a(this.a.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) a.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) a.getPrivate();
        ECPublicKey eCPublicKey2 = this.a;
        try {
            ECParameterSpec params = eCPublicKey2.getParams();
            ECParameterSpec params2 = eCPrivateKey.getParams();
            int i2 = 1;
            if (!(params.getCurve().equals(params2.getCurve()) && params.getGenerator().equals(params2.getGenerator()) && params.getOrder().equals(params2.getOrder()) && params.getCofactor() == params2.getCofactor())) {
                throw new GeneralSecurityException("invalid public key spec");
            }
            byte[] a2 = zzehe.a(eCPrivateKey, eCPublicKey2.getW());
            EllipticCurve curve = eCPublicKey.getParams().getCurve();
            ECPoint w = eCPublicKey.getW();
            zzehe.a(w, curve);
            int bitLength = (zzehe.a(curve).subtract(BigInteger.ONE).bitLength() + 7) / 8;
            switch (zzehfVar) {
                case UNCOMPRESSED:
                    int i3 = (2 * bitLength) + 1;
                    bArr3 = new byte[i3];
                    byte[] byteArray = w.getAffineX().toByteArray();
                    byte[] byteArray2 = w.getAffineY().toByteArray();
                    System.arraycopy(byteArray2, 0, bArr3, i3 - byteArray2.length, byteArray2.length);
                    System.arraycopy(byteArray, 0, bArr3, (bitLength + 1) - byteArray.length, byteArray.length);
                    bArr3[0] = 4;
                    break;
                case DO_NOT_USE_CRUNCHY_UNCOMPRESSED:
                    int i4 = 2 * bitLength;
                    bArr3 = new byte[i4];
                    byte[] byteArray3 = w.getAffineX().toByteArray();
                    if (byteArray3.length > bitLength) {
                        byteArray3 = Arrays.copyOfRange(byteArray3, byteArray3.length - bitLength, byteArray3.length);
                    }
                    byte[] byteArray4 = w.getAffineY().toByteArray();
                    if (byteArray4.length > bitLength) {
                        byteArray4 = Arrays.copyOfRange(byteArray4, byteArray4.length - bitLength, byteArray4.length);
                    }
                    System.arraycopy(byteArray4, 0, bArr3, i4 - byteArray4.length, byteArray4.length);
                    System.arraycopy(byteArray3, 0, bArr3, bitLength - byteArray3.length, byteArray3.length);
                    break;
                case COMPRESSED:
                    int i5 = bitLength + 1;
                    byte[] bArr4 = new byte[i5];
                    byte[] byteArray5 = w.getAffineX().toByteArray();
                    System.arraycopy(byteArray5, 0, bArr4, i5 - byteArray5.length, byteArray5.length);
                    bArr4[0] = (byte) (w.getAffineY().testBit(0) ? 3 : 2);
                    bArr3 = bArr4;
                    break;
                default:
                    String valueOf = String.valueOf(zzehfVar);
                    StringBuilder sb = new StringBuilder(15 + String.valueOf(valueOf).length());
                    sb.append("invalid format:");
                    sb.append(valueOf);
                    throw new GeneralSecurityException(sb.toString());
            }
            byte[] a3 = zzegr.a(bArr3, a2);
            Mac a4 = zzehh.b.a(str);
            if (i > 255 * a4.getMacLength()) {
                throw new GeneralSecurityException("size too large");
            }
            if (bArr == null || bArr.length == 0) {
                a4.init(new SecretKeySpec(new byte[a4.getMacLength()], str));
            } else {
                a4.init(new SecretKeySpec(bArr, str));
            }
            byte[] doFinal = a4.doFinal(a3);
            byte[] bArr5 = new byte[i];
            a4.init(new SecretKeySpec(doFinal, str));
            byte[] bArr6 = new byte[0];
            int i6 = 0;
            while (true) {
                a4.update(bArr6);
                a4.update(bArr2);
                a4.update((byte) i2);
                bArr6 = a4.doFinal();
                if (bArr6.length + i6 < i) {
                    System.arraycopy(bArr6, 0, bArr5, i6, bArr6.length);
                    i6 += bArr6.length;
                    i2++;
                } else {
                    System.arraycopy(bArr6, 0, bArr5, i6, i - i6);
                    return new zzehb(bArr3, bArr5);
                }
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new GeneralSecurityException(e.toString());
        }
    }
}
