package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public final class i {
    private final ArrayList<a> b = new ArrayList<>();
    private a c = null;
    ValueAnimator a = null;
    private final Animator.AnimatorListener d = new AnimatorListenerAdapter() { // from class: com.google.android.material.internal.i.1
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (i.this.a == animator) {
                i.this.a = null;
            }
        }
    };

    /* compiled from: source */
    /* renamed from: com.google.android.material.internal.i$1 */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (i.this.a == animator) {
                i.this.a = null;
            }
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        a aVar = new a(iArr, valueAnimator);
        valueAnimator.addListener(this.d);
        this.b.add(aVar);
    }

    public void a(int[] iArr) {
        a aVar;
        int size = this.b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.b.get(i);
            if (StateSet.stateSetMatches(aVar.a, iArr)) {
                break;
            } else {
                i++;
            }
        }
        if (aVar == this.c) {
            return;
        }
        if (this.c != null) {
            b();
        }
        this.c = aVar;
        if (aVar != null) {
            a(aVar);
        }
    }

    private void a(a aVar) {
        this.a = aVar.b;
        this.a.start();
    }

    private void b() {
        if (this.a != null) {
            this.a.cancel();
            this.a = null;
        }
    }

    public void a() {
        if (this.a != null) {
            this.a.end();
            this.a = null;
        }
    }

    /* compiled from: source */
    static class a {
        final int[] a;
        final ValueAnimator b;

        a(int[] iArr, ValueAnimator valueAnimator) {
            this.a = iArr;
            this.b = valueAnimator;
        }
    }
}
