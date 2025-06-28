package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdqx<E, V> implements zzdyz<V> {
    private final E a;
    private final String b;
    private final zzdyz<V> c;

    public zzdqx(E e, String str, zzdyz<V> zzdyzVar) {
        this.a = e;
        this.b = str;
        this.c = zzdyzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyz
    public final void a(Runnable runnable, Executor executor) {
        this.c.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.c.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        return this.c.get();
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.c.get(j, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.c.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.c.isDone();
    }

    public final E a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String toString() {
        String str = this.b;
        int identityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(12 + String.valueOf(str).length());
        sb.append(str);
        sb.append("@");
        sb.append(identityHashCode);
        return sb.toString();
    }
}
