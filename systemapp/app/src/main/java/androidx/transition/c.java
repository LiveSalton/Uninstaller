package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* compiled from: source */
/* loaded from: classes.dex */
public class c extends aq {
    private float a = 3.0f;

    @Override // androidx.transition.w
    public long a(ViewGroup viewGroup, Transition transition, y yVar, y yVar2) {
        int i;
        int round;
        int i2;
        if (yVar == null && yVar2 == null) {
            return 0L;
        }
        if (yVar2 == null || b(yVar) == 0) {
            i = -1;
        } else {
            yVar = yVar2;
            i = 1;
        }
        int c = c(yVar);
        int d = d(yVar);
        Rect o = transition.o();
        if (o != null) {
            i2 = o.centerX();
            round = o.centerY();
        } else {
            viewGroup.getLocationOnScreen(new int[2]);
            int round2 = Math.round(r5[0] + (viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
            round = Math.round(r5[1] + (viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
            i2 = round2;
        }
        float a = a(c, d, i2, round) / a(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long b = transition.b();
        if (b < 0) {
            b = 300;
        }
        return Math.round(((b * i) / this.a) * a);
    }

    private static float a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }
}
