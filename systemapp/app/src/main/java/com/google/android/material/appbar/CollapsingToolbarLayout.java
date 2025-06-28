package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.a;
import androidx.appcompat.widget.Toolbar;
import androidx.core.h.ae;
import androidx.core.h.r;
import androidx.core.h.w;
import com.google.android.material.a;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.c;
import com.google.android.material.internal.d;
import com.google.android.material.internal.k;

/* compiled from: source */
/* loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    final c a;
    Drawable b;
    int c;
    ae d;
    private boolean e;
    private int f;
    private Toolbar g;
    private View h;
    private View i;
    private int j;
    private int k;
    private int l;
    private int m;
    private final Rect n;
    private boolean o;
    private boolean p;
    private Drawable q;
    private int r;
    private boolean s;
    private ValueAnimator t;
    private long u;
    private int v;
    private AppBarLayout.b w;

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = true;
        this.n = new Rect();
        this.v = -1;
        this.a = new c(this);
        this.a.a(com.google.android.material.a.a.e);
        TypedArray a2 = k.a(context, attributeSet, a.k.CollapsingToolbarLayout, i, a.j.Widget_Design_CollapsingToolbar, new int[0]);
        this.a.a(a2.getInt(a.k.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.a.b(a2.getInt(a.k.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = a2.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.m = dimensionPixelSize;
        this.l = dimensionPixelSize;
        this.k = dimensionPixelSize;
        this.j = dimensionPixelSize;
        if (a2.hasValue(a.k.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.j = a2.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (a2.hasValue(a.k.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.l = a2.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (a2.hasValue(a.k.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.k = a2.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (a2.hasValue(a.k.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.m = a2.getDimensionPixelSize(a.k.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.o = a2.getBoolean(a.k.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(a2.getText(a.k.CollapsingToolbarLayout_title));
        this.a.d(a.j.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.a.c(a.i.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (a2.hasValue(a.k.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.a.d(a2.getResourceId(a.k.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (a2.hasValue(a.k.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.a.c(a2.getResourceId(a.k.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.v = a2.getDimensionPixelSize(a.k.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.u = a2.getInt(a.k.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(a2.getDrawable(a.k.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(a2.getDrawable(a.k.CollapsingToolbarLayout_statusBarScrim));
        this.f = a2.getResourceId(a.k.CollapsingToolbarLayout_toolbarId, -1);
        a2.recycle();
        setWillNotDraw(false);
        w.a(this, new r() { // from class: com.google.android.material.appbar.CollapsingToolbarLayout.1
            AnonymousClass1() {
            }

            @Override // androidx.core.h.r
            public ae a(View view, ae aeVar) {
                return CollapsingToolbarLayout.this.a(aeVar);
            }
        });
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.appbar.CollapsingToolbarLayout$1 */
    class AnonymousClass1 implements r {
        AnonymousClass1() {
        }

        @Override // androidx.core.h.r
        public ae a(View view, ae aeVar) {
            return CollapsingToolbarLayout.this.a(aeVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object parent = getParent();
        if (parent instanceof AppBarLayout) {
            w.b(this, w.u((View) parent));
            if (this.w == null) {
                this.w = new a();
            }
            ((AppBarLayout) parent).a(this.w);
            w.t(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.w != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).b(this.w);
        }
        super.onDetachedFromWindow();
    }

    ae a(ae aeVar) {
        ae aeVar2 = w.u(this) ? aeVar : null;
        if (!androidx.core.g.c.a(this.d, aeVar2)) {
            this.d = aeVar2;
            requestLayout();
        }
        return aeVar.g();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        c();
        if (this.g == null && this.q != null && this.r > 0) {
            this.q.mutate().setAlpha(this.r);
            this.q.draw(canvas);
        }
        if (this.o && this.p) {
            this.a.a(canvas);
        }
        if (this.b == null || this.r <= 0) {
            return;
        }
        int b = this.d != null ? this.d.b() : 0;
        if (b > 0) {
            this.b.setBounds(0, -this.c, getWidth(), b - this.c);
            this.b.mutate().setAlpha(this.r);
            this.b.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.q == null || this.r <= 0 || !c(view)) {
            z = false;
        } else {
            this.q.mutate().setAlpha(this.r);
            this.q.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j) || z;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.q != null) {
            this.q.setBounds(0, 0, i, i2);
        }
    }

    private void c() {
        if (this.e) {
            Toolbar toolbar = null;
            this.g = null;
            this.h = null;
            if (this.f != -1) {
                this.g = (Toolbar) findViewById(this.f);
                if (this.g != null) {
                    this.h = d(this.g);
                }
            }
            if (this.g == null) {
                int childCount = getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i++;
                }
                this.g = toolbar;
            }
            d();
            this.e = false;
        }
    }

    private boolean c(View view) {
        if (this.h == null || this.h == this) {
            if (view != this.g) {
                return false;
            }
        } else if (view != this.h) {
            return false;
        }
        return true;
    }

    private View d(View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    private void d() {
        if (!this.o && this.i != null) {
            ViewParent parent = this.i.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.i);
            }
        }
        if (!this.o || this.g == null) {
            return;
        }
        if (this.i == null) {
            this.i = new View(getContext());
        }
        if (this.i.getParent() == null) {
            this.g.addView(this.i, -1, -1);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        c();
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int b = this.d != null ? this.d.b() : 0;
        if (mode != 0 || b <= 0) {
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + b, 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.d != null) {
            int b = this.d.b();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!w.u(childAt) && childAt.getTop() < b) {
                    w.f(childAt, b);
                }
            }
        }
        if (this.o && this.i != null) {
            this.p = w.F(this.i) && this.i.getVisibility() == 0;
            if (this.p) {
                boolean z2 = w.h(this) == 1;
                int b2 = b(this.h != null ? this.h : this.g);
                d.b(this, this.i, this.n);
                this.a.b(this.n.left + (z2 ? this.g.getTitleMarginEnd() : this.g.getTitleMarginStart()), this.n.top + b2 + this.g.getTitleMarginTop(), this.n.right + (z2 ? this.g.getTitleMarginStart() : this.g.getTitleMarginEnd()), (this.n.bottom + b2) - this.g.getTitleMarginBottom());
                this.a.a(z2 ? this.l : this.j, this.n.top + this.k, (i3 - i) - (z2 ? this.j : this.l), (i4 - i2) - this.m);
                this.a.k();
            }
        }
        int childCount2 = getChildCount();
        for (int i6 = 0; i6 < childCount2; i6++) {
            a(getChildAt(i6)).a();
        }
        if (this.g != null) {
            if (this.o && TextUtils.isEmpty(this.a.l())) {
                setTitle(this.g.getTitle());
            }
            if (this.h == null || this.h == this) {
                setMinimumHeight(e(this.g));
            } else {
                setMinimumHeight(e(this.h));
            }
        }
        b();
    }

    private static int e(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return view.getHeight();
    }

    static com.google.android.material.appbar.a a(View view) {
        com.google.android.material.appbar.a aVar = (com.google.android.material.appbar.a) view.getTag(a.f.view_offset_helper);
        if (aVar != null) {
            return aVar;
        }
        com.google.android.material.appbar.a aVar2 = new com.google.android.material.appbar.a(view);
        view.setTag(a.f.view_offset_helper, aVar2);
        return aVar2;
    }

    public void setTitle(CharSequence charSequence) {
        this.a.a(charSequence);
        e();
    }

    public CharSequence getTitle() {
        if (this.o) {
            return this.a.l();
        }
        return null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.o) {
            this.o = z;
            e();
            d();
            requestLayout();
        }
    }

    public void setScrimsShown(boolean z) {
        a(z, w.C(this) && !isInEditMode());
    }

    public void a(boolean z, boolean z2) {
        if (this.s != z) {
            if (z2) {
                a(z ? 255 : 0);
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.s = z;
        }
    }

    private void a(int i) {
        c();
        if (this.t == null) {
            this.t = new ValueAnimator();
            this.t.setDuration(this.u);
            this.t.setInterpolator(i > this.r ? com.google.android.material.a.a.c : com.google.android.material.a.a.d);
            this.t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.CollapsingToolbarLayout.2
                AnonymousClass2() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else if (this.t.isRunning()) {
            this.t.cancel();
        }
        this.t.setIntValues(this.r, i);
        this.t.start();
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.appbar.CollapsingToolbarLayout$2 */
    class AnonymousClass2 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass2() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    void setScrimAlpha(int i) {
        if (i != this.r) {
            if (this.q != null && this.g != null) {
                w.f(this.g);
            }
            this.r = i;
            w.f(this);
        }
    }

    int getScrimAlpha() {
        return this.r;
    }

    public void setContentScrim(Drawable drawable) {
        if (this.q != drawable) {
            if (this.q != null) {
                this.q.setCallback(null);
            }
            this.q = drawable != null ? drawable.mutate() : null;
            if (this.q != null) {
                this.q.setBounds(0, 0, getWidth(), getHeight());
                this.q.setCallback(this);
                this.q.setAlpha(this.r);
            }
            w.f(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(androidx.core.content.a.a(getContext(), i));
    }

    public Drawable getContentScrim() {
        return this.q;
    }

    public void setStatusBarScrim(Drawable drawable) {
        if (this.b != drawable) {
            if (this.b != null) {
                this.b.setCallback(null);
            }
            this.b = drawable != null ? drawable.mutate() : null;
            if (this.b != null) {
                if (this.b.isStateful()) {
                    this.b.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.b(this.b, w.h(this));
                this.b.setVisible(getVisibility() == 0, false);
                this.b.setCallback(this);
                this.b.setAlpha(this.r);
            }
            w.f(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.b;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.q;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (this.a != null) {
            z |= this.a.a(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q || drawable == this.b;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.b != null && this.b.isVisible() != z) {
            this.b.setVisible(z, false);
        }
        if (this.q == null || this.q.isVisible() == z) {
            return;
        }
        this.q.setVisible(z, false);
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(androidx.core.content.a.a(getContext(), i));
    }

    public Drawable getStatusBarScrim() {
        return this.b;
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.a.c(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.a.a(colorStateList);
    }

    public void setCollapsedTitleGravity(int i) {
        this.a.b(i);
    }

    public int getCollapsedTitleGravity() {
        return this.a.e();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.a.d(i);
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.a.b(colorStateList);
    }

    public void setExpandedTitleGravity(int i) {
        this.a.a(i);
    }

    public int getExpandedTitleGravity() {
        return this.a.d();
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.a.a(typeface);
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.a.f();
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.a.b(typeface);
    }

    public Typeface getExpandedTitleTypeface() {
        return this.a.g();
    }

    public int getExpandedTitleMarginStart() {
        return this.j;
    }

    public void setExpandedTitleMarginStart(int i) {
        this.j = i;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.k;
    }

    public void setExpandedTitleMarginTop(int i) {
        this.k = i;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.l;
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.l = i;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.m;
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.m = i;
        requestLayout();
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.v != i) {
            this.v = i;
            b();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        if (this.v >= 0) {
            return this.v;
        }
        int b = this.d != null ? this.d.b() : 0;
        int n = w.n(this);
        if (n > 0) {
            return Math.min((n * 2) + b, getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long j) {
        this.u = j;
    }

    public long getScrimAnimationDuration() {
        return this.u;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: a */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* compiled from: source */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        int a;
        float b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            this.b = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.CollapsingToolbarLayout_Layout);
            this.a = obtainStyledAttributes.getInt(a.k.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            a(obtainStyledAttributes.getFloat(a.k.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = 0;
            this.b = 0.5f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
            this.b = 0.5f;
        }

        public void a(float f) {
            this.b = f;
        }
    }

    final void b() {
        if (this.q == null && this.b == null) {
            return;
        }
        setScrimsShown(getHeight() + this.c < getScrimVisibleHeightTrigger());
    }

    final int b(View view) {
        return ((getHeight() - a(view).c()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    private void e() {
        setContentDescription(getTitle());
    }

    /* compiled from: source */
    private class a implements AppBarLayout.b {
        a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.a
        public void a(AppBarLayout appBarLayout, int i) {
            CollapsingToolbarLayout.this.c = i;
            int b = CollapsingToolbarLayout.this.d != null ? CollapsingToolbarLayout.this.d.b() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                com.google.android.material.appbar.a a = CollapsingToolbarLayout.a(childAt);
                switch (layoutParams.a) {
                    case 1:
                        a.a(androidx.core.b.a.a(-i, 0, CollapsingToolbarLayout.this.b(childAt)));
                        break;
                    case 2:
                        a.a(Math.round((-i) * layoutParams.b));
                        break;
                }
            }
            CollapsingToolbarLayout.this.b();
            if (CollapsingToolbarLayout.this.b != null && b > 0) {
                w.f(CollapsingToolbarLayout.this);
            }
            CollapsingToolbarLayout.this.a.b(Math.abs(i) / ((CollapsingToolbarLayout.this.getHeight() - w.n(CollapsingToolbarLayout.this)) - b));
        }
    }
}
