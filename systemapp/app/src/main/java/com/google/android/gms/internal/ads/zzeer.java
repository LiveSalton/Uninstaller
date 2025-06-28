package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeer extends zzekh<zzeer, zza> implements zzelu {
    private static volatile zzemb<zzeer> zzei;
    private static final zzeer zzicr;
    private int zziaz;
    private zzeiu zziba = zzeiu.a;
    private zzeeu zzicq;

    private zzeer() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzeer, zza> implements zzelu {
        private zza() {
            super(zzeer.zzicr);
        }

        public final zza a(int i) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzeer) this.a).b(0);
            return this;
        }

        public final zza a(zzeeu zzeeuVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzeer) this.a).a(zzeeuVar);
            return this;
        }

        public final zza a(zzeiu zzeiuVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzeer) this.a).a(zzeiuVar);
            return this;
        }

        /* synthetic */ zza(aqw aqwVar) {
            this();
        }
    }

    public final int a() {
        return this.zziaz;
    }

    public final void b(int i) {
        this.zziaz = i;
    }

    public final zzeeu b() {
        return this.zzicq == null ? zzeeu.f() : this.zzicq;
    }

    public final void a(zzeeu zzeeuVar) {
        zzeeuVar.getClass();
        this.zzicq = zzeeuVar;
    }

    public final zzeiu c() {
        return this.zziba;
    }

    public final void a(zzeiu zzeiuVar) {
        zzeiuVar.getClass();
        this.zziba = zzeiuVar;
    }

    public static zzeer a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzeer) zzekh.a(zzicr, zzeiuVar, zzejuVar);
    }

    public static zza d() {
        return zzicr.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqw.a[i - 1]) {
            case 1:
                return new zzeer();
            case 2:
                return new zza(null);
            case 3:
                return a(zzicr, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zziaz", "zzicq", "zziba"});
            case 4:
                return zzicr;
            case 5:
                zzemb<zzeer> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzeer.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzicr);
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
        zzeer zzeerVar = new zzeer();
        zzicr = zzeerVar;
        zzekh.a((Class<zzeer>) zzeer.class, zzeerVar);
    }
}
