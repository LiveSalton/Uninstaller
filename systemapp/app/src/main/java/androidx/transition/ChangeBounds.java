package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: source */
/* loaded from: classes.dex */
public class ChangeBounds extends Transition {
    private static final String[] a = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> i = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") { // from class: androidx.transition.ChangeBounds.1
        private Rect a = new Rect();

        AnonymousClass1(Class cls, String str) {
            super(cls, str);
            this.a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.a);
            this.a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.a);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.a);
            return new PointF(this.a.left, this.a.top);
        }
    };
    private static final Property<a, PointF> j = new Property<a, PointF>(PointF.class, "topLeft") { // from class: androidx.transition.ChangeBounds.3
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(a aVar) {
            return null;
        }

        AnonymousClass3(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(a aVar, PointF pointF) {
            aVar.a(pointF);
        }
    };
    private static final Property<a, PointF> k = new Property<a, PointF>(PointF.class, "bottomRight") { // from class: androidx.transition.ChangeBounds.4
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(a aVar) {
            return null;
        }

        AnonymousClass4(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(a aVar, PointF pointF) {
            aVar.b(pointF);
        }
    };
    private static final Property<View, PointF> l = new Property<View, PointF>(PointF.class, "bottomRight") { // from class: androidx.transition.ChangeBounds.5
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        AnonymousClass5(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, PointF pointF) {
            aj.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    private static final Property<View, PointF> m = new Property<View, PointF>(PointF.class, "topLeft") { // from class: androidx.transition.ChangeBounds.6
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        AnonymousClass6(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, PointF pointF) {
            aj.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    private static final Property<View, PointF> n = new Property<View, PointF>(PointF.class, "position") { // from class: androidx.transition.ChangeBounds.7
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        AnonymousClass7(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            aj.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };
    private static q r = new q();
    private int[] o;
    private boolean p;
    private boolean q;

    /* compiled from: source */
    /* renamed from: androidx.transition.ChangeBounds$1 */
    static class AnonymousClass1 extends Property<Drawable, PointF> {
        private Rect a = new Rect();

        AnonymousClass1(Class cls, String str) {
            super(cls, str);
            this.a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.a);
            this.a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.a);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.a);
            return new PointF(this.a.left, this.a.top);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.ChangeBounds$3 */
    static class AnonymousClass3 extends Property<a, PointF> {
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(a aVar) {
            return null;
        }

        AnonymousClass3(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(a aVar, PointF pointF) {
            aVar.a(pointF);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.ChangeBounds$4 */
    static class AnonymousClass4 extends Property<a, PointF> {
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(a aVar) {
            return null;
        }

        AnonymousClass4(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(a aVar, PointF pointF) {
            aVar.b(pointF);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.ChangeBounds$5 */
    static class AnonymousClass5 extends Property<View, PointF> {
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        AnonymousClass5(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, PointF pointF) {
            aj.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.ChangeBounds$6 */
    static class AnonymousClass6 extends Property<View, PointF> {
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        AnonymousClass6(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, PointF pointF) {
            aj.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.ChangeBounds$7 */
    static class AnonymousClass7 extends Property<View, PointF> {
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        AnonymousClass7(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            aj.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    public ChangeBounds() {
        this.o = new int[2];
        this.p = false;
        this.q = false;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = new int[2];
        this.p = false;
        this.q = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.d);
        boolean a2 = androidx.core.content.a.g.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        a(a2);
    }

    @Override // androidx.transition.Transition
    public String[] a() {
        return a;
    }

    public void a(boolean z) {
        this.p = z;
    }

    private void d(y yVar) {
        View view = yVar.b;
        if (!androidx.core.h.w.C(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        yVar.a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        yVar.a.put("android:changeBounds:parent", yVar.b.getParent());
        if (this.q) {
            yVar.b.getLocationInWindow(this.o);
            yVar.a.put("android:changeBounds:windowX", Integer.valueOf(this.o[0]));
            yVar.a.put("android:changeBounds:windowY", Integer.valueOf(this.o[1]));
        }
        if (this.p) {
            yVar.a.put("android:changeBounds:clip", androidx.core.h.w.E(view));
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

    private boolean a(View view, View view2) {
        if (!this.q) {
            return true;
        }
        y b = b(view, true);
        if (b == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == b.b) {
            return true;
        }
        return false;
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, y yVar, y yVar2) {
        int i2;
        View view;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator a2;
        if (yVar == null || yVar2 == null) {
            return null;
        }
        Map<String, Object> map = yVar.a;
        Map<String, Object> map2 = yVar2.a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = yVar2.b;
        if (a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) yVar.a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) yVar2.a.get("android:changeBounds:bounds");
            int i4 = rect2.left;
            int i5 = rect3.left;
            int i6 = rect2.top;
            int i7 = rect3.top;
            int i8 = rect2.right;
            int i9 = rect3.right;
            int i10 = rect2.bottom;
            int i11 = rect3.bottom;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            Rect rect4 = (Rect) yVar.a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) yVar2.a.get("android:changeBounds:clip");
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i2 = 0;
            } else {
                i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (i8 != i9 || i10 != i11) {
                    i2++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i2++;
            }
            if (i2 <= 0) {
                return null;
            }
            if (!this.p) {
                view = view2;
                aj.a(view, i4, i6, i8, i10);
                if (i2 == 2) {
                    if (i12 == i14 && i13 == i15) {
                        a2 = m.a(view, n, m().a(i4, i6, i5, i7));
                    } else {
                        a aVar = new a(view);
                        ObjectAnimator a3 = m.a(aVar, j, m().a(i4, i6, i5, i7));
                        ObjectAnimator a4 = m.a(aVar, k, m().a(i8, i10, i9, i11));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(a3, a4);
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.8
                            final /* synthetic */ a a;
                            private a mViewBounds;

                            AnonymousClass8(a aVar2) {
                                aVar = aVar2;
                                this.mViewBounds = aVar;
                            }
                        });
                        a2 = animatorSet;
                    }
                } else if (i4 != i5 || i6 != i7) {
                    a2 = m.a(view, m, m().a(i4, i6, i5, i7));
                } else {
                    a2 = m.a(view, l, m().a(i8, i10, i9, i11));
                }
            } else {
                view = view2;
                aj.a(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                ObjectAnimator a5 = (i4 == i5 && i6 == i7) ? null : m.a(view, n, m().a(i4, i6, i5, i7));
                if (rect4 == null) {
                    i3 = 0;
                    rect = new Rect(0, 0, i12, i13);
                } else {
                    i3 = 0;
                    rect = rect4;
                }
                Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
                if (rect.equals(rect6)) {
                    objectAnimator = null;
                } else {
                    androidx.core.h.w.a(view, rect);
                    q qVar = r;
                    Object[] objArr = new Object[2];
                    objArr[i3] = rect;
                    objArr[1] = rect6;
                    objectAnimator = ObjectAnimator.ofObject(view, "clipBounds", qVar, objArr);
                    objectAnimator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.9
                        final /* synthetic */ View a;
                        final /* synthetic */ Rect b;
                        final /* synthetic */ int c;
                        final /* synthetic */ int d;
                        final /* synthetic */ int e;
                        final /* synthetic */ int f;
                        private boolean h;

                        AnonymousClass9(View view3, Rect rect52, int i52, int i72, int i92, int i112) {
                            view = view3;
                            rect5 = rect52;
                            i5 = i52;
                            i7 = i72;
                            i9 = i92;
                            i11 = i112;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            this.h = true;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (this.h) {
                                return;
                            }
                            androidx.core.h.w.a(view, rect5);
                            aj.a(view, i5, i7, i9, i11);
                        }
                    });
                }
                a2 = x.a(a5, objectAnimator);
            }
            if (view3.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view3.getParent();
                ae.a(viewGroup4, true);
                a(new u() { // from class: androidx.transition.ChangeBounds.10
                    boolean a = false;
                    final /* synthetic */ ViewGroup b;

                    AnonymousClass10(ViewGroup viewGroup42) {
                        viewGroup4 = viewGroup42;
                    }

                    @Override // androidx.transition.u, androidx.transition.Transition.c
                    public void a(Transition transition) {
                        ae.a(viewGroup4, false);
                        this.a = true;
                    }

                    @Override // androidx.transition.u, androidx.transition.Transition.c
                    public void b(Transition transition) {
                        if (!this.a) {
                            ae.a(viewGroup4, false);
                        }
                        transition.b(this);
                    }

                    @Override // androidx.transition.u, androidx.transition.Transition.c
                    public void c(Transition transition) {
                        ae.a(viewGroup4, false);
                    }

                    @Override // androidx.transition.u, androidx.transition.Transition.c
                    public void d(Transition transition) {
                        ae.a(viewGroup4, true);
                    }
                });
            }
            return a2;
        }
        int intValue = ((Integer) yVar.a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) yVar.a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) yVar2.a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) yVar2.a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.o);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c = aj.c(view2);
        aj.a(view2, 0.0f);
        aj.a(viewGroup).a(bitmapDrawable);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, o.a(i, m().a(intValue - this.o[0], intValue2 - this.o[1], intValue3 - this.o[0], intValue4 - this.o[1])));
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.2
            final /* synthetic */ ViewGroup a;
            final /* synthetic */ BitmapDrawable b;
            final /* synthetic */ View c;
            final /* synthetic */ float d;

            AnonymousClass2(ViewGroup viewGroup5, BitmapDrawable bitmapDrawable2, View view22, float c2) {
                viewGroup = viewGroup5;
                bitmapDrawable = bitmapDrawable2;
                view2 = view22;
                c = c2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                aj.a(viewGroup).b(bitmapDrawable);
                aj.a(view2, c);
            }
        });
        return ofPropertyValuesHolder;
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.ChangeBounds$8 */
    class AnonymousClass8 extends AnimatorListenerAdapter {
        final /* synthetic */ a a;
        private a mViewBounds;

        AnonymousClass8(a aVar2) {
            aVar = aVar2;
            this.mViewBounds = aVar;
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.ChangeBounds$9 */
    class AnonymousClass9 extends AnimatorListenerAdapter {
        final /* synthetic */ View a;
        final /* synthetic */ Rect b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        private boolean h;

        AnonymousClass9(View view3, Rect rect52, int i52, int i72, int i92, int i112) {
            view = view3;
            rect5 = rect52;
            i5 = i52;
            i7 = i72;
            i9 = i92;
            i11 = i112;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.h = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.h) {
                return;
            }
            androidx.core.h.w.a(view, rect5);
            aj.a(view, i5, i7, i9, i11);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.ChangeBounds$10 */
    class AnonymousClass10 extends u {
        boolean a = false;
        final /* synthetic */ ViewGroup b;

        AnonymousClass10(ViewGroup viewGroup42) {
            viewGroup4 = viewGroup42;
        }

        @Override // androidx.transition.u, androidx.transition.Transition.c
        public void a(Transition transition) {
            ae.a(viewGroup4, false);
            this.a = true;
        }

        @Override // androidx.transition.u, androidx.transition.Transition.c
        public void b(Transition transition) {
            if (!this.a) {
                ae.a(viewGroup4, false);
            }
            transition.b(this);
        }

        @Override // androidx.transition.u, androidx.transition.Transition.c
        public void c(Transition transition) {
            ae.a(viewGroup4, false);
        }

        @Override // androidx.transition.u, androidx.transition.Transition.c
        public void d(Transition transition) {
            ae.a(viewGroup4, true);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.ChangeBounds$2 */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ BitmapDrawable b;
        final /* synthetic */ View c;
        final /* synthetic */ float d;

        AnonymousClass2(ViewGroup viewGroup5, BitmapDrawable bitmapDrawable2, View view22, float c2) {
            viewGroup = viewGroup5;
            bitmapDrawable = bitmapDrawable2;
            view2 = view22;
            c = c2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            aj.a(viewGroup).b(bitmapDrawable);
            aj.a(view2, c);
        }
    }

    /* compiled from: source */
    private static class a {
        private int a;
        private int b;
        private int c;
        private int d;
        private View e;
        private int f;
        private int g;

        a(View view) {
            this.e = view;
        }

        void a(PointF pointF) {
            this.a = Math.round(pointF.x);
            this.b = Math.round(pointF.y);
            this.f++;
            if (this.f == this.g) {
                a();
            }
        }

        void b(PointF pointF) {
            this.c = Math.round(pointF.x);
            this.d = Math.round(pointF.y);
            this.g++;
            if (this.f == this.g) {
                a();
            }
        }

        private void a() {
            aj.a(this.e, this.a, this.b, this.c, this.d);
            this.f = 0;
            this.g = 0;
        }
    }
}
