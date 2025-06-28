package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzefv extends zzekh<zzefv, zza> implements zzelu {
    private static volatile zzemb<zzefv> zzei;
    private static final zzefv zzifb;
    private int zziaz;
    private zzefw zzifa;

    private zzefv() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzefv, zza> implements zzelu {
        private zza() {
            super(zzefv.zzifb);
        }

        public final zza a(int i) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzefv) this.a).b(0);
            return this;
        }

        public final zza a(zzefw zzefwVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzefv) this.a).a(zzefwVar);
            return this;
        }

        /* synthetic */ zza(arl arlVar) {
            this();
        }
    }

    public final int a() {
        return this.zziaz;
    }

    public final void b(int i) {
        this.zziaz = i;
    }

    public final zzefw b() {
        return this.zzifa == null ? zzefw.b() : this.zzifa;
    }

    public final void a(zzefw zzefwVar) {
        zzefwVar.getClass();
        this.zzifa = zzefwVar;
    }

    public static zzefv a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzefv) zzekh.a(zzifb, zzeiuVar, zzejuVar);
    }

    public static zza c() {
        return zzifb.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (arl.a[i - 1]) {
            case 1:
                return new zzefv();
            case 2:
                return new zza(null);
            case 3:
                return a(zzifb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zziaz", "zzifa"});
            case 4:
                return zzifb;
            case 5:
                zzemb<zzefv> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzefv.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzifb);
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
        zzefv zzefvVar = new zzefv();
        zzifb = zzefvVar;
        zzekh.a((Class<zzefv>) zzefv.class, zzefvVar);
    }
}
