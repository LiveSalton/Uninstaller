package com.google.android.gms.internal.ads;

import java.lang.Throwable;

/* compiled from: source */
/* loaded from: classes.dex */
final class amp<V, X extends Throwable> extends amq<V, X, zzdyb<? super X, ? extends V>, zzdyz<? extends V>> {
    amp(zzdyz<? extends V> zzdyzVar, Class<X> cls, zzdyb<? super X, ? extends V> zzdybVar) {
        super(zzdyzVar, cls, zzdybVar);
    }

    @Override // com.google.android.gms.internal.ads.amq
    final /* synthetic */ void a(Object obj) {
        a((zzdyz) obj);
    }

    @Override // com.google.android.gms.internal.ads.amq
    final /* synthetic */ Object a(Object obj, Throwable th) throws Exception {
        zzdyb zzdybVar = (zzdyb) obj;
        zzdyz a = zzdybVar.a(th);
        zzdvv.a(a, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzdybVar);
        return a;
    }
}
