package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.m;
import androidx.core.h.ae;

/* compiled from: source */
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements n, androidx.core.h.n, androidx.core.h.o, androidx.core.h.p {
    static final int[] e = {a.C0001a.actionBarSize, R.attr.windowContentOverlay};
    private androidx.core.h.ae A;
    private a B;
    private OverScroller C;
    private final Runnable D;
    private final Runnable E;
    private final androidx.core.h.q F;
    ActionBarContainer a;
    boolean b;
    ViewPropertyAnimator c;
    final AnimatorListenerAdapter d;
    private int f;
    private int g;
    private ContentFrameLayout h;
    private o i;
    private Drawable j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private final Rect u;
    private final Rect v;
    private final Rect w;
    private androidx.core.h.ae x;
    private androidx.core.h.ae y;
    private androidx.core.h.ae z;

    /* compiled from: source */
    public interface a {
        void a(int i);

        void g(boolean z);

        void j();

        void k();

        void l();

        void m();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$1 */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout.this.c = null;
            ActionBarOverlayLayout.this.b = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout.this.c = null;
            ActionBarOverlayLayout.this.b = false;
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.d();
            ActionBarOverlayLayout.this.c = ActionBarOverlayLayout.this.a.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.d);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$3 */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.d();
            ActionBarOverlayLayout.this.c = ActionBarOverlayLayout.this.a.animate().translationY(-ActionBarOverlayLayout.this.a.getHeight()).setListener(ActionBarOverlayLayout.this.d);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 0;
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.v = new Rect();
        this.w = new Rect();
        this.x = androidx.core.h.ae.a;
        this.y = androidx.core.h.ae.a;
        this.z = androidx.core.h.ae.a;
        this.A = androidx.core.h.ae.a;
        this.d = new AnimatorListenerAdapter() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.1
            AnonymousClass1() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout.this.c = null;
                ActionBarOverlayLayout.this.b = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout.this.c = null;
                ActionBarOverlayLayout.this.b = false;
            }
        };
        this.D = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.d();
                ActionBarOverlayLayout.this.c = ActionBarOverlayLayout.this.a.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.d);
            }
        };
        this.E = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.3
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.d();
                ActionBarOverlayLayout.this.c = ActionBarOverlayLayout.this.a.animate().translationY(-ActionBarOverlayLayout.this.a.getHeight()).setListener(ActionBarOverlayLayout.this.d);
            }
        };
        a(context);
        this.F = new androidx.core.h.q(this);
    }

    private void a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(e);
        this.f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.j = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.j == null);
        obtainStyledAttributes.recycle();
        this.k = context.getApplicationInfo().targetSdkVersion < 19;
        this.C = new OverScroller(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.B = aVar;
        if (getWindowToken() != null) {
            this.B.a(this.g);
            if (this.p != 0) {
                onWindowSystemUiVisibilityChanged(this.p);
                androidx.core.h.w.t(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.l = z;
        this.k = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public boolean a() {
        return this.l;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.m = z;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(getContext());
        androidx.core.h.w.t(this);
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        c();
        int i2 = this.p ^ i;
        this.p = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        if (this.B != null) {
            this.B.g(!z2);
            if (z || !z2) {
                this.B.j();
            } else {
                this.B.k();
            }
        }
        if ((i2 & 256) == 0 || this.B == null) {
            return;
        }
        androidx.core.h.w.t(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.g = i;
        if (this.B != null) {
            this.B.a(i);
        }
    }

    private boolean a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!z || layoutParams.leftMargin == rect.left) {
            z5 = false;
        } else {
            layoutParams.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || layoutParams.bottomMargin == rect.bottom) {
            return z5;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        c();
        boolean a2 = a((View) this.a, rect, true, true, false, true);
        this.t.set(rect);
        al.a(this, this.t, this.q);
        if (!this.u.equals(this.t)) {
            this.u.set(this.t);
            a2 = true;
        }
        if (!this.r.equals(this.q)) {
            this.r.set(this.q);
            a2 = true;
        }
        if (a2) {
            requestLayout();
        }
        return true;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        c();
        androidx.core.h.ae a2 = androidx.core.h.ae.a(windowInsets);
        boolean a3 = a((View) this.a, new Rect(a2.a(), a2.b(), a2.c(), a2.d()), true, true, false, true);
        androidx.core.h.w.a(this, a2, this.q);
        this.x = a2.b(this.q.left, this.q.top, this.q.right, this.q.bottom);
        if (!this.y.equals(this.x)) {
            this.y = this.x;
            a3 = true;
        }
        if (!this.r.equals(this.q)) {
            this.r.set(this.q);
            a3 = true;
        }
        if (a3) {
            requestLayout();
        }
        return a2.i().g().h().l();
    }

    @Override // android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        c();
        measureChildWithMargins(this.a, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.a.getLayoutParams();
        int max = Math.max(0, this.a.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, this.a.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.a.getMeasuredState());
        boolean z = (androidx.core.h.w.s(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f;
            if (this.m && this.a.getTabContainer() != null) {
                measuredHeight += this.f;
            }
        } else {
            measuredHeight = this.a.getVisibility() != 8 ? this.a.getMeasuredHeight() : 0;
        }
        this.s.set(this.q);
        if (Build.VERSION.SDK_INT >= 21) {
            this.z = this.x;
        } else {
            this.v.set(this.t);
        }
        if (!this.l && !z) {
            this.s.top += measuredHeight;
            this.s.bottom += 0;
            if (Build.VERSION.SDK_INT >= 21) {
                this.z = this.z.b(0, measuredHeight, 0, 0);
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.z = new ae.a(this.z).a(androidx.core.graphics.b.a(this.z.a(), this.z.b() + measuredHeight, this.z.c(), this.z.d() + 0)).a();
        } else {
            this.v.top += measuredHeight;
            this.v.bottom += 0;
        }
        a((View) this.h, this.s, true, true, true, true);
        if (Build.VERSION.SDK_INT >= 21 && !this.A.equals(this.z)) {
            this.A = this.z;
            androidx.core.h.w.b(this.h, this.z);
        } else if (Build.VERSION.SDK_INT < 21 && !this.w.equals(this.v)) {
            this.w.set(this.v);
            this.h.a(this.v);
        }
        measureChildWithMargins(this.h, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.h.getLayoutParams();
        int max3 = Math.max(max, this.h.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, this.h.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = layoutParams.leftMargin + paddingLeft;
                int i7 = layoutParams.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.j == null || this.k) {
            return;
        }
        int bottom = this.a.getVisibility() == 0 ? (int) (this.a.getBottom() + this.a.getTranslationY() + 0.5f) : 0;
        this.j.setBounds(0, bottom, getWidth(), this.j.getIntrinsicHeight() + bottom);
        this.j.draw(canvas);
    }

    @Override // androidx.core.h.p
    public void a(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        a(view, i, i2, i3, i4, i5);
    }

    @Override // androidx.core.h.o
    public boolean a(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // androidx.core.h.o
    public void b(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // androidx.core.h.o
    public void a(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.h.o
    public void a(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // androidx.core.h.o
    public void a(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.a.getVisibility() != 0) {
            return false;
        }
        return this.n;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.F.a(view, view2, i);
        this.o = getActionBarHideOffset();
        d();
        if (this.B != null) {
            this.B.l();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.o += i2;
        setActionBarHideOffset(this.o);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public void onStopNestedScroll(View view) {
        if (this.n && !this.b) {
            if (this.o <= this.a.getHeight()) {
                l();
            } else {
                m();
            }
        }
        if (this.B != null) {
            this.B.m();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.n || !z) {
            return false;
        }
        if (a(f2)) {
            o();
        } else {
            n();
        }
        this.b = true;
        return true;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.F.a();
    }

    void c() {
        if (this.h == null) {
            this.h = (ContentFrameLayout) findViewById(a.f.action_bar_activity_content);
            this.a = (ActionBarContainer) findViewById(a.f.action_bar_container);
            this.i = a(findViewById(a.f.action_bar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private o a(View view) {
        if (view instanceof o) {
            return (o) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.n) {
            this.n = z;
            if (z) {
                return;
            }
            d();
            setActionBarHideOffset(0);
        }
    }

    public int getActionBarHideOffset() {
        if (this.a != null) {
            return -((int) this.a.getTranslationY());
        }
        return 0;
    }

    public void setActionBarHideOffset(int i) {
        d();
        this.a.setTranslationY(-Math.max(0, Math.min(i, this.a.getHeight())));
    }

    void d() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
        if (this.c != null) {
            this.c.cancel();
        }
    }

    private void l() {
        d();
        postDelayed(this.D, 600L);
    }

    private void m() {
        d();
        postDelayed(this.E, 600L);
    }

    private void n() {
        d();
        this.D.run();
    }

    private void o() {
        d();
        this.E.run();
    }

    private boolean a(float f) {
        this.C.fling(0, 0, 0, (int) f, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.C.getFinalY() > this.a.getHeight();
    }

    @Override // androidx.appcompat.widget.n
    public void setWindowCallback(Window.Callback callback) {
        c();
        this.i.a(callback);
    }

    @Override // androidx.appcompat.widget.n
    public void setWindowTitle(CharSequence charSequence) {
        c();
        this.i.a(charSequence);
    }

    public CharSequence getTitle() {
        c();
        return this.i.e();
    }

    @Override // androidx.appcompat.widget.n
    public void a(int i) {
        c();
        if (i == 2) {
            this.i.f();
        } else if (i == 5) {
            this.i.g();
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public void setIcon(int i) {
        c();
        this.i.a(i);
    }

    public void setIcon(Drawable drawable) {
        c();
        this.i.a(drawable);
    }

    public void setLogo(int i) {
        c();
        this.i.b(i);
    }

    @Override // androidx.appcompat.widget.n
    public boolean e() {
        c();
        return this.i.h();
    }

    @Override // androidx.appcompat.widget.n
    public boolean f() {
        c();
        return this.i.i();
    }

    @Override // androidx.appcompat.widget.n
    public boolean g() {
        c();
        return this.i.j();
    }

    @Override // androidx.appcompat.widget.n
    public boolean h() {
        c();
        return this.i.k();
    }

    @Override // androidx.appcompat.widget.n
    public boolean i() {
        c();
        return this.i.l();
    }

    @Override // androidx.appcompat.widget.n
    public void j() {
        c();
        this.i.m();
    }

    @Override // androidx.appcompat.widget.n
    public void a(Menu menu, m.a aVar) {
        c();
        this.i.a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.n
    public void k() {
        c();
        this.i.n();
    }

    /* compiled from: source */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
