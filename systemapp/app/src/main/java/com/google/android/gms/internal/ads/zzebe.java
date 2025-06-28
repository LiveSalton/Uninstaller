package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzebe extends zzeae<zzedr> {
    zzebe() {
        super(zzedr.class, new aou(zzdzt.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final String b() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzefh.zzb c() {
        return zzefh.zzb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzead<?, zzedr> f() {
        return new aot(this, zzedu.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ void a(zzedr zzedrVar) throws GeneralSecurityException {
        zzedr zzedrVar2 = zzedrVar;
        zzeic.a(zzedrVar2.a(), 0);
        zzeic.a(zzedrVar2.c().b());
        if (zzedrVar2.b().a() != 12 && zzedrVar2.b().a() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ zzedr a(zzeiu zzeiuVar) throws zzeks {
        return zzedr.a(zzeiuVar, zzeju.a());
    }
}
