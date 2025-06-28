package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: source */
/* loaded from: classes.dex */
public class ChangeClipBounds extends Transition {
    private static final String[] a = {"android:clipBounds:clip"};

    @Override // androidx.transition.Transition
    public String[] a() {
        return a;
    }

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d(y yVar) {
        View view = yVar.b;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect E = androidx.core.h.w.E(view);
        yVar.a.put("android:clipBounds:clip", E);
        if (E == null) {
            yVar.a.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
        }
    }

    @Override // androidx.transition.Transition
    public void a(y yVar) {
        d(yVar);
    }

    @Override // androidx.transition.Transition
    public void b(y yVar) {
        d(yVar);
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, y yVar, y yVar2) {
        if (yVar == null || yVar2 == null || !yVar.a.containsKey("android:clipBounds:clip") || !yVar2.a.containsKey("android:clipBounds:clip")) {
            return null;
        }
        Rect rect = (Rect) yVar.a.get("android:clipBounds:clip");
        Rect rect2 = (Rect) yVar2.a.get("android:clipBounds:clip");
        boolean z = rect2 == null;
        if (rect == null && rect2 == null) {
            return null;
        }
        if (rect == null) {
            rect = (Rect) yVar.a.get("android:clipBounds:bounds");
        } else if (rect2 == null) {
            rect2 = (Rect) yVar2.a.get("android:clipBounds:bounds");
        }
        if (rect.equals(rect2)) {
            return null;
        }
        androidx.core.h.w.a(yVar2.b, rect);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(yVar2.b, (Property<View, V>) aj.b, (TypeEvaluator) new q(new Rect()), (Object[]) new Rect[]{rect, rect2});
        if (z) {
            ofObject.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeClipBounds.1
                final /* synthetic */ View a;

                AnonymousClass1(View view) {
                    view = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    androidx.core.h.w.a(view, (Rect) null);
                }
            });
        }
        return ofObject;
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.ChangeClipBounds$1 */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ View a;

        AnonymousClass1(View view) {
            view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            androidx.core.h.w.a(view, (Rect) null);
        }
    }
}
