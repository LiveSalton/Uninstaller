package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeed extends zzekh<zzeed, zza> implements zzelu {
    private static volatile zzemb<zzeed> zzei;
    private static final zzeed zzibz;
    private int zziaz;
    private int zzibd;

    private zzeed() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzeed, zza> implements zzelu {
        private zza() {
            super(zzeed.zzibz);
        }

        /* synthetic */ zza(aqp aqpVar) {
            this();
        }
    }

    public final int a() {
        return this.zzibd;
    }

    public static zzeed a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzeed) zzekh.a(zzibz, zzeiuVar, zzejuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqp.a[i - 1]) {
            case 1:
                return new zzeed();
            case 2:
                return new zza(null);
            case 3:
                return a(zzibz, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zziaz", "zzibd"});
            case 4:
                return zzibz;
            case 5:
                zzemb<zzeed> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzeed.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzibz);
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
        zzeed zzeedVar = new zzeed();
        zzibz = zzeedVar;
        zzekh.a((Class<zzeed>) zzeed.class, zzeedVar);
    }
}
