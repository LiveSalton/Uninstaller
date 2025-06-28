package com.github.ybq.android.spinkit.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.github.ybq.android.spinkit.b.f;

/* compiled from: source */
/* loaded from: classes.dex */
public class a {
    public static void a(Animator animator) {
        if (animator == null || animator.isStarted()) {
            return;
        }
        animator.start();
    }

    public static void a(f... fVarArr) {
        for (f fVar : fVarArr) {
            fVar.start();
        }
    }

    public static void b(f... fVarArr) {
        for (f fVar : fVarArr) {
            fVar.stop();
        }
    }

    public static boolean c(f... fVarArr) {
        for (f fVar : fVarArr) {
            if (fVar.isRunning()) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(ValueAnimator valueAnimator) {
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public static boolean b(ValueAnimator valueAnimator) {
        return valueAnimator != null && valueAnimator.isStarted();
    }
}
