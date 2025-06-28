package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzedr extends zzekh<zzedr, zza> implements zzelu {
    private static volatile zzemb<zzedr> zzei;
    private static final zzedr zzibt;
    private int zziaz;
    private zzeiu zziba = zzeiu.a;
    private zzedv zzibs;

    private zzedr() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzedr, zza> implements zzelu {
        private zza() {
            super(zzedr.zzibt);
        }

        public final zza a(int i) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzedr) this.a).b(0);
            return this;
        }

        public final zza a(zzedv zzedvVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzedr) this.a).a(zzedvVar);
            return this;
        }

        public final zza a(zzeiu zzeiuVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzedr) this.a).a(zzeiuVar);
            return this;
        }

        /* synthetic */ zza(aqi aqiVar) {
            this();
        }
    }

    public final int a() {
        return this.zziaz;
    }

    public final void b(int i) {
        this.zziaz = i;
    }

    public final zzedv b() {
        return this.zzibs == null ? zzedv.b() : this.zzibs;
    }

    public final void a(zzedv zzedvVar) {
        zzedvVar.getClass();
        this.zzibs = zzedvVar;
    }

    public final zzeiu c() {
        return this.zziba;
    }

    public final void a(zzeiu zzeiuVar) {
        zzeiuVar.getClass();
        this.zziba = zzeiuVar;
    }

    public static zzedr a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzedr) zzekh.a(zzibt, zzeiuVar, zzejuVar);
    }

    public static zza d() {
        return zzibt.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqi.a[i - 1]) {
            case 1:
                return new zzedr();
            case 2:
                return new zza(null);
            case 3:
                return a(zzibt, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zziaz", "zzibs", "zziba"});
            case 4:
                return zzibt;
            case 5:
                zzemb<zzedr> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzedr.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzibt);
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
        zzedr zzedrVar = new zzedr();
        zzibt = zzedrVar;
        zzekh.a((Class<zzedr>) zzedr.class, zzedrVar);
    }
}
