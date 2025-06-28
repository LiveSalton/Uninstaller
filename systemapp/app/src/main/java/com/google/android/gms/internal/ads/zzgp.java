package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzgp extends zzekh<zzgp, zza> implements zzelu {
    private static final zzgp zzabz;
    private static volatile zzemb<zzgp> zzei;
    private zzgt zzabw;
    private zzeiu zzabx = zzeiu.a;
    private zzeiu zzaby = zzeiu.a;
    private int zzdt;

    private zzgp() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzgp, zza> implements zzelu {
        private zza() {
            super(zzgp.zzabz);
        }

        /* synthetic */ zza(axu axuVar) {
            this();
        }
    }

    public final zzgt a() {
        return this.zzabw == null ? zzgt.g() : this.zzabw;
    }

    public final zzeiu b() {
        return this.zzabx;
    }

    public final zzeiu c() {
        return this.zzaby;
    }

    public static zzgp a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzgp) zzekh.a(zzabz, zzeiuVar, zzejuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (axu.a[i - 1]) {
            case 1:
                return new zzgp();
            case 2:
                return new zza(null);
            case 3:
                return a(zzabz, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdt", "zzabw", "zzabx", "zzaby"});
            case 4:
                return zzabz;
            case 5:
                zzemb<zzgp> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzgp.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzabz);
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
        zzgp zzgpVar = new zzgp();
        zzabz = zzgpVar;
        zzekh.a((Class<zzgp>) zzgp.class, zzgpVar);
    }
}
