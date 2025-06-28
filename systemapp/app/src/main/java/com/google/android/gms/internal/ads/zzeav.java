package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeav {
    public static final String a = new zzeaz().b();
    public static final String b = new zzebj().b();
    private static final String c = new zzebk().b();
    private static final String d = new zzebe().b();
    private static final String e = new zzebq().b();
    private static final String f = new zzebu().b();
    private static final String g = new zzebp().b();
    private static final String h = new zzebz().b();

    @Deprecated
    private static final zzegf i;

    @Deprecated
    private static final zzegf j;

    @Deprecated
    private static final zzegf k;

    public static void a() throws GeneralSecurityException {
        zzecy.a();
        zzeap.a((zzeae) new zzeaz(), true);
        zzeap.a((zzeae) new zzebe(), true);
        zzeap.a((zzeae) new zzebj(), true);
        zzebk.a(true);
        zzeap.a((zzeae) new zzebp(), true);
        zzeap.a((zzeae) new zzebq(), true);
        zzeap.a((zzeae) new zzebu(), true);
        zzeap.a((zzeae) new zzebz(), true);
        zzeap.a((zzeao) new zzeay());
    }

    static {
        zzegf b2 = zzegf.b();
        i = b2;
        j = b2;
        k = i;
        try {
            a();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }
}
