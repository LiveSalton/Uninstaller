package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import java.lang.reflect.Field;

/* compiled from: source */
/* loaded from: classes.dex */
class k {
    private static boolean a = true;
    private static Field b;
    private static boolean c;

    static void a(ImageView imageView, Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 29) {
            imageView.animateTransform(matrix);
            return;
        }
        if (matrix == null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
                imageView.invalidate();
                return;
            }
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            b(imageView, matrix);
            return;
        }
        Drawable drawable2 = imageView.getDrawable();
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            Matrix matrix2 = null;
            a();
            if (b != null) {
                try {
                    Matrix matrix3 = (Matrix) b.get(imageView);
                    if (matrix3 == null) {
                        try {
                            matrix2 = new Matrix();
                            b.set(imageView, matrix2);
                        } catch (IllegalAccessException unused) {
                        }
                    }
                    matrix2 = matrix3;
                } catch (IllegalAccessException unused2) {
                }
            }
            if (matrix2 != null) {
                matrix2.set(matrix);
            }
            imageView.invalidate();
        }
    }

    @SuppressLint({"NewApi"})
    private static void b(ImageView imageView, Matrix matrix) {
        if (a) {
            try {
                imageView.animateTransform(matrix);
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
    }

    private static void a() {
        if (c) {
            return;
        }
        try {
            b = ImageView.class.getDeclaredField("mDrawMatrix");
            b.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        c = true;
    }
}
