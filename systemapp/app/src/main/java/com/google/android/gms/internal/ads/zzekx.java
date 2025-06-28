package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzekx {
    private static final zzeju a = zzeju.a();
    private zzeiu b;
    private volatile zzels c;
    private volatile zzeiu d;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzekx)) {
            return false;
        }
        zzekx zzekxVar = (zzekx) obj;
        zzels zzelsVar = this.c;
        zzels zzelsVar2 = zzekxVar.c;
        if (zzelsVar == null && zzelsVar2 == null) {
            return c().equals(zzekxVar.c());
        }
        if (zzelsVar != null && zzelsVar2 != null) {
            return zzelsVar.equals(zzelsVar2);
        }
        if (zzelsVar != null) {
            return zzelsVar.equals(zzekxVar.b(zzelsVar.w()));
        }
        return b(zzelsVar2.w()).equals(zzelsVar2);
    }

    private final zzels b(zzels zzelsVar) {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    try {
                        this.c = zzelsVar;
                        this.d = zzeiu.a;
                    } catch (zzeks unused) {
                        this.c = zzelsVar;
                        this.d = zzeiu.a;
                    }
                }
            }
        }
        return this.c;
    }

    public final zzels a(zzels zzelsVar) {
        zzels zzelsVar2 = this.c;
        this.b = null;
        this.d = null;
        this.c = zzelsVar;
        return zzelsVar2;
    }

    public final int b() {
        if (this.d != null) {
            return this.d.b();
        }
        if (this.c != null) {
            return this.c.q();
        }
        return 0;
    }

    public final zzeiu c() {
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d != null) {
                return this.d;
            }
            if (this.c == null) {
                this.d = zzeiu.a;
            } else {
                this.d = this.c.k();
            }
            return this.d;
        }
    }
}
