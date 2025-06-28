package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbw {

    /* compiled from: source */
    public static final class zza extends zzekh<zza, C0057zza> implements zzelu {
        private static final zza zzeh;
        private static volatile zzemb<zza> zzei;
        private int zzdt;
        private long zzdv;
        private long zzdz;
        private long zzea;
        private long zzec;
        private int zzeg;
        private String zzdu = "";
        private String zzdw = "";
        private String zzdx = "";
        private String zzdy = "";
        private String zzeb = "";
        private String zzed = "";
        private String zzee = "";
        private zzekp<zzb> zzef = t();

        /* compiled from: source */
        public static final class zzb extends zzekh<zzb, C0058zza> implements zzelu {
            private static volatile zzemb<zzb> zzei;
            private static final zzb zzel;
            private int zzdt;
            private String zzej = "";
            private String zzek = "";

            private zzb() {
            }

            /* compiled from: source */
            /* renamed from: com.google.android.gms.internal.ads.zzbw$zza$zzb$zza */
            public static final class C0058zza extends zzekh.zza<zzb, C0058zza> implements zzelu {
                private C0058zza() {
                    super(zzb.zzel);
                }

                /* synthetic */ C0058zza(om omVar) {
                    this();
                }
            }

            @Override // com.google.android.gms.internal.ads.zzekh
            protected final Object a(int i, Object obj, Object obj2) {
                switch (om.a[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0058zza(null);
                    case 3:
                        return a(zzel, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzdt", "zzej", "zzek"});
                    case 4:
                        return zzel;
                    case 5:
                        zzemb<zzb> zzembVar = zzei;
                        if (zzembVar == null) {
                            synchronized (zzb.class) {
                                zzembVar = zzei;
                                if (zzembVar == null) {
                                    zzembVar = new zzekh.zzc<>(zzel);
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
                zzel = zzbVar;
                zzekh.a((Class<zzb>) zzb.class, zzbVar);
            }
        }

        /* compiled from: source */
        public enum zzc implements zzekj {
            UNKNOWN(0),
            ENABLED(1),
            DISABLED(2);

            private static final zzekm<zzc> d = new pn();
            private final int e;

            @Override // com.google.android.gms.internal.ads.zzekj
            public final int a() {
                return this.e;
            }

            public static zzc a(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return ENABLED;
                    case 2:
                        return DISABLED;
                    default:
                        return null;
                }
            }

            public static zzekl b() {
                return qe.a;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.e + " name=" + name() + '>';
            }

            zzc(int i) {
                this.e = i;
            }
        }

        private zza() {
        }

        /* compiled from: source */
        /* renamed from: com.google.android.gms.internal.ads.zzbw$zza$zza */
        public static final class C0057zza extends zzekh.zza<zza, C0057zza> implements zzelu {
            private C0057zza() {
                super(zza.zzeh);
            }

            public final C0057zza a(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).a(str);
                return this;
            }

            public final C0057zza a(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).a(j);
                return this;
            }

            public final C0057zza b(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).b(str);
                return this;
            }

            public final C0057zza c(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).c(str);
                return this;
            }

            public final C0057zza d(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).d(str);
                return this;
            }

            public final C0057zza e(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).e(str);
                return this;
            }

            public final C0057zza a(zzc zzcVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).a(zzcVar);
                return this;
            }

            /* synthetic */ C0057zza(om omVar) {
                this();
            }
        }

        public final void a(String str) {
            str.getClass();
            this.zzdt |= 1;
            this.zzdu = str;
        }

        public final void a(long j) {
            this.zzdt |= 2;
            this.zzdv = j;
        }

        public final void b(String str) {
            str.getClass();
            this.zzdt |= 4;
            this.zzdw = str;
        }

        public final void c(String str) {
            str.getClass();
            this.zzdt |= 8;
            this.zzdx = str;
        }

        public final void d(String str) {
            str.getClass();
            this.zzdt |= 16;
            this.zzdy = str;
        }

        public final void e(String str) {
            str.getClass();
            this.zzdt |= 1024;
            this.zzee = str;
        }

        public final void a(zzc zzcVar) {
            this.zzeg = zzcVar.a();
            this.zzdt |= 2048;
        }

        public static C0057zza a() {
            return zzeh.n();
        }

        @Override // com.google.android.gms.internal.ads.zzekh
        protected final Object a(int i, Object obj, Object obj2) {
            switch (om.a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0057zza(null);
                case 3:
                    return a(zzeh, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\rဌ\u000b", new Object[]{"zzdt", "zzdu", "zzdv", "zzdw", "zzdx", "zzdy", "zzdz", "zzea", "zzeb", "zzec", "zzed", "zzee", "zzef", zzb.class, "zzeg", zzc.b()});
                case 4:
                    return zzeh;
                case 5:
                    zzemb<zza> zzembVar = zzei;
                    if (zzembVar == null) {
                        synchronized (zza.class) {
                            zzembVar = zzei;
                            if (zzembVar == null) {
                                zzembVar = new zzekh.zzc<>(zzeh);
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
            zza zzaVar = new zza();
            zzeh = zzaVar;
            zzekh.a((Class<zza>) zza.class, zzaVar);
        }
    }
}
