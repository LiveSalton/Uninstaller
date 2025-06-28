package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.h.w;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: source */
/* loaded from: classes.dex */
class d extends RecyclerView.h implements RecyclerView.l {
    private static final int[] k = {R.attr.state_pressed};
    private static final int[] l = new int[0];
    final StateListDrawable a;
    final Drawable b;
    int c;
    int d;
    float e;
    int f;
    int g;
    float h;
    private final int m;
    private final int n;
    private final int o;
    private final int p;
    private final StateListDrawable q;
    private final Drawable r;
    private final int s;
    private final int t;
    private RecyclerView w;
    private int u = 0;
    private int v = 0;
    private boolean x = false;
    private boolean y = false;
    private int z = 0;
    private int A = 0;
    private final int[] B = new int[2];
    private final int[] C = new int[2];
    final ValueAnimator i = ValueAnimator.ofFloat(0.0f, 1.0f);
    int j = 0;
    private final Runnable D = new Runnable() { // from class: androidx.recyclerview.widget.d.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.b(500);
        }
    };
    private final RecyclerView.m E = new RecyclerView.m() { // from class: androidx.recyclerview.widget.d.2
        AnonymousClass2() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public void a(RecyclerView recyclerView, int i, int i2) {
            d.this.a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    };

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void a(boolean z) {
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.d$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.b(500);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.d$2 */
    class AnonymousClass2 extends RecyclerView.m {
        AnonymousClass2() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public void a(RecyclerView recyclerView, int i, int i2) {
            d.this.a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.a = stateListDrawable;
        this.b = drawable;
        this.q = stateListDrawable2;
        this.r = drawable2;
        this.o = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.p = Math.max(i, drawable.getIntrinsicWidth());
        this.s = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.t = Math.max(i, drawable2.getIntrinsicWidth());
        this.m = i2;
        this.n = i3;
        this.a.setAlpha(255);
        this.b.setAlpha(255);
        this.i.addListener(new a());
        this.i.addUpdateListener(new b());
        a(recyclerView);
    }

    public void a(RecyclerView recyclerView) {
        if (this.w == recyclerView) {
            return;
        }
        if (this.w != null) {
            d();
        }
        this.w = recyclerView;
        if (this.w != null) {
            c();
        }
    }

    private void c() {
        this.w.a((RecyclerView.h) this);
        this.w.a((RecyclerView.l) this);
        this.w.a(this.E);
    }

    private void d() {
        this.w.b((RecyclerView.h) this);
        this.w.b((RecyclerView.l) this);
        this.w.b(this.E);
        f();
    }

    void a() {
        this.w.invalidate();
    }

    void a(int i) {
        if (i == 2 && this.z != 2) {
            this.a.setState(k);
            f();
        }
        if (i == 0) {
            a();
        } else {
            b();
        }
        if (this.z == 2 && i != 2) {
            this.a.setState(l);
            c(1200);
        } else if (i == 1) {
            c(1500);
        }
        this.z = i;
    }

    private boolean e() {
        return w.h(this.w) == 1;
    }

    public void b() {
        int i = this.j;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                this.i.cancel();
            }
        }
        this.j = 1;
        this.i.setFloatValues(((Float) this.i.getAnimatedValue()).floatValue(), 1.0f);
        this.i.setDuration(500L);
        this.i.setStartDelay(0L);
        this.i.start();
    }

    void b(int i) {
        switch (this.j) {
            case 1:
                this.i.cancel();
                break;
            case 2:
                break;
            default:
                return;
        }
        this.j = 3;
        this.i.setFloatValues(((Float) this.i.getAnimatedValue()).floatValue(), 0.0f);
        this.i.setDuration(i);
        this.i.start();
    }

    private void f() {
        this.w.removeCallbacks(this.D);
    }

    private void c(int i) {
        f();
        this.w.postDelayed(this.D, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        if (this.u != this.w.getWidth() || this.v != this.w.getHeight()) {
            this.u = this.w.getWidth();
            this.v = this.w.getHeight();
            a(0);
        } else if (this.j != 0) {
            if (this.x) {
                a(canvas);
            }
            if (this.y) {
                b(canvas);
            }
        }
    }

    private void a(Canvas canvas) {
        int i = this.u - this.o;
        int i2 = this.d - (this.c / 2);
        this.a.setBounds(0, 0, this.o, this.c);
        this.b.setBounds(0, 0, this.p, this.v);
        if (e()) {
            this.b.draw(canvas);
            canvas.translate(this.o, i2);
            canvas.scale(-1.0f, 1.0f);
            this.a.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate(-this.o, -i2);
            return;
        }
        canvas.translate(i, 0.0f);
        this.b.draw(canvas);
        canvas.translate(0.0f, i2);
        this.a.draw(canvas);
        canvas.translate(-i, -i2);
    }

    private void b(Canvas canvas) {
        int i = this.v - this.s;
        int i2 = this.g - (this.f / 2);
        this.q.setBounds(0, 0, this.f, this.s);
        this.r.setBounds(0, 0, this.u, this.t);
        canvas.translate(0.0f, i);
        this.r.draw(canvas);
        canvas.translate(i2, 0.0f);
        this.q.draw(canvas);
        canvas.translate(-i2, -i);
    }

    void a(int i, int i2) {
        int computeVerticalScrollRange = this.w.computeVerticalScrollRange();
        int i3 = this.v;
        this.x = computeVerticalScrollRange - i3 > 0 && this.v >= this.m;
        int computeHorizontalScrollRange = this.w.computeHorizontalScrollRange();
        int i4 = this.u;
        this.y = computeHorizontalScrollRange - i4 > 0 && this.u >= this.m;
        if (!this.x && !this.y) {
            if (this.z != 0) {
                a(0);
                return;
            }
            return;
        }
        if (this.x) {
            float f = i3;
            this.d = (int) ((f * (i2 + (f / 2.0f))) / computeVerticalScrollRange);
            this.c = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
        }
        if (this.y) {
            float f2 = i4;
            this.g = (int) ((f2 * (i + (f2 / 2.0f))) / computeHorizontalScrollRange);
            this.f = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
        }
        if (this.z == 0 || this.z == 1) {
            a(1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.z == 1) {
            boolean a2 = a(motionEvent.getX(), motionEvent.getY());
            boolean b2 = b(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!a2 && !b2) {
                return false;
            }
            if (b2) {
                this.A = 1;
                this.h = (int) motionEvent.getX();
            } else if (a2) {
                this.A = 2;
                this.e = (int) motionEvent.getY();
            }
            a(2);
        } else if (this.z != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.z == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean a2 = a(motionEvent.getX(), motionEvent.getY());
            boolean b2 = b(motionEvent.getX(), motionEvent.getY());
            if (a2 || b2) {
                if (b2) {
                    this.A = 1;
                    this.h = (int) motionEvent.getX();
                } else if (a2) {
                    this.A = 2;
                    this.e = (int) motionEvent.getY();
                }
                a(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.z == 2) {
            this.e = 0.0f;
            this.h = 0.0f;
            a(1);
            this.A = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.z == 2) {
            b();
            if (this.A == 1) {
                b(motionEvent.getX());
            }
            if (this.A == 2) {
                a(motionEvent.getY());
            }
        }
    }

    private void a(float f) {
        int[] g = g();
        float max = Math.max(g[0], Math.min(g[1], f));
        if (Math.abs(this.d - max) < 2.0f) {
            return;
        }
        int a2 = a(this.e, max, g, this.w.computeVerticalScrollRange(), this.w.computeVerticalScrollOffset(), this.v);
        if (a2 != 0) {
            this.w.scrollBy(0, a2);
        }
        this.e = max;
    }

    private void b(float f) {
        int[] h = h();
        float max = Math.max(h[0], Math.min(h[1], f));
        if (Math.abs(this.g - max) < 2.0f) {
            return;
        }
        int a2 = a(this.h, max, h, this.w.computeHorizontalScrollRange(), this.w.computeHorizontalScrollOffset(), this.u);
        if (a2 != 0) {
            this.w.scrollBy(a2, 0);
        }
        this.h = max;
    }

    private int a(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    boolean a(float f, float f2) {
        if (!e() ? f >= this.u - this.o : f <= this.o / 2) {
            if (f2 >= this.d - (this.c / 2) && f2 <= this.d + (this.c / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean b(float f, float f2) {
        return f2 >= ((float) (this.v - this.s)) && f >= ((float) (this.g - (this.f / 2))) && f <= ((float) (this.g + (this.f / 2)));
    }

    private int[] g() {
        this.B[0] = this.n;
        this.B[1] = this.v - this.n;
        return this.B;
    }

    private int[] h() {
        this.C[0] = this.n;
        this.C[1] = this.u - this.n;
        return this.C;
    }

    /* compiled from: source */
    private class a extends AnimatorListenerAdapter {
        private boolean b = false;

        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.b) {
                this.b = false;
            } else if (((Float) d.this.i.getAnimatedValue()).floatValue() == 0.0f) {
                d.this.j = 0;
                d.this.a(0);
            } else {
                d.this.j = 2;
                d.this.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.b = true;
        }
    }

    /* compiled from: source */
    private class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (255.0f * ((Float) valueAnimator.getAnimatedValue()).floatValue());
            d.this.a.setAlpha(floatValue);
            d.this.b.setAlpha(floatValue);
            d.this.a();
        }
    }
}
