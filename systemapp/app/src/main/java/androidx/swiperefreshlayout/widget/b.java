package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.g.e;

/* compiled from: source */
/* loaded from: classes.dex */
public class b extends Drawable implements Animatable {
    private static final Interpolator c = new LinearInterpolator();
    private static final Interpolator d = new androidx.d.a.a.b();
    private static final int[] e = {-16777216};
    float a;
    boolean b;
    private final a f = new a();
    private float g;
    private Resources h;
    private Animator i;

    private int a(float f, int i, int i2) {
        return ((((i >> 24) & 255) + ((int) ((((i2 >> 24) & 255) - r0) * f))) << 24) | ((((i >> 16) & 255) + ((int) ((((i2 >> 16) & 255) - r1) * f))) << 16) | ((((i >> 8) & 255) + ((int) ((((i2 >> 8) & 255) - r2) * f))) << 8) | ((i & 255) + ((int) (f * ((i2 & 255) - r8))));
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public b(Context context) {
        this.h = ((Context) e.a(context)).getResources();
        this.f.a(e);
        a(2.5f);
        a();
    }

    private void a(float f, float f2, float f3, float f4) {
        a aVar = this.f;
        float f5 = this.h.getDisplayMetrics().density;
        aVar.a(f2 * f5);
        aVar.e(f * f5);
        aVar.b(0);
        aVar.a(f3 * f5, f4 * f5);
    }

    public void a(int i) {
        if (i == 0) {
            a(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            a(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public void a(float f) {
        this.f.a(f);
        invalidateSelf();
    }

    public void a(boolean z) {
        this.f.a(z);
        invalidateSelf();
    }

    public void b(float f) {
        this.f.f(f);
        invalidateSelf();
    }

    public void a(float f, float f2) {
        this.f.b(f);
        this.f.c(f2);
        invalidateSelf();
    }

    public void c(float f) {
        this.f.d(f);
        invalidateSelf();
    }

    public void a(int... iArr) {
        this.f.a(iArr);
        this.f.b(0);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.g, bounds.exactCenterX(), bounds.exactCenterY());
        this.f.a(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f.c(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f.d();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f.a(colorFilter);
        invalidateSelf();
    }

    private void d(float f) {
        this.g = f;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.i.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.i.cancel();
        this.f.k();
        if (this.f.i() != this.f.e()) {
            this.b = true;
            this.i.setDuration(666L);
            this.i.start();
        } else {
            this.f.b(0);
            this.f.l();
            this.i.setDuration(1332L);
            this.i.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.i.cancel();
        d(0.0f);
        this.f.a(false);
        this.f.b(0);
        this.f.l();
        invalidateSelf();
    }

    void a(float f, a aVar) {
        if (f > 0.75f) {
            aVar.a(a((f - 0.75f) / 0.25f, aVar.h(), aVar.a()));
        } else {
            aVar.a(aVar.h());
        }
    }

    private void b(float f, a aVar) {
        a(f, aVar);
        float floor = (float) (Math.floor(aVar.j() / 0.8f) + 1.0d);
        aVar.b(aVar.f() + (((aVar.g() - 0.01f) - aVar.f()) * f));
        aVar.c(aVar.g());
        aVar.d(aVar.j() + ((floor - aVar.j()) * f));
    }

    void a(float f, a aVar, boolean z) {
        float f2;
        float interpolation;
        if (this.b) {
            b(f, aVar);
            return;
        }
        if (f != 1.0f || z) {
            float j = aVar.j();
            if (f < 0.5f) {
                float f3 = aVar.f();
                interpolation = f3;
                f2 = (0.79f * d.getInterpolation(f / 0.5f)) + 0.01f + f3;
            } else {
                f2 = aVar.f() + 0.79f;
                interpolation = f2 - ((0.79f * (1.0f - d.getInterpolation((f - 0.5f) / 0.5f))) + 0.01f);
            }
            float f4 = 216.0f * (f + this.a);
            aVar.b(interpolation);
            aVar.c(f2);
            aVar.d(j + (0.20999998f * f));
            d(f4);
        }
    }

    private void a() {
        a aVar = this.f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.swiperefreshlayout.widget.b.1
            final /* synthetic */ a a;

            AnonymousClass1(a aVar2) {
                aVar = aVar2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                b.this.a(floatValue, aVar);
                b.this.a(floatValue, aVar, false);
                b.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(c);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: androidx.swiperefreshlayout.widget.b.2
            final /* synthetic */ a a;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            AnonymousClass2(a aVar2) {
                aVar = aVar2;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.a = 0.0f;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                b.this.a(1.0f, aVar, true);
                aVar.k();
                aVar.c();
                if (b.this.b) {
                    b.this.b = false;
                    animator.cancel();
                    animator.setDuration(1332L);
                    animator.start();
                    aVar.a(false);
                    return;
                }
                b.this.a += 1.0f;
            }
        });
        this.i = ofFloat;
    }

    /* compiled from: source */
    /* renamed from: androidx.swiperefreshlayout.widget.b$1 */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ a a;

        AnonymousClass1(a aVar2) {
            aVar = aVar2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.a(floatValue, aVar);
            b.this.a(floatValue, aVar, false);
            b.this.invalidateSelf();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.swiperefreshlayout.widget.b$2 */
    class AnonymousClass2 implements Animator.AnimatorListener {
        final /* synthetic */ a a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        AnonymousClass2(a aVar2) {
            aVar = aVar2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.a = 0.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.this.a(1.0f, aVar, true);
            aVar.k();
            aVar.c();
            if (b.this.b) {
                b.this.b = false;
                animator.cancel();
                animator.setDuration(1332L);
                animator.start();
                aVar.a(false);
                return;
            }
            b.this.a += 1.0f;
        }
    }

    /* compiled from: source */
    private static class a {
        int[] i;
        int j;
        float k;
        float l;
        float m;
        boolean n;
        Path o;
        float q;
        int r;
        int s;
        int u;
        final RectF a = new RectF();
        final Paint b = new Paint();
        final Paint c = new Paint();
        final Paint d = new Paint();
        float e = 0.0f;
        float f = 0.0f;
        float g = 0.0f;
        float h = 5.0f;
        float p = 1.0f;
        int t = 255;

        a() {
            this.b.setStrokeCap(Paint.Cap.SQUARE);
            this.b.setAntiAlias(true);
            this.b.setStyle(Paint.Style.STROKE);
            this.c.setStyle(Paint.Style.FILL);
            this.c.setAntiAlias(true);
            this.d.setColor(0);
        }

        void a(float f, float f2) {
            this.r = (int) f;
            this.s = (int) f2;
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.a;
            float f = this.q + (this.h / 2.0f);
            if (this.q <= 0.0f) {
                f = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.r * this.p) / 2.0f, this.h / 2.0f);
            }
            rectF.set(rect.centerX() - f, rect.centerY() - f, rect.centerX() + f, rect.centerY() + f);
            float f2 = (this.e + this.g) * 360.0f;
            float f3 = ((this.f + this.g) * 360.0f) - f2;
            this.b.setColor(this.u);
            this.b.setAlpha(this.t);
            float f4 = this.h / 2.0f;
            rectF.inset(f4, f4);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.d);
            float f5 = -f4;
            rectF.inset(f5, f5);
            canvas.drawArc(rectF, f2, f3, false, this.b);
            a(canvas, f2, f3, rectF);
        }

        void a(Canvas canvas, float f, float f2, RectF rectF) {
            if (this.n) {
                if (this.o == null) {
                    this.o = new Path();
                    this.o.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    this.o.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f3 = (this.r * this.p) / 2.0f;
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(this.r * this.p, 0.0f);
                this.o.lineTo((this.r * this.p) / 2.0f, this.s * this.p);
                this.o.offset((min + rectF.centerX()) - f3, rectF.centerY() + (this.h / 2.0f));
                this.o.close();
                this.c.setColor(this.u);
                this.c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.c);
                canvas.restore();
            }
        }

        void a(int[] iArr) {
            this.i = iArr;
            b(0);
        }

        void a(int i) {
            this.u = i;
        }

        void b(int i) {
            this.j = i;
            this.u = this.i[this.j];
        }

        int a() {
            return this.i[b()];
        }

        int b() {
            return (this.j + 1) % this.i.length;
        }

        void c() {
            b(b());
        }

        void a(ColorFilter colorFilter) {
            this.b.setColorFilter(colorFilter);
        }

        void c(int i) {
            this.t = i;
        }

        int d() {
            return this.t;
        }

        void a(float f) {
            this.h = f;
            this.b.setStrokeWidth(f);
        }

        void b(float f) {
            this.e = f;
        }

        float e() {
            return this.e;
        }

        float f() {
            return this.k;
        }

        float g() {
            return this.l;
        }

        int h() {
            return this.i[this.j];
        }

        void c(float f) {
            this.f = f;
        }

        float i() {
            return this.f;
        }

        void d(float f) {
            this.g = f;
        }

        void e(float f) {
            this.q = f;
        }

        void a(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }

        void f(float f) {
            if (f != this.p) {
                this.p = f;
            }
        }

        float j() {
            return this.m;
        }

        void k() {
            this.k = this.e;
            this.l = this.f;
            this.m = this.g;
        }

        void l() {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            b(0.0f);
            c(0.0f);
            d(0.0f);
        }
    }
}
