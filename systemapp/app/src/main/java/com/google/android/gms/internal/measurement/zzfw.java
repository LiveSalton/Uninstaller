package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzfw extends ac<String> implements zzfv, RandomAccess {
    private static final zzfw a;
    private static final zzfv b;
    private final List<Object> c;

    public zzfw() {
        this(10);
    }

    public zzfw(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzfw(ArrayList<Object> arrayList) {
        this.c = arrayList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c.size();
    }

    @Override // com.google.android.gms.internal.measurement.ac, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.measurement.ac, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        q_();
        if (collection instanceof zzfv) {
            collection = ((zzfv) collection).p_();
        }
        boolean addAll = this.c.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.measurement.ac, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        q_();
        this.c.clear();
        this.modCount++;
    }

    private static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdu) {
            return ((zzdu) obj).b();
        }
        return zzff.b((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzfv
    public final List<?> p_() {
        return Collections.unmodifiableList(this.c);
    }

    @Override // com.google.android.gms.internal.measurement.zzfv
    public final zzfv c() {
        return a() ? new zzia(this) : this;
    }

    @Override // com.google.android.gms.internal.measurement.ac, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        q_();
        return a(this.c.set(i, (String) obj));
    }

    @Override // com.google.android.gms.internal.measurement.ac, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.measurement.ac, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.measurement.ac, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.measurement.ac, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        q_();
        Object remove = this.c.remove(i);
        this.modCount++;
        return a(remove);
    }

    @Override // com.google.android.gms.internal.measurement.ac, com.google.android.gms.internal.measurement.zzfl
    public final /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    @Override // com.google.android.gms.internal.measurement.ac, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        q_();
        this.c.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.ac, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.ac, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzfl
    public final /* synthetic */ zzfl a(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.c);
        return new zzfw((ArrayList<Object>) arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.c.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdu) {
            zzdu zzduVar = (zzdu) obj;
            String b2 = zzduVar.b();
            if (zzduVar.c()) {
                this.c.set(i, b2);
            }
            return b2;
        }
        byte[] bArr = (byte[]) obj;
        String b3 = zzff.b(bArr);
        if (zzff.a(bArr)) {
            this.c.set(i, b3);
        }
        return b3;
    }

    static {
        zzfw zzfwVar = new zzfw();
        a = zzfwVar;
        zzfwVar.b();
        b = a;
    }
}
