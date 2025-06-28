package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final class bd extends bb {
    private static final Class<?> a = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* JADX INFO: Access modifiers changed from: private */
    bd() {
        super();
    }

    @Override // com.google.android.gms.internal.measurement.bb
    final void a(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) co.f(obj, j);
        if (list instanceof zzfv) {
            unmodifiableList = ((zzfv) list).c();
        } else {
            if (a.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof bu) && (list instanceof zzfl)) {
                zzfl zzflVar = (zzfl) list;
                if (zzflVar.a()) {
                    zzflVar.b();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        co.a(obj, j, unmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> a(Object obj, long j, int i) {
        zzfw zzfwVar;
        List<L> arrayList;
        List<L> b = b(obj, j);
        if (b.isEmpty()) {
            if (b instanceof zzfv) {
                arrayList = new zzfw(i);
            } else if ((b instanceof bu) && (b instanceof zzfl)) {
                arrayList = ((zzfl) b).a(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            co.a(obj, j, arrayList);
            return arrayList;
        }
        if (a.isAssignableFrom(b.getClass())) {
            ArrayList arrayList2 = new ArrayList(b.size() + i);
            arrayList2.addAll(b);
            co.a(obj, j, arrayList2);
            zzfwVar = arrayList2;
        } else if (b instanceof zzia) {
            zzfw zzfwVar2 = new zzfw(b.size() + i);
            zzfwVar2.addAll((zzia) b);
            co.a(obj, j, zzfwVar2);
            zzfwVar = zzfwVar2;
        } else {
            if (!(b instanceof bu) || !(b instanceof zzfl)) {
                return b;
            }
            zzfl zzflVar = (zzfl) b;
            if (zzflVar.a()) {
                return b;
            }
            zzfl a2 = zzflVar.a(b.size() + i);
            co.a(obj, j, a2);
            return a2;
        }
        return zzfwVar;
    }

    @Override // com.google.android.gms.internal.measurement.bb
    final <E> void a(Object obj, Object obj2, long j) {
        List b = b(obj2, j);
        List a2 = a(obj, j, b.size());
        int size = a2.size();
        int size2 = b.size();
        if (size > 0 && size2 > 0) {
            a2.addAll(b);
        }
        if (size > 0) {
            b = a2;
        }
        co.a(obj, j, b);
    }

    private static <E> List<E> b(Object obj, long j) {
        return (List) co.f(obj, j);
    }

    /* synthetic */ bd(ba baVar) {
        this();
    }
}
