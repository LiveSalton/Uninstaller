package androidx.recyclerview.widget;

import androidx.core.g.d;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
class a implements g.a {
    final ArrayList<b> a;
    final ArrayList<b> b;
    final InterfaceC0041a c;
    Runnable d;
    final boolean e;
    final g f;
    private d.a<b> g;
    private int h;

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.a$a */
    interface InterfaceC0041a {
        RecyclerView.v a(int i);

        void a(int i, int i2);

        void a(int i, int i2, Object obj);

        void a(b bVar);

        void b(int i, int i2);

        void b(b bVar);

        void c(int i, int i2);

        void d(int i, int i2);
    }

    a(InterfaceC0041a interfaceC0041a) {
        this(interfaceC0041a, false);
    }

    a(InterfaceC0041a interfaceC0041a, boolean z) {
        this.g = new d.b(30);
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
        this.h = 0;
        this.c = interfaceC0041a;
        this.e = z;
        this.f = new g(this);
    }

    void a() {
        a(this.a);
        a(this.b);
        this.h = 0;
    }

    void b() {
        this.f.a(this.a);
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.a.get(i);
            int i2 = bVar.a;
            if (i2 == 4) {
                d(bVar);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        f(bVar);
                        break;
                    case 2:
                        c(bVar);
                        break;
                }
            } else {
                b(bVar);
            }
            if (this.d != null) {
                this.d.run();
            }
        }
        this.a.clear();
    }

    void c() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            this.c.b(this.b.get(i));
        }
        a(this.b);
        this.h = 0;
    }

    private void b(b bVar) {
        g(bVar);
    }

    private void c(b bVar) {
        boolean z;
        boolean z2;
        int i = bVar.b;
        int i2 = bVar.b + bVar.d;
        int i3 = bVar.b;
        boolean z3 = -1;
        int i4 = 0;
        while (i3 < i2) {
            if (this.c.a(i3) != null || d(i3)) {
                if (z3) {
                    z = false;
                } else {
                    e(a(2, i, i4, null));
                    z = true;
                }
                z2 = true;
            } else {
                if (z3) {
                    g(a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                z2 = false;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            z3 = z2;
        }
        if (i4 != bVar.d) {
            a(bVar);
            bVar = a(2, i, i4, null);
        }
        if (!z3) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private void d(b bVar) {
        int i = bVar.b;
        int i2 = bVar.b + bVar.d;
        char c = 65535;
        int i3 = i;
        int i4 = 0;
        for (int i5 = bVar.b; i5 < i2; i5++) {
            if (this.c.a(i5) != null || d(i5)) {
                if (c == 0) {
                    e(a(4, i3, i4, bVar.c));
                    i3 = i5;
                    i4 = 0;
                }
                c = 1;
            } else {
                if (c == 1) {
                    g(a(4, i3, i4, bVar.c));
                    i3 = i5;
                    i4 = 0;
                }
                c = 0;
            }
            i4++;
        }
        if (i4 != bVar.d) {
            Object obj = bVar.c;
            a(bVar);
            bVar = a(4, i3, i4, obj);
        }
        if (c == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private void e(b bVar) {
        int i;
        if (bVar.a == 1 || bVar.a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int b2 = b(bVar.b, bVar.a);
        int i2 = bVar.b;
        int i3 = bVar.a;
        if (i3 == 2) {
            i = 0;
        } else {
            if (i3 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i = 1;
        }
        int i4 = b2;
        int i5 = i2;
        int i6 = 1;
        for (int i7 = 1; i7 < bVar.d; i7++) {
            int b3 = b(bVar.b + (i * i7), bVar.a);
            int i8 = bVar.a;
            if (i8 == 2 ? b3 == i4 : i8 == 4 && b3 == i4 + 1) {
                i6++;
            } else {
                b a = a(bVar.a, i4, i6, bVar.c);
                a(a, i5);
                a(a);
                if (bVar.a == 4) {
                    i5 += i6;
                }
                i6 = 1;
                i4 = b3;
            }
        }
        Object obj = bVar.c;
        a(bVar);
        if (i6 > 0) {
            b a2 = a(bVar.a, i4, i6, obj);
            a(a2, i5);
            a(a2);
        }
    }

    void a(b bVar, int i) {
        this.c.a(bVar);
        int i2 = bVar.a;
        if (i2 == 2) {
            this.c.a(i, bVar.d);
        } else {
            if (i2 == 4) {
                this.c.a(i, bVar.d, bVar.c);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int b(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.b.size() - 1; size >= 0; size--) {
            b bVar = this.b.get(size);
            if (bVar.a == 8) {
                if (bVar.b < bVar.d) {
                    i3 = bVar.b;
                    i4 = bVar.d;
                } else {
                    i3 = bVar.d;
                    i4 = bVar.b;
                }
                if (i >= i3 && i <= i4) {
                    if (i3 == bVar.b) {
                        if (i2 == 1) {
                            bVar.d++;
                        } else if (i2 == 2) {
                            bVar.d--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            bVar.b++;
                        } else if (i2 == 2) {
                            bVar.b--;
                        }
                        i--;
                    }
                } else if (i < bVar.b) {
                    if (i2 == 1) {
                        bVar.b++;
                        bVar.d++;
                    } else if (i2 == 2) {
                        bVar.b--;
                        bVar.d--;
                    }
                }
            } else if (bVar.b <= i) {
                if (bVar.a == 1) {
                    i -= bVar.d;
                } else if (bVar.a == 2) {
                    i += bVar.d;
                }
            } else if (i2 == 1) {
                bVar.b++;
            } else if (i2 == 2) {
                bVar.b--;
            }
        }
        for (int size2 = this.b.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.b.get(size2);
            if (bVar2.a == 8) {
                if (bVar2.d == bVar2.b || bVar2.d < 0) {
                    this.b.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.d <= 0) {
                this.b.remove(size2);
                a(bVar2);
            }
        }
        return i;
    }

    private boolean d(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.b.get(i2);
            if (bVar.a == 8) {
                if (a(bVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.a == 1) {
                int i3 = bVar.b + bVar.d;
                for (int i4 = bVar.b; i4 < i3; i4++) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void f(b bVar) {
        g(bVar);
    }

    private void g(b bVar) {
        this.b.add(bVar);
        int i = bVar.a;
        if (i == 4) {
            this.c.a(bVar.b, bVar.d, bVar.c);
            return;
        }
        if (i != 8) {
            switch (i) {
                case 1:
                    this.c.c(bVar.b, bVar.d);
                    return;
                case 2:
                    this.c.b(bVar.b, bVar.d);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown update op type for " + bVar);
            }
        }
        this.c.d(bVar.b, bVar.d);
    }

    boolean d() {
        return this.a.size() > 0;
    }

    boolean a(int i) {
        return (i & this.h) != 0;
    }

    int b(int i) {
        return a(i, 0);
    }

    int a(int i, int i2) {
        int size = this.b.size();
        while (i2 < size) {
            b bVar = this.b.get(i2);
            if (bVar.a == 8) {
                if (bVar.b == i) {
                    i = bVar.d;
                } else {
                    if (bVar.b < i) {
                        i--;
                    }
                    if (bVar.d <= i) {
                        i++;
                    }
                }
            } else if (bVar.b > i) {
                continue;
            } else if (bVar.a == 2) {
                if (i < bVar.b + bVar.d) {
                    return -1;
                }
                i -= bVar.d;
            } else if (bVar.a == 1) {
                i += bVar.d;
            }
            i2++;
        }
        return i;
    }

    void e() {
        c();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.a.get(i);
            int i2 = bVar.a;
            if (i2 == 4) {
                this.c.b(bVar);
                this.c.a(bVar.b, bVar.d, bVar.c);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        this.c.b(bVar);
                        this.c.c(bVar.b, bVar.d);
                        break;
                    case 2:
                        this.c.b(bVar);
                        this.c.a(bVar.b, bVar.d);
                        break;
                }
            } else {
                this.c.b(bVar);
                this.c.d(bVar.b, bVar.d);
            }
            if (this.d != null) {
                this.d.run();
            }
        }
        a(this.a);
        this.h = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int c(int r6) {
        /*
            r5 = this;
            java.util.ArrayList<androidx.recyclerview.widget.a$b> r0 = r5.a
            int r0 = r0.size()
            r1 = 0
        L7:
            if (r1 >= r0) goto L4a
            java.util.ArrayList<androidx.recyclerview.widget.a$b> r2 = r5.a
            java.lang.Object r2 = r2.get(r1)
            androidx.recyclerview.widget.a$b r2 = (androidx.recyclerview.widget.a.b) r2
            int r3 = r2.a
            r4 = 8
            if (r3 == r4) goto L34
            switch(r3) {
                case 1: goto L2c;
                case 2: goto L1b;
                default: goto L1a;
            }
        L1a:
            goto L47
        L1b:
            int r3 = r2.b
            if (r3 > r6) goto L47
            int r3 = r2.b
            int r4 = r2.d
            int r3 = r3 + r4
            if (r3 <= r6) goto L28
            r6 = -1
            return r6
        L28:
            int r2 = r2.d
            int r6 = r6 - r2
            goto L47
        L2c:
            int r3 = r2.b
            if (r3 > r6) goto L47
            int r2 = r2.d
            int r6 = r6 + r2
            goto L47
        L34:
            int r3 = r2.b
            if (r3 != r6) goto L3b
            int r6 = r2.d
            goto L47
        L3b:
            int r3 = r2.b
            if (r3 >= r6) goto L41
            int r6 = r6 + (-1)
        L41:
            int r2 = r2.d
            if (r2 > r6) goto L47
            int r6 = r6 + 1
        L47:
            int r1 = r1 + 1
            goto L7
        L4a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.a.c(int):int");
    }

    boolean f() {
        return (this.b.isEmpty() || this.a.isEmpty()) ? false : true;
    }

    /* compiled from: source */
    static class b {
        int a;
        int b;
        Object c;
        int d;

        b(int i, int i2, int i3, Object obj) {
            this.a = i;
            this.b = i2;
            this.d = i3;
            this.c = obj;
        }

        String a() {
            int i = this.a;
            if (i == 4) {
                return "up";
            }
            if (i == 8) {
                return "mv";
            }
            switch (i) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                default:
                    return "??";
            }
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.b + "c:" + this.d + ",p:" + this.c + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.a != bVar.a) {
                return false;
            }
            if (this.a == 8 && Math.abs(this.d - this.b) == 1 && this.d == bVar.b && this.b == bVar.d) {
                return true;
            }
            if (this.d != bVar.d || this.b != bVar.b) {
                return false;
            }
            if (this.c != null) {
                if (!this.c.equals(bVar.c)) {
                    return false;
                }
            } else if (bVar.c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (31 * ((this.a * 31) + this.b)) + this.d;
        }
    }

    @Override // androidx.recyclerview.widget.g.a
    public b a(int i, int i2, int i3, Object obj) {
        b a = this.g.a();
        if (a == null) {
            return new b(i, i2, i3, obj);
        }
        a.a = i;
        a.b = i2;
        a.d = i3;
        a.c = obj;
        return a;
    }

    @Override // androidx.recyclerview.widget.g.a
    public void a(b bVar) {
        if (this.e) {
            return;
        }
        bVar.c = null;
        this.g.a(bVar);
    }

    void a(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(list.get(i));
        }
        list.clear();
    }
}
