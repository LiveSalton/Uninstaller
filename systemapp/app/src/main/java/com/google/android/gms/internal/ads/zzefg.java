package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzefg extends zzekh<zzefg, zza> implements zzelu {
    private static volatile zzemb<zzefg> zzei;
    private static final zzefg zzidr;
    private int zzibf;
    private int zzidq;

    private zzefg() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzefg, zza> implements zzelu {
        private zza() {
            super(zzefg.zzidr);
        }

        /* synthetic */ zza(ard ardVar) {
            this();
        }
    }

    public final zzefa a() {
        zzefa a = zzefa.a(this.zzidq);
        return a == null ? zzefa.UNRECOGNIZED : a;
    }

    public final int b() {
        return this.zzibf;
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (ard.a[i - 1]) {
            case 1:
                return new zzefg();
            case 2:
                return new zza(null);
            case 3:
                return a(zzidr, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzidq", "zzibf"});
            case 4:
                return zzidr;
            case 5:
                zzemb<zzefg> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzefg.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzidr);
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

    public static zzefg c() {
        return zzidr;
    }

    static {
        zzefg zzefgVar = new zzefg();
        zzidr = zzefgVar;
        zzekh.a((Class<zzefg>) zzefg.class, zzefgVar);
    }
}
