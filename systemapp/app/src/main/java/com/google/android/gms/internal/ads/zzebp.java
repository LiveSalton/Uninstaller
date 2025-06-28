package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzebp extends zzeae<zzeeg> {
    zzebp() {
        super(zzeeg.class, new aoz(zzdzt.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final String b() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzefh.zzb c() {
        return zzefh.zzb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzead<?, zzeeg> f() {
        return new apa(this, zzeeh.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ void a(zzeeg zzeegVar) throws GeneralSecurityException {
        zzeeg zzeegVar2 = zzeegVar;
        zzeic.a(zzeegVar2.a(), 0);
        if (zzeegVar2.b().b() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ zzeeg a(zzeiu zzeiuVar) throws zzeks {
        return zzeeg.a(zzeiuVar, zzeju.a());
    }
}
