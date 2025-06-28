package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class avk<K, V> implements Iterator<Map.Entry<K, V>> {
    private int a;
    private Iterator<Map.Entry<K, V>> b;
    private final /* synthetic */ avi c;

    private avk(avi aviVar) {
        List list;
        this.c = aviVar;
        list = this.c.b;
        this.a = list.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        if (this.a > 0) {
            int i = this.a;
            list = this.c.b;
            if (i <= list.size()) {
                return true;
            }
        }
        return a().hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> a() {
        Map map;
        if (this.b == null) {
            map = this.c.f;
            this.b = map.entrySet().iterator();
        }
        return this.b;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        if (a().hasNext()) {
            return a().next();
        }
        list = this.c.b;
        int i = this.a - 1;
        this.a = i;
        return (Map.Entry) list.get(i);
    }

    /* synthetic */ avk(avi aviVar, avh avhVar) {
        this(aviVar);
    }
}
