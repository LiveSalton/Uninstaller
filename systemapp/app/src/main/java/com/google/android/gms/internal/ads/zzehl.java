package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzehl implements zzehk<KeyFactory> {
    @Override // com.google.android.gms.internal.ads.zzehk
    public final /* synthetic */ KeyFactory a(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return KeyFactory.getInstance(str);
        }
        return KeyFactory.getInstance(str, provider);
    }
}
