package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzega extends zzekh<zzega, zza> implements zzelu {
    private static volatile zzemb<zzega> zzei;
    private static final zzega zzifi;
    private String zzifg = "";
    private zzefn zzifh;

    private zzega() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzega, zza> implements zzelu {
        private zza() {
            super(zzega.zzifi);
        }

        /* synthetic */ zza(aro aroVar) {
            this();
        }
    }

    public final String a() {
        return this.zzifg;
    }

    public final zzefn b() {
        return this.zzifh == null ? zzefn.c() : this.zzifh;
    }

    public static zzega a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzega) zzekh.a(zzifi, zzeiuVar, zzejuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aro.a[i - 1]) {
            case 1:
                return new zzega();
            case 2:
                return new zza(null);
            case 3:
                return a(zzifi, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzifg", "zzifh"});
            case 4:
                return zzifi;
            case 5:
                zzemb<zzega> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzega.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzifi);
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

    public static zzega c() {
        return zzifi;
    }

    static {
        zzega zzegaVar = new zzega();
        zzifi = zzegaVar;
        zzekh.a((Class<zzega>) zzega.class, zzegaVar);
    }
}
