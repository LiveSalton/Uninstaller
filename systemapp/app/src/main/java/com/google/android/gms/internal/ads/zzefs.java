package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzefs extends zzekh<zzefs, zza> implements zzelu {
    private static volatile zzemb<zzefs> zzei;
    private static final zzefs zziey;
    private int zzieq;
    private zzekp<zzb> zziex = t();

    private zzefs() {
    }

    /* compiled from: source */
    public static final class zzb extends zzekh<zzb, zza> implements zzelu {
        private static volatile zzemb<zzb> zzei;
        private static final zzb zziez;
        private String zzids = "";
        private int zziej;
        private int zzieu;
        private int zziev;

        private zzb() {
        }

        /* compiled from: source */
        public static final class zza extends zzekh.zza<zzb, zza> implements zzelu {
            private zza() {
                super(zzb.zziez);
            }

            public final zza a(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzb) this.a).a(str);
                return this;
            }

            public final zza a(zzefl zzeflVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzb) this.a).a(zzeflVar);
                return this;
            }

            public final zza a(int i) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzb) this.a).b(i);
                return this;
            }

            public final zza a(zzegd zzegdVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzb) this.a).a(zzegdVar);
                return this;
            }

            /* synthetic */ zza(ark arkVar) {
                this();
            }
        }

        public final void a(String str) {
            str.getClass();
            this.zzids = str;
        }

        public final void a(zzefl zzeflVar) {
            this.zzieu = zzeflVar.a();
        }

        public final void b(int i) {
            this.zziev = i;
        }

        public final void a(zzegd zzegdVar) {
            this.zziej = zzegdVar.a();
        }

        public static zza a() {
            return zziez.n();
        }

        @Override // com.google.android.gms.internal.ads.zzekh
        protected final Object a(int i, Object obj, Object obj2) {
            switch (ark.a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return a(zziez, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzids", "zzieu", "zziev", "zziej"});
                case 4:
                    return zziez;
                case 5:
                    zzemb<zzb> zzembVar = zzei;
                    if (zzembVar == null) {
                        synchronized (zzb.class) {
                            zzembVar = zzei;
                            if (zzembVar == null) {
                                zzembVar = new zzekh.zzc<>(zziez);
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
            zzb zzbVar = new zzb();
            zziez = zzbVar;
            zzekh.a((Class<zzb>) zzb.class, zzbVar);
        }
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzefs, zza> implements zzelu {
        private zza() {
            super(zzefs.zziey);
        }

        public final zza a(int i) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzefs) this.a).b(i);
            return this;
        }

        public final zza a(zzb zzbVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzefs) this.a).a(zzbVar);
            return this;
        }

        /* synthetic */ zza(ark arkVar) {
            this();
        }
    }

    public final void b(int i) {
        this.zzieq = i;
    }

    public final void a(zzb zzbVar) {
        zzbVar.getClass();
        zzekp<zzb> zzekpVar = this.zziex;
        if (!zzekpVar.a()) {
            this.zziex = zzekh.a(zzekpVar);
        }
        this.zziex.add(zzbVar);
    }

    public static zza a() {
        return zziey.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (ark.a[i - 1]) {
            case 1:
                return new zzefs();
            case 2:
                return new zza(null);
            case 3:
                return a(zziey, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzieq", "zziex", zzb.class});
            case 4:
                return zziey;
            case 5:
                zzemb<zzefs> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzefs.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zziey);
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
        zzefs zzefsVar = new zzefs();
        zziey = zzefsVar;
        zzekh.a((Class<zzefs>) zzefs.class, zzefsVar);
    }
}
