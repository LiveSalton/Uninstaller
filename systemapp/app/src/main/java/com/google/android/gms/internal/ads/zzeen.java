package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeen extends zzekh<zzeen, zza> implements zzelu {
    private static volatile zzemb<zzeen> zzei;
    private static final zzeen zzicl;
    private zzeeq zzick;

    private zzeen() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzeen, zza> implements zzelu {
        private zza() {
            super(zzeen.zzicl);
        }

        /* synthetic */ zza(aqu aquVar) {
            this();
        }
    }

    public final zzeeq a() {
        return this.zzick == null ? zzeeq.d() : this.zzick;
    }

    public static zzeen a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzeen) zzekh.a(zzicl, zzeiuVar, zzejuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqu.a[i - 1]) {
            case 1:
                return new zzeen();
            case 2:
                return new zza(null);
            case 3:
                return a(zzicl, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzick"});
            case 4:
                return zzicl;
            case 5:
                zzemb<zzeen> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzeen.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzicl);
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
        zzeen zzeenVar = new zzeen();
        zzicl = zzeenVar;
        zzekh.a((Class<zzeen>) zzeen.class, zzeenVar);
    }
}
