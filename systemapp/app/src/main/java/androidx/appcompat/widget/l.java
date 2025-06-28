package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.core.content.a.f;
import java.lang.ref.WeakReference;

/* compiled from: source */
/* loaded from: classes.dex */
class l {
    private final TextView a;
    private ad b;
    private ad c;
    private ad d;
    private ad e;
    private ad f;
    private ad g;
    private ad h;
    private final m i;
    private int j = 0;
    private int k = -1;
    private Typeface l;
    private boolean m;

    l(TextView textView) {
        this.a = textView;
        this.i = new m(this.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0124  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(android.util.AttributeSet r19, int r20) {
        /*
            Method dump skipped, instructions count: 845
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.l.a(android.util.AttributeSet, int):void");
    }

    private void a(Context context, af afVar) {
        int i;
        String d;
        this.j = afVar.a(a.j.TextAppearance_android_textStyle, this.j);
        if (Build.VERSION.SDK_INT >= 28) {
            this.k = afVar.a(a.j.TextAppearance_android_textFontWeight, -1);
            if (this.k != -1) {
                this.j = (this.j & 2) | 0;
            }
        }
        if (afVar.g(a.j.TextAppearance_android_fontFamily) || afVar.g(a.j.TextAppearance_fontFamily)) {
            this.l = null;
            if (afVar.g(a.j.TextAppearance_fontFamily)) {
                i = a.j.TextAppearance_fontFamily;
            } else {
                i = a.j.TextAppearance_android_fontFamily;
            }
            int i2 = this.k;
            int i3 = this.j;
            if (!context.isRestricted()) {
                try {
                    Typeface a = afVar.a(i, this.j, new f.a() { // from class: androidx.appcompat.widget.l.1
                        final /* synthetic */ int a;
                        final /* synthetic */ int b;
                        final /* synthetic */ WeakReference c;

                        @Override // androidx.core.content.a.f.a
                        public void a(int i4) {
                        }

                        AnonymousClass1(int i22, int i32, WeakReference weakReference) {
                            i2 = i22;
                            i3 = i32;
                            weakReference = weakReference;
                        }

                        @Override // androidx.core.content.a.f.a
                        public void a(Typeface typeface) {
                            if (Build.VERSION.SDK_INT >= 28 && i2 != -1) {
                                typeface = Typeface.create(typeface, i2, (i3 & 2) != 0);
                            }
                            l.this.a(weakReference, typeface);
                        }
                    });
                    if (a != null) {
                        if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
                            this.l = Typeface.create(Typeface.create(a, 0), this.k, (this.j & 2) != 0);
                        } else {
                            this.l = a;
                        }
                    }
                    this.m = this.l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.l != null || (d = afVar.d(i)) == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
                this.l = Typeface.create(Typeface.create(d, 0), this.k, (this.j & 2) != 0);
                return;
            } else {
                this.l = Typeface.create(d, this.j);
                return;
            }
        }
        if (afVar.g(a.j.TextAppearance_android_typeface)) {
            this.m = false;
            switch (afVar.a(a.j.TextAppearance_android_typeface, 1)) {
                case 1:
                    this.l = Typeface.SANS_SERIF;
                    break;
                case 2:
                    this.l = Typeface.SERIF;
                    break;
                case 3:
                    this.l = Typeface.MONOSPACE;
                    break;
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.l$1 */
    class AnonymousClass1 extends f.a {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ WeakReference c;

        @Override // androidx.core.content.a.f.a
        public void a(int i4) {
        }

        AnonymousClass1(int i22, int i32, WeakReference weakReference) {
            i2 = i22;
            i3 = i32;
            weakReference = weakReference;
        }

        @Override // androidx.core.content.a.f.a
        public void a(Typeface typeface) {
            if (Build.VERSION.SDK_INT >= 28 && i2 != -1) {
                typeface = Typeface.create(typeface, i2, (i3 & 2) != 0);
            }
            l.this.a(weakReference, typeface);
        }
    }

    void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.m) {
            this.l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.j);
            }
        }
    }

    void a(Context context, int i) {
        String d;
        ColorStateList e;
        af a = af.a(context, i, a.j.TextAppearance);
        if (a.g(a.j.TextAppearance_textAllCaps)) {
            a(a.a(a.j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && a.g(a.j.TextAppearance_android_textColor) && (e = a.e(a.j.TextAppearance_android_textColor)) != null) {
            this.a.setTextColor(e);
        }
        if (a.g(a.j.TextAppearance_android_textSize) && a.e(a.j.TextAppearance_android_textSize, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        a(context, a);
        if (Build.VERSION.SDK_INT >= 26 && a.g(a.j.TextAppearance_fontVariationSettings) && (d = a.d(a.j.TextAppearance_fontVariationSettings)) != null) {
            this.a.setFontVariationSettings(d);
        }
        a.b();
        if (this.l != null) {
            this.a.setTypeface(this.l, this.j);
        }
    }

    void a(boolean z) {
        this.a.setAllCaps(z);
    }

    void a() {
        b();
    }

    void b() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f == null && this.g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    private void a(Drawable drawable, ad adVar) {
        if (drawable == null || adVar == null) {
            return;
        }
        f.a(drawable, adVar, this.a.getDrawableState());
    }

    private static ad a(Context context, f fVar, int i) {
        ColorStateList b = fVar.b(context, i);
        if (b == null) {
            return null;
        }
        ad adVar = new ad();
        adVar.d = true;
        adVar.a = b;
        return adVar;
    }

    void a(boolean z, int i, int i2, int i3, int i4) {
        if (androidx.core.widget.b.d) {
            return;
        }
        c();
    }

    void a(int i, float f) {
        if (androidx.core.widget.b.d || d()) {
            return;
        }
        b(i, f);
    }

    void c() {
        this.i.f();
    }

    boolean d() {
        return this.i.g();
    }

    private void b(int i, float f) {
        this.i.a(i, f);
    }

    void a(int i) {
        this.i.a(i);
    }

    void a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        this.i.a(i, i2, i3, i4);
    }

    void a(int[] iArr, int i) throws IllegalArgumentException {
        this.i.a(iArr, i);
    }

    int e() {
        return this.i.a();
    }

    int f() {
        return this.i.b();
    }

    int g() {
        return this.i.c();
    }

    int h() {
        return this.i.d();
    }

    int[] i() {
        return this.i.e();
    }

    ColorStateList j() {
        if (this.h != null) {
            return this.h.a;
        }
        return null;
    }

    void a(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new ad();
        }
        this.h.a = colorStateList;
        this.h.d = colorStateList != null;
        l();
    }

    PorterDuff.Mode k() {
        if (this.h != null) {
            return this.h.b;
        }
        return null;
    }

    void a(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new ad();
        }
        this.h.b = mode;
        this.h.c = mode != null;
        l();
    }

    private void l() {
        this.b = this.h;
        this.c = this.h;
        this.d = this.h;
        this.e = this.h;
        this.f = this.h;
        this.g = this.h;
    }

    private void a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            TextView textView = this.a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Drawable[] compoundDrawablesRelative2 = this.a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                TextView textView2 = this.a;
                Drawable drawable7 = compoundDrawablesRelative2[0];
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable8 = compoundDrawablesRelative2[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
        }
        Drawable[] compoundDrawables = this.a.getCompoundDrawables();
        TextView textView3 = this.a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }
}
