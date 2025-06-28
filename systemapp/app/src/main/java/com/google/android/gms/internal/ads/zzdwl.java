package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzdwl<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] a = new Object[0];

    zzdwl() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: a */
    public abstract zzdxh<E> iterator();

    @NullableDecl
    Object[] b() {
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(@NullableDecl Object obj);

    abstract boolean f();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        zzdvv.a(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] b = b();
            if (b != null) {
                return (T[]) Arrays.copyOfRange(b, c(), d(), tArr.getClass());
            }
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        a(tArr, 0);
        return tArr;
    }

    int c() {
        throw new UnsupportedOperationException();
    }

    int d() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public zzdwm<E> e() {
        return isEmpty() ? zzdwm.g() : zzdwm.b(toArray());
    }

    int a(Object[] objArr, int i) {
        zzdxh zzdxhVar = (zzdxh) iterator();
        while (zzdxhVar.hasNext()) {
            objArr[i] = zzdxhVar.next();
            i++;
        }
        return i;
    }
}
