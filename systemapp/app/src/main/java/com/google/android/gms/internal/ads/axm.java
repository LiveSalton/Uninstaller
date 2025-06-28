package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
final class axm {
    static zzeaa a;

    static boolean a(zzfa zzfaVar) throws IllegalAccessException, InvocationTargetException {
        Method a2;
        if (a != null) {
            return true;
        }
        String str = (String) zzwq.e().a(zzabf.bm);
        if (str == null || str.length() == 0) {
            str = (zzfaVar == null || (a2 = zzfaVar.a("Yv/QAPSCUDlFANE2NHMbvShNPv936wVUF2MbIpB/68GL9aQmjKsPYkuORAEbfgnY", "bGYe82pRgk3yFFeIap/06A6dOEaZWsntOa5Lvaa8feA=")) == null) ? null : (String) a2.invoke(null, new Object[0]);
            if (str == null) {
                return false;
            }
        }
        try {
            try {
                zzeaf a3 = zzeaj.a(zzcv.a(str, true));
                for (zzefo zzefoVar : zzecj.a.a()) {
                    if (zzefoVar.b().isEmpty()) {
                        throw new GeneralSecurityException("Missing type_url.");
                    }
                    if (zzefoVar.a().isEmpty()) {
                        throw new GeneralSecurityException("Missing primitive_name.");
                    }
                    if (zzefoVar.e().isEmpty()) {
                        throw new GeneralSecurityException("Missing catalogue_name.");
                    }
                    if (!zzefoVar.e().equals("TinkAead") && !zzefoVar.e().equals("TinkMac") && !zzefoVar.e().equals("TinkHybridDecrypt") && !zzefoVar.e().equals("TinkHybridEncrypt") && !zzefoVar.e().equals("TinkPublicKeySign") && !zzefoVar.e().equals("TinkPublicKeyVerify") && !zzefoVar.e().equals("TinkStreamingAead") && !zzefoVar.e().equals("TinkDeterministicAead")) {
                        zzdzw<?> a4 = zzeap.a(zzefoVar.e());
                        zzeap.a((zzeao) a4.a());
                        zzeap.a(a4.a(zzefoVar.b(), zzefoVar.a(), zzefoVar.c()), zzefoVar.d());
                    }
                }
                a = zzeck.a(a3, null);
                return a != null;
            } catch (GeneralSecurityException unused) {
                return false;
            }
        } catch (IllegalArgumentException unused2) {
            return false;
        }
    }
}
