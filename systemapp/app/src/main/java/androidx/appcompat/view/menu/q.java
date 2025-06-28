package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.u;
import androidx.core.h.w;

/* compiled from: source */
/* loaded from: classes.dex */
final class q extends k implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, m {
    private static final int e = a.g.abc_popup_menu_item_layout;
    final u a;
    View c;
    ViewTreeObserver d;
    private final Context f;
    private final g g;
    private final f h;
    private final boolean i;
    private final int j;
    private final int k;
    private final int l;
    private PopupWindow.OnDismissListener n;
    private View o;
    private m.a p;
    private boolean q;
    private boolean r;
    private int s;
    private boolean u;
    final ViewTreeObserver.OnGlobalLayoutListener b = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.q.1
        AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!q.this.e() || q.this.a.j()) {
                return;
            }
            View view = q.this.c;
            if (view == null || !view.isShown()) {
                q.this.d();
            } else {
                q.this.a.a_();
            }
        }
    };
    private final View.OnAttachStateChangeListener m = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.q.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        AnonymousClass2() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (q.this.d != null) {
                if (!q.this.d.isAlive()) {
                    q.this.d = view.getViewTreeObserver();
                }
                q.this.d.removeGlobalOnLayoutListener(q.this.b);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private int t = 0;

    @Override // androidx.appcompat.view.menu.m
    public void a(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(g gVar) {
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable f() {
        return null;
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.view.menu.q$1 */
    class AnonymousClass1 implements ViewTreeObserver.OnGlobalLayoutListener {
        AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!q.this.e() || q.this.a.j()) {
                return;
            }
            View view = q.this.c;
            if (view == null || !view.isShown()) {
                q.this.d();
            } else {
                q.this.a.a_();
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.view.menu.q$2 */
    class AnonymousClass2 implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        AnonymousClass2() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (q.this.d != null) {
                if (!q.this.d.isAlive()) {
                    q.this.d = view.getViewTreeObserver();
                }
                q.this.d.removeGlobalOnLayoutListener(q.this.b);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i, int i2, boolean z) {
        this.f = context;
        this.g = gVar;
        this.i = z;
        this.h = new f(gVar, LayoutInflater.from(context), this.i, e);
        this.k = i;
        this.l = i2;
        Resources resources = context.getResources();
        this.j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.o = view;
        this.a = new u(this.f, null, this.k, this.l);
        gVar.a(this, context);
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(boolean z) {
        this.h.a(z);
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(int i) {
        this.t = i;
    }

    private boolean j() {
        if (e()) {
            return true;
        }
        if (this.q || this.o == null) {
            return false;
        }
        this.c = this.o;
        this.a.a((PopupWindow.OnDismissListener) this);
        this.a.a((AdapterView.OnItemClickListener) this);
        this.a.a(true);
        View view = this.c;
        boolean z = this.d == null;
        this.d = view.getViewTreeObserver();
        if (z) {
            this.d.addOnGlobalLayoutListener(this.b);
        }
        view.addOnAttachStateChangeListener(this.m);
        this.a.b(view);
        this.a.f(this.t);
        if (!this.r) {
            this.s = a(this.h, null, this.f, this.j);
            this.r = true;
        }
        this.a.h(this.s);
        this.a.i(2);
        this.a.a(i());
        this.a.a_();
        ListView g = this.a.g();
        g.setOnKeyListener(this);
        if (this.u && this.g.n() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f).inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup) g, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.g.n());
            }
            frameLayout.setEnabled(false);
            g.addHeaderView(frameLayout, null, false);
        }
        this.a.a((ListAdapter) this.h);
        this.a.a_();
        return true;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a_() {
        if (!j()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public void d() {
        if (e()) {
            this.a.d();
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean e() {
        return !this.q && this.a.e();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.q = true;
        this.g.close();
        if (this.d != null) {
            if (!this.d.isAlive()) {
                this.d = this.c.getViewTreeObserver();
            }
            this.d.removeGlobalOnLayoutListener(this.b);
            this.d = null;
        }
        this.c.removeOnAttachStateChangeListener(this.m);
        if (this.n != null) {
            this.n.onDismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(boolean z) {
        this.r = false;
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(m.a aVar) {
        this.p = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean a(r rVar) {
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.f, rVar, this.c, this.i, this.k, this.l);
            lVar.a(this.p);
            lVar.a(k.b(rVar));
            lVar.a(this.n);
            this.n = null;
            this.g.a(false);
            int f = this.a.f();
            int c = this.a.c();
            if ((Gravity.getAbsoluteGravity(this.t, w.h(this.o)) & 7) == 5) {
                f += this.o.getWidth();
            }
            if (lVar.a(f, c)) {
                if (this.p == null) {
                    return true;
                }
                this.p.a(rVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(g gVar, boolean z) {
        if (gVar != this.g) {
            return;
        }
        d();
        if (this.p != null) {
            this.p.a(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(View view) {
        this.o = view;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        d();
        return true;
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView g() {
        return this.a.g();
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(int i) {
        this.a.b(i);
    }

    @Override // androidx.appcompat.view.menu.k
    public void c(int i) {
        this.a.a(i);
    }

    @Override // androidx.appcompat.view.menu.k
    public void c(boolean z) {
        this.u = z;
    }
}
