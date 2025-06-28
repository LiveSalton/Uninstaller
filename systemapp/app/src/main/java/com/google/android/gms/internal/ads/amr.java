package com.google.android.gms.internal.ads;

import java.lang.Throwable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
final class amr<V, X extends Throwable> extends amq<V, X, zzdvm<? super X, ? extends V>, V> {
    amr(zzdyz<? extends V> zzdyzVar, Class<X> cls, zzdvm<? super X, ? extends V> zzdvmVar) {
        super(zzdyzVar, cls, zzdvmVar);
    }

    @Override // com.google.android.gms.internal.ads.amq
    final void a(@NullableDecl V v) {
        b((amr<V, X>) v);
    }

    @Override // com.google.android.gms.internal.ads.amq
    @NullableDecl
    final /* synthetic */ Object a(Object obj, Throwable th) throws Exception {
        return ((zzdvm) obj).a(th);
    }
}
