package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
final class aot extends zzead<zzedu, zzedr> {
    private final /* synthetic */ zzebe a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    aot(zzebe zzebeVar, Class cls) {
        super(cls);
        this.a = zzebeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzead
    public final /* synthetic */ zzedr b(zzedu zzeduVar) throws GeneralSecurityException {
        zzedu zzeduVar2 = zzeduVar;
        return (zzedr) ((zzekh) zzedr.d().a(zzeiu.a(zzehx.a(zzeduVar2.b()))).a(zzeduVar2.a()).a(0).g());
    }

    @Override // com.google.android.gms.internal.ads.zzead
    public final /* synthetic */ zzedu a(zzeiu zzeiuVar) throws zzeks {
        return zzedu.a(zzeiuVar, zzeju.a());
    }

    @Override // com.google.android.gms.internal.ads.zzead
    public final /* synthetic */ void a(zzedu zzeduVar) throws GeneralSecurityException {
        zzedu zzeduVar2 = zzeduVar;
        zzeic.a(zzeduVar2.b());
        if (zzeduVar2.a().a() != 12 && zzeduVar2.a().a() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
