package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.h.ae;
import androidx.core.h.r;
import androidx.core.h.w;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    private int A;
    private boolean B;
    private boolean C;
    private int D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private int K;
    private VelocityTracker L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private EdgeEffect R;
    private EdgeEffect S;
    private boolean T;
    private boolean U;
    private boolean V;
    private int W;
    private List<e> aa;
    private e ab;
    private e ac;
    private List<d> ad;
    private f ae;
    private int af;
    private int ag;
    private ArrayList<View> ah;
    private final Runnable aj;
    private int ak;
    androidx.viewpager.widget.a b;
    int c;
    private int d;
    private final ArrayList<b> g;
    private final b h;
    private final Rect i;
    private int j;
    private Parcelable k;
    private ClassLoader l;
    private Scroller m;
    private boolean n;
    private g o;
    private int p;
    private Drawable q;
    private int r;
    private int s;
    private float t;
    private float u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private boolean z;
    static final int[] a = {R.attr.layout_gravity};
    private static final Comparator<b> e = new Comparator<b>() { // from class: androidx.viewpager.widget.ViewPager.1
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return bVar.b - bVar2.b;
        }
    };
    private static final Interpolator f = new Interpolator() { // from class: androidx.viewpager.widget.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }

        AnonymousClass2() {
        }
    };
    private static final h ai = new h();

    /* compiled from: source */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
    }

    /* compiled from: source */
    public interface d {
        void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2);
    }

    /* compiled from: source */
    public interface e {
        void a(int i);

        void a(int i, float f, int i2);

        void b(int i);
    }

    /* compiled from: source */
    public interface f {
        void a(View view, float f);
    }

    /* compiled from: source */
    static class b {
        Object a;
        int b;
        boolean c;
        float d;
        float e;

        b() {
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.viewpager.widget.ViewPager$1 */
    static class AnonymousClass1 implements Comparator<b> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return bVar.b - bVar2.b;
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.viewpager.widget.ViewPager$2 */
    static class AnonymousClass2 implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }

        AnonymousClass2() {
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.viewpager.widget.ViewPager$3 */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.c();
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new ArrayList<>();
        this.h = new b();
        this.i = new Rect();
        this.j = -1;
        this.k = null;
        this.l = null;
        this.t = -3.4028235E38f;
        this.u = Float.MAX_VALUE;
        this.A = 1;
        this.K = -1;
        this.T = true;
        this.U = false;
        this.aj = new Runnable() { // from class: androidx.viewpager.widget.ViewPager.3
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.c();
            }
        };
        this.ak = 0;
        a();
    }

    void a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.m = new Scroller(context, f);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.F = viewConfiguration.getScaledPagingTouchSlop();
        this.M = (int) (400.0f * f2);
        this.N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.R = new EdgeEffect(context);
        this.S = new EdgeEffect(context);
        this.O = (int) (25.0f * f2);
        this.P = (int) (2.0f * f2);
        this.D = (int) (16.0f * f2);
        w.a(this, new c());
        if (w.g(this) == 0) {
            w.b((View) this, 1);
        }
        w.a(this, new r() { // from class: androidx.viewpager.widget.ViewPager.4
            private final Rect b = new Rect();

            AnonymousClass4() {
            }

            @Override // androidx.core.h.r
            public ae a(View view, ae aeVar) {
                ae a2 = w.a(view, aeVar);
                if (a2.f()) {
                    return a2;
                }
                Rect rect = this.b;
                rect.left = a2.a();
                rect.top = a2.b();
                rect.right = a2.c();
                rect.bottom = a2.d();
                int childCount = ViewPager.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    ae b2 = w.b(ViewPager.this.getChildAt(i), a2);
                    rect.left = Math.min(b2.a(), rect.left);
                    rect.top = Math.min(b2.b(), rect.top);
                    rect.right = Math.min(b2.c(), rect.right);
                    rect.bottom = Math.min(b2.d(), rect.bottom);
                }
                return a2.a(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    /* compiled from: source */
    /* renamed from: androidx.viewpager.widget.ViewPager$4 */
    class AnonymousClass4 implements r {
        private final Rect b = new Rect();

        AnonymousClass4() {
        }

        @Override // androidx.core.h.r
        public ae a(View view, ae aeVar) {
            ae a2 = w.a(view, aeVar);
            if (a2.f()) {
                return a2;
            }
            Rect rect = this.b;
            rect.left = a2.a();
            rect.top = a2.b();
            rect.right = a2.c();
            rect.bottom = a2.d();
            int childCount = ViewPager.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ae b2 = w.b(ViewPager.this.getChildAt(i), a2);
                rect.left = Math.min(b2.a(), rect.left);
                rect.top = Math.min(b2.b(), rect.top);
                rect.right = Math.min(b2.c(), rect.right);
                rect.bottom = Math.min(b2.d(), rect.bottom);
            }
            return a2.a(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.aj);
        if (this.m != null && !this.m.isFinished()) {
            this.m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int i) {
        if (this.ak == i) {
            return;
        }
        this.ak = i;
        if (this.ae != null) {
            b(i != 0);
        }
        f(i);
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) {
        if (this.b != null) {
            this.b.c(null);
            this.b.a((ViewGroup) this);
            for (int i = 0; i < this.g.size(); i++) {
                b bVar = this.g.get(i);
                this.b.a((ViewGroup) this, bVar.b, bVar.a);
            }
            this.b.b((ViewGroup) this);
            this.g.clear();
            f();
            this.c = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a aVar2 = this.b;
        this.b = aVar;
        this.d = 0;
        if (this.b != null) {
            if (this.o == null) {
                this.o = new g();
            }
            this.b.c(this.o);
            this.z = false;
            boolean z = this.T;
            this.T = true;
            this.d = this.b.a();
            if (this.j >= 0) {
                this.b.a(this.k, this.l);
                a(this.j, false, true);
                this.j = -1;
                this.k = null;
                this.l = null;
            } else if (!z) {
                c();
            } else {
                requestLayout();
            }
        }
        if (this.ad == null || this.ad.isEmpty()) {
            return;
        }
        int size = this.ad.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.ad.get(i2).a(this, aVar2, aVar);
        }
    }

    private void f() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.b;
    }

    public void a(d dVar) {
        if (this.ad == null) {
            this.ad = new ArrayList();
        }
        this.ad.add(dVar);
    }

    public void b(d dVar) {
        if (this.ad != null) {
            this.ad.remove(dVar);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.z = false;
        a(i, !this.T, false);
    }

    public void a(int i, boolean z) {
        this.z = false;
        a(i, z, false);
    }

    public int getCurrentItem() {
        return this.c;
    }

    void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    void a(int i, boolean z, boolean z2, int i2) {
        if (this.b == null || this.b.a() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.c == i && this.g.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.b.a()) {
            i = this.b.a() - 1;
        }
        int i3 = this.A;
        if (i > this.c + i3 || i < this.c - i3) {
            for (int i4 = 0; i4 < this.g.size(); i4++) {
                this.g.get(i4).c = true;
            }
        }
        boolean z3 = this.c != i;
        if (this.T) {
            this.c = i;
            if (z3) {
                e(i);
            }
            requestLayout();
            return;
        }
        a(i);
        a(i, z, i2, z3);
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        b b2 = b(i);
        int clientWidth = b2 != null ? (int) (getClientWidth() * Math.max(this.t, Math.min(b2.e, this.u))) : 0;
        if (z) {
            a(clientWidth, 0, i2);
            if (z2) {
                e(i);
                return;
            }
            return;
        }
        if (z2) {
            e(i);
        }
        a(false);
        scrollTo(clientWidth, 0);
        d(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(e eVar) {
        this.ab = eVar;
    }

    public void a(e eVar) {
        if (this.aa == null) {
            this.aa = new ArrayList();
        }
        this.aa.add(eVar);
    }

    public void b(e eVar) {
        if (this.aa != null) {
            this.aa.remove(eVar);
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ag == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) this.ah.get(i2).getLayoutParams()).f;
    }

    e c(e eVar) {
        e eVar2 = this.ac;
        this.ac = eVar;
        return eVar2;
    }

    public int getOffscreenPageLimit() {
        return this.A;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.A) {
            this.A = i;
            c();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.p;
        this.p = i;
        int width = getWidth();
        a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.p;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(androidx.core.content.a.a(getContext(), i));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.q;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    float a(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    void a(int i, int i2, int i3) {
        int scrollX;
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if ((this.m == null || this.m.isFinished()) ? false : true) {
            scrollX = this.n ? this.m.getCurrX() : this.m.getStartX();
            this.m.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            a(false);
            c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i7;
        float a2 = f3 + (a(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f2)) * f3);
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = 4 * Math.round(1000.0f * Math.abs(a2 / abs2));
        } else {
            abs = (int) (((Math.abs(i5) / ((f2 * this.b.b(this.c)) + this.p)) + 1.0f) * 100.0f);
        }
        int min = Math.min(abs, 600);
        this.n = false;
        this.m.startScroll(i4, scrollY, i5, i6, min);
        w.f(this);
    }

    b a(int i, int i2) {
        b bVar = new b();
        bVar.b = i;
        bVar.a = this.b.a((ViewGroup) this, i);
        bVar.d = this.b.b(i);
        if (i2 < 0 || i2 >= this.g.size()) {
            this.g.add(bVar);
        } else {
            this.g.add(i2, bVar);
        }
        return bVar;
    }

    void b() {
        int a2 = this.b.a();
        this.d = a2;
        boolean z = this.g.size() < (this.A * 2) + 1 && this.g.size() < a2;
        int i = this.c;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.g.size()) {
            b bVar = this.g.get(i2);
            int a3 = this.b.a(bVar.a);
            if (a3 != -1) {
                if (a3 == -2) {
                    this.g.remove(i2);
                    i2--;
                    if (!z2) {
                        this.b.a((ViewGroup) this);
                        z2 = true;
                    }
                    this.b.a((ViewGroup) this, bVar.b, bVar.a);
                    if (this.c == bVar.b) {
                        i = Math.max(0, Math.min(this.c, a2 - 1));
                    }
                } else if (bVar.b != a3) {
                    if (bVar.b == this.c) {
                        i = a3;
                    }
                    bVar.b = a3;
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.b.b((ViewGroup) this);
        }
        Collections.sort(this.g, e);
        if (z) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                if (!layoutParams.a) {
                    layoutParams.c = 0.0f;
                }
            }
            a(i, false, true);
            requestLayout();
        }
    }

    void c() {
        a(this.c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00be, code lost:
    
        if (r8.b == r18.c) goto L219;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(int r19) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.a(int):void");
    }

    private void g() {
        if (this.ag != 0) {
            if (this.ah == null) {
                this.ah = new ArrayList<>();
            } else {
                this.ah.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ah.add(getChildAt(i));
            }
            Collections.sort(this.ah, ai);
        }
    }

    private void a(b bVar, int i, b bVar2) {
        b bVar3;
        b bVar4;
        int a2 = this.b.a();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.p / clientWidth : 0.0f;
        if (bVar2 != null) {
            int i2 = bVar2.b;
            if (i2 < bVar.b) {
                float f3 = bVar2.e + bVar2.d + f2;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= bVar.b && i4 < this.g.size()) {
                    b bVar5 = this.g.get(i4);
                    while (true) {
                        bVar4 = bVar5;
                        if (i3 <= bVar4.b || i4 >= this.g.size() - 1) {
                            break;
                        }
                        i4++;
                        bVar5 = this.g.get(i4);
                    }
                    while (i3 < bVar4.b) {
                        f3 += this.b.b(i3) + f2;
                        i3++;
                    }
                    bVar4.e = f3;
                    f3 += bVar4.d + f2;
                    i3++;
                }
            } else if (i2 > bVar.b) {
                int size = this.g.size() - 1;
                float f4 = bVar2.e;
                while (true) {
                    i2--;
                    if (i2 < bVar.b || size < 0) {
                        break;
                    }
                    b bVar6 = this.g.get(size);
                    while (true) {
                        bVar3 = bVar6;
                        if (i2 >= bVar3.b || size <= 0) {
                            break;
                        }
                        size--;
                        bVar6 = this.g.get(size);
                    }
                    while (i2 > bVar3.b) {
                        f4 -= this.b.b(i2) + f2;
                        i2--;
                    }
                    f4 -= bVar3.d + f2;
                    bVar3.e = f4;
                }
            }
        }
        int size2 = this.g.size();
        float f5 = bVar.e;
        int i5 = bVar.b - 1;
        this.t = bVar.b == 0 ? bVar.e : -3.4028235E38f;
        int i6 = a2 - 1;
        this.u = bVar.b == i6 ? (bVar.e + bVar.d) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            b bVar7 = this.g.get(i7);
            while (i5 > bVar7.b) {
                f5 -= this.b.b(i5) + f2;
                i5--;
            }
            f5 -= bVar7.d + f2;
            bVar7.e = f5;
            if (bVar7.b == 0) {
                this.t = f5;
            }
            i7--;
            i5--;
        }
        float f6 = bVar.e + bVar.d + f2;
        int i8 = bVar.b + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            b bVar8 = this.g.get(i9);
            while (i8 < bVar8.b) {
                f6 += this.b.b(i8) + f2;
                i8++;
            }
            if (bVar8.b == i6) {
                this.u = (bVar8.d + f6) - 1.0f;
            }
            bVar8.e = f6;
            f6 += bVar8.d + f2;
            i9++;
            i8++;
        }
        this.U = false;
    }

    /* compiled from: source */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.viewpager.widget.ViewPager.SavedState.1
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
        int a;
        Parcelable b;
        ClassLoader d;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeParcelable(this.b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
        }

        /* compiled from: source */
        /* renamed from: androidx.viewpager.widget.ViewPager$SavedState$1 */
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

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.a = parcel.readInt();
            this.b = parcel.readParcelable(classLoader);
            this.d = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.c;
        if (this.b != null) {
            savedState.b = this.b.b();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        if (this.b != null) {
            this.b.a(savedState.b, savedState.d);
            a(savedState.a, false, true);
        } else {
            this.j = savedState.a;
            this.k = savedState.b;
            this.l = savedState.d;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        layoutParams2.a |= c(view);
        if (this.x) {
            if (layoutParams2 != null && layoutParams2.a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.d = true;
            addViewInLayout(view, i, layoutParams);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private static boolean c(View view) {
        return view.getClass().getAnnotation(a.class) != null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    b a(View view) {
        for (int i = 0; i < this.g.size(); i++) {
            b bVar = this.g.get(i);
            if (this.b.a(view, bVar.a)) {
                return bVar;
            }
        }
        return null;
    }

    b b(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return a(view);
            }
        }
    }

    b b(int i) {
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            b bVar = this.g.get(i2);
            if (bVar.b == i) {
                return bVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.T = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i3;
        int i4;
        int i5;
        boolean z = false;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.E = Math.min(measuredWidth / 10, this.D);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = measuredHeight;
        int i7 = paddingLeft;
        int i8 = 0;
        while (true) {
            boolean z2 = true;
            int i9 = 1073741824;
            if (i8 >= childCount) {
                break;
            }
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.a) {
                int i10 = layoutParams2.b & 7;
                int i11 = layoutParams2.b & 112;
                boolean z3 = (i11 == 48 || i11 == 80) ? true : z;
                if (i10 != 3 && i10 != 5) {
                    z2 = z;
                }
                int i12 = Integer.MIN_VALUE;
                if (z3) {
                    i3 = Integer.MIN_VALUE;
                    i12 = 1073741824;
                } else {
                    i3 = z2 ? 1073741824 : Integer.MIN_VALUE;
                }
                if (layoutParams2.width != -2) {
                    i4 = layoutParams2.width != -1 ? layoutParams2.width : i7;
                    i12 = 1073741824;
                } else {
                    i4 = i7;
                }
                if (layoutParams2.height != -2) {
                    i5 = layoutParams2.height != -1 ? layoutParams2.height : i6;
                } else {
                    i5 = i6;
                    i9 = i3;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i12), View.MeasureSpec.makeMeasureSpec(i5, i9));
                if (z3) {
                    i6 -= childAt.getMeasuredHeight();
                } else if (z2) {
                    i7 -= childAt.getMeasuredWidth();
                }
            }
            i8++;
            z = false;
        }
        this.v = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        this.w = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        this.x = true;
        c();
        this.x = false;
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (i7 * layoutParams.c), 1073741824), this.w);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            a(i, i3, this.p, this.p);
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.g.isEmpty()) {
            if (!this.m.isFinished()) {
                this.m.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        b b2 = b(this.c);
        int min = (int) ((b2 != null ? Math.min(b2.e, this.u) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            a(false);
            scrollTo(min, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        b a2;
        int max;
        int max2;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = paddingBottom;
        int i8 = 0;
        int i9 = paddingTop;
        int i10 = paddingLeft;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.a) {
                    int i12 = layoutParams.b & 7;
                    int i13 = layoutParams.b & 112;
                    if (i12 == 1) {
                        max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, i10);
                    } else if (i12 == 3) {
                        max = i10;
                        i10 = childAt.getMeasuredWidth() + i10;
                    } else if (i12 != 5) {
                        max = i10;
                    } else {
                        max = (i5 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i13 == 16) {
                        max2 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, i9);
                    } else if (i13 == 48) {
                        max2 = i9;
                        i9 = childAt.getMeasuredHeight() + i9;
                    } else if (i13 != 80) {
                        max2 = i9;
                    } else {
                        max2 = (i6 - i7) - childAt.getMeasuredHeight();
                        i7 += childAt.getMeasuredHeight();
                    }
                    int i14 = max + scrollX;
                    childAt.layout(i14, max2, childAt.getMeasuredWidth() + i14, max2 + childAt.getMeasuredHeight());
                    i8++;
                }
            }
        }
        int i15 = (i5 - i10) - paddingRight;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt2 = getChildAt(i16);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.a && (a2 = a(childAt2)) != null) {
                    float f2 = i15;
                    int i17 = ((int) (a2.e * f2)) + i10;
                    if (layoutParams2.d) {
                        layoutParams2.d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * layoutParams2.c), 1073741824), View.MeasureSpec.makeMeasureSpec((i6 - i9) - i7, 1073741824));
                    }
                    childAt2.layout(i17, i9, childAt2.getMeasuredWidth() + i17, childAt2.getMeasuredHeight() + i9);
                }
            }
        }
        this.r = i9;
        this.s = i6 - i7;
        this.W = i8;
        if (this.T) {
            z2 = false;
            a(this.c, false, 0, false);
        } else {
            z2 = false;
        }
        this.T = z2;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.n = true;
        if (!this.m.isFinished() && this.m.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.m.getCurrX();
            int currY = this.m.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!d(currX)) {
                    this.m.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            w.f(this);
            return;
        }
        a(true);
    }

    private boolean d(int i) {
        if (this.g.size() == 0) {
            if (this.T) {
                return false;
            }
            this.V = false;
            a(0, 0.0f, 0);
            if (this.V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b i2 = i();
        int clientWidth = getClientWidth();
        int i3 = this.p + clientWidth;
        float f2 = clientWidth;
        int i4 = i2.b;
        float f3 = ((i / f2) - i2.e) / (i2.d + (this.p / f2));
        this.V = false;
        a(i4, f3, (int) (i3 * f3));
        if (this.V) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.W
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = r1
        L1d:
            if (r3 >= r6) goto L6d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.a
            if (r10 != 0) goto L2e
            goto L6a
        L2e:
            int r9 = r9.b
            r9 = r9 & 7
            if (r9 == r2) goto L4f
            r10 = 3
            if (r9 == r10) goto L49
            r10 = 5
            if (r9 == r10) goto L3c
            r9 = r4
            goto L5e
        L3c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L5b
        L49:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L5e
        L4f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L5b:
            r11 = r9
            r9 = r4
            r4 = r11
        L5e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L69
            r8.offsetLeftAndRight(r4)
        L69:
            r4 = r9
        L6a:
            int r3 = r3 + 1
            goto L1d
        L6d:
            r12.b(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$f r13 = r12.ae
            if (r13 == 0) goto La1
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7c:
            if (r1 >= r14) goto La1
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r0 = (androidx.viewpager.widget.ViewPager.LayoutParams) r0
            boolean r0 = r0.a
            if (r0 == 0) goto L8d
            goto L9e
        L8d:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$f r3 = r12.ae
            r3.a(r15, r0)
        L9e:
            int r1 = r1 + 1
            goto L7c
        La1:
            r12.V = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.a(int, float, int):void");
    }

    private void b(int i, float f2, int i2) {
        if (this.ab != null) {
            this.ab.a(i, f2, i2);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                e eVar = this.aa.get(i3);
                if (eVar != null) {
                    eVar.a(i, f2, i2);
                }
            }
        }
        if (this.ac != null) {
            this.ac.a(i, f2, i2);
        }
    }

    private void e(int i) {
        if (this.ab != null) {
            this.ab.a(i);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = this.aa.get(i2);
                if (eVar != null) {
                    eVar.a(i);
                }
            }
        }
        if (this.ac != null) {
            this.ac.a(i);
        }
    }

    private void f(int i) {
        if (this.ab != null) {
            this.ab.b(i);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = this.aa.get(i2);
                if (eVar != null) {
                    eVar.b(i);
                }
            }
        }
        if (this.ac != null) {
            this.ac.b(i);
        }
    }

    private void a(boolean z) {
        boolean z2 = this.ak == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.m.isFinished()) {
                this.m.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.m.getCurrX();
                int currY = this.m.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        d(currX);
                    }
                }
            }
        }
        this.z = false;
        boolean z3 = z2;
        for (int i = 0; i < this.g.size(); i++) {
            b bVar = this.g.get(i);
            if (bVar.c) {
                bVar.c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                w.a(this, this.aj);
            } else {
                this.aj.run();
            }
        }
    }

    private boolean a(float f2, float f3) {
        return (f2 < ((float) this.E) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.E)) && f3 < 0.0f);
    }

    private void b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.af : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            h();
            return false;
        }
        if (action != 0) {
            if (this.B) {
                return true;
            }
            if (this.C) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.I = x;
            this.G = x;
            float y = motionEvent.getY();
            this.J = y;
            this.H = y;
            this.K = motionEvent.getPointerId(0);
            this.C = false;
            this.n = true;
            this.m.computeScrollOffset();
            if (this.ak == 2 && Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.P) {
                this.m.abortAnimation();
                this.z = false;
                c();
                this.B = true;
                c(true);
                setScrollState(1);
            } else {
                a(false);
                this.B = false;
            }
        } else if (action == 2) {
            int i = this.K;
            if (i != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i);
                float x2 = motionEvent.getX(findPointerIndex);
                float f2 = x2 - this.G;
                float abs = Math.abs(f2);
                float y2 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y2 - this.J);
                if (f2 != 0.0f && !a(this.G, f2) && a(this, false, (int) f2, (int) x2, (int) y2)) {
                    this.G = x2;
                    this.H = y2;
                    this.C = true;
                    return false;
                }
                if (abs > this.F && abs * 0.5f > abs2) {
                    this.B = true;
                    c(true);
                    setScrollState(1);
                    this.G = f2 > 0.0f ? this.I + this.F : this.I - this.F;
                    this.H = y2;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > this.F) {
                    this.C = true;
                }
                if (this.B && b(x2)) {
                    w.f(this);
                }
            }
        } else if (action == 6) {
            a(motionEvent);
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent);
        return this.B;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Q) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || this.b == null || this.b.a() == 0) {
            return false;
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.m.abortAnimation();
                this.z = false;
                c();
                float x = motionEvent.getX();
                this.I = x;
                this.G = x;
                float y = motionEvent.getY();
                this.J = y;
                this.H = y;
                this.K = motionEvent.getPointerId(0);
                break;
            case 1:
                if (this.B) {
                    VelocityTracker velocityTracker = this.L;
                    velocityTracker.computeCurrentVelocity(1000, this.N);
                    int xVelocity = (int) velocityTracker.getXVelocity(this.K);
                    this.z = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    b i = i();
                    float f2 = clientWidth;
                    a(a(i.b, ((scrollX / f2) - i.e) / (i.d + (this.p / f2)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.K)) - this.I)), true, true, xVelocity);
                    z = h();
                    break;
                }
                break;
            case 2:
                if (!this.B) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.K);
                    if (findPointerIndex == -1) {
                        z = h();
                        break;
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.G);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.H);
                        if (abs > this.F && abs > abs2) {
                            this.B = true;
                            c(true);
                            this.G = x2 - this.I > 0.0f ? this.I + this.F : this.I - this.F;
                            this.H = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.B) {
                    z = false | b(motionEvent.getX(motionEvent.findPointerIndex(this.K)));
                    break;
                }
                break;
            case 3:
                if (this.B) {
                    a(this.c, true, 0, false);
                    z = h();
                    break;
                }
                break;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                this.G = motionEvent.getX(actionIndex);
                this.K = motionEvent.getPointerId(actionIndex);
                break;
            case 6:
                a(motionEvent);
                this.G = motionEvent.getX(motionEvent.findPointerIndex(this.K));
                break;
        }
        if (z) {
            w.f(this);
        }
        return true;
    }

    private boolean h() {
        this.K = -1;
        j();
        this.R.onRelease();
        this.S.onRelease();
        return this.R.isFinished() || this.S.isFinished();
    }

    private void c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean b(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.G - f2;
        this.G = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.t * clientWidth;
        float f5 = this.u * clientWidth;
        boolean z3 = false;
        b bVar = this.g.get(0);
        b bVar2 = this.g.get(this.g.size() - 1);
        if (bVar.b != 0) {
            f4 = bVar.e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (bVar2.b != this.b.a() - 1) {
            f5 = bVar2.e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.R.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.S.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i = (int) scrollX;
        this.G += scrollX - i;
        scrollTo(i, getScrollY());
        d(i);
        return z3;
    }

    private b i() {
        int i;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.p / clientWidth : 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i2 = 0;
        int i3 = -1;
        b bVar = null;
        boolean z = true;
        while (i2 < this.g.size()) {
            b bVar2 = this.g.get(i2);
            if (!z && bVar2.b != (i = i3 + 1)) {
                bVar2 = this.h;
                bVar2.e = f3 + f4 + f2;
                bVar2.b = i;
                bVar2.d = this.b.b(bVar2.b);
                i2--;
            }
            f3 = bVar2.e;
            float f5 = bVar2.d + f3 + f2;
            if (!z && scrollX < f3) {
                return bVar;
            }
            if (scrollX < f5 || i2 == this.g.size() - 1) {
                return bVar2;
            }
            i3 = bVar2.b;
            f4 = bVar2.d;
            i2++;
            z = false;
            bVar = bVar2;
        }
        return bVar;
    }

    private int a(int i, float f2, int i2, int i3) {
        if (Math.abs(i3) <= this.O || Math.abs(i2) <= this.M) {
            i += (int) (f2 + (i >= this.c ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.g.size() > 0) {
            return Math.max(this.g.get(0).b, Math.min(i, this.g.get(this.g.size() - 1).b));
        }
        return i;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && this.b != null && this.b.a() > 1)) {
            if (!this.R.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.t * width);
                this.R.setSize(height, width);
                z = false | this.R.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.S.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.u + 1.0f)) * width2);
                this.S.setSize(height2, width2);
                z |= this.S.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.R.finish();
            this.S.finish();
        }
        if (z) {
            w.f(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.p <= 0 || this.q == null || this.g.size() <= 0 || this.b == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f4 = this.p / width;
        int i = 0;
        b bVar = this.g.get(0);
        float f5 = bVar.e;
        int size = this.g.size();
        int i2 = bVar.b;
        int i3 = this.g.get(size - 1).b;
        while (i2 < i3) {
            while (i2 > bVar.b && i < size) {
                i++;
                bVar = this.g.get(i);
            }
            if (i2 == bVar.b) {
                f2 = (bVar.e + bVar.d) * width;
                f5 = bVar.e + bVar.d + f4;
            } else {
                float b2 = this.b.b(i2);
                f2 = (f5 + b2) * width;
                f5 += b2 + f4;
            }
            if (this.p + f2 > scrollX) {
                f3 = f4;
                this.q.setBounds(Math.round(f2), this.r, Math.round(this.p + f2), this.s);
                this.q.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollX + r2) {
                return;
            }
            i2++;
            f4 = f3;
        }
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.K) {
            int i = actionIndex == 0 ? 1 : 0;
            this.G = motionEvent.getX(i);
            this.K = motionEvent.getPointerId(i);
            if (this.L != null) {
                this.L.clear();
            }
        }
    }

    private void j() {
        this.B = false;
        this.C = false;
        if (this.L != null) {
            this.L.recycle();
            this.L = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.y != z) {
            this.y = z;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.b == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.t)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.u));
    }

    protected boolean a(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && a(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                switch (keyCode) {
                    case 21:
                        if (keyEvent.hasModifiers(2)) {
                            return d();
                        }
                        return c(17);
                    case 22:
                        if (keyEvent.hasModifiers(2)) {
                            return e();
                        }
                        return c(66);
                }
            }
            if (keyEvent.hasNoModifiers()) {
                return c(2);
            }
            if (keyEvent.hasModifiers(1)) {
                return c(1);
            }
        }
        return false;
    }

    public boolean c(int i) {
        boolean requestFocus;
        boolean z;
        View findFocus = findFocus();
        boolean z2 = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    }
                    if (parent == this) {
                        z = true;
                        break;
                    }
                    parent = parent.getParent();
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus != null && findNextFocus != view) {
            if (i == 17) {
                int i2 = a(this.i, findNextFocus).left;
                int i3 = a(this.i, view).left;
                if (view != null && i2 >= i3) {
                    requestFocus = d();
                } else {
                    requestFocus = findNextFocus.requestFocus();
                }
            } else if (i == 66) {
                int i4 = a(this.i, findNextFocus).left;
                int i5 = a(this.i, view).left;
                if (view != null && i4 <= i5) {
                    requestFocus = e();
                } else {
                    requestFocus = findNextFocus.requestFocus();
                }
            }
            z2 = requestFocus;
        } else if (i == 17 || i == 1) {
            z2 = d();
        } else if (i == 66 || i == 2) {
            z2 = e();
        }
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z2;
    }

    private Rect a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    boolean d() {
        if (this.c <= 0) {
            return false;
        }
        a(this.c - 1, true);
        return true;
    }

    boolean e() {
        if (this.b == null || this.c >= this.b.a() - 1) {
            return false;
        }
        a(this.c + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        b a2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.b == this.c) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        b a2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.b == this.c) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        b a2;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
        }
        while (i2 != i4) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.b == this.c && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        b a2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.b == this.c && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* compiled from: source */
    class c extends androidx.core.h.a {
        c() {
        }

        @Override // androidx.core.h.a
        public void d(View view, AccessibilityEvent accessibilityEvent) {
            super.d(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(b());
            if (accessibilityEvent.getEventType() != 4096 || ViewPager.this.b == null) {
                return;
            }
            accessibilityEvent.setItemCount(ViewPager.this.b.a());
            accessibilityEvent.setFromIndex(ViewPager.this.c);
            accessibilityEvent.setToIndex(ViewPager.this.c);
        }

        @Override // androidx.core.h.a
        public void a(View view, androidx.core.h.a.d dVar) {
            super.a(view, dVar);
            dVar.b((CharSequence) ViewPager.class.getName());
            dVar.k(b());
            if (ViewPager.this.canScrollHorizontally(1)) {
                dVar.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                dVar.a(8192);
            }
        }

        @Override // androidx.core.h.a
        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (i == 4096) {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                ViewPager.this.setCurrentItem(ViewPager.this.c + 1);
                return true;
            }
            if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                return false;
            }
            ViewPager.this.setCurrentItem(ViewPager.this.c - 1);
            return true;
        }

        private boolean b() {
            return ViewPager.this.b != null && ViewPager.this.b.a() > 1;
        }
    }

    /* compiled from: source */
    private class g extends DataSetObserver {
        g() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.b();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.b();
        }
    }

    /* compiled from: source */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public boolean a;
        public int b;
        float c;
        boolean d;
        int e;
        int f;

        public LayoutParams() {
            super(-1, -1);
            this.c = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.a);
            this.b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: source */
    static class h implements Comparator<View> {
        h() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            if (layoutParams.a != layoutParams2.a) {
                return layoutParams.a ? 1 : -1;
            }
            return layoutParams.e - layoutParams2.e;
        }
    }
}
