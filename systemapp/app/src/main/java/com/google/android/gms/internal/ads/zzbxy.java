package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbxy<T> {
    public T a;
    public Executor b;

    public static <T> zzbxy<T> a(T t, Executor executor) {
        return new zzbxy<>(t, executor);
    }

    public zzbxy(T t, Executor executor) {
        this.a = t;
        this.b = executor;
    }
}
