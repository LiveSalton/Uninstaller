package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class bb {
    private static final bb a;
    private static final bb b;

    /* JADX INFO: Access modifiers changed from: private */
    bb() {
    }

    abstract void a(Object obj, long j);

    abstract <L> void a(Object obj, Object obj2, long j);

    static bb a() {
        return a;
    }

    static bb b() {
        return b;
    }

    /* synthetic */ bb(ba baVar) {
        this();
    }

    static {
        a = new bd();
        b = new bc();
    }
}
