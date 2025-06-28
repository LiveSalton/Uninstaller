package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.w;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.a;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.i.c;
import com.google.android.material.i.e;
import com.google.android.material.internal.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.a {
    AnimatorListenerAdapter e;
    private final int f;
    private final c g;
    private final a h;
    private Animator i;
    private Animator j;
    private Animator k;
    private int l;
    private boolean m;
    private boolean n;

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.bottomAppBarStyle);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = true;
        this.e = new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.7
            AnonymousClass7() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BottomAppBar.this.a(BottomAppBar.this.n);
                BottomAppBar.this.a(BottomAppBar.this.l, BottomAppBar.this.n);
            }
        };
        TypedArray a = k.a(context, attributeSet, a.k.BottomAppBar, i, a.j.Widget_MaterialComponents_BottomAppBar, new int[0]);
        ColorStateList a2 = com.google.android.material.f.a.a(context, a, a.k.BottomAppBar_backgroundTint);
        float dimensionPixelOffset = a.getDimensionPixelOffset(a.k.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = a.getDimensionPixelOffset(a.k.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = a.getDimensionPixelOffset(a.k.BottomAppBar_fabCradleVerticalOffset, 0);
        this.l = a.getInt(a.k.BottomAppBar_fabAlignmentMode, 0);
        this.m = a.getBoolean(a.k.BottomAppBar_hideOnScroll, false);
        a.recycle();
        this.f = getResources().getDimensionPixelOffset(a.d.mtrl_bottomappbar_fabOffsetEndMode);
        this.h = new a(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        e eVar = new e();
        eVar.a(this.h);
        this.g = new c(eVar);
        this.g.a(true);
        this.g.a(Paint.Style.FILL);
        androidx.core.graphics.drawable.a.a(this.g, a2);
        w.a(this, this.g);
    }

    public int getFabAlignmentMode() {
        return this.l;
    }

    public void setFabAlignmentMode(int i) {
        b(i);
        a(i, this.n);
        this.l = i;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.a(this.g, colorStateList);
    }

    public ColorStateList getBackgroundTint() {
        return this.g.a();
    }

    public float getFabCradleMargin() {
        return this.h.d();
    }

    public void setFabCradleMargin(float f) {
        if (f != getFabCradleMargin()) {
            this.h.d(f);
            this.g.invalidateSelf();
        }
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.h.e();
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            this.h.e(f);
            this.g.invalidateSelf();
        }
    }

    public float getCradleVerticalOffset() {
        return this.h.b();
    }

    public void setCradleVerticalOffset(float f) {
        if (f != getCradleVerticalOffset()) {
            this.h.b(f);
            this.g.invalidateSelf();
        }
    }

    public boolean getHideOnScroll() {
        return this.m;
    }

    public void setHideOnScroll(boolean z) {
        this.m = z;
    }

    void setFabDiameter(int i) {
        float f = i;
        if (f != this.h.c()) {
            this.h.c(f);
            this.g.invalidateSelf();
        }
    }

    private void b(int i) {
        if (this.l == i || !w.C(this)) {
            return;
        }
        if (this.j != null) {
            this.j.cancel();
        }
        ArrayList arrayList = new ArrayList();
        a(i, arrayList);
        b(i, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.j = animatorSet;
        this.j.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.1
            AnonymousClass1() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BottomAppBar.this.j = null;
            }
        });
        this.j.start();
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$1 */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.j = null;
        }
    }

    private void a(int i, List<Animator> list) {
        if (this.n) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.h.a(), c(i));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.2
                AnonymousClass2() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BottomAppBar.this.h.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    BottomAppBar.this.g.invalidateSelf();
                }
            });
            ofFloat.setDuration(300L);
            list.add(ofFloat);
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$2 */
    class AnonymousClass2 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass2() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BottomAppBar.this.h.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
            BottomAppBar.this.g.invalidateSelf();
        }
    }

    public FloatingActionButton m() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).d(this)) {
            if (view instanceof FloatingActionButton) {
                return (FloatingActionButton) view;
            }
        }
        return null;
    }

    private boolean n() {
        FloatingActionButton m = m();
        return m != null && m.b();
    }

    private void b(int i, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(m(), "translationX", c(i));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    public void a(int i, boolean z) {
        if (w.C(this)) {
            if (this.k != null) {
                this.k.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!n()) {
                i = 0;
                z = false;
            }
            a(i, z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.k = animatorSet;
            this.k.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.3
                AnonymousClass3() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    BottomAppBar.this.k = null;
                }
            });
            this.k.start();
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$3 */
    class AnonymousClass3 extends AnimatorListenerAdapter {
        AnonymousClass3() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.k = null;
        }
    }

    private void a(int i, boolean z, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if ((!this.n && (!z || !n())) || (this.l != 1 && i != 1)) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        } else {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            ofFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.4
                public boolean a;
                final /* synthetic */ ActionMenuView b;
                final /* synthetic */ int c;
                final /* synthetic */ boolean d;

                AnonymousClass4(ActionMenuView actionMenuView2, int i2, boolean z2) {
                    actionMenuView = actionMenuView2;
                    i = i2;
                    z = z2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.a = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.a) {
                        return;
                    }
                    BottomAppBar.this.a(actionMenuView, i, z);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$4 */
    class AnonymousClass4 extends AnimatorListenerAdapter {
        public boolean a;
        final /* synthetic */ ActionMenuView b;
        final /* synthetic */ int c;
        final /* synthetic */ boolean d;

        AnonymousClass4(ActionMenuView actionMenuView2, int i2, boolean z2) {
            actionMenuView = actionMenuView2;
            i = i2;
            z = z2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            BottomAppBar.this.a(actionMenuView, i, z);
        }
    }

    public void a(boolean z) {
        if (w.C(this)) {
            if (this.i != null) {
                this.i.cancel();
            }
            ArrayList arrayList = new ArrayList();
            a(z && n(), arrayList);
            b(z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.i = animatorSet;
            this.i.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.5
                AnonymousClass5() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    BottomAppBar.this.i = null;
                }
            });
            this.i.start();
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$5 */
    class AnonymousClass5 extends AnimatorListenerAdapter {
        AnonymousClass5() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.i = null;
        }
    }

    private void a(boolean z, List<Animator> list) {
        if (z) {
            this.h.a(getFabTranslationX());
        }
        float[] fArr = new float[2];
        fArr[0] = this.g.b();
        fArr[1] = z ? 1.0f : 0.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.6
            AnonymousClass6() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BottomAppBar.this.g.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$6 */
    class AnonymousClass6 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass6() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BottomAppBar.this.g.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    private void b(boolean z, List<Animator> list) {
        FloatingActionButton m = m();
        if (m == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(m, "translationY", b(z));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    private float b(boolean z) {
        FloatingActionButton m = m();
        if (m == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        m.a(rect);
        float height = rect.height();
        if (height == 0.0f) {
            height = m.getMeasuredHeight();
        }
        float height2 = m.getHeight() - rect.bottom;
        float height3 = m.getHeight() - rect.height();
        float f = (-getCradleVerticalOffset()) + (height / 2.0f) + height2;
        float paddingBottom = height3 - m.getPaddingBottom();
        float f2 = -getMeasuredHeight();
        if (z) {
            paddingBottom = f;
        }
        return f2 + paddingBottom;
    }

    public float getFabTranslationY() {
        return b(this.n);
    }

    private int c(int i) {
        boolean z = w.h(this) == 1;
        if (i == 1) {
            return ((getMeasuredWidth() / 2) - this.f) * (z ? -1 : 1);
        }
        return 0;
    }

    private float getFabTranslationX() {
        return c(this.l);
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    public void a(ActionMenuView actionMenuView, int i, boolean z) {
        boolean z2 = w.h(this) == 1;
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).a & 8388615) == 8388611) {
                i2 = Math.max(i2, z2 ? childAt.getLeft() : childAt.getRight());
            }
        }
        actionMenuView.setTranslationX((i == 1 && z) ? i2 - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft()) : 0.0f);
    }

    private void o() {
        if (this.i != null) {
            this.i.cancel();
        }
        if (this.k != null) {
            this.k.cancel();
        }
        if (this.j != null) {
            this.j.cancel();
        }
    }

    public boolean p() {
        return (this.i != null && this.i.isRunning()) || (this.k != null && this.k.isRunning()) || (this.j != null && this.j.isRunning());
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        o();
        q();
    }

    public void q() {
        this.h.a(getFabTranslationX());
        FloatingActionButton m = m();
        this.g.a((this.n && n()) ? 1.0f : 0.0f);
        if (m != null) {
            m.setTranslationY(getFabTranslationY());
            m.setTranslationX(getFabTranslationX());
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (!n()) {
                a(actionMenuView, 0, false);
            } else {
                a(actionMenuView, this.l, this.n);
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$7 */
    class AnonymousClass7 extends AnimatorListenerAdapter {
        AnonymousClass7() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.a(BottomAppBar.this.n);
            BottomAppBar.this.a(BottomAppBar.this.l, BottomAppBar.this.n);
        }
    }

    public void a(FloatingActionButton floatingActionButton) {
        b(floatingActionButton);
        floatingActionButton.c(this.e);
        floatingActionButton.a(this.e);
    }

    private void b(FloatingActionButton floatingActionButton) {
        floatingActionButton.d(this.e);
        floatingActionButton.b(this.e);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.a
    public CoordinatorLayout.Behavior<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    /* compiled from: source */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        private final Rect a;

        public Behavior() {
            this.a = new Rect();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = new Rect();
        }

        private boolean a(FloatingActionButton floatingActionButton, BottomAppBar bottomAppBar) {
            ((CoordinatorLayout.d) floatingActionButton.getLayoutParams()).d = 17;
            bottomAppBar.a(floatingActionButton);
            return true;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            FloatingActionButton m = bottomAppBar.m();
            if (m != null) {
                a(m, bottomAppBar);
                m.b(this.a);
                bottomAppBar.setFabDiameter(this.a.height());
            }
            if (!bottomAppBar.p()) {
                bottomAppBar.q();
            }
            coordinatorLayout.b(bottomAppBar, i);
            return super.a(coordinatorLayout, (CoordinatorLayout) bottomAppBar, i);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.a(coordinatorLayout, (CoordinatorLayout) bottomAppBar, view, view2, i, i2);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        public void a(BottomAppBar bottomAppBar) {
            super.a((Behavior) bottomAppBar);
            FloatingActionButton m = bottomAppBar.m();
            if (m != null) {
                m.clearAnimation();
                m.animate().translationY(bottomAppBar.getFabTranslationY()).setInterpolator(com.google.android.material.a.a.d).setDuration(225L);
            }
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        public void b(BottomAppBar bottomAppBar) {
            super.b((Behavior) bottomAppBar);
            FloatingActionButton m = bottomAppBar.m();
            if (m != null) {
                m.a(this.a);
                float measuredHeight = m.getMeasuredHeight() - this.a.height();
                m.clearAnimation();
                m.animate().translationY((-m.getPaddingBottom()) + measuredHeight).setInterpolator(com.google.android.material.a.a.c).setDuration(175L);
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.l;
        savedState.b = this.n;
        return savedState;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.l = savedState.a;
        this.n = savedState.b;
    }

    /* compiled from: source */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomappbar.BottomAppBar.SavedState.1
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
        boolean b;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
            this.b = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b ? 1 : 0);
        }

        /* compiled from: source */
        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$SavedState$1 */
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
