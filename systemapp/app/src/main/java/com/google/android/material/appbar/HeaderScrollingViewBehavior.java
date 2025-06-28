package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.ae;
import androidx.core.h.d;
import androidx.core.h.w;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    final Rect a;
    final Rect b;
    private int c;
    private int d;

    private static int c(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    float a(View view) {
        return 1.0f;
    }

    abstract View b(List<View> list);

    public HeaderScrollingViewBehavior() {
        this.a = new Rect();
        this.b = new Rect();
        this.c = 0;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Rect();
        this.b = new Rect();
        this.c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View b;
        View view2;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (b = b(coordinatorLayout.c(view))) == null) {
            return false;
        }
        if (!w.u(b) || w.u(view)) {
            view2 = view;
        } else {
            view2 = view;
            w.b(view2, true);
            if (w.u(view2)) {
                view2.requestLayout();
                return true;
            }
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.a(view2, i, i2, View.MeasureSpec.makeMeasureSpec((size - b.getMeasuredHeight()) + b(b), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    protected void b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View b = b(coordinatorLayout.c(view));
        if (b != null) {
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) view.getLayoutParams();
            Rect rect = this.a;
            rect.set(coordinatorLayout.getPaddingLeft() + dVar.leftMargin, b.getBottom() + dVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - dVar.rightMargin, ((coordinatorLayout.getHeight() + b.getBottom()) - coordinatorLayout.getPaddingBottom()) - dVar.bottomMargin);
            ae lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && w.u(coordinatorLayout) && !w.u(view)) {
                rect.left += lastWindowInsets.a();
                rect.right -= lastWindowInsets.c();
            }
            Rect rect2 = this.b;
            d.a(c(dVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int c = c(b);
            view.layout(rect2.left, rect2.top - c, rect2.right, rect2.bottom - c);
            this.c = rect2.top - b.getBottom();
            return;
        }
        super.b(coordinatorLayout, (CoordinatorLayout) view, i);
        this.c = 0;
    }

    final int c(View view) {
        if (this.d == 0) {
            return 0;
        }
        return androidx.core.b.a.a((int) (a(view) * this.d), 0, this.d);
    }

    int b(View view) {
        return view.getMeasuredHeight();
    }

    final int b() {
        return this.c;
    }

    public final void b(int i) {
        this.d = i;
    }

    public final int d() {
        return this.d;
    }
}
