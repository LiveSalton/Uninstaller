package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzedv extends zzekh<zzedv, zza> implements zzelu {
    private static volatile zzemb<zzedv> zzei;
    private static final zzedv zzibv;
    private int zzibq;

    private zzedv() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzedv, zza> implements zzelu {
        private zza() {
            super(zzedv.zzibv);
        }

        /* synthetic */ zza(aqk aqkVar) {
            this();
        }
    }

    public final int a() {
        return this.zzibq;
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqk.a[i - 1]) {
            case 1:
                return new zzedv();
            case 2:
                return new zza(null);
            case 3:
                return a(zzibv, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzibq"});
            case 4:
                return zzibv;
            case 5:
                zzemb<zzedv> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzedv.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzibv);
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

    public static zzedv b() {
        return zzibv;
    }

    static {
        zzedv zzedvVar = new zzedv();
        zzibv = zzedvVar;
        zzekh.a((Class<zzedv>) zzedv.class, zzedvVar);
    }
}
