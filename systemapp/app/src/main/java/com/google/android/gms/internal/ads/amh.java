package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class amh<K, V> extends zzdwt<Map.Entry<K, V>> {
    private final transient zzdwq<K, V> a;
    private final transient Object[] b;
    private final transient int c = 0;
    private final transient int d;

    amh(zzdwq<K, V> zzdwqVar, Object[] objArr, int i, int i2) {
        this.a = zzdwqVar;
        this.b = objArr;
        this.d = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final boolean f() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    /* renamed from: a */
    public final zzdxh<Map.Entry<K, V>> iterator() {
        return (zzdxh) e().iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final int a(Object[] objArr, int i) {
        return e().a(objArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzdwt
    final zzdwm<Map.Entry<K, V>> h() {
        return new amk(this);
    }

    @Override // com.google.android.gms.internal.ads.zzdwl, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        return value != null && value.equals(this.a.get(key));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzdwt, com.google.android.gms.internal.ads.zzdwl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
