package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzdwm<E> extends zzdwl<E> implements List<E>, RandomAccess {
    private static final zzdxg<Object> a = new amd(amg.a, 0);

    public static <E> zzdwm<E> g() {
        return (zzdwm<E>) amg.a;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    public final zzdwm<E> e() {
        return this;
    }

    public static <E> zzdwm<E> a(E e) {
        Object[] objArr = {e};
        for (int i = 0; i <= 0; i++) {
            zzdwx.a(objArr[0], 0);
        }
        return b(objArr, 1);
    }

    public static <E> zzdwm<E> a(Iterable<? extends E> iterable) {
        zzdvv.a(iterable);
        if (iterable instanceof Collection) {
            return a((Collection) iterable);
        }
        Iterator<? extends E> it = iterable.iterator();
        if (!it.hasNext()) {
            return (zzdwm<E>) amg.a;
        }
        E next = it.next();
        if (!it.hasNext()) {
            return a(next);
        }
        zzdwp zzdwpVar = (zzdwp) ((zzdwp) new zzdwp().b(next)).a((Iterator) it);
        zzdwpVar.c = true;
        return b(zzdwpVar.a, zzdwpVar.b);
    }

    public static <E> zzdwm<E> a(Collection<? extends E> collection) {
        if (collection instanceof zzdwl) {
            zzdwm<E> e = ((zzdwl) collection).e();
            if (!e.f()) {
                return e;
            }
            Object[] array = e.toArray();
            return b(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        for (int i = 0; i < length; i++) {
            zzdwx.a(array2[i], i);
        }
        return b(array2, array2.length);
    }

    public static <E> zzdwm<E> a(E[] eArr) {
        if (eArr.length == 0) {
            return (zzdwm<E>) amg.a;
        }
        Object[] objArr = (Object[]) eArr.clone();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            zzdwx.a(objArr[i], i);
        }
        return b(objArr, objArr.length);
    }

    static <E> zzdwm<E> b(Object[] objArr) {
        return b(objArr, objArr.length);
    }

    static <E> zzdwm<E> b(Object[] objArr, int i) {
        if (i == 0) {
            return (zzdwm<E>) amg.a;
        }
        return new amg(objArr, i);
    }

    zzdwm() {
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    /* renamed from: a */
    public final zzdxh<E> iterator() {
        return (zzdxg) listIterator();
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            int size = size();
            int i = 0;
            if (obj == null) {
                while (i < size) {
                    if (get(i) == null) {
                        return i;
                    }
                    i++;
                }
            } else {
                while (i < size) {
                    if (obj.equals(get(i))) {
                        return i;
                    }
                    i++;
                }
            }
            return -1;
        }
        ListIterator<E> listIterator = listIterator();
        while (listIterator.hasNext()) {
            if (zzdvs.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (!(this instanceof RandomAccess)) {
            ListIterator<E> listIterator = listIterator(size());
            while (listIterator.hasPrevious()) {
                if (zzdvs.a(obj, listIterator.previous())) {
                    return listIterator.nextIndex();
                }
            }
            return -1;
        }
        if (obj == null) {
            for (int size = size() - 1; size >= 0; size--) {
                if (get(size) == null) {
                    return size;
                }
            }
        } else {
            for (int size2 = size() - 1; size2 >= 0; size2--) {
                if (obj.equals(get(size2))) {
                    return size2;
                }
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List
    /* renamed from: a */
    public zzdwm<E> subList(int i, int i2) {
        zzdvv.a(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return (zzdwm<E>) amg.a;
        }
        return new ame(this, i, i3);
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    int a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzdvv.a(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if ((this instanceof RandomAccess) && (list instanceof RandomAccess)) {
                    for (int i = 0; i < size; i++) {
                        if (zzdvs.a(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                zzdwm<E> zzdwmVar = this;
                int size2 = zzdwmVar.size();
                Iterator<E> it = list.iterator();
                int i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        E e = zzdwmVar.get(i2);
                        i2++;
                        if (!zzdvs.a(e, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator(int i) {
        zzdvv.b(i, size());
        if (isEmpty()) {
            return a;
        }
        return new amd(this, i);
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator() {
        return (zzdxg) listIterator(0);
    }
}
