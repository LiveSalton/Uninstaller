package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.x;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public class ChangeImageTransform extends Transition {
    private static final String[] a = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
    private static final TypeEvaluator<Matrix> i = new TypeEvaluator<Matrix>() { // from class: androidx.transition.ChangeImageTransform.1
        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            return null;
        }

        AnonymousClass1() {
        }
    };
    private static final Property<ImageView, Matrix> j = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") { // from class: androidx.transition.ChangeImageTransform.2
        @Override // android.util.Property
        /* renamed from: a */
        public Matrix get(ImageView imageView) {
            return null;
        }

        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(ImageView imageView, Matrix matrix) {
            k.a(imageView, matrix);
        }
    };

    /* compiled from: source */
    /* renamed from: androidx.transition.ChangeImageTransform$1 */
    static class AnonymousClass1 implements TypeEvaluator<Matrix> {
        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            return null;
        }

        AnonymousClass1() {
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.ChangeImageTransform$2 */
    static class AnonymousClass2 extends Property<ImageView, Matrix> {
        @Override // android.util.Property
        /* renamed from: a */
        public Matrix get(ImageView imageView) {
            return null;
        }

        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(ImageView imageView, Matrix matrix) {
            k.a(imageView, matrix);
        }
    }

    public ChangeImageTransform() {
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d(y yVar) {
        View view = yVar.b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            Map<String, Object> map = yVar.a;
            map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            map.put("android:changeImageTransform:matrix", b(imageView));
        }
    }

    @Override // androidx.transition.Transition
    public void a(y yVar) {
        d(yVar);
    }

    @Override // androidx.transition.Transition
    public void b(y yVar) {
        d(yVar);
    }

    @Override // androidx.transition.Transition
    public String[] a() {
        return a;
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, y yVar, y yVar2) {
        if (yVar == null || yVar2 == null) {
            return null;
        }
        Rect rect = (Rect) yVar.a.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) yVar2.a.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) yVar.a.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) yVar2.a.get("android:changeImageTransform:matrix");
        boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z) {
            return null;
        }
        ImageView imageView = (ImageView) yVar2.b;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return a(imageView);
        }
        if (matrix == null) {
            matrix = l.a;
        }
        if (matrix2 == null) {
            matrix2 = l.a;
        }
        j.set(imageView, matrix);
        return a(imageView, matrix, matrix2);
    }

    private ObjectAnimator a(ImageView imageView) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) j, (TypeEvaluator) i, (Object[]) new Matrix[]{l.a, l.a});
    }

    private ObjectAnimator a(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) j, (TypeEvaluator) new x.a(), (Object[]) new Matrix[]{matrix, matrix2});
    }

    private static Matrix b(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            switch (AnonymousClass3.a[imageView.getScaleType().ordinal()]) {
                case 1:
                    return c(imageView);
                case 2:
                    return d(imageView);
            }
        }
        return new Matrix(imageView.getImageMatrix());
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.ChangeImageTransform$3 */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static Matrix c(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(imageView.getWidth() / drawable.getIntrinsicWidth(), imageView.getHeight() / drawable.getIntrinsicHeight());
        return matrix;
    }

    private static Matrix d(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = imageView.getWidth();
        float f = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = imageView.getHeight();
        float f2 = intrinsicHeight;
        float max = Math.max(width / f, height / f2);
        int round = Math.round((width - (f * max)) / 2.0f);
        int round2 = Math.round((height - (f2 * max)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(max, max);
        matrix.postTranslate(round, round2);
        return matrix;
    }
}
