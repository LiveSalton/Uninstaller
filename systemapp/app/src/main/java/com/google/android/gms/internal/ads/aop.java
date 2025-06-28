package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
final class aop extends zzead<zzedj, zzedi> {
    private final /* synthetic */ zzeaz a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    aop(zzeaz zzeazVar, Class cls) {
        super(cls);
        this.a = zzeazVar;
    }

    @Override // com.google.android.gms.internal.ads.zzead
    public final /* synthetic */ zzedi b(zzedj zzedjVar) throws GeneralSecurityException {
        zzedj zzedjVar2 = zzedjVar;
        zzedm b = new zzebd().f().b(zzedjVar2.a());
        return (zzedi) ((zzekh) zzedi.d().a(b).a(new zzecu().f().b(zzedjVar2.b())).a(0).g());
    }

    @Override // com.google.android.gms.internal.ads.zzead
    public final /* synthetic */ zzedj a(zzeiu zzeiuVar) throws zzeks {
        return zzedj.a(zzeiuVar, zzeju.a());
    }

    @Override // com.google.android.gms.internal.ads.zzead
    public final /* synthetic */ void a(zzedj zzedjVar) throws GeneralSecurityException {
        zzedj zzedjVar2 = zzedjVar;
        new zzebd().f().a((zzead<?, zzedm>) zzedjVar2.a());
        new zzecu().f().a((zzead<?, zzefc>) zzedjVar2.b());
        zzeic.a(zzedjVar2.a().b());
    }
}
