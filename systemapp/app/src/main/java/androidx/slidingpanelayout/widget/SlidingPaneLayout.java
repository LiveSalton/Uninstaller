package androidx.slidingpanelayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.w;
import androidx.customview.a.c;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup {
    View a;
    float b;
    int c;
    boolean d;
    final androidx.customview.a.c e;
    boolean f;
    final ArrayList<b> g;
    private int h;
    private int i;
    private Drawable j;
    private Drawable k;
    private final int l;
    private boolean m;
    private float n;
    private int o;
    private float p;
    private float q;
    private d r;
    private boolean s;
    private final Rect t;
    private Method u;
    private Field v;
    private boolean w;

    /* compiled from: source */
    public interface d {
        void a(View view);

        void a(View view, float f);

        void b(View view);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = -858993460;
        this.s = true;
        this.t = new Rect();
        this.g = new ArrayList<>();
        float f = context.getResources().getDisplayMetrics().density;
        this.l = (int) ((32.0f * f) + 0.5f);
        setWillNotDraw(false);
        w.a(this, new a());
        w.b((View) this, 1);
        this.e = androidx.customview.a.c.a(this, 0.5f, new c());
        this.e.a(400.0f * f);
    }

    public void setParallaxDistance(int i) {
        this.o = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.o;
    }

    public void setSliderFadeColor(int i) {
        this.h = i;
    }

    public int getSliderFadeColor() {
        return this.h;
    }

    public void setCoveredFadeColor(int i) {
        this.i = i;
    }

    public int getCoveredFadeColor() {
        return this.i;
    }

    public void setPanelSlideListener(d dVar) {
        this.r = dVar;
    }

    void a(View view) {
        if (this.r != null) {
            this.r.a(view, this.b);
        }
    }

    void b(View view) {
        if (this.r != null) {
            this.r.a(view);
        }
        sendAccessibilityEvent(32);
    }

    void c(View view) {
        if (this.r != null) {
            this.r.b(view);
        }
        sendAccessibilityEvent(32);
    }

    void d(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        View view2 = view;
        boolean f = f();
        int width = f ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = f ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !g(view)) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            i = view.getLeft();
            i2 = view.getRight();
            i3 = view.getTop();
            i4 = view.getBottom();
        }
        int childCount = getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt == view2) {
                return;
            }
            if (childAt.getVisibility() == 8) {
                z = f;
            } else {
                int max = Math.max(f ? paddingLeft : width, childAt.getLeft());
                int max2 = Math.max(paddingTop, childAt.getTop());
                if (f) {
                    z = f;
                    i5 = width;
                } else {
                    z = f;
                    i5 = paddingLeft;
                }
                childAt.setVisibility((max < i || max2 < i3 || Math.min(i5, childAt.getRight()) > i2 || Math.min(height, childAt.getBottom()) > i4) ? 0 : 4);
            }
            i6++;
            f = z;
            view2 = view;
        }
    }

    void a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    private static boolean g(View view) {
        Drawable background;
        if (view.isOpaque()) {
            return true;
        }
        return Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s = true;
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.g.get(i).run();
        }
        this.g.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x020b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r21, int r22) {
        /*
            Method dump skipped, instructions count: 585
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c6  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.s = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.m) {
            return;
        }
        this.f = view == this.a;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.m && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f = !this.e.b(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.m || (this.d && actionMasked != 0)) {
            this.e.f();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            this.e.f();
            return false;
        }
        if (actionMasked == 0) {
            this.d = false;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.p = x;
            this.q = y;
            if (this.e.b(this.a, (int) x, (int) y) && f(this.a)) {
                z = true;
                return this.e.a(motionEvent) || z;
            }
        } else if (actionMasked == 2) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float abs = Math.abs(x2 - this.p);
            float abs2 = Math.abs(y2 - this.q);
            if (abs > this.e.e() && abs2 > abs) {
                this.e.f();
                this.d = true;
                return false;
            }
        }
        z = false;
        if (this.e.a(motionEvent)) {
            return true;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
    
        return true;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.m
            if (r0 != 0) goto L9
            boolean r6 = super.onTouchEvent(r6)
            return r6
        L9:
            androidx.customview.a.c r0 = r5.e
            r0.b(r6)
            r0 = 1
            int r1 = r6.getActionMasked()
            switch(r1) {
                case 0: goto L51;
                case 1: goto L17;
                default: goto L16;
            }
        L16:
            goto L5d
        L17:
            android.view.View r1 = r5.a
            boolean r1 = r5.f(r1)
            if (r1 == 0) goto L5d
            float r1 = r6.getX()
            float r6 = r6.getY()
            float r2 = r5.p
            float r2 = r1 - r2
            float r3 = r5.q
            float r3 = r6 - r3
            androidx.customview.a.c r4 = r5.e
            int r4 = r4.e()
            float r2 = r2 * r2
            float r3 = r3 * r3
            float r2 = r2 + r3
            int r4 = r4 * r4
            float r3 = (float) r4
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L5d
            androidx.customview.a.c r2 = r5.e
            android.view.View r3 = r5.a
            int r1 = (int) r1
            int r6 = (int) r6
            boolean r6 = r2.b(r3, r1, r6)
            if (r6 == 0) goto L5d
            android.view.View r6 = r5.a
            r1 = 0
            r5.a(r6, r1)
            goto L5d
        L51:
            float r1 = r6.getX()
            float r6 = r6.getY()
            r5.p = r1
            r5.q = r6
        L5d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean a(View view, int i) {
        if (!this.s && !a(0.0f, i)) {
            return false;
        }
        this.f = false;
        return true;
    }

    private boolean b(View view, int i) {
        if (!this.s && !a(1.0f, i)) {
            return false;
        }
        this.f = true;
        return true;
    }

    public boolean b() {
        return b(this.a, 0);
    }

    public boolean c() {
        return a(this.a, 0);
    }

    public boolean d() {
        return !this.m || this.b == 1.0f;
    }

    public boolean e() {
        return this.m;
    }

    void a(int i) {
        if (this.a == null) {
            this.b = 0.0f;
            return;
        }
        boolean f = f();
        LayoutParams layoutParams = (LayoutParams) this.a.getLayoutParams();
        int width = this.a.getWidth();
        if (f) {
            i = (getWidth() - i) - width;
        }
        this.b = (i - ((f ? getPaddingRight() : getPaddingLeft()) + (f ? layoutParams.rightMargin : layoutParams.leftMargin))) / this.c;
        if (this.o != 0) {
            a(this.b);
        }
        if (layoutParams.c) {
            a(this.a, this.b, this.h);
        }
        a(this.a);
    }

    private void a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) ((((-16777216) & i) >>> 24) * f)) << 24) | (i & 16777215);
            if (layoutParams.d == null) {
                layoutParams.d = new Paint();
            }
            layoutParams.d.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.d);
            }
            e(view);
            return;
        }
        if (view.getLayerType() != 0) {
            if (layoutParams.d != null) {
                layoutParams.d.setColorFilter(null);
            }
            b bVar = new b(view);
            this.g.add(bVar);
            w.a(this, bVar);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.m && !layoutParams.b && this.a != null) {
            canvas.getClipBounds(this.t);
            if (f()) {
                this.t.left = Math.max(this.t.left, this.a.getRight());
            } else {
                this.t.right = Math.min(this.t.right, this.a.getLeft());
            }
            canvas.clipRect(this.t);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return drawChild;
    }

    void e(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            w.a(view, ((LayoutParams) view.getLayoutParams()).d);
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (!this.w) {
                try {
                    this.u = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
                } catch (NoSuchMethodException e) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
                }
                try {
                    this.v = View.class.getDeclaredField("mRecreateDisplayList");
                    this.v.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
                }
                this.w = true;
            }
            if (this.u == null || this.v == null) {
                view.invalidate();
                return;
            }
            try {
                this.v.setBoolean(view, true);
                this.u.invoke(view, (Object[]) null);
            } catch (Exception e3) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e3);
            }
        }
        w.a(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    boolean a(float f, int i) {
        int paddingLeft;
        if (!this.m) {
            return false;
        }
        boolean f2 = f();
        LayoutParams layoutParams = (LayoutParams) this.a.getLayoutParams();
        if (f2) {
            paddingLeft = (int) (getWidth() - (((getPaddingRight() + layoutParams.rightMargin) + (f * this.c)) + this.a.getWidth()));
        } else {
            paddingLeft = (int) (getPaddingLeft() + layoutParams.leftMargin + (f * this.c));
        }
        if (!this.e.a(this.a, paddingLeft, this.a.getTop())) {
            return false;
        }
        a();
        w.f(this);
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.e.a(true)) {
            if (!this.m) {
                this.e.g();
            } else {
                w.f(this);
            }
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.j = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.k = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(androidx.core.content.a.a(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(androidx.core.content.a.a(getContext(), i));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        int i;
        int i2;
        super.draw(canvas);
        if (f()) {
            drawable = this.k;
        } else {
            drawable = this.j;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (f()) {
            i2 = childAt.getRight();
            i = intrinsicWidth + i2;
        } else {
            int left = childAt.getLeft();
            int i3 = left - intrinsicWidth;
            i = left;
            i2 = i3;
        }
        drawable.setBounds(i2, top, i, bottom);
        drawable.draw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(float r10) {
        /*
            r9 = this;
            boolean r0 = r9.f()
            android.view.View r1 = r9.a
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r1
            boolean r2 = r1.c
            r3 = 0
            if (r2 == 0) goto L1c
            if (r0 == 0) goto L16
            int r1 = r1.rightMargin
            goto L18
        L16:
            int r1 = r1.leftMargin
        L18:
            if (r1 > 0) goto L1c
            r1 = 1
            goto L1d
        L1c:
            r1 = r3
        L1d:
            int r2 = r9.getChildCount()
        L21:
            if (r3 >= r2) goto L5b
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.a
            if (r4 != r5) goto L2c
            goto L58
        L2c:
            float r5 = r9.n
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.o
            float r7 = (float) r7
            float r5 = r5 * r7
            int r5 = (int) r5
            r9.n = r10
            float r7 = r6 - r10
            int r8 = r9.o
            float r8 = (float) r8
            float r7 = r7 * r8
            int r7 = (int) r7
            int r5 = r5 - r7
            if (r0 == 0) goto L44
            int r5 = -r5
        L44:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L58
            if (r0 == 0) goto L4f
            float r5 = r9.n
            float r5 = r5 - r6
            goto L53
        L4f:
            float r5 = r9.n
            float r5 = r6 - r5
        L53:
            int r6 = r9.i
            r9.a(r4, r5, r6)
        L58:
            int r3 = r3 + 1
            goto L21
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.a(float):void");
    }

    boolean f(View view) {
        if (view == null) {
            return false;
        }
        return this.m && ((LayoutParams) view.getLayoutParams()).c && this.b > 0.0f;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = e() ? d() : this.f;
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        if (savedState.a) {
            b();
        } else {
            c();
        }
        this.f = savedState.a;
    }

    /* compiled from: source */
    private class c extends c.a {
        c() {
        }

        @Override // androidx.customview.a.c.a
        public boolean b(View view, int i) {
            if (SlidingPaneLayout.this.d) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).b;
        }

        @Override // androidx.customview.a.c.a
        public void a(int i) {
            if (SlidingPaneLayout.this.e.a() == 0) {
                if (SlidingPaneLayout.this.b == 0.0f) {
                    SlidingPaneLayout.this.d(SlidingPaneLayout.this.a);
                    SlidingPaneLayout.this.c(SlidingPaneLayout.this.a);
                    SlidingPaneLayout.this.f = false;
                } else {
                    SlidingPaneLayout.this.b(SlidingPaneLayout.this.a);
                    SlidingPaneLayout.this.f = true;
                }
            }
        }

        @Override // androidx.customview.a.c.a
        public void a(View view, int i) {
            SlidingPaneLayout.this.a();
        }

        @Override // androidx.customview.a.c.a
        public void a(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout.this.a(i);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.a.c.a
        public void a(View view, float f, float f2) {
            int paddingLeft;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.f()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.b > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.c;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.a.getWidth();
            } else {
                paddingLeft = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && SlidingPaneLayout.this.b > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.c;
                }
            }
            SlidingPaneLayout.this.e.a(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.a.c.a
        public int a(View view) {
            return SlidingPaneLayout.this.c;
        }

        @Override // androidx.customview.a.c.a
        public int a(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.a.getLayoutParams();
            if (SlidingPaneLayout.this.f()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin) + SlidingPaneLayout.this.a.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.c);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.c + paddingLeft);
        }

        @Override // androidx.customview.a.c.a
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.a.c.a
        public void b(int i, int i2) {
            SlidingPaneLayout.this.e.a(SlidingPaneLayout.this.a, i2);
        }
    }

    /* compiled from: source */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] e = {R.attr.layout_weight};
        public float a;
        boolean b;
        boolean c;
        Paint d;

        public LayoutParams() {
            super(-1, -1);
            this.a = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e);
            this.a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: source */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
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
        boolean a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a ? 1 : 0);
        }

        /* compiled from: source */
        /* renamed from: androidx.slidingpanelayout.widget.SlidingPaneLayout$SavedState$1 */
        static class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
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
    class a extends androidx.core.h.a {
        private final Rect b = new Rect();

        a() {
        }

        @Override // androidx.core.h.a
        public void a(View view, androidx.core.h.a.d dVar) {
            androidx.core.h.a.d a = androidx.core.h.a.d.a(dVar);
            super.a(view, a);
            a(dVar, a);
            a.v();
            dVar.b((CharSequence) SlidingPaneLayout.class.getName());
            dVar.b(view);
            Object i = w.i(view);
            if (i instanceof View) {
                dVar.d((View) i);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i2);
                if (!c(childAt) && childAt.getVisibility() == 0) {
                    w.b(childAt, 1);
                    dVar.c(childAt);
                }
            }
        }

        @Override // androidx.core.h.a
        public void d(View view, AccessibilityEvent accessibilityEvent) {
            super.d(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // androidx.core.h.a
        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (c(view)) {
                return false;
            }
            return super.a(viewGroup, view, accessibilityEvent);
        }

        public boolean c(View view) {
            return SlidingPaneLayout.this.f(view);
        }

        private void a(androidx.core.h.a.d dVar, androidx.core.h.a.d dVar2) {
            Rect rect = this.b;
            dVar2.a(rect);
            dVar.b(rect);
            dVar2.c(rect);
            dVar.d(rect);
            dVar.e(dVar2.j());
            dVar.a(dVar2.r());
            dVar.b(dVar2.s());
            dVar.e(dVar2.u());
            dVar.j(dVar2.o());
            dVar.h(dVar2.m());
            dVar.c(dVar2.h());
            dVar.d(dVar2.i());
            dVar.f(dVar2.k());
            dVar.g(dVar2.l());
            dVar.i(dVar2.n());
            dVar.a(dVar2.d());
            dVar.b(dVar2.e());
        }
    }

    /* compiled from: source */
    private class b implements Runnable {
        final View a;

        b(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.getParent() == SlidingPaneLayout.this) {
                this.a.setLayerType(0, null);
                SlidingPaneLayout.this.e(this.a);
            }
            SlidingPaneLayout.this.g.remove(this);
        }
    }

    boolean f() {
        return w.h(this) == 1;
    }
}
