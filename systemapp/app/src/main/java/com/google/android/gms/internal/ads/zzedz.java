package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzedz extends zzekh<zzedz, zza> implements zzelu {
    private static volatile zzemb<zzedz> zzei;
    private static final zzedz zzibx;
    private int zziaz;
    private int zzibd;

    private zzedz() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzedz, zza> implements zzelu {
        private zza() {
            super(zzedz.zzibx);
        }

        /* synthetic */ zza(aqn aqnVar) {
            this();
        }
    }

    public final int a() {
        return this.zzibd;
    }

    public static zzedz a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzedz) zzekh.a(zzibx, zzeiuVar, zzejuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqn.a[i - 1]) {
            case 1:
                return new zzedz();
            case 2:
                return new zza(null);
            case 3:
                return a(zzibx, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzibd", "zziaz"});
            case 4:
                return zzibx;
            case 5:
                zzemb<zzedz> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzedz.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzibx);
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
        zzedz zzedzVar = new zzedz();
        zzibx = zzedzVar;
        zzekh.a((Class<zzedz>) zzedz.class, zzedzVar);
    }
}
