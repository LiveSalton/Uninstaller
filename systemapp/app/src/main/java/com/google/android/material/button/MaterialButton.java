package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.h.w;
import androidx.core.widget.i;
import com.google.android.material.a;
import com.google.android.material.internal.k;
import com.google.android.material.internal.l;

/* compiled from: source */
/* loaded from: classes.dex */
public class MaterialButton extends AppCompatButton {
    private final b a;
    private int b;
    private PorterDuff.Mode c;
    private ColorStateList e;
    private Drawable f;
    private int g;
    private int h;
    private int i;

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.materialButtonStyle);
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray a = k.a(context, attributeSet, a.k.MaterialButton, i, a.j.Widget_MaterialComponents_Button, new int[0]);
        this.b = a.getDimensionPixelSize(a.k.MaterialButton_iconPadding, 0);
        this.c = l.a(a.getInt(a.k.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.e = com.google.android.material.f.a.a(getContext(), a, a.k.MaterialButton_iconTint);
        this.f = com.google.android.material.f.a.b(getContext(), a, a.k.MaterialButton_icon);
        this.i = a.getInteger(a.k.MaterialButton_iconGravity, 1);
        this.g = a.getDimensionPixelSize(a.k.MaterialButton_iconSize, 0);
        this.a = new b(this);
        this.a.a(a);
        a.recycle();
        setCompoundDrawablePadding(this.b);
        b();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT >= 21 || !c()) {
            return;
        }
        this.a.a(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.h.u
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (c()) {
            this.a.a(colorStateList);
        } else if (this.a != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.h.u
    public ColorStateList getSupportBackgroundTintList() {
        if (c()) {
            return this.a.c();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.h.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (c()) {
            this.a.a(mode);
        } else if (this.a != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.h.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (c()) {
            return this.a.d();
        }
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (c()) {
            this.a.a(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (c()) {
            if (drawable != getBackground()) {
                Log.i("MaterialButton", "Setting a custom background is not supported.");
                this.a.a();
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT != 21 || this.a == null) {
            return;
        }
        this.a.a(i4 - i2, i3 - i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f == null || this.i != 2) {
            return;
        }
        int measuredWidth = (((((getMeasuredWidth() - ((int) getPaint().measureText(getText().toString()))) - w.l(this)) - (this.g == 0 ? this.f.getIntrinsicWidth() : this.g)) - this.b) - w.k(this)) / 2;
        if (a()) {
            measuredWidth = -measuredWidth;
        }
        if (this.h != measuredWidth) {
            this.h = measuredWidth;
            b();
        }
    }

    private boolean a() {
        return w.h(this) == 1;
    }

    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setIconPadding(int i) {
        if (this.b != i) {
            this.b = i;
            setCompoundDrawablePadding(i);
        }
    }

    public int getIconPadding() {
        return this.b;
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.g != i) {
            this.g = i;
            b();
        }
    }

    public int getIconSize() {
        return this.g;
    }

    public void setIcon(Drawable drawable) {
        if (this.f != drawable) {
            this.f = drawable;
            b();
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    public Drawable getIcon() {
        return this.f;
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            b();
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(androidx.appcompat.a.a.a.a(getContext(), i));
    }

    public ColorStateList getIconTint() {
        return this.e;
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.c != mode) {
            this.c = mode;
            b();
        }
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.c;
    }

    private void b() {
        if (this.f != null) {
            this.f = this.f.mutate();
            androidx.core.graphics.drawable.a.a(this.f, this.e);
            if (this.c != null) {
                androidx.core.graphics.drawable.a.a(this.f, this.c);
            }
            this.f.setBounds(this.h, 0, this.h + (this.g != 0 ? this.g : this.f.getIntrinsicWidth()), this.g != 0 ? this.g : this.f.getIntrinsicHeight());
        }
        i.a(this, this.f, null, null, null);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (c()) {
            this.a.b(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        if (c()) {
            setRippleColor(androidx.appcompat.a.a.a.a(getContext(), i));
        }
    }

    public ColorStateList getRippleColor() {
        if (c()) {
            return this.a.e();
        }
        return null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (c()) {
            this.a.c(colorStateList);
        }
    }

    public void setStrokeColorResource(int i) {
        if (c()) {
            setStrokeColor(androidx.appcompat.a.a.a.a(getContext(), i));
        }
    }

    public ColorStateList getStrokeColor() {
        if (c()) {
            return this.a.f();
        }
        return null;
    }

    public void setStrokeWidth(int i) {
        if (c()) {
            this.a.b(i);
        }
    }

    public void setStrokeWidthResource(int i) {
        if (c()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    public int getStrokeWidth() {
        if (c()) {
            return this.a.g();
        }
        return 0;
    }

    public void setCornerRadius(int i) {
        if (c()) {
            this.a.c(i);
        }
    }

    public void setCornerRadiusResource(int i) {
        if (c()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public int getCornerRadius() {
        if (c()) {
            return this.a.h();
        }
        return 0;
    }

    public int getIconGravity() {
        return this.i;
    }

    public void setIconGravity(int i) {
        this.i = i;
    }

    private boolean c() {
        return (this.a == null || this.a.b()) ? false : true;
    }
}
