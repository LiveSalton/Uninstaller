package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;
import androidx.transition.Transition;
import androidx.transition.p;

/* compiled from: source */
/* loaded from: classes.dex */
class aa {
    static Animator a(View view, y yVar, int i, int i2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator, Transition transition) {
        float f5;
        float f6;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) yVar.b.getTag(p.a.transition_position)) != null) {
            f5 = (r8[0] - i) + translationX;
            f6 = (r8[1] - i2) + translationY;
        } else {
            f5 = f;
            f6 = f2;
        }
        int round = i + Math.round(f5 - translationX);
        int round2 = i2 + Math.round(f6 - translationY);
        view.setTranslationX(f5);
        view.setTranslationY(f6);
        if (f5 == f3 && f6 == f4) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f5, f3), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f6, f4));
        a aVar = new a(view, yVar.b, round, round2, translationX, translationY);
        transition.a(aVar);
        ofPropertyValuesHolder.addListener(aVar);
        androidx.transition.a.a(ofPropertyValuesHolder, aVar);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }

    /* compiled from: source */
    private static class a extends AnimatorListenerAdapter implements Transition.c {
        private final View a;
        private final View b;
        private final int c;
        private final int d;
        private int[] e;
        private float f;
        private float g;
        private final float h;
        private final float i;

        @Override // androidx.transition.Transition.c
        public void a(Transition transition) {
        }

        @Override // androidx.transition.Transition.c
        public void c(Transition transition) {
        }

        @Override // androidx.transition.Transition.c
        public void d(Transition transition) {
        }

        @Override // androidx.transition.Transition.c
        public void e(Transition transition) {
        }

        a(View view, View view2, int i, int i2, float f, float f2) {
            this.b = view;
            this.a = view2;
            this.c = i - Math.round(this.b.getTranslationX());
            this.d = i2 - Math.round(this.b.getTranslationY());
            this.h = f;
            this.i = f2;
            this.e = (int[]) this.a.getTag(p.a.transition_position);
            if (this.e != null) {
                this.a.setTag(p.a.transition_position, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.e == null) {
                this.e = new int[2];
            }
            this.e[0] = Math.round(this.c + this.b.getTranslationX());
            this.e[1] = Math.round(this.d + this.b.getTranslationY());
            this.a.setTag(p.a.transition_position, this.e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f = this.b.getTranslationX();
            this.g = this.b.getTranslationY();
            this.b.setTranslationX(this.h);
            this.b.setTranslationY(this.i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.b.setTranslationX(this.f);
            this.b.setTranslationY(this.g);
        }

        @Override // androidx.transition.Transition.c
        public void b(Transition transition) {
            this.b.setTranslationX(this.h);
            this.b.setTranslationY(this.i);
            transition.b(this);
        }
    }
}
