package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzebz extends zzeae<zzegg> {
    zzebz() {
        super(zzegg.class, new apf(zzdzt.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final String b() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzefh.zzb c() {
        return zzefh.zzb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzead<?, zzegg> f() {
        return new aph(this, zzegj.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ void a(zzegg zzeggVar) throws GeneralSecurityException {
        zzegg zzeggVar2 = zzeggVar;
        zzeic.a(zzeggVar2.a(), 0);
        if (zzeggVar2.b().b() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ zzegg a(zzeiu zzeiuVar) throws zzeks {
        return zzegg.a(zzeiuVar, zzeju.a());
    }
}
