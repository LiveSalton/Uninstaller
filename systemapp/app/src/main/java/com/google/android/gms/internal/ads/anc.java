package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final class anc<V> extends ana<V, List<V>> {
    anc(zzdwl<? extends zzdyz<? extends V>> zzdwlVar, boolean z) {
        super(zzdwlVar, true);
        h();
    }

    @Override // com.google.android.gms.internal.ads.ana
    public final /* synthetic */ Object a(List list) {
        ArrayList a = zzdwu.a(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            anb anbVar = (anb) it.next();
            a.add(anbVar != null ? anbVar.a : null);
        }
        return Collections.unmodifiableList(a);
    }
}
