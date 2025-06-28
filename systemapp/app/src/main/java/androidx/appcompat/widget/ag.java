package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;

/* compiled from: source */
/* loaded from: classes.dex */
public class ag implements o {
    Toolbar a;
    CharSequence b;
    Window.Callback c;
    boolean d;
    private int e;
    private View f;
    private View g;
    private Drawable h;
    private Drawable i;
    private Drawable j;
    private boolean k;
    private CharSequence l;
    private CharSequence m;
    private ActionMenuPresenter n;
    private int o;
    private int p;
    private Drawable q;

    @Override // androidx.appcompat.widget.o
    public void b(boolean z) {
    }

    public ag(Toolbar toolbar, boolean z) {
        this(toolbar, z, a.h.abc_action_bar_up_description, a.e.abc_ic_ab_back_material);
    }

    public ag(Toolbar toolbar, boolean z, int i, int i2) {
        this.o = 0;
        this.p = 0;
        this.a = toolbar;
        this.b = toolbar.getTitle();
        this.l = toolbar.getSubtitle();
        this.k = this.b != null;
        this.j = toolbar.getNavigationIcon();
        af a = af.a(toolbar.getContext(), null, a.j.ActionBar, a.C0001a.actionBarStyle, 0);
        this.q = a.a(a.j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence c = a.c(a.j.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                b(c);
            }
            CharSequence c2 = a.c(a.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c2)) {
                c(c2);
            }
            Drawable a2 = a.a(a.j.ActionBar_logo);
            if (a2 != null) {
                b(a2);
            }
            Drawable a3 = a.a(a.j.ActionBar_icon);
            if (a3 != null) {
                a(a3);
            }
            if (this.j == null && this.q != null) {
                c(this.q);
            }
            c(a.a(a.j.ActionBar_displayOptions, 0));
            int g = a.g(a.j.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                a(LayoutInflater.from(this.a.getContext()).inflate(g, (ViewGroup) this.a, false));
                c(this.e | 16);
            }
            int f = a.f(a.j.ActionBar_height, 0);
            if (f > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = f;
                this.a.setLayoutParams(layoutParams);
            }
            int d = a.d(a.j.ActionBar_contentInsetStart, -1);
            int d2 = a.d(a.j.ActionBar_contentInsetEnd, -1);
            if (d >= 0 || d2 >= 0) {
                this.a.a(Math.max(d, 0), Math.max(d2, 0));
            }
            int g2 = a.g(a.j.ActionBar_titleTextStyle, 0);
            if (g2 != 0) {
                this.a.a(this.a.getContext(), g2);
            }
            int g3 = a.g(a.j.ActionBar_subtitleTextStyle, 0);
            if (g3 != 0) {
                this.a.b(this.a.getContext(), g3);
            }
            int g4 = a.g(a.j.ActionBar_popupTheme, 0);
            if (g4 != 0) {
                this.a.setPopupTheme(g4);
            }
        } else {
            this.e = r();
        }
        a.b();
        e(i);
        this.m = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ag.1
            final androidx.appcompat.view.menu.a a;

