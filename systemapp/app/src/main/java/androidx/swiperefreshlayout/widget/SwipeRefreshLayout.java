package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.h.j;
import androidx.core.h.m;
import androidx.core.h.n;
import androidx.core.h.q;
import androidx.core.h.w;
import androidx.core.widget.g;

/* compiled from: source */
/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements j, n {
    private static final int[] E = {R.attr.enabled};
    private static final String n = "SwipeRefreshLayout";
    private boolean A;
    private int B;
    private boolean C;
    private final DecelerateInterpolator D;
    private int F;
    private Animation G;
    private Animation H;
    private Animation I;
    private Animation J;
    private Animation K;
    private int L;
    private a M;
    private Animation.AnimationListener N;
    private final Animation O;
    private final Animation P;
    b a;
    boolean b;
    int c;
    boolean d;
    androidx.swiperefreshlayout.widget.a e;
    protected int f;
    float g;
    protected int h;
    int i;
    int j;
    androidx.swiperefreshlayout.widget.b k;
    boolean l;
    boolean m;
    private View o;
    private int p;
    private float q;
    private float r;
    private final q s;
    private final m t;
    private final int[] u;
    private final int[] v;
    private boolean w;
    private int x;
    private float y;
    private float z;

    /* compiled from: source */
    public interface a {
        boolean a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    /* compiled from: source */
    public interface b {
        void a();
    }

    /* compiled from: source */
    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$1 */
    class AnonymousClass1 implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        AnonymousClass1() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (SwipeRefreshLayout.this.b) {
                SwipeRefreshLayout.this.k.setAlpha(255);
                SwipeRefreshLayout.this.k.start();
                if (SwipeRefreshLayout.this.l && SwipeRefreshLayout.this.a != null) {
                    SwipeRefreshLayout.this.a.a();
                }
                SwipeRefreshLayout.this.c = SwipeRefreshLayout.this.e.getTop();
                return;
            }
            SwipeRefreshLayout.this.a();
        }
    }

    void a() {
        this.e.clearAnimation();
        this.k.stop();
        this.e.setVisibility(8);
        setColorViewAlpha(255);
        if (this.d) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.h - this.c);
        }
        this.c = this.e.getTop();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    private void setColorViewAlpha(int i) {
        this.e.getBackground().setAlpha(i);
        this.k.setAlpha(i);
    }

    public int getProgressViewStartOffset() {
        return this.h;
    }

    public int getProgressViewEndOffset() {
        return this.i;
    }

    public void setSlingshotDistance(int i) {
        this.j = i;
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.L = (int) (56.0f * displayMetrics.density);
            } else {
                this.L = (int) (40.0f * displayMetrics.density);
            }
            this.e.setImageDrawable(null);
            this.k.a(i);
            this.e.setImageDrawable(this.k);
        }
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
        this.q = -1.0f;
        this.u = new int[2];
        this.v = new int[2];
        this.B = -1;
        this.F = -1;
        this.N = new Animation.AnimationListener() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            AnonymousClass1() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (SwipeRefreshLayout.this.b) {
                    SwipeRefreshLayout.this.k.setAlpha(255);
                    SwipeRefreshLayout.this.k.start();
                    if (SwipeRefreshLayout.this.l && SwipeRefreshLayout.this.a != null) {
                        SwipeRefreshLayout.this.a.a();
                    }
                    SwipeRefreshLayout.this.c = SwipeRefreshLayout.this.e.getTop();
                    return;
                }
                SwipeRefreshLayout.this.a();
            }
        };
        this.O = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.6
            AnonymousClass6() {
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                int i;
                if (!SwipeRefreshLayout.this.m) {
                    i = SwipeRefreshLayout.this.i - Math.abs(SwipeRefreshLayout.this.h);
                } else {
                    i = SwipeRefreshLayout.this.i;
                }
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((SwipeRefreshLayout.this.f + ((int) ((i - SwipeRefreshLayout.this.f) * f))) - SwipeRefreshLayout.this.e.getTop());
                SwipeRefreshLayout.this.k.b(1.0f - f);
            }
        };
        this.P = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.7
            AnonymousClass7() {
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.a(f);
            }
        };
        this.p = ViewConfiguration.get(context).getScaledTouchSlop();
        this.x = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.D = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.L = (int) (40.0f * displayMetrics.density);
        c();
        setChildrenDrawingOrderEnabled(true);
        this.i = (int) (64.0f * displayMetrics.density);
        this.q = this.i;
        this.s = new q(this);
        this.t = new m(this);
        setNestedScrollingEnabled(true);
        int i = -this.L;
        this.c = i;
        this.h = i;
        a(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, E);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.F < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.F;
        }
        return i2 >= this.F ? i2 + 1 : i2;
    }

    private void c() {
        this.e = new androidx.swiperefreshlayout.widget.a(getContext(), -328966);
        this.k = new androidx.swiperefreshlayout.widget.b(getContext());
        this.k.a(1);
        this.e.setImageDrawable(this.k);
        this.e.setVisibility(8);
        addView(this.e);
    }

    public void setOnRefreshListener(b bVar) {
        this.a = bVar;
    }

    public void setRefreshing(boolean z) {
        int i;
        if (z && this.b != z) {
            this.b = z;
            if (!this.m) {
                i = this.i + this.h;
            } else {
                i = this.i;
            }
            setTargetOffsetTopAndBottom(i - this.c);
            this.l = false;
            b(this.N);
            return;
        }
        a(z, false);
    }

    private void b(Animation.AnimationListener animationListener) {
        this.e.setVisibility(0);
        this.k.setAlpha(255);
        this.G = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.2
            AnonymousClass2() {
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f);
            }
        };
        this.G.setDuration(this.x);
        if (animationListener != null) {
            this.e.a(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.G);
    }

    /* compiled from: source */
    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$2 */
    class AnonymousClass2 extends Animation {
        AnonymousClass2() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f);
        }
    }

    void setAnimationProgress(float f) {
        this.e.setScaleX(f);
        this.e.setScaleY(f);
    }

    private void a(boolean z, boolean z2) {
        if (this.b != z) {
            this.l = z2;
            f();
            this.b = z;
            if (this.b) {
                a(this.c, this.N);
            } else {
                a(this.N);
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$3 */
    class AnonymousClass3 extends Animation {
        AnonymousClass3() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
        }
    }

    void a(Animation.AnimationListener animationListener) {
        this.H = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.3
            AnonymousClass3() {
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.H.setDuration(150L);
        this.e.a(animationListener);
        this.e.clearAnimation();
        this.e.startAnimation(this.H);
    }

    private void d() {
        this.I = a(this.k.getAlpha(), 76);
    }

    private void e() {
        this.J = a(this.k.getAlpha(), 255);
    }

    /* compiled from: source */
    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$4 */
    class AnonymousClass4 extends Animation {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        AnonymousClass4(int i, int i2) {
            i = i;
            i2 = i2;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.k.setAlpha((int) (i + ((i2 - i) * f)));
        }
    }

    private Animation a(int i, int i2) {
        AnonymousClass4 anonymousClass4 = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.4
            final /* synthetic */ int a;
            final /* synthetic */ int b;

            AnonymousClass4(int i3, int i22) {
                i = i3;
                i2 = i22;
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.k.setAlpha((int) (i + ((i2 - i) * f)));
            }
        };
        anonymousClass4.setDuration(300L);
        this.e.a(null);
        this.e.clearAnimation();
        this.e.startAnimation(anonymousClass4);
        return anonymousClass4;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.a.c(getContext(), i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.e.setBackgroundColor(i);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = androidx.core.content.a.c(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        f();
        this.k.a(iArr);
    }

    private void f() {
        if (this.o == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.e)) {
                    this.o = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.q = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.o == null) {
            f();
        }
        if (this.o == null) {
            return;
        }
        View view = this.o;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.e.getMeasuredWidth();
        int i5 = measuredWidth / 2;
        int i6 = measuredWidth2 / 2;
        this.e.layout(i5 - i6, this.c, i5 + i6, this.c + this.e.getMeasuredHeight());
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.o == null) {
            f();
        }
        if (this.o == null) {
            return;
        }
        this.o.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.e.measure(View.MeasureSpec.makeMeasureSpec(this.L, 1073741824), View.MeasureSpec.makeMeasureSpec(this.L, 1073741824));
        this.F = -1;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) == this.e) {
                this.F = i3;
                return;
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.L;
    }

    public boolean b() {
        if (this.M != null) {
            return this.M.a(this, this.o);
        }
        if (this.o instanceof ListView) {
            return g.b((ListView) this.o, -1);
        }
        return this.o.canScrollVertically(-1);
    }

    public void setOnChildScrollUpCallback(a aVar) {
        this.M = aVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        f();
        int actionMasked = motionEvent.getActionMasked();
        if (this.C && actionMasked == 0) {
            this.C = false;
        }
        if (!isEnabled() || this.C || b() || this.b || this.w) {
            return false;
        }
        if (actionMasked != 6) {
            switch (actionMasked) {
                case 0:
                    setTargetOffsetTopAndBottom(this.h - this.e.getTop());
                    this.B = motionEvent.getPointerId(0);
                    this.A = false;
                    int findPointerIndex = motionEvent.findPointerIndex(this.B);
                    if (findPointerIndex >= 0) {
                        this.z = motionEvent.getY(findPointerIndex);
                        break;
                    } else {
                        return false;
                    }
                case 1:
                case 3:
                    this.A = false;
                    this.B = -1;
                    break;
                case 2:
                    if (this.B == -1) {
                        Log.e(n, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex2 = motionEvent.findPointerIndex(this.B);
                    if (findPointerIndex2 >= 0) {
                        d(motionEvent.getY(findPointerIndex2));
                        break;
                    } else {
                        return false;
                    }
            }
        } else {
            a(motionEvent);
        }
        return this.A;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.o instanceof AbsListView)) {
            if (this.o == null || w.A(this.o)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.C || this.b || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.s.a(view, view2, i);
        startNestedScroll(i & 2);
        this.r = 0.0f;
        this.w = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.r > 0.0f) {
            float f = i2;
            if (f > this.r) {
                iArr[1] = i2 - ((int) this.r);
                this.r = 0.0f;
            } else {
                this.r -= f;
                iArr[1] = i2;
            }
            b(this.r);
        }
        if (this.m && i2 > 0 && this.r == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.e.setVisibility(8);
        }
        int[] iArr2 = this.u;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.s.a();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public void onStopNestedScroll(View view) {
        this.s.a(view);
        this.w = false;
        if (this.r > 0.0f) {
            c(this.r);
            this.r = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.v);
        if (i4 + this.v[1] >= 0 || b()) {
            return;
        }
        this.r += Math.abs(r11);
        b(this.r);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.t.a(z);
    }

    @Override // android.view.View, androidx.core.h.j
    public boolean isNestedScrollingEnabled() {
        return this.t.a();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.t.b(i);
    }

    @Override // android.view.View, androidx.core.h.j
    public void stopNestedScroll() {
        this.t.c();
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.t.b();
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.t.a(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.t.a(i, i2, iArr, iArr2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.t.a(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.t.a(f, f2);
    }

    private boolean a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void b(float f) {
        this.k.a(true);
        float min = Math.min(1.0f, Math.abs(f / this.q));
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.q;
        float f2 = this.j > 0 ? this.j : this.m ? this.i - this.h : this.i;
        double max2 = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i = this.h + ((int) ((f2 * min) + (f2 * pow * 2.0f)));
        if (this.e.getVisibility() != 0) {
            this.e.setVisibility(0);
        }
        if (!this.d) {
            this.e.setScaleX(1.0f);
            this.e.setScaleY(1.0f);
        }
        if (this.d) {
            setAnimationProgress(Math.min(1.0f, f / this.q));
        }
        if (f < this.q) {
            if (this.k.getAlpha() > 76 && !a(this.I)) {
                d();
            }
        } else if (this.k.getAlpha() < 255 && !a(this.J)) {
            e();
        }
        this.k.a(0.0f, Math.min(0.8f, max * 0.8f));
        this.k.b(Math.min(1.0f, max));
        this.k.c(((-0.25f) + (0.4f * max) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i - this.c);
    }

    private void c(float f) {
        if (f > this.q) {
            a(true, true);
            return;
        }
        this.b = false;
        this.k.a(0.0f, 0.0f);
        b(this.c, this.d ? null : new Animation.AnimationListener() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            AnonymousClass5() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (SwipeRefreshLayout.this.d) {
                    return;
                }
                SwipeRefreshLayout.this.a((Animation.AnimationListener) null);
            }
        });
        this.k.a(false);
    }

    /* compiled from: source */
    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$5 */
    class AnonymousClass5 implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        AnonymousClass5() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (SwipeRefreshLayout.this.d) {
                return;
            }
            SwipeRefreshLayout.this.a((Animation.AnimationListener) null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.C && actionMasked == 0) {
            this.C = false;
        }
        if (!isEnabled() || this.C || b() || this.b || this.w) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                this.B = motionEvent.getPointerId(0);
                this.A = false;
                break;
            case 1:
                int findPointerIndex = motionEvent.findPointerIndex(this.B);
                if (findPointerIndex < 0) {
                    Log.e(n, "Got ACTION_UP event but don't have an active pointer id.");
                    break;
                } else {
                    if (this.A) {
                        float y = (motionEvent.getY(findPointerIndex) - this.y) * 0.5f;
                        this.A = false;
                        c(y);
                    }
                    this.B = -1;
                    break;
                }
            case 2:
                int findPointerIndex2 = motionEvent.findPointerIndex(this.B);
                if (findPointerIndex2 < 0) {
                    Log.e(n, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    break;
                } else {
                    float y2 = motionEvent.getY(findPointerIndex2);
                    d(y2);
                    if (this.A) {
                        float f = (y2 - this.y) * 0.5f;
                        if (f > 0.0f) {
                            b(f);
                            break;
                        }
                    }
                }
                break;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(n, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    break;
                } else {
                    this.B = motionEvent.getPointerId(actionIndex);
                    break;
                }
            case 6:
                a(motionEvent);
                break;
        }
        return false;
    }

    private void d(float f) {
        if (f - this.z <= this.p || this.A) {
            return;
        }
        this.y = this.z + this.p;
        this.A = true;
        this.k.setAlpha(76);
    }

    private void a(int i, Animation.AnimationListener animationListener) {
        this.f = i;
        this.O.reset();
        this.O.setDuration(200L);
        this.O.setInterpolator(this.D);
        if (animationListener != null) {
            this.e.a(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.O);
    }

    private void b(int i, Animation.AnimationListener animationListener) {
        if (this.d) {
            c(i, animationListener);
            return;
        }
        this.f = i;
        this.P.reset();
        this.P.setDuration(200L);
        this.P.setInterpolator(this.D);
        if (animationListener != null) {
            this.e.a(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.P);
    }

    /* compiled from: source */
    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$6 */
    class AnonymousClass6 extends Animation {
        AnonymousClass6() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            int i;
            if (!SwipeRefreshLayout.this.m) {
                i = SwipeRefreshLayout.this.i - Math.abs(SwipeRefreshLayout.this.h);
            } else {
                i = SwipeRefreshLayout.this.i;
            }
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((SwipeRefreshLayout.this.f + ((int) ((i - SwipeRefreshLayout.this.f) * f))) - SwipeRefreshLayout.this.e.getTop());
            SwipeRefreshLayout.this.k.b(1.0f - f);
        }
    }

    void a(float f) {
        setTargetOffsetTopAndBottom((this.f + ((int) ((this.h - this.f) * f))) - this.e.getTop());
    }

    /* compiled from: source */
    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$7 */
    class AnonymousClass7 extends Animation {
        AnonymousClass7() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.a(f);
        }
    }

    private void c(int i, Animation.AnimationListener animationListener) {
        this.f = i;
        this.g = this.e.getScaleX();
        this.K = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.8
            AnonymousClass8() {
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.g + ((-SwipeRefreshLayout.this.g) * f));
                SwipeRefreshLayout.this.a(f);
            }
        };
        this.K.setDuration(150L);
        if (animationListener != null) {
            this.e.a(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.K);
    }

    /* compiled from: source */
    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$8 */
    class AnonymousClass8 extends Animation {
        AnonymousClass8() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.g + ((-SwipeRefreshLayout.this.g) * f));
            SwipeRefreshLayout.this.a(f);
        }
    }

    void setTargetOffsetTopAndBottom(int i) {
        this.e.bringToFront();
        w.f(this.e, i);
        this.c = this.e.getTop();
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.B) {
            this.B = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}
