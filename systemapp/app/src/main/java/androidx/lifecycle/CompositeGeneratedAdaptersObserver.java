package androidx.lifecycle;

import androidx.lifecycle.f;

/* compiled from: source */
/* loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements h {
    private final d[] a;

    CompositeGeneratedAdaptersObserver(d[] dVarArr) {
        this.a = dVarArr;
    }

    @Override // androidx.lifecycle.h
    public void a(j jVar, f.a aVar) {
        n nVar = new n();
        for (d dVar : this.a) {
            dVar.a(jVar, aVar, false, nVar);
        }
        for (d dVar2 : this.a) {
            dVar2.a(jVar, aVar, true, nVar);
        }
    }
}
