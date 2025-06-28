package androidx.work;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class p {
    private UUID a;
    private androidx.work.impl.b.j b;
    private Set<String> c;

    protected p(UUID uuid, androidx.work.impl.b.j jVar, Set<String> set) {
        this.a = uuid;
        this.b = jVar;
        this.c = set;
    }

    public String a() {
        return this.a.toString();
    }

    public androidx.work.impl.b.j b() {
        return this.b;
    }

    public Set<String> c() {
        return this.c;
    }

    /* compiled from: source */
    public static abstract class a<B extends a, W extends p> {
        androidx.work.impl.b.j c;
        boolean a = false;
        Set<String> d = new HashSet();
        UUID b = UUID.randomUUID();

        abstract B c();

        abstract W d();

        a(Class<? extends ListenableWorker> cls) {
            this.c = new androidx.work.impl.b.j(this.b.toString(), cls.getName());
            a(cls.getName());
        }

        public final B a(c cVar) {
            this.c.j = cVar;
            return c();
        }

        public final B a(e eVar) {
            this.c.e = eVar;
            return c();
        }

        public final B a(String str) {
            this.d.add(str);
            return c();
        }

        public final W e() {
            W d = d();
            this.b = UUID.randomUUID();
            this.c = new androidx.work.impl.b.j(this.c);
            this.c.a = this.b.toString();
            return d;
        }
    }
}
