package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzedi extends zzekh<zzedi, zza> implements zzelu {
    private static volatile zzemb<zzedi> zzei;
    private static final zzedi zzibj;
    private int zziaz;
    private zzedm zzibh;
    private zzefc zzibi;

    private zzedi() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzedi, zza> implements zzelu {
        private zza() {
            super(zzedi.zzibj);
        }

        public final zza a(int i) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzedi) this.a).b(i);
            return this;
        }

        public final zza a(zzedm zzedmVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzedi) this.a).a(zzedmVar);
            return this;
        }

        public final zza a(zzefc zzefcVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzedi) this.a).a(zzefcVar);
            return this;
        }

        /* synthetic */ zza(aqd aqdVar) {
            this();
        }
    }

    public final int a() {
        return this.zziaz;
    }

    public final void b(int i) {
        this.zziaz = i;
    }

    public final zzedm b() {
        return this.zzibh == null ? zzedm.e() : this.zzibh;
    }

    public final void a(zzedm zzedmVar) {
        zzedmVar.getClass();
        this.zzibh = zzedmVar;
    }

    public final zzefc c() {
        return this.zzibi == null ? zzefc.e() : this.zzibi;
    }

    public final void a(zzefc zzefcVar) {
        zzefcVar.getClass();
        this.zzibi = zzefcVar;
    }

    public static zzedi a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzedi) zzekh.a(zzibj, zzeiuVar, zzejuVar);
    }

    public static zza d() {
        return zzibj.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqd.a[i - 1]) {
            case 1:
                return new zzedi();
            case 2:
                return new zza(null);
            case 3:
                return a(zzibj, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zziaz", "zzibh", "zzibi"});
            case 4:
                return zzibj;
            case 5:
                zzemb<zzedi> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzedi.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzibj);
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
        zzedi zzediVar = new zzedi();
        zzibj = zzediVar;
        zzekh.a((Class<zzedi>) zzedi.class, zzediVar);
    }
}
