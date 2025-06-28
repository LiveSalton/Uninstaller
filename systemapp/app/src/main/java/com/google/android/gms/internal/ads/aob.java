package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class aob<V> extends anp<zzdyz<V>> {
    private final zzdxz<V> a;
    private final /* synthetic */ aoc b;

    aob(aoc aocVar, zzdxz<V> zzdxzVar) {
        this.b = aocVar;
        this.a = (zzdxz) zzdvv.a(zzdxzVar);
    }

    @Override // com.google.android.gms.internal.ads.anp
    final boolean c() {
        return this.b.isDone();
    }

    @Override // com.google.android.gms.internal.ads.anp
    final String b() {
        return this.a.toString();
    }

    @Override // com.google.android.gms.internal.ads.anp
    final /* synthetic */ void a(Object obj, Throwable th) {
        zzdyz<? extends V> zzdyzVar = (zzdyz) obj;
        if (th == null) {
            this.b.a((zzdyz) zzdyzVar);
        } else {
            this.b.a(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.anp
    final /* synthetic */ Object a() throws Exception {
        return (zzdyz) zzdvv.a(this.a.a(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.a);
    }
}
