package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class amk<K, V> extends zzdwm<Map.Entry<K, V>> {
    private final /* synthetic */ amh a;

    amk(amh amhVar) {
        this.a = amhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    public final boolean f() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i;
        i = this.a.d;
        return i;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        int i2;
        Object[] objArr;
        Object[] objArr2;
        i2 = this.a.d;
        zzdvv.a(i, i2);
        objArr = this.a.b;
        int i3 = 2 * i;
        Object obj = objArr[i3];
        objArr2 = this.a.b;
        return new AbstractMap.SimpleImmutableEntry(obj, objArr2[i3 + 1]);
    }
}
