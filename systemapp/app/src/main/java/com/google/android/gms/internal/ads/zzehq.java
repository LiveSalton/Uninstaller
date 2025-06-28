package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Provider;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzehq implements zzehk<MessageDigest> {
    @Override // com.google.android.gms.internal.ads.zzehk
    public final /* synthetic */ MessageDigest a(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return MessageDigest.getInstance(str);
        }
        return MessageDigest.getInstance(str, provider);
    }
}
