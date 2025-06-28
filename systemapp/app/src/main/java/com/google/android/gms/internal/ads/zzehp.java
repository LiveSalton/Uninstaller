package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Signature;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzehp implements zzehk<Signature> {
    @Override // com.google.android.gms.internal.ads.zzehk
    public final /* synthetic */ Signature a(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return Signature.getInstance(str);
        }
        return Signature.getInstance(str, provider);
    }
}
