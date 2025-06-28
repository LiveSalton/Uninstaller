package com.jumobile.manager.systemapp.ui.widget.slidingmenu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.h.i;
import androidx.core.h.v;
import androidx.core.h.x;
import com.jumobile.manager.systemapp.ui.widget.slidingmenu.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class CustomViewAbove extends ViewGroup {
    private static final Interpolator e = new Interpolator() { // from class: com.jumobile.manager.systemapp.ui.widget.slidingmenu.CustomViewAbove.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }

        AnonymousClass1() {
        }
    };
    private float A;
    protected int a;
    protected VelocityTracker b;
    protected int c;
    protected int d;
    private View f;
    private int g;
    private Scroller h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private float n;
    private float o;
    private float p;
    private int q;
    private int r;
    private CustomViewBehind s;
    private boolean t;
    private a u;
    private a v;
    private SlidingMenu.c w;
    private SlidingMenu.e x;
    private List<View> y;
    private boolean z;

    /* compiled from: source */
    public interface a {
        void a(int i);

        void a(int i, float f, int i2);
    }

    /* compiled from: source */
    public static class b implements a {
        @Override // com.jumobile.manager.systemapp.ui.widget.slidingmenu.CustomViewAbove.a
        public void a(int i) {
        }

        @Override // com.jumobile.manager.systemapp.ui.widget.slidingmenu.CustomViewAbove.a
        public void a(int i, float f, int i2) {
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.widget.slidingmenu.CustomViewAbove$1 */
    static class AnonymousClass1 implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }

        AnonymousClass1() {
        }
    }

    public CustomViewAbove(Context context) {
        this(context, null);
    }

    public CustomViewAbove(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.t = true;
        this.y = new ArrayList();
        this.d = 0;
        this.z = false;
        this.A = 0.0f;
        a();
    }

    void a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.h = new Scroller(context, e);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.m = x.a(viewConfiguration);
        this.q = viewConfiguration.getScaledMinimumFlingVelocity();
        this.c = viewConfiguration.getScaledMaximumFlingVelocity();
        a(new b() { // from class: com.jumobile.manager.systemapp.ui.widget.slidingmenu.CustomViewAbove.2
            AnonymousClass2() {
            }

            @Override // com.jumobile.manager.systemapp.ui.widget.slidingmenu.CustomViewAbove.b, com.jumobile.manager.systemapp.ui.widget.slidingmenu.CustomViewAbove.a
            public void a(int i) {
                if (CustomViewAbove.this.s != null) {
                    switch (i) {
                        case 0:
                        case 2:
                            CustomViewAbove.this.s.setChildrenEnabled(true);
                            break;
                        case 1:
                            CustomViewAbove.this.s.setChildrenEnabled(false);
                            break;
                    }
                }
            }
        });
        this.r = (int) (25.0f * context.getResources().getDisplayMetrics().density);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.widget.slidingmenu.CustomViewAbove$2 */
    class AnonymousClass2 extends b {
        AnonymousClass2() {
        }

        @Override // com.jumobile.manager.systemapp.ui.widget.slidingmenu.CustomViewAbove.b, com.jumobile.manager.systemapp.ui.widget.slidingmenu.CustomViewAbove.a
        public void a(int i) {
            if (CustomViewAbove.this.s != null) {
                switch (i) {
                    case 0:
                    case 2:
                        CustomViewAbove.this.s.setChildrenEnabled(true);
                        break;
                    case 1:
                        CustomViewAbove.this.s.setChildrenEnabled(false);
                        break;
                }
            }
        }
    }

    public void setCurrentItem(int i) {
        a(i, true, false);
    }

    public void a(int i, boolean z) {
        a(i, z, false);
    }

    public int getCurrentItem() {
        return this.g;
    }

    void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    void a(int i, boolean z, boolean z2, int i2) {
        if (!z2 && this.g == i) {
            setScrollingCacheEnabled(false);
            return;
        }
        int a2 = this.s.a(i);
        boolean z3 = this.g != a2;
        this.g = a2;
        int a3 = a(this.g);
        if (z3 && this.u != null) {
            this.u.a(a2);
        }
        if (z3 && this.v != null) {
            this.v.a(a2);
        }
        if (z) {
            a(a3, 0, i2);
        } else {
            e();
            scrollTo(a3, 0);
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.u = aVar;
    }

    public void setOnOpenedListener(SlidingMenu.e eVar) {
        this.x = eVar;
    }

    public void setOnClosedListener(SlidingMenu.c cVar) {
        this.w = cVar;
    }

    a a(a aVar) {
        a aVar2 = this.v;
        this.v = aVar;
        return aVar2;
    }

    float a(float f) {
        return (float) Math.sin((float) ((f - 0.5f) * 0.4712389167638204d));
    }

    public int a(int i) {
        switch (i) {
            case 0:
            case 2:
                return this.s.a(this.f, i);
            case 1:
                return this.f.getLeft();
            default:
                return 0;
        }
    }

    private int getLeftBound() {
        return this.s.a(this.f);
    }

    private int getRightBound() {
        return this.s.b(this.f);
    }

    public int getContentLeft() {
        return this.f.getLeft() + this.f.getPaddingLeft();
    }

    public boolean b() {
        return this.g == 0 || this.g == 2;
    }

    private boolean a(MotionEvent motionEvent) {
        Rect rect = new Rect();
        Iterator<View> it = this.y.iterator();
        while (it.hasNext()) {
            it.next().getHitRect(rect);
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return true;
            }
        }
        return false;
    }

    public int getBehindWidth() {
        if (this.s == null) {
            return 0;
        }
        return this.s.getBehindWidth();
    }

    public void setSlidingEnabled(boolean z) {
        this.t = z;
    }

    void a(int i, int i2, int i3) {
        int i4;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i5 = i - scrollX;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            e();
            if (b()) {
                if (this.x != null) {
                    this.x.a();
                    return;
                }
                return;
            } else {
                if (this.w != null) {
                    this.w.a();
                    return;
                }
                return;
            }
        }
        setScrollingCacheEnabled(true);
        this.j = true;
        int behindWidth = getBehindWidth();
        float f = behindWidth / 2;
        float a2 = f + (a(Math.min(1.0f, (Math.abs(i5) * 1.0f) / behindWidth)) * f);
        int abs = Math.abs(i3);
        if (abs > 0) {
            i4 = Math.round(1000.0f * Math.abs(a2 / abs)) * 4;
        } else {
            Math.abs(i5);
            i4 = 600;
        }
        this.h.startScroll(scrollX, scrollY, i5, i6, Math.min(i4, 600));
        invalidate();
    }

    public void setContent(View view) {
        if (this.f != null) {
            removeView(this.f);
        }
        this.f = view;
        addView(this.f);
    }

    public View getContent() {
        return this.f;
    }

    public void setCustomViewBehind(CustomViewBehind customViewBehind) {
        this.s = customViewBehind;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(0, i);
        int defaultSize2 = getDefaultSize(0, i2);
        setMeasuredDimension(defaultSize, defaultSize2);
        this.f.measure(getChildMeasureSpec(i, 0, defaultSize), getChildMeasureSpec(i2, 0, defaultSize2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            e();
            scrollTo(a(this.g), getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f.layout(0, 0, i3 - i, i4 - i2);
    }

    public void setAboveOffset(int i) {
        this.f.setPadding(i, this.f.getPaddingTop(), this.f.getPaddingRight(), this.f.getPaddingBottom());
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.h.isFinished() && this.h.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.h.getCurrX();
            int currY = this.h.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                c(currX);
            }
            invalidate();
            return;
        }
        e();
    }

    private void c(int i) {
        int width = getWidth();
        int i2 = i / width;
        int i3 = i % width;
        a(i2, i3 / width, i3);
    }

    protected void a(int i, float f, int i2) {
        if (this.u != null) {
            this.u.a(i, f, i2);
        }
        if (this.v != null) {
            this.v.a(i, f, i2);
        }
    }

    private void e() {
        if (this.j) {
            setScrollingCacheEnabled(false);
            this.h.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.h.getCurrX();
            int currY = this.h.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
            if (b()) {
                if (this.x != null) {
                    this.x.a();
                }
            } else if (this.w != null) {
                this.w.a();
            }
        }
        this.j = false;
    }

    public void setTouchMode(int i) {
        this.d = i;
    }

    public int getTouchMode() {
        return this.d;
    }

    private boolean b(MotionEvent motionEvent) {
        int x = (int) (motionEvent.getX() + this.A);
        if (b()) {
            return this.s.a(this.f, this.g, x);
        }
        switch (this.d) {
            case 0:
                return this.s.b(this.f, x);
            case 1:
                return !a(motionEvent);
            case 2:
                return false;
            default:
                return false;
        }
    }

    private boolean b(float f) {
        if (b()) {
            return this.s.b(f);
        }
        return this.s.a(f);
    }

    private int a(MotionEvent motionEvent, int i) {
        int a2 = i.a(motionEvent, i);
        if (a2 == -1) {
            this.a = -1;
        }
        return a2;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.t) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1 || (action != 0 && this.l)) {
            g();
            return false;
        }
        if (action == 0) {
            int a2 = i.a(motionEvent);
            this.a = i.b(motionEvent, a2);
            if (this.a != -1) {
                float c = i.c(motionEvent, a2);
                this.n = c;
                this.o = c;
                this.p = i.d(motionEvent, a2);
                if (b(motionEvent)) {
                    this.k = false;
                    this.l = false;
                    if (b() && this.s.b(this.f, this.g, motionEvent.getX() + this.A)) {
                        this.z = true;
                    }
                } else {
                    this.l = true;
                }
            }
        } else if (action == 2) {
            c(motionEvent);
        } else if (action == 6) {
            d(motionEvent);
        }
        if (!this.k) {
            if (this.b == null) {
                this.b = VelocityTracker.obtain();
            }
            this.b.addMovement(motionEvent);
        }
        return this.k || this.z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.t) {
            return false;
        }
        if (!this.k && !b(motionEvent)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (this.b == null) {
            this.b = VelocityTracker.obtain();
        }
        this.b.addMovement(motionEvent);
        switch (action & 255) {
            case 0:
                e();
                this.a = i.b(motionEvent, i.a(motionEvent));
                float x = motionEvent.getX();
                this.n = x;
                this.o = x;
                return true;
            case 1:
                if (this.k) {
                    VelocityTracker velocityTracker = this.b;
                    velocityTracker.computeCurrentVelocity(1000, this.c);
                    int a2 = (int) v.a(velocityTracker, this.a);
                    float scrollX = (getScrollX() - a(this.g)) / getBehindWidth();
                    int a3 = a(motionEvent, this.a);
                    if (this.a != -1) {
                        a(a(scrollX, a2, (int) (i.c(motionEvent, a3) - this.n)), true, true, a2);
                    } else {
                        a(this.g, true, true, a2);
                    }
                    this.a = -1;
                    g();
                } else if (this.z && this.s.b(this.f, this.g, motionEvent.getX() + this.A)) {
                    setCurrentItem(1);
                    g();
                }
                return true;
            case 2:
                if (!this.k) {
                    c(motionEvent);
                    if (this.l) {
                        return false;
                    }
                }
                if (this.k) {
                    int a4 = a(motionEvent, this.a);
                    if (this.a != -1) {
                        float c = i.c(motionEvent, a4);
                        float f = this.o - c;
                        this.o = c;
                        float scrollX2 = getScrollX() + f;
                        float leftBound = getLeftBound();
                        float rightBound = getRightBound();
                        if (scrollX2 < leftBound) {
                            scrollX2 = leftBound;
                        } else if (scrollX2 > rightBound) {
                            scrollX2 = rightBound;
                        }
                        int i = (int) scrollX2;
                        this.o += scrollX2 - i;
                        scrollTo(i, getScrollY());
                        c(i);
                    }
                }
                return true;
            case 3:
                if (this.k) {
                    a(this.g, true, true);
                    this.a = -1;
                    g();
                }
                return true;
            case 4:
            default:
                return true;
            case 5:
                int a5 = i.a(motionEvent);
                this.o = i.c(motionEvent, a5);
                this.a = i.b(motionEvent, a5);
                return true;
            case 6:
                d(motionEvent);
                int a6 = a(motionEvent, this.a);
                if (this.a != -1) {
                    this.o = i.c(motionEvent, a6);
                }
                return true;
        }
    }

    private void c(MotionEvent motionEvent) {
        int i = this.a;
        int a2 = a(motionEvent, i);
        if (i == -1) {
            return;
        }
        float c = i.c(motionEvent, a2);
        float f = c - this.o;
        float abs = Math.abs(f);
        float d = i.d(motionEvent, a2);
        float abs2 = Math.abs(d - this.p);
        if (abs <= (b() ? this.m / 2 : this.m) || abs <= abs2 || !b(f)) {
            if (abs > this.m) {
                this.l = true;
            }
        } else {
            f();
            this.o = c;
            this.p = d;
            setScrollingCacheEnabled(true);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
        this.A = i;
        this.s.a(this.f, i, i2);
        ((SlidingMenu) getParent()).a(getPercentOpen());
    }

    private int a(float f, int i, int i2) {
        int i3 = this.g;
        if (Math.abs(i2) <= this.r || Math.abs(i) <= this.q) {
            return Math.round(this.g + f);
        }
        return (i <= 0 || i2 <= 0) ? (i >= 0 || i2 >= 0) ? i3 : i3 + 1 : i3 - 1;
    }

    protected float getPercentOpen() {
        return Math.abs(this.A - this.f.getLeft()) / getBehindWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.s.a(this.f, canvas);
        this.s.a(this.f, canvas, getPercentOpen());
        this.s.b(this.f, canvas, getPercentOpen());
    }

    private void d(MotionEvent motionEvent) {
        int a2 = i.a(motionEvent);
        if (i.b(motionEvent, a2) == this.a) {
            int i = a2 == 0 ? 1 : 0;
            this.o = i.c(motionEvent, i);
            this.a = i.b(motionEvent, i);
            if (this.b != null) {
                this.b.clear();
            }
        }
    }

    private void f() {
        this.k = true;
        this.z = false;
    }

    private void g() {
        this.z = false;
        this.k = false;
        this.l = false;
        this.a = -1;
        if (this.b != null) {
            this.b.recycle();
            this.b = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.i != z) {
            this.i = z;
        }
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
                        return b(17);
                    case 22:
                        return b(66);
                }
            }
            int i = Build.VERSION.SDK_INT;
        }
        return false;
    }

    public boolean b(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        boolean z = false;
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        if (findNextFocus == null || findNextFocus == findFocus) {
            if (i == 17 || i == 1) {
                z = c();
            } else if (i == 66 || i == 2) {
                z = d();
            }
        } else if (i == 17) {
            z = findNextFocus.requestFocus();
        } else if (i == 66) {
            if (findFocus != null && findNextFocus.getLeft() <= findFocus.getLeft()) {
                z = d();
            } else {
                z = findNextFocus.requestFocus();
            }
        }
        if (z) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z;
    }

    boolean c() {
        if (this.g <= 0) {
            return false;
        }
        a(this.g - 1, true);
        return true;
    }

    boolean d() {
        if (this.g >= 1) {
            return false;
        }
        a(this.g + 1, true);
        return true;
    }
}
