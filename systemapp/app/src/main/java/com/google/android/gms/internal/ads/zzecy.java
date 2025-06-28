package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzecy {
    private static final String a = new zzecu().b();

    @Deprecated
    private static final zzegf b;

    @Deprecated
    private static final zzegf c;

    @Deprecated
    private static final zzegf d;

    public static void a() throws GeneralSecurityException {
        zzeap.a((zzeae) new zzecu(), true);
        zzeap.a((zzeae) new zzecp(), true);
        zzeap.a((zzeao) new apx());
    }

    static {
        zzegf b2 = zzegf.b();
        b = b2;
        c = b2;
        d = b;
        try {
            a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
