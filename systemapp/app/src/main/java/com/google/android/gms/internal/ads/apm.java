package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
final class apm extends zzeae<zzeeu> {
    public apm() {
        super(zzeeu.class, new apl(zzeaa.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final String b() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzefh.zzb c() {
        return zzefh.zzb.ASYMMETRIC_PUBLIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ void a(zzeeu zzeeuVar) throws GeneralSecurityException {
        zzeeu zzeeuVar2 = zzeeuVar;
        zzeic.a(zzeeuVar2.a(), 0);
        apq.a(zzeeuVar2.b());
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ zzeeu a(zzeiu zzeiuVar) throws zzeks {
        return zzeeu.a(zzeiuVar, zzeju.a());
    }
}
