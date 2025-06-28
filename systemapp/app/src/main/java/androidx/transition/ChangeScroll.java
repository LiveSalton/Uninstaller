package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: source */
/* loaded from: classes.dex */
public class ChangeScroll extends Transition {
    private static final String[] a = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
    public String[] a() {
        return a;
    }

    private void d(y yVar) {
        yVar.a.put("android:changeScroll:x", Integer.valueOf(yVar.b.getScrollX()));
        yVar.a.put("android:changeScroll:y", Integer.valueOf(yVar.b.getScrollY()));
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, y yVar, y yVar2) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = null;
        if (yVar == null || yVar2 == null) {
            return null;
        }
        View view = yVar2.b;
        int intValue = ((Integer) yVar.a.get("android:changeScroll:x")).intValue();
        int intValue2 = ((Integer) yVar2.a.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) yVar.a.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) yVar2.a.get("android:changeScroll:y")).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            objectAnimator = ObjectAnimator.ofInt(view, "scrollX", intValue, intValue2);
        } else {
            objectAnimator = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            objectAnimator2 = ObjectAnimator.ofInt(view, "scrollY", intValue3, intValue4);
        }
        return x.a(objectAnimator, objectAnimator2);
    }
}
