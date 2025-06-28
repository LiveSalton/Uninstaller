package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzecc extends zzeaq<zzeer, zzeeu> {
    private static final byte[] a = new byte[0];

    zzecc() {
        super(zzeer.class, zzeeu.class, new apk(zzdzx.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final String b() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzefh.zzb c() {
        return zzefh.zzb.ASYMMETRIC_PRIVATE;
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzead<zzeen, zzeer> f() {
        return new apj(this, zzeen.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ void a(zzels zzelsVar) throws GeneralSecurityException {
        zzeer zzeerVar = (zzeer) zzelsVar;
        if (zzeerVar.c().c()) {
            throw new GeneralSecurityException("invalid ECIES private key");
        }
        zzeic.a(zzeerVar.a(), 0);
        apq.a(zzeerVar.b().b());
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ zzels a(zzeiu zzeiuVar) throws zzeks {
        return zzeer.a(zzeiuVar, zzeju.a());
    }
}
