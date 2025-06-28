package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
class an extends am {
    private static boolean a = true;

    an() {
    }

    @Override // androidx.transition.ap
    @SuppressLint({"NewApi"})
    public void a(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.a(view, i);
        } else if (a) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
    }
}
