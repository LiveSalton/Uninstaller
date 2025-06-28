package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import androidx.transition.p;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: source */
/* loaded from: classes.dex */
class ap {
    private static Method a;
    private static boolean b;
    private static Field c;
    private static boolean d;
    private float[] e;

    ap() {
    }

    public void a(View view, float f) {
        Float f2 = (Float) view.getTag(p.a.save_non_transition_alpha);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f);
        } else {
            view.setAlpha(f);
        }
    }

    public float a(View view) {
        Float f = (Float) view.getTag(p.a.save_non_transition_alpha);
        if (f != null) {
            return view.getAlpha() / f.floatValue();
        }
        return view.getAlpha();
    }

    public void b(View view) {
        if (view.getTag(p.a.save_non_transition_alpha) == null) {
            view.setTag(p.a.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    public void c(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(p.a.save_non_transition_alpha, null);
        }
    }

    public void a(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            a((View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    public void b(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            b((View) parent, matrix);
            matrix.postTranslate(r0.getScrollX(), r0.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }

    public void c(View view, Matrix matrix) {
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX(view.getWidth() / 2);
            view.setPivotY(view.getHeight() / 2);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.e;
        if (fArr == null) {
            fArr = new float[9];
            this.e = fArr;
        }
        matrix.getValues(fArr);
        float f = fArr[3];
        float sqrt = ((float) Math.sqrt(1.0f - (f * f))) * (fArr[0] < 0.0f ? -1 : 1);
        float degrees = (float) Math.toDegrees(Math.atan2(f, sqrt));
        float f2 = fArr[0] / sqrt;
        float f3 = fArr[4] / sqrt;
        float f4 = fArr[2];
        float f5 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f4);
        view.setTranslationY(f5);
        view.setRotation(degrees);
        view.setScaleX(f2);
        view.setScaleY(f3);
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        a();
        if (a != null) {
            try {
                a.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    public void a(View view, int i) {
        if (!d) {
            try {
                c = View.class.getDeclaredField("mViewFlags");
                c.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            d = true;
        }
        if (c != null) {
            try {
                c.setInt(view, i | (c.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    private void a() {
        if (b) {
            return;
        }
        try {
            a = View.class.getDeclaredMethod("setFrame", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            a.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", e);
        }
        b = true;
    }
}
