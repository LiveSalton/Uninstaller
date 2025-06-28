package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.h.ae;
import androidx.core.h.r;
import androidx.core.h.w;
import com.google.android.material.a;

/* compiled from: source */
/* loaded from: classes.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {
    Drawable a;
    Rect b;
    private Rect c;

    protected void a(ae aeVar) {
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new Rect();
        TypedArray a = k.a(context, attributeSet, a.k.ScrimInsetsFrameLayout, i, a.j.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.a = a.getDrawable(a.k.ScrimInsetsFrameLayout_insetForeground);
        a.recycle();
        setWillNotDraw(true);
        w.a(this, new r() { // from class: com.google.android.material.internal.ScrimInsetsFrameLayout.1
            AnonymousClass1() {
            }

            @Override // androidx.core.h.r
            public ae a(View view, ae aeVar) {
                if (ScrimInsetsFrameLayout.this.b == null) {
                    ScrimInsetsFrameLayout.this.b = new Rect();
                }
                ScrimInsetsFrameLayout.this.b.set(aeVar.a(), aeVar.b(), aeVar.c(), aeVar.d());
                ScrimInsetsFrameLayout.this.a(aeVar);
                ScrimInsetsFrameLayout.this.setWillNotDraw(!aeVar.e() || ScrimInsetsFrameLayout.this.a == null);
                w.f(ScrimInsetsFrameLayout.this);
                return aeVar.g();
            }
        });
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.internal.ScrimInsetsFrameLayout$1 */
    class AnonymousClass1 implements r {
        AnonymousClass1() {
        }

        @Override // androidx.core.h.r
        public ae a(View view, ae aeVar) {
            if (ScrimInsetsFrameLayout.this.b == null) {
                ScrimInsetsFrameLayout.this.b = new Rect();
            }
            ScrimInsetsFrameLayout.this.b.set(aeVar.a(), aeVar.b(), aeVar.c(), aeVar.d());
            ScrimInsetsFrameLayout.this.a(aeVar);
            ScrimInsetsFrameLayout.this.setWillNotDraw(!aeVar.e() || ScrimInsetsFrameLayout.this.a == null);
            w.f(ScrimInsetsFrameLayout.this);
            return aeVar.g();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.b == null || this.a == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        this.c.set(0, 0, width, this.b.top);
        this.a.setBounds(this.c);
        this.a.draw(canvas);
        this.c.set(0, height - this.b.bottom, width, height);
        this.a.setBounds(this.c);
        this.a.draw(canvas);
        this.c.set(0, this.b.top, this.b.left, height - this.b.bottom);
        this.a.setBounds(this.c);
        this.a.draw(canvas);
        this.c.set(width - this.b.right, this.b.top, width, height - this.b.bottom);
        this.a.setBounds(this.c);
        this.a.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            this.a.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            this.a.setCallback(null);
        }
    }
}
