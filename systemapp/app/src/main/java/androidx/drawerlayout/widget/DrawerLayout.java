package androidx.drawerlayout.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.a.d;
import androidx.core.h.a.g;
import androidx.core.h.ae;
import androidx.core.h.w;
import androidx.customview.a.c;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    private static boolean O;
    static final boolean b;
    private static final boolean d;
    private Drawable A;
    private Drawable B;
    private Drawable C;
    private CharSequence D;
    private CharSequence E;
    private Object F;
    private boolean G;
    private Drawable H;
    private Drawable I;
    private Drawable J;
    private Drawable K;
    private final ArrayList<View> L;
    private Rect M;
    private Matrix N;
    private final g P;
    private final b e;
    private float f;
    private int g;
    private int h;
    private float i;
    private Paint j;
    private final androidx.customview.a.c k;
    private final androidx.customview.a.c l;
    private final d m;
    private final d n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private c w;
    private List<c> x;
    private float y;
    private float z;
    private static final int[] c = {R.attr.colorPrimaryDark};
    static final int[] a = {R.attr.layout_gravity};

    /* compiled from: source */
    public interface c {
        void a(int i);

        void a(View view);

        void a(View view, float f);

        void b(View view);
    }

    static {
        b = Build.VERSION.SDK_INT >= 19;
        d = Build.VERSION.SDK_INT >= 21;
        O = Build.VERSION.SDK_INT >= 29;
    }

    /* compiled from: source */
    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$1 */
    class AnonymousClass1 implements g {
        AnonymousClass1() {
        }

        @Override // androidx.core.h.a.g
        public boolean a(View view, g.a aVar) {
            if (!DrawerLayout.this.j(view) || DrawerLayout.this.a(view) == 2) {
                return false;
            }
            DrawerLayout.this.i(view);
            return true;
        }
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0031a.drawerLayoutStyle);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new b();
        this.h = -1728053248;
        this.j = new Paint();
        this.q = true;
        this.r = 3;
        this.s = 3;
        this.t = 3;
        this.u = 3;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.P = new g() { // from class: androidx.drawerlayout.widget.DrawerLayout.1
            AnonymousClass1() {
            }

            @Override // androidx.core.h.a.g
            public boolean a(View view, g.a aVar) {
                if (!DrawerLayout.this.j(view) || DrawerLayout.this.a(view) == 2) {
                    return false;
                }
                DrawerLayout.this.i(view);
                return true;
            }
        };
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.g = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.m = new d(3);
        this.n = new d(5);
        this.k = androidx.customview.a.c.a(this, 1.0f, this.m);
        this.k.a(1);
        this.k.a(f2);
        this.m.a(this.k);
        this.l = androidx.customview.a.c.a(this, 1.0f, this.n);
        this.l.a(2);
        this.l.a(f2);
        this.n.a(this.l);
        setFocusableInTouchMode(true);
        w.b((View) this, 1);
        w.a(this, new a());
        setMotionEventSplittingEnabled(false);
        if (w.u(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.drawerlayout.widget.DrawerLayout.2
                    AnonymousClass2() {
                    }

                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        ((DrawerLayout) view).a(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
                        return windowInsets.consumeSystemWindowInsets();
                    }
                });
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c);
                try {
                    this.A = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.A = null;
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a.c.DrawerLayout, i, 0);
        try {
            if (obtainStyledAttributes2.hasValue(a.c.DrawerLayout_elevation)) {
                this.f = obtainStyledAttributes2.getDimension(a.c.DrawerLayout_elevation, 0.0f);
            } else {
                this.f = getResources().getDimension(a.b.def_drawer_elevation);
            }
            obtainStyledAttributes2.recycle();
            this.L = new ArrayList<>();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$2 */
    class AnonymousClass2 implements View.OnApplyWindowInsetsListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).a(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    public void setDrawerElevation(float f) {
        this.f = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (g(childAt)) {
                w.a(childAt, this.f);
            }
        }
    }

    public float getDrawerElevation() {
        if (d) {
            return this.f;
        }
        return 0.0f;
    }

    public void a(Object obj, boolean z) {
        this.F = obj;
        this.G = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void setScrimColor(int i) {
        this.h = i;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(c cVar) {
        if (this.w != null) {
            b(this.w);
        }
        if (cVar != null) {
            a(cVar);
        }
        this.w = cVar;
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.x == null) {
            this.x = new ArrayList();
        }
        this.x.add(cVar);
    }

    public void b(c cVar) {
        if (cVar == null || this.x == null) {
            return;
        }
        this.x.remove(cVar);
    }

    public void setDrawerLockMode(int i) {
        a(i, 3);
        a(i, 5);
    }

    public void a(int i, int i2) {
        int a2 = androidx.core.h.d.a(i2, w.h(this));
        if (i2 == 3) {
            this.r = i;
        } else if (i2 == 5) {
            this.s = i;
        } else if (i2 == 8388611) {
            this.t = i;
        } else if (i2 == 8388613) {
            this.u = i;
        }
        if (i != 0) {
            (a2 == 3 ? this.k : this.l).f();
        }
        switch (i) {
            case 1:
                View c2 = c(a2);
                if (c2 != null) {
                    i(c2);
                    break;
                }
                break;
            case 2:
                View c3 = c(a2);
                if (c3 != null) {
                    h(c3);
                    break;
                }
                break;
        }
    }

    public int a(int i) {
        int h = w.h(this);
        if (i == 3) {
            if (this.r != 3) {
                return this.r;
            }
            int i2 = h == 0 ? this.t : this.u;
            if (i2 != 3) {
                return i2;
            }
            return 0;
        }
        if (i == 5) {
            if (this.s != 3) {
                return this.s;
            }
            int i3 = h == 0 ? this.u : this.t;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (i == 8388611) {
            if (this.t != 3) {
                return this.t;
            }
            int i4 = h == 0 ? this.r : this.s;
            if (i4 != 3) {
                return i4;
            }
            return 0;
        }
        if (i != 8388613) {
            return 0;
        }
        if (this.u != 3) {
            return this.u;
        }
        int i5 = h == 0 ? this.s : this.r;
        if (i5 != 3) {
            return i5;
        }
        return 0;
    }

    public int a(View view) {
        if (!g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
        return a(((LayoutParams) view.getLayoutParams()).a);
    }

    public CharSequence b(int i) {
        int a2 = androidx.core.h.d.a(i, w.h(this));
        if (a2 == 3) {
            return this.D;
        }
        if (a2 == 5) {
            return this.E;
        }
        return null;
    }

    private boolean a(float f, float f2, View view) {
        if (this.M == null) {
            this.M = new Rect();
        }
        view.getHitRect(this.M);
        return this.M.contains((int) f, (int) f2);
    }

    private boolean a(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent b2 = b(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(b2);
            b2.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent b(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.N == null) {
                this.N = new Matrix();
            }
            matrix.invert(this.N);
            obtain.transform(this.N);
        }
        return obtain;
    }

    void a(int i, View view) {
        int a2 = this.k.a();
        int a3 = this.l.a();
        int i2 = 2;
        if (a2 == 1 || a3 == 1) {
            i2 = 1;
        } else if (a2 != 2 && a3 != 2) {
            i2 = 0;
        }
        if (view != null && i == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.b == 0.0f) {
                b(view);
            } else if (layoutParams.b == 1.0f) {
                c(view);
            }
        }
        if (i2 != this.o) {
            this.o = i2;
            if (this.x != null) {
                for (int size = this.x.size() - 1; size >= 0; size--) {
                    this.x.get(size).a(i2);
                }
            }
        }
    }

    void b(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.d & 1) == 1) {
            layoutParams.d = 0;
            if (this.x != null) {
                for (int size = this.x.size() - 1; size >= 0; size--) {
                    this.x.get(size).b(view);
                }
            }
            c(view, false);
            m(view);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    void c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.d & 1) == 0) {
            layoutParams.d = 1;
            if (this.x != null) {
                for (int size = this.x.size() - 1; size >= 0; size--) {
                    this.x.get(size).a(view);
                }
            }
            c(view, true);
            m(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    private void c(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((!z && !g(childAt)) || (z && childAt == view)) {
                w.b(childAt, 1);
            } else {
                w.b(childAt, 4);
            }
        }
    }

    private void m(View view) {
        w.c(view, d.a.u.a());
        if (!j(view) || a(view) == 2) {
            return;
        }
        w.a(view, d.a.u, null, this.P);
    }

    void a(View view, float f) {
        if (this.x != null) {
            for (int size = this.x.size() - 1; size >= 0; size--) {
                this.x.get(size).a(view, f);
            }
        }
    }

    void b(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f == layoutParams.b) {
            return;
        }
        layoutParams.b = f;
        a(view, f);
    }

    float d(View view) {
        return ((LayoutParams) view.getLayoutParams()).b;
    }

    int e(View view) {
        return androidx.core.h.d.a(((LayoutParams) view.getLayoutParams()).a, w.h(this));
    }

    boolean a(View view, int i) {
        return (e(view) & i) == i;
    }

    View a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    void c(View view, float f) {
        float d2 = d(view);
        float width = view.getWidth();
        int i = ((int) (width * f)) - ((int) (d2 * width));
        if (!a(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        b(view, f);
    }

    View c(int i) {
        int a2 = androidx.core.h.d.a(i, w.h(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((e(childAt) & 7) == a2) {
                return childAt;
            }
        }
        return null;
    }

    static String d(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.q = true;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = 300;
            }
            if (mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        int i3 = 0;
        boolean z = this.F != null && w.u(this);
        int h = w.h(this);
        int childCount = getChildCount();
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z) {
                    int a2 = androidx.core.h.d.a(layoutParams.a, h);
                    if (w.u(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.F;
                            if (a2 == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i3, windowInsets.getSystemWindowInsetBottom());
                            } else if (a2 == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i3, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.F;
                        if (a2 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i3, windowInsets2.getSystemWindowInsetBottom());
                        } else if (a2 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i3, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        layoutParams.leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        layoutParams.topMargin = windowInsets2.getSystemWindowInsetTop();
                        layoutParams.rightMargin = windowInsets2.getSystemWindowInsetRight();
                        layoutParams.bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (f(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824));
                } else if (g(childAt)) {
                    if (d && w.p(childAt) != this.f) {
                        w.a(childAt, this.f);
                    }
                    int e = e(childAt) & 7;
                    int i5 = e == 3 ? 1 : i3;
                    if ((i5 != 0 && z2) || (i5 == 0 && z3)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + d(e) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (i5 != 0) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(getChildMeasureSpec(i, this.g + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), getChildMeasureSpec(i2, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                    i4++;
                    i3 = 0;
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i4 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            i4++;
            i3 = 0;
        }
    }

    private void h() {
        if (d) {
            return;
        }
        this.B = i();
        this.C = j();
    }

    private Drawable i() {
        int h = w.h(this);
        if (h == 0) {
            if (this.H != null) {
                a(this.H, h);
                return this.H;
            }
        } else if (this.I != null) {
            a(this.I, h);
            return this.I;
        }
        return this.J;
    }

    private Drawable j() {
        int h = w.h(this);
        if (h == 0) {
            if (this.I != null) {
                a(this.I, h);
                return this.I;
            }
        } else if (this.H != null) {
            a(this.H, h);
            return this.H;
        }
        return this.K;
    }

    private void a(Drawable drawable, int i) {
        if (drawable == null || !androidx.core.graphics.drawable.a.b(drawable)) {
            return;
        }
        androidx.core.graphics.drawable.a.b(drawable, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WindowInsets rootWindowInsets;
        float f;
        int i5;
        boolean z2 = true;
        this.p = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (f(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        float f2 = measuredWidth;
                        i5 = (-measuredWidth) + ((int) (layoutParams.b * f2));
                        f = (measuredWidth + i5) / f2;
                    } else {
                        float f3 = measuredWidth;
                        f = (i6 - r13) / f3;
                        i5 = i6 - ((int) (layoutParams.b * f3));
                    }
                    boolean z3 = f != layoutParams.b ? z2 : false;
                    int i8 = layoutParams.a & 112;
                    if (i8 == 16) {
                        int i9 = i4 - i2;
                        int i10 = (i9 - measuredHeight) / 2;
                        if (i10 < layoutParams.topMargin) {
                            i10 = layoutParams.topMargin;
                        } else if (i10 + measuredHeight > i9 - layoutParams.bottomMargin) {
                            i10 = (i9 - layoutParams.bottomMargin) - measuredHeight;
                        }
                        childAt.layout(i5, i10, measuredWidth + i5, measuredHeight + i10);
                    } else if (i8 != 80) {
                        childAt.layout(i5, layoutParams.topMargin, measuredWidth + i5, layoutParams.topMargin + measuredHeight);
                    } else {
                        int i11 = i4 - i2;
                        childAt.layout(i5, (i11 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i11 - layoutParams.bottomMargin);
                    }
                    if (z3) {
                        b(childAt, f);
                    }
                    int i12 = layoutParams.b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i12) {
                        childAt.setVisibility(i12);
                    }
                }
            }
            i7++;
            z2 = true;
        }
        if (O && (rootWindowInsets = getRootWindowInsets()) != null) {
            androidx.core.graphics.b k = ae.a(rootWindowInsets).k();
            this.k.b(Math.max(this.k.c(), k.b));
            this.l.b(Math.max(this.l.c(), k.d));
        }
        this.p = false;
        this.q = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.p) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).b);
        }
        this.i = f;
        boolean a2 = this.k.a(true);
        boolean a3 = this.l.a(true);
        if (a2 || a3) {
            w.f(this);
        }
    }

    private static boolean n(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.A = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.A;
    }

    public void setStatusBarBackground(int i) {
        this.A = i != 0 ? androidx.core.content.a.a(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.A = new ColorDrawable(i);
        invalidate();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        h();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.G || this.A == null) {
            return;
        }
        int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || this.F == null) ? 0 : ((WindowInsets) this.F).getSystemWindowInsetTop();
        if (systemWindowInsetTop > 0) {
            this.A.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.A.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int i2;
        int height = getHeight();
        boolean f = f(view);
        int width = getWidth();
        int save = canvas.save();
        if (f) {
            int childCount = getChildCount();
            i = width;
            i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && n(childAt) && g(childAt) && childAt.getHeight() >= height) {
                    if (a(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i2) {
                            i2 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < i) {
                            i = left;
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, i, getHeight());
        } else {
            i = width;
            i2 = 0;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.i > 0.0f && f) {
            this.j.setColor((((int) (((this.h & (-16777216)) >>> 24) * this.i)) << 24) | (this.h & 16777215));
            canvas.drawRect(i2, 0.0f, i, getHeight(), this.j);
        } else if (this.B != null && a(view, 3)) {
            int intrinsicWidth = this.B.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(right2 / this.k.b(), 1.0f));
            this.B.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.B.setAlpha((int) (255.0f * max));
            this.B.draw(canvas);
        } else if (this.C != null && a(view, 5)) {
            int intrinsicWidth2 = this.C.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.l.b(), 1.0f));
            this.C.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.C.setAlpha((int) (255.0f * max2));
            this.C.draw(canvas);
        }
        return drawChild;
    }

    boolean f(View view) {
        return ((LayoutParams) view.getLayoutParams()).a == 0;
    }

    boolean g(View view) {
        int a2 = androidx.core.h.d.a(((LayoutParams) view.getLayoutParams()).a, w.h(view));
        return ((a2 & 3) == 0 && (a2 & 5) == 0) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View d2;
        int actionMasked = motionEvent.getActionMasked();
        boolean a2 = this.k.a(motionEvent) | this.l.a(motionEvent);
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.y = x;
                this.z = y;
                z = this.i > 0.0f && (d2 = this.k.d((int) x, (int) y)) != null && f(d2);
                this.v = false;
                break;
            case 1:
            case 3:
                a(true);
                this.v = false;
                z = false;
                break;
            case 2:
                if (this.k.e(3)) {
                    this.m.a();
                    this.n.a();
                }
                z = false;
                break;
            default:
                z = false;
                break;
        }
        return a2 || z || k() || this.v;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.i <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (a(x, y, childAt) && !f(childAt) && a(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0051, code lost:
    
        if (a(r7) != 2) goto L38;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.a.c r0 = r6.k
            r0.b(r7)
            androidx.customview.a.c r0 = r6.l
            r0.b(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 3
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L67
            switch(r0) {
                case 0: goto L58;
                case 1: goto L19;
                default: goto L18;
            }
        L18:
            goto L6c
        L19:
            float r0 = r7.getX()
            float r7 = r7.getY()
            androidx.customview.a.c r1 = r6.k
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r1 = r1.d(r4, r5)
            if (r1 == 0) goto L53
            boolean r1 = r6.f(r1)
            if (r1 == 0) goto L53
            float r1 = r6.y
            float r0 = r0 - r1
            float r1 = r6.z
            float r7 = r7 - r1
            androidx.customview.a.c r1 = r6.k
            int r1 = r1.e()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r1 = r1 * r1
            float r7 = (float) r1
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L53
            android.view.View r7 = r6.a()
            if (r7 == 0) goto L53
            int r7 = r6.a(r7)
            r0 = 2
            if (r7 != r0) goto L54
        L53:
            r2 = r3
        L54:
            r6.a(r2)
            goto L6c
        L58:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.y = r0
            r6.z = r7
            r6.v = r2
            goto L6c
        L67:
            r6.a(r3)
            r6.v = r2
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            a(true);
        }
    }

    public void b() {
        a(false);
    }

    void a(boolean z) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (g(childAt) && (!z || layoutParams.c)) {
                int width = childAt.getWidth();
                if (a(childAt, 3)) {
                    z2 |= this.k.a(childAt, -width, childAt.getTop());
                } else {
                    z2 |= this.l.a(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.c = false;
            }
        }
        this.m.a();
        this.n.a();
        if (z2) {
            invalidate();
        }
    }

    public void c() {
        e(8388611);
    }

    public void h(View view) {
        a(view, true);
    }

    public void a(View view, boolean z) {
        if (!g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.q) {
            layoutParams.b = 1.0f;
            layoutParams.d = 1;
            c(view, true);
            m(view);
        } else if (z) {
            layoutParams.d |= 2;
            if (a(view, 3)) {
                this.k.a(view, 0, view.getTop());
            } else {
                this.l.a(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            c(view, 1.0f);
            a(0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void e(int i) {
        a(i, true);
    }

    public void a(int i, boolean z) {
        View c2 = c(i);
        if (c2 == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + d(i));
        }
        a(c2, z);
    }

    public void d() {
        f(8388611);
    }

    public void i(View view) {
        b(view, true);
    }

    public void b(View view, boolean z) {
        if (!g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.q) {
            layoutParams.b = 0.0f;
            layoutParams.d = 0;
        } else if (z) {
            layoutParams.d |= 4;
            if (a(view, 3)) {
                this.k.a(view, -view.getWidth(), view.getTop());
            } else {
                this.l.a(view, getWidth(), view.getTop());
            }
        } else {
            c(view, 0.0f);
            a(0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    public void f(int i) {
        b(i, true);
    }

    public void b(int i, boolean z) {
        View c2 = c(i);
        if (c2 == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + d(i));
        }
        b(c2, z);
    }

    public boolean j(View view) {
        if (g(view)) {
            return (((LayoutParams) view.getLayoutParams()).d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean e() {
        return g(8388611);
    }

    public boolean g(int i) {
        View c2 = c(i);
        if (c2 != null) {
            return j(c2);
        }
        return false;
    }

    public boolean k(View view) {
        if (g(view)) {
            return ((LayoutParams) view.getLayoutParams()).b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    private boolean k() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).c) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (g(childAt)) {
                if (j(childAt)) {
                    childAt.addFocusables(arrayList, i, i2);
                    z = true;
                }
            } else {
                this.L.add(childAt);
            }
        }
        if (!z) {
            int size = this.L.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = this.L.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        this.L.clear();
    }

    private boolean l() {
        return f() != null;
    }

    View f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (g(childAt) && k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    void g() {
        if (this.v) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).dispatchTouchEvent(obtain);
        }
        obtain.recycle();
        this.v = true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && l()) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            View f = f();
            if (f != null && a(f) == 0) {
                b();
            }
            return f != null;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View c2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        if (savedState.a != 0 && (c2 = c(savedState.a)) != null) {
            h(c2);
        }
        if (savedState.b != 3) {
            a(savedState.b, 3);
        }
        if (savedState.d != 3) {
            a(savedState.d, 5);
        }
        if (savedState.e != 3) {
            a(savedState.e, 8388611);
        }
        if (savedState.f != 3) {
            a(savedState.f, 8388613);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            boolean z = layoutParams.d == 1;
            boolean z2 = layoutParams.d == 2;
            if (z || z2) {
                savedState.a = layoutParams.a;
                break;
            }
        }
        savedState.b = this.r;
        savedState.d = this.s;
        savedState.e = this.t;
        savedState.f = this.u;
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (a() != null || g(view)) {
            w.b(view, 4);
        } else {
            w.b(view, 1);
        }
        if (b) {
            return;
        }
        w.a(view, this.e);
    }

    static boolean l(View view) {
        return (w.g(view) == 4 || w.g(view) == 2) ? false : true;
    }

    /* compiled from: source */
    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.drawerlayout.widget.DrawerLayout.SavedState.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int a;
        int b;
        int d;
        int e;
        int f;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = 0;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.a = 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
        }

        /* compiled from: source */
        /* renamed from: androidx.drawerlayout.widget.DrawerLayout$SavedState$1 */
        class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }
    }

    /* compiled from: source */
    private class d extends c.a {
        private final int b;
        private androidx.customview.a.c c;
        private final Runnable d = new Runnable() { // from class: androidx.drawerlayout.widget.DrawerLayout.d.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.b();
            }
        };

        @Override // androidx.customview.a.c.a
        public boolean b(int i) {
            return false;
        }

        /* compiled from: source */
        /* renamed from: androidx.drawerlayout.widget.DrawerLayout$d$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.b();
            }
        }

        d(int i) {
            this.b = i;
        }

        public void a(androidx.customview.a.c cVar) {
            this.c = cVar;
        }

        public void a() {
            DrawerLayout.this.removeCallbacks(this.d);
        }

        @Override // androidx.customview.a.c.a
        public boolean b(View view, int i) {
            return DrawerLayout.this.g(view) && DrawerLayout.this.a(view, this.b) && DrawerLayout.this.a(view) == 0;
        }

        @Override // androidx.customview.a.c.a
        public void a(int i) {
            DrawerLayout.this.a(i, this.c.d());
        }

        @Override // androidx.customview.a.c.a
        public void a(View view, int i, int i2, int i3, int i4) {
            int width = view.getWidth();
            float width2 = DrawerLayout.this.a(view, 3) ? (i + width) / width : (DrawerLayout.this.getWidth() - i) / width;
            DrawerLayout.this.b(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // androidx.customview.a.c.a
        public void a(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).c = false;
            c();
        }

        private void c() {
            View c = DrawerLayout.this.c(this.b == 3 ? 5 : 3);
            if (c != null) {
                DrawerLayout.this.i(c);
            }
        }

        @Override // androidx.customview.a.c.a
        public void a(View view, float f, float f2) {
            int i;
            float d = DrawerLayout.this.d(view);
            int width = view.getWidth();
            if (DrawerLayout.this.a(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && d > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && d > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.c.a(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // androidx.customview.a.c.a
        public void a(int i, int i2) {
            DrawerLayout.this.postDelayed(this.d, 160L);
        }

        void b() {
            View c;
            int width;
            int b = this.c.b();
            boolean z = this.b == 3;
            if (z) {
                c = DrawerLayout.this.c(3);
                width = (c != null ? -c.getWidth() : 0) + b;
            } else {
                c = DrawerLayout.this.c(5);
                width = DrawerLayout.this.getWidth() - b;
            }
            if (c != null) {
                if (((!z || c.getLeft() >= width) && (z || c.getLeft() <= width)) || DrawerLayout.this.a(c) != 0) {
                    return;
                }
                LayoutParams layoutParams = (LayoutParams) c.getLayoutParams();
                this.c.a(c, width, c.getTop());
                layoutParams.c = true;
                DrawerLayout.this.invalidate();
                c();
                DrawerLayout.this.g();
            }
        }

        @Override // androidx.customview.a.c.a
        public void b(int i, int i2) {
            View c;
            if ((i & 1) == 1) {
                c = DrawerLayout.this.c(3);
            } else {
                c = DrawerLayout.this.c(5);
            }
            if (c == null || DrawerLayout.this.a(c) != 0) {
                return;
            }
            this.c.a(c, i2);
        }

        @Override // androidx.customview.a.c.a
        public int a(View view) {
            if (DrawerLayout.this.g(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // androidx.customview.a.c.a
        public int a(View view, int i, int i2) {
            if (DrawerLayout.this.a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        @Override // androidx.customview.a.c.a
        public int b(View view, int i, int i2) {
            return view.getTop();
        }
    }

    /* compiled from: source */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int a;
        float b;
        boolean c;
        int d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.a);
            this.a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.a = 0;
            this.a = layoutParams.a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 0;
        }
    }

    /* compiled from: source */
    class a extends androidx.core.h.a {
        private final Rect b = new Rect();

        a() {
        }

        @Override // androidx.core.h.a
        public void a(View view, androidx.core.h.a.d dVar) {
            if (DrawerLayout.b) {
                super.a(view, dVar);
            } else {
                androidx.core.h.a.d a = androidx.core.h.a.d.a(dVar);
                super.a(view, a);
                dVar.b(view);
                Object i = w.i(view);
                if (i instanceof View) {
                    dVar.d((View) i);
                }
                a(dVar, a);
                a.v();
                a(dVar, (ViewGroup) view);
            }
            dVar.b("androidx.drawerlayout.widget.DrawerLayout");
            dVar.c(false);
            dVar.d(false);
            dVar.b(d.a.a);
            dVar.b(d.a.b);
        }

        @Override // androidx.core.h.a
        public void d(View view, AccessibilityEvent accessibilityEvent) {
            super.d(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // androidx.core.h.a
        public boolean b(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() == 32) {
                List<CharSequence> text = accessibilityEvent.getText();
                View f = DrawerLayout.this.f();
                if (f == null) {
                    return true;
                }
                CharSequence b = DrawerLayout.this.b(DrawerLayout.this.e(f));
                if (b == null) {
                    return true;
                }
                text.add(b);
                return true;
            }
            return super.b(view, accessibilityEvent);
        }

        @Override // androidx.core.h.a
        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.b || DrawerLayout.l(view)) {
                return super.a(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        private void a(androidx.core.h.a.d dVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.l(childAt)) {
                    dVar.c(childAt);
                }
            }
        }

        private void a(androidx.core.h.a.d dVar, androidx.core.h.a.d dVar2) {
            Rect rect = this.b;
            dVar2.c(rect);
            dVar.d(rect);
            dVar.e(dVar2.j());
            dVar.a(dVar2.r());
            dVar.b(dVar2.s());
            dVar.e(dVar2.u());
            dVar.j(dVar2.o());
            dVar.d(dVar2.i());
            dVar.f(dVar2.k());
            dVar.g(dVar2.l());
            dVar.a(dVar2.d());
        }
    }

    /* compiled from: source */
    static final class b extends androidx.core.h.a {
        b() {
        }

        @Override // androidx.core.h.a
        public void a(View view, androidx.core.h.a.d dVar) {
            super.a(view, dVar);
            if (DrawerLayout.l(view)) {
                return;
            }
            dVar.d((View) null);
        }
    }
}
