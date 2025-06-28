package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: source */
/* loaded from: classes.dex */
final class ati extends asl<Double> implements auu, zzekp<Double>, RandomAccess {
    private static final ati a;
    private double[] b;
    private int c;

    ati() {
        this(new double[10], 0);
    }

    private ati(double[] dArr, int i) {
        this.b = dArr;
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
        if (!(obj instanceof ati)) {
            return super.equals(obj);
        }
        ati atiVar = (ati) obj;
        if (this.c != atiVar.c) {
            return false;
        }
        double[] dArr = atiVar.b;
        for (int i = 0; i < this.c; i++) {
            if (Double.doubleToLongBits(this.b[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + zzekk.a(Double.doubleToLongBits(this.b[i2]));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.b[i] == doubleValue) {
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

    public final void a(double d) {
        c();
        if (this.c == this.b.length) {
            double[] dArr = new double[((this.c * 3) / 2) + 1];
            System.arraycopy(this.b, 0, dArr, 0, this.c);
            this.b = dArr;
        }
        double[] dArr2 = this.b;
        int i = this.c;
        this.c = i + 1;
        dArr2[i] = d;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        c();
        zzekk.a(collection);
        if (!(collection instanceof ati)) {
            return super.addAll(collection);
        }
        ati atiVar = (ati) collection;
        if (atiVar.c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.c < atiVar.c) {
            throw new OutOfMemoryError();
        }
        int i = this.c + atiVar.c;
        if (i > this.b.length) {
            this.b = Arrays.copyOf(this.b, i);
        }
        System.arraycopy(atiVar.b, 0, this.b, this.c, atiVar.c);
        this.c = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Double.valueOf(this.b[i]))) {
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
        double doubleValue = ((Double) obj).doubleValue();
        c();
        b(i);
        double d = this.b[i];
        this.b[i] = doubleValue;
        return Double.valueOf(d);
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        b(i);
        double d = this.b[i];
        if (i < this.c - 1) {
            System.arraycopy(this.b, i + 1, this.b, i, (this.c - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Double.valueOf(d);
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        c();
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException(c(i));
        }
        if (this.c < this.b.length) {
            System.arraycopy(this.b, i, this.b, i + 1, this.c - i);
        } else {
            double[] dArr = new double[((this.c * 3) / 2) + 1];
            System.arraycopy(this.b, 0, dArr, 0, i);
            System.arraycopy(this.b, i, dArr, i + 1, this.c - i);
            this.b = dArr;
        }
        this.b[i] = doubleValue;
        this.c++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        a(((Double) obj).doubleValue());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzekp
    public final /* synthetic */ zzekp<Double> a(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new ati(Arrays.copyOf(this.b, i), this.c);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        b(i);
        return Double.valueOf(this.b[i]);
    }

    static {
        ati atiVar = new ati(new double[0], 0);
        a = atiVar;
        atiVar.b();
    }
}
