package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.h.w;
import androidx.core.widget.i;
import androidx.legacy.widget.Space;
import com.google.android.material.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final class b {
    private final Context a;
    private final TextInputLayout b;
    private LinearLayout c;
    private int d;
    private FrameLayout e;
    private int f;
    private Animator g;
    private final float h;
    private int i;
    private int j;
    private CharSequence k;
    private boolean l;
    private TextView m;
    private int n;
    private CharSequence o;
    private boolean p;
    private TextView q;
    private int r;
    private Typeface s;

    boolean a(int i) {
        return i == 0 || i == 1;
    }

    public b(TextInputLayout textInputLayout) {
        this.a = textInputLayout.getContext();
        this.b = textInputLayout;
        this.h = this.a.getResources().getDimensionPixelSize(a.d.design_textinput_caption_translate_y);
    }

    void a(CharSequence charSequence) {
        c();
        this.o = charSequence;
        this.q.setText(charSequence);
        if (this.i != 2) {
            this.j = 2;
        }
        a(this.i, this.j, a(this.q, charSequence));
    }

    void a() {
        c();
        if (this.i == 2) {
            this.j = 0;
        }
        a(this.i, this.j, a(this.q, (CharSequence) null));
    }

    void b(CharSequence charSequence) {
        c();
        this.k = charSequence;
        this.m.setText(charSequence);
        if (this.i != 1) {
            this.j = 1;
        }
        a(this.i, this.j, a(this.m, charSequence));
    }

    void b() {
        this.k = null;
        c();
        if (this.i == 1) {
            if (this.p && !TextUtils.isEmpty(this.o)) {
                this.j = 2;
            } else {
                this.j = 0;
            }
        }
        a(this.i, this.j, a(this.m, (CharSequence) null));
    }

    private boolean a(TextView textView, CharSequence charSequence) {
        return w.C(this.b) && this.b.isEnabled() && !(this.j == this.i && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void a(int i, int i2, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.g = animatorSet;
            ArrayList arrayList = new ArrayList();
            a(arrayList, this.p, this.q, 2, i, i2);
            a(arrayList, this.l, this.m, 1, i, i2);
            com.google.android.material.a.b.a(animatorSet, arrayList);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.b.1
                final /* synthetic */ int a;
                final /* synthetic */ TextView b;
                final /* synthetic */ int c;
                final /* synthetic */ TextView d;

                AnonymousClass1(int i22, TextView textView, int i3, TextView textView2) {
                    i2 = i22;
                    d = textView;
                    i = i3;
                    d2 = textView2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    b.this.i = i2;
                    b.this.g = null;
                    if (d != null) {
                        d.setVisibility(4);
                        if (i != 1 || b.this.m == null) {
                            return;
                        }
                        b.this.m.setText((CharSequence) null);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (d2 != null) {
                        d2.setVisibility(0);
                    }
                }
            });
            animatorSet.start();
        } else {
            a(i3, i22);
        }
        this.b.c();
        this.b.a(z);
        this.b.d();
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.textfield.b$1 */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ int a;
        final /* synthetic */ TextView b;
        final /* synthetic */ int c;
        final /* synthetic */ TextView d;

        AnonymousClass1(int i22, TextView textView, int i3, TextView textView2) {
            i2 = i22;
            d = textView;
            i = i3;
            d2 = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.i = i2;
            b.this.g = null;
            if (d != null) {
                d.setVisibility(4);
                if (i != 1 || b.this.m == null) {
                    return;
                }
                b.this.m.setText((CharSequence) null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (d2 != null) {
                d2.setVisibility(0);
            }
        }
    }

    private void a(int i, int i2) {
        TextView d;
        TextView d2;
        if (i == i2) {
            return;
        }
        if (i2 != 0 && (d2 = d(i2)) != null) {
            d2.setVisibility(0);
            d2.setAlpha(1.0f);
        }
        if (i != 0 && (d = d(i)) != null) {
            d.setVisibility(4);
            if (i == 1) {
                d.setText((CharSequence) null);
            }
        }
        this.i = i2;
    }

    private void a(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            list.add(a(textView, i3 == i));
            if (i3 == i) {
                list.add(a(textView));
            }
        }
    }

    private ObjectAnimator a(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(com.google.android.material.a.a.a);
        return ofFloat;
    }

    private ObjectAnimator a(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.h, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(com.google.android.material.a.a.d);
        return ofFloat;
    }

    void c() {
        if (this.g != null) {
            this.g.cancel();
        }
    }

    private TextView d(int i) {
        switch (i) {
            case 1:
                return this.m;
            case 2:
                return this.q;
            default:
                return null;
        }
    }

    void d() {
        if (m()) {
            w.b(this.c, w.k(this.b.getEditText()), 0, w.l(this.b.getEditText()), 0);
        }
    }

    private boolean m() {
        return (this.c == null || this.b.getEditText() == null) ? false : true;
    }

    void a(TextView textView, int i) {
        if (this.c == null && this.e == null) {
            this.c = new LinearLayout(this.a);
            this.c.setOrientation(0);
            this.b.addView(this.c, -1, -2);
            this.e = new FrameLayout(this.a);
            this.c.addView(this.e, -1, new FrameLayout.LayoutParams(-2, -2));
            this.c.addView(new Space(this.a), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.b.getEditText() != null) {
                d();
            }
        }
        if (a(i)) {
            this.e.setVisibility(0);
            this.e.addView(textView);
            this.f++;
        } else {
            this.c.addView(textView, i);
        }
        this.c.setVisibility(0);
        this.d++;
    }

    void b(TextView textView, int i) {
        if (this.c == null) {
            return;
        }
        if (a(i) && this.e != null) {
            this.f--;
            a(this.e, this.f);
            this.e.removeView(textView);
        } else {
            this.c.removeView(textView);
        }
        this.d--;
        a(this.c, this.d);
    }

    private void a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    void a(boolean z) {
        if (this.l == z) {
            return;
        }
        c();
        if (z) {
            this.m = new AppCompatTextView(this.a);
            this.m.setId(a.f.textinput_error);
            if (this.s != null) {
                this.m.setTypeface(this.s);
            }
            b(this.n);
            this.m.setVisibility(4);
            w.d(this.m, 1);
            a(this.m, 0);
        } else {
            b();
            b(this.m, 0);
            this.m = null;
            this.b.c();
            this.b.d();
        }
        this.l = z;
    }

    boolean e() {
        return this.l;
    }

    boolean f() {
        return this.p;
    }

    void b(boolean z) {
        if (this.p == z) {
            return;
        }
        c();
        if (z) {
            this.q = new AppCompatTextView(this.a);
            this.q.setId(a.f.textinput_helper_text);
            if (this.s != null) {
                this.q.setTypeface(this.s);
            }
            this.q.setVisibility(4);
            w.d(this.q, 1);
            c(this.r);
            a(this.q, 1);
        } else {
            a();
            b(this.q, 1);
            this.q = null;
            this.b.c();
            this.b.d();
        }
        this.p = z;
    }

    boolean g() {
        return e(this.j);
    }

    private boolean e(int i) {
        return (i != 1 || this.m == null || TextUtils.isEmpty(this.k)) ? false : true;
    }

    CharSequence h() {
        return this.k;
    }

    CharSequence i() {
        return this.o;
    }

    void a(Typeface typeface) {
        if (typeface != this.s) {
            this.s = typeface;
            a(this.m, typeface);
            a(this.q, typeface);
        }
    }

    private void a(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    int j() {
        if (this.m != null) {
            return this.m.getCurrentTextColor();
        }
        return -1;
    }

    ColorStateList k() {
        if (this.m != null) {
            return this.m.getTextColors();
        }
        return null;
    }

    void a(ColorStateList colorStateList) {
        if (this.m != null) {
            this.m.setTextColor(colorStateList);
        }
    }

    void b(int i) {
        this.n = i;
        if (this.m != null) {
            this.b.a(this.m, i);
        }
    }

    int l() {
        if (this.q != null) {
            return this.q.getCurrentTextColor();
        }
        return -1;
    }

    void b(ColorStateList colorStateList) {
        if (this.q != null) {
            this.q.setTextColor(colorStateList);
        }
    }

    void c(int i) {
        this.r = i;
        if (this.q != null) {
            i.a(this.q, i);
        }
    }
}
