package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.a;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.o;
import androidx.appcompat.widget.y;
import androidx.core.h.aa;
import androidx.core.h.ab;
import androidx.core.h.ac;
import androidx.core.h.ad;
import androidx.core.h.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class j extends ActionBar implements ActionBarOverlayLayout.a {
    private static final Interpolator s = new AccelerateInterpolator();
    private static final Interpolator t = new DecelerateInterpolator();
    private boolean B;
    private boolean D;
    private boolean F;
    Context a;
    ActionBarOverlayLayout b;
    ActionBarContainer c;
    o d;
    ActionBarContextView e;
    View f;
    y g;
    a h;
    androidx.appcompat.view.b i;
    b.a j;
    boolean l;
    boolean m;
    androidx.appcompat.view.h n;
    boolean o;
    private Context u;
    private Activity v;
    private boolean y;
    private boolean z;
    private ArrayList<Object> w = new ArrayList<>();
    private int x = -1;
    private ArrayList<ActionBar.a> A = new ArrayList<>();
    private int C = 0;
    boolean k = true;
    private boolean E = true;
    final ab p = new ac() { // from class: androidx.appcompat.app.j.1
        AnonymousClass1() {
        }

        @Override // androidx.core.h.ac, androidx.core.h.ab
        public void b(View view) {
            if (j.this.k && j.this.f != null) {
                j.this.f.setTranslationY(0.0f);
                j.this.c.setTranslationY(0.0f);
            }
            j.this.c.setVisibility(8);
            j.this.c.setTransitioning(false);
            j.this.n = null;
            j.this.h();
            if (j.this.b != null) {
                w.t(j.this.b);
            }
        }
    };
    final ab q = new ac() { // from class: androidx.appcompat.app.j.2
        AnonymousClass2() {
        }

        @Override // androidx.core.h.ac, androidx.core.h.ab
        public void b(View view) {
            j.this.n = null;
            j.this.c.requestLayout();
        }
    };
    final ad r = new ad() { // from class: androidx.appcompat.app.j.3
        AnonymousClass3() {
        }

        @Override // androidx.core.h.ad
        public void a(View view) {
            ((View) j.this.c.getParent()).invalidate();
        }
    };

    static boolean a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void m() {
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.app.j$1 */
    class AnonymousClass1 extends ac {
        AnonymousClass1() {
        }

        @Override // androidx.core.h.ac, androidx.core.h.ab
        public void b(View view) {
            if (j.this.k && j.this.f != null) {
                j.this.f.setTranslationY(0.0f);
                j.this.c.setTranslationY(0.0f);
            }
            j.this.c.setVisibility(8);
            j.this.c.setTransitioning(false);
            j.this.n = null;
            j.this.h();
            if (j.this.b != null) {
                w.t(j.this.b);
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.app.j$2 */
    class AnonymousClass2 extends ac {
        AnonymousClass2() {
        }

        @Override // androidx.core.h.ac, androidx.core.h.ab
        public void b(View view) {
            j.this.n = null;
            j.this.c.requestLayout();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.app.j$3 */
    class AnonymousClass3 implements ad {
        AnonymousClass3() {
        }

        @Override // androidx.core.h.ad
        public void a(View view) {
            ((View) j.this.c.getParent()).invalidate();
        }
    }

    public j(Activity activity, boolean z) {
        this.v = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (z) {
            return;
        }
        this.f = decorView.findViewById(R.id.content);
    }

    public j(Dialog dialog) {
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        this.b = (ActionBarOverlayLayout) view.findViewById(a.f.decor_content_parent);
        if (this.b != null) {
            this.b.setActionBarVisibilityCallback(this);
        }
        this.d = b(view.findViewById(a.f.action_bar));
        this.e = (ActionBarContextView) view.findViewById(a.f.action_context_bar);
        this.c = (ActionBarContainer) view.findViewById(a.f.action_bar_container);
        if (this.d == null || this.e == null || this.c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.a = this.d.b();
        boolean z = (this.d.o() & 4) != 0;
        if (z) {
            this.y = true;
        }
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(this.a);
        a(a2.f() || z);
        k(a2.d());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(null, a.j.ActionBar, a.C0001a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(a.j.ActionBar_hideOnContentScroll, false)) {
            b(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(a.j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private o b(View view) {
        if (view instanceof o) {
            return (o) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(float f) {
        w.a(this.c, f);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(Configuration configuration) {
        k(androidx.appcompat.view.a.a(this.a).d());
    }

    private void k(boolean z) {
        this.B = z;
        if (!this.B) {
            this.d.a((y) null);
            this.c.setTabContainer(this.g);
        } else {
            this.c.setTabContainer(null);
            this.d.a(this.g);
        }
        boolean z2 = i() == 2;
        if (this.g != null) {
            if (z2) {
                this.g.setVisibility(0);
                if (this.b != null) {
                    w.t(this.b);
                }
            } else {
                this.g.setVisibility(8);
            }
        }
        this.d.a(!this.B && z2);
        this.b.setHasNonEmbeddedTabs(!this.B && z2);
    }

    void h() {
        if (this.j != null) {
            this.j.a(this.i);
            this.i = null;
            this.j = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void a(int i) {
        this.C = i;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void d(boolean z) {
        this.F = z;
        if (z || this.n == null) {
            return;
        }
        this.n.c();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void e(boolean z) {
        if (z == this.z) {
            return;
        }
        this.z = z;
        int size = this.A.size();
        for (int i = 0; i < size; i++) {
            this.A.get(i).a(z);
        }
    }

    public void f(boolean z) {
        a(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(boolean z) {
        this.d.b(z);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(CharSequence charSequence) {
        this.d.a(charSequence);
    }

    public void a(int i, int i2) {
        int o = this.d.o();
        if ((i2 & 4) != 0) {
            this.y = true;
        }
        this.d.c((i & i2) | ((~i2) & o));
    }

    public int i() {
        return this.d.p();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int a() {
        return this.d.o();
    }

    @Override // androidx.appcompat.app.ActionBar
    public androidx.appcompat.view.b a(b.a aVar) {
        if (this.h != null) {
            this.h.c();
        }
        this.b.setHideOnContentScrollEnabled(false);
        this.e.c();
        a aVar2 = new a(this.e.getContext(), aVar);
        if (!aVar2.e()) {
            return null;
        }
        this.h = aVar2;
        aVar2.d();
        this.e.a(aVar2);
        j(true);
        this.e.sendAccessibilityEvent(32);
        return aVar2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void g(boolean z) {
        this.k = z;
    }

    private void n() {
        if (this.D) {
            return;
        }
        this.D = true;
        if (this.b != null) {
            this.b.setShowingForActionMode(true);
        }
        l(false);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void j() {
        if (this.m) {
            this.m = false;
            l(true);
        }
    }

    private void o() {
        if (this.D) {
            this.D = false;
            if (this.b != null) {
                this.b.setShowingForActionMode(false);
            }
            l(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void k() {
        if (this.m) {
            return;
        }
        this.m = true;
        l(true);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void b(boolean z) {
        if (z && !this.b.a()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.o = z;
        this.b.setHideOnContentScrollEnabled(z);
    }

    private void l(boolean z) {
        if (a(this.l, this.m, this.D)) {
            if (this.E) {
                return;
            }
            this.E = true;
            h(z);
            return;
        }
        if (this.E) {
            this.E = false;
            i(z);
        }
    }

    public void h(boolean z) {
        if (this.n != null) {
            this.n.c();
        }
        this.c.setVisibility(0);
        if (this.C == 0 && (this.F || z)) {
            this.c.setTranslationY(0.0f);
            float f = -this.c.getHeight();
            if (z) {
                this.c.getLocationInWindow(new int[]{0, 0});
                f -= r5[1];
            }
            this.c.setTranslationY(f);
            androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
            aa b = w.o(this.c).b(0.0f);
            b.a(this.r);
            hVar.a(b);
            if (this.k && this.f != null) {
                this.f.setTranslationY(f);
                hVar.a(w.o(this.f).b(0.0f));
            }
            hVar.a(t);
            hVar.a(250L);
            hVar.a(this.q);
            this.n = hVar;
            hVar.a();
        } else {
            this.c.setAlpha(1.0f);
            this.c.setTranslationY(0.0f);
            if (this.k && this.f != null) {
                this.f.setTranslationY(0.0f);
            }
            this.q.b(null);
        }
        if (this.b != null) {
            w.t(this.b);
        }
    }

    public void i(boolean z) {
        if (this.n != null) {
            this.n.c();
        }
        if (this.C == 0 && (this.F || z)) {
            this.c.setAlpha(1.0f);
            this.c.setTransitioning(true);
            androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
            float f = -this.c.getHeight();
            if (z) {
                this.c.getLocationInWindow(new int[]{0, 0});
                f -= r5[1];
            }
            aa b = w.o(this.c).b(f);
            b.a(this.r);
            hVar.a(b);
            if (this.k && this.f != null) {
                hVar.a(w.o(this.f).b(f));
            }
            hVar.a(s);
            hVar.a(250L);
            hVar.a(this.p);
            this.n = hVar;
            hVar.a();
            return;
        }
        this.p.b(null);
    }

    public void j(boolean z) {
        aa a2;
        aa a3;
        if (z) {
            n();
        } else {
            o();
        }
        if (!p()) {
            if (z) {
                this.d.d(4);
                this.e.setVisibility(0);
                return;
            } else {
                this.d.d(0);
                this.e.setVisibility(8);
                return;
            }
        }
        if (z) {
            a3 = this.d.a(4, 100L);
            a2 = this.e.a(0, 200L);
        } else {
            a2 = this.d.a(0, 200L);
            a3 = this.e.a(8, 100L);
        }
        androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
        hVar.a(a3, a2);
        hVar.a();
    }

    private boolean p() {
        return w.C(this.c);
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context b() {
        if (this.u == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(a.C0001a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.u = new ContextThemeWrapper(this.a, i);
            } else {
                this.u = this.a;
            }
        }
        return this.u;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void l() {
        if (this.n != null) {
            this.n.c();
            this.n = null;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean f() {
        if (this.d == null || !this.d.c()) {
            return false;
        }
        this.d.d();
        return true;
    }

    /* compiled from: source */
    public class a extends androidx.appcompat.view.b implements g.a {
        private final Context b;
        private final androidx.appcompat.view.menu.g c;
        private b.a d;
        private WeakReference<View> e;

        public a(Context context, b.a aVar) {
            this.b = context;
            this.d = aVar;
            this.c = new androidx.appcompat.view.menu.g(context).a(1);
            this.c.a(this);
        }

        @Override // androidx.appcompat.view.b
        public MenuInflater a() {
            return new androidx.appcompat.view.g(this.b);
        }

        @Override // androidx.appcompat.view.b
        public Menu b() {
            return this.c;
        }

        @Override // androidx.appcompat.view.b
        public void c() {
            if (j.this.h != this) {
                return;
            }
            if (!j.a(j.this.l, j.this.m, false)) {
                j.this.i = this;
                j.this.j = this.d;
            } else {
                this.d.a(this);
            }
            this.d = null;
            j.this.j(false);
            j.this.e.b();
            j.this.d.a().sendAccessibilityEvent(32);
            j.this.b.setHideOnContentScrollEnabled(j.this.o);
            j.this.h = null;
        }

        @Override // androidx.appcompat.view.b
        public void d() {
            if (j.this.h != this) {
                return;
            }
            this.c.h();
            try {
                this.d.b(this, this.c);
            } finally {
                this.c.i();
            }
        }

        public boolean e() {
            this.c.h();
            try {
                return this.d.a(this, this.c);
            } finally {
                this.c.i();
            }
        }

        @Override // androidx.appcompat.view.b
        public void a(View view) {
            j.this.e.setCustomView(view);
            this.e = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.b
        public void a(CharSequence charSequence) {
            j.this.e.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void b(CharSequence charSequence) {
            j.this.e.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void a(int i) {
            b(j.this.a.getResources().getString(i));
        }

        @Override // androidx.appcompat.view.b
        public void b(int i) {
            a((CharSequence) j.this.a.getResources().getString(i));
        }

        @Override // androidx.appcompat.view.b
        public CharSequence f() {
            return j.this.e.getTitle();
        }

        @Override // androidx.appcompat.view.b
        public CharSequence g() {
            return j.this.e.getSubtitle();
        }

        @Override // androidx.appcompat.view.b
        public void a(boolean z) {
            super.a(z);
            j.this.e.setTitleOptional(z);
        }

        @Override // androidx.appcompat.view.b
        public boolean h() {
            return j.this.e.d();
        }

        @Override // androidx.appcompat.view.b
        public View i() {
            if (this.e != null) {
                return this.e.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            if (this.d != null) {
                return this.d.a(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void a(androidx.appcompat.view.menu.g gVar) {
            if (this.d == null) {
                return;
            }
            d();
            j.this.e.a();
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void c(boolean z) {
        if (this.y) {
            return;
        }
        f(z);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean a(int i, KeyEvent keyEvent) {
        Menu b;
        if (this.h == null || (b = this.h.b()) == null) {
            return false;
        }
        b.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return b.performShortcut(i, keyEvent, 0);
    }
}
