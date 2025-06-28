package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzebk extends zzeae<zzeec> {
    zzebk() {
        super(zzeec.class, new aoy(zzdzt.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final String b() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzefh.zzb c() {
        return zzefh.zzb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final zzead<?, zzeec> f() {
        return new aox(this, zzeed.class);
    }

    private static boolean g() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public static void a(boolean z) throws GeneralSecurityException {
        if (g()) {
            zzeap.a((zzeae) new zzebk(), true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ void a(zzeec zzeecVar) throws GeneralSecurityException {
        zzeec zzeecVar2 = zzeecVar;
        zzeic.a(zzeecVar2.a(), 0);
        zzeic.a(zzeecVar2.b().b());
    }

    @Override // com.google.android.gms.internal.ads.zzeae
    public final /* synthetic */ zzeec a(zzeiu zzeiuVar) throws zzeks {
        return zzeec.a(zzeiuVar, zzeju.a());
    }
}
