package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaj<T> {
    public final T a;
    public final zzn b;
    public final zzao c;
    public boolean d;

    public static <T> zzaj<T> a(T t, zzn zznVar) {
        return new zzaj<>(t, zznVar);
    }

    public static <T> zzaj<T> a(zzao zzaoVar) {
        return new zzaj<>(zzaoVar);
    }

    public final boolean a() {
        return this.c == null;
    }

    private zzaj(T t, zzn zznVar) {
        this.d = false;
        this.a = t;
        this.b = zznVar;
        this.c = null;
    }

    private zzaj(zzao zzaoVar) {
        this.d = false;
        this.a = null;
        this.b = null;
        this.c = zzaoVar;
    }
}
