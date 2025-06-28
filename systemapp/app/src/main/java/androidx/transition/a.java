package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
class a {

    /* compiled from: source */
    /* renamed from: androidx.transition.a$a */
    interface InterfaceC0049a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    static void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(animatorListenerAdapter);
        }
    }

    static void a(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof InterfaceC0049a) {
                    ((InterfaceC0049a) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }

    static void b(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.resume();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof InterfaceC0049a) {
                    ((InterfaceC0049a) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }
}
