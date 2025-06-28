package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzefr extends zzekh<zzefr, zzb> implements zzelu {
    private static volatile zzemb<zzefr> zzei;
    private static final zzefr zzies;
    private int zzieq;
    private zzekp<zza> zzier = t();

    /* compiled from: source */
    public static final class zza extends zzekh<zza, C0063zza> implements zzelu {
        private static volatile zzemb<zza> zzei;
        private static final zza zziew;
        private int zziej;
        private zzefh zziet;
        private int zzieu;
        private int zziev;

        private zza() {
        }

        /* compiled from: source */
        /* renamed from: com.google.android.gms.internal.ads.zzefr$zza$zza */
        public static final class C0063zza extends zzekh.zza<zza, C0063zza> implements zzelu {
            private C0063zza() {
                super(zza.zziew);
            }

            /* synthetic */ C0063zza(arj arjVar) {
                this();
            }
        }

        public final boolean a() {
            return this.zziet != null;
        }

        public final zzefh b() {
            return this.zziet == null ? zzefh.e() : this.zziet;
        }

        public final zzefl c() {
            zzefl a = zzefl.a(this.zzieu);
            return a == null ? zzefl.UNRECOGNIZED : a;
        }

        public final int d() {
            return this.zziev;
        }

        public final zzegd e() {
            zzegd a = zzegd.a(this.zziej);
            return a == null ? zzegd.UNRECOGNIZED : a;
        }

        @Override // com.google.android.gms.internal.ads.zzekh
        protected final Object a(int i, Object obj, Object obj2) {
            switch (arj.a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0063zza(null);
                case 3:
                    return a(zziew, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zziet", "zzieu", "zziev", "zziej"});
                case 4:
                    return zziew;
                case 5:
                    zzemb<zza> zzembVar = zzei;
                    if (zzembVar == null) {
                        synchronized (zza.class) {
                            zzembVar = zzei;
                            if (zzembVar == null) {
                                zzembVar = new zzekh.zzc<>(zziew);
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
            zziew = zzaVar;
            zzekh.a((Class<zza>) zza.class, zzaVar);
        }
    }

    private zzefr() {
    }

    /* compiled from: source */
    public static final class zzb extends zzekh.zza<zzefr, zzb> implements zzelu {
        private zzb() {
            super(zzefr.zzies);
        }

        /* synthetic */ zzb(arj arjVar) {
            this();
        }
    }

    public final int a() {
        return this.zzieq;
    }

    public final List<zza> b() {
        return this.zzier;
    }

    public final int c() {
        return this.zzier.size();
    }

    public static zzefr a(byte[] bArr, zzeju zzejuVar) throws zzeks {
        return (zzefr) zzekh.a(zzies, bArr, zzejuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (arj.a[i - 1]) {
            case 1:
                return new zzefr();
            case 2:
                return new zzb(null);
            case 3:
                return a(zzies, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzieq", "zzier", zza.class});
            case 4:
                return zzies;
            case 5:
                zzemb<zzefr> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzefr.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzies);
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
        zzefr zzefrVar = new zzefr();
        zzies = zzefrVar;
        zzekh.a((Class<zzefr>) zzefr.class, zzefrVar);
    }
}
