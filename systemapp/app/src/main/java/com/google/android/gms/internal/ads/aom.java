package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import com.google.android.gms.internal.ads.zzefr;
import com.google.android.gms.internal.ads.zzefs;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
final class aom {
    private static final Charset a = Charset.forName("UTF-8");

    public static zzefs a(zzefr zzefrVar) {
        zzefs.zza a2 = zzefs.a().a(zzefrVar.a());
        for (zzefr.zza zzaVar : zzefrVar.b()) {
            a2.a((zzefs.zzb) ((zzekh) zzefs.zzb.a().a(zzaVar.b().a()).a(zzaVar.c()).a(zzaVar.e()).a(zzaVar.d()).g()));
        }
        return (zzefs) ((zzekh) a2.g());
    }

    public static void b(zzefr zzefrVar) throws GeneralSecurityException {
        int a2 = zzefrVar.a();
        boolean z = true;
        int i = 0;
        boolean z2 = false;
        for (zzefr.zza zzaVar : zzefrVar.b()) {
            if (zzaVar.c() == zzefl.ENABLED) {
                if (!zzaVar.a()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzaVar.d())));
                }
                if (zzaVar.e() == zzegd.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzaVar.d())));
                }
                if (zzaVar.c() == zzefl.UNKNOWN_STATUS) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzaVar.d())));
                }
                if (zzaVar.d() == a2) {
                    if (z2) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z2 = true;
                }
                if (zzaVar.b().c() != zzefh.zzb.ASYMMETRIC_PUBLIC) {
                    z = false;
                }
                i++;
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z2 && !z) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
