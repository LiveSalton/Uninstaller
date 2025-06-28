package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzedn extends zzekh<zzedn, zza> implements zzelu {
    private static volatile zzemb<zzedn> zzei;
    private static final zzedn zzibp;
    private int zzibd;
    private zzedq zzibn;

    private zzedn() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzedn, zza> implements zzelu {
        private zza() {
            super(zzedn.zzibp);
        }

        /* synthetic */ zza(aqg aqgVar) {
            this();
        }
    }

    public final zzedq a() {
        return this.zzibn == null ? zzedq.b() : this.zzibn;
    }

    public final int b() {
        return this.zzibd;
    }

    public static zzedn a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzedn) zzekh.a(zzibp, zzeiuVar, zzejuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqg.a[i - 1]) {
            case 1:
                return new zzedn();
            case 2:
                return new zza(null);
            case 3:
                return a(zzibp, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzibn", "zzibd"});
            case 4:
                return zzibp;
            case 5:
                zzemb<zzedn> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzedn.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzibp);
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

    public static zzedn c() {
        return zzibp;
    }

    static {
        zzedn zzednVar = new zzedn();
        zzibp = zzednVar;
        zzekh.a((Class<zzedn>) zzedn.class, zzednVar);
    }
}
