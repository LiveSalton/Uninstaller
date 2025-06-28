package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.amw;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
final class ane<V> extends amw<Object, V> {
    private ang<?> a;

    ane(zzdwl<? extends zzdyz<?>> zzdwlVar, boolean z, Executor executor, Callable<V> callable) {
        super(zzdwlVar, z, false);
        this.a = new and(this, callable, executor);
        h();
    }

    @Override // com.google.android.gms.internal.ads.amw
    final void a(int i, @NullableDecl Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.amw
    final void i() {
        ang<?> angVar = this.a;
        if (angVar != null) {
            angVar.d();
        }
    }

    @Override // com.google.android.gms.internal.ads.amw
    final void a(amw.a aVar) {
        super.a(aVar);
        if (aVar == amw.a.OUTPUT_FUTURE_DONE) {
            this.a = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdxo
    protected final void c() {
        ang<?> angVar = this.a;
        if (angVar != null) {
            angVar.e();
        }
    }

    static /* synthetic */ ang a(ane aneVar, ang angVar) {
        aneVar.a = null;
        return null;
    }
}
