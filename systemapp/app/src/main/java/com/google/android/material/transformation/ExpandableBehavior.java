package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.w;
import com.google.android.material.d.b;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    private int a;

    protected abstract boolean a(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean a(CoordinatorLayout coordinatorLayout, View view, View view2);

    public ExpandableBehavior() {
        this.a = 0;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
        b e;
        if (w.C(view) || (e = e(coordinatorLayout, view)) == null || !a(e.a())) {
            return false;
        }
        this.a = e.a() ? 1 : 2;
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.transformation.ExpandableBehavior.1
            final /* synthetic */ View a;
            final /* synthetic */ int b;
            final /* synthetic */ b c;

            AnonymousClass1(View view2, int i2, b e2) {
                view = view2;
                i2 = i2;
                e = e2;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                if (ExpandableBehavior.this.a == i2) {
                    ExpandableBehavior.this.a((View) e, view, e.a(), false);
                }
                return false;
            }
        });
        return false;
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.transformation.ExpandableBehavior$1 */
    class AnonymousClass1 implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View a;
        final /* synthetic */ int b;
        final /* synthetic */ b c;

        AnonymousClass1(View view2, int i2, b e2) {
            view = view2;
            i2 = i2;
            e = e2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.a == i2) {
                ExpandableBehavior.this.a((View) e, view, e.a(), false);
            }
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b bVar = (b) view2;
        if (!a(bVar.a())) {
            return false;
        }
        this.a = bVar.a() ? 1 : 2;
        return a((View) bVar, view, bVar.a(), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected b e(CoordinatorLayout coordinatorLayout, View view) {
        List<View> c = coordinatorLayout.c(view);
        int size = c.size();
        for (int i = 0; i < size; i++) {
            View view2 = c.get(i);
            if (a(coordinatorLayout, view, view2)) {
                return (b) view2;
            }
        }
        return null;
    }

    private boolean a(boolean z) {
        return z ? this.a == 0 || this.a == 2 : this.a == 1;
    }
}
