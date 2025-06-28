package androidx.core.h;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;

/* compiled from: source */
/* loaded from: classes.dex */
public class ae {
    public static final ae a = new a().a().i().h().g();
    private final e b;

    private ae(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.b = new i(this, windowInsets);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.b = new h(this, windowInsets);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.b = new g(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.b = new f(this, windowInsets);
        } else {
            this.b = new e(this);
        }
    }

    public ae(ae aeVar) {
        if (aeVar != null) {
            e eVar = aeVar.b;
            if (Build.VERSION.SDK_INT >= 29 && (eVar instanceof i)) {
                this.b = new i(this, (i) eVar);
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && (eVar instanceof h)) {
                this.b = new h(this, (h) eVar);
                return;
            }
            if (Build.VERSION.SDK_INT >= 21 && (eVar instanceof g)) {
                this.b = new g(this, (g) eVar);
                return;
            } else if (Build.VERSION.SDK_INT >= 20 && (eVar instanceof f)) {
                this.b = new f(this, (f) eVar);
                return;
            } else {
                this.b = new e(this);
                return;
            }
        }
        this.b = new e(this);
    }

    public static ae a(WindowInsets windowInsets) {
        return new ae((WindowInsets) androidx.core.g.e.a(windowInsets));
    }

    public int a() {
        return j().b;
    }

    public int b() {
        return j().c;
    }

    public int c() {
        return j().d;
    }

    public int d() {
        return j().e;
    }

    public boolean e() {
        return !j().equals(androidx.core.graphics.b.a);
    }

    public boolean f() {
        return this.b.b();
    }

    public ae g() {
        return this.b.c();
    }

    @Deprecated
    public ae a(int i2, int i3, int i4, int i5) {
        return new a(this).a(androidx.core.graphics.b.a(i2, i3, i4, i5)).a();
    }

    public ae h() {
        return this.b.d();
    }

    public ae i() {
        return this.b.f();
    }

    public androidx.core.graphics.b j() {
        return this.b.g();
    }

    public androidx.core.graphics.b k() {
        return this.b.i();
    }

    public ae b(int i2, int i3, int i4, int i5) {
        return this.b.a(i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ae) {
            return androidx.core.g.c.a(this.b, ((ae) obj).b);
        }
        return false;
    }

    public int hashCode() {
        if (this.b == null) {
            return 0;
        }
        return this.b.hashCode();
    }

    public WindowInsets l() {
        if (this.b instanceof f) {
            return ((f) this.b).b;
        }
        return null;
    }

    /* compiled from: source */
    private static class e {
        final ae a;

        boolean a() {
            return false;
        }

        boolean b() {
            return false;
        }

        androidx.core.h.c e() {
            return null;
        }

        e(ae aeVar) {
            this.a = aeVar;
        }

        ae c() {
            return this.a;
        }

        ae d() {
            return this.a;
        }

        ae f() {
            return this.a;
        }

        androidx.core.graphics.b g() {
            return androidx.core.graphics.b.a;
        }

        androidx.core.graphics.b h() {
            return androidx.core.graphics.b.a;
        }

        androidx.core.graphics.b i() {
            return g();
        }

        ae a(int i, int i2, int i3, int i4) {
            return ae.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return a() == eVar.a() && b() == eVar.b() && androidx.core.g.c.a(g(), eVar.g()) && androidx.core.g.c.a(h(), eVar.h()) && androidx.core.g.c.a(e(), eVar.e());
        }

        public int hashCode() {
            return androidx.core.g.c.a(Boolean.valueOf(a()), Boolean.valueOf(b()), g(), h(), e());
        }
    }

    /* compiled from: source */
    private static class f extends e {
        final WindowInsets b;
        private androidx.core.graphics.b c;

        f(ae aeVar, WindowInsets windowInsets) {
            super(aeVar);
            this.c = null;
            this.b = windowInsets;
        }

        f(ae aeVar, f fVar) {
            this(aeVar, new WindowInsets(fVar.b));
        }

        @Override // androidx.core.h.ae.e
        boolean a() {
            return this.b.isRound();
        }

        @Override // androidx.core.h.ae.e
        final androidx.core.graphics.b g() {
            if (this.c == null) {
                this.c = androidx.core.graphics.b.a(this.b.getSystemWindowInsetLeft(), this.b.getSystemWindowInsetTop(), this.b.getSystemWindowInsetRight(), this.b.getSystemWindowInsetBottom());
            }
            return this.c;
        }

        @Override // androidx.core.h.ae.e
        ae a(int i, int i2, int i3, int i4) {
            a aVar = new a(ae.a(this.b));
            aVar.a(ae.a(g(), i, i2, i3, i4));
            aVar.b(ae.a(h(), i, i2, i3, i4));
            return aVar.a();
        }
    }

    /* compiled from: source */
    private static class g extends f {
        private androidx.core.graphics.b c;

        g(ae aeVar, WindowInsets windowInsets) {
            super(aeVar, windowInsets);
            this.c = null;
        }

        g(ae aeVar, g gVar) {
            super(aeVar, gVar);
            this.c = null;
        }

        @Override // androidx.core.h.ae.e
        boolean b() {
            return this.b.isConsumed();
        }

        @Override // androidx.core.h.ae.e
        ae d() {
            return ae.a(this.b.consumeStableInsets());
        }

