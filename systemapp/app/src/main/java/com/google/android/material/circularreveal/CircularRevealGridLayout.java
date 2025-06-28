package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;
import com.google.android.material.circularreveal.c;

/* compiled from: source */
/* loaded from: classes.dex */
public class CircularRevealGridLayout extends GridLayout implements c {
    private final b a;

    public CircularRevealGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new b(this);
    }

    @Override // com.google.android.material.circularreveal.c
    public void a() {
        this.a.a();
    }

    @Override // com.google.android.material.circularreveal.c
    public void s_() {
        this.a.b();
    }

    @Override // com.google.android.material.circularreveal.c
    public c.d getRevealInfo() {
        return this.a.c();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setRevealInfo(c.d dVar) {
        this.a.a(dVar);
    }

    @Override // com.google.android.material.circularreveal.c
    public int getCircularRevealScrimColor() {
        return this.a.d();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealScrimColor(int i) {
        this.a.a(i);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.a.e();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.a.a(drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.a(canvas);
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
        if (this.a != null) {
            return this.a.f();
        }
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.b.a
    public boolean c() {
        return super.isOpaque();
    }
}
