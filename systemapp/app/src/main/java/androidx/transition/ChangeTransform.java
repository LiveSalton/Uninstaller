package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.p;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: source */
/* loaded from: classes.dex */
public class ChangeTransform extends Transition {
    private static final String[] i = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    private static final Property<b, float[]> j = new Property<b, float[]>(float[].class, "nonTranslations") { // from class: androidx.transition.ChangeTransform.1
        @Override // android.util.Property
        /* renamed from: a */
        public float[] get(b bVar) {
            return null;
        }

        AnonymousClass1(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(b bVar, float[] fArr) {
            bVar.a(fArr);
        }
    };
    private static final Property<b, PointF> k = new Property<b, PointF>(PointF.class, "translations") { // from class: androidx.transition.ChangeTransform.2
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(b bVar) {
            return null;
        }

        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(b bVar, PointF pointF) {
            bVar.a(pointF);
        }
    };
    private static final boolean l;
    boolean a;
    private boolean m;
    private Matrix n;

    static {
        l = Build.VERSION.SDK_INT >= 21;
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.ChangeTransform$1 */
    static class AnonymousClass1 extends Property<b, float[]> {
        @Override // android.util.Property
        /* renamed from: a */
        public float[] get(b bVar) {
            return null;
        }

        AnonymousClass1(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(b bVar, float[] fArr) {
            bVar.a(fArr);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.ChangeTransform$2 */
    static class AnonymousClass2 extends Property<b, PointF> {
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(b bVar) {
            return null;
        }

        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(b bVar, PointF pointF) {
            bVar.a(pointF);
        }
    }

    public ChangeTransform() {
        this.a = true;
        this.m = true;
        this.n = new Matrix();
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        this.m = true;
        this.n = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.a = androidx.core.content.a.g.a(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.m = androidx.core.content.a.g.a(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.transition.Transition
    public String[] a() {
        return i;
    }

    private void d(y yVar) {
        View view = yVar.b;
        if (view.getVisibility() == 8) {
            return;
        }
        yVar.a.put("android:changeTransform:parent", view.getParent());
        yVar.a.put("android:changeTransform:transforms", new c(view));
        Matrix matrix = view.getMatrix();
        yVar.a.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.m) {
            Matrix matrix2 = new Matrix();
            aj.a((ViewGroup) view.getParent(), matrix2);
            matrix2.preTranslate(-r2.getScrollX(), -r2.getScrollY());
            yVar.a.put("android:changeTransform:parentMatrix", matrix2);
            yVar.a.put("android:changeTransform:intermediateMatrix", view.getTag(p.a.transition_transform));
            yVar.a.put("android:changeTransform:intermediateParentMatrix", view.getTag(p.a.parent_matrix));
        }
    }

    @Override // androidx.transition.Transition
    public void a(y yVar) {
        d(yVar);
        if (l) {
            return;
        }
        ((ViewGroup) yVar.b.getParent()).startViewTransition(yVar.b);
    }

    @Override // androidx.transition.Transition
    public void b(y yVar) {
        d(yVar);
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, y yVar, y yVar2) {
        if (yVar == null || yVar2 == null || !yVar.a.containsKey("android:changeTransform:parent") || !yVar2.a.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) yVar.a.get("android:changeTransform:parent");
        boolean z = this.m && !a(viewGroup2, (ViewGroup) yVar2.a.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) yVar.a.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            yVar.a.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) yVar.a.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            yVar.a.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z) {
            b(yVar, yVar2);
        }
        ObjectAnimator a2 = a(yVar, yVar2, z);
        if (z && a2 != null && this.a) {
            b(viewGroup, yVar, yVar2);
        } else if (!l) {
            viewGroup2.endViewTransition(yVar.b);
        }
        return a2;
    }

    private ObjectAnimator a(y yVar, y yVar2, boolean z) {
        Matrix matrix = (Matrix) yVar.a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) yVar2.a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = l.a;
        }
        if (matrix2 == null) {
            matrix2 = l.a;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        c cVar = (c) yVar2.a.get("android:changeTransform:transforms");
        View view = yVar2.b;
        a(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        b bVar = new b(view, fArr);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bVar, PropertyValuesHolder.ofObject(j, new d(new float[9]), fArr, fArr2), o.a(k, m().a(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        AnonymousClass3 anonymousClass3 = new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeTransform.3
            final /* synthetic */ boolean a;
            final /* synthetic */ Matrix b;
            final /* synthetic */ View c;
            final /* synthetic */ c d;
            final /* synthetic */ b e;
            private boolean g;
            private Matrix h = new Matrix();

            AnonymousClass3(boolean z2, Matrix matrix32, View view2, c cVar2, b bVar2) {
                z = z2;
                matrix3 = matrix32;
                view = view2;
                cVar = cVar2;
                bVar = bVar2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.g = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.g) {
                    if (z && ChangeTransform.this.a) {
                        a(matrix3);
                    } else {
                        view.setTag(p.a.transition_transform, null);
                        view.setTag(p.a.parent_matrix, null);
                    }
                }
                aj.c(view, null);
                cVar.a(view);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator) {
                a(bVar.a());
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(Animator animator) {
                ChangeTransform.a(view);
            }

            private void a(Matrix matrix4) {
                this.h.set(matrix4);
                view.setTag(p.a.transition_transform, this.h);
                cVar.a(view);
            }
        };
        ofPropertyValuesHolder.addListener(anonymousClass3);
        androidx.transition.a.a(ofPropertyValuesHolder, anonymousClass3);
        return ofPropertyValuesHolder;
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.ChangeTransform$3 */
    class AnonymousClass3 extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;
        final /* synthetic */ Matrix b;
        final /* synthetic */ View c;
        final /* synthetic */ c d;
        final /* synthetic */ b e;
        private boolean g;
        private Matrix h = new Matrix();

        AnonymousClass3(boolean z2, Matrix matrix32, View view2, c cVar2, b bVar2) {
            z = z2;
            matrix3 = matrix32;
            view = view2;
            cVar = cVar2;
            bVar = bVar2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.g = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.g) {
                if (z && ChangeTransform.this.a) {
                    a(matrix3);
                } else {
                    view.setTag(p.a.transition_transform, null);
                    view.setTag(p.a.parent_matrix, null);
                }
            }
            aj.c(view, null);
            cVar.a(view);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            a(bVar.a());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            ChangeTransform.a(view);
        }

        private void a(Matrix matrix4) {
            this.h.set(matrix4);
            view.setTag(p.a.transition_transform, this.h);
            cVar.a(view);
        }
    }

    private boolean a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (b(viewGroup) && b(viewGroup2)) {
            y b2 = b((View) viewGroup, true);
            if (b2 == null || viewGroup2 != b2.b) {
                return false;
            }
        } else if (viewGroup != viewGroup2) {
            return false;
        }
        return true;
    }

    private void b(ViewGroup viewGroup, y yVar, y yVar2) {
        View view = yVar2.b;
        Matrix matrix = new Matrix((Matrix) yVar2.a.get("android:changeTransform:parentMatrix"));
        aj.b(viewGroup, matrix);
        f a2 = j.a(view, viewGroup, matrix);
        if (a2 == null) {
            return;
        }
        a2.a((ViewGroup) yVar.a.get("android:changeTransform:parent"), yVar.b);
        Transition transition = this;
        while (transition.e != null) {
            transition = transition.e;
        }
        transition.a(new a(view, a2));
        if (l) {
            if (yVar.b != yVar2.b) {
                aj.a(yVar.b, 0.0f);
            }
            aj.a(view, 1.0f);
        }
    }

    private void b(y yVar, y yVar2) {
        Matrix matrix = (Matrix) yVar2.a.get("android:changeTransform:parentMatrix");
        yVar2.b.setTag(p.a.parent_matrix, matrix);
        Matrix matrix2 = this.n;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) yVar.a.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            yVar.a.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) yVar.a.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }

    static void a(View view) {
        a(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    static void a(View view, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
        androidx.core.h.w.b(view, f3);
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setRotationX(f6);
        view.setRotationY(f7);
        view.setRotation(f8);
    }

    /* compiled from: source */
    private static class c {
        final float a;
        final float b;
        final float c;
        final float d;
        final float e;
        final float f;
        final float g;
        final float h;

        c(View view) {
            this.a = view.getTranslationX();
            this.b = view.getTranslationY();
            this.c = androidx.core.h.w.q(view);
            this.d = view.getScaleX();
            this.e = view.getScaleY();
            this.f = view.getRotationX();
            this.g = view.getRotationY();
            this.h = view.getRotation();
        }

        public void a(View view) {
            ChangeTransform.a(view, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.a == this.a && cVar.b == this.b && cVar.c == this.c && cVar.d == this.d && cVar.e == this.e && cVar.f == this.f && cVar.g == this.g && cVar.h == this.h;
        }

        public int hashCode() {
            return (31 * (((((((((((((this.a != 0.0f ? Float.floatToIntBits(this.a) : 0) * 31) + (this.b != 0.0f ? Float.floatToIntBits(this.b) : 0)) * 31) + (this.c != 0.0f ? Float.floatToIntBits(this.c) : 0)) * 31) + (this.d != 0.0f ? Float.floatToIntBits(this.d) : 0)) * 31) + (this.e != 0.0f ? Float.floatToIntBits(this.e) : 0)) * 31) + (this.f != 0.0f ? Float.floatToIntBits(this.f) : 0)) * 31) + (this.g != 0.0f ? Float.floatToIntBits(this.g) : 0))) + (this.h != 0.0f ? Float.floatToIntBits(this.h) : 0);
        }
    }

    /* compiled from: source */
    private static class a extends u {
        private View a;
        private f b;

        a(View view, f fVar) {
            this.a = view;
            this.b = fVar;
        }

        @Override // androidx.transition.u, androidx.transition.Transition.c
        public void b(Transition transition) {
            transition.b(this);
            j.a(this.a);
            this.a.setTag(p.a.transition_transform, null);
            this.a.setTag(p.a.parent_matrix, null);
        }

        @Override // androidx.transition.u, androidx.transition.Transition.c
        public void c(Transition transition) {
            this.b.setVisibility(4);
        }

        @Override // androidx.transition.u, androidx.transition.Transition.c
        public void d(Transition transition) {
            this.b.setVisibility(0);
        }
    }

    /* compiled from: source */
    private static class b {
        private final Matrix a = new Matrix();
        private final View b;
        private final float[] c;
        private float d;
        private float e;

        b(View view, float[] fArr) {
            this.b = view;
            this.c = (float[]) fArr.clone();
            this.d = this.c[2];
            this.e = this.c[5];
            b();
        }

        void a(float[] fArr) {
            System.arraycopy(fArr, 0, this.c, 0, fArr.length);
            b();
        }

        void a(PointF pointF) {
            this.d = pointF.x;
            this.e = pointF.y;
            b();
        }

        private void b() {
            this.c[2] = this.d;
            this.c[5] = this.e;
            this.a.setValues(this.c);
            aj.c(this.b, this.a);
        }

        Matrix a() {
            return this.a;
        }
    }
}
