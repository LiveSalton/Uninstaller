package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class a extends ViewGroup {
    protected final C0008a a;
    protected final Context b;
    protected ActionMenuView c;
    protected ActionMenuPresenter d;
    protected int e;
    protected androidx.core.h.aa f;
    private boolean g;
    private boolean h;

    protected static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    a(Context context) {
        this(context, null);
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new C0008a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(a.C0001a.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.b = context;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, a.j.ActionBar, a.C0001a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(a.j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.d != null) {
            this.d.a(configuration);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.g = false;
        }
        if (!this.g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.g = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.h = false;
        }
        if (!this.h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.e = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.e;
    }

    public int getAnimatedVisibility() {
        if (this.f != null) {
            return this.a.a;
        }
        return getVisibility();
    }

    public androidx.core.h.aa a(int i, long j) {
        if (this.f != null) {
            this.f.b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            androidx.core.h.aa a = androidx.core.h.w.o(this).a(1.0f);
            a.a(j);
            a.a(this.a.a(a, i));
            return a;
        }
        androidx.core.h.aa a2 = androidx.core.h.w.o(this).a(0.0f);
        a2.a(j);
        a2.a(this.a.a(a2, i));
        return a2;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f != null) {
                this.f.b();
            }
            super.setVisibility(i);
        }
    }

    public boolean a() {
        if (this.d != null) {
            return this.d.e();
        }
        return false;
    }

    protected int a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.a$a */
    protected class C0008a implements androidx.core.h.ab {
        int a;
        private boolean c = false;

        protected C0008a() {
        }

        public C0008a a(androidx.core.h.aa aaVar, int i) {
            a.this.f = aaVar;
            this.a = i;
            return this;
        }

        @Override // androidx.core.h.ab
        public void a(View view) {
            a.super.setVisibility(0);
            this.c = false;
        }

        @Override // androidx.core.h.ab
        public void b(View view) {
            if (this.c) {
                return;
            }
            a.this.f = null;
            a.super.setVisibility(this.a);
        }

        @Override // androidx.core.h.ab
        public void c(View view) {
            this.c = true;
        }
    }
}
