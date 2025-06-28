package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.a;

/* compiled from: source */
/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    int a(View view) {
        return 0;
    }

    int a(View view, int i) {
        return 0;
    }

    int b(View view) {
        return 0;
    }

    int d(int i) {
        return 0;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        this.b = -1;
        this.c = 0;
        this.e = 8388659;
        af a = af.a(context, attributeSet, a.j.LinearLayoutCompat, i, 0);
        androidx.core.h.w.a(this, context, a.j.LinearLayoutCompat, attributeSet, a.a(), i, 0);
        int a2 = a.a(a.j.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        int a3 = a.a(a.j.LinearLayoutCompat_android_gravity, -1);
        if (a3 >= 0) {
            setGravity(a3);
        }
        boolean a4 = a.a(a.j.LinearLayoutCompat_android_baselineAligned, true);
        if (!a4) {
            setBaselineAligned(a4);
        }
        this.g = a.a(a.j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.b = a.a(a.j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.h = a.a(a.j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.a(a.j.LinearLayoutCompat_divider));
        this.n = a.a(a.j.LinearLayoutCompat_showDividers, 0);
        this.o = a.e(a.j.LinearLayoutCompat_dividerPadding, 0);
        a.b();
    }

    public void setShowDividers(int i) {
        if (i != this.n) {
            requestLayout();
        }
        this.n = i;
    }

    public int getShowDividers() {
        return this.n;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.k) {
            return;
        }
        this.k = drawable;
        if (drawable != null) {
            this.l = drawable.getIntrinsicWidth();
            this.m = drawable.getIntrinsicHeight();
        } else {
            this.l = 0;
            this.m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.o = i;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.k == null) {
            return;
        }
        if (this.d == 1) {
            a(canvas);
        } else {
            b(canvas);
        }
    }

    void a(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View b = b(i);
            if (b != null && b.getVisibility() != 8 && c(i)) {
                a(canvas, (b.getTop() - ((LayoutParams) b.getLayoutParams()).topMargin) - this.m);
            }
        }
        if (c(virtualChildCount)) {
            View b2 = b(virtualChildCount - 1);
            if (b2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.m;
            } else {
                bottom = b2.getBottom() + ((LayoutParams) b2.getLayoutParams()).bottomMargin;
            }
            a(canvas, bottom);
        }
    }

    void b(Canvas canvas) {
        int right;
        int left;
        int virtualChildCount = getVirtualChildCount();
        boolean a = al.a(this);
        for (int i = 0; i < virtualChildCount; i++) {
            View b = b(i);
            if (b != null && b.getVisibility() != 8 && c(i)) {
                LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
                if (a) {
                    left = b.getRight() + layoutParams.rightMargin;
                } else {
                    left = (b.getLeft() - layoutParams.leftMargin) - this.l;
                }
                b(canvas, left);
            }
        }
        if (c(virtualChildCount)) {
            View b2 = b(virtualChildCount - 1);
            if (b2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) b2.getLayoutParams();
                if (a) {
                    right = (b2.getLeft() - layoutParams2.leftMargin) - this.l;
                } else {
                    right = b2.getRight() + layoutParams2.rightMargin;
                }
            } else if (a) {
                right = getPaddingLeft();
            } else {
                right = (getWidth() - getPaddingRight()) - this.l;
            }
            b(canvas, right);
        }
    }

    void a(Canvas canvas, int i) {
        this.k.setBounds(getPaddingLeft() + this.o, i, (getWidth() - getPaddingRight()) - this.o, this.m + i);
        this.k.draw(canvas);
    }

    void b(Canvas canvas, int i) {
        this.k.setBounds(i, getPaddingTop() + this.o, this.l + i, (getHeight() - getPaddingBottom()) - this.o);
        this.k.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.a = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.h = z;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.b);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int i2 = this.c;
        if (this.d == 1 && (i = this.e & 112) != 48) {
            if (i == 16) {
                i2 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f) / 2;
            } else if (i == 80) {
                i2 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f;
            }
        }
        return i2 + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.b = i;
    }

    View b(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    public void setWeightSum(float f) {
        this.g = Math.max(0.0f, f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.d == 1) {
            a(i, i2);
        } else {
            b(i, i2);
        }
    }

    protected boolean c(int i) {
        if (i == 0) {
            return (this.n & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.n & 4) != 0;
        }
        if ((this.n & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x0334  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(int r41, int r42) {
        /*
            Method dump skipped, instructions count: 929
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.a(int, int):void");
    }

    private void c(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = b(i3);
            if (b.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void b(int r42, int r43) {
        /*
            Method dump skipped, instructions count: 1281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.b(int, int):void");
    }

    private void d(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = b(i3);
            if (b.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    void a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.d == 1) {
            a(i, i2, i3, i4);
        } else {
            b(i, i2, i3, i4);
        }
    }

    void a(int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int i6;
        int paddingLeft = getPaddingLeft();
        int i7 = i3 - i;
        int paddingRight = i7 - getPaddingRight();
        int paddingRight2 = (i7 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i8 = this.e & 112;
        int i9 = this.e & 8388615;
        if (i8 == 16) {
            paddingTop = (((i4 - i2) - this.f) / 2) + getPaddingTop();
        } else if (i8 == 80) {
            paddingTop = ((getPaddingTop() + i4) - i2) - this.f;
        } else {
            paddingTop = getPaddingTop();
        }
        int i10 = 0;
        while (i10 < virtualChildCount) {
            View b = b(i10);
            if (b == null) {
                paddingTop += d(i10);
            } else if (b.getVisibility() != 8) {
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
                int i11 = layoutParams.h;
                if (i11 < 0) {
                    i11 = i9;
                }
                int a = androidx.core.h.d.a(i11, androidx.core.h.w.h(this)) & 7;
                if (a == 1) {
                    i5 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                } else if (a == 5) {
                    i5 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                } else {
                    i5 = layoutParams.leftMargin + paddingLeft;
                }
                int i12 = i5;
                if (c(i10)) {
                    paddingTop += this.m;
                }
                int i13 = paddingTop + layoutParams.topMargin;
                a(b, i12, i13 + a(b), measuredWidth, measuredHeight);
                int b2 = i13 + measuredHeight + layoutParams.bottomMargin + b(b);
                i10 += a(b, i10);
                paddingTop = b2;
                i6 = 1;
                i10 += i6;
            }
            i6 = 1;
            i10 += i6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void b(int r28, int r29, int r30, int r31) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.b(int, int, int, int):void");
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    public void setOrientation(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.d;
    }

    public void setGravity(int i) {
        if (this.e != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.e = i;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.e;
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((8388615 & this.e) != i2) {
            this.e = i2 | (this.e & (-8388616));
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.e & 112) != i2) {
            this.e = i2 | (this.e & (-113));
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: j */
    public LayoutParams generateDefaultLayoutParams() {
        if (this.d == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.d == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* compiled from: source */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public float g;
        public int h;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.LinearLayoutCompat_Layout);
            this.g = obtainStyledAttributes.getFloat(a.j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.h = obtainStyledAttributes.getInt(a.j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.h = -1;
            this.g = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.h = -1;
        }
    }
}
