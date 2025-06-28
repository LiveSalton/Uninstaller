package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzebd extends zzeae<zzedm> {
    zzebd() {
        super(zzedm.class, new aor(zzehr.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final String b() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzefh.zzb c() {
        return zzefh.zzb.SYMMETRIC;
    }

    /* renamed from: a */
    public static void a2(zzedm zzedmVar) throws GeneralSecurityException {
        zzeic.a(zzedmVar.a(), 0);
        zzeic.a(zzedmVar.c().b());
        a(zzedmVar.b());
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzead<?, zzedm> f() {
        return new aos(this, zzedn.class);
    }

    public static void a(zzedq zzedqVar) throws GeneralSecurityException {
        if (zzedqVar.a() < 12 || zzedqVar.a() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ void a(zzedm zzedmVar) throws GeneralSecurityException {
        a2(zzedmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ zzedm a(zzeiu zzeiuVar) throws zzeks {
        return zzedm.a(zzeiuVar, zzeju.a());
    }
}