        @Override // androidx.core.h.ae.e
        ae c() {
            return ae.a(this.b.consumeSystemWindowInsets());
        }

        @Override // androidx.core.h.ae.e
        final androidx.core.graphics.b h() {
            if (this.c == null) {
                this.c = androidx.core.graphics.b.a(this.b.getStableInsetLeft(), this.b.getStableInsetTop(), this.b.getStableInsetRight(), this.b.getStableInsetBottom());
            }
            return this.c;
        }
    }

    /* compiled from: source */
    private static class h extends g {
        h(ae aeVar, WindowInsets windowInsets) {
            super(aeVar, windowInsets);
        }

        h(ae aeVar, h hVar) {
            super(aeVar, hVar);
        }

        @Override // androidx.core.h.ae.e
        androidx.core.h.c e() {
            return androidx.core.h.c.a(this.b.getDisplayCutout());
        }

        @Override // androidx.core.h.ae.e
        ae f() {
            return ae.a(this.b.consumeDisplayCutout());
        }

        @Override // androidx.core.h.ae.e
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof h) {
                return Objects.equals(this.b, ((h) obj).b);
            }
            return false;
        }

        @Override // androidx.core.h.ae.e
        public int hashCode() {
            return this.b.hashCode();
        }
    }

    /* compiled from: source */
    private static class i extends h {
        private androidx.core.graphics.b c;
        private androidx.core.graphics.b d;
        private androidx.core.graphics.b e;

        i(ae aeVar, WindowInsets windowInsets) {
            super(aeVar, windowInsets);
            this.c = null;
            this.d = null;
            this.e = null;
        }

        i(ae aeVar, i iVar) {
            super(aeVar, iVar);
            this.c = null;
            this.d = null;
            this.e = null;
        }

        @Override // androidx.core.h.ae.e
        androidx.core.graphics.b i() {
            if (this.c == null) {
                this.c = androidx.core.graphics.b.a(this.b.getSystemGestureInsets());
            }
            return this.c;
        }

        @Override // androidx.core.h.ae.f, androidx.core.h.ae.e
        ae a(int i, int i2, int i3, int i4) {
            return ae.a(this.b.inset(i, i2, i3, i4));
        }
    }

    static androidx.core.graphics.b a(androidx.core.graphics.b bVar, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, bVar.b - i2);
        int max2 = Math.max(0, bVar.c - i3);
        int max3 = Math.max(0, bVar.d - i4);
        int max4 = Math.max(0, bVar.e - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? bVar : androidx.core.graphics.b.a(max, max2, max3, max4);
    }

    /* compiled from: source */
    public static final class a {
        private final b a;

        public a() {
            if (Build.VERSION.SDK_INT >= 29) {
                this.a = new d();
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.a = new c();
            } else {
                this.a = new b();
            }
        }

        public a(ae aeVar) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.a = new d(aeVar);
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.a = new c(aeVar);
            } else {
                this.a = new b(aeVar);
            }
        }

        public a a(androidx.core.graphics.b bVar) {
            this.a.a(bVar);
            return this;
        }

        public a b(androidx.core.graphics.b bVar) {
            this.a.b(bVar);
            return this;
        }

        public ae a() {
            return this.a.a();
        }
    }

    /* compiled from: source */
    private static class b {
        private final ae a;

        void a(androidx.core.graphics.b bVar) {
        }

        void b(androidx.core.graphics.b bVar) {
        }

        b() {
            this(new ae((ae) null));
        }

        b(ae aeVar) {
            this.a = aeVar;
        }

        ae a() {
            return this.a;
        }
    }

    /* compiled from: source */
    private static class c extends b {
        private static Field a = null;
        private static boolean b = false;
        private static Constructor<WindowInsets> c = null;
        private static boolean d = false;
        private WindowInsets e;

        c() {
            this.e = b();
        }

        c(ae aeVar) {
            this.e = aeVar.l();
        }

        @Override // androidx.core.h.ae.b
        void a(androidx.core.graphics.b bVar) {
            if (this.e != null) {
                this.e = this.e.replaceSystemWindowInsets(bVar.b, bVar.c, bVar.d, bVar.e);
            }
        }

        @Override // androidx.core.h.ae.b
        ae a() {
            return ae.a(this.e);
        }

        private static WindowInsets b() {
            if (!b) {
                try {
                    a = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e);
                }
                b = true;
            }
            if (a != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) a.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e2);
                }
            }
            if (!d) {
                try {
                    c = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e3);
                }
                d = true;
            }
            if (c != null) {
                try {
                    return c.newInstance(new Rect());
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e4);
                }
            }
            return null;
        }
    }

    /* compiled from: source */
    private static class d extends b {
        final WindowInsets.Builder a;

        d() {
            this.a = new WindowInsets.Builder();
        }

        d(ae aeVar) {
            WindowInsets.Builder builder;
            WindowInsets l = aeVar.l();
            if (l != null) {
                builder = new WindowInsets.Builder(l);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.a = builder;
        }

        @Override // androidx.core.h.ae.b
        void a(androidx.core.graphics.b bVar) {
            this.a.setSystemWindowInsets(bVar.a());
        }

        @Override // androidx.core.h.ae.b
        void b(androidx.core.graphics.b bVar) {
            this.a.setStableInsets(bVar.a());
        }

        @Override // androidx.core.h.ae.b
        ae a() {
            return ae.a(this.a.build());
        }
    }
}
