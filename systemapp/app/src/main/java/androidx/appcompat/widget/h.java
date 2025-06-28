package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.a;

/* compiled from: source */
/* loaded from: classes.dex */
public class h {
    private final ImageView a;
    private ad b;
    private ad c;
    private ad d;

    public h(ImageView imageView) {
        this.a = imageView;
    }

    public void a(AttributeSet attributeSet, int i) {
        int g;
        af a = af.a(this.a.getContext(), attributeSet, a.j.AppCompatImageView, i, 0);
        androidx.core.h.w.a(this.a, this.a.getContext(), a.j.AppCompatImageView, attributeSet, a.a(), i, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null && (g = a.g(a.j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = androidx.appcompat.a.a.a.b(this.a.getContext(), g)) != null) {
                this.a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                p.b(drawable);
            }
            if (a.g(a.j.AppCompatImageView_tint)) {
                androidx.core.widget.e.a(this.a, a.e(a.j.AppCompatImageView_tint));
            }
            if (a.g(a.j.AppCompatImageView_tintMode)) {
                androidx.core.widget.e.a(this.a, p.a(a.a(a.j.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            a.b();
        }
    }

    public void a(int i) {
        if (i != 0) {
            Drawable b = androidx.appcompat.a.a.a.b(this.a.getContext(), i);
            if (b != null) {
                p.b(b);
            }
            this.a.setImageDrawable(b);
        } else {
            this.a.setImageDrawable(null);
        }
        d();
    }

    boolean a() {
        return Build.VERSION.SDK_INT < 21 || !(this.a.getBackground() instanceof RippleDrawable);
    }

    void a(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new ad();
        }
        this.c.a = colorStateList;
        this.c.d = true;
        d();
    }

    ColorStateList b() {
        if (this.c != null) {
            return this.c.a;
        }
        return null;
    }

    void a(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new ad();
        }
        this.c.b = mode;
        this.c.c = true;
        d();
    }

    PorterDuff.Mode c() {
        if (this.c != null) {
            return this.c.b;
        }
        return null;
    }

    void d() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            p.b(drawable);
        }
        if (drawable != null) {
            if (e() && a(drawable)) {
                return;
            }
            if (this.c != null) {
                f.a(drawable, this.c, this.a.getDrawableState());
            } else if (this.b != null) {
                f.a(drawable, this.b, this.a.getDrawableState());
            }
        }
    }

    private boolean e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.b != null : i == 21;
    }

    private boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new ad();
        }
        ad adVar = this.d;
        adVar.a();
        ColorStateList a = androidx.core.widget.e.a(this.a);
        if (a != null) {
            adVar.d = true;
            adVar.a = a;
        }
        PorterDuff.Mode b = androidx.core.widget.e.b(this.a);
        if (b != null) {
            adVar.c = true;
            adVar.b = b;
        }
        if (!adVar.d && !adVar.c) {
            return false;
        }
        f.a(drawable, adVar, this.a.getDrawableState());
        return true;
    }
}
