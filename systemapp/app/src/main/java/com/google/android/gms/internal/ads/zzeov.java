package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzeov<E> extends AbstractList<E> {
    private static final zzeox c = zzeox.a(zzeov.class);
    List<E> a;
    Iterator<E> b;

    public zzeov(List<E> list, Iterator<E> it) {
        this.a = list;
        this.b = it;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        if (this.a.size() > i) {
            return this.a.get(i);
        }
        if (this.b.hasNext()) {
            this.a.add(this.b.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new awz(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        c.a("potentially expensive size() call");
        c.a("blowup running");
        while (this.b.hasNext()) {
            this.a.add(this.b.next());
        }
        return this.a.size();
    }
}
