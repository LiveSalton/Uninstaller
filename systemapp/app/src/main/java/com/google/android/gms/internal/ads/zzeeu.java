package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeeu extends zzekh<zzeeu, zza> implements zzelu {
    private static volatile zzemb<zzeeu> zzei;
    private static final zzeeu zzicu;
    private int zziaz;
    private zzeeq zzick;
    private zzeiu zzics = zzeiu.a;
    private zzeiu zzict = zzeiu.a;

    private zzeeu() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzeeu, zza> implements zzelu {
        private zza() {
            super(zzeeu.zzicu);
        }

        public final zza a(int i) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzeeu) this.a).b(0);
            return this;
        }

        public final zza a(zzeeq zzeeqVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzeeu) this.a).a(zzeeqVar);
            return this;
        }

        public final zza a(zzeiu zzeiuVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzeeu) this.a).a(zzeiuVar);
            return this;
        }

        public final zza b(zzeiu zzeiuVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzeeu) this.a).b(zzeiuVar);
            return this;
        }

        /* synthetic */ zza(aqx aqxVar) {
            this();
        }
    }

    public final int a() {
        return this.zziaz;
    }

    public final void b(int i) {
        this.zziaz = i;
    }

    public final zzeeq b() {
        return this.zzick == null ? zzeeq.d() : this.zzick;
    }

    public final void a(zzeeq zzeeqVar) {
        zzeeqVar.getClass();
        this.zzick = zzeeqVar;
    }

    public final zzeiu c() {
        return this.zzics;
    }

    public final void a(zzeiu zzeiuVar) {
        zzeiuVar.getClass();
        this.zzics = zzeiuVar;
    }

    public final zzeiu d() {
        return this.zzict;
    }

    public final void b(zzeiu zzeiuVar) {
        zzeiuVar.getClass();
        this.zzict = zzeiuVar;
    }

    public static zzeeu a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzeeu) zzekh.a(zzicu, zzeiuVar, zzejuVar);
    }

    public static zza e() {
        return zzicu.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aqx.a[i - 1]) {
            case 1:
                return new zzeeu();
            case 2:
                return new zza(null);
            case 3:
                return a(zzicu, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zziaz", "zzick", "zzics", "zzict"});
            case 4:
                return zzicu;
            case 5:
                zzemb<zzeeu> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzeeu.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzicu);
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

    public static zzeeu f() {
        return zzicu;
    }

    static {
        zzeeu zzeeuVar = new zzeeu();
        zzicu = zzeeuVar;
        zzekh.a((Class<zzeeu>) zzeeu.class, zzeeuVar);
    }
}
