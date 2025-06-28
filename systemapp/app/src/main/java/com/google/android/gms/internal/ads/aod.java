package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
final class aod<V> extends anp<V> {
    private final Callable<V> a;
    private final /* synthetic */ aoc b;

    aod(aoc aocVar, Callable<V> callable) {
        this.b = aocVar;
        this.a = (Callable) zzdvv.a(callable);
    }

    @Override // com.google.android.gms.internal.ads.anp
    final boolean c() {
        return this.b.isDone();
    }

    @Override // com.google.android.gms.internal.ads.anp
    final V a() throws Exception {
        return this.a.call();
    }

    @Override // com.google.android.gms.internal.ads.anp
    final void a(V v, Throwable th) {
        if (th == null) {
            this.b.b((aoc) v);
        } else {
            this.b.a(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.anp
    final String b() {
        return this.a.toString();
    }
}
