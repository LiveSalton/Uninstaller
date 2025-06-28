package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import com.google.android.material.internal.VisibilityAwareImageButton;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
class b extends com.google.android.material.floatingactionbutton.a {
    private InsetDrawable x;

    @Override // com.google.android.material.floatingactionbutton.a
    void g() {
    }

    @Override // com.google.android.material.floatingactionbutton.a
    boolean m() {
        return false;
    }

    b(VisibilityAwareImageButton visibilityAwareImageButton, com.google.android.material.h.b bVar) {
        super(visibilityAwareImageButton, bVar);
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable drawable;
        this.g = androidx.core.graphics.drawable.a.g(p());
        androidx.core.graphics.drawable.a.a(this.g, colorStateList);
        if (mode != null) {
            androidx.core.graphics.drawable.a.a(this.g, mode);
        }
        if (i > 0) {
            this.i = a(i, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{this.i, this.g});
        } else {
            this.i = null;
            drawable = this.g;
        }
        this.h = new RippleDrawable(com.google.android.material.g.a.a(colorStateList2), drawable, null);
        this.j = this.h;
        this.w.a(this.h);
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void b(ColorStateList colorStateList) {
        if (this.h instanceof RippleDrawable) {
            ((RippleDrawable) this.h).setColor(com.google.android.material.g.a.a(colorStateList));
        } else {
            super.b(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void a(float f, float f2, float f3) {
        if (Build.VERSION.SDK_INT == 21) {
            this.v.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(p, a(f, f3));
            stateListAnimator.addState(q, a(f, f2));
            stateListAnimator.addState(r, a(f, f2));
            stateListAnimator.addState(s, a(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.v, "elevation", f).setDuration(0L));
            if (Build.VERSION.SDK_INT >= 22 && Build.VERSION.SDK_INT <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(this.v, (Property<VisibilityAwareImageButton, Float>) View.TRANSLATION_Z, this.v.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.v, (Property<VisibilityAwareImageButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(a);
            stateListAnimator.addState(t, animatorSet);
            stateListAnimator.addState(u, a(0.0f, 0.0f));
            this.v.setStateListAnimator(stateListAnimator);
        }
        if (this.w.b()) {
            j();
        }
    }

    private Animator a(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.v, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.v, (Property<VisibilityAwareImageButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(a);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public float a() {
        return this.v.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void i() {
        j();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void b(Rect rect) {
        if (this.w.b()) {
            this.x = new InsetDrawable(this.h, rect.left, rect.top, rect.right, rect.bottom);
            this.w.a(this.x);
        } else {
            this.w.a(this.h);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void a(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (this.v.isEnabled()) {
                this.v.setElevation(this.k);
                if (this.v.isPressed()) {
                    this.v.setTranslationZ(this.m);
                    return;
                } else if (this.v.isFocused() || this.v.isHovered()) {
                    this.v.setTranslationZ(this.l);
                    return;
                } else {
                    this.v.setTranslationZ(0.0f);
                    return;
                }
            }
            this.v.setElevation(0.0f);
            this.v.setTranslationZ(0.0f);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    com.google.android.material.internal.a n() {
        return new com.google.android.material.internal.b();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    GradientDrawable q() {
        return new a();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    void a(Rect rect) {
        if (this.w.b()) {
            float a2 = this.w.a();
            float a3 = a() + this.m;
            int ceil = (int) Math.ceil(com.google.android.material.h.a.b(a3, a2, false));
            int ceil2 = (int) Math.ceil(com.google.android.material.h.a.a(a3, a2, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    /* compiled from: source */
    static class a extends GradientDrawable {
        @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }

        a() {
        }
    }
}
