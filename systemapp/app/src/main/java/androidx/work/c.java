package androidx.work;

import android.os.Build;

/* compiled from: source */
/* loaded from: classes.dex */
public final class c {
    public static final c a = new a().a();
    private i b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private long g;
    private long h;
    private d i;

    public c() {
        this.b = i.NOT_REQUIRED;
        this.g = -1L;
        this.h = -1L;
        this.i = new d();
    }

    c(a aVar) {
        this.b = i.NOT_REQUIRED;
        this.g = -1L;
        this.h = -1L;
        this.i = new d();
        this.c = aVar.a;
        this.d = Build.VERSION.SDK_INT >= 23 && aVar.b;
        this.b = aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        if (Build.VERSION.SDK_INT >= 24) {
            this.i = aVar.h;
            this.g = aVar.f;
            this.h = aVar.g;
        }
    }

    public c(c cVar) {
        this.b = i.NOT_REQUIRED;
        this.g = -1L;
        this.h = -1L;
        this.i = new d();
        this.c = cVar.c;
        this.d = cVar.d;
        this.b = cVar.b;
        this.e = cVar.e;
        this.f = cVar.f;
        this.i = cVar.i;
    }

    public i a() {
        return this.b;
    }

    public void a(i iVar) {
        this.b = iVar;
    }

    public boolean b() {
        return this.c;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean c() {
        return this.d;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public boolean d() {
        return this.e;
    }

    public void c(boolean z) {
        this.e = z;
    }

    public boolean e() {
        return this.f;
    }

    public void d(boolean z) {
        this.f = z;
    }

    public long f() {
        return this.g;
    }

    public void a(long j) {
        this.g = j;
    }

    public long g() {
        return this.h;
    }

    public void b(long j) {
        this.h = j;
    }

    public void a(d dVar) {
        this.i = dVar;
    }

    public d h() {
        return this.i;
    }

    public boolean i() {
        return this.i.b() > 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.c == cVar.c && this.d == cVar.d && this.e == cVar.e && this.f == cVar.f && this.g == cVar.g && this.h == cVar.h && this.b == cVar.b) {
            return this.i.equals(cVar.i);
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((((((((((((this.b.hashCode() * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + ((int) (this.g ^ (this.g >>> 32)))) * 31) + ((int) (this.h ^ (this.h >>> 32))))) + this.i.hashCode();
    }

    /* compiled from: source */
    public static final class a {
        boolean a = false;
        boolean b = false;
        i c = i.NOT_REQUIRED;
        boolean d = false;
        boolean e = false;
        long f = -1;
        long g = -1;
        d h = new d();

        public a a(i iVar) {
            this.c = iVar;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }
}
