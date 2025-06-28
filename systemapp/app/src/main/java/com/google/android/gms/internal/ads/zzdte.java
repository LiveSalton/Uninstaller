package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdte extends zzekh<zzdte, zzb> implements zzelu {
    private static volatile zzemb<zzdte> zzei;
    private static final zzekn<Integer, zza> zzhqn = new akt();
    private static final zzdte zzhqr;
    private int zzdt;
    private zzeko zzhqm = r();
    private String zzhqo = "";
    private String zzhqp = "";
    private String zzhqq = "";

    /* compiled from: source */
    public enum zza implements zzekj {
        BLOCKED_REASON_UNKNOWN(1),
        BLOCKED_REASON_BACKGROUND(2);

        private static final zzekm<zza> c = new akw();
        private final int d;

        @Override // com.google.android.gms.internal.ads.zzekj
        public final int a() {
            return this.d;
        }

        public static zza a(int i) {
            switch (i) {
                case 1:
                    return BLOCKED_REASON_UNKNOWN;
                case 2:
                    return BLOCKED_REASON_BACKGROUND;
                default:
                    return null;
            }
        }

        public static zzekl b() {
            return akv.a;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.d + " name=" + name() + '>';
        }

        zza(int i) {
            this.d = i;
        }
    }

    private zzdte() {
    }

    /* compiled from: source */
    public static final class zzb extends zzekh.zza<zzdte, zzb> implements zzelu {
        private zzb() {
            super(zzdte.zzhqr);
        }

        public final zzb a(zza zzaVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzdte) this.a).a(zzaVar);
            return this;
        }

        public final zzb a(String str) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzdte) this.a).a(str);
            return this;
        }

        /* synthetic */ zzb(akt aktVar) {
            this();
        }
    }

    public final void a(zza zzaVar) {
        zzaVar.getClass();
        zzeko zzekoVar = this.zzhqm;
        if (!zzekoVar.a()) {
            this.zzhqm = zzekh.a(zzekoVar);
        }
        this.zzhqm.d(zzaVar.a());
    }

    public final void a(String str) {
        str.getClass();
        this.zzdt |= 1;
        this.zzhqo = str;
    }

    public static zzb a() {
        return zzhqr.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aku.a[i - 1]) {
            case 1:
                return new zzdte();
            case 2:
                return new zzb(null);
            case 3:
                return a(zzhqr, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzdt", "zzhqm", zza.b(), "zzhqo", "zzhqp", "zzhqq"});
            case 4:
                return zzhqr;
            case 5:
                zzemb<zzdte> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzdte.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzhqr);
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
        zzdte zzdteVar = new zzdte();
        zzhqr = zzdteVar;
        zzekh.a((Class<zzdte>) zzdte.class, zzdteVar);
    }
}
