package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.a.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: source */
/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    boolean a;
    int b;
    int[] c;
    View[] d;
    final SparseIntArray e;
    final SparseIntArray f;
    b g;
    final Rect h;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = false;
        this.b = -1;
        this.e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        a(a(context, attributeSet, i, i2).b);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.a(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.i == 0) {
            return this.b;
        }
        if (sVar.e() < 1) {
            return 0;
        }
        return a(oVar, sVar, sVar.e() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.i == 1) {
            return this.b;
        }
        if (sVar.e() < 1) {
            return 0;
        }
        return a(oVar, sVar, sVar.e() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.o oVar, RecyclerView.s sVar, View view, androidx.core.h.a.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.a(view, dVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int a2 = a(oVar, sVar, layoutParams2.f());
        if (this.i == 0) {
            dVar.b(d.c.a(layoutParams2.a(), layoutParams2.b(), a2, 1, this.b > 1 && layoutParams2.b() == this.b, false));
        } else {
            dVar.b(d.c.a(a2, 1, layoutParams2.a(), layoutParams2.b(), this.b > 1 && layoutParams2.b() == this.b, false));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public void c(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (sVar.a()) {
            L();
        }
        super.c(oVar, sVar);
        K();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.s sVar) {
        super.a(sVar);
        this.a = false;
    }

    private void K() {
        this.e.clear();
        this.f.clear();
    }

    private void L() {
        int v = v();
        for (int i = 0; i < v; i++) {
            LayoutParams layoutParams = (LayoutParams) i(i).getLayoutParams();
            int f = layoutParams.f();
            this.e.put(f, layoutParams.b());
            this.f.put(f, layoutParams.a());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2) {
        this.g.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView) {
        this.g.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void b(RecyclerView recyclerView, int i, int i2) {
        this.g.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.g.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.g.a();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams a() {
        if (this.i == 0) {
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

    private void M() {
        int z;
        if (g() == 1) {
            z = (y() - C()) - A();
        } else {
            z = (z() - D()) - B();
        }
        m(z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Rect rect, int i, int i2) {
        int a2;
        int a3;
        if (this.c == null) {
            super.a(rect, i, i2);
        }
        int A = A() + C();
        int B = B() + D();
        if (this.i == 1) {
            a3 = a(i2, rect.height() + B, G());
            a2 = a(i, this.c[this.c.length - 1] + A, F());
        } else {
            a2 = a(i, rect.width() + A, F());
            a3 = a(i2, this.c[this.c.length - 1] + B, G());
        }
        f(a2, a3);
    }

    private void m(int i) {
        this.c = a(this.c, this.b, i);
    }

    static int[] a(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    int a(int i, int i2) {
        if (this.i == 1 && h()) {
            return this.c[this.b - i] - this.c[(this.b - i) - i2];
        }
        return this.c[i2 + i] - this.c[i];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void a(RecyclerView.o oVar, RecyclerView.s sVar, LinearLayoutManager.a aVar, int i) {
        super.a(oVar, sVar, aVar, i);
        M();
        if (sVar.e() > 0 && !sVar.a()) {
            b(oVar, sVar, aVar, i);
        }
        N();
    }

    private void N() {
        if (this.d == null || this.d.length != this.b) {
            this.d = new View[this.b];
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int a(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        M();
        N();
        return super.a(i, oVar, sVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int b(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        M();
        N();
        return super.b(i, oVar, sVar);
    }

    private void b(RecyclerView.o oVar, RecyclerView.s sVar, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int b2 = b(oVar, sVar, aVar.b);
        if (z) {
            while (b2 > 0 && aVar.b > 0) {
                aVar.b--;
                b2 = b(oVar, sVar, aVar.b);
            }
            return;
        }
        int e = sVar.e() - 1;
        int i2 = aVar.b;
        while (i2 < e) {
            int i3 = i2 + 1;
            int b3 = b(oVar, sVar, i3);
            if (b3 <= b2) {
                break;
            }
            i2 = i3;
            b2 = b3;
        }
        aVar.b = i2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View a(RecyclerView.o oVar, RecyclerView.s sVar, int i, int i2, int i3) {
        i();
        int c = this.j.c();
        int d = this.j.d();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View i5 = i(i);
            int d2 = d(i5);
            if (d2 >= 0 && d2 < i3 && b(oVar, sVar, d2) == 0) {
                if (((RecyclerView.LayoutParams) i5.getLayoutParams()).d()) {
                    if (view2 == null) {
                        view2 = i5;
                    }
                } else {
                    if (this.j.a(i5) < d && this.j.b(i5) >= c) {
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

    private int a(RecyclerView.o oVar, RecyclerView.s sVar, int i) {
        if (!sVar.a()) {
            return this.g.c(i, this.b);
        }
        int b2 = oVar.b(i);
        if (b2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
            return 0;
        }
        return this.g.c(b2, this.b);
    }

    private int b(RecyclerView.o oVar, RecyclerView.s sVar, int i) {
        if (!sVar.a()) {
            return this.g.b(i, this.b);
        }
        int i2 = this.f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b2 = oVar.b(i);
        if (b2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 0;
        }
        return this.g.b(b2, this.b);
    }

    private int c(RecyclerView.o oVar, RecyclerView.s sVar, int i) {
        if (!sVar.a()) {
            return this.g.a(i);
        }
        int i2 = this.e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b2 = oVar.b(i);
        if (b2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 1;
        }
        return this.g.a(b2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void a(RecyclerView.s sVar, LinearLayoutManager.c cVar, RecyclerView.i.a aVar) {
        int i = this.b;
        for (int i2 = 0; i2 < this.b && cVar.a(sVar) && i > 0; i2++) {
            int i3 = cVar.d;
            aVar.b(i3, Math.max(0, cVar.g));
            i -= this.g.a(i3);
            cVar.d += cVar.e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a1, code lost:
    
        r22.b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a3, code lost:
    
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(androidx.recyclerview.widget.RecyclerView.o r19, androidx.recyclerview.widget.RecyclerView.s r20, androidx.recyclerview.widget.LinearLayoutManager.c r21, androidx.recyclerview.widget.LinearLayoutManager.b r22) {
        /*
            Method dump skipped, instructions count: 567
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.a(androidx.recyclerview.widget.RecyclerView$o, androidx.recyclerview.widget.RecyclerView$s, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    private void a(View view, int i, boolean z) {
        int i2;
        int i3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.d;
        int i4 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i5 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int a2 = a(layoutParams.a, layoutParams.b);
        if (this.i == 1) {
            i3 = a(a2, i, i5, layoutParams.width, false);
            i2 = a(this.j.f(), x(), i4, layoutParams.height, true);
        } else {
            int a3 = a(a2, i, i4, layoutParams.height, false);
            int a4 = a(this.j.f(), w(), i5, layoutParams.width, true);
            i2 = a3;
            i3 = a4;
        }
        a(view, i3, i2, z);
    }

    private void a(float f, int i) {
        m(Math.max(Math.round(f * this.b), i));
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean b2;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            b2 = a(view, i, i2, layoutParams);
        } else {
            b2 = b(view, i, i2, layoutParams);
        }
        if (b2) {
            view.measure(i, i2);
        }
    }

    private void a(RecyclerView.o oVar, RecyclerView.s sVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = -1;
        int i6 = 0;
        if (z) {
            i4 = 1;
            i5 = i;
            i3 = 0;
        } else {
            i3 = i - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            View view = this.d[i3];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.b = c(oVar, sVar, d(view));
            layoutParams.a = i6;
            i6 += layoutParams.b;
            i3 += i4;
        }
    }

    public void a(int i) {
        if (i == this.b) {
            return;
        }
        this.a = true;
        if (i < 1) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
        this.b = i;
        this.g.a();
        o();
    }

    /* compiled from: source */
    public static abstract class b {
        final SparseIntArray a = new SparseIntArray();
        private boolean b = false;

        public abstract int a(int i);

        public void a() {
            this.a.clear();
        }

        int b(int i, int i2) {
            if (!this.b) {
                return a(i, i2);
            }
            int i3 = this.a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int a = a(i, i2);
            this.a.put(i, a);
            return a;
        }

        public int a(int i, int i2) {
            int i3;
            int i4;
            int b;
            int a = a(i);
            if (a == i2) {
                return 0;
            }
            if (!this.b || this.a.size() <= 0 || (b = b(i)) < 0) {
                i3 = 0;
                i4 = 0;
            } else {
                i4 = this.a.get(b) + a(b);
                i3 = b + 1;
            }
            while (i3 < i) {
                int a2 = a(i3);
                i4 += a2;
                if (i4 == i2) {
                    i4 = 0;
                } else if (i4 > i2) {
                    i4 = a2;
                }
                i3++;
            }
            if (a + i4 <= i2) {
                return i4;
            }
            return 0;
        }

        int b(int i) {
            int size = this.a.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.a.size()) {
                return -1;
            }
            return this.a.keyAt(i4);
        }

        public int c(int i, int i2) {
            int a = a(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int a2 = a(i5);
                i3 += a2;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = a2;
                }
            }
            return i3 + a > i2 ? i4 + 1 : i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d8, code lost:
    
        if (r13 == (r2 > r8)) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00f5, code lost:
    
        if (r13 == (r2 > r11)) goto L146;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0104  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View a(android.view.View r27, int r28, androidx.recyclerview.widget.RecyclerView.o r29, androidx.recyclerview.widget.RecyclerView.s r30) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.a(android.view.View, int, androidx.recyclerview.widget.RecyclerView$o, androidx.recyclerview.widget.RecyclerView$s):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public boolean b() {
        return this.n == null && !this.a;
    }

    /* compiled from: source */
    public static final class a extends b {
        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int a(int i) {
            return 1;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int a(int i, int i2) {
            return i % i2;
        }
    }

    /* compiled from: source */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        int a;
        int b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = -1;
            this.b = 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = -1;
            this.b = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = -1;
            this.b = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = -1;
            this.b = 0;
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }
    }
}
