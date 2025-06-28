package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* compiled from: source */
/* loaded from: classes.dex */
class q implements TypeEvaluator<Rect> {
    private Rect a;

    q() {
    }

    q(Rect rect) {
        this.a = rect;
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        int i = rect.left + ((int) ((rect2.left - rect.left) * f));
        int i2 = rect.top + ((int) ((rect2.top - rect.top) * f));
        int i3 = rect.right + ((int) ((rect2.right - rect.right) * f));
        int i4 = rect.bottom + ((int) ((rect2.bottom - rect.bottom) * f));
        if (this.a == null) {
            return new Rect(i, i2, i3, i4);
        }
        this.a.set(i, i2, i3, i4);
        return this.a;
    }
}
