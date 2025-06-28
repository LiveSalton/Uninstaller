package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: source */
/* loaded from: classes.dex */
public class Fade extends Visibility {
    public Fade(int i) {
        b(i);
    }

    public Fade() {
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.f);
        b(androidx.core.content.a.g.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "fadingMode", 0, s()));
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void a(y yVar) {
        super.a(yVar);
        yVar.a.put("android:fade:transitionAlpha", Float.valueOf(aj.c(yVar.b)));
    }

    private Animator a(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        aj.a(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, aj.a, f2);
        ofFloat.addListener(new a(view));
        a(new u() { // from class: androidx.transition.Fade.1
            final /* synthetic */ View a;

            AnonymousClass1(View view2) {
                view = view2;
            }

            @Override // androidx.transition.u, androidx.transition.Transition.c
            public void b(Transition transition) {
                aj.a(view, 1.0f);
                aj.e(view);
                transition.b(this);
            }
        });
        return ofFloat;
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.Fade$1 */
    class AnonymousClass1 extends u {
        final /* synthetic */ View a;

        AnonymousClass1(View view2) {
            view = view2;
        }

        @Override // androidx.transition.u, androidx.transition.Transition.c
        public void b(Transition transition) {
            aj.a(view, 1.0f);
            aj.e(view);
            transition.b(this);
        }
    }

    @Override // androidx.transition.Visibility
    public Animator a(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        float a2 = a(yVar, 0.0f);
        return a(view, a2 != 1.0f ? a2 : 0.0f, 1.0f);
    }

    @Override // androidx.transition.Visibility
    public Animator b(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        aj.d(view);
        return a(view, a(yVar, 1.0f), 0.0f);
    }

    private static float a(y yVar, float f) {
        Float f2;
        return (yVar == null || (f2 = (Float) yVar.a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    /* compiled from: source */
    private static class a extends AnimatorListenerAdapter {
        private final View a;
        private boolean b = false;

        a(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (androidx.core.h.w.w(this.a) && this.a.getLayerType() == 0) {
                this.b = true;
                this.a.setLayerType(2, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            aj.a(this.a, 1.0f);
            if (this.b) {
                this.a.setLayerType(0, null);
            }
        }
    }
}
