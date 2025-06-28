package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* compiled from: source */
/* loaded from: classes.dex */
public class a extends Drawable {
    float e;
    private int f;
    private int g;
    private int h;
    private int i;
    private ColorStateList j;
    private int k;
    private float m;
    final Rect b = new Rect();
    final RectF c = new RectF();
    final C0083a d = new C0083a();
    private boolean l = true;
    final Paint a = new Paint(1);

    public a() {
        this.a.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.d;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.i = i4;
    }

    public void a(float f) {
        if (this.e != f) {
            this.e = f;
            this.a.setStrokeWidth(f * 1.3333f);
            this.l = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.l) {
            this.a.setShader(a());
            this.l = false;
        }
        float strokeWidth = this.a.getStrokeWidth() / 2.0f;
        RectF rectF = this.c;
        copyBounds(this.b);
        rectF.set(this.b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.m, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int round = Math.round(this.e);
        rect.set(round, round, round, round);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.a.setAlpha(i);
        invalidateSelf();
    }

    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.k = colorStateList.getColorForState(getState(), this.k);
        }
        this.j = colorStateList;
        this.l = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.e > 0.0f ? -3 : -2;
    }

    public final void b(float f) {
        if (f != this.m) {
            this.m = f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return (this.j != null && this.j.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        if (this.j != null && (colorForState = this.j.getColorForState(iArr, this.k)) != this.k) {
            this.l = true;
            this.k = colorForState;
        }
        if (this.l) {
            invalidateSelf();
        }
        return this.l;
    }

    private Shader a() {
        copyBounds(this.b);
        float height = this.e / r0.height();
        return new LinearGradient(0.0f, r0.top, 0.0f, r0.bottom, new int[]{androidx.core.graphics.a.a(this.f, this.k), androidx.core.graphics.a.a(this.g, this.k), androidx.core.graphics.a.a(androidx.core.graphics.a.b(this.g, 0), this.k), androidx.core.graphics.a.a(androidx.core.graphics.a.b(this.i, 0), this.k), androidx.core.graphics.a.a(this.i, this.k), androidx.core.graphics.a.a(this.h, this.k)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.internal.a$a */
    private class C0083a extends Drawable.ConstantState {
        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        private C0083a() {
        }

        /* synthetic */ C0083a(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return a.this;
        }
    }
}
