package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class amm extends zzdwm<Object> {
    private final transient Object[] a;
    private final transient int b;
    private final transient int c;

    amm(Object[] objArr, int i, int i2) {
        this.a = objArr;
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final boolean f() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzdvv.a(i, this.c);
        return this.a[(2 * i) + this.b];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }
}
