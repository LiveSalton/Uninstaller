package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeem extends zzekh<zzeem, zza> implements zzelu {
    private static volatile zzemb<zzeem> zzei;
    private static final zzeem zzicj;
    private zzefn zzici;

    private zzeem() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzeem, zza> implements zzelu {
        private zza() {
            super(zzeem.zzicj);
        }

        /* synthetic */ zza(aqt aqtVar) {
            this();
        }
    }

    public final zzefn a() {
        return this.zzici == null ? zzefn.c() : this.zzici;
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqt.a[i - 1]) {
            case 1:
                return new zzeem();
            case 2:
                return new zza(null);
            case 3:
                return a(zzicj, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzici"});
            case 4:
                return zzicj;
            case 5:
                zzemb<zzeem> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzeem.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzicj);
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

    public static zzeem b() {
        return zzicj;
    }

    static {
        zzeem zzeemVar = new zzeem();
        zzicj = zzeemVar;
        zzekh.a((Class<zzeem>) zzeem.class, zzeemVar);
    }
}
