package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPairGenerator;
import java.security.Provider;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeho implements zzehk<KeyPairGenerator> {
    @Override // com.google.android.gms.internal.ads.zzehk
    public final /* synthetic */ KeyPairGenerator a(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return KeyPairGenerator.getInstance(str);
        }
        return KeyPairGenerator.getInstance(str, provider);
    }
}
