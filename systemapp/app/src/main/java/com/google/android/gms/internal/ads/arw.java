package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* compiled from: source */
/* loaded from: classes.dex */
final class arw extends ThreadLocal<Cipher> {
    arw() {
    }

    private static Cipher a() {
        try {
            return zzehh.a.a("AES/GCM/NoPadding");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ Cipher initialValue() {
        return a();
    }
}
