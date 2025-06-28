package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzedj extends zzekh<zzedj, zza> implements zzelu {
    private static volatile zzemb<zzedj> zzei;
    private static final zzedj zzibm;
    private zzedn zzibk;
    private zzefd zzibl;

    private zzedj() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzedj, zza> implements zzelu {
        private zza() {
            super(zzedj.zzibm);
        }

        /* synthetic */ zza(aqe aqeVar) {
            this();
        }
    }

    public final zzedn a() {
        return this.zzibk == null ? zzedn.c() : this.zzibk;
    }

    public final zzefd b() {
        return this.zzibl == null ? zzefd.c() : this.zzibl;
    }

    public static zzedj a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzedj) zzekh.a(zzibm, zzeiuVar, zzejuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqe.a[i - 1]) {
            case 1:
                return new zzedj();
            case 2:
                return new zza(null);
            case 3:
                return a(zzibm, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzibk", "zzibl"});
            case 4:
                return zzibm;
            case 5:
                zzemb<zzedj> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzedj.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzibm);
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
        zzedj zzedjVar = new zzedj();
        zzibm = zzedjVar;
        zzekh.a((Class<zzedj>) zzedj.class, zzedjVar);
    }
}
