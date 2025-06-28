package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzby {

    /* compiled from: source */
    public static final class zza extends zzekh<zza, C0059zza> implements zzelu {
        private static volatile zzemb<zza> zzei;
        private static final zza zzeu;
        private int zzdt;
        private zzb zzes;
        private zzc zzet;

        private zza() {
        }

        /* compiled from: source */
        /* renamed from: com.google.android.gms.internal.ads.zzby$zza$zza */
        public static final class C0059zza extends zzekh.zza<zza, C0059zza> implements zzelu {
            private C0059zza() {
                super(zza.zzeu);
            }

            /* synthetic */ C0059zza(qj qjVar) {
                this();
            }
        }

        public final boolean a() {
            return (this.zzdt & 1) != 0;
        }

        public final zzb b() {
            return this.zzes == null ? zzb.b() : this.zzes;
        }

        public final boolean c() {
            return (this.zzdt & 2) != 0;
        }

        public final zzc d() {
            return this.zzet == null ? zzc.b() : this.zzet;
        }

        @Override // com.google.android.gms.internal.ads.zzekh
        protected final Object a(int i, Object obj, Object obj2) {
            switch (qj.a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0059zza(null);
                case 3:
                    return a(zzeu, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzdt", "zzes", "zzet"});
                case 4:
                    return zzeu;
                case 5:
                    zzemb<zza> zzembVar = zzei;
                    if (zzembVar == null) {
                        synchronized (zza.class) {
                            zzembVar = zzei;
                            if (zzembVar == null) {
                                zzembVar = new zzekh.zzc<>(zzeu);
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
            zzeu = zzaVar;
            zzekh.a((Class<zza>) zza.class, zzaVar);
        }
    }

    /* compiled from: source */
    public static final class zzb extends zzekh<zzb, zza> implements zzelu {
        private static volatile zzemb<zzb> zzei;
        private static final zzb zzew;
        private int zzdt;
        private int zzev = 2;

        private zzb() {
        }

        /* compiled from: source */
        public static final class zza extends zzekh.zza<zzb, zza> implements zzelu {
            private zza() {
                super(zzb.zzew);
            }

            /* synthetic */ zza(qj qjVar) {
                this();
            }
        }

        public final zzcb a() {
            zzcb a = zzcb.a(this.zzev);
            return a == null ? zzcb.ENUM_SIGNAL_SOURCE_ADSHIELD : a;
        }

        @Override // com.google.android.gms.internal.ads.zzekh
        protected final Object a(int i, Object obj, Object obj2) {
            switch (qj.a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return a(zzew, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001bဌ\u0000", new Object[]{"zzdt", "zzev", zzcb.b()});
                case 4:
                    return zzew;
                case 5:
                    zzemb<zzb> zzembVar = zzei;
                    if (zzembVar == null) {
                        synchronized (zzb.class) {
                            zzembVar = zzei;
                            if (zzembVar == null) {
                                zzembVar = new zzekh.zzc<>(zzew);
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

        public static zzb b() {
            return zzew;
        }

        static {
            zzb zzbVar = new zzb();
            zzew = zzbVar;
            zzekh.a((Class<zzb>) zzb.class, zzbVar);
        }
    }

    /* compiled from: source */
    public static final class zzc extends zzekh<zzc, zza> implements zzelu {
        private static volatile zzemb<zzc> zzei;
        private static final zzc zzfj;
        private int zzdt;
        private String zzfd = "";
        private String zzfe = "";
        private String zzff = "";
        private String zzfg = "";
        private String zzfh = "";
        private String zzfi = "";

        private zzc() {
        }

        /* compiled from: source */
        public static final class zza extends zzekh.zza<zzc, zza> implements zzelu {
            private zza() {
                super(zzc.zzfj);
            }

            /* synthetic */ zza(qj qjVar) {
                this();
            }
        }

        public final String a() {
            return this.zzfd;
        }

        @Override // com.google.android.gms.internal.ads.zzekh
        protected final Object a(int i, Object obj, Object obj2) {
            switch (qj.a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return a(zzfj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005", new Object[]{"zzdt", "zzfd", "zzfe", "zzff", "zzfg", "zzfh", "zzfi"});
                case 4:
                    return zzfj;
                case 5:
                    zzemb<zzc> zzembVar = zzei;
                    if (zzembVar == null) {
                        synchronized (zzc.class) {
                            zzembVar = zzei;
                            if (zzembVar == null) {
                                zzembVar = new zzekh.zzc<>(zzfj);
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

        public static zzc b() {
            return zzfj;
        }

        static {
            zzc zzcVar = new zzc();
            zzfj = zzcVar;
            zzekh.a((Class<zzc>) zzc.class, zzcVar);
        }
    }
}
