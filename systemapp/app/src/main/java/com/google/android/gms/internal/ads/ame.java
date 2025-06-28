package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final class ame<E> extends zzdwm<E> {
    private final transient int a;
    private final transient int b;
    private final /* synthetic */ zzdwm c;

    ame(zzdwm zzdwmVar, int i, int i2) {
        this.c = zzdwmVar;
        this.a = i;
        this.b = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final boolean f() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final Object[] b() {
        return this.c.b();
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final int c() {
        return this.c.c() + this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final int d() {
        return this.c.c() + this.a + this.b;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzdvv.a(i, this.b);
        return this.c.get(i + this.a);
    }

    @Override // com.google.android.gms.internal.ads.zzdwm
    /* renamed from: a */
    public final zzdwm<E> subList(int i, int i2) {
        zzdvv.a(i, i2, this.b);
        return (zzdwm) this.c.subList(i + this.a, i2 + this.a);
    }

    @Override // com.google.android.gms.internal.ads.zzdwm, java.util.List
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
