package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.KeyAgreement;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzehm implements zzehk<KeyAgreement> {
    @Override // com.google.android.gms.internal.ads.zzehk
    public final /* synthetic */ KeyAgreement a(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return KeyAgreement.getInstance(str);
        }
        return KeyAgreement.getInstance(str, provider);
    }
}
