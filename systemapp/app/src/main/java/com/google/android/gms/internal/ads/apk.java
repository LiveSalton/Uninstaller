package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

/* compiled from: source */
/* loaded from: classes.dex */
final class apk extends zzeag<zzdzx, zzeer> {
    apk(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ zzdzx a(zzeer zzeerVar) throws GeneralSecurityException {
        zzeer zzeerVar2 = zzeerVar;
        zzeeq b = zzeerVar2.b().b();
        zzeev a = b.a();
        zzehg a2 = apq.a(a.a());
        byte[] d = zzeerVar2.c().d();
        return new zzegx((ECPrivateKey) zzehh.e.a("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, d), zzehe.a(a2))), a.c().d(), apq.a(a.b()), apq.a(b.c()), new apr(b.b().a()));
    }
}
