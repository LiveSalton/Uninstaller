package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeaz extends zzeae<zzedi> {
    zzeaz() {
        super(zzedi.class, new aoq(zzdzt.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final String b() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzefh.zzb c() {
        return zzefh.zzb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzead<?, zzedi> f() {
        return new aop(this, zzedj.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ void a(zzedi zzediVar) throws GeneralSecurityException {
        zzedi zzediVar2 = zzediVar;
        zzeic.a(zzediVar2.a(), 0);
        new zzebd();
        zzebd.a2(zzediVar2.b());
        new zzecu();
        zzecu.a2(zzediVar2.c());
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ zzedi a(zzeiu zzeiuVar) throws zzeks {
        return zzedi.a(zzeiuVar, zzeju.a());
    }
}
