package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdte;
import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdti extends zzekh<zzdti, zza> implements zzelu {
    private static volatile zzemb<zzdti> zzei;
    private static final zzdti zzhqy;
    private int zzdt;
    private int zzhqv;
    private zzdte zzhqx;
    private String zzdu = "";
    private String zzhqw = "";

    /* compiled from: source */
    public enum zzb implements zzekj {
        EVENT_TYPE_UNKNOWN(0),
        BLOCKED_IMPRESSION(1);

        private static final zzekm<zzb> c = new aky();
        private final int d;

        @Override // com.google.android.gms.internal.ads.zzekj
        public final int a() {
            return this.d;
        }

        public static zzb a(int i) {
            switch (i) {
                case 0:
                    return EVENT_TYPE_UNKNOWN;
                case 1:
                    return BLOCKED_IMPRESSION;
                default:
                    return null;
            }
        }

        public static zzekl b() {
            return akz.a;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.d + " name=" + name() + '>';
        }

        zzb(int i) {
            this.d = i;
        }
    }

    private zzdti() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzdti, zza> implements zzelu {
        private zza() {
            super(zzdti.zzhqy);
        }

        public final zza a(zzb zzbVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzdti) this.a).a(zzbVar);
            return this;
        }

        public final zza a(String str) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzdti) this.a).a(str);
            return this;
        }

        public final zza a(zzdte.zzb zzbVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzdti) this.a).a((zzdte) ((zzekh) zzbVar.g()));
            return this;
        }

        /* synthetic */ zza(akx akxVar) {
            this();
        }
    }

    public final void a(zzb zzbVar) {
        this.zzhqv = zzbVar.a();
        this.zzdt |= 1;
    }

    public final void a(String str) {
        str.getClass();
        this.zzdt |= 2;
        this.zzdu = str;
    }

    public final void a(zzdte zzdteVar) {
        zzdteVar.getClass();
        this.zzhqx = zzdteVar;
        this.zzdt |= 8;
    }

    public static zza a() {
        return zzhqy.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (akx.a[i - 1]) {
            case 1:
                return new zzdti();
            case 2:
                return new zza(null);
            case 3:
                return a(zzhqy, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzdt", "zzhqv", zzb.b(), "zzdu", "zzhqw", "zzhqx"});
            case 4:
                return zzhqy;
            case 5:
                zzemb<zzdti> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzdti.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzhqy);
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
        zzdti zzdtiVar = new zzdti();
        zzhqy = zzdtiVar;
        zzekh.a((Class<zzdti>) zzdti.class, zzdtiVar);
    }
}
