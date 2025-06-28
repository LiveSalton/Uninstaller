package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeev extends zzekh<zzeev, zza> implements zzelu {
    private static volatile zzemb<zzeev> zzei;
    private static final zzeev zzicy;
    private int zzicv;
    private int zzicw;
    private zzeiu zzicx = zzeiu.a;

    private zzeev() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzeev, zza> implements zzelu {
        private zza() {
            super(zzeev.zzicy);
        }

        /* synthetic */ zza(aqy aqyVar) {
            this();
        }
    }

    public final zzeey a() {
        zzeey a = zzeey.a(this.zzicv);
        return a == null ? zzeey.UNRECOGNIZED : a;
    }

    public final zzefa b() {
        zzefa a = zzefa.a(this.zzicw);
        return a == null ? zzefa.UNRECOGNIZED : a;
    }

    public final zzeiu c() {
        return this.zzicx;
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqy.a[i - 1]) {
            case 1:
                return new zzeev();
            case 2:
                return new zza(null);
            case 3:
                return a(zzicy, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzicv", "zzicw", "zzicx"});
            case 4:
                return zzicy;
            case 5:
                zzemb<zzeev> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzeev.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzicy);
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

    public static zzeev d() {
        return zzicy;
    }

    static {
        zzeev zzeevVar = new zzeev();
        zzicy = zzeevVar;
        zzekh.a((Class<zzeev>) zzeev.class, zzeevVar);
    }
}
