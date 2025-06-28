package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* compiled from: source */
/* loaded from: classes.dex */
final class arv extends ThreadLocal<Cipher> {
    arv() {
    }

    private static Cipher a() {
        try {
            return zzehh.a.a("AES/ECB/NOPADDING");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ Cipher initialValue() {
        return a();
    }
}
