package com.google.android.material.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import com.google.android.material.a;
import com.google.android.material.internal.k;

/* compiled from: source */
/* loaded from: classes.dex */
public class MaterialCardView extends CardView {
    private final a e;

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.materialCardViewStyle);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray a = k.a(context, attributeSet, a.k.MaterialCardView, i, a.j.Widget_MaterialComponents_CardView, new int[0]);
        this.e = new a(this);
        this.e.a(a);
        a.recycle();
    }

    public void setStrokeColor(int i) {
        this.e.a(i);
    }

    public int getStrokeColor() {
        return this.e.a();
    }

    public void setStrokeWidth(int i) {
        this.e.b(i);
    }

    public int getStrokeWidth() {
        return this.e.b();
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f) {
        super.setRadius(f);
        this.e.c();
    }
}
