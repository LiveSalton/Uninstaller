package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.f;

/* compiled from: source */
/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements h {
    private final Object a;
    private final a.C0039a b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
        this.b = a.a.b(this.a.getClass());
    }

    @Override // androidx.lifecycle.h
    public void a(j jVar, f.a aVar) {
        this.b.a(jVar, aVar, this.a);
    }
}
