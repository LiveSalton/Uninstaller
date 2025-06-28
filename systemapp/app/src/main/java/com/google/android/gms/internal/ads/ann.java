package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxo;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
class ann<V> implements zzdyz<V> {
    static final zzdyz<?> a = new ann(null);
    private static final Logger b = Logger.getLogger(ann.class.getName());

    @NullableDecl
    private final V c;

    /* compiled from: source */
    static final class a<V> extends zzdxo.j<V> {
        a(Throwable th) {
            a(th);
        }
    }

    ann(@NullableDecl V v) {
        this.c = v;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdyz
    public void a(Runnable runnable, Executor executor) {
        zzdvv.a(runnable, "Runnable was null.");
        zzdvv.a(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = b;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(57 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.ImmediateFuture", "addListener", sb.toString(), (Throwable) e);
        }
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return this.c;
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException {
        zzdvv.a(timeUnit);
        return get();
    }

    public String toString() {
        String obj = super.toString();
        String valueOf = String.valueOf(this.c);
        StringBuilder sb = new StringBuilder(27 + String.valueOf(obj).length() + String.valueOf(valueOf).length());
        sb.append(obj);
        sb.append("[status=SUCCESS, result=[");
        sb.append(valueOf);
        sb.append("]]");
        return sb.toString();
    }
}
