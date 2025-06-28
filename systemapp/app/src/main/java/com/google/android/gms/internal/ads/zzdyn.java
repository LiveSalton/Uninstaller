package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzdyn<V> extends zzdwj implements Future<V> {
    protected zzdyn() {
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    /* renamed from: c */
    public abstract Future<? extends V> a();

    public boolean cancel(boolean z) {
        return a().cancel(z);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return a().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return a().isDone();
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return a().get();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a().get(j, timeUnit);
    }
}
