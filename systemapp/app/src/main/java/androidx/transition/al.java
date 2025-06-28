package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
class al extends ak {
    private static boolean a = true;
    private static boolean b = true;
    private static boolean c = true;

    al() {
    }

    @Override // androidx.transition.ap
    @SuppressLint({"NewApi"})
    public void a(View view, Matrix matrix) {
        if (b) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                b = false;
            }
        }
    }

    @Override // androidx.transition.ap
    @SuppressLint({"NewApi"})
    public void b(View view, Matrix matrix) {
        if (c) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                c = false;
            }
        }
    }

    @Override // androidx.transition.ap
    @SuppressLint({"NewApi"})
    public void c(View view, Matrix matrix) {
        if (a) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
    }
}
