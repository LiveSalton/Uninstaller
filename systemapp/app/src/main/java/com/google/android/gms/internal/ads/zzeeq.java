package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeeq extends zzekh<zzeeq, zza> implements zzelu {
    private static volatile zzemb<zzeeq> zzei;
    private static final zzeeq zzicp;
    private zzeev zzicm;
    private zzeem zzicn;
    private int zzico;

    private zzeeq() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzeeq, zza> implements zzelu {
        private zza() {
            super(zzeeq.zzicp);
        }

        /* synthetic */ zza(aqv aqvVar) {
            this();
        }
    }

    public final zzeev a() {
        return this.zzicm == null ? zzeev.d() : this.zzicm;
    }

    public final zzeem b() {
        return this.zzicn == null ? zzeem.b() : this.zzicn;
    }

    public final zzeek c() {
        zzeek a = zzeek.a(this.zzico);
        return a == null ? zzeek.UNRECOGNIZED : a;
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqv.a[i - 1]) {
            case 1:
                return new zzeeq();
            case 2:
                return new zza(null);
            case 3:
                return a(zzicp, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzicm", "zzicn", "zzico"});
            case 4:
                return zzicp;
            case 5:
                zzemb<zzeeq> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzeeq.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzicp);
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

    public static zzeeq d() {
        return zzicp;
    }

    static {
        zzeeq zzeeqVar = new zzeeq();
        zzicp = zzeeqVar;
        zzekh.a((Class<zzeeq>) zzeeq.class, zzeeqVar);
    }
}
