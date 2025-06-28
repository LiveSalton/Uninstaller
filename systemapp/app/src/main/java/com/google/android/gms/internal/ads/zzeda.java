package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeda extends zzekh<zzeda, zza> implements zzelu {
    private static volatile zzemb<zzeda> zzei;
    private static final zzeda zzibc;
    private int zziaz;
    private zzeiu zziba = zzeiu.a;
    private zzedf zzibb;

    private zzeda() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzeda, zza> implements zzelu {
        private zza() {
            super(zzeda.zzibc);
        }

        public final zza a(int i) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzeda) this.a).b(0);
            return this;
        }

        public final zza a(zzeiu zzeiuVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzeda) this.a).a(zzeiuVar);
            return this;
        }

        public final zza a(zzedf zzedfVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzeda) this.a).a(zzedfVar);
            return this;
        }

        /* synthetic */ zza(aqa aqaVar) {
            this();
        }
    }

    public final int a() {
        return this.zziaz;
    }

    public final void b(int i) {
        this.zziaz = 0;
    }

    public final zzeiu b() {
        return this.zziba;
    }

    public final void a(zzeiu zzeiuVar) {
        zzeiuVar.getClass();
        this.zziba = zzeiuVar;
    }

    public final zzedf c() {
        return this.zzibb == null ? zzedf.b() : this.zzibb;
    }

    public final void a(zzedf zzedfVar) {
        zzedfVar.getClass();
        this.zzibb = zzedfVar;
    }

    public static zzeda a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzeda) zzekh.a(zzibc, zzeiuVar, zzejuVar);
    }

    public static zza d() {
        return zzibc.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqa.a[i - 1]) {
            case 1:
                return new zzeda();
            case 2:
                return new zza(null);
            case 3:
                return a(zzibc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zziaz", "zziba", "zzibb"});
            case 4:
                return zzibc;
            case 5:
                zzemb<zzeda> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzeda.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzibc);
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
        zzeda zzedaVar = new zzeda();
        zzibc = zzedaVar;
        zzekh.a((Class<zzeda>) zzeda.class, zzedaVar);
    }
}
