package androidx.recyclerview.widget;

import androidx.core.g.d;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: source */
/* loaded from: classes.dex */
class m {
    final androidx.b.a<RecyclerView.v, a> a = new androidx.b.a<>();
    final androidx.b.d<RecyclerView.v> b = new androidx.b.d<>();

    /* compiled from: source */
    interface b {
        void a(RecyclerView.v vVar);

        void a(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void b(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void c(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);
    }

    m() {
    }

    void a() {
        this.a.clear();
        this.b.c();
    }

    void a(RecyclerView.v vVar, RecyclerView.f.c cVar) {
        a aVar = this.a.get(vVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(vVar, aVar);
        }
        aVar.b = cVar;
        aVar.a |= 4;
    }

    boolean a(RecyclerView.v vVar) {
        a aVar = this.a.get(vVar);
        return (aVar == null || (aVar.a & 1) == 0) ? false : true;
    }

    RecyclerView.f.c b(RecyclerView.v vVar) {
        return a(vVar, 4);
    }

    RecyclerView.f.c c(RecyclerView.v vVar) {
        return a(vVar, 8);
    }

    private RecyclerView.f.c a(RecyclerView.v vVar, int i) {
        a c;
        RecyclerView.f.c cVar;
        int a2 = this.a.a(vVar);
        if (a2 < 0 || (c = this.a.c(a2)) == null || (c.a & i) == 0) {
            return null;
        }
        c.a &= ~i;
        if (i == 4) {
            cVar = c.b;
        } else if (i == 8) {
            cVar = c.c;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((c.a & 12) == 0) {
            this.a.d(a2);
            a.a(c);
        }
        return cVar;
    }

    void a(long j, RecyclerView.v vVar) {
        this.b.b(j, vVar);
    }

    void b(RecyclerView.v vVar, RecyclerView.f.c cVar) {
        a aVar = this.a.get(vVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(vVar, aVar);
        }
        aVar.a |= 2;
        aVar.b = cVar;
    }

    boolean d(RecyclerView.v vVar) {
        a aVar = this.a.get(vVar);
        return (aVar == null || (aVar.a & 4) == 0) ? false : true;
    }

    RecyclerView.v a(long j) {
        return this.b.a(j);
    }

    void c(RecyclerView.v vVar, RecyclerView.f.c cVar) {
        a aVar = this.a.get(vVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(vVar, aVar);
        }
        aVar.c = cVar;
        aVar.a |= 8;
    }

    void e(RecyclerView.v vVar) {
        a aVar = this.a.get(vVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(vVar, aVar);
        }
        aVar.a |= 1;
    }

    void f(RecyclerView.v vVar) {
        a aVar = this.a.get(vVar);
        if (aVar == null) {
            return;
        }
        aVar.a &= -2;
    }

    void a(b bVar) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            RecyclerView.v b2 = this.a.b(size);
            a d = this.a.d(size);
            if ((d.a & 3) == 3) {
                bVar.a(b2);
            } else if ((d.a & 1) != 0) {
                if (d.b == null) {
                    bVar.a(b2);
                } else {
                    bVar.a(b2, d.b, d.c);
                }
            } else if ((d.a & 14) == 14) {
                bVar.b(b2, d.b, d.c);
            } else if ((d.a & 12) == 12) {
                bVar.c(b2, d.b, d.c);
            } else if ((d.a & 4) != 0) {
                bVar.a(b2, d.b, null);
            } else if ((d.a & 8) != 0) {
                bVar.b(b2, d.b, d.c);
            } else {
                int i = d.a;
            }
            a.a(d);
        }
    }

    void g(RecyclerView.v vVar) {
        int b2 = this.b.b() - 1;
        while (true) {
            if (b2 < 0) {
                break;
            }
            if (vVar == this.b.c(b2)) {
                this.b.a(b2);
                break;
            }
            b2--;
        }
        a remove = this.a.remove(vVar);
        if (remove != null) {
            a.a(remove);
        }
    }

    void b() {
        a.b();
    }

    public void h(RecyclerView.v vVar) {
        f(vVar);
    }

    /* compiled from: source */
    static class a {
        static d.a<a> d = new d.b(20);
        int a;
        RecyclerView.f.c b;
        RecyclerView.f.c c;

        private a() {
        }

        static a a() {
            a a = d.a();
            return a == null ? new a() : a;
        }

        static void a(a aVar) {
            aVar.a = 0;
            aVar.b = null;
            aVar.c = null;
            d.a(aVar);
        }

        static void b() {
            while (d.a() != null) {
            }
        }
    }
}
