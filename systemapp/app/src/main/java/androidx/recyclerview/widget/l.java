package androidx.recyclerview.widget;

import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
class l {
    final b a;
    a b = new a();

    /* compiled from: source */
    interface b {
        int a();

        int a(View view);

        View a(int i);

        int b();

        int b(View view);
    }

    l(b bVar) {
        this.a = bVar;
    }

    /* compiled from: source */
    static class a {
        int a = 0;
        int b;
        int c;
        int d;
        int e;

        int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        a() {
        }

        void a(int i, int i2, int i3, int i4) {
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        void a(int i) {
            this.a = i | this.a;
        }

        void a() {
            this.a = 0;
        }

        boolean b() {
            if ((this.a & 7) != 0 && (this.a & (a(this.d, this.b) << 0)) == 0) {
                return false;
            }
            if ((this.a & 112) != 0 && (this.a & (a(this.d, this.c) << 4)) == 0) {
                return false;
            }
            if ((this.a & 1792) == 0 || (this.a & (a(this.e, this.b) << 8)) != 0) {
                return (this.a & 28672) == 0 || (this.a & (a(this.e, this.c) << 12)) != 0;
            }
            return false;
        }
    }

    View a(int i, int i2, int i3, int i4) {
        int a2 = this.a.a();
        int b2 = this.a.b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a3 = this.a.a(i);
            this.b.a(a2, b2, this.a.a(a3), this.a.b(a3));
            if (i3 != 0) {
                this.b.a();
                this.b.a(i3);
                if (this.b.b()) {
                    return a3;
                }
            }
            if (i4 != 0) {
                this.b.a();
                this.b.a(i4);
                if (this.b.b()) {
                    view = a3;
                }
            }
            i += i5;
        }
        return view;
    }

    boolean a(View view, int i) {
        this.b.a(this.a.a(), this.a.b(), this.a.a(view), this.a.b(view));
        if (i == 0) {
            return false;
        }
        this.b.a();
        this.b.a(i);
        return this.b.b();
    }
}
