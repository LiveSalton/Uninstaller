package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzebj extends zzeae<zzedy> {
    zzebj() {
        super(zzedy.class, new aov(zzdzt.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final String b() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzefh.zzb c() {
        return zzefh.zzb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzead<?, zzedy> f() {
        return new aow(this, zzedz.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ void a(zzedy zzedyVar) throws GeneralSecurityException {
        zzedy zzedyVar2 = zzedyVar;
        zzeic.a(zzedyVar2.a(), 0);
        zzeic.a(zzedyVar2.b().b());
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ zzedy a(zzeiu zzeiuVar) throws zzeks {
        return zzedy.a(zzeiuVar, zzeju.a());
    }
}
