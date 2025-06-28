package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.LinearLayoutCompat;

/* compiled from: source */
/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements g.b, androidx.appcompat.view.menu.n {
    g.a a;
    d b;
    private androidx.appcompat.view.menu.g c;
    private Context d;
    private int e;
    private boolean f;
    private ActionMenuPresenter g;
    private m.a h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    /* compiled from: source */
    public interface a {
        boolean c();

        boolean d();
    }

    /* compiled from: source */
    public interface d {
        boolean a(MenuItem menuItem);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.k = (int) (56.0f * f);
        this.l = (int) (4.0f * f);
        this.d = context;
        this.e = 0;
    }

    public void setPopupTheme(int i) {
        if (this.e != i) {
            this.e = i;
            if (i == 0) {
                this.d = getContext();
            } else {
                this.d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.e;
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.g = actionMenuPresenter;
        this.g.a(this);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.g != null) {
            this.g.a(false);
            if (this.g.j()) {
                this.g.g();
                this.g.e();
            }
        }
    }

    public void setOnMenuItemClickListener(d dVar) {
        this.b = dVar;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z = this.i;
        this.i = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.i) {
            this.j = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.i && this.c != null && size != this.j) {
            this.j = size;
            this.c.b(true);
        }
        int childCount = getChildCount();
        if (this.i && childCount > 0) {
            c(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x024a A[ADDED_TO_REGION, LOOP:5: B:148:0x024a->B:153:0x026c, LOOP_START, PHI: r5 r32
      0x024a: PHI (r5v7 int) = (r5v6 int), (r5v8 int) binds: [B:147:0x0248, B:153:0x026c] A[DONT_GENERATE, DONT_INLINE]
      0x024a: PHI (r32v1 int) = (r32v0 int), (r32v2 int) binds: [B:147:0x0248, B:153:0x026c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0278  */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(int r35, int r36) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.c(int, int):void");
    }

    static int a(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = false;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.b();
        int i5 = 2;
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z2 || i6 >= 2) {
                i5 = i6;
            }
        }
        if (!layoutParams.a && z2) {
            z = true;
        }
        layoutParams.d = z;
        layoutParams.b = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int width;
        int i7;
        if (!this.i) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i8 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i9 = i3 - i;
        int paddingRight = (i9 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = al.a(this);
        int i10 = paddingRight;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (a(i13)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i7 = getPaddingLeft() + layoutParams.leftMargin;
                        width = i7 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i7 = width - measuredWidth;
                    }
                    int i14 = i8 - (measuredHeight / 2);
                    childAt.layout(i7, i14, width, measuredHeight + i14);
                    i10 -= measuredWidth;
                    i11 = 1;
                } else {
                    i10 -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    a(i13);
                    i12++;
                }
            }
        }
        if (childCount == 1 && i11 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i15 = (i9 / 2) - (measuredWidth2 / 2);
            int i16 = i8 - (measuredHeight2 / 2);
            childAt2.layout(i15, i16, measuredWidth2 + i15, measuredHeight2 + i16);
            return;
        }
        int i17 = i12 - (i11 ^ 1);
        if (i17 > 0) {
            i6 = i10 / i17;
            i5 = 0;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int max = Math.max(i5, i6);
        if (a2) {
            int width2 = getWidth() - getPaddingRight();
            while (i5 < childCount) {
                View childAt3 = getChildAt(i5);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.a) {
                    int i18 = width2 - layoutParams2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i19 = i8 - (measuredHeight3 / 2);
                    childAt3.layout(i18 - measuredWidth3, i19, i18, measuredHeight3 + i19);
                    width2 = i18 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                }
                i5++;
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        while (i5 < childCount) {
            View childAt4 = getChildAt(i5);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.a) {
                int i20 = paddingLeft + layoutParams3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i8 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft = i20 + measuredWidth4 + layoutParams3.rightMargin + max;
            }
            i5++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.g.a(drawable);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.g.d();
    }

    public boolean a() {
        return this.f;
    }

    public void setOverflowReserved(boolean z) {
        this.f = z;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: b */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.h = 16;
        return layoutParams;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams != null) {
            if (layoutParams instanceof LayoutParams) {
                layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
            } else {
                layoutParams2 = new LayoutParams(layoutParams);
            }
            if (layoutParams2.h <= 0) {
                layoutParams2.h = 16;
            }
            return layoutParams2;
        }
        return generateDefaultLayoutParams();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public LayoutParams c() {
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.a = true;
        return generateDefaultLayoutParams;
    }

    @Override // androidx.appcompat.view.menu.g.b
    public boolean a(androidx.appcompat.view.menu.i iVar) {
        return this.c.a(iVar, 0);
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(androidx.appcompat.view.menu.g gVar) {
        this.c = gVar;
    }

    public Menu getMenu() {
        if (this.c == null) {
            Context context = getContext();
            this.c = new androidx.appcompat.view.menu.g(context);
            this.c.a(new c());
            this.g = new ActionMenuPresenter(context);
            this.g.b(true);
            this.g.a(this.h != null ? this.h : new b());
            this.c.a(this.g, this.d);
            this.g.a(this);
        }
        return this.c;
    }

    public void a(m.a aVar, g.a aVar2) {
        this.h = aVar;
        this.a = aVar2;
    }

    public androidx.appcompat.view.menu.g d() {
        return this.c;
    }

    public boolean e() {
        return this.g != null && this.g.e();
    }

    public boolean f() {
        return this.g != null && this.g.g();
    }

    public boolean g() {
        return this.g != null && this.g.j();
    }

    public boolean h() {
        return this.g != null && this.g.k();
    }

    public void i() {
        if (this.g != null) {
            this.g.h();
        }
    }

    protected boolean a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z = false | ((a) childAt).d();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? z : z | ((a) childAt2).c();
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.g.c(z);
    }

    /* compiled from: source */
    private class c implements g.a {
        c() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            return ActionMenuView.this.b != null && ActionMenuView.this.b.a(menuItem);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void a(androidx.appcompat.view.menu.g gVar) {
            if (ActionMenuView.this.a != null) {
                ActionMenuView.this.a.a(gVar);
            }
        }
    }

    /* compiled from: source */
    private static class b implements m.a {
        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            return false;
        }

        b() {
        }
    }

    /* compiled from: source */
    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        @ViewDebug.ExportedProperty
        public boolean a;

        @ViewDebug.ExportedProperty
        public int b;

        @ViewDebug.ExportedProperty
        public int c;

        @ViewDebug.ExportedProperty
        public boolean d;

        @ViewDebug.ExportedProperty
        public boolean e;
        boolean f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.a = layoutParams.a;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = false;
        }
    }
}
