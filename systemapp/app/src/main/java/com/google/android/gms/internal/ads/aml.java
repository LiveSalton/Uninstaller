package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
final class aml<E> extends zzdwt<E> {
    static final aml<Object> a = new aml<>(new Object[0], 0, null, 0, 0);
    private final transient Object[] b;
    private final transient Object[] c;
    private final transient int d;
    private final transient int e;
    private final transient int f;

    aml(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.b = objArr;
        this.c = objArr2;
        this.d = i2;
        this.e = i;
        this.f = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final int c() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final boolean f() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdwt
    final boolean g() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.c;
        if (obj == null || objArr == null) {
            return false;
        }
        int a2 = amb.a(obj == null ? 0 : obj.hashCode());
        while (true) {
            int i = a2 & this.d;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            a2 = i + 1;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    /* renamed from: a */
    public final zzdxh<E> iterator() {
        return (zzdxh) e().iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final Object[] b() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final int d() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final int a(Object[] objArr, int i) {
        System.arraycopy(this.b, 0, objArr, i, this.f);
        return i + this.f;
    }

    @Override // com.google.android.gms.internal.ads.zzdwt
    final zzdwm<E> h() {
        return zzdwm.b(this.b, this.f);
    }

    @Override // com.google.android.gms.internal.ads.zzdwt, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzdwt, com.google.android.gms.internal.ads.zzdwl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
