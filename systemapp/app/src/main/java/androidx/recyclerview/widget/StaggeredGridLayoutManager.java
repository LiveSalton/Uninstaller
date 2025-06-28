package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.a.d;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.i implements RecyclerView.r.b {
    private SavedState A;
    private int B;
    private int[] G;
    b[] a;
    h b;
    h c;
    private int j;
    private int k;
    private final f l;
    private BitSet m;
    private boolean o;
    private boolean z;
    private int i = -1;
    boolean d = false;
    boolean e = false;
    int f = -1;
    int g = Integer.MIN_VALUE;
    LazySpanLookup h = new LazySpanLookup();
    private int n = 2;
    private final Rect C = new Rect();
    private final a D = new a();
    private boolean E = false;
    private boolean F = true;
    private final Runnable H = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.g();
        }
    };

    /* compiled from: source */
    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.g();
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.i.b a2 = a(context, attributeSet, i, i2);
        b(a2.a);
        a(a2.b);
        a(a2.c);
        this.l = new f();
        M();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean c() {
        return this.n != 0;
    }

    private void M() {
        this.b = h.a(this, this.j);
        this.c = h.a(this, 1 - this.j);
    }

    boolean g() {
        int L;
        int K;
        if (v() == 0 || this.n == 0 || !q()) {
            return false;
        }
        if (this.e) {
            L = K();
            K = L();
        } else {
            L = L();
            K = K();
        }
        if (L == 0 && h() != null) {
            this.h.a();
            I();
            o();
            return true;
        }
        if (!this.E) {
            return false;
        }
        int i = this.e ? -1 : 1;
        int i2 = K + 1;
        LazySpanLookup.FullSpanItem a2 = this.h.a(L, i2, i, true);
        if (a2 == null) {
            this.E = false;
            this.h.a(i2);
            return false;
        }
        LazySpanLookup.FullSpanItem a3 = this.h.a(L, a2.a, i * (-1), true);
        if (a3 == null) {
            this.h.a(a2.a);
        } else {
            this.h.a(a3.a + 1);
        }
        I();
        o();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void l(int i) {
        if (i == 0) {
            g();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, RecyclerView.o oVar) {
        super.a(recyclerView, oVar);
        a(this.H);
        for (int i = 0; i < this.i; i++) {
            this.a[i].e();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        if (r10 == r11) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0088, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0086, code lost:
    
        if (r10 == r11) goto L99;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.view.View h() {
        /*
            r12 = this;
            int r0 = r12.v()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.i
            r2.<init>(r3)
            int r3 = r12.i
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.j
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.j()
            if (r3 == 0) goto L20
            r3 = r1
            goto L21
        L20:
            r3 = r5
        L21:
            boolean r6 = r12.e
            if (r6 == 0) goto L27
            r6 = r5
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = r4
        L2b:
            if (r0 >= r6) goto L2e
            r5 = r1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.i(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r8.a
            int r9 = r9.e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r8.a
            boolean r9 = r12.a(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r8.a
            int r9 = r9.e
            r2.clear(r9)
        L54:
            boolean r9 = r8.b
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.i(r9)
            boolean r10 = r12.e
            if (r10 == 0) goto L77
            androidx.recyclerview.widget.h r10 = r12.b
            int r10 = r10.b(r7)
            androidx.recyclerview.widget.h r11 = r12.b
            int r11 = r11.b(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            androidx.recyclerview.widget.h r10 = r12.b
            int r10 = r10.a(r7)
            androidx.recyclerview.widget.h r11 = r12.b
            int r11 = r11.a(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = r1
            goto L8b
        L8a:
            r10 = r4
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r8 = r8.a
            int r8 = r8.e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r9.a
            int r9 = r9.e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = r1
            goto La1
        La0:
            r8 = r4
        La1:
            if (r3 >= 0) goto La5
            r9 = r1
            goto La6
        La5:
            r9 = r4
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.h():android.view.View");
    }

    private boolean a(b bVar) {
        if (this.e) {
            if (bVar.d() < this.b.d()) {
                return !bVar.c(bVar.a.get(bVar.a.size() - 1)).b;
            }
        } else if (bVar.b() > this.b.c()) {
            return !bVar.c(bVar.a.get(0)).b;
        }
        return false;
    }

    public void a(int i) {
        a((String) null);
        if (i != this.i) {
            i();
            this.i = i;
            this.m = new BitSet(this.i);
            this.a = new b[this.i];
            for (int i2 = 0; i2 < this.i; i2++) {
                this.a[i2] = new b(i2);
            }
            o();
        }
    }

    public void b(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        a((String) null);
        if (i == this.j) {
            return;
        }
        this.j = i;
        h hVar = this.b;
        this.b = this.c;
        this.c = hVar;
        o();
    }

    public void a(boolean z) {
        a((String) null);
        if (this.A != null && this.A.h != z) {
            this.A.h = z;
        }
        this.d = z;
        o();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(String str) {
        if (this.A == null) {
            super.a(str);
        }
    }

    public void i() {
        this.h.a();
        o();
    }

    private void N() {
        if (this.j == 1 || !j()) {
            this.e = this.d;
        } else {
            this.e = !this.d;
        }
    }

    boolean j() {
        return t() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Rect rect, int i, int i2) {
        int a2;
        int a3;
        int A = A() + C();
        int B = B() + D();
        if (this.j == 1) {
            a3 = a(i2, rect.height() + B, G());
            a2 = a(i, (this.k * this.i) + A, F());
        } else {
            a2 = a(i, rect.width() + A, F());
            a3 = a(i2, (this.k * this.i) + B, G());
        }
        f(a2, a3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void c(RecyclerView.o oVar, RecyclerView.s sVar) {
        a(oVar, sVar, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0163, code lost:
    
        if (g() != false) goto L193;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(androidx.recyclerview.widget.RecyclerView.o r9, androidx.recyclerview.widget.RecyclerView.s r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(androidx.recyclerview.widget.RecyclerView$o, androidx.recyclerview.widget.RecyclerView$s, boolean):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.s sVar) {
        super.a(sVar);
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        this.A = null;
        this.D.a();
    }

    private void O() {
        if (this.c.h() == 1073741824) {
            return;
        }
        int v = v();
        float f = 0.0f;
        for (int i = 0; i < v; i++) {
            View i2 = i(i);
            float e = this.c.e(i2);
            if (e >= f) {
                if (((LayoutParams) i2.getLayoutParams()).a()) {
                    e = (1.0f * e) / this.i;
                }
                f = Math.max(f, e);
            }
        }
        int i3 = this.k;
        int round = Math.round(f * this.i);
        if (this.c.h() == Integer.MIN_VALUE) {
            round = Math.min(round, this.c.f());
        }
        f(round);
        if (this.k == i3) {
            return;
        }
        for (int i4 = 0; i4 < v; i4++) {
            View i5 = i(i4);
            LayoutParams layoutParams = (LayoutParams) i5.getLayoutParams();
            if (!layoutParams.b) {
                if (j() && this.j == 1) {
                    i5.offsetLeftAndRight(((-((this.i - 1) - layoutParams.a.e)) * this.k) - ((-((this.i - 1) - layoutParams.a.e)) * i3));
                } else {
                    int i6 = layoutParams.a.e * this.k;
                    int i7 = layoutParams.a.e * i3;
                    if (this.j == 1) {
                        i5.offsetLeftAndRight(i6 - i7);
                    } else {
                        i5.offsetTopAndBottom(i6 - i7);
                    }
                }
            }
        }
    }

    private void a(a aVar) {
        if (this.A.c > 0) {
            if (this.A.c == this.i) {
                for (int i = 0; i < this.i; i++) {
                    this.a[i].e();
                    int i2 = this.A.d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.A.i) {
                            i2 += this.b.d();
                        } else {
                            i2 += this.b.c();
                        }
                    }
                    this.a[i].c(i2);
                }
            } else {
                this.A.a();
                this.A.a = this.A.b;
            }
        }
        this.z = this.A.j;
        a(this.A.h);
        N();
        if (this.A.a != -1) {
            this.f = this.A.a;
            aVar.c = this.A.i;
        } else {
            aVar.c = this.e;
        }
        if (this.A.e > 1) {
            this.h.a = this.A.f;
            this.h.b = this.A.g;
        }
    }

    void a(RecyclerView.s sVar, a aVar) {
        if (b(sVar, aVar) || c(sVar, aVar)) {
            return;
        }
        aVar.b();
        aVar.a = 0;
    }

    private boolean c(RecyclerView.s sVar, a aVar) {
        int v;
        if (this.o) {
            v = w(sVar.e());
        } else {
            v = v(sVar.e());
        }
        aVar.a = v;
        aVar.b = Integer.MIN_VALUE;
        return true;
    }

    boolean b(RecyclerView.s sVar, a aVar) {
        int c;
        if (sVar.a() || this.f == -1) {
            return false;
        }
        if (this.f < 0 || this.f >= sVar.e()) {
            this.f = -1;
            this.g = Integer.MIN_VALUE;
            return false;
        }
        if (this.A == null || this.A.a == -1 || this.A.c < 1) {
            View c2 = c(this.f);
            if (c2 != null) {
                aVar.a = this.e ? K() : L();
                if (this.g != Integer.MIN_VALUE) {
                    if (aVar.c) {
                        aVar.b = (this.b.d() - this.g) - this.b.b(c2);
                    } else {
                        aVar.b = (this.b.c() + this.g) - this.b.a(c2);
                    }
                    return true;
                }
                if (this.b.e(c2) > this.b.f()) {
                    if (aVar.c) {
                        c = this.b.d();
                    } else {
                        c = this.b.c();
                    }
                    aVar.b = c;
                    return true;
                }
                int a2 = this.b.a(c2) - this.b.c();
                if (a2 < 0) {
                    aVar.b = -a2;
                    return true;
                }
                int d = this.b.d() - this.b.b(c2);
                if (d < 0) {
                    aVar.b = d;
                    return true;
                }
                aVar.b = Integer.MIN_VALUE;
            } else {
                aVar.a = this.f;
                if (this.g == Integer.MIN_VALUE) {
                    aVar.c = u(aVar.a) == 1;
                    aVar.b();
                } else {
                    aVar.a(this.g);
                }
                aVar.d = true;
            }
        } else {
            aVar.b = Integer.MIN_VALUE;
            aVar.a = this.f;
        }
        return true;
    }

    void f(int i) {
        this.k = i / this.i;
        this.B = View.MeasureSpec.makeMeasureSpec(i, this.c.h());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean b() {
        return this.A == null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int c(RecyclerView.s sVar) {
        return b(sVar);
    }

    private int b(RecyclerView.s sVar) {
        if (v() == 0) {
            return 0;
        }
        return j.a(sVar, this.b, b(!this.F), c(!this.F), this, this.F, this.e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int d(RecyclerView.s sVar) {
        return b(sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int e(RecyclerView.s sVar) {
        return i(sVar);
    }

    private int i(RecyclerView.s sVar) {
        if (v() == 0) {
            return 0;
        }
        return j.a(sVar, this.b, b(!this.F), c(!this.F), this, this.F);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int f(RecyclerView.s sVar) {
        return i(sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int g(RecyclerView.s sVar) {
        return j(sVar);
    }

    private int j(RecyclerView.s sVar) {
        if (v() == 0) {
            return 0;
        }
        return j.b(sVar, this.b, b(!this.F), c(!this.F), this, this.F);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int h(RecyclerView.s sVar) {
        return j(sVar);
    }

    private void a(View view, LayoutParams layoutParams, boolean z) {
        if (layoutParams.b) {
            if (this.j == 1) {
                a(view, this.B, a(z(), x(), B() + D(), layoutParams.height, true), z);
                return;
            } else {
                a(view, a(y(), w(), A() + C(), layoutParams.width, true), this.B, z);
                return;
            }
        }
        if (this.j == 1) {
            a(view, a(this.k, w(), 0, layoutParams.width, false), a(z(), x(), B() + D(), layoutParams.height, true), z);
        } else {
            a(view, a(y(), w(), A() + C(), layoutParams.width, true), a(this.k, x(), 0, layoutParams.height, false), z);
        }
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean b2;
        b(view, this.C);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int b3 = b(i, layoutParams.leftMargin + this.C.left, layoutParams.rightMargin + this.C.right);
        int b4 = b(i2, layoutParams.topMargin + this.C.top, layoutParams.bottomMargin + this.C.bottom);
        if (z) {
            b2 = a(view, b3, b4, layoutParams);
        } else {
            b2 = b(view, b3, b4, layoutParams);
        }
        if (b2) {
            view.measure(b3, b4);
        }
    }

    private int b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.A = (SavedState) parcelable;
            o();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public Parcelable d() {
        int a2;
        if (this.A != null) {
            return new SavedState(this.A);
        }
        SavedState savedState = new SavedState();
        savedState.h = this.d;
        savedState.i = this.o;
        savedState.j = this.z;
        if (this.h != null && this.h.a != null) {
            savedState.f = this.h.a;
            savedState.e = savedState.f.length;
            savedState.g = this.h.b;
        } else {
            savedState.e = 0;
        }
        if (v() > 0) {
            savedState.a = this.o ? K() : L();
            savedState.b = k();
            savedState.c = this.i;
            savedState.d = new int[this.i];
            for (int i = 0; i < this.i; i++) {
                if (this.o) {
                    a2 = this.a[i].b(Integer.MIN_VALUE);
                    if (a2 != Integer.MIN_VALUE) {
                        a2 -= this.b.d();
                    }
                } else {
                    a2 = this.a[i].a(Integer.MIN_VALUE);
                    if (a2 != Integer.MIN_VALUE) {
                        a2 -= this.b.c();
                    }
                }
                savedState.d[i] = a2;
            }
        } else {
            savedState.a = -1;
            savedState.b = -1;
            savedState.c = 0;
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.o oVar, RecyclerView.s sVar, View view, androidx.core.h.a.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.a(view, dVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.j == 0) {
            dVar.b(d.c.a(layoutParams2.b(), layoutParams2.b ? this.i : 1, -1, -1, layoutParams2.b, false));
        } else {
            dVar.b(d.c.a(-1, -1, layoutParams2.b(), layoutParams2.b ? this.i : 1, layoutParams2.b, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (v() > 0) {
            View b2 = b(false);
            View c = c(false);
            if (b2 == null || c == null) {
                return;
            }
            int d = d(b2);
            int d2 = d(c);
            if (d < d2) {
                accessibilityEvent.setFromIndex(d);
                accessibilityEvent.setToIndex(d2);
            } else {
                accessibilityEvent.setFromIndex(d2);
                accessibilityEvent.setToIndex(d);
            }
        }
    }

    int k() {
        View c = this.e ? c(true) : b(true);
        if (c == null) {
            return -1;
        }
        return d(c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.j == 0) {
            return this.i;
        }
        return super.a(oVar, sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.j == 1) {
            return this.i;
        }
        return super.b(oVar, sVar);
    }

    View b(boolean z) {
        int c = this.b.c();
        int d = this.b.d();
        int v = v();
        View view = null;
        for (int i = 0; i < v; i++) {
            View i2 = i(i);
            int a2 = this.b.a(i2);
            if (this.b.b(i2) > c && a2 < d) {
                if (a2 >= c || !z) {
                    return i2;
                }
                if (view == null) {
                    view = i2;
                }
            }
        }
        return view;
    }

    View c(boolean z) {
        int c = this.b.c();
        int d = this.b.d();
        View view = null;
        for (int v = v() - 1; v >= 0; v--) {
            View i = i(v);
            int a2 = this.b.a(i);
            int b2 = this.b.b(i);
            if (b2 > c && a2 < d) {
                if (b2 <= d || !z) {
                    return i;
                }
                if (view == null) {
                    view = i;
                }
            }
        }
        return view;
    }

    private void b(RecyclerView.o oVar, RecyclerView.s sVar, boolean z) {
        int d;
        int r = r(Integer.MIN_VALUE);
        if (r != Integer.MIN_VALUE && (d = this.b.d() - r) > 0) {
            int i = d - (-c(-d, oVar, sVar));
            if (!z || i <= 0) {
                return;
            }
            this.b.a(i);
        }
    }

    private void c(RecyclerView.o oVar, RecyclerView.s sVar, boolean z) {
        int c;
        int q = q(Integer.MAX_VALUE);
        if (q != Integer.MAX_VALUE && (c = q - this.b.c()) > 0) {
            int c2 = c - c(c, oVar, sVar);
            if (!z || c2 <= 0) {
                return;
            }
            this.b.a(-c2);
        }
    }

    private void b(int i, RecyclerView.s sVar) {
        int i2;
        int i3;
        int c;
        boolean z = false;
        this.l.b = 0;
        this.l.c = i;
        if (!s() || (c = sVar.c()) == -1) {
            i2 = 0;
            i3 = 0;
        } else {
            if (this.e == (c < i)) {
                i3 = this.b.f();
                i2 = 0;
            } else {
                i2 = this.b.f();
                i3 = 0;
            }
        }
        if (r()) {
            this.l.f = this.b.c() - i2;
            this.l.g = this.b.d() + i3;
        } else {
            this.l.g = this.b.e() + i3;
            this.l.f = -i2;
        }
        this.l.h = false;
        this.l.a = true;
        f fVar = this.l;
        if (this.b.h() == 0 && this.b.e() == 0) {
            z = true;
        }
        fVar.i = z;
    }

    private void m(int i) {
        this.l.e = i;
        this.l.d = this.e != (i == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void j(int i) {
        super.j(i);
        for (int i2 = 0; i2 < this.i; i2++) {
            this.a[i2].d(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void k(int i) {
        super.k(i);
        for (int i2 = 0; i2 < this.i; i2++) {
            this.a[i2].d(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void b(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView) {
        this.h.a();
        o();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        c(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        c(i, i2, 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(int r6, int r7, int r8) {
        /*
            r5 = this;
            boolean r0 = r5.e
            if (r0 == 0) goto L9
            int r0 = r5.K()
            goto Ld
        L9:
            int r0 = r5.L()
        Ld:
            r1 = 8
            if (r8 != r1) goto L1b
            if (r6 >= r7) goto L16
            int r2 = r7 + 1
            goto L1d
        L16:
            int r2 = r6 + 1
            r3 = r2
            r2 = r7
            goto L1f
        L1b:
            int r2 = r6 + r7
        L1d:
            r3 = r2
            r2 = r6
        L1f:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r5.h
            r4.b(r2)
            if (r8 == r1) goto L36
            switch(r8) {
                case 1: goto L30;
                case 2: goto L2a;
                default: goto L29;
            }
        L29:
            goto L41
        L2a:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r8 = r5.h
            r8.a(r6, r7)
            goto L41
        L30:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r8 = r5.h
            r8.b(r6, r7)
            goto L41
        L36:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r8 = r5.h
            r1 = 1
            r8.a(r6, r1)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r6 = r5.h
            r6.b(r7, r1)
        L41:
            if (r3 > r0) goto L44
            return
        L44:
            boolean r6 = r5.e
            if (r6 == 0) goto L4d
            int r6 = r5.L()
            goto L51
        L4d:
            int r6 = r5.K()
        L51:
            if (r2 > r6) goto L56
            r5.o()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c(int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v6 */
    private int a(RecyclerView.o oVar, f fVar, RecyclerView.s sVar) {
        int i;
        int c;
        int r;
        b bVar;
        int e;
        int i2;
        int i3;
        int e2;
        boolean z;
        boolean n;
        ?? r9 = 0;
        this.m.set(0, this.i, true);
        if (this.l.i) {
            i = fVar.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else if (fVar.e == 1) {
            i = fVar.g + fVar.b;
        } else {
            i = fVar.f - fVar.b;
        }
        int i4 = i;
        a(fVar.e, i4);
        if (this.e) {
            c = this.b.d();
        } else {
            c = this.b.c();
        }
        int i5 = c;
        boolean z2 = false;
        while (fVar.a(sVar) && (this.l.i || !this.m.isEmpty())) {
            View a2 = fVar.a(oVar);
            LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
            int f = layoutParams.f();
            int c2 = this.h.c(f);
            boolean z3 = c2 == -1 ? true : r9;
            if (z3) {
                bVar = layoutParams.b ? this.a[r9] : a(fVar);
                this.h.a(f, bVar);
            } else {
                bVar = this.a[c2];
            }
            b bVar2 = bVar;
            layoutParams.a = bVar2;
            if (fVar.e == 1) {
                b(a2);
            } else {
                b(a2, (int) r9);
            }
            a(a2, layoutParams, (boolean) r9);
            if (fVar.e == 1) {
                int r2 = layoutParams.b ? r(i5) : bVar2.b(i5);
                int e3 = this.b.e(a2) + r2;
                if (z3 && layoutParams.b) {
                    LazySpanLookup.FullSpanItem n2 = n(r2);
                    n2.b = -1;
                    n2.a = f;
                    this.h.a(n2);
                }
                i2 = e3;
                e = r2;
            } else {
                int q = layoutParams.b ? q(i5) : bVar2.a(i5);
                e = q - this.b.e(a2);
                if (z3 && layoutParams.b) {
                    LazySpanLookup.FullSpanItem o = o(q);
                    o.b = 1;
                    o.a = f;
                    this.h.a(o);
                }
                i2 = q;
            }
            if (layoutParams.b && fVar.d == -1) {
                if (z3) {
                    this.E = true;
                } else {
                    if (fVar.e == 1) {
                        n = m();
                    } else {
                        n = n();
                    }
                    if (!n) {
                        LazySpanLookup.FullSpanItem f2 = this.h.f(f);
                        if (f2 != null) {
                            f2.d = true;
                        }
                        this.E = true;
                    }
                }
            }
            a(a2, layoutParams, fVar);
            if (j() && this.j == 1) {
                int d = layoutParams.b ? this.c.d() : this.c.d() - (((this.i - 1) - bVar2.e) * this.k);
                e2 = d;
                i3 = d - this.c.e(a2);
            } else {
                int c3 = layoutParams.b ? this.c.c() : (bVar2.e * this.k) + this.c.c();
                i3 = c3;
                e2 = this.c.e(a2) + c3;
            }
            if (this.j == 1) {
                a(a2, i3, e, e2, i2);
            } else {
                a(a2, e, i3, i2, e2);
            }
            if (layoutParams.b) {
                a(this.l.e, i4);
            } else {
                a(bVar2, this.l.e, i4);
            }
            a(oVar, this.l);
            if (this.l.h && a2.hasFocusable()) {
                if (layoutParams.b) {
                    this.m.clear();
                } else {
                    z = false;
                    this.m.set(bVar2.e, false);
                    r9 = z;
                    z2 = true;
                }
            }
            z = false;
            r9 = z;
            z2 = true;
        }
        int i6 = r9;
        if (!z2) {
            a(oVar, this.l);
        }
        if (this.l.e == -1) {
            r = this.b.c() - q(this.b.c());
        } else {
            r = r(this.b.d()) - this.b.d();
        }
        return r > 0 ? Math.min(fVar.b, r) : i6;
    }

    private LazySpanLookup.FullSpanItem n(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.c = new int[this.i];
        for (int i2 = 0; i2 < this.i; i2++) {
            fullSpanItem.c[i2] = i - this.a[i2].b(i);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem o(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.c = new int[this.i];
        for (int i2 = 0; i2 < this.i; i2++) {
            fullSpanItem.c[i2] = this.a[i2].a(i) - i;
        }
        return fullSpanItem;
    }

    private void a(View view, LayoutParams layoutParams, f fVar) {
        if (fVar.e == 1) {
            if (layoutParams.b) {
                p(view);
                return;
            } else {
                layoutParams.a.b(view);
                return;
            }
        }
        if (layoutParams.b) {
            q(view);
        } else {
            layoutParams.a.a(view);
        }
    }

    private void a(RecyclerView.o oVar, f fVar) {
        int min;
        int min2;
        if (!fVar.a || fVar.i) {
            return;
        }
        if (fVar.b == 0) {
            if (fVar.e == -1) {
                b(oVar, fVar.g);
                return;
            } else {
                a(oVar, fVar.f);
                return;
            }
        }
        if (fVar.e == -1) {
            int p = fVar.f - p(fVar.f);
            if (p < 0) {
                min2 = fVar.g;
            } else {
                min2 = fVar.g - Math.min(p, fVar.b);
            }
            b(oVar, min2);
            return;
        }
        int s = s(fVar.g) - fVar.g;
        if (s < 0) {
            min = fVar.f;
        } else {
            min = Math.min(s, fVar.b) + fVar.f;
        }
        a(oVar, min);
    }

    private void p(View view) {
        for (int i = this.i - 1; i >= 0; i--) {
            this.a[i].b(view);
        }
    }

    private void q(View view) {
        for (int i = this.i - 1; i >= 0; i--) {
            this.a[i].a(view);
        }
    }

    private void a(int i, int i2) {
        for (int i3 = 0; i3 < this.i; i3++) {
            if (!this.a[i3].a.isEmpty()) {
                a(this.a[i3], i, i2);
            }
        }
    }

    private void a(b bVar, int i, int i2) {
        int i3 = bVar.i();
        if (i == -1) {
            if (bVar.b() + i3 <= i2) {
                this.m.set(bVar.e, false);
            }
        } else if (bVar.d() - i3 >= i2) {
            this.m.set(bVar.e, false);
        }
    }

    private int p(int i) {
        int a2 = this.a[0].a(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int a3 = this.a[i2].a(i);
            if (a3 > a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private int q(int i) {
        int a2 = this.a[0].a(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int a3 = this.a[i2].a(i);
            if (a3 < a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    boolean m() {
        int b2 = this.a[0].b(Integer.MIN_VALUE);
        for (int i = 1; i < this.i; i++) {
            if (this.a[i].b(Integer.MIN_VALUE) != b2) {
                return false;
            }
        }
        return true;
    }

    boolean n() {
        int a2 = this.a[0].a(Integer.MIN_VALUE);
        for (int i = 1; i < this.i; i++) {
            if (this.a[i].a(Integer.MIN_VALUE) != a2) {
                return false;
            }
        }
        return true;
    }

    private int r(int i) {
        int b2 = this.a[0].b(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int b3 = this.a[i2].b(i);
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private int s(int i) {
        int b2 = this.a[0].b(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int b3 = this.a[i2].b(i);
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private void a(RecyclerView.o oVar, int i) {
        while (v() > 0) {
            View i2 = i(0);
            if (this.b.b(i2) > i || this.b.c(i2) > i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) i2.getLayoutParams();
            if (layoutParams.b) {
                for (int i3 = 0; i3 < this.i; i3++) {
                    if (this.a[i3].a.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.i; i4++) {
                    this.a[i4].h();
                }
            } else if (layoutParams.a.a.size() == 1) {
                return;
            } else {
                layoutParams.a.h();
            }
            a(i2, oVar);
        }
    }

    private void b(RecyclerView.o oVar, int i) {
        for (int v = v() - 1; v >= 0; v--) {
            View i2 = i(v);
            if (this.b.a(i2) < i || this.b.d(i2) < i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) i2.getLayoutParams();
            if (layoutParams.b) {
                for (int i3 = 0; i3 < this.i; i3++) {
                    if (this.a[i3].a.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.i; i4++) {
                    this.a[i4].g();
                }
            } else if (layoutParams.a.a.size() == 1) {
                return;
            } else {
                layoutParams.a.g();
            }
            a(i2, oVar);
        }
    }

    private boolean t(int i) {
        if (this.j == 0) {
            return (i == -1) != this.e;
        }
        return ((i == -1) == this.e) == j();
    }

    private b a(f fVar) {
        int i;
        int i2;
        int i3 = -1;
        if (t(fVar.e)) {
            i = this.i - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.i;
            i2 = 1;
        }
        b bVar = null;
        if (fVar.e == 1) {
            int i4 = Integer.MAX_VALUE;
            int c = this.b.c();
            while (i != i3) {
                b bVar2 = this.a[i];
                int b2 = bVar2.b(c);
                if (b2 < i4) {
                    bVar = bVar2;
                    i4 = b2;
                }
                i += i2;
            }
            return bVar;
        }
        int i5 = Integer.MIN_VALUE;
        int d = this.b.d();
        while (i != i3) {
            b bVar3 = this.a[i];
            int a2 = bVar3.a(d);
            if (a2 > i5) {
                bVar = bVar3;
                i5 = a2;
            }
            i += i2;
        }
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean f() {
        return this.j == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean e() {
        return this.j == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        return c(i, oVar, sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        return c(i, oVar, sVar);
    }

    private int u(int i) {
        if (v() == 0) {
            return this.e ? 1 : -1;
        }
        return (i < L()) != this.e ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r.b
    public PointF d(int i) {
        int u = u(i);
        PointF pointF = new PointF();
        if (u == 0) {
            return null;
        }
        if (this.j == 0) {
            pointF.x = u;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = u;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void e(int i) {
        if (this.A != null && this.A.a != i) {
            this.A.b();
        }
        this.f = i;
        this.g = Integer.MIN_VALUE;
        o();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(int i, int i2, RecyclerView.s sVar, RecyclerView.i.a aVar) {
        int b2;
        if (this.j != 0) {
            i = i2;
        }
        if (v() == 0 || i == 0) {
            return;
        }
        a(i, sVar);
        if (this.G == null || this.G.length < this.i) {
            this.G = new int[this.i];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.i; i4++) {
            if (this.l.d == -1) {
                b2 = this.l.f - this.a[i4].a(this.l.f);
            } else {
                b2 = this.a[i4].b(this.l.g) - this.l.g;
            }
            if (b2 >= 0) {
                this.G[i3] = b2;
                i3++;
            }
        }
        Arrays.sort(this.G, 0, i3);
        for (int i5 = 0; i5 < i3 && this.l.a(sVar); i5++) {
            aVar.b(this.l.c, this.G[i5]);
            this.l.c += this.l.d;
        }
    }

    void a(int i, RecyclerView.s sVar) {
        int i2;
        int L;
        if (i > 0) {
            L = K();
            i2 = 1;
        } else {
            i2 = -1;
            L = L();
        }
        this.l.a = true;
        b(L, sVar);
        m(i2);
        this.l.c = L + this.l.d;
        this.l.b = Math.abs(i);
    }

    int c(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        if (v() == 0 || i == 0) {
            return 0;
        }
        a(i, sVar);
        int a2 = a(oVar, this.l, sVar);
        if (this.l.b >= a2) {
            i = i < 0 ? -a2 : a2;
        }
        this.b.a(-i);
        this.o = this.e;
        this.l.b = 0;
        a(oVar, this.l);
        return i;
    }

    int K() {
        int v = v();
        if (v == 0) {
            return 0;
        }
        return d(i(v - 1));
    }

    int L() {
        if (v() == 0) {
            return 0;
        }
        return d(i(0));
    }

    private int v(int i) {
        int v = v();
        for (int i2 = 0; i2 < v; i2++) {
            int d = d(i(i2));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int w(int i) {
        for (int v = v() - 1; v >= 0; v--) {
            int d = d(i(v));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams a() {
        if (this.j == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean a(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View a(View view, int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        View e;
        int L;
        int k;
        int k2;
        int k3;
        View a2;
        if (v() == 0 || (e = e(view)) == null) {
            return null;
        }
        N();
        int x = x(i);
        if (x == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) e.getLayoutParams();
        boolean z = layoutParams.b;
        b bVar = layoutParams.a;
        if (x == 1) {
            L = K();
        } else {
            L = L();
        }
        b(L, sVar);
        m(x);
        this.l.c = this.l.d + L;
        this.l.b = (int) (0.33333334f * this.b.f());
        this.l.h = true;
        this.l.a = false;
        a(oVar, this.l, sVar);
        this.o = this.e;
        if (!z && (a2 = bVar.a(L, x)) != null && a2 != e) {
            return a2;
        }
        if (t(x)) {
            for (int i2 = this.i - 1; i2 >= 0; i2--) {
                View a3 = this.a[i2].a(L, x);
                if (a3 != null && a3 != e) {
                    return a3;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.i; i3++) {
                View a4 = this.a[i3].a(L, x);
                if (a4 != null && a4 != e) {
                    return a4;
                }
            }
        }
        boolean z2 = (this.d ^ true) == (x == -1);
        if (!z) {
            if (z2) {
                k3 = bVar.j();
            } else {
                k3 = bVar.k();
            }
            View c = c(k3);
            if (c != null && c != e) {
                return c;
            }
        }
        if (t(x)) {
            for (int i4 = this.i - 1; i4 >= 0; i4--) {
                if (i4 != bVar.e) {
                    if (z2) {
                        k2 = this.a[i4].j();
                    } else {
                        k2 = this.a[i4].k();
                    }
                    View c2 = c(k2);
                    if (c2 != null && c2 != e) {
                        return c2;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.i; i5++) {
                if (z2) {
                    k = this.a[i5].j();
                } else {
                    k = this.a[i5].k();
                }
                View c3 = c(k);
                if (c3 != null && c3 != e) {
                    return c3;
                }
            }
        }
        return null;
    }

    private int x(int i) {
        if (i == 17) {
            return this.j == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 33) {
            return this.j == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 66) {
            return this.j == 0 ? 1 : Integer.MIN_VALUE;
        }
        if (i == 130) {
            return this.j == 1 ? 1 : Integer.MIN_VALUE;
        }
        switch (i) {
            case 1:
                return (this.j != 1 && j()) ? 1 : -1;
            case 2:
                return (this.j != 1 && j()) ? -1 : 1;
            default:
                return Integer.MIN_VALUE;
        }
    }

    /* compiled from: source */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        b a;
        boolean b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public boolean a() {
            return this.b;
        }

        public final int b() {
            if (this.a == null) {
                return -1;
            }
            return this.a.e;
        }
    }

    /* compiled from: source */
    class b {
        ArrayList<View> a = new ArrayList<>();
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d = 0;
        final int e;

        b(int i) {
            this.e = i;
        }

        int a(int i) {
            if (this.b != Integer.MIN_VALUE) {
                return this.b;
            }
            if (this.a.size() == 0) {
                return i;
            }
            a();
            return this.b;
        }

        void a() {
            LazySpanLookup.FullSpanItem f;
            View view = this.a.get(0);
            LayoutParams c = c(view);
            this.b = StaggeredGridLayoutManager.this.b.a(view);
            if (c.b && (f = StaggeredGridLayoutManager.this.h.f(c.f())) != null && f.b == -1) {
                this.b -= f.a(this.e);
            }
        }

        int b() {
            if (this.b != Integer.MIN_VALUE) {
                return this.b;
            }
            a();
            return this.b;
        }

        int b(int i) {
            if (this.c != Integer.MIN_VALUE) {
                return this.c;
            }
            if (this.a.size() == 0) {
                return i;
            }
            c();
            return this.c;
        }

        void c() {
            LazySpanLookup.FullSpanItem f;
            View view = this.a.get(this.a.size() - 1);
            LayoutParams c = c(view);
            this.c = StaggeredGridLayoutManager.this.b.b(view);
            if (c.b && (f = StaggeredGridLayoutManager.this.h.f(c.f())) != null && f.b == 1) {
                this.c += f.a(this.e);
            }
        }

        int d() {
            if (this.c != Integer.MIN_VALUE) {
                return this.c;
            }
            c();
            return this.c;
        }

        void a(View view) {
            LayoutParams c = c(view);
            c.a = this;
            this.a.add(0, view);
            this.b = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (c.d() || c.e()) {
                this.d += StaggeredGridLayoutManager.this.b.e(view);
            }
        }

        void b(View view) {
            LayoutParams c = c(view);
            c.a = this;
            this.a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.b = Integer.MIN_VALUE;
            }
            if (c.d() || c.e()) {
                this.d += StaggeredGridLayoutManager.this.b.e(view);
            }
        }

        void a(boolean z, int i) {
            int a;
            if (z) {
                a = b(Integer.MIN_VALUE);
            } else {
                a = a(Integer.MIN_VALUE);
            }
            e();
            if (a == Integer.MIN_VALUE) {
                return;
            }
            if (!z || a >= StaggeredGridLayoutManager.this.b.d()) {
                if (z || a <= StaggeredGridLayoutManager.this.b.c()) {
                    if (i != Integer.MIN_VALUE) {
                        a += i;
                    }
                    this.c = a;
                    this.b = a;
                }
            }
        }

        void e() {
            this.a.clear();
            f();
            this.d = 0;
        }

        void f() {
            this.b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
        }

        void c(int i) {
            this.b = i;
            this.c = i;
        }

        void g() {
            int size = this.a.size();
            View remove = this.a.remove(size - 1);
            LayoutParams c = c(remove);
            c.a = null;
            if (c.d() || c.e()) {
                this.d -= StaggeredGridLayoutManager.this.b.e(remove);
            }
            if (size == 1) {
                this.b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        void h() {
            View remove = this.a.remove(0);
            LayoutParams c = c(remove);
            c.a = null;
            if (this.a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (c.d() || c.e()) {
                this.d -= StaggeredGridLayoutManager.this.b.e(remove);
            }
            this.b = Integer.MIN_VALUE;
        }

        public int i() {
            return this.d;
        }

        LayoutParams c(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        void d(int i) {
            if (this.b != Integer.MIN_VALUE) {
                this.b += i;
            }
            if (this.c != Integer.MIN_VALUE) {
                this.c += i;
            }
        }

        public int j() {
            if (StaggeredGridLayoutManager.this.d) {
                return a(this.a.size() - 1, -1, true);
            }
            return a(0, this.a.size(), true);
        }

        public int k() {
            if (StaggeredGridLayoutManager.this.d) {
                return a(0, this.a.size(), true);
            }
            return a(this.a.size() - 1, -1, true);
        }

        int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int c = StaggeredGridLayoutManager.this.b.c();
            int d = StaggeredGridLayoutManager.this.b.d();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.a.get(i);
                int a = StaggeredGridLayoutManager.this.b.a(view);
                int b = StaggeredGridLayoutManager.this.b.b(view);
                boolean z4 = false;
                boolean z5 = !z3 ? a >= d : a > d;
                if (!z3 ? b > c : b >= c) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (a >= c && b <= d) {
                            return StaggeredGridLayoutManager.this.d(view);
                        }
                    } else {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.d(view);
                        }
                        if (a < c || b > d) {
                            return StaggeredGridLayoutManager.this.d(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        int a(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }

        public View a(int i, int i2) {
            View view = null;
            if (i2 == -1) {
                int size = this.a.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.a.get(i3);
                    if ((StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view2) <= i) || ((!StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view2) >= i) || !view2.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
            } else {
                int size2 = this.a.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.a.get(size2);
                    if ((StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view3) >= i) || ((!StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.d(view3) <= i) || !view3.hasFocusable())) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }
    }

    /* compiled from: source */
    static class LazySpanLookup {
        int[] a;
        List<FullSpanItem> b;

        LazySpanLookup() {
        }

        int a(int i) {
            if (this.b != null) {
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    if (this.b.get(size).a >= i) {
                        this.b.remove(size);
                    }
                }
            }
            return b(i);
        }

        int b(int i) {
            if (this.a == null || i >= this.a.length) {
                return -1;
            }
            int g = g(i);
            if (g == -1) {
                Arrays.fill(this.a, i, this.a.length, -1);
                return this.a.length;
            }
            int i2 = g + 1;
            Arrays.fill(this.a, i, i2, -1);
            return i2;
        }

        int c(int i) {
            if (this.a == null || i >= this.a.length) {
                return -1;
            }
            return this.a[i];
        }

        void a(int i, b bVar) {
            e(i);
            this.a[i] = bVar.e;
        }

        int d(int i) {
            int length = this.a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void e(int i) {
            if (this.a == null) {
                this.a = new int[Math.max(i, 10) + 1];
                Arrays.fill(this.a, -1);
            } else if (i >= this.a.length) {
                int[] iArr = this.a;
                this.a = new int[d(i)];
                System.arraycopy(iArr, 0, this.a, 0, iArr.length);
                Arrays.fill(this.a, iArr.length, this.a.length, -1);
            }
        }

        void a() {
            if (this.a != null) {
                Arrays.fill(this.a, -1);
            }
            this.b = null;
        }

        void a(int i, int i2) {
            if (this.a == null || i >= this.a.length) {
                return;
            }
            int i3 = i + i2;
            e(i3);
            System.arraycopy(this.a, i3, this.a, i, (this.a.length - i) - i2);
            Arrays.fill(this.a, this.a.length - i2, this.a.length, -1);
            c(i, i2);
        }

        private void c(int i, int i2) {
            if (this.b == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = this.b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.b.get(size);
                if (fullSpanItem.a >= i) {
                    if (fullSpanItem.a < i3) {
                        this.b.remove(size);
                    } else {
                        fullSpanItem.a -= i2;
                    }
                }
            }
        }

        void b(int i, int i2) {
            if (this.a == null || i >= this.a.length) {
                return;
            }
            int i3 = i + i2;
            e(i3);
            System.arraycopy(this.a, i, this.a, i3, (this.a.length - i) - i2);
            Arrays.fill(this.a, i, i3, -1);
            d(i, i2);
        }

        private void d(int i, int i2) {
            if (this.b == null) {
                return;
            }
            for (int size = this.b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.b.get(size);
                if (fullSpanItem.a >= i) {
                    fullSpanItem.a += i2;
                }
            }
        }

        private int g(int i) {
            if (this.b == null) {
                return -1;
            }
            FullSpanItem f = f(i);
            if (f != null) {
                this.b.remove(f);
            }
            int size = this.b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (this.b.get(i2).a >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = this.b.get(i2);
            this.b.remove(i2);
            return fullSpanItem.a;
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.b.get(i);
                if (fullSpanItem2.a == fullSpanItem.a) {
                    this.b.remove(i);
                }
                if (fullSpanItem2.a >= fullSpanItem.a) {
                    this.b.add(i, fullSpanItem);
                    return;
                }
            }
            this.b.add(fullSpanItem);
        }

        public FullSpanItem f(int i) {
            if (this.b == null) {
                return null;
            }
            for (int size = this.b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.b.get(size);
                if (fullSpanItem.a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem a(int i, int i2, int i3, boolean z) {
            if (this.b == null) {
                return null;
            }
            int size = this.b.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.b.get(i4);
                if (fullSpanItem.a >= i2) {
                    return null;
                }
                if (fullSpanItem.a >= i && (i3 == 0 || fullSpanItem.b == i3 || (z && fullSpanItem.d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* compiled from: source */
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
                AnonymousClass1() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };
            int a;
            int b;
            int[] c;
            boolean d;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            FullSpanItem(Parcel parcel) {
                this.a = parcel.readInt();
                this.b = parcel.readInt();
                this.d = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.c = new int[readInt];
                    parcel.readIntArray(this.c);
                }
            }

            FullSpanItem() {
            }

            int a(int i) {
                if (this.c == null) {
                    return 0;
                }
                return this.c[i];
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b);
                parcel.writeInt(this.d ? 1 : 0);
                if (this.c != null && this.c.length > 0) {
                    parcel.writeInt(this.c.length);
                    parcel.writeIntArray(this.c);
                } else {
                    parcel.writeInt(0);
                }
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.a + ", mGapDir=" + this.b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
            }

            /* compiled from: source */
            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1 */
            static class AnonymousClass1 implements Parcelable.Creator<FullSpanItem> {
                AnonymousClass1() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            }
        }
    }

    /* compiled from: source */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int a;
        int b;
        int c;
        int[] d;
        int e;
        int[] f;
        List<LazySpanLookup.FullSpanItem> g;
        boolean h;
        boolean i;
        boolean j;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            if (this.c > 0) {
                this.d = new int[this.c];
                parcel.readIntArray(this.d);
            }
            this.e = parcel.readInt();
            if (this.e > 0) {
                this.f = new int[this.e];
                parcel.readIntArray(this.f);
            }
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.c = savedState.c;
            this.a = savedState.a;
            this.b = savedState.b;
            this.d = savedState.d;
            this.e = savedState.e;
            this.f = savedState.f;
            this.h = savedState.h;
            this.i = savedState.i;
            this.j = savedState.j;
            this.g = savedState.g;
        }

        void a() {
            this.d = null;
            this.c = 0;
            this.e = 0;
            this.f = null;
            this.g = null;
        }

        void b() {
            this.d = null;
            this.c = 0;
            this.a = -1;
            this.b = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.g);
        }

        /* compiled from: source */
        /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState$1 */
        static class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }
    }

    /* compiled from: source */
    class a {
        int a;
        int b;
        boolean c;
        boolean d;
        boolean e;
        int[] f;

        a() {
            a();
        }

        void a() {
            this.a = -1;
            this.b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            if (this.f != null) {
                Arrays.fill(this.f, -1);
            }
        }

        void a(b[] bVarArr) {
            int length = bVarArr.length;
            if (this.f == null || this.f.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.a.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = bVarArr[i].a(Integer.MIN_VALUE);
            }
        }

        void b() {
            this.b = this.c ? StaggeredGridLayoutManager.this.b.d() : StaggeredGridLayoutManager.this.b.c();
        }

        void a(int i) {
            if (this.c) {
                this.b = StaggeredGridLayoutManager.this.b.d() - i;
            } else {
                this.b = StaggeredGridLayoutManager.this.b.c() + i;
            }
        }
    }
}
