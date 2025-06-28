package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
class ak extends ap {
    private static boolean a = true;

    @Override // androidx.transition.ap
    public void b(View view) {
    }

    @Override // androidx.transition.ap
    public void c(View view) {
    }

    ak() {
    }

    @Override // androidx.transition.ap
    @SuppressLint({"NewApi"})
    public void a(View view, float f) {
        if (a) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
        view.setAlpha(f);
    }

    @Override // androidx.transition.ap
    @SuppressLint({"NewApi"})
    public float a(View view) {
        if (a) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
        return view.getAlpha();
    }
}
