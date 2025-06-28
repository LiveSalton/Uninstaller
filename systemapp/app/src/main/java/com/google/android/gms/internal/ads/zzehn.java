package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Mac;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzehn implements zzehk<Mac> {
    @Override // com.google.android.gms.internal.ads.zzehk
    public final /* synthetic */ Mac a(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return Mac.getInstance(str);
        }
        return Mac.getInstance(str, provider);
    }
}
