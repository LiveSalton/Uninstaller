package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: source */
/* loaded from: classes.dex */
final class att extends asl<Integer> implements auu, zzeko, RandomAccess {
    private static final att a;
    private int[] b;
    private int c;

    public static att d() {
        return a;
    }

    att() {
        this(new int[10], 0);
    }

    private att(int[] iArr, int i) {
        this.b = iArr;
        this.c = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.b, i2, this.b, i, this.c - i2);
        this.c -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof att)) {
            return super.equals(obj);
        }
        att attVar = (att) obj;
        if (this.c != attVar.c) {
            return false;
        }
        int[] iArr = attVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + this.b[i2];
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzekp
    /* renamed from: b */
    public final zzeko a(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new att(Arrays.copyOf(this.b, i), this.c);
    }

    public final int c(int i) {
        e(i);
        return this.b[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.b[i] == intValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzeko
    public final void d(int i) {
        c();
        if (this.c == this.b.length) {
            int[] iArr = new int[((this.c * 3) / 2) + 1];
            System.arraycopy(this.b, 0, iArr, 0, this.c);
            this.b = iArr;
        }
        int[] iArr2 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        iArr2[i2] = i;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        c();
        zzekk.a(collection);
        if (!(collection instanceof att)) {
            return super.addAll(collection);
        }
        att attVar = (att) collection;
        if (attVar.c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.c < attVar.c) {
            throw new OutOfMemoryError();
        }
        int i = this.c + attVar.c;
        if (i > this.b.length) {
            this.b = Arrays.copyOf(this.b, i);
        }
        System.arraycopy(attVar.b, 0, this.b, this.c, attVar.c);
        this.c = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Integer.valueOf(this.b[i]))) {
                System.arraycopy(this.b, i + 1, this.b, i, (this.c - i) - 1);
                this.c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void e(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(f(i));
        }
    }

    private final String f(int i) {
        int i2 = this.c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        c();
        e(i);
        int i2 = this.b[i];
        this.b[i] = intValue;
        return Integer.valueOf(i2);
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        e(i);
        int i2 = this.b[i];
        if (i < this.c - 1) {
            System.arraycopy(this.b, i + 1, this.b, i, (this.c - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        c();
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException(f(i));
        }
        if (this.c < this.b.length) {
            System.arraycopy(this.b, i, this.b, i + 1, this.c - i);
        } else {
            int[] iArr = new int[((this.c * 3) / 2) + 1];
            System.arraycopy(this.b, 0, iArr, 0, i);
            System.arraycopy(this.b, i, iArr, i + 1, this.c - i);
            this.b = iArr;
        }
        this.b[i] = intValue;
        this.c++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        d(((Integer) obj).intValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(c(i));
    }

    static {
        att attVar = new att(new int[0], 0);
        a = attVar;
        attVar.b();
    }
}
