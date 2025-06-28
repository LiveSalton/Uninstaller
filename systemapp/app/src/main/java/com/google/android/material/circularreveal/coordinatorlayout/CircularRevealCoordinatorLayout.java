package com.google.android.material.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;

/* compiled from: source */
/* loaded from: classes.dex */
public class CircularRevealCoordinatorLayout extends CoordinatorLayout implements c {
    private final b f;

    public CircularRevealCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new b(this);
    }

    @Override // com.google.android.material.circularreveal.c
    public void a() {
        this.f.a();
    }

    @Override // com.google.android.material.circularreveal.c
    public void s_() {
        this.f.b();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setRevealInfo(c.d dVar) {
        this.f.a(dVar);
    }

    @Override // com.google.android.material.circularreveal.c
    public c.d getRevealInfo() {
        return this.f.c();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealScrimColor(int i) {
        this.f.a(i);
    }

    @Override // com.google.android.material.circularreveal.c
    public int getCircularRevealScrimColor() {
        return this.f.d();
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f.e();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f.a(drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f != null) {
            this.f.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // com.google.android.material.circularreveal.b.a
    public void a(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.view.View
    public boolean isOpaque() {
        if (this.f != null) {
            return this.f.f();
        }
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.b.a
    public boolean c() {
        return super.isOpaque();
    }
}
