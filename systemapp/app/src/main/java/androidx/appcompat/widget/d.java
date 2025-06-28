package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.a;

/* compiled from: source */
/* loaded from: classes.dex */
class d {
    private final View a;
    private ad d;
    private ad e;
    private ad f;
    private int c = -1;
    private final f b = f.b();

    d(View view) {
        this.a = view;
    }

    void a(AttributeSet attributeSet, int i) {
        af a = af.a(this.a.getContext(), attributeSet, a.j.ViewBackgroundHelper, i, 0);
        androidx.core.h.w.a(this.a, this.a.getContext(), a.j.ViewBackgroundHelper, attributeSet, a.a(), i, 0);
        try {
            if (a.g(a.j.ViewBackgroundHelper_android_background)) {
                this.c = a.g(a.j.ViewBackgroundHelper_android_background, -1);
                ColorStateList b = this.b.b(this.a.getContext(), this.c);
                if (b != null) {
                    b(b);
                }
            }
            if (a.g(a.j.ViewBackgroundHelper_backgroundTint)) {
                androidx.core.h.w.a(this.a, a.e(a.j.ViewBackgroundHelper_backgroundTint));
            }
            if (a.g(a.j.ViewBackgroundHelper_backgroundTintMode)) {
                androidx.core.h.w.a(this.a, p.a(a.a(a.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            a.b();
        }
    }

    void a(int i) {
        this.c = i;
        b(this.b != null ? this.b.b(this.a.getContext(), i) : null);
        c();
    }

    void a(Drawable drawable) {
        this.c = -1;
        b((ColorStateList) null);
        c();
    }

    void a(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new ad();
        }
        this.e.a = colorStateList;
        this.e.d = true;
        c();
    }

    ColorStateList a() {
        if (this.e != null) {
            return this.e.a;
        }
        return null;
    }

    void a(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new ad();
        }
        this.e.b = mode;
        this.e.c = true;
        c();
    }

    PorterDuff.Mode b() {
        if (this.e != null) {
            return this.e.b;
        }
        return null;
    }

    void c() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            if (d() && b(background)) {
                return;
            }
            if (this.e != null) {
                f.a(background, this.e, this.a.getDrawableState());
            } else if (this.d != null) {
                f.a(background, this.d, this.a.getDrawableState());
            }
        }
    }

    void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new ad();
            }
            this.d.a = colorStateList;
            this.d.d = true;
        } else {
            this.d = null;
        }
        c();
    }

    private boolean d() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.d != null : i == 21;
    }

    private boolean b(Drawable drawable) {
        if (this.f == null) {
            this.f = new ad();
        }
        ad adVar = this.f;
        adVar.a();
        ColorStateList y = androidx.core.h.w.y(this.a);
        if (y != null) {
            adVar.d = true;
            adVar.a = y;
        }
        PorterDuff.Mode z = androidx.core.h.w.z(this.a);
        if (z != null) {
            adVar.c = true;
            adVar.b = z;
        }
        if (!adVar.d && !adVar.c) {
            return false;
        }
        f.a(drawable, adVar, this.a.getDrawableState());
        return true;
    }
}
