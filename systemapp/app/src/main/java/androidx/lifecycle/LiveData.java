package androidx.lifecycle;

import androidx.lifecycle.f;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class LiveData<T> {
    static final Object b = new Object();
    private boolean h;
    private boolean i;
    final Object a = new Object();
    private androidx.a.a.b.b<p<? super T>, LiveData<T>.a> e = new androidx.a.a.b.b<>();
    int c = 0;
    volatile Object d = b;
    private final Runnable j = new Runnable() { // from class: androidx.lifecycle.LiveData.1
        AnonymousClass1() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.a) {
                obj = LiveData.this.d;
                LiveData.this.d = LiveData.b;
            }
            LiveData.this.b((LiveData) obj);
        }
    };
    private volatile Object f = b;
    private int g = -1;

    protected void b() {
    }

    protected void c() {
    }

    /* compiled from: source */
    /* renamed from: androidx.lifecycle.LiveData$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.a) {
                obj = LiveData.this.d;
                LiveData.this.d = LiveData.b;
            }
            LiveData.this.b((LiveData) obj);
        }
    }

    private void b(LiveData<T>.a aVar) {
        if (aVar.d) {
            if (!aVar.a()) {
                aVar.a(false);
            } else {
                if (aVar.e >= this.g) {
                    return;
                }
                aVar.e = this.g;
                aVar.c.a((Object) this.f);
            }
        }
    }

    void a(LiveData<T>.a aVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (aVar != null) {
                b((a) aVar);
                aVar = null;
            } else {
                androidx.a.a.b.b<p<? super T>, LiveData<T>.a>.d c = this.e.c();
                while (c.hasNext()) {
                    b((a) c.next().getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.h = false;
    }

    public void a(j jVar, p<? super T> pVar) {
        a("observe");
        if (jVar.b().a() == f.b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(jVar, pVar);
        LiveData<T>.a a2 = this.e.a(pVar, lifecycleBoundObserver);
        if (a2 != null && !a2.a(jVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (a2 != null) {
            return;
        }
        jVar.b().a(lifecycleBoundObserver);
    }

    public void a(p<? super T> pVar) {
        a("removeObserver");
        LiveData<T>.a b2 = this.e.b(pVar);
        if (b2 == null) {
            return;
        }
        b2.b();
        b2.a(false);
    }

    protected void a(T t) {
        boolean z;
        synchronized (this.a) {
            z = this.d == b;
            this.d = t;
        }
        if (z) {
            androidx.a.a.a.a.a().b(this.j);
        }
    }

    protected void b(T t) {
        a("setValue");
        this.g++;
        this.f = t;
        a((a) null);
    }

    public T a() {
        T t = (T) this.f;
        if (t != b) {
            return t;
        }
        return null;
    }

    public boolean d() {
        return this.c > 0;
    }

    /* compiled from: source */
    class LifecycleBoundObserver extends LiveData<T>.a implements h {
        final j a;

        LifecycleBoundObserver(j jVar, p<? super T> pVar) {
            super(pVar);
            this.a = jVar;
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean a() {
            return this.a.b().a().a(f.b.STARTED);
        }

        @Override // androidx.lifecycle.h
        public void a(j jVar, f.a aVar) {
            if (this.a.b().a() == f.b.DESTROYED) {
                LiveData.this.a((p) this.c);
            } else {
                a(a());
            }
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean a(j jVar) {
            return this.a == jVar;
        }

        @Override // androidx.lifecycle.LiveData.a
        void b() {
            this.a.b().b(this);
        }
    }

    /* compiled from: source */
    private abstract class a {
        final p<? super T> c;
        boolean d;
        int e = -1;

        abstract boolean a();

        boolean a(j jVar) {
            return false;
        }

        void b() {
        }

        a(p<? super T> pVar) {
            this.c = pVar;
        }

        void a(boolean z) {
            if (z == this.d) {
                return;
            }
            this.d = z;
            boolean z2 = LiveData.this.c == 0;
            LiveData.this.c += this.d ? 1 : -1;
            if (z2 && this.d) {
                LiveData.this.b();
            }
            if (LiveData.this.c == 0 && !this.d) {
                LiveData.this.c();
            }
            if (this.d) {
                LiveData.this.a(this);
            }
        }
    }

    static void a(String str) {
        if (androidx.a.a.a.a.a().c()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }
}
