package androidx.customview.a;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.b.h;
import androidx.core.h.a.d;
import androidx.core.h.a.e;
import androidx.core.h.a.f;
import androidx.core.h.w;
import androidx.customview.a.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class a extends androidx.core.h.a {
    private static final Rect c = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final b.a<d> l = new b.a<d>() { // from class: androidx.customview.a.a.1
        AnonymousClass1() {
        }

        @Override // androidx.customview.a.b.a
        public void a(d dVar, Rect rect) {
            dVar.a(rect);
        }
    };
    private static final b.InterfaceC0030b<h<d>, d> m = new b.InterfaceC0030b<h<d>, d>() { // from class: androidx.customview.a.a.2
        AnonymousClass2() {
        }

        @Override // androidx.customview.a.b.InterfaceC0030b
        public d a(h<d> hVar, int i) {
            return hVar.e(i);
        }

        @Override // androidx.customview.a.b.InterfaceC0030b
        public int a(h<d> hVar) {
            return hVar.b();
        }
    };
    private final AccessibilityManager h;
    private final View i;
    private C0029a j;
    private final Rect d = new Rect();
    private final Rect e = new Rect();
    private final Rect f = new Rect();
    private final int[] g = new int[2];
    int a = Integer.MIN_VALUE;
    int b = Integer.MIN_VALUE;
    private int k = Integer.MIN_VALUE;

    private static int d(int i) {
        switch (i) {
            case 19:
                return 33;
            case 20:
            default:
                return 130;
            case 21:
                return 17;
            case 22:
                return 66;
        }
    }

    protected abstract int a(float f, float f2);

    protected void a(int i, AccessibilityEvent accessibilityEvent) {
    }

    protected abstract void a(int i, d dVar);

    protected void a(int i, boolean z) {
    }

    protected void a(AccessibilityEvent accessibilityEvent) {
    }

    protected void a(d dVar) {
    }

    protected abstract void a(List<Integer> list);

    protected abstract boolean b(int i, int i2, Bundle bundle);

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.i = view;
        this.h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (w.g(view) == 0) {
            w.b(view, 1);
        }
    }

    @Override // androidx.core.h.a
    public e a(View view) {
        if (this.j == null) {
            this.j = new C0029a();
        }
        return this.j;
    }

    public final boolean a(MotionEvent motionEvent) {
        if (!this.h.isEnabled() || !this.h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            switch (action) {
                case 9:
                    break;
                case 10:
                    if (this.k == Integer.MIN_VALUE) {
                        return false;
                    }
                    e(Integer.MIN_VALUE);
                    return true;
                default:
                    return false;
            }
        }
        int a = a(motionEvent.getX(), motionEvent.getY());
        e(a);
        return a != Integer.MIN_VALUE;
    }

    public final boolean a(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int d = d(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z = false;
                        while (i < repeatCount && b(d, (Rect) null)) {
                            i++;
                            z = true;
                        }
                        return z;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            c();
            return true;
        }
        if (keyEvent.hasNoModifiers()) {
            return b(2, (Rect) null);
        }
        if (keyEvent.hasModifiers(1)) {
            return b(1, (Rect) null);
        }
        return false;
    }

    public final void a(boolean z, int i, Rect rect) {
        if (this.b != Integer.MIN_VALUE) {
            c(this.b);
        }
        if (z) {
            b(i, rect);
        }
    }

    private void a(int i, Rect rect) {
        a(i).a(rect);
    }

    /* compiled from: source */
    /* renamed from: androidx.customview.a.a$1 */
    class AnonymousClass1 implements b.a<d> {
        AnonymousClass1() {
        }

        @Override // androidx.customview.a.b.a
        public void a(d dVar, Rect rect) {
            dVar.a(rect);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.customview.a.a$2 */
    class AnonymousClass2 implements b.InterfaceC0030b<h<d>, d> {
        AnonymousClass2() {
        }

        @Override // androidx.customview.a.b.InterfaceC0030b
        public d a(h<d> hVar, int i) {
            return hVar.e(i);
        }

        @Override // androidx.customview.a.b.InterfaceC0030b
        public int a(h<d> hVar) {
            return hVar.b();
        }
    }

    private boolean b(int i, Rect rect) {
        d dVar;
        h<d> b = b();
        int i2 = this.b;
        d a = i2 == Integer.MIN_VALUE ? null : b.a(i2);
        if (i != 17 && i != 33 && i != 66 && i != 130) {
            switch (i) {
                case 1:
                case 2:
                    dVar = (d) b.a(b, m, l, a, i, w.h(this.i) == 1, false);
                    break;
                default:
                    throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
        } else {
            Rect rect2 = new Rect();
            if (this.b != Integer.MIN_VALUE) {
                a(this.b, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                a(this.i, i, rect2);
            }
            dVar = (d) b.a(b, m, l, a, rect2, i);
        }
        return b(dVar != null ? b.d(b.a((h<d>) dVar)) : Integer.MIN_VALUE);
    }

    private h<d> b() {
        ArrayList arrayList = new ArrayList();
        a(arrayList);
        h<d> hVar = new h<>();
        for (int i = 0; i < arrayList.size(); i++) {
            hVar.b(arrayList.get(i).intValue(), g(arrayList.get(i).intValue()));
        }
        return hVar;
    }

    private static Rect a(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean c() {
        return this.b != Integer.MIN_VALUE && b(this.b, 16, null);
    }

    public final boolean a(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = this.i.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.i, b(i, i2));
    }

    private void e(int i) {
        if (this.k == i) {
            return;
        }
        int i2 = this.k;
        this.k = i;
        a(i, 128);
        a(i2, 256);
    }

    private AccessibilityEvent b(int i, int i2) {
        if (i == -1) {
            return f(i2);
        }
        return c(i, i2);
    }

    private AccessibilityEvent f(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.i.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    @Override // androidx.core.h.a
    public void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        a(accessibilityEvent);
    }

    private AccessibilityEvent c(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        d a = a(i);
        obtain.getText().add(a.t());
        obtain.setContentDescription(a.u());
        obtain.setScrollable(a.q());
        obtain.setPassword(a.p());
        obtain.setEnabled(a.o());
        obtain.setChecked(a.g());
        a(i, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(a.s());
        f.a(obtain, this.i, i);
        obtain.setPackageName(this.i.getContext().getPackageName());
        return obtain;
    }

    d a(int i) {
        if (i == -1) {
            return d();
        }
        return g(i);
    }

    private d d() {
        d a = d.a(this.i);
        w.a(this.i, a);
        ArrayList arrayList = new ArrayList();
        a(arrayList);
        if (a.c() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a.b(this.i, ((Integer) arrayList.get(i)).intValue());
        }
        return a;
    }

    @Override // androidx.core.h.a
    public void a(View view, d dVar) {
        super.a(view, dVar);
        a(dVar);
    }

    private d g(int i) {
        d b = d.b();
        b.j(true);
        b.c(true);
        b.b("android.view.View");
        b.b(c);
        b.d(c);
        b.d(this.i);
        a(i, b);
        if (b.t() == null && b.u() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        b.a(this.e);
        if (this.e.equals(c)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int d = b.d();
        if ((d & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((d & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        b.a((CharSequence) this.i.getContext().getPackageName());
        b.a(this.i, i);
        if (this.a == i) {
            b.f(true);
            b.a(128);
        } else {
            b.f(false);
            b.a(64);
        }
        boolean z = this.b == i;
        if (z) {
            b.a(2);
        } else if (b.h()) {
            b.a(1);
        }
        b.d(z);
        this.i.getLocationOnScreen(this.g);
        b.c(this.d);
        if (this.d.equals(c)) {
            b.a(this.d);
            if (b.a != -1) {
                d b2 = d.b();
                for (int i2 = b.a; i2 != -1; i2 = b2.a) {
                    b2.c(this.i, -1);
                    b2.b(c);
                    a(i2, b2);
                    b2.a(this.e);
                    this.d.offset(this.e.left, this.e.top);
                }
                b2.v();
            }
            this.d.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
        }
        if (this.i.getLocalVisibleRect(this.f)) {
            this.f.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
            if (this.d.intersect(this.f)) {
                b.d(this.d);
                if (a(this.d)) {
                    b.e(true);
                }
            }
        }
        return b;
    }

    boolean a(int i, int i2, Bundle bundle) {
        if (i == -1) {
            return a(i2, bundle);
        }
        return c(i, i2, bundle);
    }

    private boolean a(int i, Bundle bundle) {
        return w.a(this.i, i, bundle);
    }

    private boolean c(int i, int i2, Bundle bundle) {
        if (i2 == 64) {
            return h(i);
        }
        if (i2 == 128) {
            return i(i);
        }
        switch (i2) {
            case 1:
                return b(i);
            case 2:
                return c(i);
            default:
                return b(i, i2, bundle);
        }
    }

    private boolean a(Rect rect) {
        if (rect == null || rect.isEmpty() || this.i.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.i.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private boolean h(int i) {
        if (!this.h.isEnabled() || !this.h.isTouchExplorationEnabled() || this.a == i) {
            return false;
        }
        if (this.a != Integer.MIN_VALUE) {
            i(this.a);
        }
        this.a = i;
        this.i.invalidate();
        a(i, 32768);
        return true;
    }

    private boolean i(int i) {
        if (this.a != i) {
            return false;
        }
        this.a = Integer.MIN_VALUE;
        this.i.invalidate();
        a(i, 65536);
        return true;
    }

    public final boolean b(int i) {
        if ((!this.i.isFocused() && !this.i.requestFocus()) || this.b == i) {
            return false;
        }
        if (this.b != Integer.MIN_VALUE) {
            c(this.b);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.b = i;
        a(i, true);
        a(i, 8);
        return true;
    }

    public final boolean c(int i) {
        if (this.b != i) {
            return false;
        }
        this.b = Integer.MIN_VALUE;
        a(i, false);
        a(i, 8);
        return true;
    }

    /* compiled from: source */
    /* renamed from: androidx.customview.a.a$a */
    private class C0029a extends e {
        C0029a() {
        }

        @Override // androidx.core.h.a.e
        public d a(int i) {
            return d.a(a.this.a(i));
        }

        @Override // androidx.core.h.a.e
        public boolean a(int i, int i2, Bundle bundle) {
            return a.this.a(i, i2, bundle);
        }

        @Override // androidx.core.h.a.e
        public d b(int i) {
            int i2 = i == 2 ? a.this.a : a.this.b;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i2);
        }
    }
}
