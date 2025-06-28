package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeeg extends zzekh<zzeeg, zza> implements zzelu {
    private static volatile zzemb<zzeeg> zzei;
    private static final zzeeg zzica;
    private int zziaz;
    private zzeiu zziba = zzeiu.a;

    private zzeeg() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzeeg, zza> implements zzelu {
        private zza() {
            super(zzeeg.zzica);
        }

        public final zza a(int i) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzeeg) this.a).b(0);
            return this;
        }

        public final zza a(zzeiu zzeiuVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzeeg) this.a).a(zzeiuVar);
            return this;
        }

        /* synthetic */ zza(aqq aqqVar) {
            this();
        }
    }

    public final int a() {
        return this.zziaz;
    }

    public final void b(int i) {
        this.zziaz = i;
    }

    public final zzeiu b() {
        return this.zziba;
    }

    public final void a(zzeiu zzeiuVar) {
        zzeiuVar.getClass();
        this.zziba = zzeiuVar;
    }

    public static zzeeg a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzeeg) zzekh.a(zzica, zzeiuVar, zzejuVar);
    }

    public static zza c() {
        return zzica.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqq.a[i - 1]) {
            case 1:
                return new zzeeg();
            case 2:
                return new zza(null);
            case 3:
                return a(zzica, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zziaz", "zziba"});
            case 4:
                return zzica;
            case 5:
                zzemb<zzeeg> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzeeg.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzica);
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
        zzeeg zzeegVar = new zzeeg();
        zzica = zzeegVar;
        zzekh.a((Class<zzeeg>) zzeeg.class, zzeegVar);
    }
}
