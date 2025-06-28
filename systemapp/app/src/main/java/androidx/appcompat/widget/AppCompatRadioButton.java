package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.a;

/* compiled from: source */
/* loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton implements androidx.core.h.u, androidx.core.widget.j {
    private final e a;
    private final d b;
    private final l c;

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0001a.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(ac.a(context), attributeSet, i);
        aa.a(this, getContext());
        this.a = new e(this);
        this.a.a(attributeSet, i);
        this.b = new d(this);
        this.b.a(attributeSet, i);
        this.c = new l(this);
        this.c.a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.a != null) {
            this.a.c();
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.a != null ? this.a.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            this.a.a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.a != null) {
            return this.a.a();
        }
        return null;
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.a != null) {
            this.a.a(mode);
        }
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.a != null) {
            return this.a.b();
        }
        return null;
    }

    @Override // androidx.core.h.u
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            this.b.a(colorStateList);
        }
    }

    @Override // androidx.core.h.u
    public ColorStateList getSupportBackgroundTintList() {
        if (this.b != null) {
            return this.b.a();
        }
        return null;
    }

    @Override // androidx.core.h.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.b != null) {
            this.b.a(mode);
        }
    }

    @Override // androidx.core.h.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.b != null) {
            return this.b.b();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.b != null) {
            this.b.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.b != null) {
            this.b.a(i);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.c();
        }
        if (this.c != null) {
            this.c.b();
        }
    }
}
