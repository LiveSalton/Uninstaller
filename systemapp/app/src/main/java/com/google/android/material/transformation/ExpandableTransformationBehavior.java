package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    private AnimatorSet a;

    protected abstract AnimatorSet b(View view, View view2, boolean z, boolean z2);

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    protected boolean a(View view, View view2, boolean z, boolean z2) {
        boolean z3 = this.a != null;
        if (z3) {
            this.a.cancel();
        }
        this.a = b(view, view2, z, z3);
        this.a.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.ExpandableTransformationBehavior.1
            AnonymousClass1() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ExpandableTransformationBehavior.this.a = null;
            }
        });
        this.a.start();
        if (!z2) {
            this.a.end();
        }
        return true;
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.transformation.ExpandableTransformationBehavior$1 */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandableTransformationBehavior.this.a = null;
        }
    }
}
