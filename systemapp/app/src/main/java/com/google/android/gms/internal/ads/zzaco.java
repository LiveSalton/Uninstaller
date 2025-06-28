package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaco<T> extends zzacn<T> {
    public static zzacn<Boolean> b(String str, boolean z) {
        return new zzaco(str, true, v.a);
    }

    protected zzaco(String str, Object obj, int i) {
        super(str, obj, i);
    }

    @Override // com.google.android.gms.internal.ads.zzacn
    public final T a() {
        if (!zzado.a.get()) {
            throw new IllegalStateException("Striped code is accessed: 54c42518-856a-44fb-aae0-cd6676d514e5");
        }
        return (T) super.a();
    }
}
