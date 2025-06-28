package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzehk;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzehh<T_WRAPPER extends zzehk<T_ENGINE>, T_ENGINE> {
    public static final zzehh<zzehj, Cipher> a;
    public static final zzehh<zzehn, Mac> b;
    public static final zzehh<zzehm, KeyAgreement> c;
    public static final zzehh<zzeho, KeyPairGenerator> d;
    public static final zzehh<zzehl, KeyFactory> e;
    private static final Logger f = Logger.getLogger(zzehh.class.getName());
    private static final List<Provider> g;
    private static final zzehh<zzehp, Signature> h;
    private static final zzehh<zzehq, MessageDigest> i;
    private T_WRAPPER j;
    private List<Provider> k = g;
    private boolean l = true;

    private zzehh(T_WRAPPER t_wrapper) {
        this.j = t_wrapper;
    }

    public final T_ENGINE a(String str) throws GeneralSecurityException {
        Iterator<Provider> it = this.k.iterator();
        Exception exc = null;
        while (it.hasNext()) {
            try {
                return (T_ENGINE) this.j.a(str, it.next());
            } catch (Exception e2) {
                if (exc == null) {
                    exc = e2;
                }
            }
        }
        if (this.l) {
            return (T_ENGINE) this.j.a(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }

    static {
        if (zzehz.a()) {
            String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 2; i2++) {
                String str = strArr[i2];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    f.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", str));
                }
            }
            g = arrayList;
        } else {
            g = new ArrayList();
        }
        a = new zzehh<>(new zzehj());
        b = new zzehh<>(new zzehn());
        h = new zzehh<>(new zzehp());
        i = new zzehh<>(new zzehq());
        c = new zzehh<>(new zzehm());
        d = new zzehh<>(new zzeho());
        e = new zzehh<>(new zzehl());
    }
}
