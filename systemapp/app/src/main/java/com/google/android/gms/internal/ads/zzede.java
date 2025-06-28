package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzede extends zzekh<zzede, zza> implements zzelu {
    private static volatile zzemb<zzede> zzei;
    private static final zzede zzibe;
    private zzedf zzibb;
    private int zzibd;

    private zzede() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzede, zza> implements zzelu {
        private zza() {
            super(zzede.zzibe);
        }

        /* synthetic */ zza(aqb aqbVar) {
            this();
        }
    }

    public final int a() {
        return this.zzibd;
    }

    public final zzedf b() {
        return this.zzibb == null ? zzedf.b() : this.zzibb;
    }

    public static zzede a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzede) zzekh.a(zzibe, zzeiuVar, zzejuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqb.a[i - 1]) {
            case 1:
                return new zzede();
            case 2:
                return new zza(null);
            case 3:
                return a(zzibe, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzibd", "zzibb"});
            case 4:
                return zzibe;
            case 5:
                zzemb<zzede> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzede.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzibe);
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
        zzede zzedeVar = new zzede();
        zzibe = zzedeVar;
        zzekh.a((Class<zzede>) zzede.class, zzedeVar);
    }
}
