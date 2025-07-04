package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.i implements RecyclerView.r.b {
    private c a;
    private boolean b;
    private boolean f;
    h j;
    int i = 1;
    private boolean c = false;
    boolean k = false;
    private boolean d = false;
    private boolean e = true;
    int l = -1;
    int m = Integer.MIN_VALUE;
    SavedState n = null;
    final a o = new a();
    private final b g = new b();
    private int h = 2;

    void a(RecyclerView.o oVar, RecyclerView.s sVar, a aVar, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean c() {
        return true;
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        b(i);
        b(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.i.b a2 = a(context, attributeSet, i, i2);
        b(a2.a);
        b(a2.c);
        a(a2.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams a() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, RecyclerView.o oVar) {
        super.a(recyclerView, oVar);
        if (this.f) {
            c(oVar);
            oVar.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(m());
            accessibilityEvent.setToIndex(n());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public Parcelable d() {
        if (this.n != null) {
            return new SavedState(this.n);
        }
        SavedState savedState = new SavedState();
        if (v() > 0) {
            i();
            boolean z = this.b ^ this.k;
            savedState.c = z;
            if (z) {
                View M = M();
                savedState.b = this.j.d() - this.j.b(M);
                savedState.a = d(M);
            } else {
                View L = L();
                savedState.a = d(L);
                savedState.b = this.j.a(L) - this.j.c();
            }
        } else {
            savedState.b();
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.n = (SavedState) parcelable;
            o();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean e() {
        return this.i == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean f() {
        return this.i == 1;
    }

    public void a(boolean z) {
        a((String) null);
        if (this.d == z) {
            return;
        }
        this.d = z;
        o();
    }

    public int g() {
        return this.i;
    }

    public void b(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        a((String) null);
        if (i != this.i || this.j == null) {
            this.j = h.a(this, i);
            this.o.a = this.j;
            this.i = i;
            o();
        }
    }

    private void K() {
        if (this.i == 1 || !h()) {
            this.k = this.c;
        } else {
            this.k = !this.c;
        }
    }

    public void b(boolean z) {
        a((String) null);
        if (z == this.c) {
            return;
        }
        this.c = z;
        o();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View c(int i) {
        int v = v();
        if (v == 0) {
            return null;
        }
        int d = i - d(i(0));
        if (d >= 0 && d < v) {
            View i2 = i(d);
            if (d(i2) == i) {
                return i2;
            }
        }
        return super.c(i);
    }

    protected int b(RecyclerView.s sVar) {
        if (sVar.d()) {
            return this.j.f();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r.b
    public PointF d(int i) {
        if (v() == 0) {
            return null;
        }
        int i2 = (i < d(i(0))) != this.k ? -1 : 1;
        if (this.i == 0) {
            return new PointF(i2, 0.0f);
        }
        return new PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void c(RecyclerView.o oVar, RecyclerView.s sVar) {
        int i;
        int i2;
        int i3;
        View c2;
        int a2;
        int i4 = -1;
        if ((this.n != null || this.l != -1) && sVar.e() == 0) {
            c(oVar);
            return;
        }
        if (this.n != null && this.n.a()) {
            this.l = this.n.a;
        }
        i();
        this.a.a = false;
        K();
        View E = E();
        if (!this.o.e || this.l != -1 || this.n != null) {
            this.o.a();
            this.o.d = this.k ^ this.d;
            a(oVar, sVar, this.o);
            this.o.e = true;
        } else if (E != null && (this.j.a(E) >= this.j.d() || this.j.b(E) <= this.j.c())) {
            this.o.a(E, d(E));
        }
        int b2 = b(sVar);
        if (this.a.j >= 0) {
            i = b2;
            b2 = 0;
        } else {
            i = 0;
        }
        int c3 = b2 + this.j.c();
        int g = i + this.j.g();
        if (sVar.a() && this.l != -1 && this.m != Integer.MIN_VALUE && (c2 = c(this.l)) != null) {
            if (this.k) {
                a2 = (this.j.d() - this.j.b(c2)) - this.m;
            } else {
                a2 = this.m - (this.j.a(c2) - this.j.c());
            }
            if (a2 > 0) {
                c3 += a2;
            } else {
                g -= a2;
            }
        }
        if (!this.o.d ? !this.k : this.k) {
            i4 = 1;
        }
        a(oVar, sVar, this.o, i4);
        a(oVar);
        this.a.l = k();
        this.a.i = sVar.a();
        if (this.o.d) {
            b(this.o);
            this.a.h = c3;
            a(oVar, this.a, sVar, false);
            i3 = this.a.b;
            int i5 = this.a.d;
            if (this.a.c > 0) {
                g += this.a.c;
            }
            a(this.o);
            this.a.h = g;
            this.a.d += this.a.e;
            a(oVar, this.a, sVar, false);
            i2 = this.a.b;
            if (this.a.c > 0) {
                int i6 = this.a.c;
                g(i5, i3);
                this.a.h = i6;
                a(oVar, this.a, sVar, false);
                i3 = this.a.b;
            }
        } else {
            a(this.o);
            this.a.h = g;
            a(oVar, this.a, sVar, false);
            i2 = this.a.b;
            int i7 = this.a.d;
            if (this.a.c > 0) {
                c3 += this.a.c;
            }
            b(this.o);
            this.a.h = c3;
            this.a.d += this.a.e;
            a(oVar, this.a, sVar, false);
            i3 = this.a.b;
            if (this.a.c > 0) {
                int i8 = this.a.c;
                a(i7, i2);
                this.a.h = i8;
                a(oVar, this.a, sVar, false);
                i2 = this.a.b;
            }
        }
        if (v() > 0) {
            if (this.k ^ this.d) {
                int a3 = a(i2, oVar, sVar, true);
                int i9 = i3 + a3;
                int i10 = i2 + a3;
                int b3 = b(i9, oVar, sVar, false);
                i3 = i9 + b3;
                i2 = i10 + b3;
            } else {
                int b4 = b(i3, oVar, sVar, true);
                int i11 = i3 + b4;
                int i12 = i2 + b4;
                int a4 = a(i12, oVar, sVar, false);
                i3 = i11 + a4;
                i2 = i12 + a4;
            }
        }
        b(oVar, sVar, i3, i2);
        if (!sVar.a()) {
            this.j.a();
        } else {
            this.o.a();
        }
        this.b = this.d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.s sVar) {
        super.a(sVar);
        this.n = null;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.o.a();
    }

    private void b(RecyclerView.o oVar, RecyclerView.s sVar, int i, int i2) {
        if (!sVar.b() || v() == 0 || sVar.a() || !b()) {
            return;
        }
        List<RecyclerView.v> c2 = oVar.c();
        int size = c2.size();
        int d = d(i(0));
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.v vVar = c2.get(i5);
            if (!vVar.q()) {
                if (((vVar.d() < d) != this.k ? (char) 65535 : (char) 1) == 65535) {
                    i3 += this.j.e(vVar.a);
                } else {
                    i4 += this.j.e(vVar.a);
                }
            }
        }
        this.a.k = c2;
        if (i3 > 0) {
            g(d(L()), i);
            this.a.h = i3;
            this.a.c = 0;
            this.a.a();
            a(oVar, this.a, sVar, false);
        }
        if (i4 > 0) {
            a(d(M()), i2);
            this.a.h = i4;
            this.a.c = 0;
            this.a.a();
            a(oVar, this.a, sVar, false);
        }
        this.a.k = null;
    }

    private void a(RecyclerView.o oVar, RecyclerView.s sVar, a aVar) {
        if (a(sVar, aVar) || b(oVar, sVar, aVar)) {
            return;
        }
        aVar.b();
        aVar.b = this.d ? sVar.e() - 1 : 0;
    }

    private boolean b(RecyclerView.o oVar, RecyclerView.s sVar, a aVar) {
        View g;
        int c2;
        if (v() == 0) {
            return false;
        }
        View E = E();
        if (E != null && aVar.a(E, sVar)) {
            aVar.a(E, d(E));
            return true;
        }
        if (this.b != this.d) {
            return false;
        }
        if (aVar.d) {
            g = f(oVar, sVar);
        } else {
            g = g(oVar, sVar);
        }
        if (g == null) {
            return false;
        }
        aVar.b(g, d(g));
        if (!sVar.a() && b()) {
            if (this.j.a(g) >= this.j.d() || this.j.b(g) < this.j.c()) {
                if (aVar.d) {
                    c2 = this.j.d();
                } else {
                    c2 = this.j.c();
                }
                aVar.c = c2;
            }
        }
        return true;
    }

    private boolean a(RecyclerView.s sVar, a aVar) {
        int a2;
        if (sVar.a() || this.l == -1) {
            return false;
        }
        if (this.l < 0 || this.l >= sVar.e()) {
            this.l = -1;
            this.m = Integer.MIN_VALUE;
            return false;
        }
        aVar.b = this.l;
        if (this.n != null && this.n.a()) {
            aVar.d = this.n.c;
            if (aVar.d) {
                aVar.c = this.j.d() - this.n.b;
            } else {
                aVar.c = this.j.c() + this.n.b;
            }
            return true;
        }
        if (this.m == Integer.MIN_VALUE) {
            View c2 = c(this.l);
            if (c2 != null) {
                if (this.j.e(c2) > this.j.f()) {
                    aVar.b();
                    return true;
                }
                if (this.j.a(c2) - this.j.c() < 0) {
                    aVar.c = this.j.c();
                    aVar.d = false;
                    return true;
                }
                if (this.j.d() - this.j.b(c2) < 0) {
                    aVar.c = this.j.d();
                    aVar.d = true;
                    return true;
                }
                if (aVar.d) {
                    a2 = this.j.b(c2) + this.j.b();
                } else {
                    a2 = this.j.a(c2);
                }
                aVar.c = a2;
            } else {
                if (v() > 0) {
                    aVar.d = (this.l < d(i(0))) == this.k;
                }
                aVar.b();
            }
            return true;
        }
        aVar.d = this.k;
        if (this.k) {
            aVar.c = this.j.d() - this.m;
        } else {
            aVar.c = this.j.c() + this.m;
        }
        return true;
    }

    private int a(int i, RecyclerView.o oVar, RecyclerView.s sVar, boolean z) {
        int d;
        int d2 = this.j.d() - i;
        if (d2 <= 0) {
            return 0;
        }
        int i2 = -c(-d2, oVar, sVar);
        int i3 = i + i2;
        if (!z || (d = this.j.d() - i3) <= 0) {
            return i2;
        }
        this.j.a(d);
        return d + i2;
    }

    private int b(int i, RecyclerView.o oVar, RecyclerView.s sVar, boolean z) {
        int c2;
        int c3 = i - this.j.c();
        if (c3 <= 0) {
            return 0;
        }
        int i2 = -c(c3, oVar, sVar);
        int i3 = i + i2;
        if (!z || (c2 = i3 - this.j.c()) <= 0) {
            return i2;
        }
        this.j.a(-c2);
        return i2 - c2;
    }

    private void a(a aVar) {
        a(aVar.b, aVar.c);
    }

    private void a(int i, int i2) {
        this.a.c = this.j.d() - i2;
        this.a.e = this.k ? -1 : 1;
        this.a.d = i;
        this.a.f = 1;
        this.a.b = i2;
        this.a.g = Integer.MIN_VALUE;
    }

    private void b(a aVar) {
        g(aVar.b, aVar.c);
    }

    private void g(int i, int i2) {
        this.a.c = i2 - this.j.c();
        this.a.d = i;
        this.a.e = this.k ? 1 : -1;
        this.a.f = -1;
        this.a.b = i2;
        this.a.g = Integer.MIN_VALUE;
    }

    protected boolean h() {
        return t() == 1;
    }

    void i() {
        if (this.a == null) {
            this.a = j();
        }
    }

    c j() {
        return new c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void e(int i) {
        this.l = i;
        this.m = Integer.MIN_VALUE;
        if (this.n != null) {
            this.n.b();
        }
        o();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.i == 1) {
            return 0;
        }
        return c(i, oVar, sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.i == 0) {
            return 0;
        }
        return c(i, oVar, sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int c(RecyclerView.s sVar) {
        return i(sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int d(RecyclerView.s sVar) {
        return i(sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int e(RecyclerView.s sVar) {
        return j(sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int f(RecyclerView.s sVar) {
        return j(sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int g(RecyclerView.s sVar) {
        return k(sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int h(RecyclerView.s sVar) {
        return k(sVar);
    }

    private int i(RecyclerView.s sVar) {
        if (v() == 0) {
            return 0;
        }
        i();
        return j.a(sVar, this.j, a(!this.e, true), b(!this.e, true), this, this.e, this.k);
    }

    private int j(RecyclerView.s sVar) {
        if (v() == 0) {
            return 0;
        }
        i();
        return j.a(sVar, this.j, a(!this.e, true), b(!this.e, true), this, this.e);
    }

    private int k(RecyclerView.s sVar) {
        if (v() == 0) {
            return 0;
        }
        i();
        return j.b(sVar, this.j, a(!this.e, true), b(!this.e, true), this, this.e);
    }

    private void a(int i, int i2, boolean z, RecyclerView.s sVar) {
        int c2;
        this.a.l = k();
        this.a.h = b(sVar);
        this.a.f = i;
        if (i == 1) {
            this.a.h += this.j.g();
            View M = M();
            this.a.e = this.k ? -1 : 1;
            this.a.d = d(M) + this.a.e;
            this.a.b = this.j.b(M);
            c2 = this.j.b(M) - this.j.d();
        } else {
            View L = L();
            this.a.h += this.j.c();
            this.a.e = this.k ? 1 : -1;
            this.a.d = d(L) + this.a.e;
            this.a.b = this.j.a(L);
            c2 = (-this.j.a(L)) + this.j.c();
        }
        this.a.c = i2;
        if (z) {
            this.a.c -= c2;
        }
        this.a.g = c2;
    }

    boolean k() {
        return this.j.h() == 0 && this.j.e() == 0;
    }

    void a(RecyclerView.s sVar, c cVar, RecyclerView.i.a aVar) {
        int i = cVar.d;
        if (i < 0 || i >= sVar.e()) {
            return;
        }
        aVar.b(i, Math.max(0, cVar.g));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(int i, RecyclerView.i.a aVar) {
        boolean z;
        int i2;
        if (this.n != null && this.n.a()) {
            z = this.n.c;
            i2 = this.n.a;
        } else {
            K();
            z = this.k;
            if (this.l == -1) {
                i2 = z ? i - 1 : 0;
            } else {
                i2 = this.l;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.h && i2 >= 0 && i2 < i; i4++) {
            aVar.b(i2, 0);
            i2 += i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(int i, int i2, RecyclerView.s sVar, RecyclerView.i.a aVar) {
        if (this.i != 0) {
            i = i2;
        }
        if (v() == 0 || i == 0) {
            return;
        }
        i();
        a(i > 0 ? 1 : -1, Math.abs(i), true, sVar);
        a(sVar, this.a, aVar);
    }

    int c(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        if (v() == 0 || i == 0) {
            return 0;
        }
        this.a.a = true;
        i();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, sVar);
        int a2 = this.a.g + a(oVar, this.a, sVar, false);
        if (a2 < 0) {
            return 0;
        }
        if (abs > a2) {
            i = i2 * a2;
        }
        this.j.a(-i);
        this.a.j = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(String str) {
        if (this.n == null) {
            super.a(str);
        }
    }

    private void a(RecyclerView.o oVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                a(i, oVar);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                a(i3, oVar);
            }
        }
    }

    private void a(RecyclerView.o oVar, int i) {
        if (i < 0) {
            return;
        }
        int v = v();
        if (!this.k) {
            for (int i2 = 0; i2 < v; i2++) {
                View i3 = i(i2);
                if (this.j.b(i3) > i || this.j.c(i3) > i) {
                    a(oVar, 0, i2);
                    return;
                }
            }
            return;
        }
        int i4 = v - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View i6 = i(i5);
            if (this.j.b(i6) > i || this.j.c(i6) > i) {
                a(oVar, i4, i5);
                return;
            }
        }
    }

    private void b(RecyclerView.o oVar, int i) {
        int v = v();
        if (i < 0) {
            return;
        }
        int e = this.j.e() - i;
        if (this.k) {
            for (int i2 = 0; i2 < v; i2++) {
                View i3 = i(i2);
                if (this.j.a(i3) < e || this.j.d(i3) < e) {
                    a(oVar, 0, i2);
                    return;
                }
            }
            return;
        }
        int i4 = v - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View i6 = i(i5);
            if (this.j.a(i6) < e || this.j.d(i6) < e) {
                a(oVar, i4, i5);
                return;
            }
        }
    }

    private void a(RecyclerView.o oVar, c cVar) {
        if (!cVar.a || cVar.l) {
            return;
        }
        if (cVar.f == -1) {
            b(oVar, cVar.g);
        } else {
            a(oVar, cVar.g);
        }
    }

    int a(RecyclerView.o oVar, c cVar, RecyclerView.s sVar, boolean z) {
        int i = cVar.c;
        if (cVar.g != Integer.MIN_VALUE) {
            if (cVar.c < 0) {
                cVar.g += cVar.c;
            }
            a(oVar, cVar);
        }
        int i2 = cVar.c + cVar.h;
        b bVar = this.g;
        while (true) {
            if ((!cVar.l && i2 <= 0) || !cVar.a(sVar)) {
                break;
            }
            bVar.a();
            a(oVar, sVar, cVar, bVar);
            if (!bVar.b) {
                cVar.b += bVar.a * cVar.f;
                if (!bVar.c || this.a.k != null || !sVar.a()) {
                    cVar.c -= bVar.a;
                    i2 -= bVar.a;
                }
                if (cVar.g != Integer.MIN_VALUE) {
                    cVar.g += bVar.a;
                    if (cVar.c < 0) {
                        cVar.g += cVar.c;
                    }
                    a(oVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.c;
    }

    void a(RecyclerView.o oVar, RecyclerView.s sVar, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int f;
        View a2 = cVar.a(oVar);
        if (a2 == null) {
            bVar.b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) a2.getLayoutParams();
        if (cVar.k == null) {
            if (this.k == (cVar.f == -1)) {
                b(a2);
            } else {
                b(a2, 0);
            }
        } else {
            if (this.k == (cVar.f == -1)) {
                a(a2);
            } else {
                a(a2, 0);
            }
        }
        a(a2, 0, 0);
        bVar.a = this.j.e(a2);
        if (this.i == 1) {
            if (h()) {
                f = y() - C();
                i4 = f - this.j.f(a2);
            } else {
                i4 = A();
                f = this.j.f(a2) + i4;
            }
            if (cVar.f == -1) {
                int i5 = cVar.b;
                i2 = cVar.b - bVar.a;
                i = f;
                i3 = i5;
            } else {
                int i6 = cVar.b;
                i3 = cVar.b + bVar.a;
                i = f;
                i2 = i6;
            }
        } else {
            int B = B();
            int f2 = this.j.f(a2) + B;
            if (cVar.f == -1) {
                i2 = B;
                i = cVar.b;
                i3 = f2;
                i4 = cVar.b - bVar.a;
            } else {
                int i7 = cVar.b;
                i = cVar.b + bVar.a;
                i2 = B;
                i3 = f2;
                i4 = i7;
            }
        }
        a(a2, i4, i2, i, i3);
        if (layoutParams.d() || layoutParams.e()) {
            bVar.c = true;
        }
        bVar.d = a2.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    boolean l() {
        return (x() == 1073741824 || w() == 1073741824 || !J()) ? false : true;
    }

    int f(int i) {
        if (i == 17) {
            return this.i == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 33) {
            return this.i == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 66) {
            return this.i == 0 ? 1 : Integer.MIN_VALUE;
        }
        if (i == 130) {
            return this.i == 1 ? 1 : Integer.MIN_VALUE;
        }
        switch (i) {
            case 1:
                return (this.i != 1 && h()) ? 1 : -1;
            case 2:
                return (this.i != 1 && h()) ? -1 : 1;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private View L() {
        return i(this.k ? v() - 1 : 0);
    }

    private View M() {
        return i(this.k ? 0 : v() - 1);
    }

    private View a(boolean z, boolean z2) {
        if (this.k) {
            return a(v() - 1, -1, z, z2);
        }
        return a(0, v(), z, z2);
    }

    private View b(boolean z, boolean z2) {
        if (this.k) {
            return a(0, v(), z, z2);
        }
        return a(v() - 1, -1, z, z2);
    }

    private View f(RecyclerView.o oVar, RecyclerView.s sVar) {
        return this.k ? h(oVar, sVar) : i(oVar, sVar);
    }

    private View g(RecyclerView.o oVar, RecyclerView.s sVar) {
        return this.k ? i(oVar, sVar) : h(oVar, sVar);
    }

    private View h(RecyclerView.o oVar, RecyclerView.s sVar) {
        return a(oVar, sVar, 0, v(), sVar.e());
    }

    private View i(RecyclerView.o oVar, RecyclerView.s sVar) {
        return a(oVar, sVar, v() - 1, -1, sVar.e());
    }

    View a(RecyclerView.o oVar, RecyclerView.s sVar, int i, int i2, int i3) {
        i();
        int c2 = this.j.c();
        int d = this.j.d();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View i5 = i(i);
            int d2 = d(i5);
            if (d2 >= 0 && d2 < i3) {
                if (((RecyclerView.LayoutParams) i5.getLayoutParams()).d()) {
                    if (view2 == null) {
                        view2 = i5;
                    }
                } else {
                    if (this.j.a(i5) < d && this.j.b(i5) >= c2) {
                        return i5;
                    }
                    if (view == null) {
                        view = i5;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private View j(RecyclerView.o oVar, RecyclerView.s sVar) {
        return this.k ? l(oVar, sVar) : m(oVar, sVar);
    }

    private View k(RecyclerView.o oVar, RecyclerView.s sVar) {
        return this.k ? m(oVar, sVar) : l(oVar, sVar);
    }

    private View l(RecyclerView.o oVar, RecyclerView.s sVar) {
        return b(0, v());
    }

    private View m(RecyclerView.o oVar, RecyclerView.s sVar) {
        return b(v() - 1, -1);
    }

    public int m() {
        View a2 = a(0, v(), false, true);
        if (a2 == null) {
            return -1;
        }
        return d(a2);
    }

    public int n() {
        View a2 = a(v() - 1, -1, false, true);
        if (a2 == null) {
            return -1;
        }
        return d(a2);
    }

    View a(int i, int i2, boolean z, boolean z2) {
        i();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        if (this.i == 0) {
            return this.r.a(i, i2, i3, i4);
        }
        return this.s.a(i, i2, i3, i4);
    }

    View b(int i, int i2) {
        int i3;
        int i4;
        i();
        if ((i2 > i ? (char) 1 : i2 < i ? (char) 65535 : (char) 0) == 0) {
            return i(i);
        }
        if (this.j.a(i(i)) < this.j.c()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        if (this.i == 0) {
            return this.r.a(i, i2, i3, i4);
        }
        return this.s.a(i, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View a(View view, int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        int f;
        View j;
        View M;
        K();
        if (v() == 0 || (f = f(i)) == Integer.MIN_VALUE) {
            return null;
        }
        i();
        i();
        a(f, (int) (0.33333334f * this.j.f()), false, sVar);
        this.a.g = Integer.MIN_VALUE;
        this.a.a = false;
        a(oVar, this.a, sVar, true);
        if (f == -1) {
            j = k(oVar, sVar);
        } else {
            j = j(oVar, sVar);
        }
        if (f == -1) {
            M = L();
        } else {
            M = M();
        }
        if (!M.hasFocusable()) {
            return j;
        }
        if (j == null) {
            return null;
        }
        return M;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean b() {
        return this.n == null && this.b == this.d;
    }

    /* compiled from: source */
    static class c {
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int j;
        boolean l;
        boolean a = true;
        int h = 0;
        boolean i = false;
        List<RecyclerView.v> k = null;

        c() {
        }

        boolean a(RecyclerView.s sVar) {
            return this.d >= 0 && this.d < sVar.e();
        }

        View a(RecyclerView.o oVar) {
            if (this.k != null) {
                return b();
            }
            View c = oVar.c(this.d);
            this.d += this.e;
            return c;
        }

        private View b() {
            int size = this.k.size();
            for (int i = 0; i < size; i++) {
                View view = this.k.get(i).a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.d() && this.d == layoutParams.f()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View b = b(view);
            if (b == null) {
                this.d = -1;
            } else {
                this.d = ((RecyclerView.LayoutParams) b.getLayoutParams()).f();
            }
        }

        public View b(View view) {
            int f;
            int size = this.k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.k.get(i2).a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.d() && (f = (layoutParams.f() - this.d) * this.e) >= 0 && f < i) {
                    if (f == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i = f;
                }
            }
            return view2;
        }
    }

    /* compiled from: source */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.LinearLayoutManager.SavedState.1
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
        boolean c;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.a = savedState.a;
            this.b = savedState.b;
            this.c = savedState.c;
        }

        boolean a() {
            return this.a >= 0;
        }

        void b() {
            this.a = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }

        /* compiled from: source */
        /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$SavedState$1 */
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
    static class a {
        h a;
        int b;
        int c;
        boolean d;
        boolean e;

        a() {
            a();
        }

        void a() {
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }

        void b() {
            int c;
            if (this.d) {
                c = this.a.d();
            } else {
                c = this.a.c();
            }
            this.c = c;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
        }

        boolean a(View view, RecyclerView.s sVar) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.d() && layoutParams.f() >= 0 && layoutParams.f() < sVar.e();
        }

        public void a(View view, int i) {
            int b = this.a.b();
            if (b >= 0) {
                b(view, i);
                return;
            }
            this.b = i;
            if (this.d) {
                int d = (this.a.d() - b) - this.a.b(view);
                this.c = this.a.d() - d;
                if (d > 0) {
                    int e = this.c - this.a.e(view);
                    int c = this.a.c();
                    int min = e - (c + Math.min(this.a.a(view) - c, 0));
                    if (min < 0) {
                        this.c += Math.min(d, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int a = this.a.a(view);
            int c2 = a - this.a.c();
            this.c = a;
            if (c2 > 0) {
                int d2 = (this.a.d() - Math.min(0, (this.a.d() - b) - this.a.b(view))) - (a + this.a.e(view));
                if (d2 < 0) {
                    this.c -= Math.min(c2, -d2);
                }
            }
        }

        public void b(View view, int i) {
            if (this.d) {
                this.c = this.a.b(view) + this.a.b();
            } else {
                this.c = this.a.a(view);
            }
            this.b = i;
        }
    }

    /* compiled from: source */
    protected static class b {
        public int a;
        public boolean b;
        public boolean c;
        public boolean d;

        protected b() {
        }

        void a() {
            this.a = 0;
            this.b = false;
            this.c = false;
            this.d = false;
        }
    }
}
