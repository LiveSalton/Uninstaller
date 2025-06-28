package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzgt extends zzekh<zzgt, zza> implements zzelu {
    private static final zzgt zzacf;
    private static volatile zzemb<zzgt> zzei;
    private String zzaca = "";
    private String zzacb = "";
    private long zzacc;
    private long zzacd;
    private long zzace;
    private int zzdt;

    private zzgt() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzgt, zza> implements zzelu {
        private zza() {
            super(zzgt.zzacf);
        }

        public final zza a(String str) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzgt) this.a).a(str);
            return this;
        }

        public final zza b(String str) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzgt) this.a).b(str);
            return this;
        }

        public final zza a(long j) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzgt) this.a).a(j);
            return this;
        }

        public final zza b(long j) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzgt) this.a).b(j);
            return this;
        }

        public final zza c(long j) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzgt) this.a).c(j);
            return this;
        }

        /* synthetic */ zza(axv axvVar) {
            this();
        }
    }

    public final String a() {
        return this.zzaca;
    }

    public final void a(String str) {
        str.getClass();
        this.zzdt |= 1;
        this.zzaca = str;
    }

    public final String b() {
        return this.zzacb;
    }

    public final void b(String str) {
        str.getClass();
        this.zzdt |= 2;
        this.zzacb = str;
    }

    public final long c() {
        return this.zzacc;
    }

    public final void a(long j) {
        this.zzdt |= 4;
        this.zzacc = j;
    }

    public final long d() {
        return this.zzacd;
    }

    public final void b(long j) {
        this.zzdt |= 8;
        this.zzacd = j;
    }

    public final long e() {
        return this.zzace;
    }

    public final void c(long j) {
        this.zzdt |= 16;
        this.zzace = j;
    }

    public static zzgt a(zzeiu zzeiuVar) throws zzeks {
        return (zzgt) zzekh.a(zzacf, zzeiuVar);
    }

    public static zzgt a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzgt) zzekh.a(zzacf, zzeiuVar, zzejuVar);
    }

    public static zza f() {
        return zzacf.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (axv.a[i - 1]) {
            case 1:
                return new zzgt();
            case 2:
                return new zza(null);
            case 3:
                return a(zzacf, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzdt", "zzaca", "zzacb", "zzacc", "zzacd", "zzace"});
            case 4:
                return zzacf;
            case 5:
                zzemb<zzgt> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzgt.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzacf);
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

    public static zzgt g() {
        return zzacf;
    }

    static {
        zzgt zzgtVar = new zzgt();
        zzacf = zzgtVar;
        zzekh.a((Class<zzgt>) zzgt.class, zzgtVar);
    }
}
