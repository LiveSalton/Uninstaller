package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: source */
/* loaded from: classes.dex */
final class bt {
    private static final bt a = new bt();
    private final ConcurrentMap<Class<?>, bw<?>> c = new ConcurrentHashMap();
    private final by b = new be();

    public static bt a() {
        return a;
    }

    public final <T> bw<T> a(Class<T> cls) {
        zzff.a(cls, "messageType");
        bw<T> bwVar = (bw) this.c.get(cls);
        if (bwVar != null) {
            return bwVar;
        }
        bw<T> a2 = this.b.a(cls);
        zzff.a(cls, "messageType");
        zzff.a(a2, "schema");
        bw<T> bwVar2 = (bw) this.c.putIfAbsent(cls, a2);
        return bwVar2 != null ? bwVar2 : a2;
    }

    public final <T> bw<T> a(T t) {
        return a((Class) t.getClass());
    }

    private bt() {
    }
}
