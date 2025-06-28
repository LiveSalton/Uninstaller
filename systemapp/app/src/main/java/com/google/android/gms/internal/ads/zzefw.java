package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzefw extends zzekh<zzefw, zza> implements zzelu {
    private static volatile zzemb<zzefw> zzei;
    private static final zzefw zzifd;
    private String zzifc = "";

    private zzefw() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzefw, zza> implements zzelu {
        private zza() {
            super(zzefw.zzifd);
        }

        /* synthetic */ zza(arm armVar) {
            this();
        }
    }

    public final String a() {
        return this.zzifc;
    }

    public static zzefw a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzefw) zzekh.a(zzifd, zzeiuVar, zzejuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (arm.a[i - 1]) {
            case 1:
                return new zzefw();
            case 2:
                return new zza(null);
            case 3:
                return a(zzifd, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzifc"});
            case 4:
                return zzifd;
            case 5:
                zzemb<zzefw> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzefw.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzifd);
                            zzei = zzembVar;
                        }
                    }
                }
                return zzembVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static zzefw b() {
        return zzifd;
    }

    static {
        zzefw zzefwVar = new zzefw();
        zzifd = zzefwVar;
        zzekh.a((Class<zzefw>) zzefw.class, zzefwVar);
    }
}
