package com.google.android.material.card;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.google.android.material.a;

/* compiled from: source */
/* loaded from: classes.dex */
class a {
    private final MaterialCardView a;
    private int b;
    private int c;

    public a(MaterialCardView materialCardView) {
        this.a = materialCardView;
    }

    public void a(TypedArray typedArray) {
        this.b = typedArray.getColor(a.k.MaterialCardView_strokeColor, -1);
        this.c = typedArray.getDimensionPixelSize(a.k.MaterialCardView_strokeWidth, 0);
        c();
        e();
    }

    void a(int i) {
        this.b = i;
        c();
    }

    int a() {
        return this.b;
    }

    void b(int i) {
        this.c = i;
        c();
        e();
    }

    int b() {
        return this.c;
    }

    void c() {
        this.a.setForeground(d());
    }

    private Drawable d() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.a.getRadius());
        if (this.b != -1) {
            gradientDrawable.setStroke(this.c, this.b);
        }
        return gradientDrawable;
    }

    private void e() {
        this.a.a(this.a.getContentPaddingLeft() + this.c, this.a.getContentPaddingTop() + this.c, this.a.getContentPaddingRight() + this.c, this.a.getContentPaddingBottom() + this.c);
    }
}
