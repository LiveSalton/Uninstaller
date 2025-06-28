package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: source */
/* loaded from: classes.dex */
final class aso extends asl<Boolean> implements auu, zzekp<Boolean>, RandomAccess {
    private static final aso a;
    private boolean[] b;
    private int c;

    aso() {
        this(new boolean[10], 0);
    }

    private aso(boolean[] zArr, int i) {
        this.b = zArr;
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
        if (!(obj instanceof aso)) {
            return super.equals(obj);
        }
        aso asoVar = (aso) obj;
        if (this.c != asoVar.c) {
            return false;
        }
        boolean[] zArr = asoVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + zzekk.a(this.b[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.b[i] == booleanValue) {
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

    public final void a(boolean z) {
        c();
        if (this.c == this.b.length) {
            boolean[] zArr = new boolean[((this.c * 3) / 2) + 1];
            System.arraycopy(this.b, 0, zArr, 0, this.c);
            this.b = zArr;
        }
        boolean[] zArr2 = this.b;
        int i = this.c;
        this.c = i + 1;
        zArr2[i] = z;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        c();
        zzekk.a(collection);
        if (!(collection instanceof aso)) {
            return super.addAll(collection);
        }
        aso asoVar = (aso) collection;
        if (asoVar.c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.c < asoVar.c) {
            throw new OutOfMemoryError();
        }
        int i = this.c + asoVar.c;
        if (i > this.b.length) {
            this.b = Arrays.copyOf(this.b, i);
        }
        System.arraycopy(asoVar.b, 0, this.b, this.c, asoVar.c);
        this.c = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Boolean.valueOf(this.b[i]))) {
                System.arraycopy(this.b, i + 1, this.b, i, (this.c - i) - 1);
                this.c--;
                this.modCount++;
                return true;
            }
        }
        return false;
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

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        c();
        b(i);
        boolean z = this.b[i];
        this.b[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        b(i);
        boolean z = this.b[i];
        if (i < this.c - 1) {
            System.arraycopy(this.b, i + 1, this.b, i, (this.c - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        c();
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException(c(i));
        }
        if (this.c < this.b.length) {
            System.arraycopy(this.b, i, this.b, i + 1, this.c - i);
        } else {
            boolean[] zArr = new boolean[((this.c * 3) / 2) + 1];
            System.arraycopy(this.b, 0, zArr, 0, i);
            System.arraycopy(this.b, i, zArr, i + 1, this.c - i);
            this.b = zArr;
        }
        this.b[i] = booleanValue;
        this.c++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        a(((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzekp
    public final /* synthetic */ zzekp<Boolean> a(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new aso(Arrays.copyOf(this.b, i), this.c);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        b(i);
        return Boolean.valueOf(this.b[i]);
    }

    static {
        aso asoVar = new aso(new boolean[0], 0);
        a = asoVar;
        asoVar.b();
    }
}
