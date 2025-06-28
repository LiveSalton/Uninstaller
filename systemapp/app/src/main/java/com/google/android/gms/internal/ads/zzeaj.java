package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import com.google.android.gms.internal.ads.zzefr;
import java.security.GeneralSecurityException;

/* compiled from: source */
@Deprecated
/* loaded from: classes.dex */
public final class zzeaj {
    @Deprecated
    public static final zzeaf a(byte[] bArr) throws GeneralSecurityException {
        try {
            zzefr a = zzefr.a(bArr, zzeju.a());
            for (zzefr.zza zzaVar : a.b()) {
                if (zzaVar.b().c() == zzefh.zzb.UNKNOWN_KEYMATERIAL || zzaVar.b().c() == zzefh.zzb.SYMMETRIC || zzaVar.b().c() == zzefh.zzb.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            return zzeaf.a(a);
        } catch (zzeks unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
