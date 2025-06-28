package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzefc extends zzekh<zzefc, zza> implements zzelu {
    private static volatile zzemb<zzefc> zzei;
    private static final zzefc zzido;
    private int zziaz;
    private zzeiu zziba = zzeiu.a;
    private zzefg zzidn;

    private zzefc() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzefc, zza> implements zzelu {
        private zza() {
            super(zzefc.zzido);
        }

        public final zza a(int i) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzefc) this.a).b(0);
            return this;
        }

        public final zza a(zzefg zzefgVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzefc) this.a).a(zzefgVar);
            return this;
        }

        public final zza a(zzeiu zzeiuVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzefc) this.a).a(zzeiuVar);
            return this;
        }

        /* synthetic */ zza(arb arbVar) {
            this();
        }
    }

    public final int a() {
        return this.zziaz;
    }

    public final void b(int i) {
        this.zziaz = i;
    }

    public final zzefg b() {
        return this.zzidn == null ? zzefg.c() : this.zzidn;
    }

    public final void a(zzefg zzefgVar) {
        zzefgVar.getClass();
        this.zzidn = zzefgVar;
    }

    public final zzeiu c() {
        return this.zziba;
    }

    public final void a(zzeiu zzeiuVar) {
        zzeiuVar.getClass();
        this.zziba = zzeiuVar;
    }

    public static zzefc a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzefc) zzekh.a(zzido, zzeiuVar, zzejuVar);
    }

    public static zza d() {
        return zzido.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (arb.a[i - 1]) {
            case 1:
                return new zzefc();
            case 2:
                return new zza(null);
            case 3:
                return a(zzido, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zziaz", "zzidn", "zziba"});
            case 4:
                return zzido;
            case 5:
                zzemb<zzefc> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzefc.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzido);
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

    public static zzefc e() {
        return zzido;
    }

    static {
        zzefc zzefcVar = new zzefc();
        zzido = zzefcVar;
        zzekh.a((Class<zzefc>) zzefc.class, zzefcVar);
    }
}
