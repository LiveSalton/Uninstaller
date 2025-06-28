package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzedy extends zzekh<zzedy, zza> implements zzelu {
    private static volatile zzemb<zzedy> zzei;
    private static final zzedy zzibw;
    private int zziaz;
    private zzeiu zziba = zzeiu.a;

    private zzedy() {
    }

    /* compiled from: source */
    public static final class zza extends zzekh.zza<zzedy, zza> implements zzelu {
        private zza() {
            super(zzedy.zzibw);
        }

        public final zza a(int i) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzedy) this.a).b(0);
            return this;
        }

        public final zza a(zzeiu zzeiuVar) {
            if (this.b) {
                c();
                this.b = false;
            }
            ((zzedy) this.a).a(zzeiuVar);
            return this;
        }

        /* synthetic */ zza(aql aqlVar) {
            this();
        }
    }

    public final int a() {
        return this.zziaz;
    }

    public final void b(int i) {
        this.zziaz = i;
    }

    public final zzeiu b() {
        return this.zziba;
    }

    public final void a(zzeiu zzeiuVar) {
        zzeiuVar.getClass();
        this.zziba = zzeiuVar;
    }

    public static zzedy a(zzeiu zzeiuVar, zzeju zzejuVar) throws zzeks {
        return (zzedy) zzekh.a(zzibw, zzeiuVar, zzejuVar);
    }

    public static zza c() {
        return zzibw.n();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    protected final Object a(int i, Object obj, Object obj2) {
        switch (aql.a[i - 1]) {
            case 1:
                return new zzedy();
            case 2:
                return new zza(null);
            case 3:
                return a(zzibw, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zziaz", "zziba"});
            case 4:
                return zzibw;
            case 5:
                zzemb<zzedy> zzembVar = zzei;
                if (zzembVar == null) {
                    synchronized (zzedy.class) {
                        zzembVar = zzei;
                        if (zzembVar == null) {
                            zzembVar = new zzekh.zzc<>(zzibw);
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
        zzedy zzedyVar = new zzedy();
        zzibw = zzedyVar;
        zzekh.a((Class<zzedy>) zzedy.class, zzedyVar);
    }
}
