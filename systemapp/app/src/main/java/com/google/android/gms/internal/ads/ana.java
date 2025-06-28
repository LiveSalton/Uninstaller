package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.amw;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class ana<V, C> extends amw<V, C> {
    private List<anb<V>> a;

    ana(zzdwl<? extends zzdyz<? extends V>> zzdwlVar, boolean z) {
        super(zzdwlVar, true, true);
        List<anb<V>> g = zzdwlVar.isEmpty() ? zzdwm.g() : zzdwu.a(zzdwlVar.size());
        for (int i = 0; i < zzdwlVar.size(); i++) {
            g.add(null);
        }
        this.a = g;
    }

    abstract C a(List<anb<V>> list);

    @Override // com.google.android.gms.internal.ads.amw
    final void a(int i, @NullableDecl V v) {
        List<anb<V>> list = this.a;
        if (list != null) {
            list.set(i, new anb<>(v));
        }
    }

    @Override // com.google.android.gms.internal.ads.amw
    final void i() {
        List<anb<V>> list = this.a;
        if (list != null) {
            b((ana<V, C>) a((List) list));
        }
    }

    @Override // com.google.android.gms.internal.ads.amw
    final void a(amw.a aVar) {
        super.a(aVar);
        this.a = null;
    }
}
