package androidx.work.impl.a.a;

import androidx.work.impl.b.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class c<T> implements androidx.work.impl.a.a<T> {
    private final List<String> a = new ArrayList();
    private T b;
    private androidx.work.impl.a.b.d<T> c;
    private a d;

    /* compiled from: source */
    public interface a {
        void b(List<String> list);

        void c(List<String> list);
    }

    abstract boolean a(j jVar);

    abstract boolean b(T t);

    c(androidx.work.impl.a.b.d<T> dVar) {
        this.c = dVar;
    }

    public void a(a aVar) {
        if (this.d != aVar) {
            this.d = aVar;
            b();
        }
    }

    public void a(List<j> list) {
        this.a.clear();
        for (j jVar : list) {
            if (a(jVar)) {
                this.a.add(jVar.a);
            }
        }
        if (this.a.isEmpty()) {
            this.c.b(this);
        } else {
            this.c.a((androidx.work.impl.a.a) this);
        }
        b();
    }

    public void a() {
        if (this.a.isEmpty()) {
            return;
        }
        this.a.clear();
        this.c.b(this);
    }

    public boolean a(String str) {
        return this.b != null && b(this.b) && this.a.contains(str);
    }

    private void b() {
        if (this.a.isEmpty() || this.d == null) {
            return;
        }
        if (this.b == null || b(this.b)) {
            this.d.c(this.a);
        } else {
            this.d.b(this.a);
        }
    }

    @Override // androidx.work.impl.a.a
    public void a(T t) {
        this.b = t;
        b();
    }
}