            AnonymousClass1() {
                this.a = new androidx.appcompat.view.menu.a(ag.this.a.getContext(), 0, R.id.home, 0, 0, ag.this.b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ag.this.c == null || !ag.this.d) {
                    return;
                }
                ag.this.c.onMenuItemSelected(0, this.a);
            }
        });
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.ag$1 */
    class AnonymousClass1 implements View.OnClickListener {
        final androidx.appcompat.view.menu.a a;

        AnonymousClass1() {
            this.a = new androidx.appcompat.view.menu.a(ag.this.a.getContext(), 0, R.id.home, 0, 0, ag.this.b);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ag.this.c == null || !ag.this.d) {
                return;
            }
            ag.this.c.onMenuItemSelected(0, this.a);
        }
    }

    public void e(int i) {
        if (i == this.p) {
            return;
        }
        this.p = i;
        if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
            f(this.p);
        }
    }

    private int r() {
        if (this.a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.a.getNavigationIcon();
        return 15;
    }

    @Override // androidx.appcompat.widget.o
    public ViewGroup a() {
        return this.a;
    }

    @Override // androidx.appcompat.widget.o
    public Context b() {
        return this.a.getContext();
    }

    @Override // androidx.appcompat.widget.o
    public boolean c() {
        return this.a.g();
    }

    @Override // androidx.appcompat.widget.o
    public void d() {
        this.a.h();
    }

    @Override // androidx.appcompat.widget.o
    public void a(Window.Callback callback) {
        this.c = callback;
    }

    @Override // androidx.appcompat.widget.o
    public void a(CharSequence charSequence) {
        if (this.k) {
            return;
        }
        e(charSequence);
    }

    @Override // androidx.appcompat.widget.o
    public CharSequence e() {
        return this.a.getTitle();
    }

    public void b(CharSequence charSequence) {
        this.k = true;
        e(charSequence);
    }

    private void e(CharSequence charSequence) {
        this.b = charSequence;
        if ((this.e & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    public void c(CharSequence charSequence) {
        this.l = charSequence;
        if ((this.e & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.o
    public void f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.o
    public void g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.o
    public void a(int i) {
        a(i != 0 ? androidx.appcompat.a.a.a.b(b(), i) : null);
    }

    @Override // androidx.appcompat.widget.o
    public void a(Drawable drawable) {
        this.h = drawable;
        s();
    }

    @Override // androidx.appcompat.widget.o
    public void b(int i) {
        b(i != 0 ? androidx.appcompat.a.a.a.b(b(), i) : null);
    }

    public void b(Drawable drawable) {
        this.i = drawable;
        s();
    }

    private void s() {
        Drawable drawable;
        if ((this.e & 2) == 0) {
            drawable = null;
        } else if ((this.e & 1) != 0) {
            drawable = this.i != null ? this.i : this.h;
        } else {
            drawable = this.h;
        }
        this.a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.o
    public boolean h() {
        return this.a.a();
    }

    @Override // androidx.appcompat.widget.o
    public boolean i() {
        return this.a.b();
    }

    @Override // androidx.appcompat.widget.o
    public boolean j() {
        return this.a.c();
    }

    @Override // androidx.appcompat.widget.o
    public boolean k() {
        return this.a.d();
    }

    @Override // androidx.appcompat.widget.o
    public boolean l() {
        return this.a.e();
    }

    @Override // androidx.appcompat.widget.o
    public void m() {
        this.d = true;
    }

    @Override // androidx.appcompat.widget.o
    public void a(Menu menu, m.a aVar) {
        if (this.n == null) {
            this.n = new ActionMenuPresenter(this.a.getContext());
            this.n.a(a.f.action_menu_presenter);
        }
        this.n.a(aVar);
        this.a.a((androidx.appcompat.view.menu.g) menu, this.n);
    }

    @Override // androidx.appcompat.widget.o
    public void n() {
        this.a.f();
    }

    @Override // androidx.appcompat.widget.o
    public int o() {
        return this.e;
    }

    @Override // androidx.appcompat.widget.o
    public void c(int i) {
        int i2 = this.e ^ i;
        this.e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    u();
                }
                t();
            }
            if ((i2 & 3) != 0) {
                s();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.a.setTitle(this.b);
                    this.a.setSubtitle(this.l);
                } else {
                    this.a.setTitle((CharSequence) null);
                    this.a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || this.g == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.a.addView(this.g);
            } else {
                this.a.removeView(this.g);
            }
        }
    }

    @Override // androidx.appcompat.widget.o
    public void a(y yVar) {
        if (this.f != null && this.f.getParent() == this.a) {
            this.a.removeView(this.f);
        }
        this.f = yVar;
        if (yVar == null || this.o != 2) {
            return;
        }
        this.a.addView(this.f, 0);
        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.a = 8388691;
        yVar.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.o
    public void a(boolean z) {
        this.a.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.o
    public int p() {
        return this.o;
    }

    public void a(View view) {
        if (this.g != null && (this.e & 16) != 0) {
            this.a.removeView(this.g);
        }
        this.g = view;
        if (view == null || (this.e & 16) == 0) {
            return;
        }
        this.a.addView(this.g);
    }

    @Override // androidx.appcompat.widget.o
    public androidx.core.h.aa a(int i, long j) {
        return androidx.core.h.w.o(this.a).a(i == 0 ? 1.0f : 0.0f).a(j).a(new androidx.core.h.ac() { // from class: androidx.appcompat.widget.ag.2
            final /* synthetic */ int a;
            private boolean c = false;

            AnonymousClass2(int i2) {
                i = i2;
            }

            @Override // androidx.core.h.ac, androidx.core.h.ab
            public void a(View view) {
                ag.this.a.setVisibility(0);
            }

            @Override // androidx.core.h.ac, androidx.core.h.ab
            public void b(View view) {
                if (this.c) {
                    return;
                }
                ag.this.a.setVisibility(i);
            }

            @Override // androidx.core.h.ac, androidx.core.h.ab
            public void c(View view) {
                this.c = true;
            }
        });
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.ag$2 */
    class AnonymousClass2 extends androidx.core.h.ac {
        final /* synthetic */ int a;
        private boolean c = false;

        AnonymousClass2(int i2) {
            i = i2;
        }

        @Override // androidx.core.h.ac, androidx.core.h.ab
        public void a(View view) {
            ag.this.a.setVisibility(0);
        }

        @Override // androidx.core.h.ac, androidx.core.h.ab
        public void b(View view) {
            if (this.c) {
                return;
            }
            ag.this.a.setVisibility(i);
        }

        @Override // androidx.core.h.ac, androidx.core.h.ab
        public void c(View view) {
            this.c = true;
        }
    }

    public void c(Drawable drawable) {
        this.j = drawable;
        t();
    }

    private void t() {
        if ((this.e & 4) != 0) {
            this.a.setNavigationIcon(this.j != null ? this.j : this.q);
        } else {
            this.a.setNavigationIcon((Drawable) null);
        }
    }

    public void d(CharSequence charSequence) {
        this.m = charSequence;
        u();
    }

    public void f(int i) {
        d(i == 0 ? null : b().getString(i));
    }

    private void u() {
        if ((this.e & 4) != 0) {
            if (TextUtils.isEmpty(this.m)) {
                this.a.setNavigationContentDescription(this.p);
            } else {
                this.a.setNavigationContentDescription(this.m);
            }
        }
    }

    @Override // androidx.appcompat.widget.o
    public void d(int i) {
        this.a.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.o
    public void a(m.a aVar, g.a aVar2) {
        this.a.a(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.o
    public Menu q() {
        return this.a.getMenu();
    }
}
