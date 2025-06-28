package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: source */
/* loaded from: classes.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private a a;
    private int b;
    private int c;

    public ViewOffsetBehavior() {
        this.b = 0;
        this.c = 0;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        b(coordinatorLayout, (CoordinatorLayout) v, i);
        if (this.a == null) {
            this.a = new a(v);
        }
        this.a.a();
        if (this.b != 0) {
            this.a.a(this.b);
            this.b = 0;
        }
        if (this.c == 0) {
            return true;
        }
        this.a.b(this.c);
        this.c = 0;
        return true;
    }

    protected void b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.b(v, i);
    }

    public boolean a(int i) {
        if (this.a != null) {
            return this.a.a(i);
        }
        this.b = i;
        return false;
    }

    public int c() {
        if (this.a != null) {
            return this.a.b();
        }
        return 0;
    }
}
