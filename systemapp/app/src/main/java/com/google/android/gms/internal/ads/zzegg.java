package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzegg extends zzekh<zzegg, zza> implements zzelu {
    private static volatile zzemb<zzegg> zzei;
    private static final zzegg zzift;
    private int zziaz;
    private zzeiu zziba = zzeiu.a;

    private zzegg() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzegg, zza> implements zzelu {
        private zza() {
            super(zzegg.zzift);
        }

        public final zza a(int i) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzegg) this.a).b(0);
            return this;
        }

        public final zza a(zzeiu zzeiuVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzegg) this.a).a(zzeiuVar);
            return this;
        }

        /* synthetic */ zza(arr arrVar) {
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

    public static zzegg a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzegg) zzekh.a(zzift, zzeiuVar, zzejuVar);
    }

    public static zza c() {
        return zzift.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (arr.a[i - 1]) {
            case 1:
                return new zzegg();
            case 2:
                return new zza(null);
            case 3:
                return a(zzift, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zziaz", "zziba"});
            case 4:
                return zzift;
            case 5:
                zzemb<zzegg> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzegg.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzift);
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
        zzegg zzeggVar = new zzegg();
        zzift = zzeggVar;
        zzekh.a((Class<zzegg>) zzegg.class, zzeggVar);
    }
}
