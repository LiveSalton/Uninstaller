package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.a.a;

/* compiled from: source */
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int a;
    private int b;
    private ViewPropertyAnimator c;

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        return i == 2;
    }

    public HideBottomViewOnScrollBehavior() {
        this.a = 0;
        this.b = 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = 2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.a = v.getMeasuredHeight();
        return super.a(coordinatorLayout, (CoordinatorLayout) v, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        if (this.b != 1 && i2 > 0) {
            b(v);
        } else {
            if (this.b == 2 || i2 >= 0) {
                return;
            }
            a((HideBottomViewOnScrollBehavior<V>) v);
        }
    }

    protected void a(V v) {
        if (this.c != null) {
            this.c.cancel();
            v.clearAnimation();
        }
        this.b = 2;
        a((HideBottomViewOnScrollBehavior<V>) v, 0, 225L, a.d);
    }

    protected void b(V v) {
        if (this.c != null) {
            this.c.cancel();
            v.clearAnimation();
        }
        this.b = 1;
        a((HideBottomViewOnScrollBehavior<V>) v, this.a, 175L, a.c);
    }

    private void a(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.c = v.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j).setListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.behavior.HideBottomViewOnScrollBehavior.1
            AnonymousClass1() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                HideBottomViewOnScrollBehavior.this.c = null;
            }
        });
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.behavior.HideBottomViewOnScrollBehavior$1 */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.c = null;
        }
    }
}
