package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzebu extends zzeae<zzefz> {
    zzebu() {
        super(zzefz.class, new ape(zzdzt.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final String b() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzefh.zzb c() {
        return zzefh.zzb.REMOTE;
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzead<?, zzefz> f() {
        return new apd(this, zzega.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ void a(zzefz zzefzVar) throws GeneralSecurityException {
        zzeic.a(zzefzVar.a(), 0);
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ zzefz a(zzeiu zzeiuVar) throws zzeks {
        return zzefz.a(zzeiuVar, zzeju.a());
    }
}
