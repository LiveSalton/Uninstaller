package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcf {

    /* compiled from: source */
    public static final class zza extends zzekh<zza, C0060zza> implements zzelu {
        private static volatile zzemb<zza> zzei;
        private static final zza zzih;
        private int zzdt;
        private int zzfk;
        private int zzfl;
        private long zzfn;
        private long zzfo;
        private long zzfp;
        private long zzfq;
        private long zzfr;
        private long zzfs;
        private long zzft;
        private long zzfu;
        private long zzfv;
        private long zzfw;
        private long zzfy;
        private long zzfz;
        private long zzga;
        private long zzgb;
        private long zzgc;
        private long zzgd;
        private long zzge;
        private long zzgf;
        private long zzgg;
        private long zzgj;
        private long zzgk;
        private long zzgl;
        private long zzgm;
        private zzb zzgp;
        private zze zzhf;
        private zzf zzhh;
        private int zzhs;
        private int zzht;
        private int zzhu;
        private zze zzhv;
        private long zzia;
        private boolean zzid;
        private long zzif;
        private zzd zzig;
        private String zzfm = "";
        private String zzed = "";
        private String zzfx = "";
        private String zzfd = "";
        private String zzgh = "D";
        private String zzgi = "";
        private String zzff = "";
        private long zzgn = -1;
        private long zzgo = -1;
        private long zzgq = -1;
        private long zzgr = -1;
        private long zzgs = -1;
        private long zzgt = -1;
        private long zzgu = -1;
        private long zzgv = -1;
        private String zzfg = "D";
        private String zzfh = "D";
        private long zzgw = -1;
        private int zzgx = 1000;
        private int zzgy = 1000;
        private long zzgz = -1;
        private long zzha = -1;
        private long zzhb = -1;
        private long zzhc = -1;
        private long zzhd = -1;
        private int zzhe = 1000;
        private zzekp<zze> zzhg = t();
        private long zzhi = -1;
        private long zzhj = -1;
        private long zzhk = -1;
        private long zzhl = -1;
        private long zzhm = -1;
        private long zzhn = -1;
        private long zzho = -1;
        private long zzhp = -1;
        private String zzhq = "D";
        private long zzhr = -1;
        private long zzhw = -1;
        private int zzhx = 1000;
        private int zzhy = 1000;
        private String zzhz = "D";
        private String zzib = "";
        private int zzic = 2;
        private String zzie = "";

        /* compiled from: source */
        public enum zzb implements zzekj {
            DEBUGGER_STATE_UNSPECIFIED(0),
            DEBUGGER_STATE_NOT_INSTALLED(1),
            DEBUGGER_STATE_INSTALLED(2),
            DEBUGGER_STATE_ACTIVE(3),
            DEBUGGER_STATE_ENVVAR(4),
            DEBUGGER_STATE_MACHPORT(5),
            DEBUGGER_STATE_ENVVAR_MACHPORT(6);

            private static final zzekm<zzb> h = new ss();
            private final int i;

            @Override // com.google.android.gms.internal.ads.zzekj
            public final int a() {
                return this.i;
            }

            public static zzb a(int i) {
                switch (i) {
                    case 0:
                        return DEBUGGER_STATE_UNSPECIFIED;
                    case 1:
                        return DEBUGGER_STATE_NOT_INSTALLED;
                    case 2:
                        return DEBUGGER_STATE_INSTALLED;
                    case 3:
                        return DEBUGGER_STATE_ACTIVE;
                    case 4:
                        return DEBUGGER_STATE_ENVVAR;
                    case 5:
                        return DEBUGGER_STATE_MACHPORT;
                    case 6:
                        return DEBUGGER_STATE_ENVVAR_MACHPORT;
                    default:
                        return null;
                }
            }

            public static zzekl b() {
                return te.a;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.i + " name=" + name() + '>';
            }

            zzb(int i) {
                this.i = i;
            }
        }

        /* compiled from: source */
        public enum zzc implements zzekj {
            DEVICE_IDENTIFIER_NO_ID(0),
            DEVICE_IDENTIFIER_APP_SPECIFIC_ID(1),
            DEVICE_IDENTIFIER_GLOBAL_ID(2),
            DEVICE_IDENTIFIER_ADVERTISER_ID(3),
            DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED(4),
            DEVICE_IDENTIFIER_ANDROID_AD_ID(5),
            DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID(6);

            private static final zzekm<zzc> h = new ua();
            private final int i;

            @Override // com.google.android.gms.internal.ads.zzekj
            public final int a() {
                return this.i;
            }

            public static zzc a(int i) {
                switch (i) {
                    case 0:
                        return DEVICE_IDENTIFIER_NO_ID;
                    case 1:
                        return DEVICE_IDENTIFIER_APP_SPECIFIC_ID;
                    case 2:
                        return DEVICE_IDENTIFIER_GLOBAL_ID;
                    case 3:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID;
                    case 4:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED;
                    case 5:
                        return DEVICE_IDENTIFIER_ANDROID_AD_ID;
                    case 6:
                        return DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID;
                    default:
                        return null;
                }
            }

            public static zzekl b() {
                return tr.a;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.i + " name=" + name() + '>';
            }

            zzc(int i) {
                this.i = i;
            }
        }

        /* compiled from: source */
        public enum zzd implements zzekj {
            ERROR_ENCODE_SIZE_FAIL(1),
            ERROR_UNKNOWN(3),
            ERROR_NO_SIGNALS(5),
            ERROR_ENCRYPTION(7),
            ERROR_MEMORY(9),
            ERROR_SIMULATOR(11),
            ERROR_SERVICE(13),
            ERROR_THREAD(15),
            PSN_WEB64_FAIL(2),
            PSN_DECRYPT_SIZE_FAIL(4),
            PSN_MD5_CHECK_FAIL(8),
            PSN_MD5_SIZE_FAIL(16),
            PSN_MD5_FAIL(32),
            PSN_DECODE_FAIL(64),
            PSN_SALT_FAIL(128),
            PSN_BITSLICER_FAIL(256),
            PSN_REQUEST_TYPE_FAIL(512),
            PSN_INVALID_ERROR_CODE(1024),
            PSN_TIMESTAMP_EXPIRED(2048),
            PSN_ENCODE_SIZE_FAIL(4096),
            PSN_BLANK_VALUE(8192),
            PSN_INITIALIZATION_FAIL(16384),
            PSN_GASS_CLIENT_FAIL(32768),
            PSN_SIGNALS_TIMEOUT(65536),
            PSN_TINK_FAIL(131072);

            private static final zzekm<zzd> z = new um();
            private final int A;

            @Override // com.google.android.gms.internal.ads.zzekj
            public final int a() {
                return this.A;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.A + " name=" + name() + '>';
            }

            zzd(int i) {
                this.A = i;
            }
        }

        private zza() {
        }

        /* compiled from: source */
        public static final class zze extends zzekh<zze, C0061zza> implements zzelu {
            private static volatile zzemb<zze> zzei;
            private static final zze zzkr;
            private int zzdt;
            private long zzkl;
            private long zzkm;
            private long zzfy = -1;
            private long zzfz = -1;
            private long zzjy = -1;
            private long zzjz = -1;
            private long zzka = -1;
            private long zzkb = -1;
            private int zzkc = 1000;
            private long zzkd = -1;
            private long zzke = -1;
            private long zzkf = -1;
            private int zzkg = 1000;
            private long zzkh = -1;
            private long zzki = -1;
            private long zzkj = -1;
            private long zzkk = -1;
            private long zzkn = -1;
            private long zzko = -1;
            private long zzkp = -1;
            private long zzkq = -1;

            private zze() {
            }

            /* compiled from: source */
            /* renamed from: com.google.android.gms.internal.ads.zzcf$zza$zze$zza */
            public static final class C0061zza extends zzekh.zza<zze, C0061zza> implements zzelu {
                private C0061zza() {
                    super(zze.zzkr);
                }

                public final C0061zza a(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).a(j);
                    return this;
                }

                public final C0061zza b(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).b(j);
                    return this;
                }

                public final C0061zza c(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).c(j);
                    return this;
                }

                public final C0061zza d(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).d(j);
                    return this;
                }

                public final C0061zza a() {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).c();
                    return this;
                }

                public final C0061zza e(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).e(j);
                    return this;
                }

                public final C0061zza f(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).f(j);
                    return this;
                }

                public final C0061zza a(zzcn zzcnVar) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).a(zzcnVar);
                    return this;
                }

                public final C0061zza g(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).g(j);
                    return this;
                }

                public final C0061zza h(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).h(j);
                    return this;
                }

                public final C0061zza i(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).i(j);
                    return this;
                }

                public final C0061zza b(zzcn zzcnVar) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).b(zzcnVar);
                    return this;
                }

                public final C0061zza j(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).j(j);
                    return this;
                }

                public final C0061zza k(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).k(j);
                    return this;
                }

                public final C0061zza l(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).l(j);
                    return this;
                }

                public final C0061zza m(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).m(j);
                    return this;
                }

                public final C0061zza n(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).n(j);
                    return this;
                }

                public final C0061zza o(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).o(j);
                    return this;
                }

                public final C0061zza p(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).p(j);
                    return this;
                }

                public final C0061zza q(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zze) this.a).q(j);
                    return this;
                }

                /* synthetic */ C0061zza(rs rsVar) {
                    this();
                }
            }

            public final void a(long j) {
                this.zzdt |= 1;
                this.zzfy = j;
            }

            public final void b(long j) {
                this.zzdt |= 2;
                this.zzfz = j;
            }

            public final void c(long j) {
                this.zzdt |= 4;
                this.zzjy = j;
            }

            public final void d(long j) {
                this.zzdt |= 8;
                this.zzjz = j;
            }

            public final void c() {
                this.zzdt &= -9;
                this.zzjz = -1L;
            }

            public final void e(long j) {
                this.zzdt |= 16;
                this.zzka = j;
            }

            public final void f(long j) {
                this.zzdt |= 32;
                this.zzkb = j;
            }

            public final void a(zzcn zzcnVar) {
                this.zzkc = zzcnVar.a();
                this.zzdt |= 64;
            }

            public final void g(long j) {
                this.zzdt |= 128;
                this.zzkd = j;
            }

            public final void h(long j) {
                this.zzdt |= 256;
                this.zzke = j;
            }

            public final void i(long j) {
                this.zzdt |= 512;
                this.zzkf = j;
            }

            public final void b(zzcn zzcnVar) {
                this.zzkg = zzcnVar.a();
                this.zzdt |= 1024;
            }

            public final void j(long j) {
                this.zzdt |= 2048;
                this.zzkh = j;
            }

            public final void k(long j) {
                this.zzdt |= 4096;
                this.zzki = j;
            }

            public final void l(long j) {
                this.zzdt |= 8192;
                this.zzkj = j;
            }

            public final void m(long j) {
                this.zzdt |= 16384;
                this.zzkk = j;
            }

            public final void n(long j) {
                this.zzdt |= 32768;
                this.zzkl = j;
            }

            public final void o(long j) {
                this.zzdt |= 65536;
                this.zzkm = j;
            }

            public final void p(long j) {
                this.zzdt |= 131072;
                this.zzkn = j;
            }

            public final void q(long j) {
                this.zzdt |= 262144;
                this.zzko = j;
            }

            public static C0061zza a() {
                return zzkr.n();
            }

            @Override // com.google.android.gms.internal.ads.zzekh
            protected final Object a(int i, Object obj, Object obj2) {
                switch (rs.a[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C0061zza(null);
                    case 3:
                        return a(zzkr, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဌ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဌ\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zzdt", "zzfy", "zzfz", "zzjy", "zzjz", "zzka", "zzkb", "zzkc", zzcn.b(), "zzkd", "zzke", "zzkf", "zzkg", zzcn.b(), "zzkh", "zzki", "zzkj", "zzkk", "zzkl", "zzkm", "zzkn", "zzko", "zzkp", "zzkq"});
                    case 4:
                        return zzkr;
                    case 5:
                        zzemb<zze> zzembVar = zzei;
                        if (zzembVar == null) {
                            synchronized (zze.class) {
                                zzembVar = zzei;
                                if (zzembVar == null) {
                                    zzembVar = new zzekh.zzc<>(zzkr);
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
                zze zzeVar = new zze();
                zzkr = zzeVar;
                zzekh.a((Class<zze>) zze.class, zzeVar);
            }
        }

        /* compiled from: source */
        public static final class zzf extends zzekh<zzf, C0062zza> implements zzelu {
            private static volatile zzemb<zzf> zzei;
            private static final zzf zzkw;
            private int zzdt;
            private long zzhc = -1;
            private long zzhd = -1;
            private long zzks = -1;
            private long zzkt = -1;
            private long zzku = -1;
            private long zzkv = -1;

            private zzf() {
            }

            /* compiled from: source */
            /* renamed from: com.google.android.gms.internal.ads.zzcf$zza$zzf$zza */
            public static final class C0062zza extends zzekh.zza<zzf, C0062zza> implements zzelu {
                private C0062zza() {
                    super(zzf.zzkw);
                }

                public final C0062zza a(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zzf) this.a).a(j);
                    return this;
                }

                public final C0062zza b(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zzf) this.a).b(j);
                    return this;
                }

                public final C0062zza c(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zzf) this.a).c(j);
                    return this;
                }

                public final C0062zza d(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zzf) this.a).d(j);
                    return this;
                }

                /* synthetic */ C0062zza(rs rsVar) {
                    this();
                }
            }

            public final void a(long j) {
                this.zzdt |= 4;
                this.zzks = j;
            }

            public final void b(long j) {
                this.zzdt |= 8;
                this.zzkt = j;
            }

            public final void c(long j) {
                this.zzdt |= 16;
                this.zzku = j;
            }

            public final void d(long j) {
                this.zzdt |= 32;
                this.zzkv = j;
            }

            public static C0062zza a() {
                return zzkw.n();
            }

            @Override // com.google.android.gms.internal.ads.zzekh
            protected final Object a(int i, Object obj, Object obj2) {
                switch (rs.a[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C0062zza(null);
                    case 3:
                        return a(zzkw, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005", new Object[]{"zzdt", "zzhc", "zzhd", "zzks", "zzkt", "zzku", "zzkv"});
                    case 4:
                        return zzkw;
                    case 5:
                        zzemb<zzf> zzembVar = zzei;
                        if (zzembVar == null) {
                            synchronized (zzf.class) {
                                zzembVar = zzei;
                                if (zzembVar == null) {
                                    zzembVar = new zzekh.zzc<>(zzkw);
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
                zzf zzfVar = new zzf();
                zzkw = zzfVar;
                zzekh.a((Class<zzf>) zzf.class, zzfVar);
            }
        }

        /* compiled from: source */
        /* renamed from: com.google.android.gms.internal.ads.zzcf$zza$zza */
        public static final class C0060zza extends zzekh.zza<zza, C0060zza> implements zzelu {
            private C0060zza() {
                super(zza.zzih);
            }

            public final C0060zza a(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).a(str);
                return this;
            }

            public final C0060zza b(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).b(str);
                return this;
            }

            public final C0060zza a(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).a(j);
                return this;
            }

            public final C0060zza b(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).b(j);
                return this;
            }

            public final C0060zza c(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).c(j);
                return this;
            }

            public final C0060zza d(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).d(j);
                return this;
            }

            public final C0060zza e(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).e(j);
                return this;
            }

            public final C0060zza f(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).f(j);
                return this;
            }

            public final C0060zza g(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).g(j);
                return this;
            }

            public final C0060zza h(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).h(j);
                return this;
            }

            public final C0060zza i(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).i(j);
                return this;
            }

            public final C0060zza j(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).j(j);
                return this;
            }

            public final C0060zza k(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).k(j);
                return this;
            }

            public final C0060zza l(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).l(j);
                return this;
            }

            public final C0060zza c(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).c(str);
                return this;
            }

            public final C0060zza d(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).d(str);
                return this;
            }

            public final C0060zza m(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).m(j);
                return this;
            }

            public final C0060zza n(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).n(j);
                return this;
            }

            public final C0060zza o(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).o(j);
                return this;
            }

            public final C0060zza e(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).e(str);
                return this;
            }

            public final C0060zza p(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).p(j);
                return this;
            }

            @Deprecated
            public final C0060zza q(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).q(j);
                return this;
            }

            public final C0060zza r(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).r(j);
                return this;
            }

            public final C0060zza s(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).s(j);
                return this;
            }

            public final C0060zza t(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).t(j);
                return this;
            }

            public final C0060zza u(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).u(j);
                return this;
            }

            public final C0060zza v(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).v(j);
                return this;
            }

            public final C0060zza w(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).w(j);
                return this;
            }

            public final C0060zza x(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).x(j);
                return this;
            }

            public final C0060zza f(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).f(str);
                return this;
            }

            public final C0060zza g(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).g(str);
                return this;
            }

            public final C0060zza a(zzcn zzcnVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).a(zzcnVar);
                return this;
            }

            public final C0060zza b(zzcn zzcnVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).b(zzcnVar);
                return this;
            }

            public final C0060zza y(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).y(j);
                return this;
            }

            public final C0060zza z(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).z(j);
                return this;
            }

            public final C0060zza A(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).A(j);
                return this;
            }

            public final C0060zza c(zzcn zzcnVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).c(zzcnVar);
                return this;
            }

            public final C0060zza a(zze zzeVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).a(zzeVar);
                return this;
            }

            public final C0060zza b(zze zzeVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).b(zzeVar);
                return this;
            }

            public final C0060zza a() {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).x();
                return this;
            }

            public final C0060zza a(zzf zzfVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).a(zzfVar);
                return this;
            }

            public final C0060zza B(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).B(j);
                return this;
            }

            public final C0060zza C(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).C(j);
                return this;
            }

            public final C0060zza D(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).D(j);
                return this;
            }

            public final C0060zza E(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).E(j);
                return this;
            }

            public final C0060zza F(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).F(j);
                return this;
            }

            public final C0060zza h(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).h(str);
                return this;
            }

            public final C0060zza d(zzcn zzcnVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).d(zzcnVar);
                return this;
            }

            public final C0060zza e(zzcn zzcnVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).e(zzcnVar);
                return this;
            }

            public final C0060zza i(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).i(str);
                return this;
            }

            public final C0060zza a(zzc zzcVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).a(zzcVar);
                return this;
            }

            public final C0060zza a(boolean z) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).a(z);
                return this;
            }

            public final C0060zza G(long j) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zza) this.a).G(j);
                return this;
            }

            /* synthetic */ C0060zza(rs rsVar) {
                this();
            }
        }

        public final void a(String str) {
            str.getClass();
            this.zzdt |= 1;
            this.zzfm = str;
        }

        public final void b(String str) {
            str.getClass();
            this.zzdt |= 2;
            this.zzed = str;
        }

        public final void a(long j) {
            this.zzdt |= 4;
            this.zzfn = j;
        }

        public final void b(long j) {
            this.zzdt |= 16;
            this.zzfp = j;
        }

        public final void c(long j) {
            this.zzdt |= 32;
            this.zzfq = j;
        }

        public final void d(long j) {
            this.zzdt |= 1024;
            this.zzfv = j;
        }

        public final void e(long j) {
            this.zzdt |= 2048;
            this.zzfw = j;
        }

        public final void f(long j) {
            this.zzdt |= 8192;
            this.zzfy = j;
        }

        public final void g(long j) {
            this.zzdt |= 16384;
            this.zzfz = j;
        }

        public final void h(long j) {
            this.zzdt |= 32768;
            this.zzga = j;
        }

        public final void i(long j) {
            this.zzdt |= 65536;
            this.zzgb = j;
        }

        public final void j(long j) {
            this.zzdt |= 524288;
            this.zzge = j;
        }

        public final void k(long j) {
            this.zzdt |= 1048576;
            this.zzgf = j;
        }

        public final void l(long j) {
            this.zzdt |= 2097152;
            this.zzgg = j;
        }

        public final boolean a() {
            return (this.zzdt & 4194304) != 0;
        }

        public final String b() {
            return this.zzfd;
        }

        public final void c(String str) {
            str.getClass();
            this.zzdt |= 4194304;
            this.zzfd = str;
        }

        public final void d(String str) {
            str.getClass();
            this.zzdt |= 16777216;
            this.zzgi = str;
        }

        public final void m(long j) {
            this.zzdt |= 33554432;
            this.zzgj = j;
        }

        public final void n(long j) {
            this.zzdt |= 67108864;
            this.zzgk = j;
        }

        public final void o(long j) {
            this.zzdt |= 134217728;
            this.zzgl = j;
        }

        public final void e(String str) {
            str.getClass();
            this.zzdt |= 268435456;
            this.zzff = str;
        }

        public final void p(long j) {
            this.zzdt |= 536870912;
            this.zzgm = j;
        }

        public final void q(long j) {
            this.zzdt |= 1073741824;
            this.zzgn = j;
        }

        public final void r(long j) {
            this.zzdt |= Integer.MIN_VALUE;
            this.zzgo = j;
        }

        public final void s(long j) {
            this.zzfk |= 2;
            this.zzgq = j;
        }

        public final void t(long j) {
            this.zzfk |= 4;
            this.zzgr = j;
        }

        public final void u(long j) {
            this.zzfk |= 8;
            this.zzgs = j;
        }

        public final void v(long j) {
            this.zzfk |= 16;
            this.zzgt = j;
        }

        public final void w(long j) {
            this.zzfk |= 32;
            this.zzgu = j;
        }

        public final void x(long j) {
            this.zzfk |= 64;
            this.zzgv = j;
        }

        public final void f(String str) {
            str.getClass();
            this.zzfk |= 128;
            this.zzfg = str;
        }

        public final void g(String str) {
            str.getClass();
            this.zzfk |= 256;
            this.zzfh = str;
        }

        public final void a(zzcn zzcnVar) {
            this.zzgx = zzcnVar.a();
            this.zzfk |= 1024;
        }

        public final void b(zzcn zzcnVar) {
            this.zzgy = zzcnVar.a();
            this.zzfk |= 2048;
        }

        public final void y(long j) {
            this.zzfk |= 4096;
            this.zzgz = j;
        }

        public final void z(long j) {
            this.zzfk |= 8192;
            this.zzha = j;
        }

        public final void A(long j) {
            this.zzfk |= 16384;
            this.zzhb = j;
        }

        public final void c(zzcn zzcnVar) {
            this.zzhe = zzcnVar.a();
            this.zzfk |= 131072;
        }

        public final void a(zze zzeVar) {
            zzeVar.getClass();
            this.zzhf = zzeVar;
            this.zzfk |= 262144;
        }

        public final void b(zze zzeVar) {
            zzeVar.getClass();
            zzekp<zze> zzekpVar = this.zzhg;
            if (!zzekpVar.a()) {
                this.zzhg = zzekh.a(zzekpVar);
            }
            this.zzhg.add(zzeVar);
        }

        public final void x() {
            this.zzhg = t();
        }

        public final void a(zzf zzfVar) {
            zzfVar.getClass();
            this.zzhh = zzfVar;
            this.zzfk |= 524288;
        }

        public final void B(long j) {
            this.zzfk |= 2097152;
            this.zzhj = j;
        }

        public final void C(long j) {
            this.zzfk |= 4194304;
            this.zzhk = j;
        }

        public final void D(long j) {
            this.zzfk |= 8388608;
            this.zzhl = j;
        }

        public final void E(long j) {
            this.zzfk |= 67108864;
            this.zzho = j;
        }

        public final void F(long j) {
            this.zzfk |= 134217728;
            this.zzhp = j;
        }

        public final void h(String str) {
            str.getClass();
            this.zzfk |= 268435456;
            this.zzhq = str;
        }

        public final void d(zzcn zzcnVar) {
            this.zzhx = zzcnVar.a();
            this.zzfl |= 8;
        }

        public final void e(zzcn zzcnVar) {
            this.zzhy = zzcnVar.a();
            this.zzfl |= 16;
        }

        public final String c() {
            return this.zzib;
        }

        public final void i(String str) {
            str.getClass();
            this.zzfl |= 128;
            this.zzib = str;
        }

        public final zzc d() {
            zzc a = zzc.a(this.zzic);
            return a == null ? zzc.DEVICE_IDENTIFIER_GLOBAL_ID : a;
        }

        public final void a(zzc zzcVar) {
            this.zzic = zzcVar.a();
            this.zzfl |= 256;
        }

        public final boolean e() {
            return this.zzid;
        }

        public final void a(boolean z) {
            this.zzfl |= 512;
            this.zzid = z;
        }

        public final void G(long j) {
            this.zzfl |= 2048;
            this.zzif = j;
        }

        public final boolean f() {
            return (this.zzfl & 4096) != 0;
        }

        public final zzd g() {
            return this.zzig == null ? zzd.c() : this.zzig;
        }

        public static zza a(byte[] bArr, zzeju zzejuVar) throws zzeks {
            return (zza) zzekh.a(zzih, bArr, zzejuVar);
        }

        public static C0060zza h() {
            return zzih.n();
        }

        @Override // com.google.android.gms.internal.ads.zzekh
        protected final Object a(int i, Object obj, Object obj2) {
            switch (rs.a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0060zza(null);
                case 3:
                    return a(zzih, "\u0001N\u0000\u0003\u0001ÉN\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂF\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈG\u0019ဂK\u001aဌH\u001bဈ\u0016\u001cဇI\u001dဈ\u0018\u001eဈJ\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0ဌ*1ဌ+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08ဌ19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=Aဌ>Bဌ?Cဈ<Dဌ@EဉAFဂBGဂ8Hဂ9IဌCJဂ)Kဈ\u0017LဌDMဈEÉဉL", new Object[]{"zzdt", "zzfk", "zzfl", "zzfm", "zzed", "zzfn", "zzfo", "zzfp", "zzfq", "zzfr", "zzfs", "zzft", "zzfu", "zzfv", "zzfw", "zzfx", "zzfy", "zzfz", "zzga", "zzgb", "zzgc", "zzgd", "zzge", "zzia", "zzgf", "zzgg", "zzib", "zzif", "zzic", zzc.b(), "zzfd", "zzid", "zzgi", "zzie", "zzgj", "zzgk", "zzgl", "zzff", "zzgm", "zzgn", "zzgo", "zzgp", "zzgq", "zzgr", "zzgs", "zzgt", "zzhg", zze.class, "zzgu", "zzgv", "zzfg", "zzfh", "zzgx", zzcn.b(), "zzgy", zzcn.b(), "zzhf", "zzgz", "zzha", "zzhb", "zzhc", "zzhd", "zzhe", zzcn.b(), "zzhh", "zzhi", "zzhj", "zzhk", "zzhl", "zzho", "zzhp", "zzhr", "zzhs", zzcm.b(), "zzht", zzcs.b(), "zzhq", "zzhu", zzb.b(), "zzhv", "zzhw", "zzhm", "zzhn", "zzhx", zzcn.b(), "zzgw", "zzgh", "zzhy", zzcn.b(), "zzhz", "zzig"});
                case 4:
                    return zzih;
                case 5:
                    zzemb<zza> zzembVar = zzei;
                    if (zzembVar == null) {
                        synchronized (zza.class) {
                            zzembVar = zzei;
                            if (zzembVar == null) {
                                zzembVar = new zzekh.zzc<>(zzih);
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

        public static zza i() {
            return zzih;
        }

        static {
            zza zzaVar = new zza();
            zzih = zzaVar;
            zzekh.a((Class<zza>) zza.class, zzaVar);
        }
    }

    /* compiled from: source */
    public static final class zzb extends zzekh<zzb, zza> implements zzelu {
        private static volatile zzemb<zzb> zzei;
        private static final zzb zzlc;
        private int zzdt;
        private long zzkx;
        private int zzky;
        private boolean zzkz;
        private zzeko zzla = r();
        private long zzlb;

        private zzb() {
        }

        /* compiled from: source */
        public static final class zza extends zzekh.zza<zzb, zza> implements zzelu {
            private zza() {
                super(zzb.zzlc);
            }

            /* synthetic */ zza(rs rsVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.zzekh
        protected final Object a(int i, Object obj, Object obj2) {
            switch (rs.a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return a(zzlc, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဂ\u0000\u0002င\u0001\u0003ဇ\u0002\u0004\u0016\u0005ဃ\u0003", new Object[]{"zzdt", "zzkx", "zzky", "zzkz", "zzla", "zzlb"});
                case 4:
                    return zzlc;
                case 5:
                    zzemb<zzb> zzembVar = zzei;
                    if (zzembVar == null) {
                        synchronized (zzb.class) {
                            zzembVar = zzei;
                            if (zzembVar == null) {
                                zzembVar = new zzekh.zzc<>(zzlc);
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
            zzlc = zzbVar;
            zzekh.a((Class<zzb>) zzb.class, zzbVar);
        }
    }

    /* compiled from: source */
    public static final class zzd extends zzekh<zzd, zza> implements zzelu {
        private static volatile zzemb<zzd> zzei;
        private static final zzd zzmb;
        private int zzdt;
        private long zzkx;
        private String zzlz = "";
        private zzeiu zzma = zzeiu.a;

        private zzd() {
        }

        /* compiled from: source */
        public static final class zza extends zzekh.zza<zzd, zza> implements zzelu {
            private zza() {
                super(zzd.zzmb);
            }

            /* synthetic */ zza(rs rsVar) {
                this();
            }
        }

        public final boolean a() {
            return (this.zzdt & 1) != 0;
        }

        public final long b() {
            return this.zzkx;
        }

        @Override // com.google.android.gms.internal.ads.zzekh
        protected final Object a(int i, Object obj, Object obj2) {
            switch (rs.a[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(null);
                case 3:
                    return a(zzmb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzdt", "zzkx", "zzlz", "zzma"});
                case 4:
                    return zzmb;
                case 5:
                    zzemb<zzd> zzembVar = zzei;
                    if (zzembVar == null) {
                        synchronized (zzd.class) {
                            zzembVar = zzei;
                            if (zzembVar == null) {
                                zzembVar = new zzekh.zzc<>(zzmb);
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

        public static zzd c() {
            return zzmb;
        }

        static {
            zzd zzdVar = new zzd();
            zzmb = zzdVar;
            zzekh.a((Class<zzd>) zzd.class, zzdVar);
        }
    }

    /* compiled from: source */
    public static final class zze extends zzekh<zze, zza> implements zzelu {
        private static volatile zzemb<zze> zzei;
        private static final zze zzmc;
        private int zzdt;
        private String zzfi = "";

        private zze() {
        }

        /* compiled from: source */
        public static final class zza extends zzekh.zza<zze, zza> implements zzelu {
            private zza() {
                super(zze.zzmc);
            }

            /* synthetic */ zza(rs rsVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.zzekh
        protected final Object a(int i, Object obj, Object obj2) {
            switch (rs.a[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(null);
                case 3:
                    return a(zzmc, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzdt", "zzfi"});
                case 4:
                    return zzmc;
                case 5:
                    zzemb<zze> zzembVar = zzei;
                    if (zzembVar == null) {
                        synchronized (zze.class) {
                            zzembVar = zzei;
                            if (zzembVar == null) {
                                zzembVar = new zzekh.zzc<>(zzmc);
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
            zze zzeVar = new zze();
            zzmc = zzeVar;
            zzekh.a((Class<zze>) zze.class, zzeVar);
        }
    }

    /* compiled from: source */
    public static final class zzc extends zzekh<zzc, zza> implements zzelu {
        private static volatile zzemb<zzc> zzei;
        private static final zzc zzlh;
        private int zzdt;
        private zzeiu zzld = zzeiu.a;
        private zzeiu zzle = zzeiu.a;
        private zzeiu zzlf = zzeiu.a;
        private zzeiu zzlg = zzeiu.a;

        private zzc() {
        }

        /* compiled from: source */
        public static final class zza extends zzekh.zza<zzc, zza> implements zzelu {
            private zza() {
                super(zzc.zzlh);
            }

            public final zza a(zzeiu zzeiuVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzc) this.a).a(zzeiuVar);
                return this;
            }

            public final zza b(zzeiu zzeiuVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzc) this.a).b(zzeiuVar);
                return this;
            }

            public final zza c(zzeiu zzeiuVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzc) this.a).c(zzeiuVar);
                return this;
            }

            public final zza d(zzeiu zzeiuVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzc) this.a).d(zzeiuVar);
                return this;
            }

            /* synthetic */ zza(rs rsVar) {
                this();
            }
        }

        public final zzeiu a() {
            return this.zzld;
        }

        public final void a(zzeiu zzeiuVar) {
            zzeiuVar.getClass();
            this.zzdt |= 1;
            this.zzld = zzeiuVar;
        }

        public final zzeiu b() {
            return this.zzle;
        }

        public final void b(zzeiu zzeiuVar) {
            zzeiuVar.getClass();
            this.zzdt |= 2;
            this.zzle = zzeiuVar;
        }

        public final zzeiu c() {
            return this.zzlf;
        }

        public final void c(zzeiu zzeiuVar) {
            zzeiuVar.getClass();
            this.zzdt |= 4;
            this.zzlf = zzeiuVar;
        }

        public final zzeiu d() {
            return this.zzlg;
        }

        public final void d(zzeiu zzeiuVar) {
            zzeiuVar.getClass();
            this.zzdt |= 8;
            this.zzlg = zzeiuVar;
        }

        public static zzc a(byte[] bArr, zzeju zzejuVar) throws zzeks {
            return (zzc) zzekh.a(zzlh, bArr, zzejuVar);
        }

        public static zza e() {
            return zzlh.n();
        }

        @Override // com.google.android.gms.internal.ads.zzekh
        protected final Object a(int i, Object obj, Object obj2) {
            switch (rs.a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return a(zzlh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzdt", "zzld", "zzle", "zzlf", "zzlg"});
                case 4:
                    return zzlh;
                case 5:
                    zzemb<zzc> zzembVar = zzei;
                    if (zzembVar == null) {
                        synchronized (zzc.class) {
                            zzembVar = zzei;
                            if (zzembVar == null) {
                                zzembVar = new zzekh.zzc<>(zzlh);
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
            zzc zzcVar = new zzc();
            zzlh = zzcVar;
            zzekh.a((Class<zzc>) zzc.class, zzcVar);
        }
    }

    /* compiled from: source */
    public static final class zzf extends zzekh<zzf, zza> implements zzelu {
        private static volatile zzemb<zzf> zzei;
        private static final zzf zzme;
        private int zzdt;
        private zzekp<zzeiu> zzmd = t();
        private zzeiu zzle = zzeiu.a;
        private int zzht = 1;
        private int zzhs = 1;

        private zzf() {
        }

        /* compiled from: source */
        public static final class zza extends zzekh.zza<zzf, zza> implements zzelu {
            private zza() {
                super(zzf.zzme);
            }

            public final zza a(zzeiu zzeiuVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzf) this.a).a(zzeiuVar);
                return this;
            }

            public final zza b(zzeiu zzeiuVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzf) this.a).b(zzeiuVar);
                return this;
            }

            public final zza a(zzcm zzcmVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzf) this.a).a(zzcmVar);
                return this;
            }

            /* synthetic */ zza(rs rsVar) {
                this();
            }
        }

        public final void a(zzeiu zzeiuVar) {
            zzeiuVar.getClass();
            zzekp<zzeiu> zzekpVar = this.zzmd;
            if (!zzekpVar.a()) {
                this.zzmd = zzekh.a(zzekpVar);
            }
            this.zzmd.add(zzeiuVar);
        }

        public final void b(zzeiu zzeiuVar) {
            zzeiuVar.getClass();
            this.zzdt |= 1;
            this.zzle = zzeiuVar;
        }

        public final void a(zzcm zzcmVar) {
            this.zzhs = zzcmVar.a();
            this.zzdt |= 4;
        }

        public static zza a() {
            return zzme.n();
        }

        @Override // com.google.android.gms.internal.ads.zzekh
        protected final Object a(int i, Object obj, Object obj2) {
            switch (rs.a[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(null);
                case 3:
                    return a(zzme, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003ဌ\u0001\u0004ဌ\u0002", new Object[]{"zzdt", "zzmd", "zzle", "zzht", zzcs.b(), "zzhs", zzcm.b()});
                case 4:
                    return zzme;
                case 5:
                    zzemb<zzf> zzembVar = zzei;
                    if (zzembVar == null) {
                        synchronized (zzf.class) {
                            zzembVar = zzei;
                            if (zzembVar == null) {
                                zzembVar = new zzekh.zzc<>(zzme);
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
            zzf zzfVar = new zzf();
            zzme = zzfVar;
            zzekh.a((Class<zzf>) zzf.class, zzfVar);
        }
    }
}
