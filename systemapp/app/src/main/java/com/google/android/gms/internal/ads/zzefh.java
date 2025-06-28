package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzefh extends zzekh<zzefh, zza> implements zzelu {
    private static volatile zzemb<zzefh> zzei;
    private static final zzefh zzidv;
    private String zzids = "";
    private zzeiu zzidt = zzeiu.a;
    private int zzidu;

    /* compiled from: source */
    public enum zzb implements zzekj {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);

        private static final zzekm<zzb> g = new arf();
        private final int h;

        @Override // com.google.android.gms.internal.ads.zzekj
        public final int a() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.h;
        }

        public static zzb a(int i2) {
            switch (i2) {
                case 0:
                    return UNKNOWN_KEYMATERIAL;
                case 1:
                    return SYMMETRIC;
                case 2:
                    return ASYMMETRIC_PRIVATE;
                case 3:
                    return ASYMMETRIC_PUBLIC;
                case 4:
                    return REMOTE;
                default:
                    return null;
            }
        }

        @Override // java.lang.Enum
        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(getClass().getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb.append(" number=");
                sb.append(a());
            }
            sb.append(" name=");
            sb.append(name());
            sb.append('>');
            return sb.toString();
        }

        zzb(int i2) {
            this.h = i2;
        }
    }

    private zzefh() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzefh, zza> implements zzelu {
        private zza() {
            super(zzefh.zzidv);
        }

        public final zza a(String str) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzefh) this.a).a(str);
            return this;
        }

        public final zza a(zzeiu zzeiuVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzefh) this.a).a(zzeiuVar);
            return this;
        }

        public final zza a(zzb zzbVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzefh) this.a).a(zzbVar);
            return this;
        }

        /* synthetic */ zza(are areVar) {
            this();
        }
    }

    public final String a() {
        return this.zzids;
    }

    public final void a(String str) {
        str.getClass();
        this.zzids = str;
    }

    public final zzeiu b() {
        return this.zzidt;
    }

    public final void a(zzeiu zzeiuVar) {
        zzeiuVar.getClass();
        this.zzidt = zzeiuVar;
    }

    public final zzb c() {
        zzb a = zzb.a(this.zzidu);
        return a == null ? zzb.UNRECOGNIZED : a;
    }

    public final void a(zzb zzbVar) {
        this.zzidu = zzbVar.a();
    }

    public static zza d() {
        return zzidv.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (are.a[i - 1]) {
            case 1:
                return new zzefh();
            case 2:
                return new zza(null);
            case 3:
                return a(zzidv, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzids", "zzidt", "zzidu"});
            case 4:
                return zzidv;
            case 5:
                zzemb<zzefh> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzefh.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzidv);
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

    public static zzefh e() {
        return zzidv;
    }

    static {
        zzefh zzefhVar = new zzefh();
        zzidv = zzefhVar;
        zzekh.a((Class<zzefh>) zzefh.class, zzefhVar);
    }
}
