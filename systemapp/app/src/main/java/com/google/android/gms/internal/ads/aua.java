package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final class aua extends atz {
    /* JADX INFO: Access modifiers changed from: private */
    aua() {
        super();
    }

    @Override // com.google.android.gms.internal.ads.atz
    final <L> List<L> a(Object obj, long j) {
        zzekp c = c(obj, j);
        if (c.a()) {
            return c;
        }
        int size = c.size();
        zzekp a = c.a(size == 0 ? 10 : size << 1);
        avz.a(obj, j, a);
        return a;
    }

    @Override // com.google.android.gms.internal.ads.atz
    final void b(Object obj, long j) {
        c(obj, j).b();
    }

    @Override // com.google.android.gms.internal.ads.atz
    final <E> void a(Object obj, Object obj2, long j) {
        zzekp c = c(obj, j);
        zzekp c2 = c(obj2, j);
        int size = c.size();
        int size2 = c2.size();
        if (size > 0 && size2 > 0) {
            if (!c.a()) {
                c = c.a(size2 + size);
            }
            c.addAll(c2);
        }
        if (size > 0) {
            c2 = c;
        }
        avz.a(obj, j, c2);
    }

    private static <E> zzekp<E> c(Object obj, long j) {
        return (zzekp) avz.f(obj, j);
    }

    /* synthetic */ aua(aty atyVar) {
        this();
    }
}
