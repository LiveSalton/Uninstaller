package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeec extends zzekh<zzeec, zza> implements zzelu {
    private static volatile zzemb<zzeec> zzei;
    private static final zzeec zziby;
    private int zziaz;
    private zzeiu zziba = zzeiu.a;

    private zzeec() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzeec, zza> implements zzelu {
        private zza() {
            super(zzeec.zziby);
        }

        public final zza a(int i) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzeec) this.a).b(0);
            return this;
        }

        public final zza a(zzeiu zzeiuVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzeec) this.a).a(zzeiuVar);
            return this;
        }

        /* synthetic */ zza(aqo aqoVar) {
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

    public static zzeec a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzeec) zzekh.a(zziby, zzeiuVar, zzejuVar);
    }

    public static zza c() {
        return zziby.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqo.a[i - 1]) {
            case 1:
                return new zzeec();
            case 2:
                return new zza(null);
            case 3:
                return a(zziby, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zziaz", "zziba"});
            case 4:
                return zziby;
            case 5:
                zzemb<zzeec> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzeec.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zziby);
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
        zzeec zzeecVar = new zzeec();
        zziby = zzeecVar;
        zzekh.a((Class<zzeec>) zzeec.class, zzeecVar);
    }
}
