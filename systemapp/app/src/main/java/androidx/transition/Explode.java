package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.transition.p;

/* compiled from: source */
/* loaded from: classes.dex */
public class Explode extends Visibility {
    private static final TimeInterpolator a = new DecelerateInterpolator();
    private static final TimeInterpolator i = new AccelerateInterpolator();
    private int[] j;

    public Explode() {
        this.j = new int[2];
        a(new c());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new int[2];
        a(new c());
    }

    private void d(y yVar) {
        View view = yVar.b;
        view.getLocationOnScreen(this.j);
        int i2 = this.j[0];
        int i3 = this.j[1];
        yVar.a.put("android:explode:screenBounds", new Rect(i2, i3, view.getWidth() + i2, view.getHeight() + i3));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void a(y yVar) {
        super.a(yVar);
        d(yVar);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void b(y yVar) {
        super.b(yVar);
        d(yVar);
    }

    @Override // androidx.transition.Visibility
    public Animator a(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        if (yVar2 == null) {
            return null;
        }
        Rect rect = (Rect) yVar2.a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        a(viewGroup, rect, this.j);
        return aa.a(view, yVar2, rect.left, rect.top, translationX + this.j[0], translationY + this.j[1], translationX, translationY, a, this);
    }

    @Override // androidx.transition.Visibility
    public Animator b(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        float f;
        float f2;
        if (yVar == null) {
            return null;
        }
        Rect rect = (Rect) yVar.a.get("android:explode:screenBounds");
        int i2 = rect.left;
        int i3 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) yVar.b.getTag(p.a.transition_position);
        if (iArr != null) {
            f = (iArr[0] - rect.left) + translationX;
            f2 = (iArr[1] - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f = translationX;
            f2 = translationY;
        }
        a(viewGroup, rect, this.j);
        return aa.a(view, yVar, i2, i3, translationX, translationY, f + this.j[0], f2 + this.j[1], i, this);
    }

    private void a(View view, Rect rect, int[] iArr) {
        int centerY;
        int i2;
        view.getLocationOnScreen(this.j);
        int i3 = this.j[0];
        int i4 = this.j[1];
        Rect o = o();
        if (o == null) {
            i2 = (view.getWidth() / 2) + i3 + Math.round(view.getTranslationX());
            centerY = (view.getHeight() / 2) + i4 + Math.round(view.getTranslationY());
        } else {
            int centerX = o.centerX();
            centerY = o.centerY();
            i2 = centerX;
        }
        float centerX2 = rect.centerX() - i2;
        float centerY2 = rect.centerY() - centerY;
        if (centerX2 == 0.0f && centerY2 == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY2 = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float a2 = a(centerX2, centerY2);
        float a3 = a(view, i2 - i3, centerY - i4);
        iArr[0] = Math.round((centerX2 / a2) * a3);
        iArr[1] = Math.round(a3 * (centerY2 / a2));
    }

    private static float a(View view, int i2, int i3) {
        return a(Math.max(i2, view.getWidth() - i2), Math.max(i3, view.getHeight() - i3));
    }

    private static float a(float f, float f2) {
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }
}
