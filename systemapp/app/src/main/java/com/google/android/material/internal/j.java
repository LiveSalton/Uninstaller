package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.y;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public class j extends Transition {
    @Override // androidx.transition.Transition
    public void a(y yVar) {
        d(yVar);
    }

    @Override // androidx.transition.Transition
    public void b(y yVar) {
        d(yVar);
    }

    private void d(y yVar) {
        if (yVar.b instanceof TextView) {
            yVar.a.put("android:textscale:scale", Float.valueOf(((TextView) yVar.b).getScaleX()));
        }
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, y yVar, y yVar2) {
        if (yVar == null || yVar2 == null || !(yVar.b instanceof TextView) || !(yVar2.b instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) yVar2.b;
        Map<String, Object> map = yVar.a;
        Map<String, Object> map2 = yVar2.a;
        float floatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        float floatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (floatValue == floatValue2) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(floatValue, floatValue2);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.internal.j.1
            final /* synthetic */ TextView a;

            AnonymousClass1(TextView textView2) {
                textView = textView2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue3);
                textView.setScaleY(floatValue3);
            }
        });
        return ofFloat;
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.internal.j$1 */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ TextView a;

        AnonymousClass1(TextView textView2) {
            textView = textView2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            textView.setScaleX(floatValue3);
            textView.setScaleY(floatValue3);
        }
    }
}
