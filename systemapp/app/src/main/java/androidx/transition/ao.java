package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
class ao extends an {
    ao() {
    }

    @Override // androidx.transition.ak, androidx.transition.ap
    public void a(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // androidx.transition.ak, androidx.transition.ap
    public float a(View view) {
        return view.getTransitionAlpha();
    }

    @Override // androidx.transition.an, androidx.transition.ap
    public void a(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // androidx.transition.am, androidx.transition.ap
    public void a(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // androidx.transition.al, androidx.transition.ap
    public void a(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // androidx.transition.al, androidx.transition.ap
    public void b(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    @Override // androidx.transition.al, androidx.transition.ap
    public void c(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }
}
