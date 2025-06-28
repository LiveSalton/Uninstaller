package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzehw implements zzedb {
    private final ThreadLocal<Mac> a = new asd(this);
    private final String b;
    private final Key c;
    private final int d;

    public zzehw(String str, Key key) throws GeneralSecurityException {
        this.b = str;
        this.c = key;
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1823053428) {
            if (hashCode != 392315118) {
                if (hashCode != 392316170) {
                    if (hashCode == 392317873 && str.equals("HMACSHA512")) {
                        c = 3;
                    }
                } else if (str.equals("HMACSHA384")) {
                    c = 2;
                }
            } else if (str.equals("HMACSHA256")) {
                c = 1;
            }
        } else if (str.equals("HMACSHA1")) {
            c = 0;
        }
        switch (c) {
            case 0:
                this.d = 20;
                break;
            case 1:
                this.d = 32;
                break;
            case 2:
                this.d = 48;
                break;
            case 3:
                this.d = 64;
                break;
            default:
                String valueOf = String.valueOf(str);
                throw new NoSuchAlgorithmException(valueOf.length() != 0 ? "unknown Hmac algorithm: ".concat(valueOf) : new String("unknown Hmac algorithm: "));
        }
        this.a.get();
    }

    @Override // com.google.android.gms.internal.ads.zzedb
    public final byte[] a(byte[] bArr, int i) throws GeneralSecurityException {
        if (i > this.d) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        this.a.get().update(bArr);
        return Arrays.copyOf(this.a.get().doFinal(), i);
    }
}
