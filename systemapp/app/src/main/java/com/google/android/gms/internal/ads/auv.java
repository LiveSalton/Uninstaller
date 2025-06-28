package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: source */
/* loaded from: classes.dex */
final class auv<E> extends asl<E> implements RandomAccess {
    private static final auv<Object> a;
    private E[] b;
    private int c;

    public static <E> auv<E> d() {
        return (auv<E>) a;
    }

    auv() {
        this(new Object[10], 0);
    }

    private auv(E[] eArr, int i) {
        this.b = eArr;
        this.c = i;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e) {
        c();
        if (this.c == this.b.length) {
            this.b = (E[]) Arrays.copyOf(this.b, ((this.c * 3) / 2) + 1);
        }
        E[] eArr = this.b;
        int i = this.c;
        this.c = i + 1;
        eArr[i] = e;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        c();
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException(c(i));
        }
        if (this.c < this.b.length) {
            System.arraycopy(this.b, i, this.b, i + 1, this.c - i);
        } else {
            E[] eArr = (E[]) new Object[((this.c * 3) / 2) + 1];
            System.arraycopy(this.b, 0, eArr, 0, i);
            System.arraycopy(this.b, i, eArr, i + 1, this.c - i);
            this.b = eArr;
        }
        this.b[i] = e;
        this.c++;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        b(i);
        return this.b[i];
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        c();
        b(i);
        E e = this.b[i];
        if (i < this.c - 1) {
            System.arraycopy(this.b, i + 1, this.b, i, (this.c - i) - 1);
        }
        this.c--;
        this.modCount++;
        return e;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        c();
        b(i);
        E e2 = this.b[i];
        this.b[i] = e;
        this.modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    private final void b(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(c(i));
        }
    }

    private final String c(int i) {
        int i2 = this.c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzekp
    public final /* synthetic */ zzekp a(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new auv(Arrays.copyOf(this.b, i), this.c);
    }

    static {
        auv<Object> auvVar = new auv<>(new Object[0], 0);
        a = auvVar;
        auvVar.b();
    }
}
