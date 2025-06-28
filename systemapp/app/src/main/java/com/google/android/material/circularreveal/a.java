package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import com.google.android.material.circularreveal.c;

/* compiled from: source */
/* loaded from: classes.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static Animator a(c cVar, float f, float f2, float f3) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(cVar, (Property<c, V>) c.b.a, (TypeEvaluator) c.a.a, (Object[]) new c.d[]{new c.d(f, f2, f3)});
        if (Build.VERSION.SDK_INT < 21) {
            return ofObject;
        }
        c.d revealInfo = cVar.getRevealInfo();
        if (revealInfo == null) {
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) cVar, (int) f, (int) f2, revealInfo.c, f3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofObject, createCircularReveal);
        return animatorSet;
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.circularreveal.a$1 */
    static class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c.this.s_();
        }
    }

    public static Animator.AnimatorListener a(c cVar) {
        return new AnimatorListenerAdapter() { // from class: com.google.android.material.circularreveal.a.1
            AnonymousClass1() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                c.this.a();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.s_();
            }
        };
    }
}
