package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzedf extends zzekh<zzedf, zza> implements zzelu {
    private static volatile zzemb<zzedf> zzei;
    private static final zzedf zzibg;
    private int zzibf;

    private zzedf() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzedf, zza> implements zzelu {
        private zza() {
            super(zzedf.zzibg);
        }

        /* synthetic */ zza(aqc aqcVar) {
            this();
        }
    }

    public final int a() {
        return this.zzibf;
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqc.a[i - 1]) {
            case 1:
                return new zzedf();
            case 2:
                return new zza(null);
            case 3:
                return a(zzibg, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzibf"});
            case 4:
                return zzibg;
            case 5:
                zzemb<zzedf> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzedf.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzibg);
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

    public static zzedf b() {
        return zzibg;
    }

    static {
        zzedf zzedfVar = new zzedf();
        zzibg = zzedfVar;
        zzekh.a((Class<zzedf>) zzedf.class, zzedfVar);
    }
}
