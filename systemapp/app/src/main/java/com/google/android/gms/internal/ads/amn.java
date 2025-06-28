package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
final class amn<E> extends zzdwt<E> {
    private final transient E a;
    private transient int b;

    amn(E e) {
        this.a = (E) zzdvv.a(e);
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final boolean f() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    amn(E e, int i) {
        this.a = e;
        this.b = i;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.a.equals(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    /* renamed from: a */
    public final zzdxh<E> iterator() {
        return new amf(this.a);
    }

    @Override // com.google.android.gms.internal.ads.zzdwt
    final zzdwm<E> h() {
        return zzdwm.a(this.a);
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final int a(Object[] objArr, int i) {
        objArr[i] = this.a;
        return i + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzdwt, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int hashCode = this.a.hashCode();
        this.b = hashCode;
        return hashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzdwt
    final boolean g() {
        return this.b != 0;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String obj = this.a.toString();
        StringBuilder sb = new StringBuilder(2 + String.valueOf(obj).length());
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdwt, com.google.android.gms.internal.ads.zzdwl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
