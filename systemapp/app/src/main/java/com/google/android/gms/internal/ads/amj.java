package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
final class amj<K> extends zzdwt<K> {
    private final transient zzdwq<K, ?> a;
    private final transient zzdwm<K> b;

    amj(zzdwq<K, ?> zzdwqVar, zzdwm<K> zzdwmVar) {
        this.a = zzdwqVar;
        this.b = zzdwmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final boolean f() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    /* renamed from: a */
    public final zzdxh<K> iterator() {
        return (zzdxh) e().iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    final int a(Object[] objArr, int i) {
        return e().a(objArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzdwt, com.google.android.gms.internal.ads.zzdwl
    public final zzdwm<K> e() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzdwl, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@NullableDecl Object obj) {
        return this.a.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.size();
    }

    @Override // com.google.android.gms.internal.ads.zzdwt, com.google.android.gms.internal.ads.zzdwl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
