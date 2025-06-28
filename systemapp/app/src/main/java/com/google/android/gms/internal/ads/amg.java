package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class amg<E> extends zzdwm<E> {
    static final zzdwm<Object> a = new amg(new Object[0], 0);
    private final transient Object[] b;
    private final transient int c;

    amg(Object[] objArr, int i) {
        this.b = objArr;
        this.c = i;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final int c() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final boolean f() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final Object[] b() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final int d() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzdwm, com.google.android.gms.internal.ads.zzdwl
    final int a(Object[] objArr, int i) {
        System.arraycopy(this.b, 0, objArr, i, this.c);
        return i + this.c;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzdvv.a(i, this.c);
        return (E) this.b[i];
    }
}
