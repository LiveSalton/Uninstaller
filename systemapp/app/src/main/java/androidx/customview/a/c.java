package androidx.customview.a;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.h.w;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public class c {
    private static final Interpolator w = new Interpolator() { // from class: androidx.customview.a.c.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }

        AnonymousClass1() {
        }
    };
    private int a;
    private int b;
    private float[] d;
    private float[] e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private final int p;
    private int q;
    private OverScroller r;
    private final a s;
    private View t;
    private boolean u;
    private final ViewGroup v;
    private int c = -1;
    private final Runnable x = new Runnable() { // from class: androidx.customview.a.c.2
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d(0);
        }
    };

    /* compiled from: source */
    public static abstract class a {
        public int a(View view) {
            return 0;
        }

        public int a(View view, int i, int i2) {
            return 0;
        }

        public void a(int i) {
        }

        public void a(int i, int i2) {
        }

        public void a(View view, float f, float f2) {
        }

        public void a(View view, int i) {
        }

        public void a(View view, int i, int i2, int i3, int i4) {
        }

        public int b(View view) {
            return 0;
        }

        public int b(View view, int i, int i2) {
            return 0;
        }

        public void b(int i, int i2) {
        }

        public boolean b(int i) {
            return false;
        }

        public abstract boolean b(View view, int i);

        public int c(int i) {
            return i;
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.customview.a.c$1 */
    class AnonymousClass1 implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }

        AnonymousClass1() {
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.customview.a.c$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d(0);
        }
    }

    public static c a(ViewGroup viewGroup, a aVar) {
        return new c(viewGroup.getContext(), viewGroup, aVar);
    }

    public static c a(ViewGroup viewGroup, float f, a aVar) {
        c a2 = a(viewGroup, aVar);
        a2.b = (int) (a2.b * (1.0f / f));
        return a2;
    }

    private c(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.v = viewGroup;
        this.s = aVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.p = (int) ((20.0f * context.getResources().getDisplayMetrics().density) + 0.5f);
        this.o = this.p;
        this.b = viewConfiguration.getScaledTouchSlop();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.r = new OverScroller(context, w);
    }

    public void a(float f) {
        this.n = f;
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.q = i;
    }

    public int b() {
        return this.o;
    }

    public void b(int i) {
        this.o = i;
    }

    public int c() {
        return this.p;
    }

    public void a(View view, int i) {
        if (view.getParent() != this.v) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.v + ")");
        }
        this.t = view;
        this.c = i;
        this.s.a(view, i);
        d(1);
    }

    public View d() {
        return this.t;
    }

    public int e() {
        return this.b;
    }

    public void f() {
        this.c = -1;
        h();
        if (this.l != null) {
            this.l.recycle();
            this.l = null;
        }
    }

    public void g() {
        f();
        if (this.a == 2) {
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            this.r.abortAnimation();
            int currX2 = this.r.getCurrX();
            int currY2 = this.r.getCurrY();
            this.s.a(this.t, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        d(0);
    }

    public boolean a(View view, int i, int i2) {
        this.t = view;
        this.c = -1;
        boolean a2 = a(i, i2, 0, 0);
        if (!a2 && this.a == 0 && this.t != null) {
            this.t = null;
        }
        return a2;
    }

    public boolean a(int i, int i2) {
        if (!this.u) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        return a(i, i2, (int) this.l.getXVelocity(this.c), (int) this.l.getYVelocity(this.c));
    }

    private boolean a(int i, int i2, int i3, int i4) {
        int left = this.t.getLeft();
        int top = this.t.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.r.abortAnimation();
            d(0);
            return false;
        }
        this.r.startScroll(left, top, i5, i6, a(this.t, i5, i6, i3, i4));
        d(2);
        return true;
    }

    private int a(View view, int i, int i2, int i3, int i4) {
        int b = b(i3, (int) this.n, (int) this.m);
        int b2 = b(i4, (int) this.n, (int) this.m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) ((a(i, b, this.s.a(view)) * (b != 0 ? abs3 / i5 : abs / i6)) + (a(i2, b2, this.s.b(view)) * (b2 != 0 ? abs4 / i5 : abs2 / i6)));
    }

    private int a(int i, int i2, int i3) {
        int abs;
        if (i == 0) {
            return 0;
        }
        int width = this.v.getWidth();
        float f = width / 2;
        float b = f + (b(Math.min(1.0f, Math.abs(i) / width)) * f);
        int abs2 = Math.abs(i2);
        if (abs2 > 0) {
            abs = 4 * Math.round(1000.0f * Math.abs(b / abs2));
        } else {
            abs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    private int b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    private float a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        return abs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    private float b(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    public boolean a(boolean z) {
        if (this.a == 2) {
            boolean computeScrollOffset = this.r.computeScrollOffset();
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            int left = currX - this.t.getLeft();
            int top = currY - this.t.getTop();
            if (left != 0) {
                w.g(this.t, left);
            }
            if (top != 0) {
                w.f(this.t, top);
            }
            if (left != 0 || top != 0) {
                this.s.a(this.t, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.r.getFinalX() && currY == this.r.getFinalY()) {
                this.r.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.v.post(this.x);
                } else {
                    d(0);
                }
            }
        }
        return this.a == 2;
    }

    private void a(float f, float f2) {
        this.u = true;
        this.s.a(this.t, f, f2);
        this.u = false;
        if (this.a == 1) {
            d(0);
        }
    }

    private void h() {
        if (this.d == null) {
            return;
        }
        Arrays.fill(this.d, 0.0f);
        Arrays.fill(this.e, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    }

    private void f(int i) {
        if (this.d == null || !c(i)) {
            return;
        }
        this.d[i] = 0.0f;
        this.e[i] = 0.0f;
        this.f[i] = 0.0f;
        this.g[i] = 0.0f;
        this.h[i] = 0;
        this.i[i] = 0;
        this.j[i] = 0;
        this.k = (~(1 << i)) & this.k;
    }

    private void g(int i) {
        if (this.d == null || this.d.length <= i) {
            int i2 = i + 1;
            float[] fArr = new float[i2];
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (this.d != null) {
                System.arraycopy(this.d, 0, fArr, 0, this.d.length);
                System.arraycopy(this.e, 0, fArr2, 0, this.e.length);
                System.arraycopy(this.f, 0, fArr3, 0, this.f.length);
                System.arraycopy(this.g, 0, fArr4, 0, this.g.length);
                System.arraycopy(this.h, 0, iArr, 0, this.h.length);
                System.arraycopy(this.i, 0, iArr2, 0, this.i.length);
                System.arraycopy(this.j, 0, iArr3, 0, this.j.length);
            }
            this.d = fArr;
            this.e = fArr2;
            this.f = fArr3;
            this.g = fArr4;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
    }

    private void a(float f, float f2, int i) {
        g(i);
        float[] fArr = this.d;
        this.f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.e;
        this.g[i] = f2;
        fArr2[i] = f2;
        this.h[i] = e((int) f, (int) f2);
        this.k |= 1 << i;
    }

    private void c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (h(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f[pointerId] = x;
                this.g[pointerId] = y;
            }
        }
    }

    public boolean c(int i) {
        return ((1 << i) & this.k) != 0;
    }

    void d(int i) {
        this.v.removeCallbacks(this.x);
        if (this.a != i) {
            this.a = i;
            this.s.a(i);
            if (this.a == 0) {
                this.t = null;
            }
        }
    }

    boolean b(View view, int i) {
        if (view == this.t && this.c == i) {
            return true;
        }
        if (view == null || !this.s.b(view, i)) {
            return false;
        }
        this.c = i;
        a(view, i);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d4, code lost:
    
        if (r12 != r11) goto L125;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.a.c.a(android.view.MotionEvent):boolean");
    }

    public void b(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            f();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int i2 = 0;
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int pointerId = motionEvent.getPointerId(0);
                View d = d((int) x, (int) y);
                a(x, y, pointerId);
                b(d, pointerId);
                int i3 = this.h[pointerId];
                if ((this.q & i3) != 0) {
                    this.s.a(i3 & this.q, pointerId);
                    break;
                }
                break;
            case 1:
                if (this.a == 1) {
                    i();
                }
                f();
                break;
            case 2:
                if (this.a == 1) {
                    if (h(this.c)) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.c);
                        float x2 = motionEvent.getX(findPointerIndex);
                        float y2 = motionEvent.getY(findPointerIndex);
                        int i4 = (int) (x2 - this.f[this.c]);
                        int i5 = (int) (y2 - this.g[this.c]);
                        b(this.t.getLeft() + i4, this.t.getTop() + i5, i4, i5);
                        c(motionEvent);
                        break;
                    }
                } else {
                    int pointerCount = motionEvent.getPointerCount();
                    while (i2 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i2);
                        if (h(pointerId2)) {
                            float x3 = motionEvent.getX(i2);
                            float y3 = motionEvent.getY(i2);
                            float f = x3 - this.d[pointerId2];
                            float f2 = y3 - this.e[pointerId2];
                            b(f, f2, pointerId2);
                            if (this.a != 1) {
                                View d2 = d((int) x3, (int) y3);
                                if (a(d2, f, f2) && b(d2, pointerId2)) {
                                }
                            }
                            c(motionEvent);
                            break;
                        }
                        i2++;
                    }
                    c(motionEvent);
                }
                break;
            case 3:
                if (this.a == 1) {
                    a(0.0f, 0.0f);
                }
                f();
                break;
            case 5:
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                float x4 = motionEvent.getX(actionIndex);
                float y4 = motionEvent.getY(actionIndex);
                a(x4, y4, pointerId3);
                if (this.a == 0) {
                    b(d((int) x4, (int) y4), pointerId3);
                    int i6 = this.h[pointerId3];
                    if ((this.q & i6) != 0) {
                        this.s.a(i6 & this.q, pointerId3);
                        break;
                    }
                } else if (c((int) x4, (int) y4)) {
                    b(this.t, pointerId3);
                    break;
                }
                break;
            case 6:
                int pointerId4 = motionEvent.getPointerId(actionIndex);
                if (this.a == 1 && pointerId4 == this.c) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (true) {
                        if (i2 < pointerCount2) {
                            int pointerId5 = motionEvent.getPointerId(i2);
                            if (pointerId5 != this.c) {
                                if (d((int) motionEvent.getX(i2), (int) motionEvent.getY(i2)) == this.t && b(this.t, pointerId5)) {
                                    i = this.c;
                                }
                            }
                            i2++;
                        } else {
                            i = -1;
                        }
                    }
                    if (i == -1) {
                        i();
                    }
                }
                f(pointerId4);
                break;
        }
    }

    private void b(float f, float f2, int i) {
        int i2 = a(f, f2, i, 1) ? 1 : 0;
        if (a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.i;
            iArr[i] = iArr[i] | i2;
            this.s.b(i2, i);
        }
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.h[i] & i2) != i2 || (this.q & i2) == 0 || (this.j[i] & i2) == i2 || (this.i[i] & i2) == i2 || (abs <= this.b && abs2 <= this.b)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.s.b(i2)) {
            return (this.i[i] & i2) == 0 && abs > ((float) this.b);
        }
        int[] iArr = this.j;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    private boolean a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.s.a(view) > 0;
        boolean z2 = this.s.b(view) > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.b * this.b)) : z ? Math.abs(f) > ((float) this.b) : z2 && Math.abs(f2) > ((float) this.b);
    }

    public boolean e(int i) {
        int length = this.d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean b(int i, int i2) {
        if (!c(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f[i2] - this.d[i2];
        float f2 = this.g[i2] - this.e[i2];
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.b * this.b)) : z ? Math.abs(f) > ((float) this.b) : z2 && Math.abs(f2) > ((float) this.b);
    }

    private void i() {
        this.l.computeCurrentVelocity(1000, this.m);
        a(a(this.l.getXVelocity(this.c), this.n, this.m), a(this.l.getYVelocity(this.c), this.n, this.m));
    }

    private void b(int i, int i2, int i3, int i4) {
        int left = this.t.getLeft();
        int top = this.t.getTop();
        if (i3 != 0) {
            i = this.s.a(this.t, i, i3);
            w.g(this.t, i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.s.b(this.t, i2, i4);
            w.f(this.t, i2 - top);
        }
        int i6 = i2;
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.s.a(this.t, i5, i6, i5 - left, i6 - top);
    }

    public boolean c(int i, int i2) {
        return b(this.t, i, i2);
    }

    public boolean b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public View d(int i, int i2) {
        for (int childCount = this.v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.v.getChildAt(this.s.c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int e(int i, int i2) {
        int i3 = i < this.v.getLeft() + this.o ? 1 : 0;
        if (i2 < this.v.getTop() + this.o) {
            i3 |= 4;
        }
        if (i > this.v.getRight() - this.o) {
            i3 |= 2;
        }
        return i2 > this.v.getBottom() - this.o ? i3 | 8 : i3;
    }

    private boolean h(int i) {
        if (c(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}
