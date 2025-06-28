package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzela extends asl<String> implements zzekz, RandomAccess {
    private static final zzela a;
    private static final zzekz b;
    private final List<Object> c;

    public zzela() {
        this(10);
    }

    public zzela(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzela(ArrayList<Object> arrayList) {
        this.c = arrayList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c.size();
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        c();
        if (collection instanceof zzekz) {
            collection = ((zzekz) collection).l_();
        }
        boolean addAll = this.c.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        c();
        this.c.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzekz
    public final void a(zzeiu zzeiuVar) {
        c();
        this.c.add(zzeiuVar);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzekz
    public final Object b(int i) {
        return this.c.get(i);
    }

    private static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeiu) {
            return ((zzeiu) obj).e();
        }
        return zzekk.b((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzekz
    public final List<?> l_() {
        return Collections.unmodifiableList(this.c);
    }

    @Override // com.google.android.gms.internal.ads.zzekz
    public final zzekz m_() {
        return a() ? new zzenk(this) : this;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        c();
        return a(this.c.set(i, (String) obj));
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        Object remove = this.c.remove(i);
        this.modCount++;
        return a(remove);
    }

    @Override // com.google.android.gms.internal.ads.asl, com.google.android.gms.internal.ads.zzekp
    public final /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        c();
        this.c.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.asl, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzekp
    public final /* synthetic */ zzekp a(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.c);
        return new zzela((ArrayList<Object>) arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.c.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeiu) {
            zzeiu zzeiuVar = (zzeiu) obj;
            String e = zzeiuVar.e();
            if (zzeiuVar.f()) {
                this.c.set(i, e);
            }
            return e;
        }
        byte[] bArr = (byte[]) obj;
        String b2 = zzekk.b(bArr);
        if (zzekk.a(bArr)) {
            this.c.set(i, b2);
        }
        return b2;
    }

    static {
        zzela zzelaVar = new zzela();
        a = zzelaVar;
        zzelaVar.b();
        b = a;
    }
}
