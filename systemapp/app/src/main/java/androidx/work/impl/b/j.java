package androidx.work.impl.b;

import androidx.work.n;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class j {
    public String a;
    public n.a b;
    public String c;
    public String d;
    public androidx.work.e e;
    public androidx.work.e f;
    public long g;
    public long h;
    public long i;
    public androidx.work.c j;
    public int k;
    public androidx.work.a l;
    public long m;
    public long n;
    public long o;
    public long p;
    private static final String r = androidx.work.h.a("WorkSpec");
    public static final androidx.a.a.c.a<List<Object>, List<androidx.work.n>> q = new androidx.a.a.c.a<List<Object>, List<androidx.work.n>>() { // from class: androidx.work.impl.b.j.1
        AnonymousClass1() {
        }
    };

    public j(String str, String str2) {
        this.b = n.a.ENQUEUED;
        this.e = androidx.work.e.a;
        this.f = androidx.work.e.a;
        this.j = androidx.work.c.a;
        this.l = androidx.work.a.EXPONENTIAL;
        this.m = 30000L;
        this.p = -1L;
        this.a = str;
        this.c = str2;
    }

    public j(j jVar) {
        this.b = n.a.ENQUEUED;
        this.e = androidx.work.e.a;
        this.f = androidx.work.e.a;
        this.j = androidx.work.c.a;
        this.l = androidx.work.a.EXPONENTIAL;
        this.m = 30000L;
        this.p = -1L;
        this.a = jVar.a;
        this.c = jVar.c;
        this.b = jVar.b;
        this.d = jVar.d;
        this.e = new androidx.work.e(jVar.e);
        this.f = new androidx.work.e(jVar.f);
        this.g = jVar.g;
        this.h = jVar.h;
        this.i = jVar.i;
        this.j = new androidx.work.c(jVar.j);
        this.k = jVar.k;
        this.l = jVar.l;
        this.m = jVar.m;
        this.n = jVar.n;
        this.o = jVar.o;
        this.p = jVar.p;
    }

    public boolean a() {
        return this.h != 0;
    }

    public boolean b() {
        return this.b == n.a.ENQUEUED && this.k > 0;
    }

    public long c() {
        long scalb;
        if (b()) {
            if (this.l == androidx.work.a.LINEAR) {
                scalb = this.m * this.k;
            } else {
                scalb = (long) Math.scalb(this.m, this.k - 1);
            }
            return this.n + Math.min(18000000L, scalb);
        }
        if (a()) {
            long currentTimeMillis = this.n == 0 ? System.currentTimeMillis() + this.g : this.n;
            if (this.i != this.h) {
                return currentTimeMillis + this.h + (this.n == 0 ? (-1) * this.i : 0L);
            }
            return currentTimeMillis + (this.n != 0 ? this.h : 0L);
        }
        return (this.n == 0 ? System.currentTimeMillis() : this.n) + this.g;
    }

    public boolean d() {
        return !androidx.work.c.a.equals(this.j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (this.g != jVar.g || this.h != jVar.h || this.i != jVar.i || this.k != jVar.k || this.m != jVar.m || this.n != jVar.n || this.o != jVar.o || this.p != jVar.p || !this.a.equals(jVar.a) || this.b != jVar.b || !this.c.equals(jVar.c)) {
            return false;
        }
        if (this.d == null ? jVar.d == null : this.d.equals(jVar.d)) {
            return this.e.equals(jVar.e) && this.f.equals(jVar.f) && this.j.equals(jVar.j) && this.l == jVar.l;
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((((((((((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + (this.d != null ? this.d.hashCode() : 0)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + ((int) (this.g ^ (this.g >>> 32)))) * 31) + ((int) (this.h ^ (this.h >>> 32)))) * 31) + ((int) (this.i ^ (this.i >>> 32)))) * 31) + this.j.hashCode()) * 31) + this.k) * 31) + this.l.hashCode()) * 31) + ((int) (this.m ^ (this.m >>> 32)))) * 31) + ((int) (this.n ^ (this.n >>> 32)))) * 31) + ((int) (this.o ^ (this.o >>> 32))))) + ((int) (this.p ^ (this.p >>> 32)));
    }

    public String toString() {
        return "{WorkSpec: " + this.a + "}";
    }

    /* compiled from: source */
    public static class a {
        public String a;
        public n.a b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.b != aVar.b) {
                return false;
            }
            return this.a.equals(aVar.a);
        }

        public int hashCode() {
            return (31 * this.a.hashCode()) + this.b.hashCode();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.b.j$1 */
    static class AnonymousClass1 implements androidx.a.a.c.a<List<Object>, List<androidx.work.n>> {
        AnonymousClass1() {
        }
    }
}
