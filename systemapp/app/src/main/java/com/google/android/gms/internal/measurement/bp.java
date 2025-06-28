package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
final class bp<T> implements bw<T> {
    private final zzgo a;
    private final cl<?, ?> b;
    private final boolean c;
    private final ap<?> d;

    private bp(cl<?, ?> clVar, ap<?> apVar, zzgo zzgoVar) {
        this.b = clVar;
        this.c = apVar.a(zzgoVar);
        this.d = apVar;
        this.a = zzgoVar;
    }

    static <T> bp<T> a(cl<?, ?> clVar, ap<?> apVar, zzgo zzgoVar) {
        return new bp<>(clVar, apVar, zzgoVar);
    }

    @Override // com.google.android.gms.internal.measurement.bw
    public final boolean a(T t, T t2) {
        if (!this.b.a(t).equals(this.b.a(t2))) {
            return false;
        }
        if (this.c) {
            return this.d.a(t).equals(this.d.a(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.bw
    public final int a(T t) {
        int hashCode = this.b.a(t).hashCode();
        return this.c ? (hashCode * 53) + this.d.a(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.bw
    public final void b(T t, T t2) {
        bx.a(this.b, t, t2);
        if (this.c) {
            bx.a(this.d, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.bw
    public final void b(T t) {
        this.b.b(t);
        this.d.c(t);
    }

    @Override // com.google.android.gms.internal.measurement.bw
    public final boolean c(T t) {
        return this.d.a(t).e();
    }
}
