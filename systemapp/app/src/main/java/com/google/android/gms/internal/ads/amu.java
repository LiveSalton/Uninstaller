package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
final class amu<I, O> extends ams<I, O, zzdyb<? super I, ? extends O>, zzdyz<? extends O>> {
    amu(zzdyz<? extends I> zzdyzVar, zzdyb<? super I, ? extends O> zzdybVar) {
        super(zzdyzVar, zzdybVar);
    }

    @Override // com.google.android.gms.internal.ads.ams
    final /* synthetic */ void a(Object obj) {
        a((zzdyz) obj);
    }

    @Override // com.google.android.gms.internal.ads.ams
    final /* synthetic */ Object a(Object obj, @NullableDecl Object obj2) throws Exception {
        zzdyb zzdybVar = (zzdyb) obj;
        zzdyz<O> a = zzdybVar.a(obj2);
        zzdvv.a(a, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzdybVar);
        return a;
    }
}
