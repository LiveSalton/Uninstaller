package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final class aub extends atz {
    private static final Class<?> a = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* JADX INFO: Access modifiers changed from: private */
    aub() {
        super();
    }

    @Override // com.google.android.gms.internal.ads.atz
    final <L> List<L> a(Object obj, long j) {
        return a(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.ads.atz
    final void b(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) avz.f(obj, j);
        if (list instanceof zzekz) {
            unmodifiableList = ((zzekz) list).m_();
        } else {
            if (a.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof auu) && (list instanceof zzekp)) {
                zzekp zzekpVar = (zzekp) list;
                if (zzekpVar.a()) {
                    zzekpVar.b();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        avz.a(obj, j, unmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> a(Object obj, long j, int i) {
        zzela zzelaVar;
        List<L> arrayList;
        List<L> c = c(obj, j);
        if (c.isEmpty()) {
            if (c instanceof zzekz) {
                arrayList = new zzela(i);
            } else if ((c instanceof auu) && (c instanceof zzekp)) {
                arrayList = ((zzekp) c).a(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            avz.a(obj, j, arrayList);
            return arrayList;
        }
        if (a.isAssignableFrom(c.getClass())) {
            ArrayList arrayList2 = new ArrayList(c.size() + i);
            arrayList2.addAll(c);
            avz.a(obj, j, arrayList2);
            zzelaVar = arrayList2;
        } else if (c instanceof zzenk) {
            zzela zzelaVar2 = new zzela(c.size() + i);
            zzelaVar2.addAll((zzenk) c);
            avz.a(obj, j, zzelaVar2);
            zzelaVar = zzelaVar2;
        } else {
            if (!(c instanceof auu) || !(c instanceof zzekp)) {
                return c;
            }
            zzekp zzekpVar = (zzekp) c;
            if (zzekpVar.a()) {
                return c;
            }
            zzekp a2 = zzekpVar.a(c.size() + i);
            avz.a(obj, j, a2);
            return a2;
        }
        return zzelaVar;
    }

    @Override // com.google.android.gms.internal.ads.atz
    final <E> void a(Object obj, Object obj2, long j) {
        List c = c(obj2, j);
        List a2 = a(obj, j, c.size());
        int size = a2.size();
        int size2 = c.size();
        if (size > 0 && size2 > 0) {
            a2.addAll(c);
        }
        if (size > 0) {
            c = a2;
        }
        avz.a(obj, j, c);
    }

    private static <E> List<E> c(Object obj, long j) {
        return (List) avz.f(obj, j);
    }

    /* synthetic */ aub(aty atyVar) {
        this();
    }
}
