package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzecp extends zzeae<zzeda> {
    zzecp() {
        super(zzeda.class, new apt(zzeak.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final String b() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzefh.zzb c() {
        return zzefh.zzb.SYMMETRIC;
    }

    public static void b(zzedf zzedfVar) throws GeneralSecurityException {
        if (zzedfVar.a() < 10) {
            throw new GeneralSecurityException("tag size too short");
        }
        if (zzedfVar.a() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    public static void b(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzead<?, zzeda> f() {
        return new aps(this, zzede.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ void a(zzeda zzedaVar) throws GeneralSecurityException {
        zzeda zzedaVar2 = zzedaVar;
        zzeic.a(zzedaVar2.a(), 0);
        b(zzedaVar2.b().b());
        b(zzedaVar2.c());
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ zzeda a(zzeiu zzeiuVar) throws zzeks {
        return zzeda.a(zzeiuVar, zzeju.a());
    }
}
