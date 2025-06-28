package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzecu extends zzeae<zzefc> {
    public zzecu() {
        super(zzefc.class, new apu(zzeak.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final String b() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzefh.zzb c() {
        return zzefh.zzb.SYMMETRIC;
    }

    /* renamed from: a */
    public static void a2(zzefc zzefcVar) throws GeneralSecurityException {
        zzeic.a(zzefcVar.a(), 0);
        if (zzefcVar.c().b() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        b(zzefcVar.b());
    }

    public static void b(zzefg zzefgVar) throws GeneralSecurityException {
        if (zzefgVar.b() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        switch (zzefgVar.a()) {
            case SHA1:
                if (zzefgVar.b() > 20) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            case SHA256:
                if (zzefgVar.b() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            case SHA512:
                if (zzefgVar.b() > 64) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            default:
                throw new GeneralSecurityException("unknown hash type");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzead<?, zzefc> f() {
        return new apw(this, zzefd.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ void a(zzefc zzefcVar) throws GeneralSecurityException {
        a2(zzefcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ zzefc a(zzeiu zzeiuVar) throws zzeks {
        return zzefc.a(zzeiuVar, zzeju.a());
    }
}
