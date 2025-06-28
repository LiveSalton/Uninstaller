package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;
import java.util.List;

/* compiled from: source */
@Deprecated
/* loaded from: classes.dex */
public final class zzegf extends zzekh<zzegf, zza> implements zzelu {
    private static volatile zzemb<zzegf> zzei;
    private static final zzegf zzifs;
    private String zzifq = "";
    private zzekp<zzefo> zzifr = t();

    private zzegf() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzegf, zza> implements zzelu {
        private zza() {
            super(zzegf.zzifs);
        }

        /* synthetic */ zza(arq arqVar) {
            this();
        }
    }

    public final List<zzefo> a() {
        return this.zzifr;
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (arq.a[i - 1]) {
            case 1:
                return new zzegf();
            case 2:
                return new zza(null);
            case 3:
                return a(zzifs, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzifq", "zzifr", zzefo.class});
            case 4:
                return zzifs;
            case 5:
                zzemb<zzegf> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzegf.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzifs);
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

    public static zzegf b() {
        return zzifs;
    }

    static {
        zzegf zzegfVar = new zzegf();
        zzifs = zzegfVar;
        zzekh.a((Class<zzegf>) zzegf.class, zzegfVar);
    }
}
