package com.google.android.gms.internal.measurement;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: source */
/* loaded from: classes.dex */
class ca<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int a;
    private List<cd> b;
    private Map<K, V> c;
    private boolean d;
    private volatile cf e;
    private Map<K, V> f;

    static <FieldDescriptorType extends zzey<FieldDescriptorType>> ca<FieldDescriptorType, Object> a(int i) {
        return new bz(i);
    }

    private ca(int i) {
        this.a = i;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
        this.f = Collections.emptyMap();
    }

    public void a() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (this.d) {
            return;
        }
        if (this.c.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.c);
        }
        this.c = unmodifiableMap;
        if (this.f.isEmpty()) {
            unmodifiableMap2 = Collections.emptyMap();
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.f);
        }
        this.f = unmodifiableMap2;
        this.d = true;
    }

    public final boolean b() {
        return this.d;
    }

    public final int c() {
        return this.b.size();
    }

    public final Map.Entry<K, V> b(int i) {
        return this.b.get(i);
    }

    public final Iterable<Map.Entry<K, V>> d() {
        if (this.c.isEmpty()) {
            return cc.a();
        }
        return this.c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.b.size() + this.c.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a((ca<K, V>) comparable) >= 0 || this.c.containsKey(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a = a((ca<K, V>) comparable);
        if (a >= 0) {
            return (V) this.b.get(a).getValue();
        }
        return this.c.get(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V a(K k, V v) {
        e();
        int a = a((ca<K, V>) k);
        if (a >= 0) {
            return (V) this.b.get(a).setValue(v);
        }
        e();
        if (this.b.isEmpty() && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList(this.a);
        }
        int i = -(a + 1);
        if (i >= this.a) {
            return f().put(k, v);
        }
        if (this.b.size() == this.a) {
            cd remove = this.b.remove(this.a - 1);
            f().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.b.add(i, new cd(this, k, v));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        e();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (this.c.isEmpty()) {
            return;
        }
        this.c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e();
        Comparable comparable = (Comparable) obj;
        int a = a((ca<K, V>) comparable);
        if (a >= 0) {
            return (V) c(a);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(comparable);
    }

    public final V c(int i) {
        e();
        V v = (V) this.b.remove(i).getValue();
        if (!this.c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = f().entrySet().iterator();
            this.b.add(new cd(this, it.next()));
            it.remove();
        }
        return v;
    }

    private final int a(K k) {
        int size = this.b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.b.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.b.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i2;
                }
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.e == null) {
            this.e = new cf(this, null);
        }
        return this.e;
    }

    public final void e() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> f() {
        e();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            this.c = new TreeMap();
            this.f = ((TreeMap) this.c).descendingMap();
        }
        return (SortedMap) this.c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ca)) {
            return super.equals(obj);
        }
        ca caVar = (ca) obj;
        int size = size();
        if (size != caVar.size()) {
            return false;
        }
        int c = c();
        if (c != caVar.c()) {
            return entrySet().equals(caVar.entrySet());
        }
        for (int i = 0; i < c; i++) {
            if (!b(i).equals(caVar.b(i))) {
                return false;
            }
        }
        if (c != size) {
            return this.c.equals(caVar.c);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int c = c();
        int i = 0;
        for (int i2 = 0; i2 < c; i2++) {
            i += this.b.get(i2).hashCode();
        }
        return this.c.size() > 0 ? i + this.c.hashCode() : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return a((ca<K, V>) obj, (Comparable) obj2);
    }

    /* synthetic */ ca(int i, bz bzVar) {
        this(i);
    }
}
