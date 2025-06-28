package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzecj {
    private static final String b = new apm().b();
    private static final String c = new zzecc().b();

    @Deprecated
    public static final zzegf a = zzegf.b();

    @Deprecated
    private static final zzegf d = zzegf.b();

    @Deprecated
    private static final zzegf e = zzegf.b();

    static {
        try {
            zzeav.a();
            zzeap.a((zzeaq) new zzecc(), (zzeae) new apm(), true);
            zzeap.a((zzeao) new zzeci());
            zzeap.a((zzeao) new apo());
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }
}
