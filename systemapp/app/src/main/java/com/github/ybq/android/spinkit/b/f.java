package com.github.ybq.android.spinkit.b;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class f extends Drawable implements ValueAnimator.AnimatorUpdateListener, Animatable, Drawable.Callback {
    private static final Rect B = new Rect();
    public static final Property<f, Integer> b = new com.github.ybq.android.spinkit.a.c<f>("rotateX") { // from class: com.github.ybq.android.spinkit.b.f.1
        AnonymousClass1(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.c
        public void a(f fVar, int i2) {
            fVar.e(i2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.k());
        }
    };
    public static final Property<f, Integer> c = new com.github.ybq.android.spinkit.a.c<f>("rotate") { // from class: com.github.ybq.android.spinkit.b.f.4
        AnonymousClass4(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.c
        public void a(f fVar, int i2) {
            fVar.d(i2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.g());
        }
    };
    public static final Property<f, Integer> d = new com.github.ybq.android.spinkit.a.c<f>("rotateY") { // from class: com.github.ybq.android.spinkit.b.f.5
        AnonymousClass5(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.c
        public void a(f fVar, int i2) {
            fVar.f(i2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.l());
        }
    };
    public static final Property<f, Integer> e = new com.github.ybq.android.spinkit.a.c<f>("translateX") { // from class: com.github.ybq.android.spinkit.b.f.6
        AnonymousClass6(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.c
        public void a(f fVar, int i2) {
            fVar.b(i2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.e());
        }
    };
    public static final Property<f, Integer> f = new com.github.ybq.android.spinkit.a.c<f>("translateY") { // from class: com.github.ybq.android.spinkit.b.f.7
        AnonymousClass7(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.c
        public void a(f fVar, int i2) {
            fVar.c(i2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.f());
        }
    };
    public static final Property<f, Float> g = new com.github.ybq.android.spinkit.a.b<f>("translateXPercentage") { // from class: com.github.ybq.android.spinkit.b.f.8
        AnonymousClass8(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.b
        public void a(f fVar, float f2) {
            fVar.a(f2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(f fVar) {
            return Float.valueOf(fVar.c());
        }
    };
    public static final Property<f, Float> h = new com.github.ybq.android.spinkit.a.b<f>("translateYPercentage") { // from class: com.github.ybq.android.spinkit.b.f.9
        AnonymousClass9(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.b
        public void a(f fVar, float f2) {
            fVar.b(f2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(f fVar) {
            return Float.valueOf(fVar.d());
        }
    };
    public static final Property<f, Float> i = new com.github.ybq.android.spinkit.a.b<f>("scaleX") { // from class: com.github.ybq.android.spinkit.b.f.10
        AnonymousClass10(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.b
        public void a(f fVar, float f2) {
            fVar.d(f2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(f fVar) {
            return Float.valueOf(fVar.i());
        }
    };
    public static final Property<f, Float> j = new com.github.ybq.android.spinkit.a.b<f>("scaleY") { // from class: com.github.ybq.android.spinkit.b.f.11
        AnonymousClass11(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.b
        public void a(f fVar, float f2) {
            fVar.e(f2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(f fVar) {
            return Float.valueOf(fVar.j());
        }
    };
    public static final Property<f, Float> k = new com.github.ybq.android.spinkit.a.b<f>("scale") { // from class: com.github.ybq.android.spinkit.b.f.2
        AnonymousClass2(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.b
        public void a(f fVar, float f2) {
            fVar.c(f2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(f fVar) {
            return Float.valueOf(fVar.h());
        }
    };
    public static final Property<f, Integer> l = new com.github.ybq.android.spinkit.a.c<f>("alpha") { // from class: com.github.ybq.android.spinkit.b.f.3
        AnonymousClass3(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.c
        public void a(f fVar, int i2) {
            fVar.setAlpha(i2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.getAlpha());
        }
    };
    private float p;
    private float q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private float x;
    private float y;
    private ValueAnimator z;
    private float m = 1.0f;
    private float n = 1.0f;
    private float o = 1.0f;
    private int A = 255;
    protected Rect a = B;
    private Camera C = new Camera();
    private Matrix D = new Matrix();

    public abstract ValueAnimator a();

    public abstract void a(int i2);

    protected abstract void a_(Canvas canvas);

    public abstract int b();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.A = i2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.A;
    }

    public float c() {
        return this.x;
    }

    public void a(float f2) {
        this.x = f2;
    }

    public float d() {
        return this.y;
    }

    public void b(float f2) {
        this.y = f2;
    }

    public int e() {
        return this.u;
    }

    public void b(int i2) {
        this.u = i2;
    }

    public int f() {
        return this.v;
    }

    public void c(int i2) {
        this.v = i2;
    }

    public int g() {
        return this.w;
    }

    public void d(int i2) {
        this.w = i2;
    }

    public float h() {
        return this.m;
    }

    public void c(float f2) {
        this.m = f2;
        d(f2);
        e(f2);
    }

    public float i() {
        return this.n;
    }

    public void d(float f2) {
        this.n = f2;
    }

    public float j() {
        return this.o;
    }

    public void e(float f2) {
        this.o = f2;
    }

    public int k() {
        return this.s;
    }

    public void e(int i2) {
        this.s = i2;
    }

    public int l() {
        return this.t;
    }

    public void f(int i2) {
        this.t = i2;
    }

    public float m() {
        return this.p;
    }

    public void f(float f2) {
        this.p = f2;
    }

    public float n() {
        return this.q;
    }

    public void g(float f2) {
        this.q = f2;
    }

    public f g(int i2) {
        this.r = i2;
        return this;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (com.github.ybq.android.spinkit.a.a.b(this.z)) {
            return;
        }
        this.z = o();
        if (this.z == null) {
            return;
        }
        com.github.ybq.android.spinkit.a.a.a((Animator) this.z);
        invalidateSelf();
    }

    public ValueAnimator o() {
        if (this.z == null) {
            this.z = a();
        }
        if (this.z != null) {
            this.z.addUpdateListener(this);
            this.z.setStartDelay(this.r);
        }
        return this.z;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (com.github.ybq.android.spinkit.a.a.b(this.z)) {
            this.z.removeAllUpdateListeners();
            this.z.end();
            p();
        }
    }

    public void p() {
        this.m = 1.0f;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0.0f;
        this.y = 0.0f;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return com.github.ybq.android.spinkit.a.a.a(this.z);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
    }

    public void a(Rect rect) {
        a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.a = new Rect(i2, i3, i4, i5);
        f(q().centerX());
        g(q().centerY());
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public Rect q() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int e2 = e();
        if (e2 == 0) {
            e2 = (int) (getBounds().width() * c());
        }
        int f2 = f();
        if (f2 == 0) {
            f2 = (int) (getBounds().height() * d());
        }
        canvas.translate(e2, f2);
        canvas.scale(i(), j(), m(), n());
        canvas.rotate(g(), m(), n());
        if (k() != 0 || l() != 0) {
            this.C.save();
            this.C.rotateX(k());
            this.C.rotateY(l());
            this.C.getMatrix(this.D);
            this.D.preTranslate(-m(), -n());
            this.D.postTranslate(m(), n());
            this.C.restore();
            canvas.concat(this.D);
        }
        a_(canvas);
    }

    public Rect b(Rect rect) {
        int min = Math.min(rect.width(), rect.height());
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        int i2 = min / 2;
        return new Rect(centerX - i2, centerY - i2, centerX + i2, centerY + i2);
    }

    /* compiled from: source */
    /* renamed from: com.github.ybq.android.spinkit.b.f$1 */
    static class AnonymousClass1 extends com.github.ybq.android.spinkit.a.c<f> {
        AnonymousClass1(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.c
        public void a(f fVar, int i2) {
            fVar.e(i2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.k());
        }
    }

    /* compiled from: source */
    /* renamed from: com.github.ybq.android.spinkit.b.f$4 */
    static class AnonymousClass4 extends com.github.ybq.android.spinkit.a.c<f> {
        AnonymousClass4(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.c
        public void a(f fVar, int i2) {
            fVar.d(i2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.g());
        }
    }

    /* compiled from: source */
    /* renamed from: com.github.ybq.android.spinkit.b.f$5 */
    static class AnonymousClass5 extends com.github.ybq.android.spinkit.a.c<f> {
        AnonymousClass5(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.c
        public void a(f fVar, int i2) {
            fVar.f(i2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.l());
        }
    }

    /* compiled from: source */
    /* renamed from: com.github.ybq.android.spinkit.b.f$6 */
    static class AnonymousClass6 extends com.github.ybq.android.spinkit.a.c<f> {
        AnonymousClass6(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.c
        public void a(f fVar, int i2) {
            fVar.b(i2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.e());
        }
    }

    /* compiled from: source */
    /* renamed from: com.github.ybq.android.spinkit.b.f$7 */
    static class AnonymousClass7 extends com.github.ybq.android.spinkit.a.c<f> {
        AnonymousClass7(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.c
        public void a(f fVar, int i2) {
            fVar.c(i2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.f());
        }
    }

    /* compiled from: source */
    /* renamed from: com.github.ybq.android.spinkit.b.f$8 */
    static class AnonymousClass8 extends com.github.ybq.android.spinkit.a.b<f> {
        AnonymousClass8(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.b
        public void a(f fVar, float f2) {
            fVar.a(f2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(f fVar) {
            return Float.valueOf(fVar.c());
        }
    }

    /* compiled from: source */
    /* renamed from: com.github.ybq.android.spinkit.b.f$9 */
    static class AnonymousClass9 extends com.github.ybq.android.spinkit.a.b<f> {
        AnonymousClass9(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.b
        public void a(f fVar, float f2) {
            fVar.b(f2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(f fVar) {
            return Float.valueOf(fVar.d());
        }
    }

    /* compiled from: source */
    /* renamed from: com.github.ybq.android.spinkit.b.f$10 */
    static class AnonymousClass10 extends com.github.ybq.android.spinkit.a.b<f> {
        AnonymousClass10(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.b
        public void a(f fVar, float f2) {
            fVar.d(f2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(f fVar) {
            return Float.valueOf(fVar.i());
        }
    }

    /* compiled from: source */
    /* renamed from: com.github.ybq.android.spinkit.b.f$11 */
    static class AnonymousClass11 extends com.github.ybq.android.spinkit.a.b<f> {
        AnonymousClass11(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.b
        public void a(f fVar, float f2) {
            fVar.e(f2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(f fVar) {
            return Float.valueOf(fVar.j());
        }
    }

    /* compiled from: source */
    /* renamed from: com.github.ybq.android.spinkit.b.f$2 */
    static class AnonymousClass2 extends com.github.ybq.android.spinkit.a.b<f> {
        AnonymousClass2(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.b
        public void a(f fVar, float f2) {
            fVar.c(f2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(f fVar) {
            return Float.valueOf(fVar.h());
        }
    }

    /* compiled from: source */
    /* renamed from: com.github.ybq.android.spinkit.b.f$3 */
    static class AnonymousClass3 extends com.github.ybq.android.spinkit.a.c<f> {
        AnonymousClass3(String str) {
            super(str);
        }

        @Override // com.github.ybq.android.spinkit.a.c
        public void a(f fVar, int i2) {
            fVar.setAlpha(i2);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.getAlpha());
        }
    }
}
