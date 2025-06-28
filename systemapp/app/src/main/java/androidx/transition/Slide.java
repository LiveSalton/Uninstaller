package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: source */
/* loaded from: classes.dex */
public class Slide extends Visibility {
    private static final TimeInterpolator a = new DecelerateInterpolator();
    private static final TimeInterpolator i = new AccelerateInterpolator();
    private static final a l = new b() { // from class: androidx.transition.Slide.1
        AnonymousClass1() {
        }

        @Override // androidx.transition.Slide.a
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - viewGroup.getWidth();
        }
    };
    private static final a m = new b() { // from class: androidx.transition.Slide.2
        AnonymousClass2() {
        }

        @Override // androidx.transition.Slide.a
        public float a(ViewGroup viewGroup, View view) {
            if (androidx.core.h.w.h(viewGroup) == 1) {
                return view.getTranslationX() + viewGroup.getWidth();
            }
            return view.getTranslationX() - viewGroup.getWidth();
        }
    };
    private static final a n = new c() { // from class: androidx.transition.Slide.3
        AnonymousClass3() {
        }

        @Override // androidx.transition.Slide.a
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - viewGroup.getHeight();
        }
    };
    private static final a o = new b() { // from class: androidx.transition.Slide.4
        AnonymousClass4() {
        }

        @Override // androidx.transition.Slide.a
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + viewGroup.getWidth();
        }
    };
    private static final a p = new b() { // from class: androidx.transition.Slide.5
        AnonymousClass5() {
        }

        @Override // androidx.transition.Slide.a
        public float a(ViewGroup viewGroup, View view) {
            if (androidx.core.h.w.h(viewGroup) == 1) {
                return view.getTranslationX() - viewGroup.getWidth();
            }
            return view.getTranslationX() + viewGroup.getWidth();
        }
    };
    private static final a q = new c() { // from class: androidx.transition.Slide.6
        AnonymousClass6() {
        }

        @Override // androidx.transition.Slide.a
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + viewGroup.getHeight();
        }
    };
    private a j;
    private int k;

    /* compiled from: source */
    private interface a {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    /* compiled from: source */
    private static abstract class b implements a {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // androidx.transition.Slide.a
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    /* compiled from: source */
    private static abstract class c implements a {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // androidx.transition.Slide.a
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.Slide$1 */
    static class AnonymousClass1 extends b {
        AnonymousClass1() {
        }

        @Override // androidx.transition.Slide.a
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - viewGroup.getWidth();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.Slide$2 */
    static class AnonymousClass2 extends b {
        AnonymousClass2() {
        }

        @Override // androidx.transition.Slide.a
        public float a(ViewGroup viewGroup, View view) {
            if (androidx.core.h.w.h(viewGroup) == 1) {
                return view.getTranslationX() + viewGroup.getWidth();
            }
            return view.getTranslationX() - viewGroup.getWidth();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.Slide$3 */
    static class AnonymousClass3 extends c {
        AnonymousClass3() {
        }

        @Override // androidx.transition.Slide.a
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - viewGroup.getHeight();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.Slide$4 */
    static class AnonymousClass4 extends b {
        AnonymousClass4() {
        }

        @Override // androidx.transition.Slide.a
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + viewGroup.getWidth();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.Slide$5 */
    static class AnonymousClass5 extends b {
        AnonymousClass5() {
        }

        @Override // androidx.transition.Slide.a
        public float a(ViewGroup viewGroup, View view) {
            if (androidx.core.h.w.h(viewGroup) == 1) {
                return view.getTranslationX() - viewGroup.getWidth();
            }
            return view.getTranslationX() + viewGroup.getWidth();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.Slide$6 */
    static class AnonymousClass6 extends c {
        AnonymousClass6() {
        }

        @Override // androidx.transition.Slide.a
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + viewGroup.getHeight();
        }
    }

    public Slide() {
        this.j = q;
        this.k = 80;
        a(80);
    }

    @SuppressLint({"RestrictedApi"})
    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = q;
        this.k = 80;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.h);
        int a2 = androidx.core.content.a.g.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        a(a2);
    }

    private void d(y yVar) {
        int[] iArr = new int[2];
        yVar.b.getLocationOnScreen(iArr);
        yVar.a.put("android:slide:screenPosition", iArr);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void a(y yVar) {
        super.a(yVar);
        d(yVar);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void b(y yVar) {
        super.b(yVar);
        d(yVar);
    }

    public void a(int i2) {
        if (i2 == 3) {
            this.j = l;
        } else if (i2 == 5) {
            this.j = o;
        } else if (i2 == 48) {
            this.j = n;
        } else if (i2 == 80) {
            this.j = q;
        } else if (i2 == 8388611) {
            this.j = m;
        } else if (i2 == 8388613) {
            this.j = p;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        this.k = i2;
        s sVar = new s();
        sVar.a(i2);
        a(sVar);
    }

    @Override // androidx.transition.Visibility
    public Animator a(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        if (yVar2 == null) {
            return null;
        }
        int[] iArr = (int[]) yVar2.a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return aa.a(view, yVar2, iArr[0], iArr[1], this.j.a(viewGroup, view), this.j.b(viewGroup, view), translationX, translationY, a, this);
    }

    @Override // androidx.transition.Visibility
    public Animator b(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        if (yVar == null) {
            return null;
        }
        int[] iArr = (int[]) yVar.a.get("android:slide:screenPosition");
        return aa.a(view, yVar, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.j.a(viewGroup, view), this.j.b(viewGroup, view), i, this);
    }
}
