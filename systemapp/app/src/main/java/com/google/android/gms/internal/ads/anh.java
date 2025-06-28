package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: source */
/* loaded from: classes.dex */
final class anh<V> extends zzdyi<V> {
    private final zzdyz<V> a;

    anh(zzdyz<V> zzdyzVar) {
        this.a = (zzdyz) zzdvv.a(zzdyzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxo, com.google.android.gms.internal.ads.zzdyz
    public final void a(Runnable runnable, Executor executor) {
        this.a.a(runnable, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzdxo, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.a.cancel(z);
    }

    @Override // com.google.android.gms.internal.ads.zzdxo, java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.a.isCancelled();
    }

    @Override // com.google.android.gms.internal.ads.zzdxo, java.util.concurrent.Future
    public final boolean isDone() {
        return this.a.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzdxo, java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        return this.a.get();
    }

    @Override // com.google.android.gms.internal.ads.zzdxo, java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.a.get(j, timeUnit);
    }

    @Override // com.google.android.gms.internal.ads.zzdxo
    public final String toString() {
        return this.a.toString();
    }
}
