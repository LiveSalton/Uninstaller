package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.h.w;
import com.google.android.material.a;
import com.google.android.material.a.g;
import com.google.android.material.a.h;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.i;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
class a {
    static final TimeInterpolator a = com.google.android.material.a.a.c;
    static final int[] p = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] q = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    static final int[] r = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] s = {R.attr.state_hovered, R.attr.state_enabled};
    static final int[] t = {R.attr.state_enabled};
    static final int[] u = new int[0];
    private float A;
    private ArrayList<Animator.AnimatorListener> B;
    private ArrayList<Animator.AnimatorListener> C;
    private ViewTreeObserver.OnPreDrawListener H;
    Animator c;
    h d;
    h e;
    com.google.android.material.h.a f;
    Drawable g;
    Drawable h;
    com.google.android.material.internal.a i;
    Drawable j;
    float k;
    float l;
    float m;
    int n;
    final VisibilityAwareImageButton v;
    final com.google.android.material.h.b w;
    private h x;
    private h y;
    int b = 0;
    float o = 1.0f;
    private final Rect D = new Rect();
    private final RectF E = new RectF();
    private final RectF F = new RectF();
    private final Matrix G = new Matrix();
    private final i z = new i();

    /* compiled from: source */
    interface d {
        void a();

        void b();
    }

    void b(Rect rect) {
    }

    void i() {
    }

    boolean m() {
        return true;
    }

    a(VisibilityAwareImageButton visibilityAwareImageButton, com.google.android.material.h.b bVar) {
        this.v = visibilityAwareImageButton;
        this.w = bVar;
        this.z.a(p, a((f) new c()));
        this.z.a(q, a((f) new b()));
        this.z.a(r, a((f) new b()));
        this.z.a(s, a((f) new b()));
        this.z.a(t, a((f) new e()));
        this.z.a(u, a((f) new C0082a()));
        this.A = this.v.getRotation();
    }

    void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable[] drawableArr;
        this.g = androidx.core.graphics.drawable.a.g(p());
        androidx.core.graphics.drawable.a.a(this.g, colorStateList);
        if (mode != null) {
            androidx.core.graphics.drawable.a.a(this.g, mode);
        }
        this.h = androidx.core.graphics.drawable.a.g(p());
        androidx.core.graphics.drawable.a.a(this.h, com.google.android.material.g.a.a(colorStateList2));
        if (i > 0) {
            this.i = a(i, colorStateList);
            drawableArr = new Drawable[]{this.i, this.g, this.h};
        } else {
            this.i = null;
            drawableArr = new Drawable[]{this.g, this.h};
        }
        this.j = new LayerDrawable(drawableArr);
        this.f = new com.google.android.material.h.a(this.v.getContext(), this.j, this.w.a(), this.k, this.k + this.m);
        this.f.a(false);
        this.w.a(this.f);
    }

    void a(ColorStateList colorStateList) {
        if (this.g != null) {
            androidx.core.graphics.drawable.a.a(this.g, colorStateList);
        }
        if (this.i != null) {
            this.i.a(colorStateList);
        }
    }

    void a(PorterDuff.Mode mode) {
        if (this.g != null) {
            androidx.core.graphics.drawable.a.a(this.g, mode);
        }
    }

    void b(ColorStateList colorStateList) {
        if (this.h != null) {
            androidx.core.graphics.drawable.a.a(this.h, com.google.android.material.g.a.a(colorStateList));
        }
    }

    final void a(float f2) {
        if (this.k != f2) {
            this.k = f2;
            a(this.k, this.l, this.m);
        }
    }

    float a() {
        return this.k;
    }

    float b() {
        return this.l;
    }

    float c() {
        return this.m;
    }

    final void b(float f2) {
        if (this.l != f2) {
            this.l = f2;
            a(this.k, this.l, this.m);
        }
    }

    final void c(float f2) {
        if (this.m != f2) {
            this.m = f2;
            a(this.k, this.l, this.m);
        }
    }

    final void a(int i) {
        if (this.n != i) {
            this.n = i;
            d();
        }
    }

    final void d() {
        d(this.o);
    }

    final void d(float f2) {
        this.o = f2;
        Matrix matrix = this.G;
        a(f2, matrix);
        this.v.setImageMatrix(matrix);
    }

    private void a(float f2, Matrix matrix) {
        matrix.reset();
        if (this.v.getDrawable() == null || this.n == 0) {
            return;
        }
        RectF rectF = this.E;
        RectF rectF2 = this.F;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        rectF2.set(0.0f, 0.0f, this.n, this.n);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        matrix.postScale(f2, f2, this.n / 2.0f, this.n / 2.0f);
    }

    final h e() {
        return this.d;
    }

    final void a(h hVar) {
        this.d = hVar;
    }

    final h f() {
        return this.e;
    }

    final void b(h hVar) {
        this.e = hVar;
    }

    void a(float f2, float f3, float f4) {
        if (this.f != null) {
            this.f.a(f2, this.m + f2);
            j();
        }
    }

    void a(int[] iArr) {
        this.z.a(iArr);
    }

    void g() {
        this.z.a();
    }

    void a(Animator.AnimatorListener animatorListener) {
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.add(animatorListener);
    }

    void b(Animator.AnimatorListener animatorListener) {
        if (this.B == null) {
            return;
        }
        this.B.remove(animatorListener);
    }

    public void c(Animator.AnimatorListener animatorListener) {
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        this.C.add(animatorListener);
    }

    public void d(Animator.AnimatorListener animatorListener) {
        if (this.C == null) {
            return;
        }
        this.C.remove(animatorListener);
    }

    void a(d dVar, boolean z) {
        if (s()) {
            return;
        }
        if (this.c != null) {
            this.c.cancel();
        }
        if (w()) {
            AnimatorSet a2 = a(this.e != null ? this.e : u(), 0.0f, 0.0f, 0.0f);
            a2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.a.1
                final /* synthetic */ boolean a;
                final /* synthetic */ d b;
                private boolean d;

                AnonymousClass1(boolean z2, d dVar2) {
                    z = z2;
                    dVar = dVar2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    a.this.v.a(0, z);
                    a.this.b = 1;
                    a.this.c = animator;
                    this.d = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.d = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.b = 0;
                    a.this.c = null;
                    if (this.d) {
                        return;
                    }
                    a.this.v.a(z ? 8 : 4, z);
                    if (dVar != null) {
                        dVar.b();
                    }
                }
            });
            if (this.C != null) {
                Iterator<Animator.AnimatorListener> it = this.C.iterator();
                while (it.hasNext()) {
                    a2.addListener(it.next());
                }
            }
            a2.start();
            return;
        }
        this.v.a(z2 ? 8 : 4, z2);
        if (dVar2 != null) {
            dVar2.b();
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.floatingactionbutton.a$1 */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;
        final /* synthetic */ d b;
        private boolean d;

        AnonymousClass1(boolean z2, d dVar2) {
            z = z2;
            dVar = dVar2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.v.a(0, z);
            a.this.b = 1;
            a.this.c = animator;
            this.d = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.d = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.b = 0;
            a.this.c = null;
            if (this.d) {
                return;
            }
            a.this.v.a(z ? 8 : 4, z);
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    void b(d dVar, boolean z) {
        if (r()) {
            return;
        }
        if (this.c != null) {
            this.c.cancel();
        }
        if (w()) {
            if (this.v.getVisibility() != 0) {
                this.v.setAlpha(0.0f);
                this.v.setScaleY(0.0f);
                this.v.setScaleX(0.0f);
                d(0.0f);
            }
            AnimatorSet a2 = a(this.d != null ? this.d : t(), 1.0f, 1.0f, 1.0f);
            a2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.a.2
                final /* synthetic */ boolean a;
                final /* synthetic */ d b;

                AnonymousClass2(boolean z2, d dVar2) {
                    z = z2;
                    dVar = dVar2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    a.this.v.a(0, z);
                    a.this.b = 2;
                    a.this.c = animator;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.b = 0;
                    a.this.c = null;
                    if (dVar != null) {
                        dVar.a();
                    }
                }
            });
            if (this.B != null) {
                Iterator<Animator.AnimatorListener> it = this.B.iterator();
                while (it.hasNext()) {
                    a2.addListener(it.next());
                }
            }
            a2.start();
            return;
        }
        this.v.a(0, z2);
        this.v.setAlpha(1.0f);
        this.v.setScaleY(1.0f);
        this.v.setScaleX(1.0f);
        d(1.0f);
        if (dVar2 != null) {
            dVar2.a();
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.floatingactionbutton.a$2 */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;
        final /* synthetic */ d b;

        AnonymousClass2(boolean z2, d dVar2) {
            z = z2;
            dVar = dVar2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.v.a(0, z);
            a.this.b = 2;
            a.this.c = animator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.b = 0;
            a.this.c = null;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    private h t() {
        if (this.x == null) {
            this.x = h.a(this.v.getContext(), a.C0079a.design_fab_show_motion_spec);
        }
        return this.x;
    }

    private h u() {
        if (this.y == null) {
            this.y = h.a(this.v.getContext(), a.C0079a.design_fab_hide_motion_spec);
        }
        return this.y;
    }

    private AnimatorSet a(h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.v, (Property<VisibilityAwareImageButton, Float>) View.ALPHA, f2);
        hVar.b("opacity").a((Animator) ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.v, (Property<VisibilityAwareImageButton, Float>) View.SCALE_X, f3);
        hVar.b("scale").a((Animator) ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.v, (Property<VisibilityAwareImageButton, Float>) View.SCALE_Y, f3);
        hVar.b("scale").a((Animator) ofFloat3);
        arrayList.add(ofFloat3);
        a(f4, this.G);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.v, new com.google.android.material.a.f(), new g(), new Matrix(this.G));
        hVar.b("iconScale").a((Animator) ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    final Drawable h() {
        return this.j;
    }

    final void j() {
        Rect rect = this.D;
        a(rect);
        b(rect);
        this.w.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void a(Rect rect) {
        this.f.getPadding(rect);
    }

    void k() {
        if (m()) {
            v();
            this.v.getViewTreeObserver().addOnPreDrawListener(this.H);
        }
    }

    void l() {
        if (this.H != null) {
            this.v.getViewTreeObserver().removeOnPreDrawListener(this.H);
            this.H = null;
        }
    }

    com.google.android.material.internal.a a(int i, ColorStateList colorStateList) {
        Context context = this.v.getContext();
        com.google.android.material.internal.a n = n();
        n.a(androidx.core.content.a.c(context, a.c.design_fab_stroke_top_outer_color), androidx.core.content.a.c(context, a.c.design_fab_stroke_top_inner_color), androidx.core.content.a.c(context, a.c.design_fab_stroke_end_inner_color), androidx.core.content.a.c(context, a.c.design_fab_stroke_end_outer_color));
        n.a(i);
        n.a(colorStateList);
        return n;
    }

    com.google.android.material.internal.a n() {
        return new com.google.android.material.internal.a();
    }

    void o() {
        float rotation = this.v.getRotation();
        if (this.A != rotation) {
            this.A = rotation;
            x();
        }
    }

    private void v() {
        if (this.H == null) {
            this.H = new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.floatingactionbutton.a.3
                AnonymousClass3() {
                }

                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    a.this.o();
                    return true;
                }
            };
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.floatingactionbutton.a$3 */
    class AnonymousClass3 implements ViewTreeObserver.OnPreDrawListener {
        AnonymousClass3() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a.this.o();
            return true;
        }
    }

    GradientDrawable p() {
        GradientDrawable q2 = q();
        q2.setShape(1);
        q2.setColor(-1);
        return q2;
    }

    GradientDrawable q() {
        return new GradientDrawable();
    }

    boolean r() {
        return this.v.getVisibility() != 0 ? this.b == 2 : this.b != 1;
    }

    boolean s() {
        return this.v.getVisibility() == 0 ? this.b == 1 : this.b != 2;
    }

    private ValueAnimator a(f fVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(a);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(fVar);
        valueAnimator.addUpdateListener(fVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    /* compiled from: source */
    private abstract class f extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private boolean a;
        private float c;
        private float d;

        protected abstract float a();

        private f() {
        }

        /* synthetic */ f(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.a) {
                this.c = a.this.f.b();
                this.d = a();
                this.a = true;
            }
            a.this.f.a(this.c + ((this.d - this.c) * valueAnimator.getAnimatedFraction()));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f.a(this.d);
            this.a = false;
        }
    }

    /* compiled from: source */
    private class e extends f {
        e() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.a.f
        protected float a() {
            return a.this.k;
        }
    }

    /* compiled from: source */
    private class b extends f {
        b() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.a.f
        protected float a() {
            return a.this.k + a.this.l;
        }
    }

    /* compiled from: source */
    private class c extends f {
        c() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.a.f
        protected float a() {
            return a.this.k + a.this.m;
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.floatingactionbutton.a$a */
    private class C0082a extends f {
        @Override // com.google.android.material.floatingactionbutton.a.f
        protected float a() {
            return 0.0f;
        }

        C0082a() {
            super();
        }
    }

    private boolean w() {
        return w.C(this.v) && !this.v.isInEditMode();
    }

    private void x() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.A % 90.0f != 0.0f) {
                if (this.v.getLayerType() != 1) {
                    this.v.setLayerType(1, null);
                }
            } else if (this.v.getLayerType() != 0) {
                this.v.setLayerType(0, null);
            }
        }
        if (this.f != null) {
            this.f.b(-this.A);
        }
        if (this.i != null) {
            this.i.b(-this.A);
        }
    }
}
