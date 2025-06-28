package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.a;

/* compiled from: source */
/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private final TextPaint H;
    private ColorStateList I;
    private Layout J;
    private Layout K;
    private TransformationMethod L;
    private final l M;
    private final Rect N;
    float a;
    ObjectAnimator b;
    private Drawable d;
    private ColorStateList e;
    private PorterDuff.Mode f;
    private boolean g;
    private boolean h;
    private Drawable i;
    private ColorStateList j;
    private PorterDuff.Mode k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private CharSequence r;
    private CharSequence s;
    private boolean t;
    private int u;
    private int v;
    private float w;
    private float x;
    private VelocityTracker y;
    private int z;
    private static final Property<SwitchCompat, Float> c = new Property<SwitchCompat, Float>(Float.class, "thumbPos") { // from class: androidx.appcompat.widget.SwitchCompat.1
        AnonymousClass1(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.a);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(SwitchCompat switchCompat, Float f) {
            switchCompat.setThumbPosition(f.floatValue());
        }
    };
    private static final int[] O = {R.attr.state_checked};

    private static float a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.SwitchCompat$1 */
    class AnonymousClass1 extends Property<SwitchCompat, Float> {
        AnonymousClass1(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.a);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(SwitchCompat switchCompat, Float f) {
            switchCompat.setThumbPosition(f.floatValue());
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0001a.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = false;
        this.j = null;
        this.k = null;
        this.l = false;
        this.m = false;
        this.y = VelocityTracker.obtain();
        this.N = new Rect();
        aa.a(this, getContext());
        this.H = new TextPaint(1);
        Resources resources = getResources();
        this.H.density = resources.getDisplayMetrics().density;
        af a = af.a(context, attributeSet, a.j.SwitchCompat, i, 0);
        androidx.core.h.w.a(this, context, a.j.SwitchCompat, attributeSet, a.a(), i, 0);
        this.d = a.a(a.j.SwitchCompat_android_thumb);
        if (this.d != null) {
            this.d.setCallback(this);
        }
        this.i = a.a(a.j.SwitchCompat_track);
        if (this.i != null) {
            this.i.setCallback(this);
        }
        this.r = a.c(a.j.SwitchCompat_android_textOn);
        this.s = a.c(a.j.SwitchCompat_android_textOff);
        this.t = a.a(a.j.SwitchCompat_showText, true);
        this.n = a.e(a.j.SwitchCompat_thumbTextPadding, 0);
        this.o = a.e(a.j.SwitchCompat_switchMinWidth, 0);
        this.p = a.e(a.j.SwitchCompat_switchPadding, 0);
        this.q = a.a(a.j.SwitchCompat_splitTrack, false);
        ColorStateList e = a.e(a.j.SwitchCompat_thumbTint);
        if (e != null) {
            this.e = e;
            this.g = true;
        }
        PorterDuff.Mode a2 = p.a(a.a(a.j.SwitchCompat_thumbTintMode, -1), null);
        if (this.f != a2) {
            this.f = a2;
            this.h = true;
        }
        if (this.g || this.h) {
            b();
        }
        ColorStateList e2 = a.e(a.j.SwitchCompat_trackTint);
        if (e2 != null) {
            this.j = e2;
            this.l = true;
        }
        PorterDuff.Mode a3 = p.a(a.a(a.j.SwitchCompat_trackTintMode, -1), null);
        if (this.k != a3) {
            this.k = a3;
            this.m = true;
        }
        if (this.l || this.m) {
            a();
        }
        int g = a.g(a.j.SwitchCompat_switchTextAppearance, 0);
        if (g != 0) {
            a(context, g);
        }
        this.M = new l(this);
        this.M.a(attributeSet, i);
        a.b();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.v = viewConfiguration.getScaledTouchSlop();
        this.z = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void a(Context context, int i) {
        af a = af.a(context, i, a.j.TextAppearance);
        ColorStateList e = a.e(a.j.TextAppearance_android_textColor);
        if (e != null) {
            this.I = e;
        } else {
            this.I = getTextColors();
        }
        int e2 = a.e(a.j.TextAppearance_android_textSize, 0);
        if (e2 != 0) {
            float f = e2;
            if (f != this.H.getTextSize()) {
                this.H.setTextSize(f);
                requestLayout();
            }
        }
        a(a.a(a.j.TextAppearance_android_typeface, -1), a.a(a.j.TextAppearance_android_textStyle, -1));
        if (a.a(a.j.TextAppearance_textAllCaps, false)) {
            this.L = new androidx.appcompat.d.a(getContext());
        } else {
            this.L = null;
        }
        a.b();
    }

    private void a(int i, int i2) {
        Typeface typeface;
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
            default:
                typeface = null;
                break;
        }
        a(typeface, i2);
    }

    public void a(Typeface typeface, int i) {
        Typeface create;
        if (i > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i);
            } else {
                create = Typeface.create(typeface, i);
            }
            setSwitchTypeface(create);
            int i2 = (~(create != null ? create.getStyle() : 0)) & i;
            this.H.setFakeBoldText((i2 & 1) != 0);
            this.H.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.H.setFakeBoldText(false);
        this.H.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.H.getTypeface() == null || this.H.getTypeface().equals(typeface)) && (this.H.getTypeface() != null || typeface == null)) {
            return;
        }
        this.H.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setSwitchPadding(int i) {
        this.p = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.p;
    }

    public void setSwitchMinWidth(int i) {
        this.o = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.o;
    }

    public void setThumbTextPadding(int i) {
        this.n = i;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.n;
    }

    public void setTrackDrawable(Drawable drawable) {
        if (this.i != null) {
            this.i.setCallback(null);
        }
        this.i = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public Drawable getTrackDrawable() {
        return this.i;
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.l = true;
        a();
    }

    public ColorStateList getTrackTintList() {
        return this.j;
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.k = mode;
        this.m = true;
        a();
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.k;
    }

    private void a() {
        if (this.i != null) {
            if (this.l || this.m) {
                this.i = androidx.core.graphics.drawable.a.g(this.i).mutate();
                if (this.l) {
                    androidx.core.graphics.drawable.a.a(this.i, this.j);
                }
                if (this.m) {
                    androidx.core.graphics.drawable.a.a(this.i, this.k);
                }
                if (this.i.isStateful()) {
                    this.i.setState(getDrawableState());
                }
            }
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        if (this.d != null) {
            this.d.setCallback(null);
        }
        this.d = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public Drawable getThumbDrawable() {
        return this.d;
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.e = colorStateList;
        this.g = true;
        b();
    }

    public ColorStateList getThumbTintList() {
        return this.e;
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f = mode;
        this.h = true;
        b();
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f;
    }

    private void b() {
        if (this.d != null) {
            if (this.g || this.h) {
                this.d = androidx.core.graphics.drawable.a.g(this.d).mutate();
                if (this.g) {
                    androidx.core.graphics.drawable.a.a(this.d, this.e);
                }
                if (this.h) {
                    androidx.core.graphics.drawable.a.a(this.d, this.f);
                }
                if (this.d.isStateful()) {
                    this.d.setState(getDrawableState());
                }
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.q = z;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.q;
    }

    public CharSequence getTextOn() {
        return this.r;
    }

    public void setTextOn(CharSequence charSequence) {
        this.r = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.s;
    }

    public void setTextOff(CharSequence charSequence) {
        this.s = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z) {
        if (this.t != z) {
            this.t = z;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.t;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (this.t) {
            if (this.J == null) {
                this.J = a(this.r);
            }
            if (this.K == null) {
                this.K = a(this.s);
            }
        }
        Rect rect = this.N;
        int i5 = 0;
        if (this.d != null) {
            this.d.getPadding(rect);
            i3 = (this.d.getIntrinsicWidth() - rect.left) - rect.right;
            i4 = this.d.getIntrinsicHeight();
        } else {
            i3 = 0;
            i4 = 0;
        }
        this.C = Math.max(this.t ? Math.max(this.J.getWidth(), this.K.getWidth()) + (this.n * 2) : 0, i3);
        if (this.i != null) {
            this.i.getPadding(rect);
            i5 = this.i.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i6 = rect.left;
        int i7 = rect.right;
        if (this.d != null) {
            Rect a = p.a(this.d);
            i6 = Math.max(i6, a.left);
            i7 = Math.max(i7, a.right);
        }
        int max = Math.max(this.o, (2 * this.C) + i6 + i7);
        int max2 = Math.max(i5, i4);
        this.A = max;
        this.B = max2;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.r : this.s;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    private Layout a(CharSequence charSequence) {
        if (this.L != null) {
            charSequence = this.L.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        return new StaticLayout(charSequence2, this.H, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, this.H)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private boolean a(float f, float f2) {
        if (this.d == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.d.getPadding(this.N);
        int i = this.E - this.v;
        int i2 = (this.D + thumbOffset) - this.v;
        return f > ((float) i2) && f < ((float) ((((this.C + i2) + this.N.left) + this.N.right) + this.v)) && f2 > ((float) i) && f2 < ((float) (this.G + this.v));
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.y.addMovement(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (isEnabled() && a(x, y)) {
                    this.u = 1;
                    this.w = x;
                    this.x = y;
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.u == 2) {
                    b(motionEvent);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                this.u = 0;
                this.y.clear();
                break;
            case 2:
                switch (this.u) {
                    case 1:
                        float x2 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (Math.abs(x2 - this.w) > this.v || Math.abs(y2 - this.x) > this.v) {
                            this.u = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.w = x2;
                            this.x = y2;
                            return true;
                        }
                        break;
                    case 2:
                        float x3 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f = x3 - this.w;
                        float f2 = thumbScrollRange != 0 ? f / thumbScrollRange : f > 0.0f ? 1.0f : -1.0f;
                        if (al.a(this)) {
                            f2 = -f2;
                        }
                        float a = a(this.a + f2, 0.0f, 1.0f);
                        if (a != this.a) {
                            this.w = x3;
                            setThumbPosition(a);
                        }
                        return true;
                }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void b(MotionEvent motionEvent) {
        boolean z;
        this.u = 0;
        boolean z2 = true;
        boolean z3 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z3) {
            this.y.computeCurrentVelocity(1000);
            float xVelocity = this.y.getXVelocity();
            if (Math.abs(xVelocity) > this.z) {
                if (!al.a(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                    z2 = false;
                }
                z = z2;
            } else {
                z = getTargetCheckedState();
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        a(motionEvent);
    }

    private void a(boolean z) {
        this.b = ObjectAnimator.ofFloat(this, c, z ? 1.0f : 0.0f);
        this.b.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.b.setAutoCancel(true);
        }
        this.b.start();
    }

    private void c() {
        if (this.b != null) {
            this.b.cancel();
        }
    }

    private boolean getTargetCheckedState() {
        return this.a > 0.5f;
    }

    void setThumbPosition(float f) {
        this.a = f;
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() != null && androidx.core.h.w.C(this)) {
            a(isChecked);
        } else {
            c();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int width;
        int i6;
        int paddingTop;
        int i7;
        super.onLayout(z, i, i2, i3, i4);
        int i8 = 0;
        if (this.d != null) {
            Rect rect = this.N;
            if (this.i != null) {
                this.i.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect a = p.a(this.d);
            int max = Math.max(0, a.left - rect.left);
            i5 = Math.max(0, a.right - rect.right);
            i8 = max;
        } else {
            i5 = 0;
        }
        if (al.a(this)) {
            i6 = getPaddingLeft() + i8;
            width = ((this.A + i6) - i8) - i5;
        } else {
            width = (getWidth() - getPaddingRight()) - i5;
            i6 = (width - this.A) + i8 + i5;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.B / 2);
            i7 = this.B + paddingTop;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            i7 = this.B + paddingTop;
        } else {
            i7 = getHeight() - getPaddingBottom();
            paddingTop = i7 - this.B;
        }
        this.D = i6;
        this.E = paddingTop;
        this.G = i7;
        this.F = width;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect;
        int i;
        int i2;
        Rect rect2 = this.N;
        int i3 = this.D;
        int i4 = this.E;
        int i5 = this.F;
        int i6 = this.G;
        int thumbOffset = getThumbOffset() + i3;
        if (this.d != null) {
            rect = p.a(this.d);
        } else {
            rect = p.a;
        }
        if (this.i != null) {
            this.i.getPadding(rect2);
            thumbOffset += rect2.left;
            if (rect != null) {
                if (rect.left > rect2.left) {
                    i3 += rect.left - rect2.left;
                }
                i = rect.top > rect2.top ? (rect.top - rect2.top) + i4 : i4;
                if (rect.right > rect2.right) {
                    i5 -= rect.right - rect2.right;
                }
                if (rect.bottom > rect2.bottom) {
                    i2 = i6 - (rect.bottom - rect2.bottom);
                    this.i.setBounds(i3, i, i5, i2);
                }
            } else {
                i = i4;
            }
            i2 = i6;
            this.i.setBounds(i3, i, i5, i2);
        }
        if (this.d != null) {
            this.d.getPadding(rect2);
            int i7 = thumbOffset - rect2.left;
            int i8 = thumbOffset + this.C + rect2.right;
            this.d.setBounds(i7, i4, i8, i6);
            Drawable background = getBackground();
            if (background != null) {
                androidx.core.graphics.drawable.a.a(background, i7, i4, i8, i6);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.N;
        Drawable drawable = this.i;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.E;
        int i2 = this.G;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.d;
        if (drawable != null) {
            if (this.q && drawable2 != null) {
                Rect a = p.a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += a.left;
                rect.right -= a.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            } else {
                drawable.draw(canvas);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.J : this.K;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            if (this.I != null) {
                this.H.setColor(this.I.getColorForState(drawableState, 0));
            }
            this.H.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i3 + i4) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!al.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.p : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (al.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.p : compoundPaddingRight;
    }

    private int getThumbOffset() {
        float f;
        if (al.a(this)) {
            f = 1.0f - this.a;
        } else {
            f = this.a;
        }
        return (int) ((f * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        if (this.i == null) {
            return 0;
        }
        Rect rect2 = this.N;
        this.i.getPadding(rect2);
        if (this.d != null) {
            rect = p.a(this.d);
        } else {
            rect = p.a;
        }
        return ((((this.A - this.C) - rect2.left) - rect2.right) - rect.left) - rect.right;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, O);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.d;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.i;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.d != null) {
            androidx.core.graphics.drawable.a.a(this.d, f, f2);
        }
        if (this.i != null) {
            androidx.core.graphics.drawable.a.a(this.i, f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.d || drawable == this.i;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.d != null) {
            this.d.jumpToCurrentState();
        }
        if (this.i != null) {
            this.i.jumpToCurrentState();
        }
        if (this.b == null || !this.b.isStarted()) {
            return;
        }
        this.b.end();
        this.b = null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.r : this.s;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (TextUtils.isEmpty(text)) {
            accessibilityNodeInfo.setText(charSequence);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.append(' ');
        sb.append(charSequence);
        accessibilityNodeInfo.setText(sb);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.a(this, callback));
    }
}
