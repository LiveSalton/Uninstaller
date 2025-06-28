package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
final class and<V> extends ang<V> {
    private final Callable<V> a;
    private final /* synthetic */ ane b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    and(ane aneVar, Callable<V> callable, Executor executor) {
        super(aneVar, executor);
        this.b = aneVar;
        this.a = (Callable) zzdvv.a(callable);
    }

    @Override // com.google.android.gms.internal.ads.anp
    final V a() throws Exception {
        return this.a.call();
    }

    @Override // com.google.android.gms.internal.ads.ang
    final void a(V v) {
        this.b.b((ane) v);
    }

    @Override // com.google.android.gms.internal.ads.anp
    final String b() {
        return this.a.toString();
    }
}
