package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzepi<T> implements zzeoz<T>, zzepf<T> {
    private static final zzepi<Object> a = new zzepi<>(null);
    private final T b;

    public static <T> zzepf<T> a(T t) {
        return new zzepi(zzepl.a(t, "instance cannot be null"));
    }

    public static <T> zzepf<T> b(T t) {
        if (t == null) {
            return a;
        }
        return new zzepi(t);
    }

    private zzepi(T t) {
        this.b = t;
    }

    @Override // com.google.android.gms.internal.ads.zzeoz, com.google.android.gms.internal.ads.zzeps
    public final T b() {
        return this.b;
    }
}
