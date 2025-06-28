package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
@Deprecated
/* loaded from: classes.dex */
public final class zzefo extends zzekh<zzefo, zza> implements zzelu {
    private static volatile zzemb<zzefo> zzei;
    private static final zzefo zziep;
    private int zziem;
    private boolean zzien;
    private String zziel = "";
    private String zzids = "";
    private String zzieo = "";

    private zzefo() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzefo, zza> implements zzelu {
        private zza() {
            super(zzefo.zziep);
        }

        /* synthetic */ zza(ari ariVar) {
            this();
        }
    }

    public final String a() {
        return this.zziel;
    }

    public final String b() {
        return this.zzids;
    }

    public final int c() {
        return this.zziem;
    }

    public final boolean d() {
        return this.zzien;
    }

    public final String e() {
        return this.zzieo;
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (ari.a[i - 1]) {
            case 1:
                return new zzefo();
            case 2:
                return new zza(null);
            case 3:
                return a(zziep, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zziel", "zzids", "zziem", "zzien", "zzieo"});
            case 4:
                return zziep;
            case 5:
                zzemb<zzefo> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzefo.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zziep);
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
        zzefo zzefoVar = new zzefo();
        zziep = zzefoVar;
        zzekh.a((Class<zzefo>) zzefo.class, zzefoVar);
    }
}
