package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: source */
/* loaded from: classes.dex */
final class auw {
    private static final auw a = new auw();
    private final ConcurrentMap<Class<?>, avd<?>> c = new ConcurrentHashMap();
    private final avg b = new auc();

    public static auw a() {
        return a;
    }

    public final <T> avd<T> a(Class<T> cls) {
        zzekk.a(cls, "messageType");
        avd<T> avdVar = (avd) this.c.get(cls);
        if (avdVar != null) {
            return avdVar;
        }
        avd<T> a2 = this.b.a(cls);
        zzekk.a(cls, "messageType");
        zzekk.a(a2, "schema");
        avd<T> avdVar2 = (avd) this.c.putIfAbsent(cls, a2);
        return avdVar2 != null ? avdVar2 : a2;
    }

    public final <T> avd<T> a(T t) {
        return a((Class) t.getClass());
    }

    private auw() {
    }
}
