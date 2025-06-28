package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* compiled from: source */
/* loaded from: classes.dex */
final class apq {
    public static void a(zzeeq zzeeqVar) throws GeneralSecurityException {
        zzehe.a(a(zzeeqVar.a().a()));
        a(zzeeqVar.a().b());
        if (zzeeqVar.c() == zzeek.UNKNOWN_FORMAT) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        zzeap.a(zzeeqVar.b().a());
    }

    public static String a(zzefa zzefaVar) throws NoSuchAlgorithmException {
        switch (zzefaVar) {
            case SHA1:
                return "HmacSha1";
            case SHA256:
                return "HmacSha256";
            case SHA512:
                return "HmacSha512";
            default:
                String valueOf = String.valueOf(zzefaVar);
                StringBuilder sb = new StringBuilder(27 + String.valueOf(valueOf).length());
                sb.append("hash unsupported for HMAC: ");
                sb.append(valueOf);
                throw new NoSuchAlgorithmException(sb.toString());
        }
    }

    public static zzehg a(zzeey zzeeyVar) throws GeneralSecurityException {
        switch (zzeeyVar) {
            case NIST_P256:
                return zzehg.NIST_P256;
            case NIST_P384:
                return zzehg.NIST_P384;
            case NIST_P521:
                return zzehg.NIST_P521;
            default:
                String valueOf = String.valueOf(zzeeyVar);
                StringBuilder sb = new StringBuilder(20 + String.valueOf(valueOf).length());
                sb.append("unknown curve type: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
        }
    }

    public static zzehf a(zzeek zzeekVar) throws GeneralSecurityException {
        switch (zzeekVar) {
            case UNCOMPRESSED:
                return zzehf.UNCOMPRESSED;
            case DO_NOT_USE_CRUNCHY_UNCOMPRESSED:
                return zzehf.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
            case COMPRESSED:
                return zzehf.COMPRESSED;
            default:
                String valueOf = String.valueOf(zzeekVar);
                StringBuilder sb = new StringBuilder(22 + String.valueOf(valueOf).length());
                sb.append("unknown point format: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
        }
    }
}
