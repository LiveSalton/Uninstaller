package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzefd extends zzekh<zzefd, zza> implements zzelu {
    private static volatile zzemb<zzefd> zzei;
    private static final zzefd zzidp;
    private int zziaz;
    private int zzibd;
    private zzefg zzidn;

    private zzefd() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzefd, zza> implements zzelu {
        private zza() {
            super(zzefd.zzidp);
        }

        /* synthetic */ zza(arc arcVar) {
            this();
        }
    }

    public final zzefg a() {
        return this.zzidn == null ? zzefg.c() : this.zzidn;
    }

    public final int b() {
        return this.zzibd;
    }

    public static zzefd a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzefd) zzekh.a(zzidp, zzeiuVar, zzejuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (arc.a[i - 1]) {
            case 1:
                return new zzefd();
            case 2:
                return new zza(null);
            case 3:
                return a(zzidp, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zzidn", "zzibd", "zziaz"});
            case 4:
                return zzidp;
            case 5:
                zzemb<zzefd> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzefd.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzidp);
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

    public static zzefd c() {
        return zzidp;
    }

    static {
        zzefd zzefdVar = new zzefd();
        zzidp = zzefdVar;
        zzekh.a((Class<zzefd>) zzefd.class, zzefdVar);
    }
}
