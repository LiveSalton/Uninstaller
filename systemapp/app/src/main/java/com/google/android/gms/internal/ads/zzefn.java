package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzefn extends zzekh<zzefn, zza> implements zzelu {
    private static volatile zzemb<zzefn> zzei;
    private static final zzefn zziek;
    private String zzids = "";
    private zzeiu zzidt = zzeiu.a;
    private int zziej;

    private zzefn() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzefn, zza> implements zzelu {
        private zza() {
            super(zzefn.zziek);
        }

        /* synthetic */ zza(arh arhVar) {
            this();
        }
    }

    public final String a() {
        return this.zzids;
    }

    public final zzeiu b() {
        return this.zzidt;
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (arh.a[i - 1]) {
            case 1:
                return new zzefn();
            case 2:
                return new zza(null);
            case 3:
                return a(zziek, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzids", "zzidt", "zziej"});
            case 4:
                return zziek;
            case 5:
                zzemb<zzefn> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzefn.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zziek);
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

    public static zzefn c() {
        return zziek;
    }

    static {
        zzefn zzefnVar = new zzefn();
        zziek = zzefnVar;
        zzekh.a((Class<zzefn>) zzefn.class, zzefnVar);
    }
}
