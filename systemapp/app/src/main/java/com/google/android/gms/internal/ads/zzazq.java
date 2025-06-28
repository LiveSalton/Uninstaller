package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class zzazq<T> implements zzdyz<T> {
    private final zzdzh<T> a = zzdzh.h();

    public final boolean b(T t) {
        return a(this.a.b((zzdzh<T>) t));
    }

    public final boolean a(Throwable th) {
        return a(this.a.a(th));
    }

    private static boolean a(boolean z) {
        if (!z) {
            zzp.g().b(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture");
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzdyz
    public void a(Runnable runnable, Executor executor) {
        this.a.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.a.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.a.isDone();
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        return this.a.get();
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.a.get(j, timeUnit);
    }
}
