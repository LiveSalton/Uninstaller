package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.a;

/* compiled from: source */
/* loaded from: classes.dex */
class j extends i {
    private final SeekBar a;
    private Drawable b;
    private ColorStateList c;
    private PorterDuff.Mode d;
    private boolean e;
    private boolean f;

    j(SeekBar seekBar) {
        super(seekBar);
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = false;
        this.a = seekBar;
    }

    @Override // androidx.appcompat.widget.i
    void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        af a = af.a(this.a.getContext(), attributeSet, a.j.AppCompatSeekBar, i, 0);
        androidx.core.h.w.a(this.a, this.a.getContext(), a.j.AppCompatSeekBar, attributeSet, a.a(), i, 0);
        Drawable b = a.b(a.j.AppCompatSeekBar_android_thumb);
        if (b != null) {
            this.a.setThumb(b);
        }
        a(a.a(a.j.AppCompatSeekBar_tickMark));
        if (a.g(a.j.AppCompatSeekBar_tickMarkTintMode)) {
            this.d = p.a(a.a(a.j.AppCompatSeekBar_tickMarkTintMode, -1), this.d);
            this.f = true;
        }
        if (a.g(a.j.AppCompatSeekBar_tickMarkTint)) {
            this.c = a.e(a.j.AppCompatSeekBar_tickMarkTint);
            this.e = true;
        }
        a.b();
        d();
    }

    void a(Drawable drawable) {
        if (this.b != null) {
            this.b.setCallback(null);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.a);
            androidx.core.graphics.drawable.a.b(drawable, androidx.core.h.w.h(this.a));
            if (drawable.isStateful()) {
                drawable.setState(this.a.getDrawableState());
            }
            d();
        }
        this.a.invalidate();
    }

    private void d() {
        if (this.b != null) {
            if (this.e || this.f) {
                this.b = androidx.core.graphics.drawable.a.g(this.b.mutate());
                if (this.e) {
                    androidx.core.graphics.drawable.a.a(this.b, this.c);
                }
                if (this.f) {
                    androidx.core.graphics.drawable.a.a(this.b, this.d);
                }
                if (this.b.isStateful()) {
                    this.b.setState(this.a.getDrawableState());
                }
            }
        }
    }

    void b() {
        if (this.b != null) {
            this.b.jumpToCurrentState();
        }
    }

    void c() {
        Drawable drawable = this.b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.a.getDrawableState())) {
            this.a.invalidateDrawable(drawable);
        }
    }

    void a(Canvas canvas) {
        if (this.b != null) {
            int max = this.a.getMax();
            if (max > 1) {
                int intrinsicWidth = this.b.getIntrinsicWidth();
                int intrinsicHeight = this.b.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.b.setBounds(-i, -i2, i, i2);
                float width = ((this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.a.getPaddingLeft(), this.a.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.b.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
