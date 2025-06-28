package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzdwq<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] a = new Map.Entry[0];
    private transient zzdwt<Map.Entry<K, V>> b;
    private transient zzdwt<K> c;
    private transient zzdwl<V> d;

    public static <K, V> zzdwq<K, V> a(K k, V v) {
        alz.a(k, v);
        return ami.a(1, new Object[]{k, v});
    }

    abstract zzdwt<Map.Entry<K, V>> a();

    abstract zzdwt<K> b();

    abstract zzdwl<V> c();

    public abstract V get(@NullableDecl Object obj);

    public static <K, V> zzdwq<K, V> a(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        alz.a(k, v);
        alz.a(k2, v2);
        alz.a(k3, v3);
        alz.a(k4, v4);
        return ami.a(4, new Object[]{k, v, k2, v2, k3, v3, k4, v4});
    }

    zzdwq() {
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzdwl) values()).contains(obj);
    }

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public int hashCode() {
        return zzdxf.a((zzdwt) entrySet());
    }

    public String toString() {
        int size = size();
        alz.a(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(size << 3, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            z = false;
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public /* synthetic */ Set entrySet() {
        zzdwt<Map.Entry<K, V>> zzdwtVar = this.b;
        if (zzdwtVar != null) {
            return zzdwtVar;
        }
        zzdwt<Map.Entry<K, V>> a2 = a();
        this.b = a2;
        return a2;
    }

    @Override // java.util.Map
    public /* synthetic */ Collection values() {
        zzdwl<V> zzdwlVar = this.d;
        if (zzdwlVar != null) {
            return zzdwlVar;
        }
        zzdwl<V> c = c();
        this.d = c;
        return c;
    }

    @Override // java.util.Map
    public /* synthetic */ Set keySet() {
        zzdwt<K> zzdwtVar = this.c;
        if (zzdwtVar != null) {
            return zzdwtVar;
        }
        zzdwt<K> b = b();
        this.c = b;
        return b;
    }
}
