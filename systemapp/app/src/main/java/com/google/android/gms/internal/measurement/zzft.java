package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzft {
    private static final zzeq a = zzeq.a();
    private zzdu b;
    private volatile zzgo c;
    private volatile zzdu d;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzft)) {
            return false;
        }
        zzft zzftVar = (zzft) obj;
        zzgo zzgoVar = this.c;
        zzgo zzgoVar2 = zzftVar.c;
        if (zzgoVar == null && zzgoVar2 == null) {
            return b().equals(zzftVar.b());
        }
        if (zzgoVar != null && zzgoVar2 != null) {
            return zzgoVar.equals(zzgoVar2);
        }
        if (zzgoVar != null) {
            return zzgoVar.equals(zzftVar.b(zzgoVar.g()));
        }
        return b(zzgoVar2.g()).equals(zzgoVar2);
    }

    private final zzgo b(zzgo zzgoVar) {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    try {
                        this.c = zzgoVar;
                        this.d = zzdu.a;
                    } catch (zzfo unused) {
                        this.c = zzgoVar;
                        this.d = zzdu.a;
                    }
                }
            }
        }
        return this.c;
    }

    public final zzgo a(zzgo zzgoVar) {
        zzgo zzgoVar2 = this.c;
        this.b = null;
        this.d = null;
        this.c = zzgoVar;
        return zzgoVar2;
    }

    public final zzdu b() {
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d != null) {
                return this.d;
            }
            if (this.c == null) {
                this.d = zzdu.a;
            } else {
                this.d = this.c.c();
            }
            return this.d;
        }
    }
}
