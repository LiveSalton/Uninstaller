package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
final class aoc<V> extends ani<V> implements RunnableFuture<V> {
    private volatile anp<?> a;

    static <V> aoc<V> a(Callable<V> callable) {
        return new aoc<>(callable);
    }

    static <V> aoc<V> a(Runnable runnable, @NullableDecl V v) {
        return new aoc<>(Executors.callable(runnable, v));
    }

    private aoc(Callable<V> callable) {
        this.a = new aod(this, callable);
    }

    aoc(zzdxz<V> zzdxzVar) {
        this.a = new aob(this, zzdxzVar);
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        anp<?> anpVar = this.a;
        if (anpVar != null) {
            anpVar.run();
        }
        this.a = null;
    }

    @Override // com.google.android.gms.internal.ads.zzdxo
    protected final void b() {
        anp<?> anpVar;
        super.b();
        if (d() && (anpVar = this.a) != null) {
            anpVar.e();
        }
        this.a = null;
    }

    @Override // com.google.android.gms.internal.ads.zzdxo
    protected final String a() {
        anp<?> anpVar = this.a;
        if (anpVar != null) {
            String valueOf = String.valueOf(anpVar);
            StringBuilder sb = new StringBuilder(7 + String.valueOf(valueOf).length());
            sb.append("task=[");
            sb.append(valueOf);
            sb.append("]");
            return sb.toString();
        }
        return super.a();
    }
}
