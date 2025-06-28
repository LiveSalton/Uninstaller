package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzedm;
import com.google.android.gms.internal.ads.zzedy;
import com.google.android.gms.internal.ads.zzefc;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
final class apr implements zzegy {
    private final String a;
    private final int b;
    private zzedy c;
    private zzedi d;
    private int e;

    apr(zzefn zzefnVar) throws GeneralSecurityException {
        this.a = zzefnVar.a();
        if (this.a.equals(zzeav.b)) {
            try {
                zzedz a = zzedz.a(zzefnVar.b(), zzeju.a());
                this.c = (zzedy) zzeap.b(zzefnVar);
                this.b = a.a();
                return;
            } catch (zzeks e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        }
        if (!this.a.equals(zzeav.a)) {
            String valueOf = String.valueOf(this.a);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        }
        try {
            zzedj a2 = zzedj.a(zzefnVar.b(), zzeju.a());
            this.d = (zzedi) zzeap.b(zzefnVar);
            this.e = a2.a().b();
            this.b = this.e + a2.b().b();
        } catch (zzeks e2) {
            throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzegy
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzegy
    public final zzdzt a(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.b) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
        if (this.a.equals(zzeav.b)) {
            return (zzdzt) zzeap.a(this.a, (zzedy) ((zzekh) zzedy.c().a((zzedy.zza) this.c).a(zzeiu.a(bArr, 0, this.b)).g()), zzdzt.class);
        }
        if (this.a.equals(zzeav.a)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.e);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.e, this.b);
            zzedm zzedmVar = (zzedm) ((zzekh) zzedm.d().a((zzedm.zza) this.d.b()).a(zzeiu.a(copyOfRange)).g());
            return (zzdzt) zzeap.a(this.a, (zzedi) ((zzekh) zzedi.d().a(this.d.a()).a(zzedmVar).a((zzefc) ((zzekh) zzefc.d().a((zzefc.zza) this.d.c()).a(zzeiu.a(copyOfRange2)).g())).g()), zzdzt.class);
        }
        throw new GeneralSecurityException("unknown DEM key type");
    }
}
