package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final class awz<E> implements Iterator<E> {
    private int a = 0;
    private final /* synthetic */ zzeov b;

    awz(zzeov zzeovVar) {
        this.b = zzeovVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b.a.size() || this.b.b.hasNext();
    }

    @Override // java.util.Iterator
    public final E next() {
        while (this.a >= this.b.a.size()) {
            this.b.a.add(this.b.b.next());
        }
        List<E> list = this.b.a;
        int i = this.a;
        this.a = i + 1;
        return list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
