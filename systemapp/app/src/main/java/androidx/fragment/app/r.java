package androidx.fragment.app;

import androidx.lifecycle.f;

/* compiled from: source */
/* loaded from: classes.dex */
class r implements androidx.lifecycle.j {
    private androidx.lifecycle.k a = null;

    r() {
    }

    void a() {
        if (this.a == null) {
            this.a = new androidx.lifecycle.k(this);
        }
    }

    boolean c() {
        return this.a != null;
    }

    @Override // androidx.lifecycle.j
    public androidx.lifecycle.f b() {
        a();
        return this.a;
    }

    void a(f.a aVar) {
        this.a.a(aVar);
    }
}
