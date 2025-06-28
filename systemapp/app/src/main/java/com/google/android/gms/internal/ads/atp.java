package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: source */
/* loaded from: classes.dex */
final class atp extends asl<Float> implements auu, zzekp<Float>, RandomAccess {
    private static final atp a;
    private float[] b;
    private int c;

    atp() {
        this(new float[10], 0);
    }

    private atp(float[] fArr, int i) {
        this.b = fArr;
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
        if (!(obj instanceof atp)) {
            return super.equals(obj);
        }
        atp atpVar = (atp) obj;
        if (this.c != atpVar.c) {
            return false;
        }
        float[] fArr = atpVar.b;
        for (int i = 0; i < this.c; i++) {
            if (Float.floatToIntBits(this.b[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.b[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.b[i] == floatValue) {
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

    public final void a(float f) {
        c();
        if (this.c == this.b.length) {
            float[] fArr = new float[((this.c * 3) / 2) + 1];
            System.arraycopy(this.b, 0, fArr, 0, this.c);
            this.b = fArr;
        }
        float[] fArr2 = this.b;
        int i = this.c;
        this.c = i + 1;
        fArr2[i] = f;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        c();
        zzekk.a(collection);
        if (!(collection instanceof atp)) {
            return super.addAll(collection);
        }
        atp atpVar = (atp) collection;
        if (atpVar.c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.c < atpVar.c) {
            throw new OutOfMemoryError();
        }
        int i = this.c + atpVar.c;
        if (i > this.b.length) {
            this.b = Arrays.copyOf(this.b, i);
        }
        System.arraycopy(atpVar.b, 0, this.b, this.c, atpVar.c);
        this.c = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Float.valueOf(this.b[i]))) {
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
        float floatValue = ((Float) obj).floatValue();
        c();
        b(i);
        float f = this.b[i];
        this.b[i] = floatValue;
        return Float.valueOf(f);
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        b(i);
        float f = this.b[i];
        if (i < this.c - 1) {
            System.arraycopy(this.b, i + 1, this.b, i, (this.c - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Float.valueOf(f);
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        c();
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException(c(i));
        }
        if (this.c < this.b.length) {
            System.arraycopy(this.b, i, this.b, i + 1, this.c - i);
        } else {
            float[] fArr = new float[((this.c * 3) / 2) + 1];
            System.arraycopy(this.b, 0, fArr, 0, i);
            System.arraycopy(this.b, i, fArr, i + 1, this.c - i);
            this.b = fArr;
        }
        this.b[i] = floatValue;
        this.c++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        a(((Float) obj).floatValue());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzekp
    public final /* synthetic */ zzekp<Float> a(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new atp(Arrays.copyOf(this.b, i), this.c);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        b(i);
        return Float.valueOf(this.b[i]);
    }

    static {
        atp atpVar = new atp(new float[0], 0);
        a = atpVar;
        atpVar.b();
    }
}
