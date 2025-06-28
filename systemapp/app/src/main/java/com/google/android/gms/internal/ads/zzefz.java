package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzefz extends zzekh<zzefz, zza> implements zzelu {
    private static volatile zzemb<zzefz> zzei;
    private static final zzefz zziff;
    private int zziaz;
    private zzega zzife;

    private zzefz() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzefz, zza> implements zzelu {
        private zza() {
            super(zzefz.zziff);
        }

        public final zza a(int i) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzefz) this.a).b(0);
            return this;
        }

        public final zza a(zzega zzegaVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzefz) this.a).a(zzegaVar);
            return this;
        }

        /* synthetic */ zza(arn arnVar) {
            this();
        }
    }

    public final int a() {
        return this.zziaz;
    }

    public final void b(int i) {
        this.zziaz = i;
    }

    public final zzega b() {
        return this.zzife == null ? zzega.c() : this.zzife;
    }

    public final void a(zzega zzegaVar) {
        zzegaVar.getClass();
        this.zzife = zzegaVar;
    }

    public static zzefz a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzefz) zzekh.a(zziff, zzeiuVar, zzejuVar);
    }

    public static zza c() {
        return zziff.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (arn.a[i - 1]) {
            case 1:
                return new zzefz();
            case 2:
                return new zza(null);
            case 3:
                return a(zziff, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zziaz", "zzife"});
            case 4:
                return zziff;
            case 5:
                zzemb<zzefz> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzefz.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zziff);
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
        zzefz zzefzVar = new zzefz();
        zziff = zzefzVar;
        zzekh.a((Class<zzefz>) zzefz.class, zzefzVar);
    }
}
