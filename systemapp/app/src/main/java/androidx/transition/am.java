package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
class am extends al {
    private static boolean a = true;

    am() {
    }

    @Override // androidx.transition.ap
    @SuppressLint({"NewApi"})
    public void a(View view, int i, int i2, int i3, int i4) {
        if (a) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
    }
}
