package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;
import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeoe {

    /* compiled from: source */
    public static final class zza extends zzekh<zza, C0064zza> implements zzelu {
        private static volatile zzemb<zza> zzei;
        private static final zza zziuq;
        private int zzdt;
        private int zziuj;
        private zzb zziuk;
        private boolean zziun;
        private boolean zziuo;
        private byte zziup = 2;
        private zzeiu zziul = zzeiu.a;
        private zzeiu zzium = zzeiu.a;

        /* compiled from: source */
        public static final class zzb extends zzekh<zzb, C0065zza> implements zzelu {
            private static volatile zzemb<zzb> zzei;
            private static final zzb zziuv;
            private int zzdt;
            private String zziur = "";
            private String zzius = "";
            private String zziut = "";
            private int zziuu;

            private zzb() {
            }

            /* compiled from: source */
            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zza$zzb$zza */
            public static final class C0065zza extends zzekh.zza<zzb, C0065zza> implements zzelu {
                private C0065zza() {
                    super(zzb.zziuv);
                }

                /* synthetic */ C0065zza(awp awpVar) {
                    this();
                }
            }

            @Override // com.google.android.gms.internal.ads.zzekh
            protected final Object a(int i, Object obj, Object obj2) {
                switch (awp.a[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0065zza(null);
                    case 3:
                        return a(zziuv, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003", new Object[]{"zzdt", "zziur", "zzius", "zziut", "zziuu"});
                    case 4:
                        return zziuv;
                    case 5:
                        zzemb<zzb> zzembVar = zzei;
                        if (zzembVar == null) {
                            synchronized (zzb.class) {
                                zzembVar = zzei;
                                if (zzembVar == null) {
                                    zzembVar = new zzekh.zzc<>(zziuv);
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
                zziuv = zzbVar;
                zzekh.a((Class<zzb>) zzb.class, zzbVar);
            }
        }

        /* compiled from: source */
        public enum zzc implements zzekj {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);

            private static final zzekm<zzc> f = new awq();
            private final int g;

            @Override // com.google.android.gms.internal.ads.zzekj
            public final int a() {
                return this.g;
            }

            public static zzc a(int i) {
                switch (i) {
                    case 0:
                        return SAFE;
                    case 1:
                        return DANGEROUS;
                    case 2:
                        return UNKNOWN;
                    case 3:
                        return POTENTIALLY_UNWANTED;
                    case 4:
                        return DANGEROUS_HOST;
                    default:
                        return null;
                }
            }

            public static zzekl b() {
                return awr.a;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.g + " name=" + name() + '>';
            }

            zzc(int i) {
                this.g = i;
            }
        }

        private zza() {
        }

        /* compiled from: source */
        /* renamed from: com.google.android.gms.internal.ads.zzeoe$zza$zza */
        public static final class C0064zza extends zzekh.zza<zza, C0064zza> implements zzelu {
            private C0064zza() {
                super(zza.zziuq);
            }

            /* synthetic */ C0064zza(awp awpVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.ads.zzekh
        protected final Object a(int i, Object obj, Object obj2) {
            switch (awp.a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0064zza(null);
                case 3:
                    return a(zziuq, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ᔌ\u0000\u0002ဉ\u0001\u0003ည\u0002\u0004ည\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzdt", "zziuj", zzc.b(), "zziuk", "zziul", "zzium", "zziun", "zziuo"});
                case 4:
                    return zziuq;
                case 5:
                    zzemb<zza> zzembVar = zzei;
                    if (zzembVar == null) {
                        synchronized (zza.class) {
                            zzembVar = zzei;
                            if (zzembVar == null) {
                                zzembVar = new zzekh.zzc<>(zziuq);
                                zzei = zzembVar;
                            }
                        }
                    }
                    return zzembVar;
                case 6:
                    return Byte.valueOf(this.zziup);
                case 7:
                    this.zziup = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zzaVar = new zza();
            zziuq = zzaVar;
            zzekh.a((Class<zza>) zza.class, zzaVar);
        }
    }

    /* compiled from: source */
    public static final class zzb extends zzekh<zzb, C0067zzb> implements zzelu {
        private static volatile zzemb<zzb> zzei;
        private static final zzb zzivr;
        private int zzbzz;
        private int zzdt;
        private int zzivc;
        private zza zzivf;
        private zzf zzivi;
        private boolean zzivj;
        private boolean zzivm;
        private boolean zzivn;
        private zzi zzivo;
        private byte zziup = 2;
        private String zzius = "";
        private String zzivd = "";
        private String zzive = "";
        private zzekp<zzh> zzivg = t();
        private String zzivh = "";
        private zzekp<String> zzivk = zzekh.t();
        private String zzivl = "";
        private zzeiu zziul = zzeiu.a;
        private zzekp<String> zzivp = zzekh.t();
        private zzekp<String> zzivq = zzekh.t();

        /* compiled from: source */
        public static final class zze extends zzekh<zze, C0071zzb> implements zzelu {
            private static volatile zzemb<zze> zzei;
            private static final zze zziwi;
            private int zzdt;
            private int zziwa;
            private zza zziwg;
            private byte zziup = 2;
            private zzekp<zzc> zzivx = t();
            private zzeiu zzivy = zzeiu.a;
            private zzeiu zzivz = zzeiu.a;
            private zzeiu zziwh = zzeiu.a;

            /* compiled from: source */
            public static final class zza extends zzekh<zza, C0070zza> implements zzelu {
                private static volatile zzemb<zza> zzei;
                private static final zza zziwl;
                private int zzdt;
                private int zziwj;
                private zzeiu zziwk = zzeiu.a;
                private zzeiu zziwe = zzeiu.a;

                private zza() {
                }

                /* compiled from: source */
                /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zze$zza$zza */
                public static final class C0070zza extends zzekh.zza<zza, C0070zza> implements zzelu {
                    private C0070zza() {
                        super(zza.zziwl);
                    }

                    /* synthetic */ C0070zza(awp awpVar) {
                        this();
                    }
                }

                @Override // com.google.android.gms.internal.ads.zzekh
                protected final Object a(int i, Object obj, Object obj2) {
                    switch (awp.a[i - 1]) {
                        case 1:
                            return new zza();
                        case 2:
                            return new C0070zza(null);
                        case 3:
                            return a(zziwl, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdt", "zziwj", "zziwk", "zziwe"});
                        case 4:
                            return zziwl;
                        case 5:
                            zzemb<zza> zzembVar = zzei;
                            if (zzembVar == null) {
                                synchronized (zza.class) {
                                    zzembVar = zzei;
                                    if (zzembVar == null) {
                                        zzembVar = new zzekh.zzc<>(zziwl);
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
                    zziwl = zzaVar;
                    zzekh.a((Class<zza>) zza.class, zzaVar);
                }
            }

            private zze() {
            }

            /* compiled from: source */
            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zze$zzb */
            public static final class C0071zzb extends zzekh.zza<zze, C0071zzb> implements zzelu {
                private C0071zzb() {
                    super(zze.zziwi);
                }

                /* synthetic */ C0071zzb(awp awpVar) {
                    this();
                }
            }

            @Override // com.google.android.gms.internal.ads.zzekh
            protected final Object a(int i, Object obj, Object obj2) {
                switch (awp.a[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C0071zzb(null);
                    case 3:
                        return a(zziwi, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzdt", "zziwg", "zzivx", zzc.class, "zzivy", "zzivz", "zziwa", "zziwh"});
                    case 4:
                        return zziwi;
                    case 5:
                        zzemb<zze> zzembVar = zzei;
                        if (zzembVar == null) {
                            synchronized (zze.class) {
                                zzembVar = zzei;
                                if (zzembVar == null) {
                                    zzembVar = new zzekh.zzc<>(zziwi);
                                    zzei = zzembVar;
                                }
                            }
                        }
                        return zzembVar;
                    case 6:
                        return Byte.valueOf(this.zziup);
                    case 7:
                        this.zziup = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zze zzeVar = new zze();
                zziwi = zzeVar;
                zzekh.a((Class<zze>) zze.class, zzeVar);
            }
        }

        /* compiled from: source */
        public enum zzg implements zzekj {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);

            private static final zzekm<zzg> k = new awu();
            private final int l;

            @Override // com.google.android.gms.internal.ads.zzekj
            public final int a() {
                return this.l;
            }

            public static zzg a(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            public static zzekl b() {
                return awv.a;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.l + " name=" + name() + '>';
            }

            zzg(int i) {
                this.l = i;
            }
        }

        private zzb() {
        }

        /* compiled from: source */
        public static final class zza extends zzekh<zza, C0066zza> implements zzelu {
            private static volatile zzemb<zza> zzei;
            private static final zza zzivt;
            private int zzdt;
            private String zzivs = "";

            private zza() {
            }

            /* compiled from: source */
            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zza$zza */
            public static final class C0066zza extends zzekh.zza<zza, C0066zza> implements zzelu {
                private C0066zza() {
                    super(zza.zzivt);
                }

                public final C0066zza a(String str) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zza) this.a).a(str);
                    return this;
                }

                /* synthetic */ C0066zza(awp awpVar) {
                    this();
                }
            }

            public final void a(String str) {
                str.getClass();
                this.zzdt |= 1;
                this.zzivs = str;
            }

            public static C0066zza a() {
                return zzivt.n();
            }

            @Override // com.google.android.gms.internal.ads.zzekh
            protected final Object a(int i, Object obj, Object obj2) {
                switch (awp.a[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0066zza(null);
                    case 3:
                        return a(zzivt, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzdt", "zzivs"});
                    case 4:
                        return zzivt;
                    case 5:
                        zzemb<zza> zzembVar = zzei;
                        if (zzembVar == null) {
                            synchronized (zza.class) {
                                zzembVar = zzei;
                                if (zzembVar == null) {
                                    zzembVar = new zzekh.zzc<>(zzivt);
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
                zzivt = zzaVar;
                zzekh.a((Class<zza>) zza.class, zzaVar);
            }
        }

        /* compiled from: source */
        public static final class zzc extends zzekh<zzc, zza> implements zzelu {
            private static volatile zzemb<zzc> zzei;
            private static final zzc zzivv;
            private int zzdt;
            private byte zziup = 2;
            private zzeiu zzivu = zzeiu.a;
            private zzeiu zzidt = zzeiu.a;

            private zzc() {
            }

            /* compiled from: source */
            public static final class zza extends zzekh.zza<zzc, zza> implements zzelu {
                private zza() {
                    super(zzc.zzivv);
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

                /* synthetic */ zza(awp awpVar) {
                    this();
                }
            }

            public final void a(zzeiu zzeiuVar) {
                zzeiuVar.getClass();
                this.zzdt |= 1;
                this.zzivu = zzeiuVar;
            }

            public final void b(zzeiu zzeiuVar) {
                zzeiuVar.getClass();
                this.zzdt |= 2;
                this.zzidt = zzeiuVar;
            }

            public static zza a() {
                return zzivv.n();
            }

            @Override // com.google.android.gms.internal.ads.zzekh
            protected final Object a(int i, Object obj, Object obj2) {
                switch (awp.a[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(null);
                    case 3:
                        return a(zzivv, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzdt", "zzivu", "zzidt"});
                    case 4:
                        return zzivv;
                    case 5:
                        zzemb<zzc> zzembVar = zzei;
                        if (zzembVar == null) {
                            synchronized (zzc.class) {
                                zzembVar = zzei;
                                if (zzembVar == null) {
                                    zzembVar = new zzekh.zzc<>(zzivv);
                                    zzei = zzembVar;
                                }
                            }
                        }
                        return zzembVar;
                    case 6:
                        return Byte.valueOf(this.zziup);
                    case 7:
                        this.zziup = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzc zzcVar = new zzc();
                zzivv = zzcVar;
                zzekh.a((Class<zzc>) zzc.class, zzcVar);
            }
        }

        /* compiled from: source */
        public static final class zzd extends zzekh<zzd, C0069zzb> implements zzelu {
            private static volatile zzemb<zzd> zzei;
            private static final zzd zziwb;
            private int zzdt;
            private zza zzivw;
            private int zziwa;
            private byte zziup = 2;
            private zzekp<zzc> zzivx = t();
            private zzeiu zzivy = zzeiu.a;
            private zzeiu zzivz = zzeiu.a;

            /* compiled from: source */
            public static final class zza extends zzekh<zza, C0068zza> implements zzelu {
                private static volatile zzemb<zza> zzei;
                private static final zza zziwf;
                private int zzdt;
                private zzeiu zziwc = zzeiu.a;
                private zzeiu zziwd = zzeiu.a;
                private zzeiu zziwe = zzeiu.a;

                private zza() {
                }

                /* compiled from: source */
                /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zzd$zza$zza */
                public static final class C0068zza extends zzekh.zza<zza, C0068zza> implements zzelu {
                    private C0068zza() {
                        super(zza.zziwf);
                    }

                    /* synthetic */ C0068zza(awp awpVar) {
                        this();
                    }
                }

                @Override // com.google.android.gms.internal.ads.zzekh
                protected final Object a(int i, Object obj, Object obj2) {
                    switch (awp.a[i - 1]) {
                        case 1:
                            return new zza();
                        case 2:
                            return new C0068zza(null);
                        case 3:
                            return a(zziwf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdt", "zziwc", "zziwd", "zziwe"});
                        case 4:
                            return zziwf;
                        case 5:
                            zzemb<zza> zzembVar = zzei;
                            if (zzembVar == null) {
                                synchronized (zza.class) {
                                    zzembVar = zzei;
                                    if (zzembVar == null) {
                                        zzembVar = new zzekh.zzc<>(zziwf);
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
                    zziwf = zzaVar;
                    zzekh.a((Class<zza>) zza.class, zzaVar);
                }
            }

            private zzd() {
            }

            /* compiled from: source */
            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zzd$zzb */
            public static final class C0069zzb extends zzekh.zza<zzd, C0069zzb> implements zzelu {
                private C0069zzb() {
                    super(zzd.zziwb);
                }

                public final C0069zzb a(zzc zzcVar) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zzd) this.a).a(zzcVar);
                    return this;
                }

                /* synthetic */ C0069zzb(awp awpVar) {
                    this();
                }
            }

            public final void a(zzc zzcVar) {
                zzcVar.getClass();
                zzekp<zzc> zzekpVar = this.zzivx;
                if (!zzekpVar.a()) {
                    this.zzivx = zzekh.a(zzekpVar);
                }
                this.zzivx.add(zzcVar);
            }

            public static C0069zzb a() {
                return zziwb.n();
            }

            @Override // com.google.android.gms.internal.ads.zzekh
            protected final Object a(int i, Object obj, Object obj2) {
                switch (awp.a[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new C0069zzb(null);
                    case 3:
                        return a(zziwb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzdt", "zzivw", "zzivx", zzc.class, "zzivy", "zzivz", "zziwa"});
                    case 4:
                        return zziwb;
                    case 5:
                        zzemb<zzd> zzembVar = zzei;
                        if (zzembVar == null) {
                            synchronized (zzd.class) {
                                zzembVar = zzei;
                                if (zzembVar == null) {
                                    zzembVar = new zzekh.zzc<>(zziwb);
                                    zzei = zzembVar;
                                }
                            }
                        }
                        return zzembVar;
                    case 6:
                        return Byte.valueOf(this.zziup);
                    case 7:
                        this.zziup = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzd zzdVar = new zzd();
                zziwb = zzdVar;
                zzekh.a((Class<zzd>) zzd.class, zzdVar);
            }
        }

        /* compiled from: source */
        public static final class zzf extends zzekh<zzf, C0072zzb> implements zzelu {
            private static volatile zzemb<zzf> zzei;
            private static final zzf zziwo;
            private int zzbzz;
            private int zzdt;
            private String zziwm = "";
            private zzeiu zziwn = zzeiu.a;

            /* compiled from: source */
            public enum zza implements zzekj {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);

                private static final zzekm<zza> c = new awt();
                private final int d;

                @Override // com.google.android.gms.internal.ads.zzekj
                public final int a() {
                    return this.d;
                }

                public static zza a(int i) {
                    switch (i) {
                        case 0:
                            return TYPE_UNKNOWN;
                        case 1:
                            return TYPE_CREATIVE;
                        default:
                            return null;
                    }
                }

                public static zzekl b() {
                    return aws.a;
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.d + " name=" + name() + '>';
                }

                zza(int i) {
                    this.d = i;
                }
            }

            private zzf() {
            }

            /* compiled from: source */
            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zzf$zzb */
            public static final class C0072zzb extends zzekh.zza<zzf, C0072zzb> implements zzelu {
                private C0072zzb() {
                    super(zzf.zziwo);
                }

                public final C0072zzb a(zza zzaVar) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zzf) this.a).a(zzaVar);
                    return this;
                }

                public final C0072zzb a(String str) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zzf) this.a).a(str);
                    return this;
                }

                public final C0072zzb a(zzeiu zzeiuVar) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zzf) this.a).a(zzeiuVar);
                    return this;
                }

                /* synthetic */ C0072zzb(awp awpVar) {
                    this();
                }
            }

            public final void a(zza zzaVar) {
                this.zzbzz = zzaVar.a();
                this.zzdt |= 1;
            }

            public final void a(String str) {
                str.getClass();
                this.zzdt |= 2;
                this.zziwm = str;
            }

            public final void a(zzeiu zzeiuVar) {
                zzeiuVar.getClass();
                this.zzdt |= 4;
                this.zziwn = zzeiuVar;
            }

            public static C0072zzb a() {
                return zziwo.n();
            }

            @Override // com.google.android.gms.internal.ads.zzekh
            protected final Object a(int i, Object obj, Object obj2) {
                switch (awp.a[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C0072zzb(null);
                    case 3:
                        return a(zziwo, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ည\u0002", new Object[]{"zzdt", "zzbzz", zza.b(), "zziwm", "zziwn"});
                    case 4:
                        return zziwo;
                    case 5:
                        zzemb<zzf> zzembVar = zzei;
                        if (zzembVar == null) {
                            synchronized (zzf.class) {
                                zzembVar = zzei;
                                if (zzembVar == null) {
                                    zzembVar = new zzekh.zzc<>(zziwo);
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
                zziwo = zzfVar;
                zzekh.a((Class<zzf>) zzf.class, zzfVar);
            }
        }

        /* compiled from: source */
        public static final class zzh extends zzekh<zzh, C0073zzb> implements zzelu {
            private static volatile zzemb<zzh> zzei;
            private static final zzh zzixl;
            private int zzdt;
            private int zzixd;
            private zzd zzixe;
            private zze zzixf;
            private int zzixg;
            private int zzixj;
            private byte zziup = 2;
            private String zzius = "";
            private zzeko zzixh = r();
            private String zzixi = "";
            private zzekp<String> zzixk = zzekh.t();

            /* compiled from: source */
            public enum zza implements zzekj {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);

                private static final zzekm<zza> e = new aww();
                private final int f;

                @Override // com.google.android.gms.internal.ads.zzekj
                public final int a() {
                    return this.f;
                }

                public static zza a(int i) {
                    switch (i) {
                        case 0:
                            return AD_RESOURCE_UNKNOWN;
                        case 1:
                            return AD_RESOURCE_CREATIVE;
                        case 2:
                            return AD_RESOURCE_POST_CLICK;
                        case 3:
                            return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                        default:
                            return null;
                    }
                }

                public static zzekl b() {
                    return awx.a;
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f + " name=" + name() + '>';
                }

                zza(int i) {
                    this.f = i;
                }
            }

            private zzh() {
            }

            /* compiled from: source */
            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zzb */
            public static final class C0073zzb extends zzekh.zza<zzh, C0073zzb> implements zzelu {
                private C0073zzb() {
                    super(zzh.zzixl);
                }

                public final C0073zzb a(int i) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zzh) this.a).b(i);
                    return this;
                }

                public final C0073zzb a(String str) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zzh) this.a).a(str);
                    return this;
                }

                public final C0073zzb a(zzd zzdVar) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zzh) this.a).a(zzdVar);
                    return this;
                }

                public final C0073zzb a(zza zzaVar) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zzh) this.a).a(zzaVar);
                    return this;
                }

                public final C0073zzb b(String str) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zzh) this.a).b(str);
                    return this;
                }

                /* synthetic */ C0073zzb(awp awpVar) {
                    this();
                }
            }

            public final void b(int i) {
                this.zzdt |= 1;
                this.zzixd = i;
            }

            public final String a() {
                return this.zzius;
            }

            public final void a(String str) {
                str.getClass();
                this.zzdt |= 2;
                this.zzius = str;
            }

            public final void a(zzd zzdVar) {
                zzdVar.getClass();
                this.zzixe = zzdVar;
                this.zzdt |= 4;
            }

            public final void a(zza zzaVar) {
                this.zzixj = zzaVar.a();
                this.zzdt |= 64;
            }

            public final int b() {
                return this.zzixk.size();
            }

            public final void b(String str) {
                str.getClass();
                zzekp<String> zzekpVar = this.zzixk;
                if (!zzekpVar.a()) {
                    this.zzixk = zzekh.a(zzekpVar);
                }
                this.zzixk.add(str);
            }

            public static C0073zzb c() {
                return zzixl.n();
            }

            @Override // com.google.android.gms.internal.ads.zzekh
            protected final Object a(int i, Object obj, Object obj2) {
                switch (awp.a[i - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C0073zzb(null);
                    case 3:
                        return a(zzixl, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\bဌ\u0006\t\u001a", new Object[]{"zzdt", "zzixd", "zzius", "zzixe", "zzixf", "zzixg", "zzixh", "zzixi", "zzixj", zza.b(), "zzixk"});
                    case 4:
                        return zzixl;
                    case 5:
                        zzemb<zzh> zzembVar = zzei;
                        if (zzembVar == null) {
                            synchronized (zzh.class) {
                                zzembVar = zzei;
                                if (zzembVar == null) {
                                    zzembVar = new zzekh.zzc<>(zzixl);
                                    zzei = zzembVar;
                                }
                            }
                        }
                        return zzembVar;
                    case 6:
                        return Byte.valueOf(this.zziup);
                    case 7:
                        this.zziup = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzh zzhVar = new zzh();
                zzixl = zzhVar;
                zzekh.a((Class<zzh>) zzh.class, zzhVar);
            }
        }

        /* compiled from: source */
        public static final class zzi extends zzekh<zzi, zza> implements zzelu {
            private static volatile zzemb<zzi> zzei;
            private static final zzi zzixu;
            private int zzdt;
            private String zzixr = "";
            private long zzixs;
            private boolean zzixt;

            private zzi() {
            }

            /* compiled from: source */
            public static final class zza extends zzekh.zza<zzi, zza> implements zzelu {
                private zza() {
                    super(zzi.zzixu);
                }

                public final zza a(String str) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zzi) this.a).a(str);
                    return this;
                }

                public final zza a(long j) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zzi) this.a).a(j);
                    return this;
                }

                public final zza a(boolean z) {
                    if (this.b) {
                        c();
                        this.b = false;
                    }
                    ((zzi) this.a).a(z);
                    return this;
                }

                /* synthetic */ zza(awp awpVar) {
                    this();
                }
            }

            public final void a(String str) {
                str.getClass();
                this.zzdt |= 1;
                this.zzixr = str;
            }

            public final void a(long j) {
                this.zzdt |= 2;
                this.zzixs = j;
            }

            public final void a(boolean z) {
                this.zzdt |= 4;
                this.zzixt = z;
            }

            public static zza a() {
                return zzixu.n();
            }

            @Override // com.google.android.gms.internal.ads.zzekh
            protected final Object a(int i, Object obj, Object obj2) {
                switch (awp.a[i - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza(null);
                    case 3:
                        return a(zzixu, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002", new Object[]{"zzdt", "zzixr", "zzixs", "zzixt"});
                    case 4:
                        return zzixu;
                    case 5:
                        zzemb<zzi> zzembVar = zzei;
                        if (zzembVar == null) {
                            synchronized (zzi.class) {
                                zzembVar = zzei;
                                if (zzembVar == null) {
                                    zzembVar = new zzekh.zzc<>(zzixu);
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
                zzi zziVar = new zzi();
                zzixu = zziVar;
                zzekh.a((Class<zzi>) zzi.class, zziVar);
            }
        }

        /* compiled from: source */
        /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zzb */
        public static final class C0067zzb extends zzekh.zza<zzb, C0067zzb> implements zzelu {
            private C0067zzb() {
                super(zzb.zzivr);
            }

            public final C0067zzb a(zzg zzgVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzb) this.a).a(zzgVar);
                return this;
            }

            public final String a() {
                return ((zzb) this.a).a();
            }

            public final C0067zzb a(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzb) this.a).a(str);
                return this;
            }

            public final C0067zzb b(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzb) this.a).b(str);
                return this;
            }

            public final C0067zzb a(zza zzaVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzb) this.a).a(zzaVar);
                return this;
            }

            public final List<zzh> h() {
                return Collections.unmodifiableList(((zzb) this.a).b());
            }

            public final C0067zzb a(zzh zzhVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzb) this.a).a(zzhVar);
                return this;
            }

            public final String i() {
                return ((zzb) this.a).c();
            }

            public final C0067zzb c(String str) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzb) this.a).c(str);
                return this;
            }

            public final C0067zzb j() {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzb) this.a).f();
                return this;
            }

            public final C0067zzb a(zzf zzfVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzb) this.a).a(zzfVar);
                return this;
            }

            public final C0067zzb a(zzi zziVar) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzb) this.a).a(zziVar);
                return this;
            }

            public final C0067zzb a(Iterable<String> iterable) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzb) this.a).a(iterable);
                return this;
            }

            public final C0067zzb b(Iterable<String> iterable) {
                if (this.b) {
                    c();
                    this.b = false;
                }
                ((zzb) this.a).b(iterable);
                return this;
            }

            /* synthetic */ C0067zzb(awp awpVar) {
                this();
            }
        }

        public final void a(zzg zzgVar) {
            this.zzbzz = zzgVar.a();
            this.zzdt |= 1;
        }

        public final String a() {
            return this.zzius;
        }

        public final void a(String str) {
            str.getClass();
            this.zzdt |= 4;
            this.zzius = str;
        }

        public final void b(String str) {
            str.getClass();
            this.zzdt |= 8;
            this.zzivd = str;
        }

        public final void a(zza zzaVar) {
            zzaVar.getClass();
            this.zzivf = zzaVar;
            this.zzdt |= 32;
        }

        public final List<zzh> b() {
            return this.zzivg;
        }

        public final void a(zzh zzhVar) {
            zzhVar.getClass();
            zzekp<zzh> zzekpVar = this.zzivg;
            if (!zzekpVar.a()) {
                this.zzivg = zzekh.a(zzekpVar);
            }
            this.zzivg.add(zzhVar);
        }

        public final String c() {
            return this.zzivh;
        }

        public final void c(String str) {
            str.getClass();
            this.zzdt |= 64;
            this.zzivh = str;
        }

        public final void f() {
            this.zzdt &= -65;
            this.zzivh = zzivr.zzivh;
        }

        public final void a(zzf zzfVar) {
            zzfVar.getClass();
            this.zzivi = zzfVar;
            this.zzdt |= 128;
        }

        public final void a(zzi zziVar) {
            zziVar.getClass();
            this.zzivo = zziVar;
            this.zzdt |= 8192;
        }

        public final void a(Iterable<String> iterable) {
            zzekp<String> zzekpVar = this.zzivp;
            if (!zzekpVar.a()) {
                this.zzivp = zzekh.a(zzekpVar);
            }
            zzeik.a(iterable, this.zzivp);
        }

        public final void b(Iterable<String> iterable) {
            zzekp<String> zzekpVar = this.zzivq;
            if (!zzekpVar.a()) {
                this.zzivq = zzekh.a(zzekpVar);
            }
            zzeik.a(iterable, this.zzivq);
        }

        public static C0067zzb d() {
            return zzivr.n();
        }

        @Override // com.google.android.gms.internal.ads.zzekh
        protected final Object a(int i, Object obj, Object obj2) {
            switch (awp.a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C0067zzb(null);
                case 3:
                    return a(zzivr, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\nဌ\u0000\u000bဌ\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0011ဉ\r\u0014\u001a\u0015\u001a", new Object[]{"zzdt", "zzius", "zzivd", "zzive", "zzivg", zzh.class, "zzivj", "zzivk", "zzivl", "zzivm", "zzivn", "zzbzz", zzg.b(), "zzivc", zza.zzc.b(), "zzivf", "zzivh", "zzivi", "zziul", "zzivo", "zzivp", "zzivq"});
                case 4:
                    return zzivr;
                case 5:
                    zzemb<zzb> zzembVar = zzei;
                    if (zzembVar == null) {
                        synchronized (zzb.class) {
                            zzembVar = zzei;
                            if (zzembVar == null) {
                                zzembVar = new zzekh.zzc<>(zzivr);
                                zzei = zzembVar;
                            }
                        }
                    }
                    return zzembVar;
                case 6:
                    return Byte.valueOf(this.zziup);
                case 7:
                    this.zziup = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzivr = zzbVar;
            zzekh.a((Class<zzb>) zzb.class, zzbVar);
        }
    }
}
