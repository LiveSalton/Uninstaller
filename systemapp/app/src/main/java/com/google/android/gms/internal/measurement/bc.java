package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
final class bc extends bb {
    /* JADX INFO: Access modifiers changed from: private */
    bc() {
        super();
    }

    @Override // com.google.android.gms.internal.measurement.bb
    final void a(Object obj, long j) {
        b(obj, j).b();
    }

    @Override // com.google.android.gms.internal.measurement.bb
    final <E> void a(Object obj, Object obj2, long j) {
        zzfl b = b(obj, j);
        zzfl b2 = b(obj2, j);
        int size = b.size();
        int size2 = b2.size();
        if (size > 0 && size2 > 0) {
            if (!b.a()) {
                b = b.a(size2 + size);
            }
            b.addAll(b2);
        }
        if (size > 0) {
            b2 = b;
        }
        co.a(obj, j, b2);
    }

    private static <E> zzfl<E> b(Object obj, long j) {
        return (zzfl) co.f(obj, j);
    }

    /* synthetic */ bc(ba baVar) {
        this();
    }
}
