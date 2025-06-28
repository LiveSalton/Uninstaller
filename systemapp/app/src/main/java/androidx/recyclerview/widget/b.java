package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
class b {
    final InterfaceC0042b a;
    final a b = new a();
    final List<View> c = new ArrayList();

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.b$b */
    interface InterfaceC0042b {
        int a();

        int a(View view);

        void a(int i);

        void a(View view, int i);

        void a(View view, int i, ViewGroup.LayoutParams layoutParams);

        View b(int i);

        RecyclerView.v b(View view);

        void b();

        void c(int i);

        void c(View view);

        void d(View view);
    }

    b(InterfaceC0042b interfaceC0042b) {
        this.a = interfaceC0042b;
    }

    private void g(View view) {
        this.c.add(view);
        this.a.c(view);
    }

    private boolean h(View view) {
        if (!this.c.remove(view)) {
            return false;
        }
        this.a.d(view);
        return true;
    }

    void a(View view, boolean z) {
        a(view, -1, z);
    }

    void a(View view, int i, boolean z) {
        int f;
        if (i < 0) {
            f = this.a.a();
        } else {
            f = f(i);
        }
        this.b.a(f, z);
        if (z) {
            g(view);
        }
        this.a.a(view, f);
    }

    private int f(int i) {
        if (i < 0) {
            return -1;
        }
        int a2 = this.a.a();
        int i2 = i;
        while (i2 < a2) {
            int e = i - (i2 - this.b.e(i2));
            if (e == 0) {
                while (this.b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    void a(View view) {
        int a2 = this.a.a(view);
        if (a2 < 0) {
            return;
        }
        if (this.b.d(a2)) {
            h(view);
        }
        this.a.a(a2);
    }

    void a(int i) {
        int f = f(i);
        View b = this.a.b(f);
        if (b == null) {
            return;
        }
        if (this.b.d(f)) {
            h(b);
        }
        this.a.a(f);
    }

    View b(int i) {
        return this.a.b(f(i));
    }

    void a() {
        this.b.a();
        for (int size = this.c.size() - 1; size >= 0; size--) {
            this.a.d(this.c.get(size));
            this.c.remove(size);
        }
        this.a.b();
    }

    View c(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.c.get(i2);
            RecyclerView.v b = this.a.b(view);
            if (b.d() == i && !b.n() && !b.q()) {
                return view;
            }
        }
        return null;
    }

    void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int f;
        if (i < 0) {
            f = this.a.a();
        } else {
            f = f(i);
        }
        this.b.a(f, z);
        if (z) {
            g(view);
        }
        this.a.a(view, f, layoutParams);
    }

    int b() {
        return this.a.a() - this.c.size();
    }

    int c() {
        return this.a.a();
    }

    View d(int i) {
        return this.a.b(i);
    }

    void e(int i) {
        int f = f(i);
        this.b.d(f);
        this.a.c(f);
    }

    int b(View view) {
        int a2 = this.a.a(view);
        if (a2 == -1 || this.b.c(a2)) {
            return -1;
        }
        return a2 - this.b.e(a2);
    }

    boolean c(View view) {
        return this.c.contains(view);
    }

    void d(View view) {
        int a2 = this.a.a(view);
        if (a2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.b.a(a2);
        g(view);
    }

    void e(View view) {
        int a2 = this.a.a(view);
        if (a2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (!this.b.c(a2)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        this.b.b(a2);
        h(view);
    }

    public String toString() {
        return this.b.toString() + ", hidden list:" + this.c.size();
    }

    boolean f(View view) {
        int a2 = this.a.a(view);
        if (a2 == -1) {
            h(view);
            return true;
        }
        if (!this.b.c(a2)) {
            return false;
        }
        this.b.d(a2);
        h(view);
        this.a.a(a2);
        return true;
    }

    /* compiled from: source */
    static class a {
        long a = 0;
        a b;

        a() {
        }

        void a(int i) {
            if (i >= 64) {
                b();
                this.b.a(i - 64);
            } else {
                this.a |= 1 << i;
            }
        }

        private void b() {
            if (this.b == null) {
                this.b = new a();
            }
        }

        void b(int i) {
            if (i >= 64) {
                if (this.b != null) {
                    this.b.b(i - 64);
                    return;
                }
                return;
            }
            this.a &= ~(1 << i);
        }

        boolean c(int i) {
            if (i < 64) {
                return (this.a & (1 << i)) != 0;
            }
            b();
            return this.b.c(i - 64);
        }

        void a() {
            this.a = 0L;
            if (this.b != null) {
                this.b.a();
            }
        }

        void a(int i, boolean z) {
            if (i >= 64) {
                b();
                this.b.a(i - 64, z);
                return;
            }
            boolean z2 = (this.a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.a = (this.a & j) | (((~j) & this.a) << 1);
            if (z) {
                a(i);
            } else {
                b(i);
            }
            if (z2 || this.b != null) {
                b();
                this.b.a(0, z2);
            }
        }

        boolean d(int i) {
            if (i >= 64) {
                b();
                return this.b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.a & j) != 0;
            this.a &= ~j;
            long j2 = j - 1;
            this.a = (this.a & j2) | Long.rotateRight((~j2) & this.a, 1);
            if (this.b != null) {
                if (this.b.c(0)) {
                    a(63);
                }
                this.b.d(0);
            }
            return z;
        }

        int e(int i) {
            if (this.b == null) {
                if (i >= 64) {
                    return Long.bitCount(this.a);
                }
                return Long.bitCount(this.a & ((1 << i) - 1));
            }
            if (i < 64) {
                return Long.bitCount(this.a & ((1 << i) - 1));
            }
            return this.b.e(i - 64) + Long.bitCount(this.a);
        }

        public String toString() {
            if (this.b == null) {
                return Long.toBinaryString(this.a);
            }
            return this.b.toString() + "xx" + Long.toBinaryString(this.a);
        }
    }
}
