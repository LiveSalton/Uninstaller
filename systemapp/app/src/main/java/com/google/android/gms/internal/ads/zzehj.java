package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Cipher;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzehj implements zzehk<Cipher> {
    @Override // com.google.android.gms.internal.ads.zzehk
    public final /* synthetic */ Cipher a(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return Cipher.getInstance(str);
        }
        return Cipher.getInstance(str, provider);
    }
}
