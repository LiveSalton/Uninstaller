package com.google.android.material.tabs;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.ah;
import androidx.core.g.d;
import androidx.core.h.t;
import androidx.core.h.w;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.a;
import com.google.android.material.internal.k;
import com.google.android.material.internal.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: source */
@ViewPager.a
/* loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {
    private static final d.a<f> w = new d.c(16);
    private final e A;
    private final int B;
    private final int C;
    private final int D;
    private int E;
    private b F;
    private final ArrayList<b> G;
    private b H;
    private ValueAnimator I;
    private androidx.viewpager.widget.a J;
    private DataSetObserver K;
    private g L;
    private a M;
    private boolean N;
    private final d.a<h> O;
    int a;
    int b;
    int c;
    int d;
    int e;
    ColorStateList f;
    ColorStateList g;
    ColorStateList h;
    Drawable i;
    PorterDuff.Mode j;
    float k;
    float l;
    final int m;
    int n;
    int o;
    int p;
    int q;
    int r;
    boolean s;
    boolean t;
    boolean u;
    ViewPager v;
    private final ArrayList<f> x;
    private f y;
    private final RectF z;

    /* compiled from: source */
    public interface b<T extends f> {
        void a(T t);

        void b(T t);

        void c(T t);
    }

    public interface c extends b {
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.tabStyle);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x = new ArrayList<>();
        this.z = new RectF();
        this.n = Integer.MAX_VALUE;
        this.G = new ArrayList<>();
        this.O = new d.b(12);
        setHorizontalScrollBarEnabled(false);
        this.A = new e(context);
        super.addView(this.A, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray a2 = k.a(context, attributeSet, a.k.TabLayout, i2, a.j.Widget_Design_TabLayout, a.k.TabLayout_tabTextAppearance);
        this.A.b(a2.getDimensionPixelSize(a.k.TabLayout_tabIndicatorHeight, -1));
        this.A.a(a2.getColor(a.k.TabLayout_tabIndicatorColor, 0));
        setSelectedTabIndicator(com.google.android.material.f.a.b(context, a2, a.k.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(a2.getInt(a.k.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(a2.getBoolean(a.k.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = a2.getDimensionPixelSize(a.k.TabLayout_tabPadding, 0);
        this.d = dimensionPixelSize;
        this.c = dimensionPixelSize;
        this.b = dimensionPixelSize;
        this.a = dimensionPixelSize;
        this.a = a2.getDimensionPixelSize(a.k.TabLayout_tabPaddingStart, this.a);
        this.b = a2.getDimensionPixelSize(a.k.TabLayout_tabPaddingTop, this.b);
        this.c = a2.getDimensionPixelSize(a.k.TabLayout_tabPaddingEnd, this.c);
        this.d = a2.getDimensionPixelSize(a.k.TabLayout_tabPaddingBottom, this.d);
        this.e = a2.getResourceId(a.k.TabLayout_tabTextAppearance, a.j.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.e, a.j.TextAppearance);
        try {
            this.k = obtainStyledAttributes.getDimensionPixelSize(a.j.TextAppearance_android_textSize, 0);
            this.f = com.google.android.material.f.a.a(context, obtainStyledAttributes, a.j.TextAppearance_android_textColor);
            obtainStyledAttributes.recycle();
            if (a2.hasValue(a.k.TabLayout_tabTextColor)) {
                this.f = com.google.android.material.f.a.a(context, a2, a.k.TabLayout_tabTextColor);
            }
            if (a2.hasValue(a.k.TabLayout_tabSelectedTextColor)) {
                this.f = a(this.f.getDefaultColor(), a2.getColor(a.k.TabLayout_tabSelectedTextColor, 0));
            }
            this.g = com.google.android.material.f.a.a(context, a2, a.k.TabLayout_tabIconTint);
            this.j = l.a(a2.getInt(a.k.TabLayout_tabIconTintMode, -1), null);
            this.h = com.google.android.material.f.a.a(context, a2, a.k.TabLayout_tabRippleColor);
            this.p = a2.getInt(a.k.TabLayout_tabIndicatorAnimationDuration, 300);
            this.B = a2.getDimensionPixelSize(a.k.TabLayout_tabMinWidth, -1);
            this.C = a2.getDimensionPixelSize(a.k.TabLayout_tabMaxWidth, -1);
            this.m = a2.getResourceId(a.k.TabLayout_tabBackground, 0);
            this.E = a2.getDimensionPixelSize(a.k.TabLayout_tabContentStart, 0);
            this.r = a2.getInt(a.k.TabLayout_tabMode, 1);
            this.o = a2.getInt(a.k.TabLayout_tabGravity, 0);
            this.s = a2.getBoolean(a.k.TabLayout_tabInlineLabel, false);
            this.u = a2.getBoolean(a.k.TabLayout_tabUnboundedRipple, false);
            a2.recycle();
            Resources resources = getResources();
            this.l = resources.getDimensionPixelSize(a.d.design_tab_text_size_2line);
            this.D = resources.getDimensionPixelSize(a.d.design_tab_scrollable_min_width);
            h();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.A.a(i2);
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.A.b(i2);
    }

    public void a(int i2, float f2, boolean z) {
        a(i2, f2, z, true);
    }

    void a(int i2, float f2, boolean z, boolean z2) {
        int round = Math.round(i2 + f2);
        if (round < 0 || round >= this.A.getChildCount()) {
            return;
        }
        if (z2) {
            this.A.a(i2, f2);
        }
        if (this.I != null && this.I.isRunning()) {
            this.I.cancel();
        }
        scrollTo(a(i2, f2), 0);
        if (z) {
            setSelectedTabView(round);
        }
    }

    public void a(f fVar) {
        a(fVar, this.x.isEmpty());
    }

    public void a(f fVar, boolean z) {
        a(fVar, this.x.size(), z);
    }

    public void a(f fVar, int i2, boolean z) {
        if (fVar.a != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        a(fVar, i2);
        e(fVar);
        if (z) {
            fVar.e();
        }
    }

    private void a(TabItem tabItem) {
        f a2 = a();
        if (tabItem.a != null) {
            a2.a(tabItem.a);
        }
        if (tabItem.b != null) {
            a2.a(tabItem.b);
        }
        if (tabItem.c != 0) {
            a2.a(tabItem.c);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            a2.b(tabItem.getContentDescription());
        }
        a(a2);
    }

    @Deprecated
    public void setOnTabSelectedListener(b bVar) {
        if (this.F != null) {
            b(this.F);
        }
        this.F = bVar;
        if (bVar != null) {
            a(bVar);
        }
    }

    public void a(b bVar) {
        if (this.G.contains(bVar)) {
            return;
        }
        this.G.add(bVar);
    }

    public void b(b bVar) {
        this.G.remove(bVar);
    }

    public f a() {
        f b2 = b();
        b2.a = this;
        b2.b = d(b2);
        return b2;
    }

    protected f b() {
        f a2 = w.a();
        return a2 == null ? new f() : a2;
    }

    protected boolean b(f fVar) {
        return w.a(fVar);
    }

    public int getTabCount() {
        return this.x.size();
    }

    public f a(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.x.get(i2);
    }

    public int getSelectedTabPosition() {
        if (this.y != null) {
            return this.y.c();
        }
        return -1;
    }

    public void c() {
        for (int childCount = this.A.getChildCount() - 1; childCount >= 0; childCount--) {
            c(childCount);
        }
        Iterator<f> it = this.x.iterator();
        while (it.hasNext()) {
            f next = it.next();
            it.remove();
            next.h();
            b(next);
        }
        this.y = null;
    }

    public void setTabMode(int i2) {
        if (i2 != this.r) {
            this.r = i2;
            h();
        }
    }

    public int getTabMode() {
        return this.r;
    }

    public void setTabGravity(int i2) {
        if (this.o != i2) {
            this.o = i2;
            h();
        }
    }

    public int getTabGravity() {
        return this.o;
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.q != i2) {
            this.q = i2;
            w.f(this.A);
        }
    }

    public int getTabIndicatorGravity() {
        return this.q;
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.t = z;
        w.f(this.A);
    }

    public void setInlineLabel(boolean z) {
        if (this.s != z) {
            this.s = z;
            for (int i2 = 0; i2 < this.A.getChildCount(); i2++) {
                View childAt = this.A.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).c();
                }
            }
            h();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    public void setUnboundedRipple(boolean z) {
        if (this.u != z) {
            this.u = z;
            for (int i2 = 0; i2 < this.A.getChildCount(); i2++) {
                View childAt = this.A.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).a(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f != colorStateList) {
            this.f = colorStateList;
            e();
        }
    }

    public ColorStateList getTabTextColors() {
        return this.f;
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            e();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    public ColorStateList getTabIconTint() {
        return this.g;
    }

    public ColorStateList getTabRippleColor() {
        return this.h;
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.h != colorStateList) {
            this.h = colorStateList;
            for (int i2 = 0; i2 < this.A.getChildCount(); i2++) {
                View childAt = this.A.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).a(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    public Drawable getTabSelectedIndicator() {
        return this.i;
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.i != drawable) {
            this.i = drawable;
            w.f(this.A);
        }
    }

    public void setSelectedTabIndicator(int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(androidx.appcompat.a.a.a.b(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public void setupWithViewPager(ViewPager viewPager) {
        a(viewPager, true);
    }

    public void a(ViewPager viewPager, boolean z) {
        a(viewPager, z, false);
    }

    private void a(ViewPager viewPager, boolean z, boolean z2) {
        if (this.v != null) {
            if (this.L != null) {
                this.v.b(this.L);
            }
            if (this.M != null) {
                this.v.b(this.M);
            }
        }
        if (this.H != null) {
            b(this.H);
            this.H = null;
        }
        if (viewPager != null) {
            this.v = viewPager;
            if (this.L == null) {
                this.L = new g(this);
            }
            this.L.a();
            viewPager.a(this.L);
            this.H = new i(viewPager);
            a(this.H);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, z);
            }
            if (this.M == null) {
                this.M = new a();
            }
            this.M.a(z);
            viewPager.a(this.M);
            a(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.v = null;
            a((androidx.viewpager.widget.a) null, false);
        }
        this.N = z2;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) {
        a(aVar, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.v == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                a((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.N) {
            setupWithViewPager(null);
            this.N = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.A.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    void a(androidx.viewpager.widget.a aVar, boolean z) {
        if (this.J != null && this.K != null) {
            this.J.b(this.K);
        }
        this.J = aVar;
        if (z && aVar != null) {
            if (this.K == null) {
                this.K = new d();
            }
            aVar.a(this.K);
        }
        d();
    }

    void d() {
        int currentItem;
        c();
        if (this.J != null) {
            int a2 = this.J.a();
            for (int i2 = 0; i2 < a2; i2++) {
                a(a().a(this.J.a(i2)), false);
            }
            if (this.v == null || a2 <= 0 || (currentItem = this.v.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            c(a(currentItem));
        }
    }

    private void e() {
        int size = this.x.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.x.get(i2).g();
        }
    }

    private h d(f fVar) {
        h a2 = this.O != null ? this.O.a() : null;
        if (a2 == null) {
            a2 = new h(getContext());
        }
        a2.a(fVar);
        a2.setFocusable(true);
        a2.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(fVar.f)) {
            a2.setContentDescription(fVar.e);
        } else {
            a2.setContentDescription(fVar.f);
        }
        return a2;
    }

    private void a(f fVar, int i2) {
        fVar.b(i2);
        this.x.add(i2, fVar);
        int size = this.x.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            } else {
                this.x.get(i2).b(i2);
            }
        }
    }

    private void e(f fVar) {
        this.A.addView(fVar.b, fVar.c(), f());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    private void a(View view) {
        if (view instanceof TabItem) {
            a((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private LinearLayout.LayoutParams f() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.r == 1 && this.o == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    int b(int i2) {
        return Math.round(getResources().getDisplayMetrics().density * i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.A.getChildCount(); i2++) {
            View childAt = this.A.getChildAt(i2);
            if (childAt instanceof h) {
                ((h) childAt).a(canvas);
            }
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0067, code lost:
    
        if (r1.getMeasuredWidth() != getMeasuredWidth()) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0069, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0073, code lost:
    
        if (r1.getMeasuredWidth() < getMeasuredWidth()) goto L53;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.getDefaultHeight()
            int r0 = r5.b(r0)
            int r1 = r5.getPaddingTop()
            int r0 = r0 + r1
            int r1 = r5.getPaddingBottom()
            int r0 = r0 + r1
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r1 == r2) goto L24
            if (r1 == 0) goto L1f
            goto L30
        L1f:
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L30
        L24:
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            int r7 = java.lang.Math.min(r0, r7)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3)
        L30:
            int r0 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r6)
            if (r1 == 0) goto L4a
            int r1 = r5.C
            if (r1 <= 0) goto L41
            int r0 = r5.C
            goto L48
        L41:
            r1 = 56
            int r1 = r5.b(r1)
            int r0 = r0 - r1
        L48:
            r5.n = r0
        L4a:
            super.onMeasure(r6, r7)
            int r6 = r5.getChildCount()
            r0 = 1
            if (r6 != r0) goto L96
            r6 = 0
            android.view.View r1 = r5.getChildAt(r6)
            int r2 = r5.r
            switch(r2) {
                case 0: goto L6b;
                case 1: goto L5f;
                default: goto L5e;
            }
        L5e:
            goto L76
        L5f:
            int r2 = r1.getMeasuredWidth()
            int r4 = r5.getMeasuredWidth()
            if (r2 == r4) goto L76
        L69:
            r6 = r0
            goto L76
        L6b:
            int r2 = r1.getMeasuredWidth()
            int r4 = r5.getMeasuredWidth()
            if (r2 >= r4) goto L76
            goto L69
        L76:
            if (r6 == 0) goto L96
            int r6 = r5.getPaddingTop()
            int r0 = r5.getPaddingBottom()
            int r6 = r6 + r0
            android.view.ViewGroup$LayoutParams r0 = r1.getLayoutParams()
            int r0 = r0.height
            int r6 = getChildMeasureSpec(r7, r6, r0)
            int r7 = r5.getMeasuredWidth()
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3)
            r1.measure(r7, r6)
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    private void c(int i2) {
        h hVar = (h) this.A.getChildAt(i2);
        this.A.removeViewAt(i2);
        if (hVar != null) {
            hVar.a();
            this.O.a(hVar);
        }
        requestLayout();
    }

    private void d(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() == null || !w.C(this) || this.A.a()) {
            a(i2, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int a2 = a(i2, 0.0f);
        if (scrollX != a2) {
            g();
            this.I.setIntValues(scrollX, a2);
            this.I.start();
        }
        this.A.b(i2, this.p);
    }

    private void g() {
        if (this.I == null) {
            this.I = new ValueAnimator();
            this.I.setInterpolator(com.google.android.material.a.a.b);
            this.I.setDuration(this.p);
            this.I.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.1
                AnonymousClass1() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.tabs.TabLayout$1 */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        g();
        this.I.addListener(animatorListener);
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.A.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.A.getChildAt(i3);
                boolean z = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z = false;
                }
                childAt.setActivated(z);
                i3++;
            }
        }
    }

    void c(f fVar) {
        b(fVar, true);
    }

    void b(f fVar, boolean z) {
        f fVar2 = this.y;
        if (fVar2 == fVar) {
            if (fVar2 != null) {
                h(fVar);
                d(fVar.c());
                return;
            }
            return;
        }
        int c2 = fVar != null ? fVar.c() : -1;
        if (z) {
            if ((fVar2 == null || fVar2.c() == -1) && c2 != -1) {
                a(c2, 0.0f, true);
            } else {
                d(c2);
            }
            if (c2 != -1) {
                setSelectedTabView(c2);
            }
        }
        this.y = fVar;
        if (fVar2 != null) {
            g(fVar2);
        }
        if (fVar != null) {
            f(fVar);
        }
    }

    private void f(f fVar) {
        for (int size = this.G.size() - 1; size >= 0; size--) {
            this.G.get(size).a(fVar);
        }
    }

    private void g(f fVar) {
        for (int size = this.G.size() - 1; size >= 0; size--) {
            this.G.get(size).b(fVar);
        }
    }

    private void h(f fVar) {
        for (int size = this.G.size() - 1; size >= 0; size--) {
            this.G.get(size).c(fVar);
        }
    }

    private int a(int i2, float f2) {
        if (this.r != 0) {
            return 0;
        }
        View childAt = this.A.getChildAt(i2);
        int i3 = i2 + 1;
        View childAt2 = i3 < this.A.getChildCount() ? this.A.getChildAt(i3) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i4 = (int) ((width + width2) * 0.5f * f2);
        return w.h(this) == 0 ? left + i4 : left - i4;
    }

    private void h() {
        w.b(this.A, this.r == 0 ? Math.max(0, this.E - this.a) : 0, 0, 0, 0);
        switch (this.r) {
            case 0:
                this.A.setGravity(8388611);
                break;
            case 1:
                this.A.setGravity(1);
                break;
        }
        a(true);
    }

    void a(boolean z) {
        for (int i2 = 0; i2 < this.A.getChildCount(); i2++) {
            View childAt = this.A.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    /* compiled from: source */
    public static class f {
        public TabLayout a;
        public h b;
        private Object c;
        private Drawable d;
        private CharSequence e;
        private CharSequence f;
        private int g = -1;
        private View h;

        public View a() {
            return this.h;
        }

        public f a(View view) {
            this.h = view;
            g();
            return this;
        }

        public f a(int i) {
            return a(LayoutInflater.from(this.b.getContext()).inflate(i, (ViewGroup) this.b, false));
        }

        public Drawable b() {
            return this.d;
        }

        public int c() {
            return this.g;
        }

        void b(int i) {
            this.g = i;
        }

        public CharSequence d() {
            return this.e;
        }

        public f a(Drawable drawable) {
            this.d = drawable;
            g();
            return this;
        }

        public f a(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(charSequence)) {
                this.b.setContentDescription(charSequence);
            }
            this.e = charSequence;
            g();
            return this;
        }

        public void e() {
            if (this.a == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.a.c(this);
        }

        public boolean f() {
            if (this.a == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return this.a.getSelectedTabPosition() == this.g;
        }

        public f b(CharSequence charSequence) {
            this.f = charSequence;
            g();
            return this;
        }

        void g() {
            if (this.b != null) {
                this.b.b();
            }
        }

        void h() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = -1;
            this.h = null;
        }
    }

    /* compiled from: source */
    class h extends LinearLayout {
        private f b;
        private TextView c;
        private ImageView d;
        private View e;
        private TextView f;
        private ImageView g;
        private Drawable h;
        private int i;

        public h(Context context) {
            super(context);
            this.i = 2;
            a(context);
            w.b(this, TabLayout.this.a, TabLayout.this.b, TabLayout.this.c, TabLayout.this.d);
            setGravity(17);
            setOrientation(!TabLayout.this.s ? 1 : 0);
            setClickable(true);
            w.a(this, t.a(getContext(), 1002));
        }

        public void a(Context context) {
            if (TabLayout.this.m != 0) {
                this.h = androidx.appcompat.a.a.a.b(context, TabLayout.this.m);
                if (this.h != null && this.h.isStateful()) {
                    this.h.setState(getDrawableState());
                }
            } else {
                this.h = null;
            }
            Drawable gradientDrawable = new GradientDrawable();
            ((GradientDrawable) gradientDrawable).setColor(0);
            if (TabLayout.this.h != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList a = com.google.android.material.g.a.a(TabLayout.this.h);
                if (Build.VERSION.SDK_INT >= 21) {
                    if (TabLayout.this.u) {
                        gradientDrawable = null;
                    }
                    if (TabLayout.this.u) {
                        gradientDrawable2 = null;
                    }
                    gradientDrawable = new RippleDrawable(a, gradientDrawable, gradientDrawable2);
                } else {
                    Drawable g = androidx.core.graphics.drawable.a.g(gradientDrawable2);
                    androidx.core.graphics.drawable.a.a(g, a);
                    gradientDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, g});
                }
            }
            w.a(this, gradientDrawable);
            TabLayout.this.invalidate();
        }

        public void a(Canvas canvas) {
            if (this.h != null) {
                this.h.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.h.draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            boolean z = false;
            if (this.h != null && this.h.isStateful()) {
                z = false | this.h.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.b == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.b.e();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            if (this.c != null) {
                this.c.setSelected(z);
            }
            if (this.d != null) {
                this.d.setSelected(z);
            }
            if (this.e != null) {
                this.e.setSelected(z);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.b.class.getName());
        }

        @Override // android.view.View
        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.b.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.n, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.c != null) {
                float f = TabLayout.this.k;
                int i3 = this.i;
                boolean z = true;
                if (this.d != null && this.d.getVisibility() == 0) {
                    i3 = 1;
                } else if (this.c != null && this.c.getLineCount() > 1) {
                    f = TabLayout.this.l;
                }
                float textSize = this.c.getTextSize();
                int lineCount = this.c.getLineCount();
                int a = androidx.core.widget.i.a(this.c);
                if (f != textSize || (a >= 0 && i3 != a)) {
                    if (TabLayout.this.r == 1 && f > textSize && lineCount == 1 && ((layout = this.c.getLayout()) == null || a(layout, 0, f) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.c.setTextSize(0, f);
                        this.c.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        void a(f fVar) {
            if (fVar != this.b) {
                this.b = fVar;
                b();
            }
        }

        void a() {
            a((f) null);
            setSelected(false);
        }

        final void b() {
            f fVar = this.b;
            Drawable drawable = null;
            View a = fVar != null ? fVar.a() : null;
            if (a != null) {
                ViewParent parent = a.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(a);
                    }
                    addView(a);
                }
                this.e = a;
                if (this.c != null) {
                    this.c.setVisibility(8);
                }
                if (this.d != null) {
                    this.d.setVisibility(8);
                    this.d.setImageDrawable(null);
                }
                this.f = (TextView) a.findViewById(R.id.text1);
                if (this.f != null) {
                    this.i = androidx.core.widget.i.a(this.f);
                }
                this.g = (ImageView) a.findViewById(R.id.icon);
            } else {
                if (this.e != null) {
                    removeView(this.e);
                    this.e = null;
                }
                this.f = null;
                this.g = null;
            }
            boolean z = false;
            if (this.e == null) {
                if (this.d == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(a.h.design_layout_tab_icon, (ViewGroup) this, false);
                    addView(imageView, 0);
                    this.d = imageView;
                }
                if (fVar != null && fVar.b() != null) {
                    drawable = androidx.core.graphics.drawable.a.g(fVar.b()).mutate();
                }
                if (drawable != null) {
                    androidx.core.graphics.drawable.a.a(drawable, TabLayout.this.g);
                    if (TabLayout.this.j != null) {
                        androidx.core.graphics.drawable.a.a(drawable, TabLayout.this.j);
                    }
                }
                if (this.c == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(a.h.design_layout_tab_text, (ViewGroup) this, false);
                    addView(textView);
                    this.c = textView;
                    this.i = androidx.core.widget.i.a(this.c);
                }
                androidx.core.widget.i.a(this.c, TabLayout.this.e);
                if (TabLayout.this.f != null) {
                    this.c.setTextColor(TabLayout.this.f);
                }
                a(this.c, this.d);
            } else if (this.f != null || this.g != null) {
                a(this.f, this.g);
            }
            if (fVar != null && !TextUtils.isEmpty(fVar.f)) {
                setContentDescription(fVar.f);
            }
            if (fVar != null && fVar.f()) {
                z = true;
            }
            setSelected(z);
        }

        final void c() {
            setOrientation(!TabLayout.this.s ? 1 : 0);
            if (this.f != null || this.g != null) {
                a(this.f, this.g);
            } else {
                a(this.c, this.d);
            }
        }

        private void a(TextView textView, ImageView imageView) {
            Drawable mutate = (this.b == null || this.b.b() == null) ? null : androidx.core.graphics.drawable.a.g(this.b.b()).mutate();
            CharSequence d = this.b != null ? this.b.d() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(d);
            if (textView != null) {
                if (z) {
                    textView.setText(d);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int b = (z && imageView.getVisibility() == 0) ? TabLayout.this.b(8) : 0;
                if (TabLayout.this.s) {
                    if (b != androidx.core.h.g.b(marginLayoutParams)) {
                        androidx.core.h.g.a(marginLayoutParams, b);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (b != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = b;
                    androidx.core.h.g.a(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            CharSequence charSequence = this.b != null ? this.b.f : null;
            if (z) {
                charSequence = null;
            }
            ah.a(this, charSequence);
        }

        public int d() {
            int i = 0;
            int i2 = 0;
            boolean z = false;
            for (View view : new View[]{this.c, this.d, this.e}) {
                if (view != null && view.getVisibility() == 0) {
                    i2 = z ? Math.min(i2, view.getLeft()) : view.getLeft();
                    i = z ? Math.max(i, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i - i2;
        }

        private float a(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }
    }

    /* compiled from: source */
    private class e extends LinearLayout {
        int a;
        float b;
        private int d;
        private final Paint e;
        private final GradientDrawable f;
        private int g;
        private int h;
        private int i;
        private ValueAnimator j;

        e(Context context) {
            super(context);
            this.a = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            setWillNotDraw(false);
            this.e = new Paint();
            this.f = new GradientDrawable();
        }

        void a(int i) {
            if (this.e.getColor() != i) {
                this.e.setColor(i);
                w.f(this);
            }
        }

        void b(int i) {
            if (this.d != i) {
                this.d = i;
                w.f(this);
            }
        }

        boolean a() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        void a(int i, float f) {
            if (this.j != null && this.j.isRunning()) {
                this.j.cancel();
            }
            this.a = i;
            this.b = f;
            b();
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT >= 23 || this.g == i) {
                return;
            }
            requestLayout();
            this.g = i;
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            boolean z = true;
            if (TabLayout.this.r == 1 && TabLayout.this.o == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    if (childAt.getVisibility() == 0) {
                        i3 = Math.max(i3, childAt.getMeasuredWidth());
                    }
                }
                if (i3 <= 0) {
                    return;
                }
                if (i3 * childCount <= getMeasuredWidth() - (TabLayout.this.b(16) * 2)) {
                    boolean z2 = false;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                        if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i3;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    TabLayout.this.o = 0;
                    TabLayout.this.a(false);
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.j != null && this.j.isRunning()) {
                this.j.cancel();
                b(this.a, Math.round((1.0f - this.j.getAnimatedFraction()) * this.j.getDuration()));
                return;
            }
            b();
        }

        private void b() {
            int i;
            int i2;
            View childAt = getChildAt(this.a);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i = childAt.getLeft();
                i2 = childAt.getRight();
                if (!TabLayout.this.t && (childAt instanceof h)) {
                    a((h) childAt, TabLayout.this.z);
                    i = (int) TabLayout.this.z.left;
                    i2 = (int) TabLayout.this.z.right;
                }
                if (this.b > 0.0f && this.a < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.a + 1);
                    int left = childAt2.getLeft();
                    int right = childAt2.getRight();
                    if (!TabLayout.this.t && (childAt2 instanceof h)) {
                        a((h) childAt2, TabLayout.this.z);
                        left = (int) TabLayout.this.z.left;
                        right = (int) TabLayout.this.z.right;
                    }
                    i = (int) ((this.b * left) + ((1.0f - this.b) * i));
                    i2 = (int) ((this.b * right) + ((1.0f - this.b) * i2));
                }
            }
            a(i, i2);
        }

        void a(int i, int i2) {
            if (i == this.h && i2 == this.i) {
                return;
            }
            this.h = i;
            this.i = i2;
            w.f(this);
        }

        void b(int i, int i2) {
            if (this.j != null && this.j.isRunning()) {
                this.j.cancel();
            }
            View childAt = getChildAt(i);
            if (childAt == null) {
                b();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (!TabLayout.this.t && (childAt instanceof h)) {
                a((h) childAt, TabLayout.this.z);
                left = (int) TabLayout.this.z.left;
                right = (int) TabLayout.this.z.right;
            }
            int i3 = left;
            int i4 = right;
            int i5 = this.h;
            int i6 = this.i;
            if (i5 == i3 && i6 == i4) {
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.j = valueAnimator;
            valueAnimator.setInterpolator(com.google.android.material.a.a.b);
            valueAnimator.setDuration(i2);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.e.1
                final /* synthetic */ int a;
                final /* synthetic */ int b;
                final /* synthetic */ int c;
                final /* synthetic */ int d;

                AnonymousClass1(int i52, int i32, int i62, int i42) {
                    i5 = i52;
                    i3 = i32;
                    i6 = i62;
                    i4 = i42;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float animatedFraction = valueAnimator2.getAnimatedFraction();
                    e.this.a(com.google.android.material.a.a.a(i5, i3, animatedFraction), com.google.android.material.a.a.a(i6, i4, animatedFraction));
                }
            });
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.tabs.TabLayout.e.2
                final /* synthetic */ int a;

                AnonymousClass2(int i7) {
                    i = i7;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    e.this.a = i;
                    e.this.b = 0.0f;
                }
            });
            valueAnimator.start();
        }

        /* compiled from: source */
        /* renamed from: com.google.android.material.tabs.TabLayout$e$1 */
        class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ int a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;
            final /* synthetic */ int d;

            AnonymousClass1(int i52, int i32, int i62, int i42) {
                i5 = i52;
                i3 = i32;
                i6 = i62;
                i4 = i42;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float animatedFraction = valueAnimator2.getAnimatedFraction();
                e.this.a(com.google.android.material.a.a.a(i5, i3, animatedFraction), com.google.android.material.a.a.a(i6, i4, animatedFraction));
            }
        }

        /* compiled from: source */
        /* renamed from: com.google.android.material.tabs.TabLayout$e$2 */
        class AnonymousClass2 extends AnimatorListenerAdapter {
            final /* synthetic */ int a;

            AnonymousClass2(int i7) {
                i = i7;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.a = i;
                e.this.b = 0.0f;
            }
        }

        private void a(h hVar, RectF rectF) {
            int d = hVar.d();
            if (d < TabLayout.this.b(24)) {
                d = TabLayout.this.b(24);
            }
            int left = (hVar.getLeft() + hVar.getRight()) / 2;
            int i = d / 2;
            rectF.set(left - i, 0.0f, left + i, 0.0f);
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int i = 0;
            int intrinsicHeight = TabLayout.this.i != null ? TabLayout.this.i.getIntrinsicHeight() : 0;
            if (this.d >= 0) {
                intrinsicHeight = this.d;
            }
            switch (TabLayout.this.q) {
                case 0:
                    i = getHeight() - intrinsicHeight;
                    intrinsicHeight = getHeight();
                    break;
                case 1:
                    i = (getHeight() - intrinsicHeight) / 2;
                    intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
                    break;
                case 2:
                    break;
                case 3:
                    intrinsicHeight = getHeight();
                    break;
                default:
                    intrinsicHeight = 0;
                    break;
            }
            if (this.h >= 0 && this.i > this.h) {
                Drawable g = androidx.core.graphics.drawable.a.g(TabLayout.this.i != null ? TabLayout.this.i : this.f);
                g.setBounds(this.h, i, this.i, intrinsicHeight);
                if (this.e != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        g.setColorFilter(this.e.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        androidx.core.graphics.drawable.a.a(g, this.e.getColor());
                    }
                }
                g.draw(canvas);
            }
            super.draw(canvas);
        }
    }

    private static ColorStateList a(int i2, int i3) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private int getDefaultHeight() {
        int size = this.x.size();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                f fVar = this.x.get(i2);
                if (fVar != null && fVar.b() != null && !TextUtils.isEmpty(fVar.d())) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z || this.s) ? 48 : 72;
    }

    private int getTabMinWidth() {
        if (this.B != -1) {
            return this.B;
        }
        if (this.r == 0) {
            return this.D;
        }
        return 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    int getTabMaxWidth() {
        return this.n;
    }

    /* compiled from: source */
    public static class g implements ViewPager.e {
        private final WeakReference<TabLayout> a;
        private int b;
        private int c;

        public g(TabLayout tabLayout) {
            this.a = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void b(int i) {
            this.b = this.c;
            this.c = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void a(int i, float f, int i2) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null) {
                tabLayout.a(i, f, this.c != 2 || this.b == 1, (this.c == 2 && this.b == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void a(int i) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
                return;
            }
            tabLayout.b(tabLayout.a(i), this.c == 0 || (this.c == 2 && this.b == 0));
        }

        void a() {
            this.c = 0;
            this.b = 0;
        }
    }

    /* compiled from: source */
    public static class i implements c {
        private final ViewPager a;

        @Override // com.google.android.material.tabs.TabLayout.b
        public void b(f fVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.b
        public void c(f fVar) {
        }

        public i(ViewPager viewPager) {
            this.a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.b
        public void a(f fVar) {
            this.a.setCurrentItem(fVar.c());
        }
    }

    /* compiled from: source */
    private class d extends DataSetObserver {
        d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.d();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.d();
        }
    }

    /* compiled from: source */
    private class a implements ViewPager.d {
        private boolean b;

        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.d
        public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            if (TabLayout.this.v == viewPager) {
                TabLayout.this.a(aVar2, this.b);
            }
        }

        void a(boolean z) {
            this.b = z;
        }
    }
}
