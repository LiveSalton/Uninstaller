package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class h {
    protected final RecyclerView.i a;
    final Rect b;
    private int c;

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public abstract int h();

    public abstract int i();

    /* synthetic */ h(RecyclerView.i iVar, AnonymousClass1 anonymousClass1) {
        this(iVar);
    }

    private h(RecyclerView.i iVar) {
        this.c = Integer.MIN_VALUE;
        this.b = new Rect();
        this.a = iVar;
    }

    public void a() {
        this.c = f();
    }

    public int b() {
        if (Integer.MIN_VALUE == this.c) {
            return 0;
        }
        return f() - this.c;
    }

    public static h a(RecyclerView.i iVar, int i) {
        switch (i) {
            case 0:
                return a(iVar);
            case 1:
                return b(iVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.h$1 */
    static class AnonymousClass1 extends h {
        AnonymousClass1(RecyclerView.i iVar) {
            super(iVar);
        }

        @Override // androidx.recyclerview.widget.h
        public int d() {
            return this.a.y() - this.a.C();
        }

        @Override // androidx.recyclerview.widget.h
        public int e() {
            return this.a.y();
        }

        @Override // androidx.recyclerview.widget.h
        public void a(int i) {
            this.a.j(i);
        }

        @Override // androidx.recyclerview.widget.h
        public int c() {
            return this.a.A();
        }

        @Override // androidx.recyclerview.widget.h
        public int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.a.f(view) + layoutParams.leftMargin + layoutParams.rightMargin;
        }

        @Override // androidx.recyclerview.widget.h
        public int f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.a.g(view) + layoutParams.topMargin + layoutParams.bottomMargin;
        }

        @Override // androidx.recyclerview.widget.h
        public int b(View view) {
            return this.a.j(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
        }

        @Override // androidx.recyclerview.widget.h
        public int a(View view) {
            return this.a.h(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
        }

        @Override // androidx.recyclerview.widget.h
        public int c(View view) {
            this.a.a(view, true, this.b);
            return this.b.right;
        }

        @Override // androidx.recyclerview.widget.h
        public int d(View view) {
            this.a.a(view, true, this.b);
            return this.b.left;
        }

        @Override // androidx.recyclerview.widget.h
        public int f() {
            return (this.a.y() - this.a.A()) - this.a.C();
        }

        @Override // androidx.recyclerview.widget.h
        public int g() {
            return this.a.C();
        }

        @Override // androidx.recyclerview.widget.h
        public int h() {
            return this.a.w();
        }

        @Override // androidx.recyclerview.widget.h
        public int i() {
            return this.a.x();
        }
    }

    public static h a(RecyclerView.i iVar) {
        return new h(iVar) { // from class: androidx.recyclerview.widget.h.1
            AnonymousClass1(RecyclerView.i iVar2) {
                super(iVar2);
            }

            @Override // androidx.recyclerview.widget.h
            public int d() {
                return this.a.y() - this.a.C();
            }

            @Override // androidx.recyclerview.widget.h
            public int e() {
                return this.a.y();
            }

            @Override // androidx.recyclerview.widget.h
            public void a(int i) {
                this.a.j(i);
            }

            @Override // androidx.recyclerview.widget.h
            public int c() {
                return this.a.A();
            }

            @Override // androidx.recyclerview.widget.h
            public int e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.a.f(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            @Override // androidx.recyclerview.widget.h
            public int f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.a.g(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            @Override // androidx.recyclerview.widget.h
            public int b(View view) {
                return this.a.j(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
            }

            @Override // androidx.recyclerview.widget.h
            public int a(View view) {
                return this.a.h(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
            }

            @Override // androidx.recyclerview.widget.h
            public int c(View view) {
                this.a.a(view, true, this.b);
                return this.b.right;
            }

            @Override // androidx.recyclerview.widget.h
            public int d(View view) {
                this.a.a(view, true, this.b);
                return this.b.left;
            }

            @Override // androidx.recyclerview.widget.h
            public int f() {
                return (this.a.y() - this.a.A()) - this.a.C();
            }

            @Override // androidx.recyclerview.widget.h
            public int g() {
                return this.a.C();
            }

            @Override // androidx.recyclerview.widget.h
            public int h() {
                return this.a.w();
            }

            @Override // androidx.recyclerview.widget.h
            public int i() {
                return this.a.x();
            }
        };
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.h$2 */
    static class AnonymousClass2 extends h {
        AnonymousClass2(RecyclerView.i iVar) {
            super(iVar);
        }

        @Override // androidx.recyclerview.widget.h
        public int d() {
            return this.a.z() - this.a.D();
        }

        @Override // androidx.recyclerview.widget.h
        public int e() {
            return this.a.z();
        }

        @Override // androidx.recyclerview.widget.h
        public void a(int i) {
            this.a.k(i);
        }

        @Override // androidx.recyclerview.widget.h
        public int c() {
            return this.a.B();
        }

        @Override // androidx.recyclerview.widget.h
        public int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.a.g(view) + layoutParams.topMargin + layoutParams.bottomMargin;
        }

        @Override // androidx.recyclerview.widget.h
        public int f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.a.f(view) + layoutParams.leftMargin + layoutParams.rightMargin;
        }

        @Override // androidx.recyclerview.widget.h
        public int b(View view) {
            return this.a.k(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.h
        public int a(View view) {
            return this.a.i(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
        }

        @Override // androidx.recyclerview.widget.h
        public int c(View view) {
            this.a.a(view, true, this.b);
            return this.b.bottom;
        }

        @Override // androidx.recyclerview.widget.h
        public int d(View view) {
            this.a.a(view, true, this.b);
            return this.b.top;
        }

        @Override // androidx.recyclerview.widget.h
        public int f() {
            return (this.a.z() - this.a.B()) - this.a.D();
        }

        @Override // androidx.recyclerview.widget.h
        public int g() {
            return this.a.D();
        }

        @Override // androidx.recyclerview.widget.h
        public int h() {
            return this.a.x();
        }

        @Override // androidx.recyclerview.widget.h
        public int i() {
            return this.a.w();
        }
    }

    public static h b(RecyclerView.i iVar) {
        return new h(iVar) { // from class: androidx.recyclerview.widget.h.2
            AnonymousClass2(RecyclerView.i iVar2) {
                super(iVar2);
            }

            @Override // androidx.recyclerview.widget.h
            public int d() {
                return this.a.z() - this.a.D();
            }

            @Override // androidx.recyclerview.widget.h
            public int e() {
                return this.a.z();
            }

            @Override // androidx.recyclerview.widget.h
            public void a(int i) {
                this.a.k(i);
            }

            @Override // androidx.recyclerview.widget.h
            public int c() {
                return this.a.B();
            }

            @Override // androidx.recyclerview.widget.h
            public int e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.a.g(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            @Override // androidx.recyclerview.widget.h
            public int f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.a.f(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            @Override // androidx.recyclerview.widget.h
            public int b(View view) {
                return this.a.k(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.h
            public int a(View view) {
                return this.a.i(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
            }

            @Override // androidx.recyclerview.widget.h
            public int c(View view) {
                this.a.a(view, true, this.b);
                return this.b.bottom;
            }

            @Override // androidx.recyclerview.widget.h
            public int d(View view) {
                this.a.a(view, true, this.b);
                return this.b.top;
            }

            @Override // androidx.recyclerview.widget.h
            public int f() {
                return (this.a.z() - this.a.B()) - this.a.D();
            }

            @Override // androidx.recyclerview.widget.h
            public int g() {
                return this.a.D();
            }

            @Override // androidx.recyclerview.widget.h
            public int h() {
                return this.a.x();
            }

            @Override // androidx.recyclerview.widget.h
            public int i() {
                return this.a.w();
            }
        };
    }
}
