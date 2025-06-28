package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
final class apw extends zzead<zzefd, zzefc> {
    private final /* synthetic */ zzecu a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    apw(zzecu zzecuVar, Class cls) {
        super(cls);
        this.a = zzecuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzead
    public final /* synthetic */ zzefc b(zzefd zzefdVar) throws GeneralSecurityException {
        zzefd zzefdVar2 = zzefdVar;
        return (zzefc) ((zzekh) zzefc.d().a(0).a(zzefdVar2.a()).a(zzeiu.a(zzehx.a(zzefdVar2.b()))).g());
    }

    @Override // com.google.android.gms.internal.ads.zzead
    public final /* synthetic */ zzefd a(zzeiu zzeiuVar) throws zzeks {
        return zzefd.a(zzeiuVar, zzeju.a());
    }

    @Override // com.google.android.gms.internal.ads.zzead
    public final /* synthetic */ void a(zzefd zzefdVar) throws GeneralSecurityException {
        zzefd zzefdVar2 = zzefdVar;
        if (zzefdVar2.b() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zzecu.b(zzefdVar2.a());
    }
}
