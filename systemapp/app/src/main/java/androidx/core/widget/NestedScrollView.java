package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.h.a.d;
import androidx.core.h.m;
import androidx.core.h.p;
import androidx.core.h.q;
import androidx.core.h.w;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements androidx.core.h.l, p {
    private static final a w = new a();
    private static final int[] x = {R.attr.fillViewport};
    private float A;
    private b B;
    private long a;
    private final Rect b;
    private OverScroller c;
    private EdgeEffect d;
    private EdgeEffect e;
    private int f;
    private boolean g;
    private boolean h;
    private View i;
    private boolean j;
    private VelocityTracker k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private int q;
    private final int[] r;
    private final int[] s;
    private int t;
    private int u;
    private SavedState v;
    private final q y;
    private final m z;

    /* compiled from: source */
    public interface b {
        void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    private static int b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    @Override // androidx.core.h.o
    public boolean a(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Rect();
        this.g = true;
        this.h = false;
        this.i = null;
        this.j = false;
        this.m = true;
        this.q = -1;
        this.r = new int[2];
        this.s = new int[2];
        a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.y = new q(this);
        this.z = new m(this);
        setNestedScrollingEnabled(true);
        w.a(this, w);
    }

    public void a(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        this.z.a(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public boolean a(int i, int i2) {
        return this.z.a(i, i2);
    }

    @Override // androidx.core.h.k
    public void a(int i) {
        this.z.c(i);
    }

    public boolean b(int i) {
        return this.z.a(i);
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.z.a(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.z.a(z);
    }

    @Override // android.view.View, androidx.core.h.j
    public boolean isNestedScrollingEnabled() {
        return this.z.a();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return a(i, 0);
    }

    @Override // android.view.View, androidx.core.h.j
    public void stopNestedScroll() {
        a(0);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return b(0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.z.a(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return a(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.z.a(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.z.a(f, f2);
    }

    @Override // androidx.core.h.p
    public void a(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        a(i4, i5, iArr);
    }

    private void a(int i, int i2, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.z.a(0, scrollY2, 0, i - scrollY2, null, i2, iArr);
    }

    @Override // androidx.core.h.o
    public void b(View view, View view2, int i, int i2) {
        this.y.a(view, view2, i, i2);
        a(2, i2);
    }

    @Override // androidx.core.h.o
    public void a(View view, int i) {
        this.y.a(view, i);
        a(i);
    }

    @Override // androidx.core.h.o
    public void a(View view, int i, int i2, int i3, int i4, int i5) {
        a(i4, i5, (int[]) null);
    }

    @Override // androidx.core.h.o
    public void a(View view, int i, int i2, int[] iArr, int i3) {
        a(i, i2, iArr, (int[]) null, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return a(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public void onNestedScrollAccepted(View view, View view2, int i) {
        b(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public void onStopNestedScroll(View view) {
        a(view, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        a(i4, 0, (int[]) null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        a(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        f((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.y.a();
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * getHeight());
    }

    private void a() {
        this.c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.n = viewConfiguration.getScaledTouchSlop();
        this.o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.B = bVar;
    }

    private boolean b() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public void setFillViewport(boolean z) {
        if (z != this.l) {
            this.l = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.m = z;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.B != null) {
            this.B.a(this, i, i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.l && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    public boolean a(KeyEvent keyEvent) {
        this.b.setEmpty();
        if (!b()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 62) {
            switch (keyCode) {
                case 19:
                    if (!keyEvent.isAltPressed()) {
                        break;
                    } else {
                        break;
                    }
                case 20:
                    if (!keyEvent.isAltPressed()) {
                        break;
                    } else {
                        break;
                    }
            }
            return false;
        }
        c(keyEvent.isShiftPressed() ? 33 : 130);
        return false;
    }

    private boolean c(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    private void c() {
        if (this.k == null) {
            this.k = VelocityTracker.obtain();
        } else {
            this.k.clear();
        }
    }

    private void d() {
        if (this.k == null) {
            this.k = VelocityTracker.obtain();
        }
    }

    private void e() {
        if (this.k != null) {
            this.k.recycle();
            this.k = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.j) {
            return true;
        }
        int i = action & 255;
        if (i != 6) {
            switch (i) {
                case 0:
                    int y = (int) motionEvent.getY();
                    if (!c((int) motionEvent.getX(), y)) {
                        this.j = false;
                        e();
                        break;
                    } else {
                        this.f = y;
                        this.q = motionEvent.getPointerId(0);
                        c();
                        this.k.addMovement(motionEvent);
                        this.c.computeScrollOffset();
                        this.j = !this.c.isFinished();
                        a(2, 0);
                        break;
                    }
                case 1:
                case 3:
                    this.j = false;
                    this.q = -1;
                    e();
                    if (this.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        w.f(this);
                    }
                    a(0);
                    break;
                case 2:
                    int i2 = this.q;
                    if (i2 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i2);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i2 + " in onInterceptTouchEvent");
                            break;
                        } else {
                            int y2 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y2 - this.f) > this.n && (2 & getNestedScrollAxes()) == 0) {
                                this.j = true;
                                this.f = y2;
                                d();
                                this.k.addMovement(motionEvent);
                                this.t = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                    break;
                                }
                            }
                        }
                    }
                    break;
            }
        } else {
            a(motionEvent);
        }
        return this.j;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        d();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.t = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, this.t);
        switch (actionMasked) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.c.isFinished();
                    this.j = z;
                    if (z && (parent = getParent()) != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    if (!this.c.isFinished()) {
                        f();
                    }
                    this.f = (int) motionEvent.getY();
                    this.q = motionEvent.getPointerId(0);
                    a(2, 0);
                    break;
                } else {
                    return false;
                }
                break;
            case 1:
                VelocityTracker velocityTracker = this.k;
                velocityTracker.computeCurrentVelocity(1000, this.p);
                int yVelocity = (int) velocityTracker.getYVelocity(this.q);
                if (Math.abs(yVelocity) >= this.o) {
                    int i = -yVelocity;
                    float f = i;
                    if (!dispatchNestedPreFling(0.0f, f)) {
                        dispatchNestedFling(0.0f, f, true);
                        f(i);
                    }
                } else if (this.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    w.f(this);
                }
                this.q = -1;
                g();
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.q);
                if (findPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.q + " in onTouchEvent");
                    break;
                } else {
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int i2 = this.f - y;
                    if (!this.j && Math.abs(i2) > this.n) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.j = true;
                        i2 = i2 > 0 ? i2 - this.n : i2 + this.n;
                    }
                    int i3 = i2;
                    if (this.j) {
                        if (a(0, i3, this.s, this.r, 0)) {
                            i3 -= this.s[1];
                            this.t += this.r[1];
                        }
                        int i4 = i3;
                        this.f = y - this.r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z2 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (a(0, i4, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !b(0)) {
                            this.k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        this.s[1] = 0;
                        a(0, scrollY2, 0, i4 - scrollY2, this.r, 0, this.s);
                        this.f -= this.r[1];
                        this.t += this.r[1];
                        if (z2) {
                            int i5 = i4 - this.s[1];
                            h();
                            int i6 = scrollY + i5;
                            if (i6 < 0) {
                                d.a(this.d, i5 / getHeight(), motionEvent.getX(findPointerIndex) / getWidth());
                                if (!this.e.isFinished()) {
                                    this.e.onRelease();
                                }
                            } else if (i6 > scrollRange) {
                                d.a(this.e, i5 / getHeight(), 1.0f - (motionEvent.getX(findPointerIndex) / getWidth()));
                                if (!this.d.isFinished()) {
                                    this.d.onRelease();
                                }
                            }
                            if (this.d != null && (!this.d.isFinished() || !this.e.isFinished())) {
                                w.f(this);
                                break;
                            }
                        }
                    }
                }
                break;
            case 3:
                if (this.j && getChildCount() > 0 && this.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    w.f(this);
                }
                this.q = -1;
                g();
                break;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                this.f = (int) motionEvent.getY(actionIndex);
                this.q = motionEvent.getPointerId(actionIndex);
                break;
            case 6:
                a(motionEvent);
                this.f = (int) motionEvent.getY(motionEvent.findPointerIndex(this.q));
                break;
        }
        if (this.k != null) {
            this.k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.q) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f = (int) motionEvent.getY(i);
            this.q = motionEvent.getPointerId(i);
            if (this.k != null) {
                this.k.clear();
            }
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.j) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i = scrollY - verticalScrollFactorCompat;
                if (i < 0) {
                    i = 0;
                } else if (i > scrollRange) {
                    i = scrollRange;
                }
                if (i != scrollY) {
                    super.scrollTo(getScrollX(), i);
                    return true;
                }
            }
        }
        return false;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.A == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.A = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.A;
    }

    @Override // android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int overScrollMode = getOverScrollMode();
        boolean z4 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z5 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z6 = overScrollMode == 0 || (overScrollMode == 1 && z4);
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        int i9 = i3 + i;
        int i10 = !z6 ? 0 : i7;
        int i11 = i4 + i2;
        int i12 = !z7 ? 0 : i8;
        int i13 = -i10;
        int i14 = i10 + i5;
        int i15 = -i12;
        int i16 = i12 + i6;
        if (i9 > i14) {
            z2 = true;
            i13 = i14;
        } else if (i9 < i13) {
            z2 = true;
        } else {
            i13 = i9;
            z2 = false;
        }
        if (i11 > i16) {
            i15 = i16;
        } else if (i11 >= i15) {
            i15 = i11;
            z3 = false;
            if (z3 && !b(1)) {
                this.c.springBack(i13, i15, 0, 0, 0, getScrollRange());
            }
            onOverScrolled(i13, i15, z2, z3);
            return !z2 || z3;
        }
        z3 = true;
        if (z3) {
            this.c.springBack(i13, i15, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i13, i15, z2, z3);
        if (z2) {
        }
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    private View a(boolean z, int i, int i2) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        boolean z2 = false;
        View view = null;
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) focusables.get(i3);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                boolean z3 = i < top && bottom < i2;
                if (view == null) {
                    view = view2;
                    z2 = z3;
                } else {
                    boolean z4 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    if (z2) {
                        if (z3) {
                            if (!z4) {
                            }
                            view = view2;
                        }
                    } else if (z3) {
                        view = view2;
                        z2 = true;
                    } else {
                        if (!z4) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    public boolean c(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                if (this.b.top + height > bottom) {
                    this.b.top = bottom - height;
                }
            }
        } else {
            this.b.top = getScrollY() - height;
            if (this.b.top < 0) {
                this.b.top = 0;
            }
        }
        this.b.bottom = this.b.top + height;
        return a(i, this.b.top, this.b.bottom);
    }

    public boolean d(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        this.b.top = 0;
        this.b.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.b.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            this.b.top = this.b.bottom - height;
        }
        return a(i, this.b.top, this.b.bottom);
    }

    private boolean a(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z = false;
        boolean z2 = i == 33;
        View a2 = a(z2, i2, i3);
        if (a2 == null) {
            a2 = this;
        }
        if (i2 < scrollY || i3 > i4) {
            g(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a2 != findFocus()) {
            a2.requestFocus(i);
        }
        return z;
    }

    public boolean e(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && a(findNextFocus, maxScrollAmount, getHeight())) {
            findNextFocus.getDrawingRect(this.b);
            offsetDescendantRectToMyCoords(findNextFocus, this.b);
            g(a(this.b));
            findNextFocus.requestFocus(i);
        } else {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            g(maxScrollAmount);
        }
        if (findFocus == null || !findFocus.isFocused() || !a(findFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    private boolean a(View view) {
        return !a(view, 0, getHeight());
    }

    private boolean a(View view, int i, int i2) {
        view.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(view, this.b);
        return this.b.bottom + i >= getScrollY() && this.b.top - i <= getScrollY() + i2;
    }

    private void g(int i) {
        if (i != 0) {
            if (this.m) {
                b(0, i);
            } else {
                scrollBy(0, i);
            }
        }
    }

    public final void b(int i, int i2) {
        b(i, i2, 250, false);
    }

    private void b(int i, int i2, int i3, boolean z) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.a > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.c.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY, i3);
            a(z);
        } else {
            if (!this.c.isFinished()) {
                f();
            }
            scrollBy(i, i2);
        }
        this.a = AnimationUtils.currentAnimationTimeMillis();
    }

    void a(int i, int i2, boolean z) {
        a(i, i2, 250, z);
    }

    void a(int i, int i2, int i3, boolean z) {
        b(i - getScrollX(), i2 - getScrollY(), i3, z);
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.c.isFinished()) {
            return;
        }
        this.c.computeScrollOffset();
        int currY = this.c.getCurrY();
        int i = currY - this.u;
        this.u = currY;
        boolean z = false;
        this.s[1] = 0;
        a(0, i, this.s, (int[]) null, 1);
        int i2 = i - this.s[1];
        int scrollRange = getScrollRange();
        if (i2 != 0) {
            int scrollY = getScrollY();
            a(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i3 = i2 - scrollY2;
            this.s[1] = 0;
            a(0, scrollY2, 0, i3, this.r, 1, this.s);
            i2 = i3 - this.s[1];
        }
        if (i2 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z = true;
            }
            if (z) {
                h();
                if (i2 < 0) {
                    if (this.d.isFinished()) {
                        this.d.onAbsorb((int) this.c.getCurrVelocity());
                    }
                } else if (this.e.isFinished()) {
                    this.e.onAbsorb((int) this.c.getCurrVelocity());
                }
            }
            f();
        }
        if (!this.c.isFinished()) {
            w.f(this);
        } else {
            a(1);
        }
    }

    private void a(boolean z) {
        if (z) {
            a(2, 1);
        } else {
            a(1);
        }
        this.u = getScrollY();
        w.f(this);
    }

    private void f() {
        this.c.abortAnimation();
        a(1);
    }

    private void b(View view) {
        view.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(view, this.b);
        int a2 = a(this.b);
        if (a2 != 0) {
            scrollBy(0, a2);
        }
    }

    private boolean a(Rect rect, boolean z) {
        int a2 = a(rect);
        boolean z2 = a2 != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a2);
            } else {
                b(0, a2);
            }
        }
        return z2;
    }

    protected int a(Rect rect) {
        int i;
        int i2;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i3 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i4 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i3 - verticalFadingEdgeLength : i3;
        if (rect.bottom > i4 && rect.top > scrollY) {
            if (rect.height() > height) {
                i2 = 0 + (rect.top - scrollY);
            } else {
                i2 = 0 + (rect.bottom - i4);
            }
            return Math.min(i2, (childAt.getBottom() + layoutParams.bottomMargin) - i3);
        }
        if (rect.top >= scrollY || rect.bottom >= i4) {
            return 0;
        }
        if (rect.height() > height) {
            i = 0 - (i4 - rect.bottom);
        } else {
            i = 0 - (scrollY - rect.top);
        }
        return Math.max(i, -getScrollY());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.g) {
            b(view2);
        } else {
            this.i = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        View findNextFocusFromRect;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (findNextFocusFromRect == null || a(findNextFocusFromRect)) {
            return false;
        }
        return findNextFocusFromRect.requestFocus(i, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return a(rect, z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.g = true;
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        this.g = false;
        if (this.i != null && a(this.i, this)) {
            b(this.i);
        }
        this.i = null;
        if (!this.h) {
            if (this.v != null) {
                scrollTo(getScrollX(), this.v.a);
                this.v = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i5 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int b2 = b(scrollY, paddingTop, i5);
            if (b2 != scrollY) {
                scrollTo(getScrollX(), b2);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.h = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.h = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !a(findFocus, 0, i4)) {
            return;
        }
        findFocus.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(findFocus, this.b);
        g(a(this.b));
    }

    private static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && a((View) parent, view2);
    }

    public void f(int i) {
        if (getChildCount() > 0) {
            this.c.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            a(true);
        }
    }

    private void g() {
        this.j = false;
        e();
        a(0);
        if (this.d != null) {
            this.d.onRelease();
            this.e.onRelease();
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int b2 = b(i, width, width2);
            int b3 = b(i2, height, height2);
            if (b2 == getScrollX() && b3 == getScrollY()) {
                return;
            }
            super.scrollTo(b2, b3);
        }
    }

    private void h() {
        if (getOverScrollMode() != 2) {
            if (this.d == null) {
                Context context = getContext();
                this.d = new EdgeEffect(context);
                this.e = new EdgeEffect(context);
                return;
            }
            return;
        }
        this.d = null;
        this.e = null;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        if (this.d != null) {
            int scrollY = getScrollY();
            int i = 0;
            if (!this.d.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    paddingLeft = getPaddingLeft() + 0;
                } else {
                    paddingLeft = 0;
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate(paddingLeft, min);
                this.d.setSize(width, height);
                if (this.d.draw(canvas)) {
                    w.f(this);
                }
                canvas.restoreToCount(save);
            }
            if (this.e.isFinished()) {
                return;
            }
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                width2 -= getPaddingLeft() + getPaddingRight();
                i = 0 + getPaddingLeft();
            }
            if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                height2 -= getPaddingTop() + getPaddingBottom();
                max -= getPaddingBottom();
            }
            canvas.translate(i - width2, max);
            canvas.rotate(180.0f, width2, 0.0f);
            this.e.setSize(width2, height2);
            if (this.e.draw(canvas)) {
                w.f(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.v = savedState;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = getScrollY();
        return savedState;
    }

    /* compiled from: source */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.core.widget.NestedScrollView.SavedState.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.a + "}";
        }

        /* compiled from: source */
        /* renamed from: androidx.core.widget.NestedScrollView$SavedState$1 */
        class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }
    }

    /* compiled from: source */
    static class a extends androidx.core.h.a {
        a() {
        }

        @Override // androidx.core.h.a
        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i != 4096) {
                if (i == 8192 || i == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.a(0, max, true);
                    return true;
                }
                if (i != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.a(0, min, true);
            return true;
        }

        @Override // androidx.core.h.a
        public void a(View view, androidx.core.h.a.d dVar) {
            int scrollRange;
            super.a(view, dVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            dVar.b((CharSequence) ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            dVar.k(true);
            if (nestedScrollView.getScrollY() > 0) {
                dVar.a(d.a.n);
                dVar.a(d.a.y);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                dVar.a(d.a.m);
                dVar.a(d.a.A);
            }
        }

        @Override // androidx.core.h.a
        public void d(View view, AccessibilityEvent accessibilityEvent) {
            super.d(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            androidx.core.h.a.f.a(accessibilityEvent, nestedScrollView.getScrollX());
            androidx.core.h.a.f.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }
    }
}
