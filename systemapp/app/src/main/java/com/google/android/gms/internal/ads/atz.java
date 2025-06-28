package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class atz {
    private static final atz a;
    private static final atz b;

    /* JADX INFO: Access modifiers changed from: private */
    atz() {
    }

    abstract <L> List<L> a(Object obj, long j);

    abstract <L> void a(Object obj, Object obj2, long j);

    abstract void b(Object obj, long j);

    static atz a() {
        return a;
    }

    static atz b() {
        return b;
    }

    /* synthetic */ atz(aty atyVar) {
        this();
    }

    static {
        a = new aub();
        b = new aua();
    }
}
