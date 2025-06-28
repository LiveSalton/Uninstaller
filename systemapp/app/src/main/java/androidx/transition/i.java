package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.transition.p;

/* compiled from: source */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class i extends ViewGroup implements f {
    ViewGroup a;
    View b;
    final View c;
    int d;
    private Matrix e;
    private final ViewTreeObserver.OnPreDrawListener f;

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* compiled from: source */
    /* renamed from: androidx.transition.i$1 */
    class AnonymousClass1 implements ViewTreeObserver.OnPreDrawListener {
        AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            androidx.core.h.w.f(i.this);
            if (i.this.a == null || i.this.b == null) {
                return true;
            }
            i.this.a.endViewTransition(i.this.b);
            androidx.core.h.w.f(i.this.a);
            i.this.a = null;
            i.this.b = null;
            return true;
        }
    }

    i(View view) {
        super(view.getContext());
        this.f = new ViewTreeObserver.OnPreDrawListener() { // from class: androidx.transition.i.1
            AnonymousClass1() {
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                androidx.core.h.w.f(i.this);
                if (i.this.a == null || i.this.b == null) {
                    return true;
                }
                i.this.a.endViewTransition(i.this.b);
                androidx.core.h.w.f(i.this.a);
                i.this.a = null;
                i.this.b = null;
                return true;
            }
        };
        this.c = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    @Override // android.view.View, androidx.transition.f
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (a(this.c) == this) {
            aj.a(this.c, i == 0 ? 4 : 0);
        }
    }

    void a(Matrix matrix) {
        this.e = matrix;
    }

    @Override // androidx.transition.f
    public void a(ViewGroup viewGroup, View view) {
        this.a = viewGroup;
        this.b = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(this.c, this);
        this.c.getViewTreeObserver().addOnPreDrawListener(this.f);
        aj.a(this.c, 4);
        if (this.c.getParent() != null) {
            ((View) this.c.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.c.getViewTreeObserver().removeOnPreDrawListener(this.f);
        aj.a(this.c, 0);
        a(this.c, (i) null);
        if (this.c.getParent() != null) {
            ((View) this.c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        b.a(canvas, true);
        canvas.setMatrix(this.e);
        aj.a(this.c, 0);
        this.c.invalidate();
        aj.a(this.c, 4);
        drawChild(canvas, this.c, getDrawingTime());
        b.a(canvas, false);
    }

    static void a(View view, View view2) {
        aj.a(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    static i a(View view) {
        return (i) view.getTag(p.a.ghost_view);
    }

    static void a(View view, i iVar) {
        view.setTag(p.a.ghost_view, iVar);
    }

    static void a(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        aj.a(viewGroup2, matrix);
        matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
        aj.b(viewGroup, matrix);
    }

    static i b(View view, ViewGroup viewGroup, Matrix matrix) {
        g gVar;
        if (!(view.getParent() instanceof ViewGroup)) {
            throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
        }
        g a = g.a(viewGroup);
        i a2 = a(view);
        int i = 0;
        if (a2 != null && (gVar = (g) a2.getParent()) != a) {
            i = a2.d;
            gVar.removeView(a2);
            a2 = null;
        }
        if (a2 == null) {
            if (matrix == null) {
                matrix = new Matrix();
                a(view, viewGroup, matrix);
            }
            a2 = new i(view);
            a2.a(matrix);
            if (a == null) {
                a = new g(viewGroup);
            } else {
                a.a();
            }
            a((View) viewGroup, (View) a);
            a((View) viewGroup, (View) a2);
            a.a(a2);
            a2.d = i;
        } else if (matrix != null) {
            a2.a(matrix);
        }
        a2.d++;
        return a2;
    }

    static void b(View view) {
        i a = a(view);
        if (a != null) {
            a.d--;
            if (a.d <= 0) {
                ((g) a.getParent()).removeView(a);
            }
        }
    }
}
