package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: source */
/* loaded from: classes.dex */
final class apu extends zzeag<zzeak, zzefc> {
    apu(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ zzeak a(zzefc zzefcVar) throws GeneralSecurityException {
        zzefc zzefcVar2 = zzefcVar;
        zzefa a = zzefcVar2.b().a();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzefcVar2.c().d(), "HMAC");
        int b = zzefcVar2.b().b();
        switch (a) {
            case SHA1:
                return new zzehy(new zzehw("HMACSHA1", secretKeySpec), b);
            case SHA256:
                return new zzehy(new zzehw("HMACSHA256", secretKeySpec), b);
            case SHA512:
                return new zzehy(new zzehw("HMACSHA512", secretKeySpec), b);
            default:
                throw new GeneralSecurityException("unknown hash");
        }
    }
}
