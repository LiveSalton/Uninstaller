package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: source */
/* loaded from: classes.dex */
final class aud extends asl<Long> implements auu, zzekq, RandomAccess {
    private static final aud a;
    private long[] b;
    private int c;

    public static aud d() {
        return a;
    }

    aud() {
        this(new long[10], 0);
    }

    private aud(long[] jArr, int i) {
        this.b = jArr;
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
        if (!(obj instanceof aud)) {
            return super.equals(obj);
        }
        aud audVar = (aud) obj;
        if (this.c != audVar.c) {
            return false;
        }
        long[] jArr = audVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != jArr[i]) {
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

    @Override // com.google.android.gms.internal.ads.zzekp
    /* renamed from: b */
    public final zzekq a(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new aud(Arrays.copyOf(this.b, i), this.c);
    }

    public final long c(int i) {
        d(i);
        return this.b[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.b[i] == longValue) {
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

    public final void a(long j) {
        c();
        if (this.c == this.b.length) {
            long[] jArr = new long[((this.c * 3) / 2) + 1];
            System.arraycopy(this.b, 0, jArr, 0, this.c);
            this.b = jArr;
        }
        long[] jArr2 = this.b;
        int i = this.c;
        this.c = i + 1;
        jArr2[i] = j;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        c();
        zzekk.a(collection);
        if (!(collection instanceof aud)) {
            return super.addAll(collection);
        }
        aud audVar = (aud) collection;
        if (audVar.c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.c < audVar.c) {
            throw new OutOfMemoryError();
        }
        int i = this.c + audVar.c;
        if (i > this.b.length) {
            this.b = Arrays.copyOf(this.b, i);
        }
        System.arraycopy(audVar.b, 0, this.b, this.c, audVar.c);
        this.c = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Long.valueOf(this.b[i]))) {
                System.arraycopy(this.b, i + 1, this.b, i, (this.c - i) - 1);
                this.c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void d(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(e(i));
        }
    }

    private final String e(int i) {
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
        long longValue = ((Long) obj).longValue();
        c();
        d(i);
        long j = this.b[i];
        this.b[i] = longValue;
        return Long.valueOf(j);
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        d(i);
        long j = this.b[i];
        if (i < this.c - 1) {
            System.arraycopy(this.b, i + 1, this.b, i, (this.c - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Long.valueOf(j);
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        c();
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException(e(i));
        }
        if (this.c < this.b.length) {
            System.arraycopy(this.b, i, this.b, i + 1, this.c - i);
        } else {
            long[] jArr = new long[((this.c * 3) / 2) + 1];
            System.arraycopy(this.b, 0, jArr, 0, i);
            System.arraycopy(this.b, i, jArr, i + 1, this.c - i);
            this.b = jArr;
        }
        this.b[i] = longValue;
        this.c++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        a(((Long) obj).longValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(c(i));
    }

    static {
        aud audVar = new aud(new long[0], 0);
        a = audVar;
        audVar.b();
    }
}
