package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.w;
import androidx.customview.a.c;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    int a;
    int b;
    int c;
    boolean d;
    int e;
    c f;
    int g;
    WeakReference<V> h;
    WeakReference<View> i;
    int j;
    boolean k;
    private boolean l;
    private float m;
    private int n;
    private boolean o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private a v;
    private VelocityTracker w;
    private int x;
    private Map<View, Integer> y;
    private final c.a z;

    /* compiled from: source */
    public static abstract class a {
        public abstract void a(View view, float f);

        public abstract void a(View view, int i);
    }

    public BottomSheetBehavior() {
        this.l = true;
        this.e = 4;
        this.z = new c.a() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
            AnonymousClass1() {
            }

            @Override // androidx.customview.a.c.a
            public boolean b(View view, int i) {
                View view2;
                if (BottomSheetBehavior.this.e == 1 || BottomSheetBehavior.this.k) {
                    return false;
                }
                if (BottomSheetBehavior.this.e == 3 && BottomSheetBehavior.this.j == i && (view2 = BottomSheetBehavior.this.i.get()) != null && view2.canScrollVertically(-1)) {
                    return false;
                }
                return BottomSheetBehavior.this.h != null && BottomSheetBehavior.this.h.get() == view;
            }

            @Override // androidx.customview.a.c.a
            public void a(View view, int i, int i2, int i3, int i4) {
                BottomSheetBehavior.this.c(i2);
            }

            @Override // androidx.customview.a.c.a
            public void a(int i) {
                if (i == 1) {
                    BottomSheetBehavior.this.b(1);
                }
            }

            @Override // androidx.customview.a.c.a
            public void a(View view, float f, float f2) {
                int i;
                int i2;
                int i3;
                int i4 = 0;
                int i5 = 4;
                if (f2 < 0.0f) {
                    if (BottomSheetBehavior.this.l) {
                        i3 = BottomSheetBehavior.this.a;
                        i5 = 3;
                    } else {
                        if (view.getTop() > BottomSheetBehavior.this.b) {
                            i2 = BottomSheetBehavior.this.b;
                            i3 = i2;
                            i5 = 6;
                        }
                        i3 = i4;
                        i5 = 3;
                    }
                } else if (BottomSheetBehavior.this.d && BottomSheetBehavior.this.a(view, f2) && (view.getTop() > BottomSheetBehavior.this.c || Math.abs(f) < Math.abs(f2))) {
                    i3 = BottomSheetBehavior.this.g;
                    i5 = 5;
                } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                    int top = view.getTop();
                    if (BottomSheetBehavior.this.l) {
                        if (Math.abs(top - BottomSheetBehavior.this.a) < Math.abs(top - BottomSheetBehavior.this.c)) {
                            i4 = BottomSheetBehavior.this.a;
                            i3 = i4;
                            i5 = 3;
                        } else {
                            i = BottomSheetBehavior.this.c;
                            i3 = i;
                        }
                    } else {
                        if (top < BottomSheetBehavior.this.b) {
                            if (top >= Math.abs(top - BottomSheetBehavior.this.c)) {
                                i2 = BottomSheetBehavior.this.b;
                            }
                            i3 = i4;
                            i5 = 3;
                        } else if (Math.abs(top - BottomSheetBehavior.this.b) < Math.abs(top - BottomSheetBehavior.this.c)) {
                            i2 = BottomSheetBehavior.this.b;
                        } else {
                            i = BottomSheetBehavior.this.c;
                            i3 = i;
                        }
                        i3 = i2;
                        i5 = 6;
                    }
                } else {
                    i3 = BottomSheetBehavior.this.c;
                }
                if (BottomSheetBehavior.this.f.a(view.getLeft(), i3)) {
                    BottomSheetBehavior.this.b(2);
                    w.a(view, new b(view, i5));
                } else {
                    BottomSheetBehavior.this.b(i5);
                }
            }

            @Override // androidx.customview.a.c.a
            public int b(View view, int i, int i2) {
                return androidx.core.b.a.a(i, BottomSheetBehavior.this.e(), BottomSheetBehavior.this.d ? BottomSheetBehavior.this.g : BottomSheetBehavior.this.c);
            }

            @Override // androidx.customview.a.c.a
            public int a(View view, int i, int i2) {
                return view.getLeft();
            }

            @Override // androidx.customview.a.c.a
            public int b(View view) {
                if (BottomSheetBehavior.this.d) {
                    return BottomSheetBehavior.this.g;
                }
                return BottomSheetBehavior.this.c;
            }
        };
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = true;
        this.e = 4;
        this.z = new c.a() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
            AnonymousClass1() {
            }

            @Override // androidx.customview.a.c.a
            public boolean b(View view, int i) {
                View view2;
                if (BottomSheetBehavior.this.e == 1 || BottomSheetBehavior.this.k) {
                    return false;
                }
                if (BottomSheetBehavior.this.e == 3 && BottomSheetBehavior.this.j == i && (view2 = BottomSheetBehavior.this.i.get()) != null && view2.canScrollVertically(-1)) {
                    return false;
                }
                return BottomSheetBehavior.this.h != null && BottomSheetBehavior.this.h.get() == view;
            }

            @Override // androidx.customview.a.c.a
            public void a(View view, int i, int i2, int i3, int i4) {
                BottomSheetBehavior.this.c(i2);
            }

            @Override // androidx.customview.a.c.a
            public void a(int i) {
                if (i == 1) {
                    BottomSheetBehavior.this.b(1);
                }
            }

            @Override // androidx.customview.a.c.a
            public void a(View view, float f, float f2) {
                int i;
                int i2;
                int i3;
                int i4 = 0;
                int i5 = 4;
                if (f2 < 0.0f) {
                    if (BottomSheetBehavior.this.l) {
                        i3 = BottomSheetBehavior.this.a;
                        i5 = 3;
                    } else {
                        if (view.getTop() > BottomSheetBehavior.this.b) {
                            i2 = BottomSheetBehavior.this.b;
                            i3 = i2;
                            i5 = 6;
                        }
                        i3 = i4;
                        i5 = 3;
                    }
                } else if (BottomSheetBehavior.this.d && BottomSheetBehavior.this.a(view, f2) && (view.getTop() > BottomSheetBehavior.this.c || Math.abs(f) < Math.abs(f2))) {
                    i3 = BottomSheetBehavior.this.g;
                    i5 = 5;
                } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                    int top = view.getTop();
                    if (BottomSheetBehavior.this.l) {
                        if (Math.abs(top - BottomSheetBehavior.this.a) < Math.abs(top - BottomSheetBehavior.this.c)) {
                            i4 = BottomSheetBehavior.this.a;
                            i3 = i4;
                            i5 = 3;
                        } else {
                            i = BottomSheetBehavior.this.c;
                            i3 = i;
                        }
                    } else {
                        if (top < BottomSheetBehavior.this.b) {
                            if (top >= Math.abs(top - BottomSheetBehavior.this.c)) {
                                i2 = BottomSheetBehavior.this.b;
                            }
                            i3 = i4;
                            i5 = 3;
                        } else if (Math.abs(top - BottomSheetBehavior.this.b) < Math.abs(top - BottomSheetBehavior.this.c)) {
                            i2 = BottomSheetBehavior.this.b;
                        } else {
                            i = BottomSheetBehavior.this.c;
                            i3 = i;
                        }
                        i3 = i2;
                        i5 = 6;
                    }
                } else {
                    i3 = BottomSheetBehavior.this.c;
                }
                if (BottomSheetBehavior.this.f.a(view.getLeft(), i3)) {
                    BottomSheetBehavior.this.b(2);
                    w.a(view, new b(view, i5));
                } else {
                    BottomSheetBehavior.this.b(i5);
                }
            }

            @Override // androidx.customview.a.c.a
            public int b(View view, int i, int i2) {
                return androidx.core.b.a.a(i, BottomSheetBehavior.this.e(), BottomSheetBehavior.this.d ? BottomSheetBehavior.this.g : BottomSheetBehavior.this.c);
            }

            @Override // androidx.customview.a.c.a
            public int a(View view, int i, int i2) {
                return view.getLeft();
            }

            @Override // androidx.customview.a.c.a
            public int b(View view) {
                if (BottomSheetBehavior.this.d) {
                    return BottomSheetBehavior.this.g;
                }
                return BottomSheetBehavior.this.c;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(a.k.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue != null && peekValue.data == -1) {
            a(peekValue.data);
        } else {
            a(obtainStyledAttributes.getDimensionPixelSize(a.k.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        b(obtainStyledAttributes.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_hideable, false));
        a(obtainStyledAttributes.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        c(obtainStyledAttributes.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.m = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable d(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.d(coordinatorLayout, v), this.e);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.a(coordinatorLayout, (CoordinatorLayout) v, savedState.a());
        if (savedState.a == 1 || savedState.a == 2) {
            this.e = 4;
        } else {
            this.e = savedState.a;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (w.u(coordinatorLayout) && !w.u(v)) {
            v.setFitsSystemWindows(true);
        }
        int top = v.getTop();
        coordinatorLayout.b(v, i);
        this.g = coordinatorLayout.getHeight();
        if (this.o) {
            if (this.p == 0) {
                this.p = coordinatorLayout.getResources().getDimensionPixelSize(a.d.design_bottom_sheet_peek_height_min);
            }
            this.q = Math.max(this.p, this.g - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.q = this.n;
        }
        this.a = Math.max(0, this.g - v.getHeight());
        this.b = this.g / 2;
        b();
        if (this.e == 3) {
            w.f(v, e());
        } else if (this.e == 6) {
            w.f(v, this.b);
        } else if (this.d && this.e == 5) {
            w.f(v, this.g);
        } else if (this.e == 4) {
            w.f(v, this.c);
        } else if (this.e == 1 || this.e == 2) {
            w.f(v, top - v.getTop());
        }
        if (this.f == null) {
            this.f = c.a(coordinatorLayout, this.z);
        }
        this.h = new WeakReference<>(v);
        this.i = new WeakReference<>(a(v));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(androidx.coordinatorlayout.widget.CoordinatorLayout r9, V r10, android.view.MotionEvent r11) {
        /*
            r8 = this;
            boolean r0 = r10.isShown()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto Lb
            r8.s = r2
            return r1
        Lb:
            int r0 = r11.getActionMasked()
            if (r0 != 0) goto L14
            r8.c()
        L14:
            android.view.VelocityTracker r3 = r8.w
            if (r3 != 0) goto L1e
            android.view.VelocityTracker r3 = android.view.VelocityTracker.obtain()
            r8.w = r3
        L1e:
            android.view.VelocityTracker r3 = r8.w
            r3.addMovement(r11)
            r3 = 3
            r4 = -1
            r5 = 0
            if (r0 == r3) goto L6e
            switch(r0) {
                case 0: goto L2c;
                case 1: goto L6e;
                default: goto L2b;
            }
        L2b:
            goto L79
        L2c:
            float r3 = r11.getX()
            int r3 = (int) r3
            float r6 = r11.getY()
            int r6 = (int) r6
            r8.x = r6
            java.lang.ref.WeakReference<android.view.View> r6 = r8.i
            if (r6 == 0) goto L45
            java.lang.ref.WeakReference<android.view.View> r6 = r8.i
            java.lang.Object r6 = r6.get()
            android.view.View r6 = (android.view.View) r6
            goto L46
        L45:
            r6 = r5
        L46:
            if (r6 == 0) goto L5c
            int r7 = r8.x
            boolean r6 = r9.a(r6, r3, r7)
            if (r6 == 0) goto L5c
            int r6 = r11.getActionIndex()
            int r6 = r11.getPointerId(r6)
            r8.j = r6
            r8.k = r2
        L5c:
            int r6 = r8.j
            if (r6 != r4) goto L6a
            int r4 = r8.x
            boolean r10 = r9.a(r10, r3, r4)
            if (r10 != 0) goto L6a
            r10 = r2
            goto L6b
        L6a:
            r10 = r1
        L6b:
            r8.s = r10
            goto L79
        L6e:
            r8.k = r1
            r8.j = r4
            boolean r10 = r8.s
            if (r10 == 0) goto L79
            r8.s = r1
            return r1
        L79:
            boolean r10 = r8.s
            if (r10 != 0) goto L8a
            androidx.customview.a.c r10 = r8.f
            if (r10 == 0) goto L8a
            androidx.customview.a.c r10 = r8.f
            boolean r10 = r10.a(r11)
            if (r10 == 0) goto L8a
            return r2
        L8a:
            java.lang.ref.WeakReference<android.view.View> r10 = r8.i
            if (r10 == 0) goto L97
            java.lang.ref.WeakReference<android.view.View> r10 = r8.i
            java.lang.Object r10 = r10.get()
            r5 = r10
            android.view.View r5 = (android.view.View) r5
        L97:
            r10 = 2
            if (r0 != r10) goto Ld0
            if (r5 == 0) goto Ld0
            boolean r10 = r8.s
            if (r10 != 0) goto Ld0
            int r10 = r8.e
            if (r10 == r2) goto Ld0
            float r10 = r11.getX()
            int r10 = (int) r10
            float r0 = r11.getY()
            int r0 = (int) r0
            boolean r9 = r9.a(r5, r10, r0)
            if (r9 != 0) goto Ld0
            androidx.customview.a.c r9 = r8.f
            if (r9 == 0) goto Ld0
            int r9 = r8.x
            float r9 = (float) r9
            float r10 = r11.getY()
            float r9 = r9 - r10
            float r9 = java.lang.Math.abs(r9)
            androidx.customview.a.c r10 = r8.f
            int r10 = r10.e()
            float r10 = (float) r10
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto Ld0
            r1 = r2
        Ld0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.a(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.e == 1 && actionMasked == 0) {
            return true;
        }
        if (this.f != null) {
            this.f.b(motionEvent);
        }
        if (actionMasked == 0) {
            c();
        }
        if (this.w == null) {
            this.w = VelocityTracker.obtain();
        }
        this.w.addMovement(motionEvent);
        if (actionMasked == 2 && !this.s && Math.abs(this.x - motionEvent.getY()) > this.f.e()) {
            this.f.a(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.s;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.t = 0;
        this.u = false;
        return (i & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 != 1 && view == this.i.get()) {
            int top = v.getTop();
            int i4 = top - i2;
            if (i2 > 0) {
                if (i4 < e()) {
                    iArr[1] = top - e();
                    w.f(v, -iArr[1]);
                    b(3);
                } else {
                    iArr[1] = i2;
                    w.f(v, -i2);
                    b(1);
                }
            } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                if (i4 <= this.c || this.d) {
                    iArr[1] = i2;
                    w.f(v, -i2);
                    b(1);
                } else {
                    iArr[1] = top - this.c;
                    w.f(v, -iArr[1]);
                    b(4);
                }
            }
            c(v.getTop());
            this.t = i2;
            this.u = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        int i2;
        int i3 = 3;
        if (v.getTop() == e()) {
            b(3);
            return;
        }
        if (view == this.i.get() && this.u) {
            if (this.t > 0) {
                i2 = e();
            } else if (this.d && a(v, d())) {
                i2 = this.g;
                i3 = 5;
            } else {
                if (this.t == 0) {
                    int top = v.getTop();
                    if (this.l) {
                        if (Math.abs(top - this.a) < Math.abs(top - this.c)) {
                            i2 = this.a;
                        } else {
                            i2 = this.c;
                        }
                    } else {
                        if (top < this.b) {
                            if (top < Math.abs(top - this.c)) {
                                i2 = 0;
                            } else {
                                i2 = this.b;
                            }
                        } else if (Math.abs(top - this.b) < Math.abs(top - this.c)) {
                            i2 = this.b;
                        } else {
                            i2 = this.c;
                        }
                        i3 = 6;
                    }
                } else {
                    i2 = this.c;
                }
                i3 = 4;
            }
            if (this.f.a((View) v, v.getLeft(), i2)) {
                b(2);
                w.a(v, new b(v, i3));
            } else {
                b(i3);
            }
            this.u = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.i.get() && (this.e != 3 || super.a(coordinatorLayout, (CoordinatorLayout) v, view, f, f2));
    }

    public void a(boolean z) {
        if (this.l == z) {
            return;
        }
        this.l = z;
        if (this.h != null) {
            b();
        }
        b((this.l && this.e == 6) ? 3 : this.e);
    }

    public final void a(int i) {
        V v;
        boolean z = true;
        if (i == -1) {
            if (!this.o) {
                this.o = true;
            }
            z = false;
        } else {
            if (this.o || this.n != i) {
                this.o = false;
                this.n = Math.max(0, i);
                this.c = this.g - i;
            }
            z = false;
        }
        if (!z || this.e != 4 || this.h == null || (v = this.h.get()) == null) {
            return;
        }
        v.requestLayout();
    }

    public void b(boolean z) {
        this.d = z;
    }

    public void c(boolean z) {
        this.r = z;
    }

    void b(int i) {
        if (this.e == i) {
            return;
        }
        this.e = i;
        if (i == 6 || i == 3) {
            d(true);
        } else if (i == 5 || i == 4) {
            d(false);
        }
        V v = this.h.get();
        if (v == null || this.v == null) {
            return;
        }
        this.v.a((View) v, i);
    }

    private void b() {
        if (this.l) {
            this.c = Math.max(this.g - this.q, this.a);
        } else {
            this.c = this.g - this.q;
        }
    }

    private void c() {
        this.j = -1;
        if (this.w != null) {
            this.w.recycle();
            this.w = null;
        }
    }

    boolean a(View view, float f) {
        if (this.r) {
            return true;
        }
        return view.getTop() >= this.c && Math.abs((((float) view.getTop()) + (f * 0.1f)) - ((float) this.c)) / ((float) this.n) > 0.5f;
    }

    View a(View view) {
        if (w.A(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View a2 = a(viewGroup.getChildAt(i));
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    private float d() {
        if (this.w == null) {
            return 0.0f;
        }
        this.w.computeCurrentVelocity(1000, this.m);
        return this.w.getYVelocity(this.j);
    }

    public int e() {
        if (this.l) {
            return this.a;
        }
        return 0;
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$1 */
    class AnonymousClass1 extends c.a {
        AnonymousClass1() {
        }

        @Override // androidx.customview.a.c.a
        public boolean b(View view, int i) {
            View view2;
            if (BottomSheetBehavior.this.e == 1 || BottomSheetBehavior.this.k) {
                return false;
            }
            if (BottomSheetBehavior.this.e == 3 && BottomSheetBehavior.this.j == i && (view2 = BottomSheetBehavior.this.i.get()) != null && view2.canScrollVertically(-1)) {
                return false;
            }
            return BottomSheetBehavior.this.h != null && BottomSheetBehavior.this.h.get() == view;
        }

        @Override // androidx.customview.a.c.a
        public void a(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.c(i2);
        }

        @Override // androidx.customview.a.c.a
        public void a(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.b(1);
            }
        }

        @Override // androidx.customview.a.c.a
        public void a(View view, float f, float f2) {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int i5 = 4;
            if (f2 < 0.0f) {
                if (BottomSheetBehavior.this.l) {
                    i3 = BottomSheetBehavior.this.a;
                    i5 = 3;
                } else {
                    if (view.getTop() > BottomSheetBehavior.this.b) {
                        i2 = BottomSheetBehavior.this.b;
                        i3 = i2;
                        i5 = 6;
                    }
                    i3 = i4;
                    i5 = 3;
                }
            } else if (BottomSheetBehavior.this.d && BottomSheetBehavior.this.a(view, f2) && (view.getTop() > BottomSheetBehavior.this.c || Math.abs(f) < Math.abs(f2))) {
                i3 = BottomSheetBehavior.this.g;
                i5 = 5;
            } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                int top = view.getTop();
                if (BottomSheetBehavior.this.l) {
                    if (Math.abs(top - BottomSheetBehavior.this.a) < Math.abs(top - BottomSheetBehavior.this.c)) {
                        i4 = BottomSheetBehavior.this.a;
                        i3 = i4;
                        i5 = 3;
                    } else {
                        i = BottomSheetBehavior.this.c;
                        i3 = i;
                    }
                } else {
                    if (top < BottomSheetBehavior.this.b) {
                        if (top >= Math.abs(top - BottomSheetBehavior.this.c)) {
                            i2 = BottomSheetBehavior.this.b;
                        }
                        i3 = i4;
                        i5 = 3;
                    } else if (Math.abs(top - BottomSheetBehavior.this.b) < Math.abs(top - BottomSheetBehavior.this.c)) {
                        i2 = BottomSheetBehavior.this.b;
                    } else {
                        i = BottomSheetBehavior.this.c;
                        i3 = i;
                    }
                    i3 = i2;
                    i5 = 6;
                }
            } else {
                i3 = BottomSheetBehavior.this.c;
            }
            if (BottomSheetBehavior.this.f.a(view.getLeft(), i3)) {
                BottomSheetBehavior.this.b(2);
                w.a(view, new b(view, i5));
            } else {
                BottomSheetBehavior.this.b(i5);
            }
        }

        @Override // androidx.customview.a.c.a
        public int b(View view, int i, int i2) {
            return androidx.core.b.a.a(i, BottomSheetBehavior.this.e(), BottomSheetBehavior.this.d ? BottomSheetBehavior.this.g : BottomSheetBehavior.this.c);
        }

        @Override // androidx.customview.a.c.a
        public int a(View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // androidx.customview.a.c.a
        public int b(View view) {
            if (BottomSheetBehavior.this.d) {
                return BottomSheetBehavior.this.g;
            }
            return BottomSheetBehavior.this.c;
        }
    }

    void c(int i) {
        V v = this.h.get();
        if (v == null || this.v == null) {
            return;
        }
        if (i > this.c) {
            this.v.a(v, (this.c - i) / (this.g - this.c));
        } else {
            this.v.a(v, (this.c - i) / (this.c - e()));
        }
    }

    /* compiled from: source */
    private class b implements Runnable {
        private final View b;
        private final int c;

        b(View view, int i) {
            this.b = view;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BottomSheetBehavior.this.f != null && BottomSheetBehavior.this.f.a(true)) {
                w.a(this.b, this);
            } else {
                BottomSheetBehavior.this.b(this.c);
            }
        }
    }

    /* compiled from: source */
    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState.1
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
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final int a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.a = i;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }

        /* compiled from: source */
        /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$SavedState$1 */
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
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }
    }

    private void d(boolean z) {
        if (this.h == null) {
            return;
        }
        ViewParent parent = this.h.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.y != null) {
                    return;
                } else {
                    this.y = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.h.get()) {
                    if (!z) {
                        if (this.y != null && this.y.containsKey(childAt)) {
                            w.b(childAt, this.y.get(childAt).intValue());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.y.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        w.b(childAt, 4);
                    }
                }
            }
            if (z) {
                return;
            }
            this.y = null;
        }
    }
}
