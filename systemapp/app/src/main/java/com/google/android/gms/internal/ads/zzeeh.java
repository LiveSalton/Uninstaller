package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeeh extends zzekh<zzeeh, zza> implements zzelu {
    private static volatile zzemb<zzeeh> zzei;
    private static final zzeeh zzicb;

    private zzeeh() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzeeh, zza> implements zzelu {
        private zza() {
            super(zzeeh.zzicb);
        }

        /* synthetic */ zza(aqr aqrVar) {
            this();
        }
    }

    public static zzeeh a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzeeh) zzekh.a(zzicb, zzeiuVar, zzejuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqr.a[i - 1]) {
            case 1:
                return new zzeeh();
            case 2:
                return new zza(null);
            case 3:
                return a(zzicb, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzicb;
            case 5:
                zzemb<zzeeh> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzeeh.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzicb);
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
        zzeeh zzeehVar = new zzeeh();
        zzicb = zzeehVar;
        zzekh.a((Class<zzeeh>) zzeeh.class, zzeehVar);
    }
}
