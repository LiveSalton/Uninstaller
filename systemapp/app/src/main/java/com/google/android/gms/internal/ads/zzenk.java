package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzenk extends AbstractList<String> implements zzekz, RandomAccess {
    private final zzekz a;

    public zzenk(zzekz zzekzVar) {
        this.a = zzekzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekz
    public final zzekz m_() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzekz
    public final Object b(int i) {
        return this.a.b(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.size();
    }

    @Override // com.google.android.gms.internal.ads.zzekz
    public final void a(zzeiu zzeiuVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new avy(this, i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new awa(this);
    }

    @Override // com.google.android.gms.internal.ads.zzekz
    public final List<?> l_() {
        return this.a.l_();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.a.get(i);
    }
}
