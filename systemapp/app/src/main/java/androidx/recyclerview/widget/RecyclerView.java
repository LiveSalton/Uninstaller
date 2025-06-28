package androidx.recyclerview.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.h.a.d;
import androidx.core.h.w;
import androidx.core.h.x;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.a;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.e;
import androidx.recyclerview.widget.l;
import androidx.recyclerview.widget.m;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements androidx.core.h.k {
    static final Interpolator L;
    private static final int[] M = {R.attr.nestedScrollingEnabled};
    private static final int[] N = {R.attr.clipToPadding};
    private static final boolean O;
    private static final boolean P;
    private static final Class<?>[] Q;
    static final boolean a;
    static final boolean b;
    static final boolean c;
    static final boolean d;
    final u A;
    androidx.recyclerview.widget.e B;
    e.a C;
    final s D;
    boolean E;
    boolean F;
    boolean G;
    androidx.recyclerview.widget.i H;
    final int[] I;
    final int[] J;
    final List<v> K;
    private final q R;
    private SavedState S;
    private final Rect T;
    private final ArrayList<l> U;
    private l V;
    private int W;
    private List<m> aA;
    private f.b aB;
    private d aC;
    private final int[] aD;
    private androidx.core.h.m aE;
    private final int[] aF;
    private final int[] aG;
    private Runnable aH;
    private final m.b aI;
    private boolean aa;
    private int ab;
    private final AccessibilityManager ac;
    private List<j> ad;
    private int ae;
    private int af;
    private e ag;
    private EdgeEffect ah;
    private EdgeEffect ai;
    private EdgeEffect aj;
    private EdgeEffect ak;
    private int al;
    private int am;
    private VelocityTracker an;
    private int ao;
    private int ap;
    private int aq;
    private int ar;
    private int as;
    private k at;
    private final int au;
    private final int av;
    private float aw;
    private float ax;
    private boolean ay;
    private m az;
    final o e;
    androidx.recyclerview.widget.a f;
    androidx.recyclerview.widget.b g;
    final androidx.recyclerview.widget.m h;
    boolean i;
    final Runnable j;
    final Rect k;
    final RectF l;
    a m;
    i n;
    p o;
    final ArrayList<h> p;
    boolean q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    f z;

    /* compiled from: source */
    public static abstract class c {
        public void a() {
        }
    }

    /* compiled from: source */
    public interface d {
        int a(int i, int i2);
    }

    /* compiled from: source */
    public interface j {
        void a(View view);

        void b(View view);
    }

    /* compiled from: source */
    public static abstract class k {
        public abstract boolean a(int i, int i2);
    }

    /* compiled from: source */
    public interface l {
        void a(boolean z);

        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* compiled from: source */
    public static abstract class m {
        public void a(RecyclerView recyclerView, int i) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* compiled from: source */
    public interface p {
        void a(v vVar);
    }

    /* compiled from: source */
    public static abstract class t {
        public abstract View a(o oVar, int i, int i2);
    }

    public void f(int i2) {
    }

    public void g(View view) {
    }

    public void h(int i2, int i3) {
    }

    public void h(View view) {
    }

    static {
        a = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        b = Build.VERSION.SDK_INT >= 23;
        c = Build.VERSION.SDK_INT >= 16;
        d = Build.VERSION.SDK_INT >= 21;
        O = Build.VERSION.SDK_INT <= 15;
        P = Build.VERSION.SDK_INT <= 15;
        Q = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        L = new Interpolator() { // from class: androidx.recyclerview.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }

            AnonymousClass3() {
            }
        };
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.RecyclerView$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!RecyclerView.this.t || RecyclerView.this.isLayoutRequested()) {
                return;
            }
            if (!RecyclerView.this.q) {
                RecyclerView.this.requestLayout();
            } else if (RecyclerView.this.v) {
                RecyclerView.this.u = true;
            } else {
                RecyclerView.this.d();
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.RecyclerView$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RecyclerView.this.z != null) {
                RecyclerView.this.z.a();
            }
            RecyclerView.this.G = false;
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.RecyclerView$3 */
    static class AnonymousClass3 implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }

        AnonymousClass3() {
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.RecyclerView$4 */
    class AnonymousClass4 implements m.b {
        AnonymousClass4() {
        }

        @Override // androidx.recyclerview.widget.m.b
        public void a(v vVar, f.c cVar, f.c cVar2) {
            RecyclerView.this.e.c(vVar);
            RecyclerView.this.b(vVar, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.m.b
        public void b(v vVar, f.c cVar, f.c cVar2) {
            RecyclerView.this.a(vVar, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.m.b
        public void c(v vVar, f.c cVar, f.c cVar2) {
            vVar.a(false);
            if (RecyclerView.this.x) {
                if (RecyclerView.this.z.a(vVar, vVar, cVar, cVar2)) {
                    RecyclerView.this.p();
                }
            } else if (RecyclerView.this.z.c(vVar, cVar, cVar2)) {
                RecyclerView.this.p();
            }
        }

        @Override // androidx.recyclerview.widget.m.b
        public void a(v vVar) {
            RecyclerView.this.n.a(vVar.a, RecyclerView.this.e);
        }
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.R = new q();
        this.e = new o();
        this.h = new androidx.recyclerview.widget.m();
        this.j = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!RecyclerView.this.t || RecyclerView.this.isLayoutRequested()) {
                    return;
                }
                if (!RecyclerView.this.q) {
                    RecyclerView.this.requestLayout();
                } else if (RecyclerView.this.v) {
                    RecyclerView.this.u = true;
                } else {
                    RecyclerView.this.d();
                }
            }
        };
        this.k = new Rect();
        this.T = new Rect();
        this.l = new RectF();
        this.p = new ArrayList<>();
        this.U = new ArrayList<>();
        this.W = 0;
        this.x = false;
        this.y = false;
        this.ae = 0;
        this.af = 0;
        this.ag = new e();
        this.z = new androidx.recyclerview.widget.c();
        this.al = 0;
        this.am = -1;
        this.aw = Float.MIN_VALUE;
        this.ax = Float.MIN_VALUE;
        boolean z = true;
        this.ay = true;
        this.A = new u();
        this.C = d ? new e.a() : null;
        this.D = new s();
        this.E = false;
        this.F = false;
        this.aB = new g();
        this.G = false;
        this.aD = new int[2];
        this.aF = new int[2];
        this.I = new int[2];
        this.aG = new int[2];
        this.J = new int[2];
        this.K = new ArrayList();
        this.aH = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.z != null) {
                    RecyclerView.this.z.a();
                }
                RecyclerView.this.G = false;
            }
        };
        this.aI = new m.b() { // from class: androidx.recyclerview.widget.RecyclerView.4
            AnonymousClass4() {
            }

            @Override // androidx.recyclerview.widget.m.b
            public void a(v vVar, f.c cVar, f.c cVar2) {
                RecyclerView.this.e.c(vVar);
                RecyclerView.this.b(vVar, cVar, cVar2);
            }

            @Override // androidx.recyclerview.widget.m.b
            public void b(v vVar, f.c cVar, f.c cVar2) {
                RecyclerView.this.a(vVar, cVar, cVar2);
            }

            @Override // androidx.recyclerview.widget.m.b
            public void c(v vVar, f.c cVar, f.c cVar2) {
                vVar.a(false);
                if (RecyclerView.this.x) {
                    if (RecyclerView.this.z.a(vVar, vVar, cVar, cVar2)) {
                        RecyclerView.this.p();
                    }
                } else if (RecyclerView.this.z.c(vVar, cVar, cVar2)) {
                    RecyclerView.this.p();
                }
            }

            @Override // androidx.recyclerview.widget.m.b
            public void a(v vVar) {
                RecyclerView.this.n.a(vVar.a, RecyclerView.this.e);
            }
        };
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, N, i2, 0);
            this.i = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.i = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.as = viewConfiguration.getScaledTouchSlop();
        this.aw = x.a(viewConfiguration, context);
        this.ax = x.b(viewConfiguration, context);
        this.au = viewConfiguration.getScaledMinimumFlingVelocity();
        this.av = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.z.a(this.aB);
        b();
        z();
        y();
        if (w.g(this) == 0) {
            w.b((View) this, 1);
        }
        this.ac = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.i(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a.b.RecyclerView, i2, 0);
            String string = obtainStyledAttributes2.getString(a.b.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(a.b.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.s = obtainStyledAttributes2.getBoolean(a.b.RecyclerView_fastScrollEnabled, false);
            if (this.s) {
                a((StateListDrawable) obtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes2.recycle();
            a(context, string, attributeSet, i2, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, M, i2, 0);
                boolean z2 = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
                z = z2;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    String a() {
        return " " + super.toString() + ", adapter:" + this.m + ", layout:" + this.n + ", context:" + getContext();
    }

    @SuppressLint({"InlinedApi"})
    private void y() {
        if (w.a(this) == 0) {
            w.a((View) this, 8);
        }
    }

    public androidx.recyclerview.widget.i getCompatAccessibilityDelegate() {
        return this.H;
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.i iVar) {
        this.H = iVar;
        w.a(this, this.H);
    }

    private void a(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String a2 = a(context, trim);
            try {
                if (isInEditMode()) {
                    classLoader = getClass().getClassLoader();
                } else {
                    classLoader = context.getClassLoader();
                }
                Class<? extends U> asSubclass = classLoader.loadClass(a2).asSubclass(i.class);
                Object[] objArr = null;
                try {
                    constructor = asSubclass.getConstructor(Q);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    try {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a2, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((i) constructor.newInstance(objArr));
            } catch (ClassCastException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a2, e4);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a2, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a2, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e8);
            }
        }
    }

    private String a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.RecyclerView$5 */
    class AnonymousClass5 implements b.InterfaceC0042b {
        AnonymousClass5() {
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0042b
        public int a() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0042b
        public void a(View view, int i) {
            RecyclerView.this.addView(view, i);
            RecyclerView.this.l(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0042b
        public int a(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0042b
        public void a(int i) {
            View childAt = RecyclerView.this.getChildAt(i);
            if (childAt != null) {
                RecyclerView.this.k(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0042b
        public View b(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0042b
        public void b() {
            int a = a();
            for (int i = 0; i < a; i++) {
                View b = b(i);
                RecyclerView.this.k(b);
                b.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0042b
        public v b(View view) {
            return RecyclerView.e(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0042b
        public void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
            v e = RecyclerView.e(view);
            if (e != null) {
                if (!e.r() && !e.c()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + e + RecyclerView.this.a());
                }
                e.m();
            }
            RecyclerView.this.attachViewToParent(view, i, layoutParams);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0042b
        public void c(int i) {
            v e;
            View b = b(i);
            if (b != null && (e = RecyclerView.e(b)) != null) {
                if (e.r() && !e.c()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + e + RecyclerView.this.a());
                }
                e.b(256);
            }
            RecyclerView.this.detachViewFromParent(i);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0042b
        public void c(View view) {
            v e = RecyclerView.e(view);
            if (e != null) {
                e.a(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0042b
        public void d(View view) {
            v e = RecyclerView.e(view);
            if (e != null) {
                e.b(RecyclerView.this);
            }
        }
    }

    private void z() {
        this.g = new androidx.recyclerview.widget.b(new b.InterfaceC0042b() { // from class: androidx.recyclerview.widget.RecyclerView.5
            AnonymousClass5() {
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0042b
            public int a() {
                return RecyclerView.this.getChildCount();
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0042b
            public void a(View view, int i2) {
                RecyclerView.this.addView(view, i2);
                RecyclerView.this.l(view);
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0042b
            public int a(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0042b
            public void a(int i2) {
                View childAt = RecyclerView.this.getChildAt(i2);
                if (childAt != null) {
                    RecyclerView.this.k(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i2);
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0042b
            public View b(int i2) {
                return RecyclerView.this.getChildAt(i2);
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0042b
            public void b() {
                int a2 = a();
                for (int i2 = 0; i2 < a2; i2++) {
                    View b2 = b(i2);
                    RecyclerView.this.k(b2);
                    b2.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0042b
            public v b(View view) {
                return RecyclerView.e(view);
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0042b
            public void a(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                v e2 = RecyclerView.e(view);
                if (e2 != null) {
                    if (!e2.r() && !e2.c()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + e2 + RecyclerView.this.a());
                    }
                    e2.m();
                }
                RecyclerView.this.attachViewToParent(view, i2, layoutParams);
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0042b
            public void c(int i2) {
                v e2;
                View b2 = b(i2);
                if (b2 != null && (e2 = RecyclerView.e(b2)) != null) {
                    if (e2.r() && !e2.c()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + e2 + RecyclerView.this.a());
                    }
                    e2.b(256);
                }
                RecyclerView.this.detachViewFromParent(i2);
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0042b
            public void c(View view) {
                v e2 = RecyclerView.e(view);
                if (e2 != null) {
                    e2.a(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.b.InterfaceC0042b
            public void d(View view) {
                v e2 = RecyclerView.e(view);
                if (e2 != null) {
                    e2.b(RecyclerView.this);
                }
            }
        });
    }

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.RecyclerView$6 */
    class AnonymousClass6 implements a.InterfaceC0041a {
        AnonymousClass6() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0041a
        public v a(int i) {
            v a = RecyclerView.this.a(i, true);
            if (a == null || RecyclerView.this.g.c(a.a)) {
                return null;
            }
            return a;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0041a
        public void a(int i, int i2) {
            RecyclerView.this.a(i, i2, true);
            RecyclerView.this.E = true;
            RecyclerView.this.D.c += i2;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0041a
        public void b(int i, int i2) {
            RecyclerView.this.a(i, i2, false);
            RecyclerView.this.E = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0041a
        public void a(int i, int i2, Object obj) {
            RecyclerView.this.a(i, i2, obj);
            RecyclerView.this.F = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0041a
        public void a(a.b bVar) {
            c(bVar);
        }

        void c(a.b bVar) {
            int i = bVar.a;
            if (i == 4) {
                RecyclerView.this.n.a(RecyclerView.this, bVar.b, bVar.d, bVar.c);
                return;
            }
            if (i != 8) {
                switch (i) {
                    case 1:
                        RecyclerView.this.n.a(RecyclerView.this, bVar.b, bVar.d);
                        break;
                    case 2:
                        RecyclerView.this.n.b(RecyclerView.this, bVar.b, bVar.d);
                        break;
                }
                return;
            }
            RecyclerView.this.n.a(RecyclerView.this, bVar.b, bVar.d, 1);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0041a
        public void b(a.b bVar) {
            c(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0041a
        public void c(int i, int i2) {
            RecyclerView.this.g(i, i2);
            RecyclerView.this.E = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0041a
        public void d(int i, int i2) {
            RecyclerView.this.f(i, i2);
            RecyclerView.this.E = true;
        }
    }

    void b() {
        this.f = new androidx.recyclerview.widget.a(new a.InterfaceC0041a() { // from class: androidx.recyclerview.widget.RecyclerView.6
            AnonymousClass6() {
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0041a
            public v a(int i2) {
                v a2 = RecyclerView.this.a(i2, true);
                if (a2 == null || RecyclerView.this.g.c(a2.a)) {
                    return null;
                }
                return a2;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0041a
            public void a(int i2, int i22) {
                RecyclerView.this.a(i2, i22, true);
                RecyclerView.this.E = true;
                RecyclerView.this.D.c += i22;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0041a
            public void b(int i2, int i22) {
                RecyclerView.this.a(i2, i22, false);
                RecyclerView.this.E = true;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0041a
            public void a(int i2, int i22, Object obj) {
                RecyclerView.this.a(i2, i22, obj);
                RecyclerView.this.F = true;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0041a
            public void a(a.b bVar) {
                c(bVar);
            }

            void c(a.b bVar) {
                int i2 = bVar.a;
                if (i2 == 4) {
                    RecyclerView.this.n.a(RecyclerView.this, bVar.b, bVar.d, bVar.c);
                    return;
                }
                if (i2 != 8) {
                    switch (i2) {
                        case 1:
                            RecyclerView.this.n.a(RecyclerView.this, bVar.b, bVar.d);
                            break;
                        case 2:
                            RecyclerView.this.n.b(RecyclerView.this, bVar.b, bVar.d);
                            break;
                    }
                    return;
                }
                RecyclerView.this.n.a(RecyclerView.this, bVar.b, bVar.d, 1);
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0041a
            public void b(a.b bVar) {
                c(bVar);
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0041a
            public void c(int i2, int i22) {
                RecyclerView.this.g(i2, i22);
                RecyclerView.this.E = true;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0041a
            public void d(int i2, int i22) {
                RecyclerView.this.f(i2, i22);
                RecyclerView.this.E = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.r = z;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.i) {
            k();
        }
        this.i = z;
        super.setClipToPadding(z);
        if (this.t) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.i;
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i2) {
            case 0:
                break;
            case 1:
                this.as = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
                break;
        }
        this.as = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        a(aVar, false, true);
        c(false);
        requestLayout();
    }

    void c() {
        if (this.z != null) {
            this.z.d();
        }
        if (this.n != null) {
            this.n.c(this.e);
            this.n.b(this.e);
        }
        this.e.a();
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (this.m != null) {
            this.m.b(this.R);
            this.m.b(this);
        }
        if (!z || z2) {
            c();
        }
        this.f.a();
        a aVar2 = this.m;
        this.m = aVar;
        if (aVar != null) {
            aVar.a(this.R);
            aVar.a(this);
        }
        if (this.n != null) {
            this.n.a(aVar2, this.m);
        }
        this.e.a(aVar2, this.m, z);
        this.D.f = true;
    }

    public a getAdapter() {
        return this.m;
    }

    public void setRecyclerListener(p pVar) {
        this.o = pVar;
    }

    @Override // android.view.View
    public int getBaseline() {
        if (this.n != null) {
            return this.n.u();
        }
        return super.getBaseline();
    }

    public void setLayoutManager(i iVar) {
        if (iVar == this.n) {
            return;
        }
        f();
        if (this.n != null) {
            if (this.z != null) {
                this.z.d();
            }
            this.n.c(this.e);
            this.n.b(this.e);
            this.e.a();
            if (this.q) {
                this.n.b(this, this.e);
            }
            this.n.b((RecyclerView) null);
            this.n = null;
        } else {
            this.e.a();
        }
        this.g.a();
        this.n = iVar;
        if (iVar != null) {
            if (iVar.q != null) {
                throw new IllegalArgumentException("LayoutManager " + iVar + " is already attached to a RecyclerView:" + iVar.q.a());
            }
            this.n.b(this);
            if (this.q) {
                this.n.c(this);
            }
        }
        this.e.b();
        requestLayout();
    }

    public void setOnFlingListener(k kVar) {
        this.at = kVar;
    }

    public k getOnFlingListener() {
        return this.at;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.S != null) {
            savedState.a(this.S);
        } else if (this.n != null) {
            savedState.a = this.n.d();
        } else {
            savedState.a = null;
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.S = (SavedState) parcelable;
        super.onRestoreInstanceState(this.S.a());
        if (this.n == null || this.S.a == null) {
            return;
        }
        this.n.a(this.S.a);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void e(v vVar) {
        View view = vVar.a;
        boolean z = view.getParent() == this;
        this.e.c(b(view));
        if (vVar.r()) {
            this.g.a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.g.a(view, true);
        } else {
            this.g.d(view);
        }
    }

    boolean a(View view) {
        e();
        boolean f2 = this.g.f(view);
        if (f2) {
            v e2 = e(view);
            this.e.c(e2);
            this.e.b(e2);
        }
        a(!f2);
        return f2;
    }

    public i getLayoutManager() {
        return this.n;
    }

    public n getRecycledViewPool() {
        return this.e.g();
    }

    public void setRecycledViewPool(n nVar) {
        this.e.a(nVar);
    }

    public void setViewCacheExtension(t tVar) {
        this.e.a(tVar);
    }

    public void setItemViewCacheSize(int i2) {
        this.e.a(i2);
    }

    public int getScrollState() {
        return this.al;
    }

    void setScrollState(int i2) {
        if (i2 == this.al) {
            return;
        }
        this.al = i2;
        if (i2 != 2) {
            B();
        }
        g(i2);
    }

    public void a(h hVar, int i2) {
        if (this.n != null) {
            this.n.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.p.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.p.add(hVar);
        } else {
            this.p.add(i2, hVar);
        }
        r();
        requestLayout();
    }

    public void a(h hVar) {
        a(hVar, -1);
    }

    public int getItemDecorationCount() {
        return this.p.size();
    }

    public void b(h hVar) {
        if (this.n != null) {
            this.n.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.p.remove(hVar);
        if (this.p.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        r();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar == this.aC) {
            return;
        }
        this.aC = dVar;
        setChildrenDrawingOrderEnabled(this.aC != null);
    }

    @Deprecated
    public void setOnScrollListener(m mVar) {
        this.az = mVar;
    }

    public void a(m mVar) {
        if (this.aA == null) {
            this.aA = new ArrayList();
        }
        this.aA.add(mVar);
    }

    public void b(m mVar) {
        if (this.aA != null) {
            this.aA.remove(mVar);
        }
    }

    void b(int i2) {
        if (this.n == null) {
            return;
        }
        this.n.e(i2);
        awakenScrollBars();
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        if (this.n == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.v) {
            return;
        }
        boolean e2 = this.n.e();
        boolean f2 = this.n.f();
        if (e2 || f2) {
            if (!e2) {
                i2 = 0;
            }
            if (!f2) {
                i3 = 0;
            }
            a(i2, i3, (MotionEvent) null);
        }
    }

    void a(int i2, int i3, int[] iArr) {
        e();
        l();
        androidx.core.d.b.a("RV Scroll");
        a(this.D);
        int a2 = i2 != 0 ? this.n.a(i2, this.e, this.D) : 0;
        int b2 = i3 != 0 ? this.n.b(i3, this.e, this.D) : 0;
        androidx.core.d.b.a();
        w();
        m();
        a(false);
        if (iArr != null) {
            iArr[0] = a2;
            iArr[1] = b2;
        }
    }

    void d() {
        if (!this.t || this.x) {
            androidx.core.d.b.a("RV FullInvalidate");
            q();
            androidx.core.d.b.a();
            return;
        }
        if (this.f.d()) {
            if (this.f.a(4) && !this.f.a(11)) {
                androidx.core.d.b.a("RV PartialInvalidate");
                e();
                l();
                this.f.b();
                if (!this.u) {
                    if (A()) {
                        q();
                    } else {
                        this.f.c();
                    }
                }
                a(true);
                m();
                androidx.core.d.b.a();
                return;
            }
            if (this.f.d()) {
                androidx.core.d.b.a("RV FullInvalidate");
                q();
                androidx.core.d.b.a();
            }
        }
    }

    private boolean A() {
        int b2 = this.g.b();
        for (int i2 = 0; i2 < b2; i2++) {
            v e2 = e(this.g.b(i2));
            if (e2 != null && !e2.c() && e2.z()) {
                return true;
            }
        }
        return false;
    }

    boolean a(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        d();
        if (this.m != null) {
            a(i2, i3, this.J);
            int i8 = this.J[0];
            int i9 = this.J[1];
            i5 = i8;
            i6 = i9;
            i7 = i2 - i8;
            i4 = i3 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.p.isEmpty()) {
            invalidate();
        }
        int i10 = i4;
        if (a(i5, i6, i7, i4, this.aF, 0)) {
            this.aq -= this.aF[0];
            this.ar -= this.aF[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation(this.aF[0], this.aF[1]);
            }
            int[] iArr = this.aG;
            iArr[0] = iArr[0] + this.aF[0];
            int[] iArr2 = this.aG;
            iArr2[1] = iArr2[1] + this.aF[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !androidx.core.h.i.e(motionEvent, 8194)) {
                a(motionEvent.getX(), i7, motionEvent.getY(), i10);
            }
            c(i2, i3);
        }
        if (i5 != 0 || i6 != 0) {
            i(i5, i6);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i5 == 0 && i6 == 0) ? false : true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        if (this.n != null && this.n.e()) {
            return this.n.c(this.D);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        if (this.n != null && this.n.e()) {
            return this.n.e(this.D);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        if (this.n != null && this.n.e()) {
            return this.n.g(this.D);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        if (this.n != null && this.n.f()) {
            return this.n.d(this.D);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        if (this.n != null && this.n.f()) {
            return this.n.f(this.D);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        if (this.n != null && this.n.f()) {
            return this.n.h(this.D);
        }
        return 0;
    }

    void e() {
        this.W++;
        if (this.W != 1 || this.v) {
            return;
        }
        this.u = false;
    }

    void a(boolean z) {
        if (this.W < 1) {
            this.W = 1;
        }
        if (!z && !this.v) {
            this.u = false;
        }
        if (this.W == 1) {
            if (z && this.u && !this.v && this.n != null && this.m != null) {
                q();
            }
            if (!this.v) {
                this.u = false;
            }
        }
        this.W--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.v) {
            a("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.v = false;
                if (this.u && this.n != null && this.m != null) {
                    requestLayout();
                }
                this.u = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.v = true;
            this.aa = true;
            f();
        }
    }

    public void a(int i2, int i3) {
        a(i2, i3, (Interpolator) null);
    }

    public void a(int i2, int i3, Interpolator interpolator) {
        if (this.n == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.v) {
            return;
        }
        if (!this.n.e()) {
            i2 = 0;
        }
        if (!this.n.f()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        this.A.a(i2, i3, interpolator);
    }

    public boolean b(int i2, int i3) {
        if (this.n == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.v) {
            return false;
        }
        boolean e2 = this.n.e();
        boolean f2 = this.n.f();
        if (!e2 || Math.abs(i2) < this.au) {
            i2 = 0;
        }
        if (!f2 || Math.abs(i3) < this.au) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        float f3 = i2;
        float f4 = i3;
        if (!dispatchNestedPreFling(f3, f4)) {
            boolean z = e2 || f2;
            dispatchNestedFling(f3, f4, z);
            if (this.at != null && this.at.a(i2, i3)) {
                return true;
            }
            if (z) {
                int i4 = e2 ? 1 : 0;
                if (f2) {
                    i4 |= 2;
                }
                j(i4, 1);
                this.A.a(Math.max(-this.av, Math.min(i2, this.av)), Math.max(-this.av, Math.min(i3, this.av)));
                return true;
            }
        }
        return false;
    }

    public void f() {
        setScrollState(0);
        B();
    }

    private void B() {
        this.A.b();
        if (this.n != null) {
            this.n.H();
        }
    }

    public int getMinFlingVelocity() {
        return this.au;
    }

    public int getMaxFlingVelocity() {
        return this.av;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L21
            r6.g()
            android.widget.EdgeEffect r1 = r6.ah
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            androidx.core.widget.d.a(r1, r4, r9)
        L1f:
            r9 = r3
            goto L3c
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r6.h()
            android.widget.EdgeEffect r1 = r6.aj
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.d.a(r1, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L56
            r6.i()
            android.widget.EdgeEffect r9 = r6.ai
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            androidx.core.widget.d.a(r9, r1, r7)
            goto L72
        L56:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L71
            r6.j()
            android.widget.EdgeEffect r9 = r6.ak
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            androidx.core.widget.d.a(r9, r1, r2)
            goto L72
        L71:
            r3 = r9
        L72:
            if (r3 != 0) goto L7c
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            androidx.core.h.w.f(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a(float, float, float, float):void");
    }

    private void C() {
        boolean z;
        if (this.ah != null) {
            this.ah.onRelease();
            z = this.ah.isFinished();
        } else {
            z = false;
        }
        if (this.ai != null) {
            this.ai.onRelease();
            z |= this.ai.isFinished();
        }
        if (this.aj != null) {
            this.aj.onRelease();
            z |= this.aj.isFinished();
        }
        if (this.ak != null) {
            this.ak.onRelease();
            z |= this.ak.isFinished();
        }
        if (z) {
            w.f(this);
        }
    }

    void c(int i2, int i3) {
        boolean z;
        if (this.ah == null || this.ah.isFinished() || i2 <= 0) {
            z = false;
        } else {
            this.ah.onRelease();
            z = this.ah.isFinished();
        }
        if (this.aj != null && !this.aj.isFinished() && i2 < 0) {
            this.aj.onRelease();
            z |= this.aj.isFinished();
        }
        if (this.ai != null && !this.ai.isFinished() && i3 > 0) {
            this.ai.onRelease();
            z |= this.ai.isFinished();
        }
        if (this.ak != null && !this.ak.isFinished() && i3 < 0) {
            this.ak.onRelease();
            z |= this.ak.isFinished();
        }
        if (z) {
            w.f(this);
        }
    }

    void d(int i2, int i3) {
        if (i2 < 0) {
            g();
            this.ah.onAbsorb(-i2);
        } else if (i2 > 0) {
            h();
            this.aj.onAbsorb(i2);
        }
        if (i3 < 0) {
            i();
            this.ai.onAbsorb(-i3);
        } else if (i3 > 0) {
            j();
            this.ak.onAbsorb(i3);
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        w.f(this);
    }

    void g() {
        if (this.ah != null) {
            return;
        }
        this.ah = this.ag.a(this, 0);
        if (this.i) {
            this.ah.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.ah.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void h() {
        if (this.aj != null) {
            return;
        }
        this.aj = this.ag.a(this, 2);
        if (this.i) {
            this.aj.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.aj.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void i() {
        if (this.ai != null) {
            return;
        }
        this.ai = this.ag.a(this, 1);
        if (this.i) {
            this.ai.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.ai.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void j() {
        if (this.ak != null) {
            return;
        }
        this.ak = this.ag.a(this, 3);
        if (this.i) {
            this.ak.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.ak.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void k() {
        this.ak = null;
        this.ai = null;
        this.aj = null;
        this.ah = null;
    }

    public void setEdgeEffectFactory(e eVar) {
        androidx.core.g.e.a(eVar);
        this.ag = eVar;
        k();
    }

    public e getEdgeEffectFactory() {
        return this.ag;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View view2;
        boolean z;
        View d2 = this.n.d(view, i2);
        if (d2 != null) {
            return d2;
        }
        boolean z2 = (this.m == null || this.n == null || o() || this.v) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i2 == 2 || i2 == 1)) {
            if (this.n.f()) {
                int i3 = i2 == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i3) == null;
                if (O) {
                    i2 = i3;
                }
            } else {
                z = false;
            }
            if (!z && this.n.e()) {
                int i4 = (this.n.t() == 1) ^ (i2 == 2) ? 66 : 17;
                z = focusFinder.findNextFocus(this, view, i4) == null;
                if (O) {
                    i2 = i4;
                }
            }
            if (z) {
                d();
                if (c(view) == null) {
                    return null;
                }
                e();
                this.n.a(view, i2, this.e, this.D);
                a(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i2);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (findNextFocus == null && z2) {
                d();
                if (c(view) == null) {
                    return null;
                }
                e();
                view2 = this.n.a(view, i2, this.e, this.D);
                a(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return a(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        a(view2, (View) null);
        return view;
    }

    private boolean a(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || c(view2) == null) {
            return false;
        }
        if (view == null || c(view) == null) {
            return true;
        }
        this.k.set(0, 0, view.getWidth(), view.getHeight());
        this.T.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.k);
        offsetDescendantRectToMyCoords(view2, this.T);
        char c2 = 65535;
        int i4 = this.n.t() == 1 ? -1 : 1;
        if ((this.k.left < this.T.left || this.k.right <= this.T.left) && this.k.right < this.T.right) {
            i3 = 1;
        } else {
            i3 = ((this.k.right > this.T.right || this.k.left >= this.T.right) && this.k.left > this.T.left) ? -1 : 0;
        }
        if ((this.k.top < this.T.top || this.k.bottom <= this.T.top) && this.k.bottom < this.T.bottom) {
            c2 = 1;
        } else if ((this.k.bottom <= this.T.bottom && this.k.top < this.T.bottom) || this.k.top <= this.T.top) {
            c2 = 0;
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return c2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return c2 > 0;
        }
        switch (i2) {
            case 1:
                return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
            case 2:
                return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
            default:
                throw new IllegalArgumentException("Invalid direction: " + i2 + a());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.n.a(this, this.D, view, view2) && view2 != null) {
            a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void a(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.k.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.e) {
                Rect rect = layoutParams2.d;
                this.k.left -= rect.left;
                this.k.right += rect.right;
                this.k.top -= rect.top;
                this.k.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.k);
            offsetRectIntoDescendantCoords(view, this.k);
        }
        this.n.a(this, view, this.k, !this.t, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.n.a(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (this.n == null || !this.n.a(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (o()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
    
        if (r0 >= 30.0f) goto L48;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.ae = r0
            r1 = 1
            r4.q = r1
            boolean r2 = r4.t
            if (r2 == 0) goto L14
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            r4.t = r1
            androidx.recyclerview.widget.RecyclerView$i r1 = r4.n
            if (r1 == 0) goto L20
            androidx.recyclerview.widget.RecyclerView$i r1 = r4.n
            r1.c(r4)
        L20:
            r4.G = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.d
            if (r0 == 0) goto L6a
            java.lang.ThreadLocal<androidx.recyclerview.widget.e> r0 = androidx.recyclerview.widget.e.a
            java.lang.Object r0 = r0.get()
            androidx.recyclerview.widget.e r0 = (androidx.recyclerview.widget.e) r0
            r4.B = r0
            androidx.recyclerview.widget.e r0 = r4.B
            if (r0 != 0) goto L65
            androidx.recyclerview.widget.e r0 = new androidx.recyclerview.widget.e
            r0.<init>()
            r4.B = r0
            android.view.Display r0 = androidx.core.h.w.H(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L54
            if (r0 == 0) goto L54
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L54
            goto L55
        L54:
            r0 = r1
        L55:
            androidx.recyclerview.widget.e r1 = r4.B
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.d = r2
            java.lang.ThreadLocal<androidx.recyclerview.widget.e> r0 = androidx.recyclerview.widget.e.a
            androidx.recyclerview.widget.e r1 = r4.B
            r0.set(r1)
        L65:
            androidx.recyclerview.widget.e r0 = r4.B
            r0.a(r4)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.z != null) {
            this.z.d();
        }
        f();
        this.q = false;
        if (this.n != null) {
            this.n.b(this, this.e);
        }
        this.K.clear();
        removeCallbacks(this.aH);
        this.h.b();
        if (!d || this.B == null) {
            return;
        }
        this.B.b(this);
        this.B = null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.q;
    }

    void a(String str) {
        if (o()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + a());
            }
            throw new IllegalStateException(str);
        }
        if (this.af > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + a()));
        }
    }

    public void a(l lVar) {
        this.U.add(lVar);
    }

    public void b(l lVar) {
        this.U.remove(lVar);
        if (this.V == lVar) {
            this.V = null;
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.V = null;
        }
        int size = this.U.size();
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = this.U.get(i2);
            if (lVar.a(this, motionEvent) && action != 3) {
                this.V = lVar;
                return true;
            }
        }
        return false;
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.V != null) {
            if (action == 0) {
                this.V = null;
            } else {
                this.V.b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.V = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.U.size();
            for (int i2 = 0; i2 < size; i2++) {
                l lVar = this.U.get(i2);
                if (lVar.a(this, motionEvent)) {
                    this.V = lVar;
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.v) {
            return false;
        }
        if (a(motionEvent)) {
            E();
            return true;
        }
        if (this.n == null) {
            return false;
        }
        boolean e2 = this.n.e();
        boolean f2 = this.n.f();
        if (this.an == null) {
            this.an = VelocityTracker.obtain();
        }
        this.an.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        switch (actionMasked) {
            case 0:
                if (this.aa) {
                    this.aa = false;
                }
                this.am = motionEvent.getPointerId(0);
                int x = (int) (motionEvent.getX() + 0.5f);
                this.aq = x;
                this.ao = x;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.ar = y;
                this.ap = y;
                if (this.al == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                }
                int[] iArr = this.aG;
                this.aG[1] = 0;
                iArr[0] = 0;
                int i2 = e2 ? 1 : 0;
                if (f2) {
                    i2 |= 2;
                }
                j(i2, 0);
                break;
            case 1:
                this.an.clear();
                a(0);
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.am);
                if (findPointerIndex < 0) {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.am + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                if (this.al != 1) {
                    int i3 = x2 - this.ao;
                    int i4 = y2 - this.ap;
                    if (!e2 || Math.abs(i3) <= this.as) {
                        z = false;
                    } else {
                        this.aq = x2;
                        z = true;
                    }
                    if (f2 && Math.abs(i4) > this.as) {
                        this.ar = y2;
                        z = true;
                    }
                    if (z) {
                        setScrollState(1);
                        break;
                    }
                }
                break;
            case 3:
                E();
                break;
            case 5:
                this.am = motionEvent.getPointerId(actionIndex);
                int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.aq = x3;
                this.ao = x3;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.ar = y3;
                this.ap = y3;
                break;
            case 6:
                c(motionEvent);
                break;
        }
        return this.al == 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.U.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.U.get(i2).a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = false;
        if (this.v || this.aa) {
            return false;
        }
        if (b(motionEvent)) {
            E();
            return true;
        }
        if (this.n == null) {
            return false;
        }
        boolean e2 = this.n.e();
        boolean f2 = this.n.f();
        if (this.an == null) {
            this.an = VelocityTracker.obtain();
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.aG;
            this.aG[1] = 0;
            iArr[0] = 0;
        }
        obtain.offsetLocation(this.aG[0], this.aG[1]);
        switch (actionMasked) {
            case 0:
                this.am = motionEvent.getPointerId(0);
                int x = (int) (motionEvent.getX() + 0.5f);
                this.aq = x;
                this.ao = x;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.ar = y;
                this.ap = y;
                int i2 = e2 ? 1 : 0;
                if (f2) {
                    i2 |= 2;
                }
                j(i2, 0);
                break;
            case 1:
                this.an.addMovement(obtain);
                this.an.computeCurrentVelocity(1000, this.av);
                float f3 = e2 ? -this.an.getXVelocity(this.am) : 0.0f;
                float f4 = f2 ? -this.an.getYVelocity(this.am) : 0.0f;
                if ((f3 == 0.0f && f4 == 0.0f) || !b((int) f3, (int) f4)) {
                    setScrollState(0);
                }
                D();
                z2 = true;
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.am);
                if (findPointerIndex < 0) {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.am + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                int i3 = this.aq - x2;
                int i4 = this.ar - y2;
                if (a(i3, i4, this.I, this.aF, 0)) {
                    i3 -= this.I[0];
                    i4 -= this.I[1];
                    obtain.offsetLocation(this.aF[0], this.aF[1]);
                    int[] iArr2 = this.aG;
                    iArr2[0] = iArr2[0] + this.aF[0];
                    int[] iArr3 = this.aG;
                    iArr3[1] = iArr3[1] + this.aF[1];
                }
                if (this.al != 1) {
                    if (!e2 || Math.abs(i3) <= this.as) {
                        z = false;
                    } else {
                        if (i3 > 0) {
                            i3 -= this.as;
                        } else {
                            i3 += this.as;
                        }
                        z = true;
                    }
                    if (f2 && Math.abs(i4) > this.as) {
                        if (i4 > 0) {
                            i4 -= this.as;
                        } else {
                            i4 += this.as;
                        }
                        z = true;
                    }
                    if (z) {
                        setScrollState(1);
                    }
                }
                if (this.al == 1) {
                    this.aq = x2 - this.aF[0];
                    this.ar = y2 - this.aF[1];
                    if (a(e2 ? i3 : 0, f2 ? i4 : 0, obtain)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    if (this.B != null && (i3 != 0 || i4 != 0)) {
                        this.B.a(this, i3, i4);
                        break;
                    }
                }
                break;
            case 3:
                E();
                break;
            case 5:
                this.am = motionEvent.getPointerId(actionIndex);
                int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.aq = x3;
                this.ao = x3;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.ar = y3;
                this.ap = y3;
                break;
            case 6:
                c(motionEvent);
                break;
        }
        if (!z2) {
            this.an.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void D() {
        if (this.an != null) {
            this.an.clear();
        }
        a(0);
        C();
    }

    private void E() {
        D();
        setScrollState(0);
    }

    private void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.am) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.am = motionEvent.getPointerId(i2);
            int x = (int) (motionEvent.getX(i2) + 0.5f);
            this.aq = x;
            this.ao = x;
            int y = (int) (motionEvent.getY(i2) + 0.5f);
            this.ar = y;
            this.ap = y;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$i r0 = r5.n
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.v
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.RecyclerView$i r0 = r5.n
            boolean r0 = r0.f()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.RecyclerView$i r3 = r5.n
            boolean r3 = r3.e()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = r2
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$i r3 = r5.n
            boolean r3 = r3.f()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$i r3 = r5.n
            boolean r3 = r3.e()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = r2
            goto L64
        L62:
            r0 = r2
            r3 = r0
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6c:
            float r2 = r5.aw
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.ax
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.a(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.n == null) {
            e(i2, i3);
            return;
        }
        boolean z = false;
        if (this.n.c()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.n.a(this.e, this.D, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (z || this.m == null) {
                return;
            }
            if (this.D.d == 1) {
                M();
            }
            this.n.c(i2, i3);
            this.D.i = true;
            N();
            this.n.d(i2, i3);
            if (this.n.l()) {
                this.n.c(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.D.i = true;
                N();
                this.n.d(i2, i3);
                return;
            }
            return;
        }
        if (this.r) {
            this.n.a(this.e, this.D, i2, i3);
            return;
        }
        if (this.w) {
            e();
            l();
            H();
            m();
            if (this.D.k) {
                this.D.g = true;
            } else {
                this.f.e();
                this.D.g = false;
            }
            this.w = false;
            a(false);
        } else if (this.D.k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        if (this.m != null) {
            this.D.e = this.m.a();
        } else {
            this.D.e = 0;
        }
        e();
        this.n.a(this.e, this.D, i2, i3);
        a(false);
        this.D.g = false;
    }

    void e(int i2, int i3) {
        setMeasuredDimension(i.a(i2, getPaddingLeft() + getPaddingRight(), w.m(this)), i.a(i3, getPaddingTop() + getPaddingBottom(), w.n(this)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        k();
    }

    public void setItemAnimator(f fVar) {
        if (this.z != null) {
            this.z.d();
            this.z.a(null);
        }
        this.z = fVar;
        if (this.z != null) {
            this.z.a(this.aB);
        }
    }

    void l() {
        this.ae++;
    }

    void m() {
        b(true);
    }

    void b(boolean z) {
        this.ae--;
        if (this.ae < 1) {
            this.ae = 0;
            if (z) {
                F();
                x();
            }
        }
    }

    boolean n() {
        return this.ac != null && this.ac.isEnabled();
    }

    private void F() {
        int i2 = this.ab;
        this.ab = 0;
        if (i2 == 0 || !n()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(2048);
        androidx.core.h.a.b.a(obtain, i2);
        sendAccessibilityEventUnchecked(obtain);
    }

    public boolean o() {
        return this.ae > 0;
    }

    boolean a(AccessibilityEvent accessibilityEvent) {
        if (!o()) {
            return false;
        }
        int a2 = accessibilityEvent != null ? androidx.core.h.a.b.a(accessibilityEvent) : 0;
        if (a2 == 0) {
            a2 = 0;
        }
        this.ab = a2 | this.ab;
        return true;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (a(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public f getItemAnimator() {
        return this.z;
    }

    void p() {
        if (this.G || !this.q) {
            return;
        }
        w.a(this, this.aH);
        this.G = true;
    }

    private boolean G() {
        return this.z != null && this.n.b();
    }

    private void H() {
        if (this.x) {
            this.f.a();
            if (this.y) {
                this.n.a(this);
            }
        }
        if (G()) {
            this.f.b();
        } else {
            this.f.e();
        }
        boolean z = this.E || this.F;
        this.D.j = this.t && this.z != null && (this.x || z || this.n.u) && (!this.x || this.m.b());
        this.D.k = this.D.j && z && !this.x && G();
    }

    void q() {
        if (this.m == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.n == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        this.D.i = false;
        if (this.D.d == 1) {
            M();
            this.n.f(this);
            N();
        } else if (this.f.f() || this.n.y() != getWidth() || this.n.z() != getHeight()) {
            this.n.f(this);
            N();
        } else {
            this.n.f(this);
        }
        O();
    }

    private void I() {
        int e2;
        View focusedChild = (this.ay && hasFocus() && this.m != null) ? getFocusedChild() : null;
        v d2 = focusedChild != null ? d(focusedChild) : null;
        if (d2 == null) {
            J();
            return;
        }
        this.D.m = this.m.b() ? d2.g() : -1L;
        s sVar = this.D;
        if (this.x) {
            e2 = -1;
        } else {
            e2 = d2.q() ? d2.d : d2.e();
        }
        sVar.l = e2;
        this.D.n = m(d2.a);
    }

    private void J() {
        this.D.m = -1L;
        this.D.l = -1;
        this.D.n = -1;
    }

    private View K() {
        v c2;
        int i2 = this.D.l != -1 ? this.D.l : 0;
        int e2 = this.D.e();
        for (int i3 = i2; i3 < e2; i3++) {
            v c3 = c(i3);
            if (c3 == null) {
                break;
            }
            if (c3.a.hasFocusable()) {
                return c3.a;
            }
        }
        int min = Math.min(e2, i2);
        do {
            min--;
            if (min < 0 || (c2 = c(min)) == null) {
                return null;
            }
        } while (!c2.a.hasFocusable());
        return c2.a;
    }

    private void L() {
        View view;
        if (!this.ay || this.m == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (P && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.g.b() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.g.c(focusedChild)) {
                return;
            }
        }
        View view2 = null;
        v a2 = (this.D.m == -1 || !this.m.b()) ? null : a(this.D.m);
        if (a2 == null || this.g.c(a2.a) || !a2.a.hasFocusable()) {
            if (this.g.b() > 0) {
                view2 = K();
            }
        } else {
            view2 = a2.a;
        }
        if (view2 != null) {
            if (this.D.n == -1 || (view = view2.findViewById(this.D.n)) == null || !view.isFocusable()) {
                view = view2;
            }
            view.requestFocus();
        }
    }

    private int m(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    final void a(s sVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.A.a;
            sVar.o = overScroller.getFinalX() - overScroller.getCurrX();
            sVar.p = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            sVar.o = 0;
            sVar.p = 0;
        }
    }

    private void M() {
        this.D.a(1);
        a(this.D);
        this.D.i = false;
        e();
        this.h.a();
        l();
        H();
        I();
        this.D.h = this.D.j && this.F;
        this.F = false;
        this.E = false;
        this.D.g = this.D.k;
        this.D.e = this.m.a();
        a(this.aD);
        if (this.D.j) {
            int b2 = this.g.b();
            for (int i2 = 0; i2 < b2; i2++) {
                v e2 = e(this.g.b(i2));
                if (!e2.c() && (!e2.n() || this.m.b())) {
                    this.h.a(e2, this.z.a(this.D, e2, f.e(e2), e2.u()));
                    if (this.D.h && e2.z() && !e2.q() && !e2.c() && !e2.n()) {
                        this.h.a(a(e2), e2);
                    }
                }
            }
        }
        if (this.D.k) {
            s();
            boolean z = this.D.f;
            this.D.f = false;
            this.n.c(this.e, this.D);
            this.D.f = z;
            for (int i3 = 0; i3 < this.g.b(); i3++) {
                v e3 = e(this.g.b(i3));
                if (!e3.c() && !this.h.d(e3)) {
                    int e4 = f.e(e3);
                    boolean a2 = e3.a(8192);
                    if (!a2) {
                        e4 |= 4096;
                    }
                    f.c a3 = this.z.a(this.D, e3, e4, e3.u());
                    if (a2) {
                        a(e3, a3);
                    } else {
                        this.h.b(e3, a3);
                    }
                }
            }
            t();
        } else {
            t();
        }
        m();
        a(false);
        this.D.d = 2;
    }

    private void N() {
        e();
        l();
        this.D.a(6);
        this.f.e();
        this.D.e = this.m.a();
        this.D.c = 0;
        this.D.g = false;
        this.n.c(this.e, this.D);
        this.D.f = false;
        this.S = null;
        this.D.j = this.D.j && this.z != null;
        this.D.d = 4;
        m();
        a(false);
    }

    private void O() {
        this.D.a(4);
        e();
        l();
        this.D.d = 1;
        if (this.D.j) {
            for (int b2 = this.g.b() - 1; b2 >= 0; b2--) {
                v e2 = e(this.g.b(b2));
                if (!e2.c()) {
                    long a2 = a(e2);
                    f.c a3 = this.z.a(this.D, e2);
                    v a4 = this.h.a(a2);
                    if (a4 != null && !a4.c()) {
                        boolean a5 = this.h.a(a4);
                        boolean a6 = this.h.a(e2);
                        if (a5 && a4 == e2) {
                            this.h.c(e2, a3);
                        } else {
                            f.c b3 = this.h.b(a4);
                            this.h.c(e2, a3);
                            f.c c2 = this.h.c(e2);
                            if (b3 == null) {
                                a(a2, e2, a4);
                            } else {
                                a(a4, e2, b3, c2, a5, a6);
                            }
                        }
                    } else {
                        this.h.c(e2, a3);
                    }
                }
            }
            this.h.a(this.aI);
        }
        this.n.b(this.e);
        this.D.b = this.D.e;
        this.x = false;
        this.y = false;
        this.D.j = false;
        this.D.k = false;
        this.n.u = false;
        if (this.e.b != null) {
            this.e.b.clear();
        }
        if (this.n.y) {
            this.n.x = 0;
            this.n.y = false;
            this.e.b();
        }
        this.n.a(this.D);
        m();
        a(false);
        this.h.a();
        if (k(this.aD[0], this.aD[1])) {
            i(0, 0);
        }
        L();
        J();
    }

    private void a(long j2, v vVar, v vVar2) {
        int b2 = this.g.b();
        for (int i2 = 0; i2 < b2; i2++) {
            v e2 = e(this.g.b(i2));
            if (e2 != vVar && a(e2) == j2) {
                if (this.m != null && this.m.b()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + e2 + " \n View Holder 2:" + vVar + a());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + e2 + " \n View Holder 2:" + vVar + a());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + vVar2 + " cannot be found but it is necessary for " + vVar + a());
    }

    void a(v vVar, f.c cVar) {
        vVar.a(0, 8192);
        if (this.D.h && vVar.z() && !vVar.q() && !vVar.c()) {
            this.h.a(a(vVar), vVar);
        }
        this.h.a(vVar, cVar);
    }

    private void a(int[] iArr) {
        int b2 = this.g.b();
        if (b2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < b2; i4++) {
            v e2 = e(this.g.b(i4));
            if (!e2.c()) {
                int d2 = e2.d();
                if (d2 < i3) {
                    i3 = d2;
                }
                if (d2 > i2) {
                    i2 = d2;
                }
            }
        }
        iArr[0] = i3;
        iArr[1] = i2;
    }

    private boolean k(int i2, int i3) {
        a(this.aD);
        return (this.aD[0] == i2 && this.aD[1] == i3) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        v e2 = e(view);
        if (e2 != null) {
            if (e2.r()) {
                e2.m();
            } else if (!e2.c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + e2 + a());
            }
        }
        view.clearAnimation();
        k(view);
        super.removeDetachedView(view, z);
    }

    long a(v vVar) {
        return this.m.b() ? vVar.g() : vVar.c;
    }

    void a(v vVar, f.c cVar, f.c cVar2) {
        vVar.a(false);
        if (this.z.b(vVar, cVar, cVar2)) {
            p();
        }
    }

    void b(v vVar, f.c cVar, f.c cVar2) {
        e(vVar);
        vVar.a(false);
        if (this.z.a(vVar, cVar, cVar2)) {
            p();
        }
    }

    private void a(v vVar, v vVar2, f.c cVar, f.c cVar2, boolean z, boolean z2) {
        vVar.a(false);
        if (z) {
            e(vVar);
        }
        if (vVar != vVar2) {
            if (z2) {
                e(vVar2);
            }
            vVar.h = vVar2;
            e(vVar);
            this.e.c(vVar);
            vVar2.a(false);
            vVar2.i = vVar;
        }
        if (this.z.a(vVar, vVar2, cVar, cVar2)) {
            p();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        androidx.core.d.b.a("RV OnLayout");
        q();
        androidx.core.d.b.a();
        this.t = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.W == 0 && !this.v) {
            super.requestLayout();
        } else {
            this.u = true;
        }
    }

    void r() {
        int c2 = this.g.c();
        for (int i2 = 0; i2 < c2; i2++) {
            ((LayoutParams) this.g.d(i2).getLayoutParams()).e = true;
        }
        this.e.j();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        boolean z2;
        super.draw(canvas);
        int size = this.p.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.p.get(i2).a(canvas, this, this.D);
        }
        if (this.ah == null || this.ah.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.i ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            z = this.ah != null && this.ah.draw(canvas);
            canvas.restoreToCount(save);
        }
        if (this.ai != null && !this.ai.isFinished()) {
            int save2 = canvas.save();
            if (this.i) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            z |= this.ai != null && this.ai.draw(canvas);
            canvas.restoreToCount(save2);
        }
        if (this.aj != null && !this.aj.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.i ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            z |= this.aj != null && this.aj.draw(canvas);
            canvas.restoreToCount(save3);
        }
        if (this.ak == null || this.ak.isFinished()) {
            z2 = z;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.i) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            if (this.ak != null && this.ak.draw(canvas)) {
                z3 = true;
            }
            z2 = z3 | z;
            canvas.restoreToCount(save4);
        }
        if (!z2 && this.z != null && this.p.size() > 0 && this.z.b()) {
            z2 = true;
        }
        if (z2) {
            w.f(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.p.get(i2).b(canvas, this, this.D);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.n.a((LayoutParams) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.n == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
        }
        return this.n.a();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.n == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
        }
        return this.n.a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.n == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
        }
        return this.n.a(layoutParams);
    }

    void s() {
        int c2 = this.g.c();
        for (int i2 = 0; i2 < c2; i2++) {
            v e2 = e(this.g.d(i2));
            if (!e2.c()) {
                e2.b();
            }
        }
    }

    void t() {
        int c2 = this.g.c();
        for (int i2 = 0; i2 < c2; i2++) {
            v e2 = e(this.g.d(i2));
            if (!e2.c()) {
                e2.a();
            }
        }
        this.e.i();
    }

    void f(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int c2 = this.g.c();
        if (i2 < i3) {
            i4 = i3;
            i6 = -1;
            i5 = i2;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i7 = 0; i7 < c2; i7++) {
            v e2 = e(this.g.d(i7));
            if (e2 != null && e2.c >= i5 && e2.c <= i4) {
                if (e2.c == i2) {
                    e2.a(i3 - i2, false);
                } else {
                    e2.a(i6, false);
                }
                this.D.f = true;
            }
        }
        this.e.a(i2, i3);
        requestLayout();
    }

    void g(int i2, int i3) {
        int c2 = this.g.c();
        for (int i4 = 0; i4 < c2; i4++) {
            v e2 = e(this.g.d(i4));
            if (e2 != null && !e2.c() && e2.c >= i2) {
                e2.a(i3, false);
                this.D.f = true;
            }
        }
        this.e.b(i2, i3);
        requestLayout();
    }

    void a(int i2, int i3, boolean z) {
        int i4 = i2 + i3;
        int c2 = this.g.c();
        for (int i5 = 0; i5 < c2; i5++) {
            v e2 = e(this.g.d(i5));
            if (e2 != null && !e2.c()) {
                if (e2.c >= i4) {
                    e2.a(-i3, z);
                    this.D.f = true;
                } else if (e2.c >= i2) {
                    e2.a(i2 - 1, -i3, z);
                    this.D.f = true;
                }
            }
        }
        this.e.a(i2, i3, z);
        requestLayout();
    }

    void a(int i2, int i3, Object obj) {
        int c2 = this.g.c();
        int i4 = i2 + i3;
        for (int i5 = 0; i5 < c2; i5++) {
            View d2 = this.g.d(i5);
            v e2 = e(d2);
            if (e2 != null && !e2.c() && e2.c >= i2 && e2.c < i4) {
                e2.b(2);
                e2.a(obj);
                ((LayoutParams) d2.getLayoutParams()).e = true;
            }
        }
        this.e.c(i2, i3);
    }

    boolean b(v vVar) {
        return this.z == null || this.z.a(vVar, vVar.u());
    }

    void c(boolean z) {
        this.y = z | this.y;
        this.x = true;
        u();
    }

    void u() {
        int c2 = this.g.c();
        for (int i2 = 0; i2 < c2; i2++) {
            v e2 = e(this.g.d(i2));
            if (e2 != null && !e2.c()) {
                e2.b(6);
            }
        }
        r();
        this.e.h();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.ay;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.ay = z;
    }

    public v b(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return e(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View c(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            goto L18
        L17:
            r3 = 0
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.c(android.view.View):android.view.View");
    }

    public v d(View view) {
        View c2 = c(view);
        if (c2 == null) {
            return null;
        }
        return b(c2);
    }

    static v e(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).c;
    }

    public int f(View view) {
        v e2 = e(view);
        if (e2 != null) {
            return e2.d();
        }
        return -1;
    }

    public v c(int i2) {
        v vVar = null;
        if (this.x) {
            return null;
        }
        int c2 = this.g.c();
        for (int i3 = 0; i3 < c2; i3++) {
            v e2 = e(this.g.d(i3));
            if (e2 != null && !e2.q() && d(e2) == i2) {
                if (!this.g.c(e2.a)) {
                    return e2;
                }
                vVar = e2;
            }
        }
        return vVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.recyclerview.widget.RecyclerView.v a(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.b r0 = r5.g
            int r0 = r0.c()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.b r3 = r5.g
            android.view.View r3 = r3.d(r2)
            androidx.recyclerview.widget.RecyclerView$v r3 = e(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.q()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.d()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.b r1 = r5.g
            android.view.View r4 = r3.a
            boolean r1 = r1.c(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a(int, boolean):androidx.recyclerview.widget.RecyclerView$v");
    }

    public v a(long j2) {
        v vVar = null;
        if (this.m == null || !this.m.b()) {
            return null;
        }
        int c2 = this.g.c();
        for (int i2 = 0; i2 < c2; i2++) {
            v e2 = e(this.g.d(i2));
            if (e2 != null && !e2.q() && e2.g() == j2) {
                if (!this.g.c(e2.a)) {
                    return e2;
                }
                vVar = e2;
            }
        }
        return vVar;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void d(int i2) {
        int b2 = this.g.b();
        for (int i3 = 0; i3 < b2; i3++) {
            this.g.b(i3).offsetTopAndBottom(i2);
        }
    }

    public void e(int i2) {
        int b2 = this.g.b();
        for (int i3 = 0; i3 < b2; i3++) {
            this.g.b(i3).offsetLeftAndRight(i2);
        }
    }

    static void a(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.d;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, view.getRight() + rect2.right + layoutParams.rightMargin, view.getBottom() + rect2.bottom + layoutParams.bottomMargin);
    }

    Rect i(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.e) {
            return layoutParams.d;
        }
        if (this.D.a() && (layoutParams.e() || layoutParams.c())) {
            return layoutParams.d;
        }
        Rect rect = layoutParams.d;
        rect.set(0, 0, 0, 0);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.k.set(0, 0, 0, 0);
            this.p.get(i2).a(this.k, view, this, this.D);
            rect.left += this.k.left;
            rect.top += this.k.top;
            rect.right += this.k.right;
            rect.bottom += this.k.bottom;
        }
        layoutParams.e = false;
        return rect;
    }

    void i(int i2, int i3) {
        this.af++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        h(i2, i3);
        if (this.az != null) {
            this.az.a(this, i2, i3);
        }
        if (this.aA != null) {
            for (int size = this.aA.size() - 1; size >= 0; size--) {
                this.aA.get(size).a(this, i2, i3);
            }
        }
        this.af--;
    }

    void g(int i2) {
        if (this.n != null) {
            this.n.l(i2);
        }
        f(i2);
        if (this.az != null) {
            this.az.a(this, i2);
        }
        if (this.aA != null) {
            for (int size = this.aA.size() - 1; size >= 0; size--) {
                this.aA.get(size).a(this, i2);
            }
        }
    }

    public boolean v() {
        return !this.t || this.x || this.f.d();
    }

    /* compiled from: source */
    class u implements Runnable {
        OverScroller a;
        private int d;
        private int e;
        Interpolator b = RecyclerView.L;
        private boolean f = false;
        private boolean g = false;

        u() {
            this.a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.L);
        }

        /* JADX WARN: Code restructure failed: missing block: B:55:0x00f3, code lost:
        
            if (r8 > 0) goto L159;
         */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0106 A[ADDED_TO_REGION] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 432
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.u.run():void");
        }

        private void c() {
            this.g = false;
            this.f = true;
        }

        private void d() {
            this.f = false;
            if (this.g) {
                a();
            }
        }

        void a() {
            if (this.f) {
                this.g = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                w.a(RecyclerView.this, this);
            }
        }

        public void a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.e = 0;
            this.d = 0;
            this.a.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        public void b(int i, int i2) {
            a(i, i2, 0, 0);
        }

        public void a(int i, int i2, int i3, int i4) {
            a(i, i2, b(i, i2, i3, i4));
        }

        private float a(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private int b(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int sqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i6 = width / 2;
            float f = width;
            float f2 = i6;
            float a = f2 + (a(Math.min(1.0f, (sqrt2 * 1.0f) / f)) * f2);
            if (sqrt > 0) {
                i5 = 4 * Math.round(1000.0f * Math.abs(a / sqrt));
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((abs / f) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        public void a(int i, int i2, int i3) {
            a(i, i2, i3, RecyclerView.L);
        }

        public void a(int i, int i2, Interpolator interpolator) {
            int b = b(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.L;
            }
            a(i, i2, b, interpolator);
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.b != interpolator) {
                this.b = interpolator;
                this.a = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.e = 0;
            this.d = 0;
            this.a.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.a.computeScrollOffset();
            }
            a();
        }

        public void b() {
            RecyclerView.this.removeCallbacks(this);
            this.a.abortAnimation();
        }
    }

    void w() {
        int b2 = this.g.b();
        for (int i2 = 0; i2 < b2; i2++) {
            View b3 = this.g.b(i2);
            v b4 = b(b3);
            if (b4 != null && b4.i != null) {
                View view = b4.i.a;
                int left = b3.getLeft();
                int top = b3.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* compiled from: source */
    private class q extends c {
        q() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void a() {
            RecyclerView.this.a((String) null);
            RecyclerView.this.D.f = true;
            RecyclerView.this.c(true);
            if (RecyclerView.this.f.d()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }
    }

    /* compiled from: source */
    public static class e {
        protected EdgeEffect a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* compiled from: source */
    public static class n {
        SparseArray<a> a = new SparseArray<>();
        private int b = 0;

        /* compiled from: source */
        static class a {
            final ArrayList<v> a = new ArrayList<>();
            int b = 5;
            long c = 0;
            long d = 0;

            a() {
            }
        }

        public void a() {
            for (int i = 0; i < this.a.size(); i++) {
                this.a.valueAt(i).a.clear();
            }
        }

        public v a(int i) {
            a aVar = this.a.get(i);
            if (aVar == null || aVar.a.isEmpty()) {
                return null;
            }
            return aVar.a.remove(r2.size() - 1);
        }

        public void a(v vVar) {
            int h = vVar.h();
            ArrayList<v> arrayList = b(h).a;
            if (this.a.get(h).b <= arrayList.size()) {
                return;
            }
            vVar.v();
            arrayList.add(vVar);
        }

        long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        void a(int i, long j) {
            a b = b(i);
            b.c = a(b.c, j);
        }

        void b(int i, long j) {
            a b = b(i);
            b.d = a(b.d, j);
        }

        boolean a(int i, long j, long j2) {
            long j3 = b(i).c;
            return j3 == 0 || j + j3 < j2;
        }

        boolean b(int i, long j, long j2) {
            long j3 = b(i).d;
            return j3 == 0 || j + j3 < j2;
        }

        void b() {
            this.b++;
        }

        void c() {
            this.b--;
        }

        void a(a aVar, a aVar2, boolean z) {
            if (aVar != null) {
                c();
            }
            if (!z && this.b == 0) {
                a();
            }
            if (aVar2 != null) {
                b();
            }
        }

        private a b(int i) {
            a aVar = this.a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.a.put(i, aVar2);
            return aVar2;
        }
    }

    static RecyclerView j(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView j2 = j(viewGroup.getChildAt(i2));
            if (j2 != null) {
                return j2;
            }
        }
        return null;
    }

    static void c(v vVar) {
        if (vVar.b != null) {
            RecyclerView recyclerView = vVar.b.get();
            while (recyclerView != null) {
                if (recyclerView == vVar.a) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            vVar.b = null;
        }
    }

    long getNanoTime() {
        if (d) {
            return System.nanoTime();
        }
        return 0L;
    }

    /* compiled from: source */
    public final class o {
        n e;
        private t i;
        final ArrayList<v> a = new ArrayList<>();
        ArrayList<v> b = null;
        final ArrayList<v> c = new ArrayList<>();
        private final List<v> g = Collections.unmodifiableList(this.a);
        private int h = 2;
        int d = 2;

        public o() {
        }

        public void a() {
            this.a.clear();
            d();
        }

        public void a(int i) {
            this.h = i;
            b();
        }

        void b() {
            this.d = this.h + (RecyclerView.this.n != null ? RecyclerView.this.n.x : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.d; size--) {
                d(size);
            }
        }

        public List<v> c() {
            return this.g;
        }

        boolean a(v vVar) {
            if (vVar.q()) {
                return RecyclerView.this.D.a();
            }
            if (vVar.c < 0 || vVar.c >= RecyclerView.this.m.a()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + vVar + RecyclerView.this.a());
            }
            if (RecyclerView.this.D.a() || RecyclerView.this.m.a(vVar.c) == vVar.h()) {
                return !RecyclerView.this.m.b() || vVar.g() == RecyclerView.this.m.b(vVar.c);
            }
            return false;
        }

        private boolean a(v vVar, int i, int i2, long j) {
            vVar.p = RecyclerView.this;
            int h = vVar.h();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.e.b(h, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.m.b((a) vVar, i);
            this.e.b(vVar.h(), RecyclerView.this.getNanoTime() - nanoTime);
            e(vVar);
            if (!RecyclerView.this.D.a()) {
                return true;
            }
            vVar.g = i2;
            return true;
        }

        public int b(int i) {
            if (i >= 0 && i < RecyclerView.this.D.e()) {
                return !RecyclerView.this.D.a() ? i : RecyclerView.this.f.b(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.D.e() + RecyclerView.this.a());
        }

        public View c(int i) {
            return a(i, false);
        }

        View a(int i, boolean z) {
            return a(i, z, Long.MAX_VALUE).a;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0190  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x01ad  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x01d2  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0208  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0232 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0216  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x01e1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        androidx.recyclerview.widget.RecyclerView.v a(int r18, boolean r19, long r20) {
            /*
                Method dump skipped, instructions count: 625
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.a(int, boolean, long):androidx.recyclerview.widget.RecyclerView$v");
        }

        private void e(v vVar) {
            if (RecyclerView.this.n()) {
                View view = vVar.a;
                if (w.g(view) == 0) {
                    w.b(view, 1);
                }
                if (w.b(view)) {
                    return;
                }
                vVar.b(16384);
                w.a(view, RecyclerView.this.H.c());
            }
        }

        private void f(v vVar) {
            if (vVar.a instanceof ViewGroup) {
                a((ViewGroup) vVar.a, false);
            }
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public void a(View view) {
            v e = RecyclerView.e(view);
            if (e.r()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (e.i()) {
                e.j();
            } else if (e.k()) {
                e.l();
            }
            b(e);
        }

        void d() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                d(size);
            }
            this.c.clear();
            if (RecyclerView.d) {
                RecyclerView.this.C.a();
            }
        }

        void d(int i) {
            a(this.c.get(i), true);
            this.c.remove(i);
        }

        void b(v vVar) {
            boolean z;
            if (vVar.i() || vVar.a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(vVar.i());
                sb.append(" isAttached:");
                sb.append(vVar.a.getParent() != null);
                sb.append(RecyclerView.this.a());
                throw new IllegalArgumentException(sb.toString());
            }
            if (vVar.r()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + vVar + RecyclerView.this.a());
            }
            if (vVar.c()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.a());
            }
            boolean y = vVar.y();
            if ((RecyclerView.this.m != null && y && RecyclerView.this.m.b((a) vVar)) || vVar.w()) {
                if (this.d <= 0 || vVar.a(526)) {
                    z = false;
                } else {
                    int size = this.c.size();
                    if (size >= this.d && size > 0) {
                        d(0);
                        size--;
                    }
                    if (RecyclerView.d && size > 0 && !RecyclerView.this.C.a(vVar.c)) {
                        int i = size - 1;
                        while (i >= 0) {
                            if (!RecyclerView.this.C.a(this.c.get(i).c)) {
                                break;
                            } else {
                                i--;
                            }
                        }
                        size = i + 1;
                    }
                    this.c.add(size, vVar);
                    z = true;
                }
                if (!z) {
                    a(vVar, true);
                    r1 = true;
                }
            } else {
                z = false;
            }
            RecyclerView.this.h.g(vVar);
            if (z || r1 || !y) {
                return;
            }
            vVar.p = null;
        }

        void a(v vVar, boolean z) {
            RecyclerView.c(vVar);
            if (vVar.a(16384)) {
                vVar.a(0, 16384);
                w.a(vVar.a, (androidx.core.h.a) null);
            }
            if (z) {
                d(vVar);
            }
            vVar.p = null;
            g().a(vVar);
        }

        void b(View view) {
            v e = RecyclerView.e(view);
            e.m = null;
            e.n = false;
            e.l();
            b(e);
        }

        void c(View view) {
            v e = RecyclerView.e(view);
            if (e.a(12) || !e.z() || RecyclerView.this.b(e)) {
                if (e.n() && !e.q() && !RecyclerView.this.m.b()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.a());
                }
                e.a(this, false);
                this.a.add(e);
                return;
            }
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
            e.a(this, true);
            this.b.add(e);
        }

        void c(v vVar) {
            if (vVar.n) {
                this.b.remove(vVar);
            } else {
                this.a.remove(vVar);
            }
            vVar.m = null;
            vVar.n = false;
            vVar.l();
        }

        int e() {
            return this.a.size();
        }

        View e(int i) {
            return this.a.get(i).a;
        }

        void f() {
            this.a.clear();
            if (this.b != null) {
                this.b.clear();
            }
        }

        v f(int i) {
            int size;
            int b;
            if (this.b == null || (size = this.b.size()) == 0) {
                return null;
            }
            for (int i2 = 0; i2 < size; i2++) {
                v vVar = this.b.get(i2);
                if (!vVar.k() && vVar.d() == i) {
                    vVar.b(32);
                    return vVar;
                }
            }
            if (RecyclerView.this.m.b() && (b = RecyclerView.this.f.b(i)) > 0 && b < RecyclerView.this.m.a()) {
                long b2 = RecyclerView.this.m.b(b);
                for (int i3 = 0; i3 < size; i3++) {
                    v vVar2 = this.b.get(i3);
                    if (!vVar2.k() && vVar2.g() == b2) {
                        vVar2.b(32);
                        return vVar2;
                    }
                }
            }
            return null;
        }

        v b(int i, boolean z) {
            View c;
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                v vVar = this.a.get(i2);
                if (!vVar.k() && vVar.d() == i && !vVar.n() && (RecyclerView.this.D.g || !vVar.q())) {
                    vVar.b(32);
                    return vVar;
                }
            }
            if (!z && (c = RecyclerView.this.g.c(i)) != null) {
                v e = RecyclerView.e(c);
                RecyclerView.this.g.e(c);
                int b = RecyclerView.this.g.b(c);
                if (b == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + e + RecyclerView.this.a());
                }
                RecyclerView.this.g.e(b);
                c(c);
                e.b(8224);
                return e;
            }
            int size2 = this.c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                v vVar2 = this.c.get(i3);
                if (!vVar2.n() && vVar2.d() == i) {
                    if (!z) {
                        this.c.remove(i3);
                    }
                    return vVar2;
                }
            }
            return null;
        }

        v a(long j, int i, boolean z) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                v vVar = this.a.get(size);
                if (vVar.g() == j && !vVar.k()) {
                    if (i == vVar.h()) {
                        vVar.b(32);
                        if (vVar.q() && !RecyclerView.this.D.a()) {
                            vVar.a(2, 14);
                        }
                        return vVar;
                    }
                    if (!z) {
                        this.a.remove(size);
                        RecyclerView.this.removeDetachedView(vVar.a, false);
                        b(vVar.a);
                    }
                }
            }
            int size2 = this.c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                v vVar2 = this.c.get(size2);
                if (vVar2.g() == j) {
                    if (i == vVar2.h()) {
                        if (!z) {
                            this.c.remove(size2);
                        }
                        return vVar2;
                    }
                    if (!z) {
                        d(size2);
                        return null;
                    }
                }
            }
        }

        void d(v vVar) {
            if (RecyclerView.this.o != null) {
                RecyclerView.this.o.a(vVar);
            }
            if (RecyclerView.this.m != null) {
                RecyclerView.this.m.a((a) vVar);
            }
            if (RecyclerView.this.D != null) {
                RecyclerView.this.h.g(vVar);
            }
        }

        void a(a aVar, a aVar2, boolean z) {
            a();
            g().a(aVar, aVar2, z);
        }

        void a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = i2;
                i4 = -1;
                i5 = i;
            } else {
                i3 = i;
                i4 = 1;
                i5 = i2;
            }
            int size = this.c.size();
            for (int i6 = 0; i6 < size; i6++) {
                v vVar = this.c.get(i6);
                if (vVar != null && vVar.c >= i5 && vVar.c <= i3) {
                    if (vVar.c == i) {
                        vVar.a(i2 - i, false);
                    } else {
                        vVar.a(i4, false);
                    }
                }
            }
        }

        void b(int i, int i2) {
            int size = this.c.size();
            for (int i3 = 0; i3 < size; i3++) {
                v vVar = this.c.get(i3);
                if (vVar != null && vVar.c >= i) {
                    vVar.a(i2, true);
                }
            }
        }

        void a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                v vVar = this.c.get(size);
                if (vVar != null) {
                    if (vVar.c >= i3) {
                        vVar.a(-i2, z);
                    } else if (vVar.c >= i) {
                        vVar.b(8);
                        d(size);
                    }
                }
            }
        }

        void a(t tVar) {
            this.i = tVar;
        }

        void a(n nVar) {
            if (this.e != null) {
                this.e.c();
            }
            this.e = nVar;
            if (this.e == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.e.b();
        }

        n g() {
            if (this.e == null) {
                this.e = new n();
            }
            return this.e;
        }

        void c(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                v vVar = this.c.get(size);
                if (vVar != null && (i3 = vVar.c) >= i && i3 < i4) {
                    vVar.b(2);
                    d(size);
                }
            }
        }

        void h() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                v vVar = this.c.get(i);
                if (vVar != null) {
                    vVar.b(6);
                    vVar.a((Object) null);
                }
            }
            if (RecyclerView.this.m == null || !RecyclerView.this.m.b()) {
                d();
            }
        }

        void i() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                this.c.get(i).a();
            }
            int size2 = this.a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.a.get(i2).a();
            }
            if (this.b != null) {
                int size3 = this.b.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.b.get(i3).a();
                }
            }
        }

        void j() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) this.c.get(i).a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.e = true;
                }
            }
        }
    }

    /* compiled from: source */
    public static abstract class a<VH extends v> {
        private final b a = new b();
        private boolean b = false;

        public abstract int a();

        public int a(int i) {
            return 0;
        }

        public abstract VH a(ViewGroup viewGroup, int i);

        public void a(VH vh) {
        }

        public abstract void a(VH vh, int i);

        public void a(RecyclerView recyclerView) {
        }

        public long b(int i) {
            return -1L;
        }

        public void b(RecyclerView recyclerView) {
        }

        public boolean b(VH vh) {
            return false;
        }

        public void c(VH vh) {
        }

        public void d(VH vh) {
        }

        public void a(VH vh, int i, List<Object> list) {
            a((a<VH>) vh, i);
        }

        public final VH b(ViewGroup viewGroup, int i) {
            try {
                androidx.core.d.b.a("RV CreateView");
                VH a = a(viewGroup, i);
                if (a.a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                a.f = i;
                return a;
            } finally {
                androidx.core.d.b.a();
            }
        }

        public final void b(VH vh, int i) {
            vh.c = i;
            if (b()) {
                vh.e = b(i);
            }
            vh.a(1, 519);
            androidx.core.d.b.a("RV OnBindView");
            a(vh, i, vh.u());
            vh.t();
            ViewGroup.LayoutParams layoutParams = vh.a.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).e = true;
            }
            androidx.core.d.b.a();
        }

        public final boolean b() {
            return this.b;
        }

        public void a(c cVar) {
            this.a.registerObserver(cVar);
        }

        public void b(c cVar) {
            this.a.unregisterObserver(cVar);
        }

        public final void c() {
            this.a.a();
        }
    }

    void k(View view) {
        v e2 = e(view);
        h(view);
        if (this.m != null && e2 != null) {
            this.m.d(e2);
        }
        if (this.ad != null) {
            for (int size = this.ad.size() - 1; size >= 0; size--) {
                this.ad.get(size).b(view);
            }
        }
    }

    void l(View view) {
        v e2 = e(view);
        g(view);
        if (this.m != null && e2 != null) {
            this.m.c(e2);
        }
        if (this.ad != null) {
            for (int size = this.ad.size() - 1; size >= 0; size--) {
                this.ad.get(size).a(view);
            }
        }
    }

    /* compiled from: source */
    public static abstract class i {
        private int e;
        private int f;
        private int g;
        private int h;
        androidx.recyclerview.widget.b p;
        RecyclerView q;
        r t;
        int x;
        boolean y;
        private final l.b a = new l.b() { // from class: androidx.recyclerview.widget.RecyclerView.i.1
            AnonymousClass1() {
            }

            @Override // androidx.recyclerview.widget.l.b
            public View a(int i) {
                return i.this.i(i);
            }

            @Override // androidx.recyclerview.widget.l.b
            public int a() {
                return i.this.A();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int b() {
                return i.this.y() - i.this.C();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int a(View view) {
                return i.this.h(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            @Override // androidx.recyclerview.widget.l.b
            public int b(View view) {
                return i.this.j(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
            }
        };
        private final l.b b = new l.b() { // from class: androidx.recyclerview.widget.RecyclerView.i.2
            AnonymousClass2() {
            }

            @Override // androidx.recyclerview.widget.l.b
            public View a(int i) {
                return i.this.i(i);
            }

            @Override // androidx.recyclerview.widget.l.b
            public int a() {
                return i.this.B();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int b() {
                return i.this.z() - i.this.D();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int a(View view) {
                return i.this.i(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            @Override // androidx.recyclerview.widget.l.b
            public int b(View view) {
                return i.this.k(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
            }
        };
        androidx.recyclerview.widget.l r = new androidx.recyclerview.widget.l(this.a);
        androidx.recyclerview.widget.l s = new androidx.recyclerview.widget.l(this.b);
        boolean u = false;
        boolean v = false;
        boolean w = false;
        private boolean c = true;
        private boolean d = true;

        /* compiled from: source */
        public interface a {
            void b(int i, int i2);
        }

        /* compiled from: source */
        public static class b {
            public int a;
            public int b;
            public boolean c;
            public boolean d;
        }

        public int a(int i, o oVar, s sVar) {
            return 0;
        }

        public View a(View view, int i, o oVar, s sVar) {
            return null;
        }

        public abstract LayoutParams a();

        public void a(int i, int i2, s sVar, a aVar) {
        }

        public void a(int i, a aVar) {
        }

        public void a(Parcelable parcelable) {
        }

        public void a(a aVar, a aVar2) {
        }

        public void a(s sVar) {
        }

        public void a(RecyclerView recyclerView) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }

        public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public boolean a(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public boolean a(o oVar, s sVar, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public int b(int i, o oVar, s sVar) {
            return 0;
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
        }

        public boolean b() {
            return false;
        }

        public int c(s sVar) {
            return 0;
        }

        public void c(RecyclerView recyclerView, int i, int i2) {
        }

        public int d(o oVar, s sVar) {
            return 0;
        }

        public int d(s sVar) {
            return 0;
        }

        public Parcelable d() {
            return null;
        }

        public View d(View view, int i) {
            return null;
        }

        public void d(RecyclerView recyclerView) {
        }

        public int e(s sVar) {
            return 0;
        }

        public void e(int i) {
        }

        @Deprecated
        public void e(RecyclerView recyclerView) {
        }

        public boolean e() {
            return false;
        }

        public boolean e(o oVar, s sVar) {
            return false;
        }

        public int f(s sVar) {
            return 0;
        }

        public boolean f() {
            return false;
        }

        public int g(s sVar) {
            return 0;
        }

        public int h(s sVar) {
            return 0;
        }

        public void l(int i) {
        }

        boolean l() {
            return false;
        }

        public int u() {
            return -1;
        }

        /* compiled from: source */
        /* renamed from: androidx.recyclerview.widget.RecyclerView$i$1 */
        class AnonymousClass1 implements l.b {
            AnonymousClass1() {
            }

            @Override // androidx.recyclerview.widget.l.b
            public View a(int i) {
                return i.this.i(i);
            }

            @Override // androidx.recyclerview.widget.l.b
            public int a() {
                return i.this.A();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int b() {
                return i.this.y() - i.this.C();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int a(View view) {
                return i.this.h(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            @Override // androidx.recyclerview.widget.l.b
            public int b(View view) {
                return i.this.j(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
            }
        }

        /* compiled from: source */
        /* renamed from: androidx.recyclerview.widget.RecyclerView$i$2 */
        class AnonymousClass2 implements l.b {
            AnonymousClass2() {
            }

            @Override // androidx.recyclerview.widget.l.b
            public View a(int i) {
                return i.this.i(i);
            }

            @Override // androidx.recyclerview.widget.l.b
            public int a() {
                return i.this.B();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int b() {
                return i.this.z() - i.this.D();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int a(View view) {
                return i.this.i(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            @Override // androidx.recyclerview.widget.l.b
            public int b(View view) {
                return i.this.k(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
            }
        }

        void b(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.q = null;
                this.p = null;
                this.g = 0;
                this.h = 0;
            } else {
                this.q = recyclerView;
                this.p = recyclerView.g;
                this.g = recyclerView.getWidth();
                this.h = recyclerView.getHeight();
            }
            this.e = 1073741824;
            this.f = 1073741824;
        }

        void c(int i, int i2) {
            this.g = View.MeasureSpec.getSize(i);
            this.e = View.MeasureSpec.getMode(i);
            if (this.e == 0 && !RecyclerView.b) {
                this.g = 0;
            }
            this.h = View.MeasureSpec.getSize(i2);
            this.f = View.MeasureSpec.getMode(i2);
            if (this.f != 0 || RecyclerView.b) {
                return;
            }
            this.h = 0;
        }

        void d(int i, int i2) {
            int v = v();
            if (v == 0) {
                this.q.e(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < v; i7++) {
                View i8 = i(i7);
                Rect rect = this.q.k;
                a(i8, rect);
                if (rect.left < i3) {
                    i3 = rect.left;
                }
                if (rect.right > i4) {
                    i4 = rect.right;
                }
                if (rect.top < i6) {
                    i6 = rect.top;
                }
                if (rect.bottom > i5) {
                    i5 = rect.bottom;
                }
            }
            this.q.k.set(i3, i6, i4, i5);
            a(this.q.k, i, i2);
        }

        public void a(Rect rect, int i, int i2) {
            f(a(i, rect.width() + A() + C(), F()), a(i2, rect.height() + B() + D(), G()));
        }

        public void o() {
            if (this.q != null) {
                this.q.requestLayout();
            }
        }

        public static int a(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void a(String str) {
            if (this.q != null) {
                this.q.a(str);
            }
        }

        public boolean c() {
            return this.w;
        }

        public final boolean p() {
            return this.d;
        }

        void c(RecyclerView recyclerView) {
            this.v = true;
            d(recyclerView);
        }

        void b(RecyclerView recyclerView, o oVar) {
            this.v = false;
            a(recyclerView, oVar);
        }

        public boolean q() {
            return this.v;
        }

        public boolean a(Runnable runnable) {
            if (this.q != null) {
                return this.q.removeCallbacks(runnable);
            }
            return false;
        }

        public void a(RecyclerView recyclerView, o oVar) {
            e(recyclerView);
        }

        public boolean r() {
            return this.q != null && this.q.i;
        }

        public void c(o oVar, s sVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public LayoutParams a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public LayoutParams a(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public boolean s() {
            return this.t != null && this.t.d();
        }

        public int t() {
            return w.h(this.q);
        }

        public void a(View view) {
            a(view, -1);
        }

        public void a(View view, int i) {
            a(view, i, true);
        }

        public void b(View view) {
            b(view, -1);
        }

        public void b(View view, int i) {
            a(view, i, false);
        }

        private void a(View view, int i, boolean z) {
            v e = RecyclerView.e(view);
            if (z || e.q()) {
                this.q.h.e(e);
            } else {
                this.q.h.f(e);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (e.k() || e.i()) {
                if (e.i()) {
                    e.j();
                } else {
                    e.l();
                }
                this.p.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.q) {
                int b2 = this.p.b(view);
                if (i == -1) {
                    i = this.p.b();
                }
                if (b2 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.q.indexOfChild(view) + this.q.a());
                }
                if (b2 != i) {
                    this.q.n.e(b2, i);
                }
            } else {
                this.p.a(view, i, false);
                layoutParams.e = true;
                if (this.t != null && this.t.d()) {
                    this.t.b(view);
                }
            }
            if (layoutParams.f) {
                e.a.invalidate();
                layoutParams.f = false;
            }
        }

        public void c(View view) {
            this.p.a(view);
        }

        public void g(int i) {
            if (i(i) != null) {
                this.p.a(i);
            }
        }

        public int d(View view) {
            return ((LayoutParams) view.getLayoutParams()).f();
        }

        public View e(View view) {
            View c;
            if (this.q == null || (c = this.q.c(view)) == null || this.p.c(c)) {
                return null;
            }
            return c;
        }

        public View c(int i) {
            int v = v();
            for (int i2 = 0; i2 < v; i2++) {
                View i3 = i(i2);
                v e = RecyclerView.e(i3);
                if (e != null && e.d() == i && !e.c() && (this.q.D.a() || !e.q())) {
                    return i3;
                }
            }
            return null;
        }

        public void h(int i) {
            a(i, i(i));
        }

        private void a(int i, View view) {
            this.p.e(i);
        }

        public void a(View view, int i, LayoutParams layoutParams) {
            v e = RecyclerView.e(view);
            if (e.q()) {
                this.q.h.e(e);
            } else {
                this.q.h.f(e);
            }
            this.p.a(view, i, layoutParams, e.q());
        }

        public void c(View view, int i) {
            a(view, i, (LayoutParams) view.getLayoutParams());
        }

        public void e(int i, int i2) {
            View i3 = i(i);
            if (i3 == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.q.toString());
            }
            h(i);
            c(i3, i2);
        }

        public void a(View view, o oVar) {
            c(view);
            oVar.a(view);
        }

        public void a(int i, o oVar) {
            View i2 = i(i);
            g(i);
            oVar.a(i2);
        }

        public int v() {
            if (this.p != null) {
                return this.p.b();
            }
            return 0;
        }

        public View i(int i) {
            if (this.p != null) {
                return this.p.b(i);
            }
            return null;
        }

        public int w() {
            return this.e;
        }

        public int x() {
            return this.f;
        }

        public int y() {
            return this.g;
        }

        public int z() {
            return this.h;
        }

        public int A() {
            if (this.q != null) {
                return this.q.getPaddingLeft();
            }
            return 0;
        }

        public int B() {
            if (this.q != null) {
                return this.q.getPaddingTop();
            }
            return 0;
        }

        public int C() {
            if (this.q != null) {
                return this.q.getPaddingRight();
            }
            return 0;
        }

        public int D() {
            if (this.q != null) {
                return this.q.getPaddingBottom();
            }
            return 0;
        }

        public View E() {
            View focusedChild;
            if (this.q == null || (focusedChild = this.q.getFocusedChild()) == null || this.p.c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void j(int i) {
            if (this.q != null) {
                this.q.e(i);
            }
        }

        public void k(int i) {
            if (this.q != null) {
                this.q.d(i);
            }
        }

        public void a(o oVar) {
            for (int v = v() - 1; v >= 0; v--) {
                a(oVar, v, i(v));
            }
        }

        private void a(o oVar, int i, View view) {
            v e = RecyclerView.e(view);
            if (e.c()) {
                return;
            }
            if (e.n() && !e.q() && !this.q.m.b()) {
                g(i);
                oVar.b(e);
            } else {
                h(i);
                oVar.c(view);
                this.q.h.h(e);
            }
        }

        void b(o oVar) {
            int e = oVar.e();
            for (int i = e - 1; i >= 0; i--) {
                View e2 = oVar.e(i);
                v e3 = RecyclerView.e(e2);
                if (!e3.c()) {
                    e3.a(false);
                    if (e3.r()) {
                        this.q.removeDetachedView(e2, false);
                    }
                    if (this.q.z != null) {
                        this.q.z.d(e3);
                    }
                    e3.a(true);
                    oVar.b(e2);
                }
            }
            oVar.f();
            if (e > 0) {
                this.q.invalidate();
            }
        }

        boolean a(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.c && b(view.getMeasuredWidth(), i, layoutParams.width) && b(view.getMeasuredHeight(), i2, layoutParams.height)) ? false : true;
        }

        boolean b(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.c && b(view.getWidth(), i, layoutParams.width) && b(view.getHeight(), i2, layoutParams.height)) ? false : true;
        }

        private static boolean b(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public void a(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect i3 = this.q.i(view);
            int i4 = i + i3.left + i3.right;
            int i5 = i2 + i3.top + i3.bottom;
            int a2 = a(y(), w(), A() + C() + layoutParams.leftMargin + layoutParams.rightMargin + i4, layoutParams.width, e());
            int a3 = a(z(), x(), B() + D() + layoutParams.topMargin + layoutParams.bottomMargin + i5, layoutParams.height, f());
            if (b(view, a2, a3, layoutParams)) {
                view.measure(a2, a3);
            }
        }

        public static int a(int i, int i2, int i3, int i4, boolean z) {
            int i5;
            int i6 = i - i3;
            int i7 = 0;
            int max = Math.max(0, i6);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 == Integer.MIN_VALUE || (i2 != 0 && i2 == 1073741824)) {
                            i5 = max;
                        } else {
                            i2 = 0;
                            i5 = 0;
                        }
                        i7 = i2;
                        max = i5;
                    }
                    max = 0;
                }
                max = i4;
                i7 = 1073741824;
            } else {
                if (i4 < 0) {
                    if (i4 == -1) {
                        i7 = i2;
                    } else {
                        if (i4 == -2) {
                            if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                                i7 = Integer.MIN_VALUE;
                            }
                        }
                        max = 0;
                    }
                }
                max = i4;
                i7 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(max, i7);
        }

        public int f(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).d;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int g(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).d;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.d;
            view.layout(i + rect.left + layoutParams.leftMargin, i2 + rect.top + layoutParams.topMargin, (i3 - rect.right) - layoutParams.rightMargin, (i4 - rect.bottom) - layoutParams.bottomMargin);
        }

        public void a(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.q != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.q.l;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(View view, Rect rect) {
            RecyclerView.a(view, rect);
        }

        public int h(View view) {
            return view.getLeft() - n(view);
        }

        public int i(View view) {
            return view.getTop() - l(view);
        }

        public int j(View view) {
            return view.getRight() + o(view);
        }

        public int k(View view) {
            return view.getBottom() + m(view);
        }

        public void b(View view, Rect rect) {
            if (this.q == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.q.i(view));
            }
        }

        public int l(View view) {
            return ((LayoutParams) view.getLayoutParams()).d.top;
        }

        public int m(View view) {
            return ((LayoutParams) view.getLayoutParams()).d.bottom;
        }

        public int n(View view) {
            return ((LayoutParams) view.getLayoutParams()).d.left;
        }

        public int o(View view) {
            return ((LayoutParams) view.getLayoutParams()).d.right;
        }

        private int[] b(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int A = A();
            int B = B();
            int y = y() - C();
            int z2 = z() - D();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i = left - A;
            int min = Math.min(0, i);
            int i2 = top - B;
            int min2 = Math.min(0, i2);
            int i3 = width - y;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height - z2);
            if (t() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return a(recyclerView, view, rect, z, false);
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] b2 = b(recyclerView, view, rect, z);
            int i = b2[0];
            int i2 = b2[1];
            if ((z2 && !d(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.a(i, i2);
            }
            return true;
        }

        public boolean a(View view, boolean z, boolean z2) {
            boolean z3 = this.r.a(view, 24579) && this.s.a(view, 24579);
            return z ? z3 : !z3;
        }

        private boolean d(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int A = A();
            int B = B();
            int y = y() - C();
            int z = z() - D();
            Rect rect = this.q.k;
            a(focusedChild, rect);
            return rect.left - i < y && rect.right - i > A && rect.top - i2 < z && rect.bottom - i2 > B;
        }

        @Deprecated
        public boolean a(RecyclerView recyclerView, View view, View view2) {
            return s() || recyclerView.o();
        }

        public boolean a(RecyclerView recyclerView, s sVar, View view, View view2) {
            return a(recyclerView, view, view2);
        }

        public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
            c(recyclerView, i, i2);
        }

        public void a(o oVar, s sVar, int i, int i2) {
            this.q.e(i, i2);
        }

        public void f(int i, int i2) {
            this.q.setMeasuredDimension(i, i2);
        }

        public int F() {
            return w.m(this.q);
        }

        public int G() {
            return w.n(this.q);
        }

        void H() {
            if (this.t != null) {
                this.t.b();
            }
        }

        void a(r rVar) {
            if (this.t == rVar) {
                this.t = null;
            }
        }

        public void c(o oVar) {
            for (int v = v() - 1; v >= 0; v--) {
                if (!RecyclerView.e(i(v)).c()) {
                    a(v, oVar);
                }
            }
        }

        void a(androidx.core.h.a.d dVar) {
            a(this.q.e, this.q.D, dVar);
        }

        public void a(o oVar, s sVar, androidx.core.h.a.d dVar) {
            if (this.q.canScrollVertically(-1) || this.q.canScrollHorizontally(-1)) {
                dVar.a(8192);
                dVar.k(true);
            }
            if (this.q.canScrollVertically(1) || this.q.canScrollHorizontally(1)) {
                dVar.a(4096);
                dVar.k(true);
            }
            dVar.a(d.b.a(a(oVar, sVar), b(oVar, sVar), e(oVar, sVar), d(oVar, sVar)));
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            a(this.q.e, this.q.D, accessibilityEvent);
        }

        public void a(o oVar, s sVar, AccessibilityEvent accessibilityEvent) {
            if (this.q == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!this.q.canScrollVertically(1) && !this.q.canScrollVertically(-1) && !this.q.canScrollHorizontally(-1) && !this.q.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            if (this.q.m != null) {
                accessibilityEvent.setItemCount(this.q.m.a());
            }
        }

        void a(View view, androidx.core.h.a.d dVar) {
            v e = RecyclerView.e(view);
            if (e == null || e.q() || this.p.c(e.a)) {
                return;
            }
            a(this.q.e, this.q.D, view, dVar);
        }

        public void a(o oVar, s sVar, View view, androidx.core.h.a.d dVar) {
            dVar.b(d.c.a(f() ? d(view) : 0, 1, e() ? d(view) : 0, 1, false, false));
        }

        public void I() {
            this.u = true;
        }

        public int a(o oVar, s sVar) {
            if (this.q == null || this.q.m == null || !f()) {
                return 1;
            }
            return this.q.m.a();
        }

        public int b(o oVar, s sVar) {
            if (this.q == null || this.q.m == null || !e()) {
                return 1;
            }
            return this.q.m.a();
        }

        boolean a(int i, Bundle bundle) {
            return a(this.q.e, this.q.D, i, bundle);
        }

        public boolean a(o oVar, s sVar, int i, Bundle bundle) {
            int z;
            int y;
            if (this.q == null) {
                return false;
            }
            if (i == 4096) {
                z = this.q.canScrollVertically(1) ? (z() - B()) - D() : 0;
                if (this.q.canScrollHorizontally(1)) {
                    y = (y() - A()) - C();
                }
                y = 0;
            } else if (i != 8192) {
                z = 0;
                y = 0;
            } else {
                z = this.q.canScrollVertically(-1) ? -((z() - B()) - D()) : 0;
                if (this.q.canScrollHorizontally(-1)) {
                    y = -((y() - A()) - C());
                }
                y = 0;
            }
            if (z == 0 && y == 0) {
                return false;
            }
            this.q.a(y, z);
            return true;
        }

        boolean a(View view, int i, Bundle bundle) {
            return a(this.q.e, this.q.D, view, i, bundle);
        }

        public static b a(Context context, AttributeSet attributeSet, int i, int i2) {
            b bVar = new b();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.RecyclerView, i, i2);
            bVar.a = obtainStyledAttributes.getInt(a.b.RecyclerView_android_orientation, 1);
            bVar.b = obtainStyledAttributes.getInt(a.b.RecyclerView_spanCount, 1);
            bVar.c = obtainStyledAttributes.getBoolean(a.b.RecyclerView_reverseLayout, false);
            bVar.d = obtainStyledAttributes.getBoolean(a.b.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return bVar;
        }

        void f(RecyclerView recyclerView) {
            c(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        boolean J() {
            int v = v();
            for (int i = 0; i < v; i++) {
                ViewGroup.LayoutParams layoutParams = i(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: source */
    public static abstract class h {
        @Deprecated
        public void a(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void b(Canvas canvas, RecyclerView recyclerView) {
        }

        public void b(Canvas canvas, RecyclerView recyclerView, s sVar) {
            a(canvas, recyclerView);
        }

        public void a(Canvas canvas, RecyclerView recyclerView, s sVar) {
            b(canvas, recyclerView);
        }

        @Deprecated
        public void a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
            a(rect, ((LayoutParams) view.getLayoutParams()).f(), recyclerView);
        }
    }

    /* compiled from: source */
    public static abstract class v {
        private static final List<Object> q = Collections.emptyList();
        public final View a;
        WeakReference<RecyclerView> b;
        int j;
        RecyclerView p;
        int c = -1;
        int d = -1;
        long e = -1;
        int f = -1;
        int g = -1;
        v h = null;
        v i = null;
        List<Object> k = null;
        List<Object> l = null;
        private int r = 0;
        o m = null;
        boolean n = false;
        private int s = 0;
        int o = -1;

        public v(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.a = view;
        }

        void a(int i, int i2, boolean z) {
            b(8);
            a(i2, z);
            this.c = i;
        }

        void a(int i, boolean z) {
            if (this.d == -1) {
                this.d = this.c;
            }
            if (this.g == -1) {
                this.g = this.c;
            }
            if (z) {
                this.g += i;
            }
            this.c += i;
            if (this.a.getLayoutParams() != null) {
                ((LayoutParams) this.a.getLayoutParams()).e = true;
            }
        }

        void a() {
            this.d = -1;
            this.g = -1;
        }

        void b() {
            if (this.d == -1) {
                this.d = this.c;
            }
        }

        boolean c() {
            return (this.j & 128) != 0;
        }

        public final int d() {
            return this.g == -1 ? this.c : this.g;
        }

        public final int e() {
            if (this.p == null) {
                return -1;
            }
            return this.p.d(this);
        }

        public final int f() {
            return this.d;
        }

        public final long g() {
            return this.e;
        }

        public final int h() {
            return this.f;
        }

        boolean i() {
            return this.m != null;
        }

        void j() {
            this.m.c(this);
        }

        boolean k() {
            return (this.j & 32) != 0;
        }

        void l() {
            this.j &= -33;
        }

        void m() {
            this.j &= -257;
        }

        void a(o oVar, boolean z) {
            this.m = oVar;
            this.n = z;
        }

        boolean n() {
            return (this.j & 4) != 0;
        }

        boolean o() {
            return (this.j & 2) != 0;
        }

        boolean p() {
            return (this.j & 1) != 0;
        }

        boolean q() {
            return (this.j & 8) != 0;
        }

        boolean a(int i) {
            return (i & this.j) != 0;
        }

        boolean r() {
            return (this.j & 256) != 0;
        }

        boolean s() {
            return (this.j & 512) != 0 || n();
        }

        void a(int i, int i2) {
            this.j = (i & i2) | (this.j & (~i2));
        }

        void b(int i) {
            this.j = i | this.j;
        }

        void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.j) == 0) {
                A();
                this.k.add(obj);
            }
        }

        private void A() {
            if (this.k == null) {
                this.k = new ArrayList();
                this.l = Collections.unmodifiableList(this.k);
            }
        }

        void t() {
            if (this.k != null) {
                this.k.clear();
            }
            this.j &= -1025;
        }

        List<Object> u() {
            if ((this.j & 1024) == 0) {
                if (this.k == null || this.k.size() == 0) {
                    return q;
                }
                return this.l;
            }
            return q;
        }

        void v() {
            this.j = 0;
            this.c = -1;
            this.d = -1;
            this.e = -1L;
            this.g = -1;
            this.r = 0;
            this.h = null;
            this.i = null;
            t();
            this.s = 0;
            this.o = -1;
            RecyclerView.c(this);
        }

        void a(RecyclerView recyclerView) {
            if (this.o != -1) {
                this.s = this.o;
            } else {
                this.s = w.g(this.a);
            }
            recyclerView.a(this, 4);
        }

        void b(RecyclerView recyclerView) {
            recyclerView.a(this, this.s);
            this.s = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.c + " id=" + this.e + ", oldPos=" + this.d + ", pLpos:" + this.g);
            if (i()) {
                sb.append(" scrap ");
                sb.append(this.n ? "[changeScrap]" : "[attachedScrap]");
            }
            if (n()) {
                sb.append(" invalid");
            }
            if (!p()) {
                sb.append(" unbound");
            }
            if (o()) {
                sb.append(" update");
            }
            if (q()) {
                sb.append(" removed");
            }
            if (c()) {
                sb.append(" ignored");
            }
            if (r()) {
                sb.append(" tmpDetached");
            }
            if (!w()) {
                sb.append(" not recyclable(" + this.r + ")");
            }
            if (s()) {
                sb.append(" undefined adapter position");
            }
            if (this.a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void a(boolean z) {
            this.r = z ? this.r - 1 : this.r + 1;
            if (this.r < 0) {
                this.r = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && this.r == 1) {
                this.j |= 16;
            } else if (z && this.r == 0) {
                this.j &= -17;
            }
        }

        public final boolean w() {
            return (this.j & 16) == 0 && !w.e(this.a);
        }

        boolean x() {
            return (this.j & 16) != 0;
        }

        boolean y() {
            return (this.j & 16) == 0 && w.e(this.a);
        }

        boolean z() {
            return (this.j & 2) != 0;
        }
    }

    boolean a(v vVar, int i2) {
        if (o()) {
            vVar.o = i2;
            this.K.add(vVar);
            return false;
        }
        w.b(vVar.a, i2);
        return true;
    }

    void x() {
        int i2;
        for (int size = this.K.size() - 1; size >= 0; size--) {
            v vVar = this.K.get(size);
            if (vVar.a.getParent() == this && !vVar.c() && (i2 = vVar.o) != -1) {
                w.b(vVar.a, i2);
                vVar.o = -1;
            }
        }
        this.K.clear();
    }

    int d(v vVar) {
        if (vVar.a(524) || !vVar.p()) {
            return -1;
        }
        return this.f.c(vVar.c);
    }

    void a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + a());
        }
        Resources resources = getContext().getResources();
        new androidx.recyclerview.widget.d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(a.C0040a.fastscroll_default_thickness), resources.getDimensionPixelSize(a.C0040a.fastscroll_minimum_range), resources.getDimensionPixelOffset(a.C0040a.fastscroll_margin));
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().a(z);
    }

    @Override // android.view.View, androidx.core.h.j
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().a();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().b(i2);
    }

    public boolean j(int i2, int i3) {
        return getScrollingChildHelper().a(i2, i3);
    }

    @Override // android.view.View, androidx.core.h.j
    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    @Override // androidx.core.h.k
    public void a(int i2) {
        getScrollingChildHelper().c(i2);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().b();
    }

    public boolean h(int i2) {
        return getScrollingChildHelper().a(i2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    /* compiled from: source */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        v c;
        final Rect d;
        boolean e;
        boolean f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.d = new Rect();
            this.e = true;
            this.f = false;
        }

        public boolean c() {
            return this.c.n();
        }

        public boolean d() {
            return this.c.q();
        }

        public boolean e() {
            return this.c.z();
        }

        public int f() {
            return this.c.d();
        }
    }

    /* compiled from: source */
    public static abstract class r {
        private int a;
        private RecyclerView b;
        private i c;
        private boolean d;
        private boolean e;
        private View f;
        private final a g;

        /* compiled from: source */
        public interface b {
            PointF d(int i);
        }

        protected abstract void a(int i, int i2, s sVar, a aVar);

        protected abstract void a(View view, s sVar, a aVar);

        protected abstract void f();

        public void a(int i) {
            this.a = i;
        }

        public PointF b(int i) {
            Object a2 = a();
            if (a2 instanceof b) {
                return ((b) a2).d(i);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public i a() {
            return this.c;
        }

        protected final void b() {
            if (this.e) {
                this.e = false;
                f();
                this.b.D.a = -1;
                this.f = null;
                this.a = -1;
                this.d = false;
                this.c.a(this);
                this.c = null;
                this.b = null;
            }
        }

        public boolean c() {
            return this.d;
        }

        public boolean d() {
            return this.e;
        }

        public int e() {
            return this.a;
        }

        void a(int i, int i2) {
            PointF b2;
            RecyclerView recyclerView = this.b;
            if (!this.e || this.a == -1 || recyclerView == null) {
                b();
            }
            if (this.d && this.f == null && this.c != null && (b2 = b(this.a)) != null && (b2.x != 0.0f || b2.y != 0.0f)) {
                recyclerView.a((int) Math.signum(b2.x), (int) Math.signum(b2.y), (int[]) null);
            }
            this.d = false;
            if (this.f != null) {
                if (a(this.f) == this.a) {
                    a(this.f, recyclerView.D, this.g);
                    this.g.a(recyclerView);
                    b();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f = null;
                }
            }
            if (this.e) {
                a(i, i2, recyclerView.D, this.g);
                boolean a2 = this.g.a();
                this.g.a(recyclerView);
                if (a2) {
                    if (this.e) {
                        this.d = true;
                        recyclerView.A.a();
                    } else {
                        b();
                    }
                }
            }
        }

        public int a(View view) {
            return this.b.f(view);
        }

        protected void b(View view) {
            if (a(view) == e()) {
                this.f = view;
            }
        }

        /* compiled from: source */
        public static class a {
            private int a;
            private int b;
            private int c;
            private int d;
            private Interpolator e;
            private boolean f;
            private int g;

            boolean a() {
                return this.d >= 0;
            }

            void a(RecyclerView recyclerView) {
                if (this.d >= 0) {
                    int i = this.d;
                    this.d = -1;
                    recyclerView.b(i);
                    this.f = false;
                    return;
                }
                if (this.f) {
                    b();
                    if (this.e == null) {
                        if (this.c == Integer.MIN_VALUE) {
                            recyclerView.A.b(this.a, this.b);
                        } else {
                            recyclerView.A.a(this.a, this.b, this.c);
                        }
                    } else {
                        recyclerView.A.a(this.a, this.b, this.c, this.e);
                    }
                    this.g++;
                    if (this.g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f = false;
                    return;
                }
                this.g = 0;
            }

            private void b() {
                if (this.e != null && this.c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }
        }
    }

    /* compiled from: source */
    static class b extends Observable<c> {
        b() {
        }

        public void a() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a();
            }
        }
    }

    /* compiled from: source */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.recyclerview.widget.RecyclerView.SavedState.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        Parcelable a;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readParcelable(classLoader == null ? i.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.a, 0);
        }

        void a(SavedState savedState) {
            this.a = savedState.a;
        }

        /* compiled from: source */
        /* renamed from: androidx.recyclerview.widget.RecyclerView$SavedState$1 */
        static class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }
    }

    /* compiled from: source */
    public static class s {
        int a = -1;
        int b = 0;
        int c = 0;
        int d = 1;
        int e = 0;
        boolean f = false;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        boolean k = false;
        int l;
        long m;
        int n;
        int o;
        int p;
        private SparseArray<Object> q;

        void a(int i) {
            if ((this.d & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.d));
            }
        }

        void a(a aVar) {
            this.d = 1;
            this.e = aVar.a();
            this.g = false;
            this.h = false;
            this.i = false;
        }

        public boolean a() {
            return this.g;
        }

        public boolean b() {
            return this.k;
        }

        public int c() {
            return this.a;
        }

        public boolean d() {
            return this.a != -1;
        }

        public int e() {
            return this.g ? this.b - this.c : this.e;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.a + ", mData=" + this.q + ", mItemCount=" + this.e + ", mIsMeasuring=" + this.i + ", mPreviousLayoutItemCount=" + this.b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.c + ", mStructureChanged=" + this.f + ", mInPreLayout=" + this.g + ", mRunSimpleAnimations=" + this.j + ", mRunPredictiveAnimations=" + this.k + '}';
        }
    }

    /* compiled from: source */
    private class g implements f.b {
        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.f.b
        public void a(v vVar) {
            vVar.a(true);
            if (vVar.h != null && vVar.i == null) {
                vVar.h = null;
            }
            vVar.i = null;
            if (vVar.x() || RecyclerView.this.a(vVar.a) || !vVar.r()) {
                return;
            }
            RecyclerView.this.removeDetachedView(vVar.a, false);
        }
    }

    /* compiled from: source */
    public static abstract class f {
        private b a = null;
        private ArrayList<a> b = new ArrayList<>();
        private long c = 120;
        private long d = 120;
        private long e = 250;
        private long f = 250;

        /* compiled from: source */
        public interface a {
            void a();
        }

        /* compiled from: source */
        interface b {
            void a(v vVar);
        }

        public abstract void a();

        public abstract boolean a(v vVar, c cVar, c cVar2);

        public abstract boolean a(v vVar, v vVar2, c cVar, c cVar2);

        public abstract boolean b();

        public abstract boolean b(v vVar, c cVar, c cVar2);

        public abstract boolean c(v vVar, c cVar, c cVar2);

        public abstract void d();

        public abstract void d(v vVar);

        public void g(v vVar) {
        }

        public boolean h(v vVar) {
            return true;
        }

        public long e() {
            return this.e;
        }

        public long f() {
            return this.c;
        }

        public long g() {
            return this.d;
        }

        public long h() {
            return this.f;
        }

        void a(b bVar) {
            this.a = bVar;
        }

        public c a(s sVar, v vVar, int i, List<Object> list) {
            return j().a(vVar);
        }

        public c a(s sVar, v vVar) {
            return j().a(vVar);
        }

        static int e(v vVar) {
            int i = vVar.j & 14;
            if (vVar.n()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int f = vVar.f();
            int e = vVar.e();
            return (f == -1 || e == -1 || f == e) ? i : i | 2048;
        }

        public final void f(v vVar) {
            g(vVar);
            if (this.a != null) {
                this.a.a(vVar);
            }
        }

        public boolean a(v vVar, List<Object> list) {
            return h(vVar);
        }

        public final void i() {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                this.b.get(i).a();
            }
            this.b.clear();
        }

        public c j() {
            return new c();
        }

        /* compiled from: source */
        public static class c {
            public int a;
            public int b;
            public int c;
            public int d;

            public c a(v vVar) {
                return a(vVar, 0);
            }

            public c a(v vVar, int i) {
                View view = vVar.a;
                this.a = view.getLeft();
                this.b = view.getTop();
                this.c = view.getRight();
                this.d = view.getBottom();
                return this;
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.aC == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return this.aC.a(i2, i3);
    }

    private androidx.core.h.m getScrollingChildHelper() {
        if (this.aE == null) {
            this.aE = new androidx.core.h.m(this);
        }
        return this.aE;
    }
}
