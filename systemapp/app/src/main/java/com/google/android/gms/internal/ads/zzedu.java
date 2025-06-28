package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzedu extends zzekh<zzedu, zza> implements zzelu {
    private static volatile zzemb<zzedu> zzei;
    private static final zzedu zzibu;
    private int zzibd;
    private zzedv zzibs;

    private zzedu() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzedu, zza> implements zzelu {
        private zza() {
            super(zzedu.zzibu);
        }

        /* synthetic */ zza(aqj aqjVar) {
            this();
        }
    }

    public final zzedv a() {
        return this.zzibs == null ? zzedv.b() : this.zzibs;
    }

    public final int b() {
        return this.zzibd;
    }

    public static zzedu a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzedu) zzekh.a(zzibu, zzeiuVar, zzejuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqj.a[i - 1]) {
            case 1:
                return new zzedu();
            case 2:
                return new zza(null);
            case 3:
                return a(zzibu, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzibs", "zzibd"});
            case 4:
                return zzibu;
            case 5:
                zzemb<zzedu> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzedu.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzibu);
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

    static {
        zzedu zzeduVar = new zzedu();
        zzibu = zzeduVar;
        zzekh.a((Class<zzedu>) zzedu.class, zzeduVar);
    }
}
