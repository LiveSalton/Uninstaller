package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzedm extends zzekh<zzedm, zza> implements zzelu {
    private static volatile zzemb<zzedm> zzei;
    private static final zzedm zzibo;
    private int zziaz;
    private zzeiu zziba = zzeiu.a;
    private zzedq zzibn;

    private zzedm() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzedm, zza> implements zzelu {
        private zza() {
            super(zzedm.zzibo);
        }

        public final zza a(int i) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzedm) this.a).b(0);
            return this;
        }

        public final zza a(zzedq zzedqVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzedm) this.a).a(zzedqVar);
            return this;
        }

        public final zza a(zzeiu zzeiuVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzedm) this.a).a(zzeiuVar);
            return this;
        }

        /* synthetic */ zza(aqf aqfVar) {
            this();
        }
    }

    public final int a() {
        return this.zziaz;
    }

    public final void b(int i) {
        this.zziaz = i;
    }

    public final zzedq b() {
        return this.zzibn == null ? zzedq.b() : this.zzibn;
    }

    public final void a(zzedq zzedqVar) {
        zzedqVar.getClass();
        this.zzibn = zzedqVar;
    }

    public final zzeiu c() {
        return this.zziba;
    }

    public final void a(zzeiu zzeiuVar) {
        zzeiuVar.getClass();
        this.zziba = zzeiuVar;
    }

    public static zzedm a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzedm) zzekh.a(zzibo, zzeiuVar, zzejuVar);
    }

    public static zza d() {
        return zzibo.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqf.a[i - 1]) {
            case 1:
                return new zzedm();
            case 2:
                return new zza(null);
            case 3:
                return a(zzibo, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zziaz", "zzibn", "zziba"});
            case 4:
                return zzibo;
            case 5:
                zzemb<zzedm> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzedm.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzibo);
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

    public static zzedm e() {
        return zzibo;
    }

    static {
        zzedm zzedmVar = new zzedm();
        zzibo = zzedmVar;
        zzekh.a((Class<zzedm>) zzedm.class, zzedmVar);
    }
}
