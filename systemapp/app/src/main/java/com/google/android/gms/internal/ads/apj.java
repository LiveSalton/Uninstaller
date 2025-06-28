package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

/* compiled from: source */
/* loaded from: classes.dex */
final class apj extends zzead<zzeen, zzeer> {
    private final /* synthetic */ zzecc a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    apj(zzecc zzeccVar, Class cls) {
        super(cls);
        this.a = zzeccVar;
    }

    @Override // com.google.android.gms.internal.ads.zzead
    public final /* synthetic */ zzeer b(zzeen zzeenVar) throws GeneralSecurityException {
        zzeen zzeenVar2 = zzeenVar;
        KeyPair a = zzehe.a(zzehe.a(apq.a(zzeenVar2.a().a().a())));
        ECPublicKey eCPublicKey = (ECPublicKey) a.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) a.getPrivate();
        ECPoint w = eCPublicKey.getW();
        return (zzeer) ((zzekh) zzeer.d().a(0).a((zzeeu) ((zzekh) zzeeu.e().a(0).a(zzeenVar2.a()).a(zzeiu.a(w.getAffineX().toByteArray())).b(zzeiu.a(w.getAffineY().toByteArray())).g())).a(zzeiu.a(eCPrivateKey.getS().toByteArray())).g());
    }

    @Override // com.google.android.gms.internal.ads.zzead
    public final /* synthetic */ zzeen a(zzeiu zzeiuVar) throws zzeks {
        return zzeen.a(zzeiuVar, zzeju.a());
    }

    @Override // com.google.android.gms.internal.ads.zzead
    public final /* synthetic */ void a(zzeen zzeenVar) throws GeneralSecurityException {
        apq.a(zzeenVar.a());
    }
}
