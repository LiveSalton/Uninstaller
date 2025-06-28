package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzia extends AbstractList<String> implements zzfv, RandomAccess {
    private final zzfv a;

    public zzia(zzfv zzfvVar) {
        this.a = zzfvVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzfv
    public final zzfv c() {
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new cn(this, i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new cp(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzfv
    public final List<?> p_() {
        return this.a.p_();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.a.get(i);
    }
}
