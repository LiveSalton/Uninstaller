package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzebq extends zzeae<zzefv> {
    zzebq() {
        super(zzefv.class, new apc(zzdzt.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final String b() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzefh.zzb c() {
        return zzefh.zzb.REMOTE;
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzead<?, zzefv> f() {
        return new apb(this, zzefw.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ void a(zzefv zzefvVar) throws GeneralSecurityException {
        zzeic.a(zzefvVar.a(), 0);
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ zzefv a(zzeiu zzeiuVar) throws zzeks {
        return zzefv.a(zzeiuVar, zzeju.a());
    }
}
