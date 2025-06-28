package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;

/* compiled from: source */
/* loaded from: classes.dex */
public class CircularRevealCardView extends CardView implements c {
    private final b e;

    public CircularRevealCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new b(this);
    }

    @Override // com.google.android.material.circularreveal.c
    public void a() {
        this.e.a();
    }

    @Override // com.google.android.material.circularreveal.c
    public void s_() {
        this.e.b();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setRevealInfo(c.d dVar) {
        this.e.a(dVar);
    }

    @Override // com.google.android.material.circularreveal.c
    public c.d getRevealInfo() {
        return this.e.c();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealScrimColor(int i) {
        this.e.a(i);
    }

    @Override // com.google.android.material.circularreveal.c
    public int getCircularRevealScrimColor() {
        return this.e.d();
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.e.e();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.e.a(drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.e != null) {
            this.e.a(canvas);
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
        if (this.e != null) {
            return this.e.f();
        }
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.b.a
    public boolean c() {
        return super.isOpaque();
    }
}
