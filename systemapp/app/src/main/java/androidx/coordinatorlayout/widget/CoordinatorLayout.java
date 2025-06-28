package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.a;
import androidx.core.g.d;
import androidx.core.h.ae;
import androidx.core.h.o;
import androidx.core.h.q;
import androidx.core.h.r;
import androidx.core.h.w;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements o {
    static final String a;
    static final Class<?>[] b;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> c;
    static final Comparator<View> d;
    private static final d.a<Rect> f;
    ViewGroup.OnHierarchyChangeListener e;
    private final List<View> g;
    private final androidx.coordinatorlayout.widget.a<View> h;
    private final List<View> i;
    private final List<View> j;
    private final int[] k;
    private Paint l;
    private boolean m;
    private boolean n;
    private int[] o;
    private View p;
    private View q;
    private e r;
    private boolean s;
    private ae t;
    private boolean u;
    private Drawable v;
    private r w;
    private final q x;

    /* compiled from: source */
    public interface a {
        Behavior getBehavior();
    }

    /* compiled from: source */
    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface b {
        Class<? extends Behavior> a();
    }

    private static int a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private static int c(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    private static int d(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    private static int e(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        a = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            d = new f();
        } else {
            d = null;
        }
        b = new Class[]{Context.class, AttributeSet.class};
        c = new ThreadLocal<>();
        f = new d.c(12);
    }

    private static Rect e() {
        Rect a2 = f.a();
        return a2 == null ? new Rect() : a2;
    }

    private static void a(Rect rect) {
        rect.setEmpty();
        f.a(rect);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0015a.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.g = new ArrayList();
        this.h = new androidx.coordinatorlayout.widget.a<>();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new int[2];
        this.x = new q(this);
        if (i == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.CoordinatorLayout, 0, a.b.Widget_Support_CoordinatorLayout);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.CoordinatorLayout, i, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(a.c.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.o = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.o.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.o[i2] = (int) (this.o[i2] * f2);
            }
        }
        this.v = obtainStyledAttributes.getDrawable(a.c.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        g();
        super.setOnHierarchyChangeListener(new c());
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.e = onHierarchyChangeListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(false);
        if (this.s) {
            if (this.r == null) {
                this.r = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.r);
        }
        if (this.t == null && w.u(this)) {
            w.t(this);
        }
        this.n = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
        if (this.s && this.r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.r);
        }
        if (this.q != null) {
            onStopNestedScroll(this.q);
        }
        this.n = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        if (this.v != drawable) {
            if (this.v != null) {
                this.v.setCallback(null);
            }
            this.v = drawable != null ? drawable.mutate() : null;
            if (this.v != null) {
                if (this.v.isStateful()) {
                    this.v.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.b(this.v, w.h(this));
                this.v.setVisible(getVisibility() == 0, false);
                this.v.setCallback(this);
            }
            w.f(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.v;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.v;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.v;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.v == null || this.v.isVisible() == z) {
            return;
        }
        this.v.setVisible(z, false);
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? androidx.core.content.a.a(getContext(), i) : null);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    final ae a(ae aeVar) {
        if (androidx.core.g.c.a(this.t, aeVar)) {
            return aeVar;
        }
        this.t = aeVar;
        boolean z = false;
        this.u = aeVar != null && aeVar.b() > 0;
        if (!this.u && getBackground() == null) {
            z = true;
        }
        setWillNotDraw(z);
        ae b2 = b(aeVar);
        requestLayout();
        return b2;
    }

    public final ae getLastWindowInsets() {
        return this.t;
    }

    private void a(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Behavior b2 = ((d) childAt.getLayoutParams()).b();
            if (b2 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    b2.a(this, (CoordinatorLayout) childAt, obtain);
                } else {
                    b2.b(this, (CoordinatorLayout) childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((d) getChildAt(i2).getLayoutParams()).f();
        }
        this.p = null;
        this.m = false;
    }

    private void a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        if (d != null) {
            Collections.sort(list, d);
        }
    }

    private boolean a(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.i;
        a(list);
        int size = list.size();
        boolean z = false;
        boolean z2 = false;
        MotionEvent motionEvent2 = null;
        for (int i2 = 0; i2 < size; i2++) {
            View view = list.get(i2);
            d dVar = (d) view.getLayoutParams();
            Behavior b2 = dVar.b();
            if (!(z || z2) || actionMasked == 0) {
                if (!z && b2 != null) {
                    switch (i) {
                        case 0:
                            z = b2.a(this, (CoordinatorLayout) view, motionEvent);
                            break;
                        case 1:
                            z = b2.b(this, (CoordinatorLayout) view, motionEvent);
                            break;
                    }
                    if (z) {
                        this.p = view;
                    }
                }
                boolean e2 = dVar.e();
                boolean a2 = dVar.a(this, view);
                z2 = a2 && !e2;
                if (a2 && !z2) {
                    list.clear();
                    return z;
                }
            } else if (b2 != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                switch (i) {
                    case 0:
                        b2.a(this, (CoordinatorLayout) view, motionEvent2);
                        break;
                    case 1:
                        b2.b(this, (CoordinatorLayout) view, motionEvent2);
                        break;
                }
            }
        }
        list.clear();
        return z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            a(true);
        }
        boolean a2 = a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            a(true);
        }
        return a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r3 != false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.p
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.a(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2c
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.p
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$d r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.d) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.b()
            if (r6 == 0) goto L15
            android.view.View r7 = r0.p
            boolean r6 = r6.b(r0, r7, r1)
        L2c:
            android.view.View r7 = r0.p
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.a(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.m) {
            return;
        }
        a(false);
        this.m = true;
    }

    private int b(int i) {
        if (this.o == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        }
        if (i < 0 || i >= this.o.length) {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
        return this.o[i];
    }

    /* JADX WARN: Multi-variable type inference failed */
    static Behavior a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(a)) {
            str = a + '.' + str;
        }
        try {
            Map map = c.get();
            if (map == null) {
                map = new HashMap();
                c.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    d a(View view) {
        d dVar = (d) view.getLayoutParams();
        if (!dVar.b) {
            if (view instanceof a) {
                Behavior behavior = ((a) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                dVar.a(behavior);
                dVar.b = true;
            } else {
                b bVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    bVar = (b) cls.getAnnotation(b.class);
                    if (bVar != null) {
                        break;
                    }
                }
                if (bVar != null) {
                    try {
                        dVar.a(bVar.a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + bVar.a().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
                dVar.b = true;
            }
        }
        return dVar;
    }

    private void f() {
        this.g.clear();
        this.h.a();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            d a2 = a(childAt);
            a2.b(this, childAt);
            this.h.a((androidx.coordinatorlayout.widget.a<View>) childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (a2.a(this, childAt, childAt2)) {
                        if (!this.h.b(childAt2)) {
                            this.h.a((androidx.coordinatorlayout.widget.a<View>) childAt2);
                        }
                        this.h.a(childAt2, childAt);
                    }
                }
            }
        }
        this.g.addAll(this.h.b());
        Collections.reverse(this.g);
    }

    void a(View view, Rect rect) {
        androidx.coordinatorlayout.widget.b.b(this, view, rect);
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0120, code lost:
    
        if (r0.a(r31, (androidx.coordinatorlayout.widget.CoordinatorLayout) r1, r23, r20, r25, 0) == false) goto L102;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0126  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r32, int r33) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    private ae b(ae aeVar) {
        Behavior b2;
        if (aeVar.f()) {
            return aeVar;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (w.u(childAt) && (b2 = ((d) childAt.getLayoutParams()).b()) != null) {
                aeVar = b2.a(this, (CoordinatorLayout) childAt, aeVar);
                if (aeVar.f()) {
                    break;
                }
            }
        }
        return aeVar;
    }

    public void b(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        if (dVar.k != null) {
            a(view, dVar.k, i);
        } else if (dVar.e >= 0) {
            b(view, dVar.e, i);
        } else {
            d(view, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Behavior b2;
        int h = w.h(this);
        int size = this.g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.g.get(i5);
            if (view.getVisibility() != 8 && ((b2 = ((d) view.getLayoutParams()).b()) == null || !b2.a(this, (CoordinatorLayout) view, h))) {
                b(view, h);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.u || this.v == null) {
            return;
        }
        int b2 = this.t != null ? this.t.b() : 0;
        if (b2 > 0) {
            this.v.setBounds(0, 0, getWidth(), b2);
            this.v.draw(canvas);
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        g();
    }

    void b(View view, Rect rect) {
        ((d) view.getLayoutParams()).a(rect);
    }

    void c(View view, Rect rect) {
        rect.set(((d) view.getLayoutParams()).c());
    }

    void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private void a(View view, int i, Rect rect, Rect rect2, d dVar, int i2, int i3) {
        int width;
        int height;
        int a2 = androidx.core.h.d.a(e(dVar.c), i);
        int a3 = androidx.core.h.d.a(c(dVar.d), i);
        int i4 = a2 & 7;
        int i5 = a2 & 112;
        int i6 = a3 & 7;
        int i7 = a3 & 112;
        if (i6 == 1) {
            width = rect.left + (rect.width() / 2);
        } else if (i6 != 5) {
            width = rect.left;
        } else {
            width = rect.right;
        }
        if (i7 == 16) {
            height = rect.top + (rect.height() / 2);
        } else if (i7 != 80) {
            height = rect.top;
        } else {
            height = rect.bottom;
        }
        if (i4 == 1) {
            width -= i2 / 2;
        } else if (i4 != 5) {
            width -= i2;
        }
        if (i5 == 16) {
            height -= i3 / 2;
        } else if (i5 != 80) {
            height -= i3;
        }
        rect2.set(width, height, i2 + width, i3 + height);
    }

    private void a(d dVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - dVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + dVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - dVar.bottomMargin));
        rect.set(max, max2, i + max, i2 + max2);
    }

    void a(View view, int i, Rect rect, Rect rect2) {
        d dVar = (d) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        a(view, i, rect, rect2, dVar, measuredWidth, measuredHeight);
        a(dVar, rect2, measuredWidth, measuredHeight);
    }

    private void a(View view, View view2, int i) {
        Rect e2 = e();
        Rect e3 = e();
        try {
            a(view2, e2);
            a(view, i, e2, e3);
            view.layout(e3.left, e3.top, e3.right, e3.bottom);
        } finally {
            a(e2);
            a(e3);
        }
    }

    private void b(View view, int i, int i2) {
        d dVar = (d) view.getLayoutParams();
        int a2 = androidx.core.h.d.a(d(dVar.c), i2);
        int i3 = a2 & 7;
        int i4 = a2 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int b2 = b(i) - measuredWidth;
        int i5 = 0;
        if (i3 == 1) {
            b2 += measuredWidth / 2;
        } else if (i3 == 5) {
            b2 += measuredWidth;
        }
        if (i4 == 16) {
            i5 = 0 + (measuredHeight / 2);
        } else if (i4 == 80) {
            i5 = 0 + measuredHeight;
        }
        int max = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(b2, ((width - getPaddingRight()) - measuredWidth) - dVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + dVar.topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - dVar.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void d(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        Rect e2 = e();
        e2.set(getPaddingLeft() + dVar.leftMargin, getPaddingTop() + dVar.topMargin, (getWidth() - getPaddingRight()) - dVar.rightMargin, (getHeight() - getPaddingBottom()) - dVar.bottomMargin);
        if (this.t != null && w.u(this) && !w.u(view)) {
            e2.left += this.t.a();
            e2.top += this.t.b();
            e2.right -= this.t.c();
            e2.bottom -= this.t.d();
        }
        Rect e3 = e();
        androidx.core.h.d.a(c(dVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), e2, e3, i);
        view.layout(e3.left, e3.top, e3.right, e3.bottom);
        a(e2);
        a(e3);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.a != null) {
            float b2 = dVar.a.b(this, view);
            if (b2 > 0.0f) {
                if (this.l == null) {
                    this.l = new Paint();
                }
                this.l.setColor(dVar.a.a(this, view));
                this.l.setAlpha(a(Math.round(255.0f * b2), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.l);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    final void a(int i) {
        boolean z;
        int h = w.h(this);
        int size = this.g.size();
        Rect e2 = e();
        Rect e3 = e();
        Rect e4 = e();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.g.get(i2);
            d dVar = (d) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (dVar.l == this.g.get(i3)) {
                        c(view, h);
                    }
                }
                a(view, true, e3);
                if (dVar.g != 0 && !e3.isEmpty()) {
                    int a2 = androidx.core.h.d.a(dVar.g, h);
                    int i4 = a2 & 112;
                    if (i4 == 48) {
                        e2.top = Math.max(e2.top, e3.bottom);
                    } else if (i4 == 80) {
                        e2.bottom = Math.max(e2.bottom, getHeight() - e3.top);
                    }
                    int i5 = a2 & 7;
                    if (i5 == 3) {
                        e2.left = Math.max(e2.left, e3.right);
                    } else if (i5 == 5) {
                        e2.right = Math.max(e2.right, getWidth() - e3.left);
                    }
                }
                if (dVar.h != 0 && view.getVisibility() == 0) {
                    a(view, e2, h);
                }
                if (i != 2) {
                    c(view, e4);
                    if (!e4.equals(e3)) {
                        b(view, e3);
                    }
                }
                for (int i6 = i2 + 1; i6 < size; i6++) {
                    View view2 = this.g.get(i6);
                    d dVar2 = (d) view2.getLayoutParams();
                    Behavior b2 = dVar2.b();
                    if (b2 != null && b2.a(this, (CoordinatorLayout) view2, view)) {
                        if (i == 0 && dVar2.g()) {
                            dVar2.h();
                        } else {
                            if (i == 2) {
                                b2.c(this, view2, view);
                                z = true;
                            } else {
                                z = b2.b(this, (CoordinatorLayout) view2, view);
                            }
                            if (i == 1) {
                                dVar2.a(z);
                            }
                        }
                    }
                }
            }
        }
        a(e2);
        a(e3);
        a(e4);
    }

    private void a(View view, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int height;
        int i3;
        if (w.C(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            d dVar = (d) view.getLayoutParams();
            Behavior b2 = dVar.b();
            Rect e2 = e();
            Rect e3 = e();
            e3.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (b2 != null && b2.a(this, (CoordinatorLayout) view, e2)) {
                if (!e3.contains(e2)) {
                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + e2.toShortString() + " | Bounds:" + e3.toShortString());
                }
            } else {
                e2.set(e3);
            }
            a(e3);
            if (e2.isEmpty()) {
                a(e2);
                return;
            }
            int a2 = androidx.core.h.d.a(dVar.h, i);
            if ((a2 & 48) != 48 || (i3 = (e2.top - dVar.topMargin) - dVar.j) >= rect.top) {
                z = false;
            } else {
                f(view, rect.top - i3);
                z = true;
            }
            if ((a2 & 80) == 80 && (height = ((getHeight() - e2.bottom) - dVar.bottomMargin) + dVar.j) < rect.bottom) {
                f(view, height - rect.bottom);
                z = true;
            }
            if (!z) {
                f(view, 0);
            }
            if ((a2 & 3) != 3 || (i2 = (e2.left - dVar.leftMargin) - dVar.i) >= rect.left) {
                z2 = false;
            } else {
                e(view, rect.left - i2);
                z2 = true;
            }
            if ((a2 & 5) == 5 && (width = ((getWidth() - e2.right) - dVar.rightMargin) + dVar.i) < rect.right) {
                e(view, width - rect.right);
                z2 = true;
            }
            if (!z2) {
                e(view, 0);
            }
            a(e2);
        }
    }

    private void e(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.i != i) {
            w.g(view, i - dVar.i);
            dVar.i = i;
        }
    }

    private void f(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.j != i) {
            w.f(view, i - dVar.j);
            dVar.j = i;
        }
    }

    public void b(View view) {
        List c2 = this.h.c(view);
        if (c2 == null || c2.isEmpty()) {
            return;
        }
        for (int i = 0; i < c2.size(); i++) {
            View view2 = (View) c2.get(i);
            Behavior b2 = ((d) view2.getLayoutParams()).b();
            if (b2 != null) {
                b2.b(this, (CoordinatorLayout) view2, view);
            }
        }
    }

    public List<View> c(View view) {
        List<View> d2 = this.h.d(view);
        this.j.clear();
        if (d2 != null) {
            this.j.addAll(d2);
        }
        return this.j;
    }

    public List<View> d(View view) {
        List c2 = this.h.c(view);
        this.j.clear();
        if (c2 != null) {
            this.j.addAll(c2);
        }
        return this.j;
    }

    final List<View> getDependencySortedChildren() {
        f();
        return Collections.unmodifiableList(this.g);
    }

    void t_() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (e(getChildAt(i))) {
                z = true;
                break;
            }
            i++;
        }
        if (z != this.s) {
            if (z) {
                b();
            } else {
                u_();
            }
        }
    }

    private boolean e(View view) {
        return this.h.e(view);
    }

    void b() {
        if (this.n) {
            if (this.r == null) {
                this.r = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.r);
        }
        this.s = true;
    }

    void u_() {
        if (this.n && this.r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.r);
        }
        this.s = false;
    }

    void c(View view, int i) {
        Behavior b2;
        d dVar = (d) view.getLayoutParams();
        if (dVar.k != null) {
            Rect e2 = e();
            Rect e3 = e();
            Rect e4 = e();
            a(dVar.k, e2);
            a(view, false, e3);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            a(view, i, e2, e4, dVar, measuredWidth, measuredHeight);
            boolean z = (e4.left == e3.left && e4.top == e3.top) ? false : true;
            a(dVar, e4, measuredWidth, measuredHeight);
            int i2 = e4.left - e3.left;
            int i3 = e4.top - e3.top;
            if (i2 != 0) {
                w.g(view, i2);
            }
            if (i3 != 0) {
                w.f(view, i3);
            }
            if (z && (b2 = dVar.b()) != null) {
                b2.b(this, (CoordinatorLayout) view, dVar.k);
            }
            a(e2);
            a(e3);
            a(e4);
        }
    }

    public boolean a(View view, int i, int i2) {
        Rect e2 = e();
        a(view, e2);
        try {
            return e2.contains(i, i2);
        } finally {
            a(e2);
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: a */
    public d generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: a */
    public d generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof d) {
            return new d((d) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new d((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new d(layoutParams);
    }

    @Override // android.view.ViewGroup
    /* renamed from: d */
    public d generateDefaultLayoutParams() {
        return new d(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return a(view, view2, i, 0);
    }

    @Override // androidx.core.h.o
    public boolean a(View view, View view2, int i, int i2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                Behavior b2 = dVar.b();
                if (b2 != null) {
                    boolean a2 = b2.a(this, (CoordinatorLayout) childAt, view, view2, i, i2);
                    dVar.a(i2, a2);
                    z |= a2;
                } else {
                    dVar.a(i2, false);
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public void onNestedScrollAccepted(View view, View view2, int i) {
        b(view, view2, i, 0);
    }

    @Override // androidx.core.h.o
    public void b(View view, View view2, int i, int i2) {
        Behavior b2;
        this.x.a(view, view2, i, i2);
        this.q = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.b(i2) && (b2 = dVar.b()) != null) {
                b2.b(this, childAt, view, view2, i, i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public void onStopNestedScroll(View view) {
        a(view, 0);
    }

    @Override // androidx.core.h.o
    public void a(View view, int i) {
        this.x.a(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.b(i)) {
                Behavior b2 = dVar.b();
                if (b2 != null) {
                    b2.a(this, (CoordinatorLayout) childAt, view, i);
                }
                dVar.a(i);
                dVar.h();
            }
        }
        this.q = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        a(view, i, i2, i3, i4, 0);
    }

    @Override // androidx.core.h.o
    public void a(View view, int i, int i2, int i3, int i4, int i5) {
        Behavior b2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.b(i5) && (b2 = dVar.b()) != null) {
                    b2.a(this, childAt, view, i, i2, i3, i4, i5);
                    z = true;
                }
            }
        }
        if (z) {
            a(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        a(view, i, i2, iArr, 0);
    }

    @Override // androidx.core.h.o
    public void a(View view, int i, int i2, int[] iArr, int i3) {
        Behavior b2;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.b(i3) && (b2 = dVar.b()) != null) {
                    int[] iArr2 = this.k;
                    this.k[1] = 0;
                    iArr2[0] = 0;
                    b2.a(this, (CoordinatorLayout) childAt, view, i, i2, this.k, i3);
                    if (i > 0) {
                        min = Math.max(i4, this.k[0]);
                    } else {
                        min = Math.min(i4, this.k[0]);
                    }
                    if (i2 > 0) {
                        min2 = Math.max(i5, this.k[1]);
                    } else {
                        min2 = Math.min(i5, this.k[1]);
                    }
                    i4 = min;
                    i5 = min2;
                    z = true;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (z) {
            a(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        Behavior b2;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.b(0) && (b2 = dVar.b()) != null) {
                    z2 |= b2.a(this, (CoordinatorLayout) childAt, view, f2, f3, z);
                }
            }
        }
        if (z2) {
            a(1);
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.n
    public boolean onNestedPreFling(View view, float f2, float f3) {
        Behavior b2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.b(0) && (b2 = dVar.b()) != null) {
                    z |= b2.a(this, (CoordinatorLayout) childAt, view, f2, f3);
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.x.a();
    }

    /* compiled from: source */
    class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.a(0);
            return true;
        }
    }

    /* compiled from: source */
    static class f implements Comparator<View> {
        f() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            float D = w.D(view);
            float D2 = w.D(view2);
            if (D > D2) {
                return -1;
            }
            return D < D2 ? 1 : 0;
        }
    }

    /* compiled from: source */
    public static abstract class Behavior<V extends View> {
        public int a(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public ae a(CoordinatorLayout coordinatorLayout, V v, ae aeVar) {
            return aeVar;
        }

        public void a() {
        }

        public void a(d dVar) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        @Deprecated
        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public float b(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        @Deprecated
        public void b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void c(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        @Deprecated
        public void d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public boolean c(CoordinatorLayout coordinatorLayout, V v) {
            return b(coordinatorLayout, v) > 0.0f;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return a(coordinatorLayout, (CoordinatorLayout) v, view, view2, i);
            }
            return false;
        }

        public void b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                b(coordinatorLayout, v, view, view2, i);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                d(coordinatorLayout, v, view);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                a(coordinatorLayout, (CoordinatorLayout) v, view, i, i2, i3, i4);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                a(coordinatorLayout, (CoordinatorLayout) v, view, i, i2, iArr);
            }
        }

        public Parcelable d(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }
    }

    /* compiled from: source */
    public static class d extends ViewGroup.MarginLayoutParams {
        Behavior a;
        boolean b;
        public int c;
        public int d;
        public int e;
        int f;
        public int g;
        public int h;
        int i;
        int j;
        View k;
        View l;
        final Rect m;
        Object n;
        private boolean o;
        private boolean p;
        private boolean q;
        private boolean r;

        public d(int i, int i2) {
            super(i, i2);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
        }

        d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.CoordinatorLayout_Layout);
            this.c = obtainStyledAttributes.getInteger(a.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f = obtainStyledAttributes.getResourceId(a.c.CoordinatorLayout_Layout_layout_anchor, -1);
            this.d = obtainStyledAttributes.getInteger(a.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.e = obtainStyledAttributes.getInteger(a.c.CoordinatorLayout_Layout_layout_keyline, -1);
            this.g = obtainStyledAttributes.getInt(a.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.h = obtainStyledAttributes.getInt(a.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.b = obtainStyledAttributes.hasValue(a.c.CoordinatorLayout_Layout_layout_behavior);
            if (this.b) {
                this.a = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(a.c.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            if (this.a != null) {
                this.a.a(this);
            }
        }

        public d(d dVar) {
            super((ViewGroup.MarginLayoutParams) dVar);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
        }

        public int a() {
            return this.f;
        }

        public Behavior b() {
            return this.a;
        }

        public void a(Behavior behavior) {
            if (this.a != behavior) {
                if (this.a != null) {
                    this.a.a();
                }
                this.a = behavior;
                this.n = null;
                this.b = true;
                if (behavior != null) {
                    behavior.a(this);
                }
            }
        }

        void a(Rect rect) {
            this.m.set(rect);
        }

        Rect c() {
            return this.m;
        }

        boolean d() {
            return this.k == null && this.f != -1;
        }

        boolean e() {
            if (this.a == null) {
                this.o = false;
            }
            return this.o;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.o) {
                return true;
            }
            boolean c = (this.a != null ? this.a.c(coordinatorLayout, view) : false) | this.o;
            this.o = c;
            return c;
        }

        void f() {
            this.o = false;
        }

        void a(int i) {
            a(i, false);
        }

        void a(int i, boolean z) {
            switch (i) {
                case 0:
                    this.p = z;
                    break;
                case 1:
                    this.q = z;
                    break;
            }
        }

        boolean b(int i) {
            switch (i) {
                case 0:
                    return this.p;
                case 1:
                    return this.q;
                default:
                    return false;
            }
        }

        boolean g() {
            return this.r;
        }

        void a(boolean z) {
            this.r = z;
        }

        void h() {
            this.r = false;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.l || a(view2, w.h(coordinatorLayout)) || (this.a != null && this.a.a(coordinatorLayout, (CoordinatorLayout) view, view2));
        }

        View b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f == -1) {
                this.l = null;
                this.k = null;
                return null;
            }
            if (this.k == null || !b(view, coordinatorLayout)) {
                a(view, coordinatorLayout);
            }
            return this.k;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3, types: [android.view.ViewParent] */
        private void a(View view, CoordinatorLayout coordinatorLayout) {
            this.k = coordinatorLayout.findViewById(this.f);
            if (this.k != null) {
                if (this.k == coordinatorLayout) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.l = null;
                        this.k = null;
                        return;
                    }
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                CoordinatorLayout coordinatorLayout2 = this.k;
                for (CoordinatorLayout coordinatorLayout3 = this.k.getParent(); coordinatorLayout3 != coordinatorLayout && coordinatorLayout3 != null; coordinatorLayout3 = coordinatorLayout3.getParent()) {
                    if (coordinatorLayout3 == view) {
                        if (coordinatorLayout.isInEditMode()) {
                            this.l = null;
                            this.k = null;
                            return;
                        }
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    if (coordinatorLayout3 instanceof View) {
                        coordinatorLayout2 = coordinatorLayout3;
                    }
                }
                this.l = coordinatorLayout2;
                return;
            }
            if (coordinatorLayout.isInEditMode()) {
                this.l = null;
                this.k = null;
                return;
            }
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f) + " to anchor view " + view);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [android.view.ViewParent] */
        private boolean b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f) {
                return false;
            }
            CoordinatorLayout coordinatorLayout2 = this.k;
            for (CoordinatorLayout coordinatorLayout3 = this.k.getParent(); coordinatorLayout3 != coordinatorLayout; coordinatorLayout3 = coordinatorLayout3.getParent()) {
                if (coordinatorLayout3 == null || coordinatorLayout3 == view) {
                    this.l = null;
                    this.k = null;
                    return false;
                }
                if (coordinatorLayout3 instanceof View) {
                    coordinatorLayout2 = coordinatorLayout3;
                }
            }
            this.l = coordinatorLayout2;
            return true;
        }

        private boolean a(View view, int i) {
            int a = androidx.core.h.d.a(((d) view.getLayoutParams()).g, i);
            return a != 0 && (androidx.core.h.d.a(this.h, i) & a) == a;
        }
    }

    /* compiled from: source */
    private class c implements ViewGroup.OnHierarchyChangeListener {
        c() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.e != null) {
                CoordinatorLayout.this.e.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.a(2);
            if (CoordinatorLayout.this.e != null) {
                CoordinatorLayout.this.e.onChildViewRemoved(view, view2);
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        SparseArray<Parcelable> sparseArray = savedState.a;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior b2 = a(childAt).b();
            if (id != -1 && b2 != null && (parcelable2 = sparseArray.get(id)) != null) {
                b2.a(this, (CoordinatorLayout) childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable d2;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior b2 = ((d) childAt.getLayoutParams()).b();
            if (id != -1 && b2 != null && (d2 = b2.d(this, childAt)) != null) {
                sparseArray.append(id, d2);
            }
        }
        savedState.a = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior b2 = ((d) view.getLayoutParams()).b();
        if (b2 == null || !b2.a(this, (CoordinatorLayout) view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    private void g() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (w.u(this)) {
            if (this.w == null) {
                this.w = new r() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.1
                    AnonymousClass1() {
                    }

                    @Override // androidx.core.h.r
                    public ae a(View view, ae aeVar) {
                        return CoordinatorLayout.this.a(aeVar);
                    }
                };
            }
            w.a(this, this.w);
            setSystemUiVisibility(1280);
            return;
        }
        w.a(this, (r) null);
    }

    /* compiled from: source */
    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$1 */
    class AnonymousClass1 implements r {
        AnonymousClass1() {
        }

        @Override // androidx.core.h.r
        public ae a(View view, ae aeVar) {
            return CoordinatorLayout.this.a(aeVar);
        }
    }

    /* compiled from: source */
    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.SavedState.1
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
        SparseArray<Parcelable> a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.a = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int size = this.a != null ? this.a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.a.keyAt(i2);
                parcelableArr[i2] = this.a.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }

        /* compiled from: source */
        /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$SavedState$1 */
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
}
