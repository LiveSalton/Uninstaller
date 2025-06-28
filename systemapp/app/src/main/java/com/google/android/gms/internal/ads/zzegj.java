package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzegj extends zzekh<zzegj, zza> implements zzelu {
    private static volatile zzemb<zzegj> zzei;
    private static final zzegj zzifu;

    private zzegj() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzegj, zza> implements zzelu {
        private zza() {
            super(zzegj.zzifu);
        }

        /* synthetic */ zza(ars arsVar) {
            this();
        }
    }

    public static zzegj a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzegj) zzekh.a(zzifu, zzeiuVar, zzejuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (ars.a[i - 1]) {
            case 1:
                return new zzegj();
            case 2:
                return new zza(null);
            case 3:
                return a(zzifu, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzifu;
            case 5:
                zzemb<zzegj> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzegj.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzifu);
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
        zzegj zzegjVar = new zzegj();
        zzifu = zzegjVar;
        zzekh.a((Class<zzegj>) zzegj.class, zzegjVar);
    }
}
