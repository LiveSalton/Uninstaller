package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class cg<K, V> implements Iterator<Map.Entry<K, V>> {
    private int a;
    private boolean b;
    private Iterator<Map.Entry<K, V>> c;
    private final /* synthetic */ ca d;

    private cg(ca caVar) {
        this.d = caVar;
        this.a = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.a + 1;
        list = this.d.b;
        if (i >= list.size()) {
            map = this.d.c;
            if (map.isEmpty() || !a().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.b = false;
        this.d.e();
        int i = this.a;
        list = this.d.b;
        if (i < list.size()) {
            ca caVar = this.d;
            int i2 = this.a;
            this.a = i2 - 1;
            caVar.c(i2);
            return;
        }
        a().remove();
    }

    private final Iterator<Map.Entry<K, V>> a() {
        Map map;
        if (this.c == null) {
            map = this.d.c;
            this.c = map.entrySet().iterator();
        }
        return this.c;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        List list2;
        this.b = true;
        int i = this.a + 1;
        this.a = i;
        list = this.d.b;
        if (i >= list.size()) {
            return a().next();
        }
        list2 = this.d.b;
        return (Map.Entry) list2.get(this.a);
    }

    /* synthetic */ cg(ca caVar, bz bzVar) {
        this(caVar);
    }
}
