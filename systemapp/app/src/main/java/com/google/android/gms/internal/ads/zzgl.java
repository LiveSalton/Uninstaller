package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzgl implements Callable {
    protected final zzfa a;
    protected final zzcf.zza.C0060zza b;
    protected Method c;
    private final String d = getClass().getSimpleName();
    private final String e;
    private final String f;
    private final int g;
    private final int h;

    public zzgl(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, int i, int i2) {
        this.a = zzfaVar;
        this.e = str;
        this.f = str2;
        this.b = c0060zza;
        this.g = i;
        this.h = i2;
    }

    protected abstract void a() throws IllegalAccessException, InvocationTargetException;

    @Override // java.util.concurrent.Callable
    /* renamed from: b */
    public Void call() throws Exception {
        long nanoTime;
        try {
            nanoTime = System.nanoTime();
            this.c = this.a.a(this.e, this.f);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        if (this.c == null) {
            return null;
        }
        a();
        zzdt h = this.a.h();
        if (h != null && this.g != Integer.MIN_VALUE) {
            h.a(this.h, this.g, (System.nanoTime() - nanoTime) / 1000);
        }
        return null;
    }
}
