package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.c;
import androidx.core.h.ae;
import androidx.core.h.j;
import androidx.core.h.r;
import androidx.core.h.w;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.a;
import com.google.android.material.internal.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
@CoordinatorLayout.b(a = Behavior.class)
/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout {
    private int a;
    private int b;
    private int c;
    private boolean d;
    private int e;
    private ae f;
    private List<a> g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int[] l;

    /* compiled from: source */
    public interface a<T extends AppBarLayout> {
        void a(T t, int i);
    }

    /* compiled from: source */
    public interface b extends a<AppBarLayout> {
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.e = 0;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            com.google.android.material.appbar.b.a(this);
            com.google.android.material.appbar.b.a(this, attributeSet, 0, a.j.Widget_Design_AppBarLayout);
        }
        TypedArray a2 = k.a(context, attributeSet, a.k.AppBarLayout, 0, a.j.Widget_Design_AppBarLayout, new int[0]);
        w.a(this, a2.getDrawable(a.k.AppBarLayout_android_background));
        if (a2.hasValue(a.k.AppBarLayout_expanded)) {
            a(a2.getBoolean(a.k.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && a2.hasValue(a.k.AppBarLayout_elevation)) {
            com.google.android.material.appbar.b.a(this, a2.getDimensionPixelSize(a.k.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (a2.hasValue(a.k.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(a2.getBoolean(a.k.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (a2.hasValue(a.k.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(a2.getBoolean(a.k.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.k = a2.getBoolean(a.k.AppBarLayout_liftOnScroll, false);
        a2.recycle();
        w.a(this, new r() { // from class: com.google.android.material.appbar.AppBarLayout.1
            AnonymousClass1() {
            }

            @Override // androidx.core.h.r
            public ae a(View view, ae aeVar) {
                return AppBarLayout.this.a(aeVar);
            }
        });
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.appbar.AppBarLayout$1 */
    class AnonymousClass1 implements r {
        AnonymousClass1() {
        }

        @Override // androidx.core.h.r
        public ae a(View view, ae aeVar) {
            return AppBarLayout.this.a(aeVar);
        }
    }

    public void a(a aVar) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        if (aVar == null || this.g.contains(aVar)) {
            return;
        }
        this.g.add(aVar);
    }

    public void a(b bVar) {
        a((a) bVar);
    }

    public void b(a aVar) {
        if (this.g == null || aVar == null) {
            return;
        }
        this.g.remove(aVar);
    }

    public void b(b bVar) {
        b((a) bVar);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        g();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        g();
        this.d = false;
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            if (((LayoutParams) getChildAt(i5).getLayoutParams()).b() != null) {
                this.d = true;
                break;
            }
            i5++;
        }
        if (this.h) {
            return;
        }
        b(this.k || f());
    }

    private boolean f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void g() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setExpanded(boolean z) {
        a(z, w.C(this));
    }

    public void a(boolean z, boolean z2) {
        a(z, z2, true);
    }

    private void a(boolean z, boolean z2, boolean z3) {
        this.e = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    boolean b() {
        return this.d;
    }

    public final int getTotalScrollRange() {
        if (this.a != -1) {
            return this.a;
        }
        int childCount = getChildCount();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.a;
            if ((i3 & 1) == 0) {
                break;
            }
            i2 += measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin;
            if ((i3 & 2) != 0) {
                i2 -= w.n(childAt);
                break;
            }
            i++;
        }
        int max = Math.max(0, i2 - getTopInset());
        this.a = max;
        return max;
    }

    boolean c() {
        return getTotalScrollRange() != 0;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    int getDownNestedPreScrollRange() {
        if (this.b != -1) {
            return this.b;
        }
        int i = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i2 = layoutParams.a;
            if ((i2 & 5) != 5) {
                if (i > 0) {
                    break;
                }
            } else {
                int i3 = i + layoutParams.topMargin + layoutParams.bottomMargin;
                if ((i2 & 8) != 0) {
                    i = i3 + w.n(childAt);
                } else if ((i2 & 2) != 0) {
                    i = i3 + (measuredHeight - w.n(childAt));
                } else {
                    i = i3 + (measuredHeight - getTopInset());
                }
            }
        }
        int max = Math.max(0, i);
        this.b = max;
        return max;
    }

    int getDownNestedScrollRange() {
        if (this.c != -1) {
            return this.c;
        }
        int childCount = getChildCount();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int i3 = layoutParams.a;
            if ((i3 & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i3 & 2) != 0) {
                i2 -= w.n(childAt) + getTopInset();
                break;
            }
            i++;
        }
        int max = Math.max(0, i2);
        this.c = max;
        return max;
    }

    void a(int i) {
        if (this.g != null) {
            int size = this.g.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.g.get(i2);
                if (aVar != null) {
                    aVar.a(this, i);
                }
            }
        }
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int n = w.n(this);
        if (n != 0) {
            return (n * 2) + topInset;
        }
        int childCount = getChildCount();
        int n2 = childCount >= 1 ? w.n(getChildAt(childCount - 1)) : 0;
        return n2 != 0 ? (n2 * 2) + topInset : getHeight() / 3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        if (this.l == null) {
            this.l = new int[4];
        }
        int[] iArr = this.l;
        int[] onCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.i ? a.b.state_liftable : -a.b.state_liftable;
        iArr[1] = (this.i && this.j) ? a.b.state_lifted : -a.b.state_lifted;
        iArr[2] = this.i ? a.b.state_collapsible : -a.b.state_collapsible;
        iArr[3] = (this.i && this.j) ? a.b.state_collapsed : -a.b.state_collapsed;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    private boolean b(boolean z) {
        if (this.i == z) {
            return false;
        }
        this.i = z;
        refreshDrawableState();
        return true;
    }

    boolean a(boolean z) {
        if (this.j == z) {
            return false;
        }
        this.j = z;
        refreshDrawableState();
        return true;
    }

    public void setLiftOnScroll(boolean z) {
        this.k = z;
    }

    public boolean d() {
        return this.k;
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            com.google.android.material.appbar.b.a(this, f);
        }
    }

    int getPendingAction() {
        return this.e;
    }

    void e() {
        this.e = 0;
    }

    final int getTopInset() {
        if (this.f != null) {
            return this.f.b();
        }
        return 0;
    }

    ae a(ae aeVar) {
        ae aeVar2 = w.u(this) ? aeVar : null;
        if (!c.a(this.f, aeVar2)) {
            this.f = aeVar2;
            g();
        }
        return aeVar;
    }

    /* compiled from: source */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        int a;
        Interpolator b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.AppBarLayout_Layout);
            this.a = obtainStyledAttributes.getInt(a.k.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(a.k.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(a.k.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }

        public int a() {
            return this.a;
        }

        public Interpolator b() {
            return this.b;
        }

        boolean c() {
            return (this.a & 1) == 1 && (this.a & 10) != 0;
        }
    }

    /* compiled from: source */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
            super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr, i3);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean a(int i) {
            return super.a(i);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            return super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, i);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, i, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            return super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i, i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: b */
        public /* bridge */ /* synthetic */ Parcelable d(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.d(coordinatorLayout, (CoordinatorLayout) appBarLayout);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int c() {
            return super.c();
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* compiled from: source */
    protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private int b;
        private int c;
        private ValueAnimator d;
        private int e;
        private boolean f;
        private float g;
        private WeakReference<View> h;
        private a i;

        /* compiled from: source */
        public static abstract class a<T extends AppBarLayout> {
            public abstract boolean a(T t);
        }

        private static boolean a(int i, int i2) {
            return (i & i2) == i2;
        }

        public BaseBehavior() {
            this.e = -1;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.e = -1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i, int i2) {
            boolean z = (i & 2) != 0 && (t.d() || a(coordinatorLayout, (CoordinatorLayout) t, view));
            if (z && this.d != null) {
                this.d.cancel();
            }
            this.h = null;
            this.c = i2;
            return z;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.c() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int i5;
            if (i2 != 0) {
                if (i2 < 0) {
                    i4 = -t.getTotalScrollRange();
                    i5 = t.getDownNestedPreScrollRange() + i4;
                } else {
                    i4 = -t.getUpNestedPreScrollRange();
                    i5 = 0;
                }
                int i6 = i4;
                int i7 = i5;
                if (i6 != i7) {
                    iArr[1] = b(coordinatorLayout, (CoordinatorLayout) t, i2, i6, i7);
                    a(i2, (int) t, view, i3);
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int i3, int i4, int i5) {
            if (i4 < 0) {
                b(coordinatorLayout, (CoordinatorLayout) t, i4, -t.getDownNestedScrollRange(), 0);
                a(i4, (int) t, view, i5);
            }
            if (t.d()) {
                t.a(view.getScrollY() > 0);
            }
        }

        private void a(int i, T t, View view, int i2) {
            if (i2 == 1) {
                int b = b();
                if ((i >= 0 || b != 0) && (i <= 0 || b != (-t.getDownNestedScrollRange()))) {
                    return;
                }
                w.e(view, 1);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i) {
            if (this.c == 0 || i == 1) {
                c(coordinatorLayout, (CoordinatorLayout) t);
            }
            this.h = new WeakReference<>(view);
        }

        private void a(CoordinatorLayout coordinatorLayout, T t, int i, float f) {
            int height;
            int abs = Math.abs(b() - i);
            float abs2 = Math.abs(f);
            if (abs2 > 0.0f) {
                height = 3 * Math.round(1000.0f * (abs / abs2));
            } else {
                height = (int) (((abs / t.getHeight()) + 1.0f) * 150.0f);
            }
            a(coordinatorLayout, (CoordinatorLayout) t, i, height);
        }

        private void a(CoordinatorLayout coordinatorLayout, T t, int i, int i2) {
            int b = b();
            if (b == i) {
                if (this.d == null || !this.d.isRunning()) {
                    return;
                }
                this.d.cancel();
                return;
            }
            if (this.d == null) {
                this.d = new ValueAnimator();
                this.d.setInterpolator(com.google.android.material.a.a.e);
                this.d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.1
                    final /* synthetic */ CoordinatorLayout a;
                    final /* synthetic */ AppBarLayout b;

                    AnonymousClass1(CoordinatorLayout coordinatorLayout2, AppBarLayout t2) {
                        coordinatorLayout = coordinatorLayout2;
                        t = t2;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        BaseBehavior.this.a_(coordinatorLayout, t, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                this.d.cancel();
            }
            this.d.setDuration(Math.min(i2, 600));
            this.d.setIntValues(b, i);
            this.d.start();
        }

        /* compiled from: source */
        /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$1 */
        class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ CoordinatorLayout a;
            final /* synthetic */ AppBarLayout b;

            AnonymousClass1(CoordinatorLayout coordinatorLayout2, AppBarLayout t2) {
                coordinatorLayout = coordinatorLayout2;
                t = t2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.a_(coordinatorLayout, t, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        private int a(T t, int i) {
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (a(layoutParams.a(), 32)) {
                    top -= layoutParams.topMargin;
                    bottom += layoutParams.bottomMargin;
                }
                int i3 = -i;
                if (top <= i3 && bottom >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        private void c(CoordinatorLayout coordinatorLayout, T t) {
            int b = b();
            int a2 = a((BaseBehavior<T>) t, b);
            if (a2 >= 0) {
                View childAt = t.getChildAt(a2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int a3 = layoutParams.a();
                if ((a3 & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (a2 == t.getChildCount() - 1) {
                        i2 += t.getTopInset();
                    }
                    if (a(a3, 2)) {
                        i2 += w.n(childAt);
                    } else if (a(a3, 5)) {
                        int n = w.n(childAt) + i2;
                        if (b < n) {
                            i = n;
                        } else {
                            i2 = n;
                        }
                    }
                    if (a(a3, 32)) {
                        i += layoutParams.topMargin;
                        i2 -= layoutParams.bottomMargin;
                    }
                    if (b < (i2 + i) / 2) {
                        i = i2;
                    }
                    a(coordinatorLayout, (CoordinatorLayout) t, androidx.core.b.a.a(i, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3, int i4) {
            if (((CoordinatorLayout.d) t.getLayoutParams()).height == -2) {
                coordinatorLayout.a(t, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
                return true;
            }
            return super.a(coordinatorLayout, (CoordinatorLayout) t, i, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i) {
            int round;
            boolean a2 = super.a(coordinatorLayout, (CoordinatorLayout) t, i);
            int pendingAction = t.getPendingAction();
            if (this.e >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(this.e);
                int i2 = -childAt.getBottom();
                if (this.f) {
                    round = i2 + w.n(childAt) + t.getTopInset();
                } else {
                    round = i2 + Math.round(childAt.getHeight() * this.g);
                }
                a_(coordinatorLayout, t, round);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i3 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        a(coordinatorLayout, (CoordinatorLayout) t, i3, 0.0f);
                    } else {
                        a_(coordinatorLayout, t, i3);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        a(coordinatorLayout, (CoordinatorLayout) t, 0, 0.0f);
                    } else {
                        a_(coordinatorLayout, t, 0);
                    }
                }
            }
            t.e();
            this.e = -1;
            a(androidx.core.b.a.a(c(), -t.getTotalScrollRange(), 0));
            a(coordinatorLayout, (CoordinatorLayout) t, c(), 0, true);
            t.a(c());
            return a2;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: a */
        public boolean c(T t) {
            if (this.i != null) {
                return this.i.a(t);
            }
            if (this.h == null) {
                return true;
            }
            View view = this.h.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: a */
        public void e(CoordinatorLayout coordinatorLayout, T t) {
            c(coordinatorLayout, (CoordinatorLayout) t);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public int b(T t) {
            return -t.getDownNestedScrollRange();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: c */
        public int a(T t) {
            return t.getTotalScrollRange();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public int a(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3) {
            int b = b();
            int i4 = 0;
            if (i2 != 0 && b >= i2 && b <= i3) {
                int a2 = androidx.core.b.a.a(i, i2, i3);
                if (b != a2) {
                    int b2 = t.b() ? b((BaseBehavior<T>) t, a2) : a2;
                    boolean a3 = a(b2);
                    i4 = b - a2;
                    this.b = a2 - b2;
                    if (!a3 && t.b()) {
                        coordinatorLayout.b(t);
                    }
                    t.a(c());
                    a(coordinatorLayout, (CoordinatorLayout) t, a2, a2 < b ? -1 : 1, false);
                }
            } else {
                this.b = 0;
            }
            return i4;
        }

        private int b(T t, int i) {
            int abs = Math.abs(i);
            int childCount = t.getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator b = layoutParams.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i3++;
                } else if (b != null) {
                    int a2 = layoutParams.a();
                    if ((a2 & 1) != 0) {
                        i2 = 0 + childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                        if ((a2 & 2) != 0) {
                            i2 -= w.n(childAt);
                        }
                    }
                    if (w.u(childAt)) {
                        i2 -= t.getTopInset();
                    }
                    if (i2 > 0) {
                        float f = i2;
                        return Integer.signum(i) * (childAt.getTop() + Math.round(f * b.getInterpolation((abs - childAt.getTop()) / f)));
                    }
                }
            }
            return i;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void a(androidx.coordinatorlayout.widget.CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
            /*
                r5 = this;
                android.view.View r0 = c(r7, r8)
                if (r0 == 0) goto L6e
                android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$LayoutParams r1 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r1
                int r1 = r1.a()
                r2 = r1 & 1
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L41
                int r2 = androidx.core.h.w.n(r0)
                if (r9 <= 0) goto L2f
                r9 = r1 & 12
                if (r9 == 0) goto L2f
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L41
            L2d:
                r8 = r3
                goto L42
            L2f:
                r9 = r1 & 2
                if (r9 == 0) goto L41
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L41
                goto L2d
            L41:
                r8 = r4
            L42:
                boolean r9 = r7.d()
                if (r9 == 0) goto L57
                android.view.View r9 = r5.a(r6)
                if (r9 == 0) goto L57
                int r8 = r9.getScrollY()
                if (r8 <= 0) goto L56
                r8 = r3
                goto L57
            L56:
                r8 = r4
            L57:
                boolean r8 = r7.a(r8)
                int r9 = android.os.Build.VERSION.SDK_INT
                r0 = 11
                if (r9 < r0) goto L6e
                if (r10 != 0) goto L6b
                if (r8 == 0) goto L6e
                boolean r6 = r5.d(r6, r7)
                if (r6 == 0) goto L6e
            L6b:
                r7.jumpDrawablesToCurrentState()
            L6e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.a(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        private boolean d(CoordinatorLayout coordinatorLayout, T t) {
            List<View> d = coordinatorLayout.d(t);
            int size = d.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.Behavior b = ((CoordinatorLayout.d) d.get(i).getLayoutParams()).b();
                if (b instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) b).d() != 0;
                }
            }
            return false;
        }

        private static View c(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private View a(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt instanceof j) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int b() {
            return c() + this.b;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: b */
        public Parcelable d(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable d = super.d(coordinatorLayout, (CoordinatorLayout) t);
            int c = c();
            int childCount = t.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = t.getChildAt(i);
                int bottom = childAt.getBottom() + c;
                if (childAt.getTop() + c <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(d);
                    savedState.a = i;
                    savedState.d = bottom == w.n(childAt) + t.getTopInset();
                    savedState.b = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return d;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void a(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.a(coordinatorLayout, (CoordinatorLayout) t, savedState.a());
                this.e = savedState.a;
                this.g = savedState.b;
                this.f = savedState.d;
                return;
            }
            super.a(coordinatorLayout, (CoordinatorLayout) t, parcelable);
            this.e = -1;
        }

        /* compiled from: source */
        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState.1
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
            float b;
            boolean d;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.a = parcel.readInt();
                this.b = parcel.readFloat();
                this.d = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.a);
                parcel.writeFloat(this.b);
                parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
            }

            /* compiled from: source */
            /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$SavedState$1 */
            static class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
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
    }

    /* compiled from: source */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean a(int i) {
            return super.a(i);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.a(coordinatorLayout, (CoordinatorLayout) view, i);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, view, i, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        /* synthetic */ View b(List list) {
            return a((List<View>) list);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int c() {
            return super.c();
        }

        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.ScrollingViewBehavior_Layout);
            b(obtainStyledAttributes.getDimensionPixelSize(a.k.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            a(view, view2);
            b(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout a = a(coordinatorLayout.c(view));
            if (a != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.a;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    a.a(false, !z);
                    return true;
                }
            }
            return false;
        }

        private void a(View view, View view2) {
            CoordinatorLayout.Behavior b = ((CoordinatorLayout.d) view2.getLayoutParams()).b();
            if (b instanceof BaseBehavior) {
                w.f(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) b).b) + b()) - c(view2));
            }
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float a(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int a = a(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + a > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return 1.0f + (a / i);
                }
            }
            return 0.0f;
        }

        private static int a(AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior b = ((CoordinatorLayout.d) appBarLayout.getLayoutParams()).b();
            if (b instanceof BaseBehavior) {
                return ((BaseBehavior) b).b();
            }
            return 0;
        }

        AppBarLayout a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        int b(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.b(view);
        }

        private void b(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.d()) {
                    appBarLayout.a(view.getScrollY() > 0);
                }
            }
        }
    }
}
