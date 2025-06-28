package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzedq extends zzekh<zzedq, zza> implements zzelu {
    private static volatile zzemb<zzedq> zzei;
    private static final zzedq zzibr;
    private int zzibq;

    private zzedq() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzedq, zza> implements zzelu {
        private zza() {
            super(zzedq.zzibr);
        }

        /* synthetic */ zza(aqh aqhVar) {
            this();
        }
    }

    public final int a() {
        return this.zzibq;
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqh.a[i - 1]) {
            case 1:
                return new zzedq();
            case 2:
                return new zza(null);
            case 3:
                return a(zzibr, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzibq"});
            case 4:
                return zzibr;
            case 5:
                zzemb<zzedq> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzedq.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzibr);
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

    public static zzedq b() {
        return zzibr;
    }

    static {
        zzedq zzedqVar = new zzedq();
        zzibr = zzedqVar;
        zzekh.a((Class<zzedq>) zzedq.class, zzedqVar);
    }
}
