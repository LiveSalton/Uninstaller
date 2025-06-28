package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.a.f;
import androidx.core.graphics.drawable.b;
import com.google.android.material.a;
import com.google.android.material.a.h;
import com.google.android.material.internal.k;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public class a extends Drawable implements Drawable.Callback, b {
    private static final int[] a = {R.attr.state_enabled};
    private float A;
    private float B;
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private final Context H;
    private final Paint K;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private int T;
    private ColorFilter V;
    private PorterDuffColorFilter W;
    private ColorStateList X;
    private int[] Z;
    private boolean aa;
    private ColorStateList ab;
    private float ae;
    private TextUtils.TruncateAt af;
    private boolean ag;
    private int ah;
    private ColorStateList b;
    private float c;
    private float d;
    private ColorStateList e;
    private float f;
    private ColorStateList g;
    private CharSequence i;
    private com.google.android.material.f.b j;
    private boolean l;
    private Drawable m;
    private ColorStateList n;
    private float o;
    private boolean p;
    private Drawable q;
    private ColorStateList r;
    private float s;
    private CharSequence t;
    private boolean u;
    private boolean v;
    private Drawable w;
    private h x;
    private h y;
    private float z;
    private final f.a k = new f.a() { // from class: com.google.android.material.chip.a.1
        @Override // androidx.core.content.a.f.a
        public void a(int i) {
        }

        AnonymousClass1() {
        }

        @Override // androidx.core.content.a.f.a
        public void a(Typeface typeface) {
            a.this.ad = true;
            a.this.a();
            a.this.invalidateSelf();
        }
    };
    private final TextPaint I = new TextPaint(1);
    private final Paint J = new Paint(1);
    private final Paint.FontMetrics L = new Paint.FontMetrics();
    private final RectF M = new RectF();
    private final PointF N = new PointF();
    private int U = 255;
    private PorterDuff.Mode Y = PorterDuff.Mode.SRC_IN;
    private WeakReference<InterfaceC0080a> ac = new WeakReference<>(null);
    private boolean ad = true;
    private CharSequence h = "";

    /* compiled from: source */
    /* renamed from: com.google.android.material.chip.a$a */
    public interface InterfaceC0080a {
        void a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.chip.a$1 */
    class AnonymousClass1 extends f.a {
        @Override // androidx.core.content.a.f.a
        public void a(int i) {
        }

        AnonymousClass1() {
        }

        @Override // androidx.core.content.a.f.a
        public void a(Typeface typeface) {
            a.this.ad = true;
            a.this.a();
            a.this.invalidateSelf();
        }
    }

    public static a a(Context context, AttributeSet attributeSet, int i, int i2) {
        a aVar = new a(context);
        aVar.a(attributeSet, i, i2);
        return aVar;
    }

    private a(Context context) {
        this.H = context;
        this.I.density = context.getResources().getDisplayMetrics().density;
        this.K = null;
        if (this.K != null) {
            this.K.setStyle(Paint.Style.STROKE);
        }
        setState(a);
        a(a);
        this.ag = true;
    }

    private void a(AttributeSet attributeSet, int i, int i2) {
        TypedArray a2 = k.a(this.H, attributeSet, a.k.Chip, i, i2, new int[0]);
        a(com.google.android.material.f.a.a(this.H, a2, a.k.Chip_chipBackgroundColor));
        a(a2.getDimension(a.k.Chip_chipMinHeight, 0.0f));
        b(a2.getDimension(a.k.Chip_chipCornerRadius, 0.0f));
        b(com.google.android.material.f.a.a(this.H, a2, a.k.Chip_chipStrokeColor));
        c(a2.getDimension(a.k.Chip_chipStrokeWidth, 0.0f));
        c(com.google.android.material.f.a.a(this.H, a2, a.k.Chip_rippleColor));
        a(a2.getText(a.k.Chip_android_text));
        a(com.google.android.material.f.a.c(this.H, a2, a.k.Chip_android_textAppearance));
        switch (a2.getInt(a.k.Chip_android_ellipsize, 0)) {
            case 1:
                a(TextUtils.TruncateAt.START);
                break;
            case 2:
                a(TextUtils.TruncateAt.MIDDLE);
                break;
            case 3:
                a(TextUtils.TruncateAt.END);
                break;
        }
        b(a2.getBoolean(a.k.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            b(a2.getBoolean(a.k.Chip_chipIconEnabled, false));
        }
        a(com.google.android.material.f.a.b(this.H, a2, a.k.Chip_chipIcon));
        d(com.google.android.material.f.a.a(this.H, a2, a.k.Chip_chipIconTint));
        d(a2.getDimension(a.k.Chip_chipIconSize, 0.0f));
        c(a2.getBoolean(a.k.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            c(a2.getBoolean(a.k.Chip_closeIconEnabled, false));
        }
        b(com.google.android.material.f.a.b(this.H, a2, a.k.Chip_closeIcon));
        e(com.google.android.material.f.a.a(this.H, a2, a.k.Chip_closeIconTint));
        e(a2.getDimension(a.k.Chip_closeIconSize, 0.0f));
        d(a2.getBoolean(a.k.Chip_android_checkable, false));
        e(a2.getBoolean(a.k.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            e(a2.getBoolean(a.k.Chip_checkedIconEnabled, false));
        }
        c(com.google.android.material.f.a.b(this.H, a2, a.k.Chip_checkedIcon));
        a(h.a(this.H, a2, a.k.Chip_showMotionSpec));
        b(h.a(this.H, a2, a.k.Chip_hideMotionSpec));
        f(a2.getDimension(a.k.Chip_chipStartPadding, 0.0f));
        g(a2.getDimension(a.k.Chip_iconStartPadding, 0.0f));
        h(a2.getDimension(a.k.Chip_iconEndPadding, 0.0f));
        i(a2.getDimension(a.k.Chip_textStartPadding, 0.0f));
        j(a2.getDimension(a.k.Chip_textEndPadding, 0.0f));
        k(a2.getDimension(a.k.Chip_closeIconStartPadding, 0.0f));
        l(a2.getDimension(a.k.Chip_closeIconEndPadding, 0.0f));
        m(a2.getDimension(a.k.Chip_chipEndPadding, 0.0f));
        C(a2.getDimensionPixelSize(a.k.Chip_android_maxWidth, Integer.MAX_VALUE));
        a2.recycle();
    }

    public void a(boolean z) {
        if (this.aa != z) {
            this.aa = z;
            S();
            onStateChange(getState());
        }
    }

    public void a(InterfaceC0080a interfaceC0080a) {
        this.ac = new WeakReference<>(interfaceC0080a);
    }

    protected void a() {
        InterfaceC0080a interfaceC0080a = this.ac.get();
        if (interfaceC0080a != null) {
            interfaceC0080a.a();
        }
    }

    public void a(RectF rectF) {
        e(getBounds(), rectF);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.z + b() + this.C + O() + this.D + P() + this.G), this.ah);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.c;
    }

    private boolean K() {
        return this.l && this.m != null;
    }

    private boolean L() {
        return this.v && this.w != null && this.S;
    }

    private boolean M() {
        return this.p && this.q != null;
    }

    private boolean N() {
        return this.v && this.w != null && this.u;
    }

    float b() {
        if (K() || L()) {
            return this.A + this.o + this.B;
        }
        return 0.0f;
    }

    private float O() {
        if (!this.ad) {
            return this.ae;
        }
        this.ae = c(this.i);
        this.ad = false;
        return this.ae;
    }

    private float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.I.measureText(charSequence, 0, charSequence.length());
    }

    private float P() {
        if (M()) {
            return this.E + this.s + this.F;
        }
        return 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int a2 = this.U < 255 ? com.google.android.material.b.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, this.U) : 0;
        a(canvas, bounds);
        b(canvas, bounds);
        c(canvas, bounds);
        d(canvas, bounds);
        e(canvas, bounds);
        if (this.ag) {
            f(canvas, bounds);
        }
        g(canvas, bounds);
        h(canvas, bounds);
        if (this.U < 255) {
            canvas.restoreToCount(a2);
        }
    }

    private void a(Canvas canvas, Rect rect) {
        this.J.setColor(this.O);
        this.J.setStyle(Paint.Style.FILL);
        this.J.setColorFilter(R());
        this.M.set(rect);
        canvas.drawRoundRect(this.M, this.d, this.d, this.J);
    }

    private void b(Canvas canvas, Rect rect) {
        if (this.f > 0.0f) {
            this.J.setColor(this.P);
            this.J.setStyle(Paint.Style.STROKE);
            this.J.setColorFilter(R());
            this.M.set(rect.left + (this.f / 2.0f), rect.top + (this.f / 2.0f), rect.right - (this.f / 2.0f), rect.bottom - (this.f / 2.0f));
            float f = this.d - (this.f / 2.0f);
            canvas.drawRoundRect(this.M, f, f, this.J);
        }
    }

    private void c(Canvas canvas, Rect rect) {
        this.J.setColor(this.Q);
        this.J.setStyle(Paint.Style.FILL);
        this.M.set(rect);
        canvas.drawRoundRect(this.M, this.d, this.d, this.J);
    }

    private void d(Canvas canvas, Rect rect) {
        if (K()) {
            a(rect, this.M);
            float f = this.M.left;
            float f2 = this.M.top;
            canvas.translate(f, f2);
            this.m.setBounds(0, 0, (int) this.M.width(), (int) this.M.height());
            this.m.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void e(Canvas canvas, Rect rect) {
        if (L()) {
            a(rect, this.M);
            float f = this.M.left;
            float f2 = this.M.top;
            canvas.translate(f, f2);
            this.w.setBounds(0, 0, (int) this.M.width(), (int) this.M.height());
            this.w.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void f(Canvas canvas, Rect rect) {
        if (this.i != null) {
            Paint.Align a2 = a(rect, this.N);
            b(rect, this.M);
            if (this.j != null) {
                this.I.drawableState = getState();
                this.j.b(this.H, this.I, this.k);
            }
            this.I.setTextAlign(a2);
            int i = 0;
            boolean z = Math.round(O()) > Math.round(this.M.width());
            if (z) {
                i = canvas.save();
                canvas.clipRect(this.M);
            }
            CharSequence charSequence = this.i;
            if (z && this.af != null) {
                charSequence = TextUtils.ellipsize(this.i, this.I, this.M.width(), this.af);
            }
            CharSequence charSequence2 = charSequence;
            canvas.drawText(charSequence2, 0, charSequence2.length(), this.N.x, this.N.y, this.I);
            if (z) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void g(Canvas canvas, Rect rect) {
        if (M()) {
            c(rect, this.M);
            float f = this.M.left;
            float f2 = this.M.top;
            canvas.translate(f, f2);
            this.q.setBounds(0, 0, (int) this.M.width(), (int) this.M.height());
            this.q.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void h(Canvas canvas, Rect rect) {
        if (this.K != null) {
            this.K.setColor(androidx.core.graphics.a.b(-16777216, 127));
            canvas.drawRect(rect, this.K);
            if (K() || L()) {
                a(rect, this.M);
                canvas.drawRect(this.M, this.K);
            }
            if (this.i != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.K);
            }
            if (M()) {
                c(rect, this.M);
                canvas.drawRect(this.M, this.K);
            }
            this.K.setColor(androidx.core.graphics.a.b(-65536, 127));
            d(rect, this.M);
            canvas.drawRect(this.M, this.K);
            this.K.setColor(androidx.core.graphics.a.b(-16711936, 127));
            e(rect, this.M);
            canvas.drawRect(this.M, this.K);
        }
    }

    private void a(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (K() || L()) {
            float f = this.z + this.A;
            if (androidx.core.graphics.drawable.a.i(this) == 0) {
                rectF.left = rect.left + f;
                rectF.right = rectF.left + this.o;
            } else {
                rectF.right = rect.right - f;
                rectF.left = rectF.right - this.o;
            }
            rectF.top = rect.exactCenterY() - (this.o / 2.0f);
            rectF.bottom = rectF.top + this.o;
        }
    }

    Paint.Align a(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.i != null) {
            float b = this.z + b() + this.C;
            if (androidx.core.graphics.drawable.a.i(this) == 0) {
                pointF.x = rect.left + b;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - b;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - Q();
        }
        return align;
    }

    private float Q() {
        this.I.getFontMetrics(this.L);
        return (this.L.descent + this.L.ascent) / 2.0f;
    }

    private void b(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.i != null) {
            float b = this.z + b() + this.C;
            float P = this.G + P() + this.D;
            if (androidx.core.graphics.drawable.a.i(this) == 0) {
                rectF.left = rect.left + b;
                rectF.right = rect.right - P;
            } else {
                rectF.left = rect.left + P;
                rectF.right = rect.right - b;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void c(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (M()) {
            float f = this.G + this.F;
            if (androidx.core.graphics.drawable.a.i(this) == 0) {
                rectF.right = rect.right - f;
                rectF.left = rectF.right - this.s;
            } else {
                rectF.left = rect.left + f;
                rectF.right = rectF.left + this.s;
            }
            rectF.top = rect.exactCenterY() - (this.s / 2.0f);
            rectF.bottom = rectF.top + this.s;
        }
    }

    private void d(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (M()) {
            float f = this.G + this.F + this.s + this.E + this.D;
            if (androidx.core.graphics.drawable.a.i(this) == 0) {
                rectF.right = rect.right - f;
            } else {
                rectF.left = rect.left + f;
            }
        }
    }

    private void e(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (M()) {
            float f = this.G + this.F + this.s + this.E + this.D;
            if (androidx.core.graphics.drawable.a.i(this) == 0) {
                rectF.right = rect.right;
                rectF.left = rectF.right - f;
            } else {
                rectF.left = rect.left;
                rectF.right = rect.left + f;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return f(this.b) || f(this.e) || (this.aa && f(this.ab)) || b(this.j) || N() || d(this.m) || d(this.w) || f(this.X);
    }

    public boolean c() {
        return d(this.q);
    }

    public boolean a(int[] iArr) {
        if (Arrays.equals(this.Z, iArr)) {
            return false;
        }
        this.Z = iArr;
        if (M()) {
            return a(getState(), iArr);
        }
        return false;
    }

    public int[] d() {
        return this.Z;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return a(iArr, d());
    }

    private boolean a(int[] iArr, int[] iArr2) {
        boolean z;
        boolean onStateChange = super.onStateChange(iArr);
        int colorForState = this.b != null ? this.b.getColorForState(iArr, this.O) : 0;
        if (this.O != colorForState) {
            this.O = colorForState;
            onStateChange = true;
        }
        int colorForState2 = this.e != null ? this.e.getColorForState(iArr, this.P) : 0;
        if (this.P != colorForState2) {
            this.P = colorForState2;
            onStateChange = true;
        }
        int colorForState3 = this.ab != null ? this.ab.getColorForState(iArr, this.Q) : 0;
        if (this.Q != colorForState3) {
            this.Q = colorForState3;
            if (this.aa) {
                onStateChange = true;
            }
        }
        int colorForState4 = (this.j == null || this.j.b == null) ? 0 : this.j.b.getColorForState(iArr, this.R);
        if (this.R != colorForState4) {
            this.R = colorForState4;
            onStateChange = true;
        }
        boolean z2 = a(getState(), R.attr.state_checked) && this.u;
        if (this.S == z2 || this.w == null) {
            z = false;
        } else {
            float b = b();
            this.S = z2;
            if (b != b()) {
                onStateChange = true;
                z = true;
            } else {
                z = false;
                onStateChange = true;
            }
        }
        int colorForState5 = this.X != null ? this.X.getColorForState(iArr, this.T) : 0;
        if (this.T != colorForState5) {
            this.T = colorForState5;
            this.W = com.google.android.material.c.a.a(this, this.X, this.Y);
            onStateChange = true;
        }
        if (d(this.m)) {
            onStateChange |= this.m.setState(iArr);
        }
        if (d(this.w)) {
            onStateChange |= this.w.setState(iArr);
        }
        if (d(this.q)) {
            onStateChange |= this.q.setState(iArr2);
        }
        if (onStateChange) {
            invalidateSelf();
        }
        if (z) {
            a();
        }
        return onStateChange;
    }

    private static boolean f(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private static boolean d(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean b(com.google.android.material.f.b bVar) {
        return (bVar == null || bVar.b == null || !bVar.b.isStateful()) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(23)
    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (K()) {
            onLayoutDirectionChanged |= this.m.setLayoutDirection(i);
        }
        if (L()) {
            onLayoutDirectionChanged |= this.w.setLayoutDirection(i);
        }
        if (M()) {
            onLayoutDirectionChanged |= this.q.setLayoutDirection(i);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (K()) {
            onLevelChange |= this.m.setLevel(i);
        }
        if (L()) {
            onLevelChange |= this.w.setLevel(i);
        }
        if (M()) {
            onLevelChange |= this.q.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (K()) {
            visible |= this.m.setVisible(z, z2);
        }
        if (L()) {
            visible |= this.w.setVisible(z, z2);
        }
        if (M()) {
            visible |= this.q.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.U != i) {
            this.U = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.U;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.V != colorFilter) {
            this.V = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.V;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        if (this.X != colorStateList) {
            this.X = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.Y != mode) {
            this.Y = mode;
            this.W = com.google.android.material.c.a.a(this, this.X, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.d);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.d);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    private void e(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void f(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            androidx.core.graphics.drawable.a.b(drawable, androidx.core.graphics.drawable.a.i(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.q) {
                if (drawable.isStateful()) {
                    drawable.setState(d());
                }
                androidx.core.graphics.drawable.a.a(drawable, this.r);
            } else if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }

    private ColorFilter R() {
        return this.V != null ? this.V : this.W;
    }

    private void S() {
        this.ab = this.aa ? com.google.android.material.g.a.a(this.g) : null;
    }

    private static boolean a(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public ColorStateList e() {
        return this.b;
    }

    public void a(int i) {
        a(androidx.appcompat.a.a.a.a(this.H, i));
    }

    public void a(ColorStateList colorStateList) {
        if (this.b != colorStateList) {
            this.b = colorStateList;
            onStateChange(getState());
        }
    }

    public float f() {
        return this.c;
    }

    public void b(int i) {
        a(this.H.getResources().getDimension(i));
    }

    public void a(float f) {
        if (this.c != f) {
            this.c = f;
            invalidateSelf();
            a();
        }
    }

    public float g() {
        return this.d;
    }

    public void c(int i) {
        b(this.H.getResources().getDimension(i));
    }

    public void b(float f) {
        if (this.d != f) {
            this.d = f;
            invalidateSelf();
        }
    }

    public ColorStateList h() {
        return this.e;
    }

    public void d(int i) {
        b(androidx.appcompat.a.a.a.a(this.H, i));
    }

    public void b(ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            onStateChange(getState());
        }
    }

    public float i() {
        return this.f;
    }

    public void e(int i) {
        c(this.H.getResources().getDimension(i));
    }

    public void c(float f) {
        if (this.f != f) {
            this.f = f;
            this.J.setStrokeWidth(f);
            invalidateSelf();
        }
    }

    public ColorStateList j() {
        return this.g;
    }

    public void f(int i) {
        c(androidx.appcompat.a.a.a.a(this.H, i));
    }

    public void c(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            S();
            onStateChange(getState());
        }
    }

    public CharSequence k() {
        return this.h;
    }

    public void a(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (this.h != charSequence) {
            this.h = charSequence;
            this.i = androidx.core.f.a.a().a(charSequence);
            this.ad = true;
            invalidateSelf();
            a();
        }
    }

    public com.google.android.material.f.b l() {
        return this.j;
    }

    public void g(int i) {
        a(new com.google.android.material.f.b(this.H, i));
    }

    public void a(com.google.android.material.f.b bVar) {
        if (this.j != bVar) {
            this.j = bVar;
            if (bVar != null) {
                bVar.c(this.H, this.I, this.k);
                this.ad = true;
            }
            onStateChange(getState());
            a();
        }
    }

    public TextUtils.TruncateAt m() {
        return this.af;
    }

    public void a(TextUtils.TruncateAt truncateAt) {
        this.af = truncateAt;
    }

    public boolean n() {
        return this.l;
    }

    public void h(int i) {
        b(this.H.getResources().getBoolean(i));
    }

    public void b(boolean z) {
        if (this.l != z) {
            boolean K = K();
            this.l = z;
            boolean K2 = K();
            if (K != K2) {
                if (K2) {
                    f(this.m);
                } else {
                    e(this.m);
                }
                invalidateSelf();
                a();
            }
        }
    }

    public Drawable o() {
        if (this.m != null) {
            return androidx.core.graphics.drawable.a.h(this.m);
        }
        return null;
    }

    public void i(int i) {
        a(androidx.appcompat.a.a.a.b(this.H, i));
    }

    public void a(Drawable drawable) {
        Drawable o = o();
        if (o != drawable) {
            float b = b();
            this.m = drawable != null ? androidx.core.graphics.drawable.a.g(drawable).mutate() : null;
            float b2 = b();
            e(o);
            if (K()) {
                f(this.m);
            }
            invalidateSelf();
            if (b != b2) {
                a();
            }
        }
    }

    public ColorStateList p() {
        return this.n;
    }

    public void j(int i) {
        d(androidx.appcompat.a.a.a.a(this.H, i));
    }

    public void d(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            if (K()) {
                androidx.core.graphics.drawable.a.a(this.m, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float q() {
        return this.o;
    }

    public void k(int i) {
        d(this.H.getResources().getDimension(i));
    }

    public void d(float f) {
        if (this.o != f) {
            float b = b();
            this.o = f;
            float b2 = b();
            invalidateSelf();
            if (b != b2) {
                a();
            }
        }
    }

    public boolean r() {
        return this.p;
    }

    public void l(int i) {
        c(this.H.getResources().getBoolean(i));
    }

    public void c(boolean z) {
        if (this.p != z) {
            boolean M = M();
            this.p = z;
            boolean M2 = M();
            if (M != M2) {
                if (M2) {
                    f(this.q);
                } else {
                    e(this.q);
                }
                invalidateSelf();
                a();
            }
        }
    }

    public Drawable s() {
        if (this.q != null) {
            return androidx.core.graphics.drawable.a.h(this.q);
        }
        return null;
    }

    public void m(int i) {
        b(androidx.appcompat.a.a.a.b(this.H, i));
    }

    public void b(Drawable drawable) {
        Drawable s = s();
        if (s != drawable) {
            float P = P();
            this.q = drawable != null ? androidx.core.graphics.drawable.a.g(drawable).mutate() : null;
            float P2 = P();
            e(s);
            if (M()) {
                f(this.q);
            }
            invalidateSelf();
            if (P != P2) {
                a();
            }
        }
    }

    public ColorStateList t() {
        return this.r;
    }

    public void n(int i) {
        e(androidx.appcompat.a.a.a.a(this.H, i));
    }

    public void e(ColorStateList colorStateList) {
        if (this.r != colorStateList) {
            this.r = colorStateList;
            if (M()) {
                androidx.core.graphics.drawable.a.a(this.q, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float u() {
        return this.s;
    }

    public void o(int i) {
        e(this.H.getResources().getDimension(i));
    }

    public void e(float f) {
        if (this.s != f) {
            this.s = f;
            invalidateSelf();
            if (M()) {
                a();
            }
        }
    }

    public void b(CharSequence charSequence) {
        if (this.t != charSequence) {
            this.t = androidx.core.f.a.a().a(charSequence);
            invalidateSelf();
        }
    }

    public CharSequence v() {
        return this.t;
    }

    public boolean w() {
        return this.u;
    }

    public void p(int i) {
        d(this.H.getResources().getBoolean(i));
    }

    public void d(boolean z) {
        if (this.u != z) {
            this.u = z;
            float b = b();
            if (!z && this.S) {
                this.S = false;
            }
            float b2 = b();
            invalidateSelf();
            if (b != b2) {
                a();
            }
        }
    }

    public boolean x() {
        return this.v;
    }

    public void q(int i) {
        e(this.H.getResources().getBoolean(i));
    }

    public void e(boolean z) {
        if (this.v != z) {
            boolean L = L();
            this.v = z;
            boolean L2 = L();
            if (L != L2) {
                if (L2) {
                    f(this.w);
                } else {
                    e(this.w);
                }
                invalidateSelf();
                a();
            }
        }
    }

    public Drawable y() {
        return this.w;
    }

    public void r(int i) {
        c(androidx.appcompat.a.a.a.b(this.H, i));
    }

    public void c(Drawable drawable) {
        if (this.w != drawable) {
            float b = b();
            this.w = drawable;
            float b2 = b();
            e(this.w);
            f(this.w);
            invalidateSelf();
            if (b != b2) {
                a();
            }
        }
    }

    public h z() {
        return this.x;
    }

    public void s(int i) {
        a(h.a(this.H, i));
    }

    public void a(h hVar) {
        this.x = hVar;
    }

    public h A() {
        return this.y;
    }

    public void t(int i) {
        b(h.a(this.H, i));
    }

    public void b(h hVar) {
        this.y = hVar;
    }

    public float B() {
        return this.z;
    }

    public void u(int i) {
        f(this.H.getResources().getDimension(i));
    }

    public void f(float f) {
        if (this.z != f) {
            this.z = f;
            invalidateSelf();
            a();
        }
    }

    public float C() {
        return this.A;
    }

    public void v(int i) {
        g(this.H.getResources().getDimension(i));
    }

    public void g(float f) {
        if (this.A != f) {
            float b = b();
            this.A = f;
            float b2 = b();
            invalidateSelf();
            if (b != b2) {
                a();
            }
        }
    }

    public float D() {
        return this.B;
    }

    public void w(int i) {
        h(this.H.getResources().getDimension(i));
    }

    public void h(float f) {
        if (this.B != f) {
            float b = b();
            this.B = f;
            float b2 = b();
            invalidateSelf();
            if (b != b2) {
                a();
            }
        }
    }

    public float E() {
        return this.C;
    }

    public void x(int i) {
        i(this.H.getResources().getDimension(i));
    }

    public void i(float f) {
        if (this.C != f) {
            this.C = f;
            invalidateSelf();
            a();
        }
    }

    public float F() {
        return this.D;
    }

    public void y(int i) {
        j(this.H.getResources().getDimension(i));
    }

    public void j(float f) {
        if (this.D != f) {
            this.D = f;
            invalidateSelf();
            a();
        }
    }

    public float G() {
        return this.E;
    }

    public void z(int i) {
        k(this.H.getResources().getDimension(i));
    }

    public void k(float f) {
        if (this.E != f) {
            this.E = f;
            invalidateSelf();
            if (M()) {
                a();
            }
        }
    }

    public float H() {
        return this.F;
    }

    public void A(int i) {
        l(this.H.getResources().getDimension(i));
    }

    public void l(float f) {
        if (this.F != f) {
            this.F = f;
            invalidateSelf();
            if (M()) {
                a();
            }
        }
    }

    public float I() {
        return this.G;
    }

    public void B(int i) {
        m(this.H.getResources().getDimension(i));
    }

    public void m(float f) {
        if (this.G != f) {
            this.G = f;
            invalidateSelf();
            a();
        }
    }

    public void C(int i) {
        this.ah = i;
    }

    boolean J() {
        return this.ag;
    }

    void f(boolean z) {
        this.ag = z;
    }
}
