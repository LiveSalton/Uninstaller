package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.af;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.p;
import androidx.core.h.w;
import androidx.core.widget.i;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.a;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.c;
import com.google.android.material.internal.d;
import com.google.android.material.internal.e;
import com.google.android.material.internal.k;
import com.google.android.material.internal.l;

/* compiled from: source */
/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    private int A;
    private int B;
    private Drawable C;
    private final Rect D;
    private final RectF E;
    private Typeface F;
    private boolean G;
    private Drawable H;
    private CharSequence I;
    private CheckableImageButton J;
    private boolean K;
    private Drawable L;
    private Drawable M;
    private ColorStateList N;
    private boolean O;
    private PorterDuff.Mode P;
    private boolean Q;
    private ColorStateList R;
    private ColorStateList S;
    private final int T;
    private final int U;
    private int V;
    private final int W;
    EditText a;
    private boolean aa;
    private boolean ab;
    private ValueAnimator ac;
    private boolean ad;
    private boolean ae;
    private boolean af;
    boolean b;
    final c c;
    private final FrameLayout d;
    private CharSequence e;
    private final b f;
    private int g;
    private boolean h;
    private TextView i;
    private final int j;
    private final int k;
    private boolean l;
    private CharSequence m;
    private boolean n;
    private GradientDrawable o;
    private final int p;
    private final int q;
    private int r;
    private final int s;
    private float t;
    private float u;
    private float v;
    private float w;
    private int x;
    private final int y;
    private final int z;

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.textInputStyle);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new b(this);
        this.D = new Rect();
        this.E = new RectF();
        this.c = new c(this);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.d = new FrameLayout(context);
        this.d.setAddStatesFromChildren(true);
        addView(this.d);
        this.c.a(com.google.android.material.a.a.a);
        this.c.b(com.google.android.material.a.a.a);
        this.c.b(8388659);
        af b = k.b(context, attributeSet, a.k.TextInputLayout, i, a.j.Widget_Design_TextInputLayout, new int[0]);
        this.l = b.a(a.k.TextInputLayout_hintEnabled, true);
        setHint(b.c(a.k.TextInputLayout_android_hint));
        this.ab = b.a(a.k.TextInputLayout_hintAnimationEnabled, true);
        this.p = context.getResources().getDimensionPixelOffset(a.d.mtrl_textinput_box_bottom_offset);
        this.q = context.getResources().getDimensionPixelOffset(a.d.mtrl_textinput_box_label_cutout_padding);
        this.s = b.d(a.k.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.t = b.b(a.k.TextInputLayout_boxCornerRadiusTopStart, 0.0f);
        this.u = b.b(a.k.TextInputLayout_boxCornerRadiusTopEnd, 0.0f);
        this.v = b.b(a.k.TextInputLayout_boxCornerRadiusBottomEnd, 0.0f);
        this.w = b.b(a.k.TextInputLayout_boxCornerRadiusBottomStart, 0.0f);
        this.B = b.b(a.k.TextInputLayout_boxBackgroundColor, 0);
        this.V = b.b(a.k.TextInputLayout_boxStrokeColor, 0);
        this.y = context.getResources().getDimensionPixelSize(a.d.mtrl_textinput_box_stroke_width_default);
        this.z = context.getResources().getDimensionPixelSize(a.d.mtrl_textinput_box_stroke_width_focused);
        this.x = this.y;
        setBoxBackgroundMode(b.a(a.k.TextInputLayout_boxBackgroundMode, 0));
        if (b.g(a.k.TextInputLayout_android_textColorHint)) {
            ColorStateList e = b.e(a.k.TextInputLayout_android_textColorHint);
            this.S = e;
            this.R = e;
        }
        this.T = androidx.core.content.a.c(context, a.c.mtrl_textinput_default_box_stroke_color);
        this.W = androidx.core.content.a.c(context, a.c.mtrl_textinput_disabled_color);
        this.U = androidx.core.content.a.c(context, a.c.mtrl_textinput_hovered_box_stroke_color);
        if (b.g(a.k.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(b.g(a.k.TextInputLayout_hintTextAppearance, 0));
        }
        int g = b.g(a.k.TextInputLayout_errorTextAppearance, 0);
        boolean a2 = b.a(a.k.TextInputLayout_errorEnabled, false);
        int g2 = b.g(a.k.TextInputLayout_helperTextTextAppearance, 0);
        boolean a3 = b.a(a.k.TextInputLayout_helperTextEnabled, false);
        CharSequence c = b.c(a.k.TextInputLayout_helperText);
        boolean a4 = b.a(a.k.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(b.a(a.k.TextInputLayout_counterMaxLength, -1));
        this.k = b.g(a.k.TextInputLayout_counterTextAppearance, 0);
        this.j = b.g(a.k.TextInputLayout_counterOverflowTextAppearance, 0);
        this.G = b.a(a.k.TextInputLayout_passwordToggleEnabled, false);
        this.H = b.a(a.k.TextInputLayout_passwordToggleDrawable);
        this.I = b.c(a.k.TextInputLayout_passwordToggleContentDescription);
        if (b.g(a.k.TextInputLayout_passwordToggleTint)) {
            this.O = true;
            this.N = b.e(a.k.TextInputLayout_passwordToggleTint);
        }
        if (b.g(a.k.TextInputLayout_passwordToggleTintMode)) {
            this.Q = true;
            this.P = l.a(b.a(a.k.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        b.b();
        setHelperTextEnabled(a3);
        setHelperText(c);
        setHelperTextTextAppearance(g2);
        setErrorEnabled(a2);
        setErrorTextAppearance(g);
        setCounterEnabled(a4);
        s();
        w.b((View) this, 2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = 16 | (layoutParams2.gravity & (-113));
            this.d.addView(view, layoutParams2);
            this.d.setLayoutParams(layoutParams);
            g();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private Drawable getBoxBackground() {
        if (this.r == 1 || this.r == 2) {
            return this.o;
        }
        throw new IllegalStateException();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.r) {
            return;
        }
        this.r = i;
        e();
    }

    private void e() {
        f();
        if (this.r != 0) {
            g();
        }
        h();
    }

    private void f() {
        if (this.r == 0) {
            this.o = null;
            return;
        }
        if (this.r == 2 && this.l && !(this.o instanceof com.google.android.material.textfield.a)) {
            this.o = new com.google.android.material.textfield.a();
        } else {
            if (this.o instanceof GradientDrawable) {
                return;
            }
            this.o = new GradientDrawable();
        }
    }

    public void setBoxStrokeColor(int i) {
        if (this.V != i) {
            this.V = i;
            d();
        }
    }

    public int getBoxStrokeColor() {
        return this.V;
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(androidx.core.content.a.c(getContext(), i));
    }

    public void setBoxBackgroundColor(int i) {
        if (this.B != i) {
            this.B = i;
            n();
        }
    }

    public int getBoxBackgroundColor() {
        return this.B;
    }

    public float getBoxCornerRadiusTopStart() {
        return this.t;
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.u;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.v;
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.w;
    }

    private float[] getCornerRadiiAsArray() {
        if (!l.a(this)) {
            return new float[]{this.t, this.t, this.u, this.u, this.v, this.v, this.w, this.w};
        }
        return new float[]{this.u, this.u, this.t, this.t, this.w, this.w, this.v, this.v};
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.F) {
            this.F = typeface;
            this.c.c(typeface);
            this.f.a(typeface);
            if (this.i != null) {
                this.i.setTypeface(typeface);
            }
        }
    }

    public Typeface getTypeface() {
        return this.F;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        if (this.e == null || this.a == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        boolean z = this.n;
        this.n = false;
        CharSequence hint = this.a.getHint();
        this.a.setHint(this.e);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
        } finally {
            this.a.setHint(hint);
            this.n = z;
        }
    }

    private void setEditText(EditText editText) {
        if (this.a != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (!(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.a = editText;
        e();
        setTextInputAccessibilityDelegate(new a(this));
        if (!q()) {
            this.c.c(this.a.getTypeface());
        }
        this.c.a(this.a.getTextSize());
        int gravity = this.a.getGravity();
        this.c.b(48 | (gravity & (-113)));
        this.c.a(gravity);
        this.a.addTextChangedListener(new TextWatcher() { // from class: com.google.android.material.textfield.TextInputLayout.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            AnonymousClass1() {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                TextInputLayout.this.a(!TextInputLayout.this.af);
                if (TextInputLayout.this.b) {
                    TextInputLayout.this.a(editable.length());
                }
            }
        });
        if (this.R == null) {
            this.R = this.a.getHintTextColors();
        }
        if (this.l) {
            if (TextUtils.isEmpty(this.m)) {
                this.e = this.a.getHint();
                setHint(this.e);
                this.a.setHint((CharSequence) null);
            }
            this.n = true;
        }
        if (this.i != null) {
            a(this.a.getText().length());
        }
        this.f.d();
        p();
        a(false, true);
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.textfield.TextInputLayout$1 */
    class AnonymousClass1 implements TextWatcher {
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        AnonymousClass1() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.a(!TextInputLayout.this.af);
            if (TextInputLayout.this.b) {
                TextInputLayout.this.a(editable.length());
            }
        }
    }

    private void g() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        int j = j();
        if (j != layoutParams.topMargin) {
            layoutParams.topMargin = j;
            this.d.requestLayout();
        }
    }

    void a(boolean z) {
        a(z, false);
    }

    private void a(boolean z, boolean z2) {
        boolean isEnabled = isEnabled();
        boolean z3 = false;
        boolean z4 = (this.a == null || TextUtils.isEmpty(this.a.getText())) ? false : true;
        if (this.a != null && this.a.hasFocus()) {
            z3 = true;
        }
        boolean g = this.f.g();
        if (this.R != null) {
            this.c.a(this.R);
            this.c.b(this.R);
        }
        if (!isEnabled) {
            this.c.a(ColorStateList.valueOf(this.W));
            this.c.b(ColorStateList.valueOf(this.W));
        } else if (g) {
            this.c.a(this.f.k());
        } else if (this.h && this.i != null) {
            this.c.a(this.i.getTextColors());
        } else if (z3 && this.S != null) {
            this.c.a(this.S);
        }
        if (z4 || (isEnabled() && (z3 || g))) {
            if (z2 || this.aa) {
                c(z);
                return;
            }
            return;
        }
        if (z2 || !this.aa) {
            d(z);
        }
    }

    public EditText getEditText() {
        return this.a;
    }

    public void setHint(CharSequence charSequence) {
        if (this.l) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.m)) {
            return;
        }
        this.m = charSequence;
        this.c.a(charSequence);
        if (this.aa) {
            return;
        }
        u();
    }

    public CharSequence getHint() {
        if (this.l) {
            return this.m;
        }
        return null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.l) {
            this.l = z;
            if (!this.l) {
                this.n = false;
                if (!TextUtils.isEmpty(this.m) && TextUtils.isEmpty(this.a.getHint())) {
                    this.a.setHint(this.m);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.a.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.m)) {
                        setHint(hint);
                    }
                    this.a.setHint((CharSequence) null);
                }
                this.n = true;
            }
            if (this.a != null) {
                g();
            }
        }
    }

    boolean a() {
        return this.n;
    }

    public void setHintTextAppearance(int i) {
        this.c.c(i);
        this.S = this.c.m();
        if (this.a != null) {
            a(false);
            g();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.R = colorStateList;
        this.S = colorStateList;
        if (this.a != null) {
            a(false);
        }
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.R;
    }

    public void setErrorEnabled(boolean z) {
        this.f.a(z);
    }

    public void setErrorTextAppearance(int i) {
        this.f.b(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f.a(colorStateList);
    }

    public int getErrorCurrentTextColors() {
        return this.f.j();
    }

    public void setHelperTextTextAppearance(int i) {
        this.f.c(i);
    }

    public void setHelperTextEnabled(boolean z) {
        this.f.b(z);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (b()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!b()) {
                setHelperTextEnabled(true);
            }
            this.f.a(charSequence);
        }
    }

    public boolean b() {
        return this.f.f();
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f.b(colorStateList);
    }

    public int getHelperTextCurrentTextColor() {
        return this.f.l();
    }

    public void setError(CharSequence charSequence) {
        if (!this.f.e()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f.b(charSequence);
        } else {
            this.f.b();
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.b != z) {
            if (z) {
                this.i = new AppCompatTextView(getContext());
                this.i.setId(a.f.textinput_counter);
                if (this.F != null) {
                    this.i.setTypeface(this.F);
                }
                this.i.setMaxLines(1);
                a(this.i, this.k);
                this.f.a(this.i, 2);
                if (this.a == null) {
                    a(0);
                } else {
                    a(this.a.getText().length());
                }
            } else {
                this.f.b(this.i, 2);
                this.i = null;
            }
            this.b = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.g != i) {
            if (i > 0) {
                this.g = i;
            } else {
                this.g = -1;
            }
            if (this.b) {
                a(this.a == null ? 0 : this.a.getText().length());
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        a(this, z);
        super.setEnabled(z);
    }

    private static void a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, z);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.g;
    }

    CharSequence getCounterOverflowDescription() {
        if (this.b && this.h && this.i != null) {
            return this.i.getContentDescription();
        }
        return null;
    }

    void a(int i) {
        boolean z = this.h;
        if (this.g == -1) {
            this.i.setText(String.valueOf(i));
            this.i.setContentDescription(null);
            this.h = false;
        } else {
            if (w.j(this.i) == 1) {
                w.d(this.i, 0);
            }
            this.h = i > this.g;
            if (z != this.h) {
                a(this.i, this.h ? this.j : this.k);
                if (this.h) {
                    w.d(this.i, 1);
                }
            }
            this.i.setText(getContext().getString(a.i.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.g)));
            this.i.setContentDescription(getContext().getString(a.i.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(this.g)));
        }
        if (this.a == null || z == this.h) {
            return;
        }
        a(false);
        d();
        c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.i.a(r3, r4)     // Catch: java.lang.Exception -> L19
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L19
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L19
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L19
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L19
        L18:
            r0 = 0
        L19:
            if (r0 == 0) goto L2d
            int r4 = com.google.android.material.a.j.TextAppearance_AppCompat_Caption
            androidx.core.widget.i.a(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = com.google.android.material.a.c.design_error
            int r4 = androidx.core.content.a.c(r4, r0)
            r3.setTextColor(r4)
        L2d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.a(android.widget.TextView, int):void");
    }

    private void h() {
        if (this.r == 0 || this.o == null || this.a == null || getRight() == 0) {
            return;
        }
        int left = this.a.getLeft();
        int i = i();
        int right = this.a.getRight();
        int bottom = this.a.getBottom() + this.p;
        if (this.r == 2) {
            left += this.z / 2;
            i -= this.z / 2;
            right -= this.z / 2;
            bottom += this.z / 2;
        }
        this.o.setBounds(left, i, right, bottom);
        n();
        l();
    }

    private int i() {
        if (this.a == null) {
            return 0;
        }
        switch (this.r) {
        }
        return 0;
    }

    private int j() {
        if (!this.l) {
            return 0;
        }
        switch (this.r) {
        }
        return 0;
    }

    private int k() {
        switch (this.r) {
            case 1:
                return getBoxBackground().getBounds().top + this.s;
            case 2:
                return getBoxBackground().getBounds().top - j();
            default:
                return getPaddingTop();
        }
    }

    private void l() {
        Drawable background;
        if (this.a == null || (background = this.a.getBackground()) == null) {
            return;
        }
        if (p.c(background)) {
            background = background.mutate();
        }
        d.b(this, this.a, new Rect());
        Rect bounds = background.getBounds();
        if (bounds.left != bounds.right) {
            Rect rect = new Rect();
            background.getPadding(rect);
            background.setBounds(bounds.left - rect.left, bounds.top, bounds.right + (rect.right * 2), this.a.getBottom());
        }
    }

    private void m() {
        switch (this.r) {
            case 1:
                this.x = 0;
                break;
            case 2:
                if (this.V == 0) {
                    this.V = this.S.getColorForState(getDrawableState(), this.S.getDefaultColor());
                    break;
                }
                break;
        }
    }

    private void n() {
        if (this.o == null) {
            return;
        }
        m();
        if (this.a != null && this.r == 2) {
            if (this.a.getBackground() != null) {
                this.C = this.a.getBackground();
            }
            w.a(this.a, (Drawable) null);
        }
        if (this.a != null && this.r == 1 && this.C != null) {
            w.a(this.a, this.C);
        }
        if (this.x > -1 && this.A != 0) {
            this.o.setStroke(this.x, this.A);
        }
        this.o.setCornerRadii(getCornerRadiiAsArray());
        this.o.setColor(this.B);
        invalidate();
    }

    void c() {
        Drawable background;
        if (this.a == null || (background = this.a.getBackground()) == null) {
            return;
        }
        o();
        if (p.c(background)) {
            background = background.mutate();
        }
        if (this.f.g()) {
            background.setColorFilter(f.a(this.f.j(), PorterDuff.Mode.SRC_IN));
        } else if (this.h && this.i != null) {
            background.setColorFilter(f.a(this.i.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            androidx.core.graphics.drawable.a.f(background);
            this.a.refreshDrawableState();
        }
    }

    private void o() {
        Drawable background;
        int i = Build.VERSION.SDK_INT;
        if ((i != 21 && i != 22) || (background = this.a.getBackground()) == null || this.ad) {
            return;
        }
        Drawable newDrawable = background.getConstantState().newDrawable();
        if (background instanceof DrawableContainer) {
            this.ad = e.a((DrawableContainer) background, newDrawable.getConstantState());
        }
        if (this.ad) {
            return;
        }
        w.a(this.a, newDrawable);
        this.ad = true;
        e();
    }

    /* compiled from: source */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.textfield.TextInputLayout.SavedState.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        CharSequence a;
        boolean b;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.b = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.a, parcel, i);
            parcel.writeInt(this.b ? 1 : 0);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.a) + "}";
        }

        /* compiled from: source */
        /* renamed from: com.google.android.material.textfield.TextInputLayout$SavedState$1 */
        static class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f.g()) {
            savedState.a = getError();
        }
        savedState.b = this.K;
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setError(savedState.a);
        if (savedState.b) {
            b(true);
        }
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.af = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.af = false;
    }

    public CharSequence getError() {
        if (this.f.e()) {
            return this.f.h();
        }
        return null;
    }

    public CharSequence getHelperText() {
        if (this.f.f()) {
            return this.f.i();
        }
        return null;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.ab = z;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.o != null) {
            this.o.draw(canvas);
        }
        super.draw(canvas);
        if (this.l) {
            this.c.a(canvas);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        p();
        super.onMeasure(i, i2);
    }

    private void p() {
        if (this.a == null) {
            return;
        }
        if (r()) {
            if (this.J == null) {
                this.J = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(a.h.design_text_input_password_icon, (ViewGroup) this.d, false);
                this.J.setImageDrawable(this.H);
                this.J.setContentDescription(this.I);
                this.d.addView(this.J);
                this.J.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.textfield.TextInputLayout.2
                    AnonymousClass2() {
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TextInputLayout.this.b(false);
                    }
                });
            }
            if (this.a != null && w.n(this.a) <= 0) {
                this.a.setMinimumHeight(w.n(this.J));
            }
            this.J.setVisibility(0);
            this.J.setChecked(this.K);
            if (this.L == null) {
                this.L = new ColorDrawable();
            }
            this.L.setBounds(0, 0, this.J.getMeasuredWidth(), 1);
            Drawable[] b = i.b(this.a);
            if (b[2] != this.L) {
                this.M = b[2];
            }
            i.a(this.a, b[0], b[1], this.L, b[3]);
            this.J.setPadding(this.a.getPaddingLeft(), this.a.getPaddingTop(), this.a.getPaddingRight(), this.a.getPaddingBottom());
            return;
        }
        if (this.J != null && this.J.getVisibility() == 0) {
            this.J.setVisibility(8);
        }
        if (this.L != null) {
            Drawable[] b2 = i.b(this.a);
            if (b2[2] == this.L) {
                i.a(this.a, b2[0], b2[1], this.M, b2[3]);
                this.L = null;
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.textfield.TextInputLayout$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextInputLayout.this.b(false);
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.H = drawable;
        if (this.J != null) {
            this.J.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.I = charSequence;
        if (this.J != null) {
            this.J.setContentDescription(charSequence);
        }
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.H;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.I;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.G != z) {
            this.G = z;
            if (!z && this.K && this.a != null) {
                this.a.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.K = false;
            p();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.N = colorStateList;
        this.O = true;
        s();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.P = mode;
        this.Q = true;
        s();
    }

    public void b(boolean z) {
        if (this.G) {
            int selectionEnd = this.a.getSelectionEnd();
            if (q()) {
                this.a.setTransformationMethod(null);
                this.K = true;
            } else {
                this.a.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.K = false;
            }
            this.J.setChecked(this.K);
            if (z) {
                this.J.jumpDrawablesToCurrentState();
            }
            this.a.setSelection(selectionEnd);
        }
    }

    public void setTextInputAccessibilityDelegate(a aVar) {
        if (this.a != null) {
            w.a(this.a, aVar);
        }
    }

    private boolean q() {
        return this.a != null && (this.a.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private boolean r() {
        return this.G && (q() || this.K);
    }

    private void s() {
        if (this.H != null) {
            if (this.O || this.Q) {
                this.H = androidx.core.graphics.drawable.a.g(this.H).mutate();
                if (this.O) {
                    androidx.core.graphics.drawable.a.a(this.H, this.N);
                }
                if (this.Q) {
                    androidx.core.graphics.drawable.a.a(this.H, this.P);
                }
                if (this.J == null || this.J.getDrawable() == this.H) {
                    return;
                }
                this.J.setImageDrawable(this.H);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.o != null) {
            h();
        }
        if (!this.l || this.a == null) {
            return;
        }
        Rect rect = this.D;
        d.b(this, this.a, rect);
        int compoundPaddingLeft = rect.left + this.a.getCompoundPaddingLeft();
        int compoundPaddingRight = rect.right - this.a.getCompoundPaddingRight();
        int k = k();
        this.c.a(compoundPaddingLeft, rect.top + this.a.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.a.getCompoundPaddingBottom());
        this.c.b(compoundPaddingLeft, k, compoundPaddingRight, (i4 - i2) - getPaddingBottom());
        this.c.k();
        if (!t() || this.aa) {
            return;
        }
        u();
    }

    private void c(boolean z) {
        if (this.ac != null && this.ac.isRunning()) {
            this.ac.cancel();
        }
        if (z && this.ab) {
            a(1.0f);
        } else {
            this.c.b(1.0f);
        }
        this.aa = false;
        if (t()) {
            u();
        }
    }

    private boolean t() {
        return this.l && !TextUtils.isEmpty(this.m) && (this.o instanceof com.google.android.material.textfield.a);
    }

    private void u() {
        if (t()) {
            RectF rectF = this.E;
            this.c.a(rectF);
            a(rectF);
            ((com.google.android.material.textfield.a) this.o).a(rectF);
        }
    }

    private void v() {
        if (t()) {
            ((com.google.android.material.textfield.a) this.o).b();
        }
    }

    private void a(RectF rectF) {
        rectF.left -= this.q;
        rectF.top -= this.q;
        rectF.right += this.q;
        rectF.bottom += this.q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.ae) {
            return;
        }
        this.ae = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        a(w.C(this) && isEnabled());
        c();
        h();
        d();
        if (this.c != null ? this.c.a(drawableState) | false : false) {
            invalidate();
        }
        this.ae = false;
    }

    void d() {
        if (this.o == null || this.r == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = this.a != null && this.a.hasFocus();
        if (this.a != null && this.a.isHovered()) {
            z = true;
        }
        if (this.r == 2) {
            if (!isEnabled()) {
                this.A = this.W;
            } else if (this.f.g()) {
                this.A = this.f.j();
            } else if (this.h && this.i != null) {
                this.A = this.i.getCurrentTextColor();
            } else if (z2) {
                this.A = this.V;
            } else if (z) {
                this.A = this.U;
            } else {
                this.A = this.T;
            }
            if ((z || z2) && isEnabled()) {
                this.x = this.z;
            } else {
                this.x = this.y;
            }
            n();
        }
    }

    private void d(boolean z) {
        if (this.ac != null && this.ac.isRunning()) {
            this.ac.cancel();
        }
        if (z && this.ab) {
            a(0.0f);
        } else {
            this.c.b(0.0f);
        }
        if (t() && ((com.google.android.material.textfield.a) this.o).a()) {
            v();
        }
        this.aa = true;
    }

    void a(float f) {
        if (this.c.i() == f) {
            return;
        }
        if (this.ac == null) {
            this.ac = new ValueAnimator();
            this.ac.setInterpolator(com.google.android.material.a.a.b);
            this.ac.setDuration(167L);
            this.ac.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.TextInputLayout.3
                AnonymousClass3() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TextInputLayout.this.c.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        this.ac.setFloatValues(this.c.i(), f);
        this.ac.start();
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.textfield.TextInputLayout$3 */
    class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass3() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.c.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.c.j();
    }

    final float getHintCollapsedTextHeight() {
        return this.c.b();
    }

    final int getErrorTextCurrentColor() {
        return this.f.j();
    }

    /* compiled from: source */
    public static class a extends androidx.core.h.a {
        private final TextInputLayout a;

        public a(TextInputLayout textInputLayout) {
            this.a = textInputLayout;
        }

        @Override // androidx.core.h.a
        public void a(View view, androidx.core.h.a.d dVar) {
            super.a(view, dVar);
            EditText editText = this.a.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.a.getHint();
            CharSequence error = this.a.getError();
            CharSequence counterOverflowDescription = this.a.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = false;
            boolean z5 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z) {
                dVar.c(text);
            } else if (z2) {
                dVar.c(hint);
            }
            if (z2) {
                dVar.f(hint);
                if (!z && z2) {
                    z4 = true;
                }
                dVar.o(z4);
            }
            if (z5) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                dVar.g(error);
                dVar.l(true);
            }
        }

        @Override // androidx.core.h.a
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            super.c(view, accessibilityEvent);
            EditText editText = this.a.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            if (TextUtils.isEmpty(text)) {
                text = this.a.getHint();
            }
            if (TextUtils.isEmpty(text)) {
                return;
            }
            accessibilityEvent.getText().add(text);
        }
    }
}
