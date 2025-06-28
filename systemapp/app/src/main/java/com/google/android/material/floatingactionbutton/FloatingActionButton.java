package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.h;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.u;
import androidx.core.h.w;
import androidx.core.widget.l;
import com.google.android.material.a;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.d.c;
import com.google.android.material.floatingactionbutton.a;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.d;
import com.google.android.material.internal.k;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.List;

/* compiled from: source */
@CoordinatorLayout.b(a = Behavior.class)
/* loaded from: classes.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements u, l, com.google.android.material.d.a {
    boolean a;
    final Rect b;
    private ColorStateList c;
    private PorterDuff.Mode d;
    private ColorStateList e;
    private PorterDuff.Mode f;
    private int g;
    private ColorStateList h;
    private int i;
    private int j;
    private int k;
    private int l;
    private final Rect m;
    private final h n;
    private final c o;
    private com.google.android.material.floatingactionbutton.a p;

    /* compiled from: source */
    public static abstract class a {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.floatingActionButtonStyle);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Rect();
        this.m = new Rect();
        TypedArray a2 = k.a(context, attributeSet, a.k.FloatingActionButton, i, a.j.Widget_Design_FloatingActionButton, new int[0]);
        this.c = com.google.android.material.f.a.a(context, a2, a.k.FloatingActionButton_backgroundTint);
        this.d = com.google.android.material.internal.l.a(a2.getInt(a.k.FloatingActionButton_backgroundTintMode, -1), null);
        this.h = com.google.android.material.f.a.a(context, a2, a.k.FloatingActionButton_rippleColor);
        this.i = a2.getInt(a.k.FloatingActionButton_fabSize, -1);
        this.j = a2.getDimensionPixelSize(a.k.FloatingActionButton_fabCustomSize, 0);
        this.g = a2.getDimensionPixelSize(a.k.FloatingActionButton_borderWidth, 0);
        float dimension = a2.getDimension(a.k.FloatingActionButton_elevation, 0.0f);
        float dimension2 = a2.getDimension(a.k.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = a2.getDimension(a.k.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.a = a2.getBoolean(a.k.FloatingActionButton_useCompatPadding, false);
        this.l = a2.getDimensionPixelSize(a.k.FloatingActionButton_maxImageSize, 0);
        com.google.android.material.a.h a3 = com.google.android.material.a.h.a(context, a2, a.k.FloatingActionButton_showMotionSpec);
        com.google.android.material.a.h a4 = com.google.android.material.a.h.a(context, a2, a.k.FloatingActionButton_hideMotionSpec);
        a2.recycle();
        this.n = new h(this);
        this.n.a(attributeSet, i);
        this.o = new c(this);
        getImpl().a(this.c, this.d, this.h, this.g);
        getImpl().a(dimension);
        getImpl().b(dimension2);
        getImpl().c(dimension3);
        getImpl().a(this.l);
        getImpl().a(a3);
        getImpl().b(a4);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.k = (sizeDimension - this.l) / 2;
        getImpl().j();
        int min = Math.min(a(sizeDimension, i), a(sizeDimension, i2));
        setMeasuredDimension(this.b.left + min + this.b.right, min + this.b.top + this.b.bottom);
    }

    @Deprecated
    public int getRippleColor() {
        if (this.h != null) {
            return this.h.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.h;
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.h != colorStateList) {
            this.h = colorStateList;
            getImpl().b(this.h);
        }
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.c;
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.c != colorStateList) {
            this.c = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.d;
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.d != mode) {
            this.d = mode;
            getImpl().a(mode);
        }
    }

    @Override // androidx.core.h.u
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.h.u
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.h.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.h.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            c();
        }
    }

    @Override // androidx.core.widget.l
    public ColorStateList getSupportImageTintList() {
        return this.e;
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f != mode) {
            this.f = mode;
            c();
        }
    }

    @Override // androidx.core.widget.l
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f;
    }

    private void c() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        if (this.e == null) {
            androidx.core.graphics.drawable.a.f(drawable);
            return;
        }
        int colorForState = this.e.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(f.a(colorForState, mode));
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.n.a(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        getImpl().d();
    }

    void a(a aVar, boolean z) {
        getImpl().b(a(aVar), z);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        getImpl().a(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        getImpl().b(animatorListener);
    }

    void b(a aVar, boolean z) {
        getImpl().a(a(aVar), z);
    }

    public void c(Animator.AnimatorListener animatorListener) {
        getImpl().c(animatorListener);
    }

    public void d(Animator.AnimatorListener animatorListener) {
        getImpl().d(animatorListener);
    }

    @Override // com.google.android.material.d.b
    public boolean a() {
        return this.o.a();
    }

    public void setExpandedComponentIdHint(int i) {
        this.o.a(i);
    }

    public int getExpandedComponentIdHint() {
        return this.o.c();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.a != z) {
            this.a = z;
            getImpl().i();
        }
    }

    public boolean getUseCompatPadding() {
        return this.a;
    }

    public void setSize(int i) {
        this.j = 0;
        if (i != this.i) {
            this.i = i;
            requestLayout();
        }
    }

    public int getSize() {
        return this.i;
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButton$1 */
    class AnonymousClass1 implements a.d {
        final /* synthetic */ a a;

        AnonymousClass1(a aVar) {
            aVar = aVar;
        }

        @Override // com.google.android.material.floatingactionbutton.a.d
        public void a() {
            aVar.a(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.a.d
        public void b() {
            aVar.b(FloatingActionButton.this);
        }
    }

    private a.d a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new a.d() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButton.1
            final /* synthetic */ a a;

            AnonymousClass1(a aVar2) {
                aVar = aVar2;
            }

            @Override // com.google.android.material.floatingactionbutton.a.d
            public void a() {
                aVar.a(FloatingActionButton.this);
            }

            @Override // com.google.android.material.floatingactionbutton.a.d
            public void b() {
                aVar.b(FloatingActionButton.this);
            }
        };
    }

    public boolean b() {
        return getImpl().r();
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        this.j = i;
    }

    public int getCustomSize() {
        return this.j;
    }

    int getSizeDimension() {
        return a(this.i);
    }

    private int a(int i) {
        if (this.j != 0) {
            return this.j;
        }
        Resources resources = getResources();
        if (i != -1) {
            if (i == 1) {
                return resources.getDimensionPixelSize(a.d.design_fab_size_mini);
            }
            return resources.getDimensionPixelSize(a.d.design_fab_size_normal);
        }
        if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return a(1);
        }
        return a(0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().k();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().l();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().g();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
        extendableSavedState.a.put("expandableWidgetHelper", this.o.b());
        return extendableSavedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.a());
        this.o.a(extendableSavedState.a.get("expandableWidgetHelper"));
    }

    @Deprecated
    public boolean a(Rect rect) {
        if (!w.C(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        c(rect);
        return true;
    }

    public void b(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        c(rect);
    }

    private void c(Rect rect) {
        rect.left += this.b.left;
        rect.top += this.b.top;
        rect.right -= this.b.right;
        rect.bottom -= this.b.bottom;
    }

    public Drawable getContentBackground() {
        return getImpl().h();
    }

    private static int a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size);
        }
        if (mode == 0) {
            return i;
        }
        if (mode != 1073741824) {
            throw new IllegalArgumentException();
        }
        return size;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && a(this.m) && !this.m.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* compiled from: source */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout.d dVar) {
            super.a(dVar);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            return super.a(coordinatorLayout, floatingActionButton, i);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.a(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.b(coordinatorLayout, floatingActionButton, view);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* compiled from: source */
    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private Rect a;
        private a b;
        private boolean c;

        public BaseBehavior() {
            this.c = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.FloatingActionButton_Behavior_Layout);
            this.c = obtainStyledAttributes.getBoolean(a.k.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void a(CoordinatorLayout.d dVar) {
            if (dVar.h == 0) {
                dVar.h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!a(view)) {
                return false;
            }
            b(view, floatingActionButton);
            return false;
        }

        private static boolean a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.d) {
                return ((CoordinatorLayout.d) layoutParams).b() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            return this.c && ((CoordinatorLayout.d) floatingActionButton.getLayoutParams()).a() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!a(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            d.b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.b(this.b, false);
                return true;
            }
            floatingActionButton.a(this.b, false);
            return true;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (!a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((CoordinatorLayout.d) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.b(this.b, false);
                return true;
            }
            floatingActionButton.a(this.b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> c = coordinatorLayout.c(floatingActionButton);
            int size = c.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = c.get(i2);
                if (view instanceof AppBarLayout) {
                    if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (a(view) && b(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.b(floatingActionButton, i);
            a(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.b;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        private void a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i;
            Rect rect = floatingActionButton.b;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) floatingActionButton.getLayoutParams();
            int i2 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - dVar.rightMargin) {
                i = rect.right;
            } else {
                i = floatingActionButton.getLeft() <= dVar.leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - dVar.bottomMargin) {
                i2 = rect.bottom;
            } else if (floatingActionButton.getTop() <= dVar.topMargin) {
                i2 = -rect.top;
            }
            if (i2 != 0) {
                w.f(floatingActionButton, i2);
            }
            if (i != 0) {
                w.g(floatingActionButton, i);
            }
        }
    }

    public float getCompatElevation() {
        return getImpl().a();
    }

    public void setCompatElevation(float f) {
        getImpl().a(f);
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().b();
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        getImpl().b(f);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().c();
    }

    public void setCompatPressedTranslationZ(float f) {
        getImpl().c(f);
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public com.google.android.material.a.h getShowMotionSpec() {
        return getImpl().e();
    }

    public void setShowMotionSpec(com.google.android.material.a.h hVar) {
        getImpl().a(hVar);
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(com.google.android.material.a.h.a(getContext(), i));
    }

    public com.google.android.material.a.h getHideMotionSpec() {
        return getImpl().f();
    }

    public void setHideMotionSpec(com.google.android.material.a.h hVar) {
        getImpl().b(hVar);
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(com.google.android.material.a.h.a(getContext(), i));
    }

    private com.google.android.material.floatingactionbutton.a getImpl() {
        if (this.p == null) {
            this.p = d();
        }
        return this.p;
    }

    private com.google.android.material.floatingactionbutton.a d() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.google.android.material.floatingactionbutton.b(this, new b());
        }
        return new com.google.android.material.floatingactionbutton.a(this, new b());
    }

    /* compiled from: source */
    private class b implements com.google.android.material.h.b {
        b() {
        }

        @Override // com.google.android.material.h.b
        public float a() {
            return FloatingActionButton.this.getSizeDimension() / 2.0f;
        }

        @Override // com.google.android.material.h.b
        public void a(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.b.set(i, i2, i3, i4);
            FloatingActionButton.this.setPadding(i + FloatingActionButton.this.k, i2 + FloatingActionButton.this.k, i3 + FloatingActionButton.this.k, i4 + FloatingActionButton.this.k);
        }

        @Override // com.google.android.material.h.b
        public void a(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.h.b
        public boolean b() {
            return FloatingActionButton.this.a;
        }
    }
}
