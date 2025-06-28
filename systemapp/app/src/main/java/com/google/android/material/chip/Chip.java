package com.google.android.material.chip;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.multidex.BuildConfig;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.a.f;
import androidx.core.h.a.d;
import androidx.core.h.w;
import com.google.android.material.a;
import com.google.android.material.a.h;
import com.google.android.material.chip.a;
import com.google.android.material.f.b;
import com.google.android.material.internal.l;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class Chip extends AppCompatCheckBox implements a.InterfaceC0080a {
    private static final Rect a = new Rect();
    private static final int[] b = {R.attr.state_selected};
    private com.google.android.material.chip.a c;
    private RippleDrawable d;
    private View.OnClickListener e;
    private CompoundButton.OnCheckedChangeListener f;
    private boolean g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private final a l;
    private final Rect m;
    private final RectF n;
    private final f.a o;

    /* compiled from: source */
    /* renamed from: com.google.android.material.chip.Chip$1 */
    class AnonymousClass1 extends f.a {
        @Override // androidx.core.content.a.f.a
        public void a(int i) {
        }

        AnonymousClass1() {
        }

        @Override // androidx.core.content.a.f.a
        public void a(Typeface typeface) {
            Chip.this.setText(Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.chipStyle);
    }

    public Chip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = Integer.MIN_VALUE;
        this.m = new Rect();
        this.n = new RectF();
        this.o = new f.a() { // from class: com.google.android.material.chip.Chip.1
            @Override // androidx.core.content.a.f.a
            public void a(int i2) {
            }

            AnonymousClass1() {
            }

            @Override // androidx.core.content.a.f.a
            public void a(Typeface typeface) {
                Chip.this.setText(Chip.this.getText());
                Chip.this.requestLayout();
                Chip.this.invalidate();
            }
        };
        a(attributeSet);
        com.google.android.material.chip.a a2 = com.google.android.material.chip.a.a(context, attributeSet, i, a.j.Widget_MaterialComponents_Chip_Action);
        setChipDrawable(a2);
        this.l = new a(this);
        w.a(this, this.l);
        e();
        setChecked(this.g);
        a2.f(false);
        setText(a2.k());
        setEllipsize(a2.m());
        setIncludeFontPadding(false);
        if (getTextAppearance() != null) {
            a(getTextAppearance());
        }
        setSingleLine();
        setGravity(8388627);
        d();
    }

    private void d() {
        if (TextUtils.isEmpty(getText()) || this.c == null) {
            return;
        }
        float B = this.c.B() + this.c.I() + this.c.E() + this.c.F();
        if ((this.c.n() && this.c.o() != null) || (this.c.y() != null && this.c.x() && isChecked())) {
            B += this.c.C() + this.c.D() + this.c.q();
        }
        if (this.c.r() && this.c.s() != null) {
            B += this.c.G() + this.c.H() + this.c.u();
        }
        if (w.l(this) != B) {
            w.b(this, w.k(this), getPaddingTop(), (int) B, getPaddingBottom());
        }
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    private void e() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new ViewOutlineProvider() { // from class: com.google.android.material.chip.Chip.2
                AnonymousClass2() {
                }

                @Override // android.view.ViewOutlineProvider
                @TargetApi(21)
                public void getOutline(View view, Outline outline) {
                    if (Chip.this.c != null) {
                        Chip.this.c.getOutline(outline);
                    } else {
                        outline.setAlpha(0.0f);
                    }
                }
            });
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.chip.Chip$2 */
    class AnonymousClass2 extends ViewOutlineProvider {
        AnonymousClass2() {
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, Outline outline) {
            if (Chip.this.c != null) {
                Chip.this.c.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    public Drawable getChipDrawable() {
        return this.c;
    }

    public void setChipDrawable(com.google.android.material.chip.a aVar) {
        if (this.c != aVar) {
            a(this.c);
            this.c = aVar;
            b(this.c);
            if (com.google.android.material.g.a.a) {
                this.d = new RippleDrawable(com.google.android.material.g.a.a(this.c.j()), this.c, null);
                this.c.a(false);
                w.a(this, this.d);
            } else {
                this.c.a(true);
                w.a(this, this.c);
            }
        }
    }

    private void a(com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.a((a.InterfaceC0080a) null);
        }
    }

    private void b(com.google.android.material.chip.a aVar) {
        aVar.a(this);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, b);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (TextUtils.isEmpty(getText()) || this.c == null || this.c.J()) {
            super.onDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.translate(c(this.c), 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    private float c(com.google.android.material.chip.a aVar) {
        float chipStartPadding = getChipStartPadding() + aVar.b() + getTextStartPadding();
        return w.h(this) == 0 ? chipStartPadding : -chipStartPadding;
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        throw new UnsupportedOperationException("Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        throw new UnsupportedOperationException("Do not set the background tint mode; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        throw new UnsupportedOperationException("Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i) {
        throw new UnsupportedOperationException("Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable != this.c && drawable != this.d) {
            throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
        }
        super.setBackground(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != this.c && drawable != this.d) {
            throw new UnsupportedOperationException("Do not set the background drawable; Chip manages its own background drawable.");
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        if (this.c != null) {
            return this.c.m();
        }
        return null;
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.c == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        if (this.c != null) {
            this.c.a(truncateAt);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (!z) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z);
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i);
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        if (this.c != null) {
            this.c.C(i);
        }
    }

    @Override // com.google.android.material.chip.a.InterfaceC0080a
    public void a() {
        d();
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.c == null) {
            this.g = z;
            return;
        }
        if (this.c.w()) {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked == z || this.f == null) {
                return;
            }
            this.f.onCheckedChanged(this, z);
        }
    }

    void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public boolean b() {
        boolean z;
        playSoundEffect(0);
        if (this.e != null) {
            this.e.onClick(this);
            z = true;
        } else {
            z = false;
        }
        this.l.a(0, 1);
        return z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        boolean contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        switch (actionMasked) {
            case 0:
                if (contains) {
                    setCloseIconPressed(true);
                    z = true;
                    break;
                }
                z = false;
                break;
            case 1:
                if (this.i) {
                    b();
                    z = true;
                    setCloseIconPressed(false);
                    break;
                }
                z = false;
                setCloseIconPressed(false);
            case 2:
                if (this.i) {
                    if (!contains) {
                        setCloseIconPressed(false);
                    }
                    z = true;
                    break;
                }
                z = false;
                break;
            case 3:
                z = false;
                setCloseIconPressed(false);
                break;
            default:
                z = false;
                break;
        }
        return z || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @SuppressLint({"PrivateApi"})
    private boolean a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = androidx.customview.a.a.class.getDeclaredField("k");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.l)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = androidx.customview.a.a.class.getDeclaredMethod("updateHoveredVirtualView", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.l, Integer.MIN_VALUE);
                    return true;
                }
            } catch (IllegalAccessException e) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e);
            } catch (NoSuchFieldException e2) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e2);
            } catch (NoSuchMethodException e3) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e3);
            } catch (InvocationTargetException e4) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e4);
            }
        }
        return false;
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return a(motionEvent) || this.l.a(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.l.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            setFocusedVirtualView(-1);
        } else {
            setFocusedVirtualView(Integer.MIN_VALUE);
        }
        invalidate();
        super.onFocusChanged(z, i, rect);
        this.l.a(z, i, rect);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int i2;
        int keyCode = keyEvent.getKeyCode();
        boolean z = false;
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 21:
                        if (keyEvent.hasNoModifiers()) {
                            z = a(l.a(this));
                            break;
                        }
                        break;
                    case 22:
                        if (keyEvent.hasNoModifiers()) {
                            z = a(!l.a(this));
                            break;
                        }
                        break;
                }
            }
            switch (this.h) {
                case BuildConfig.VERSION_CODE /* -1 */:
                    performClick();
                    break;
                case 0:
                    b();
                    break;
            }
            return true;
        }
        if (keyEvent.hasNoModifiers()) {
            i2 = 2;
        } else {
            i2 = keyEvent.hasModifiers(1) ? 1 : 0;
        }
        if (i2 != 0) {
            ViewParent parent = getParent();
            View view = this;
            do {
                view = view.focusSearch(i2);
                if (view == null || view == this) {
                    break;
                }
            } while (view.getParent() == parent);
            if (view != null) {
                view.requestFocus();
                return true;
            }
        }
        if (z) {
            invalidate();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean a(boolean z) {
        f();
        if (z) {
            if (this.h == -1) {
                setFocusedVirtualView(0);
                return true;
            }
        } else if (this.h == 0) {
            setFocusedVirtualView(-1);
            return true;
        }
        return false;
    }

    private void f() {
        if (this.h == Integer.MIN_VALUE) {
            setFocusedVirtualView(-1);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.h == 0) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    private void setFocusedVirtualView(int i) {
        if (this.h != i) {
            if (this.h == 0) {
                setCloseIconFocused(false);
            }
            this.h = i;
            if (i == 0) {
                setCloseIconFocused(true);
            }
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.i != z) {
            this.i = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconHovered(boolean z) {
        if (this.j != z) {
            this.j = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconFocused(boolean z) {
        if (this.k != z) {
            this.k = z;
            refreshDrawableState();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if ((this.c == null || !this.c.c()) ? false : this.c.a(g())) {
            invalidate();
        }
    }

    private int[] g() {
        int i = 0;
        int i2 = isEnabled() ? 1 : 0;
        if (this.k) {
            i2++;
        }
        if (this.j) {
            i2++;
        }
        if (this.i) {
            i2++;
        }
        if (isChecked()) {
            i2++;
        }
        int[] iArr = new int[i2];
        if (isEnabled()) {
            iArr[0] = 16842910;
            i = 1;
        }
        if (this.k) {
            iArr[i] = 16842908;
            i++;
        }
        if (this.j) {
            iArr[i] = 16843623;
            i++;
        }
        if (this.i) {
            iArr[i] = 16842919;
            i++;
        }
        if (isChecked()) {
            iArr[i] = 16842913;
        }
        return iArr;
    }

    public boolean h() {
        return (this.c == null || this.c.s() == null) ? false : true;
    }

    public RectF getCloseIconTouchBounds() {
        this.n.setEmpty();
        if (h()) {
            this.c.a(this.n);
        }
        return this.n;
    }

    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.m.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.m;
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    /* compiled from: source */
    private class a extends androidx.customview.a.a {
        a(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.a.a
        protected int a(float f, float f2) {
            return (Chip.this.h() && Chip.this.getCloseIconTouchBounds().contains(f, f2)) ? 0 : -1;
        }

        @Override // androidx.customview.a.a
        protected void a(List<Integer> list) {
            if (Chip.this.h()) {
                list.add(0);
            }
        }

        @Override // androidx.customview.a.a
        protected void a(int i, d dVar) {
            if (Chip.this.h()) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    dVar.e(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i2 = a.i.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (TextUtils.isEmpty(text)) {
                        text = "";
                    }
                    objArr[0] = text;
                    dVar.e(context.getString(i2, objArr).trim());
                }
                dVar.b(Chip.this.getCloseIconTouchBoundsInt());
                dVar.a(d.a.e);
                dVar.j(Chip.this.isEnabled());
                return;
            }
            dVar.e("");
            dVar.b(Chip.a);
        }

        @Override // androidx.customview.a.a
        protected void a(d dVar) {
            dVar.a(Chip.this.c != null && Chip.this.c.w());
            dVar.b((CharSequence) Chip.class.getName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                dVar.c(text);
            } else {
                dVar.e(text);
            }
        }

        @Override // androidx.customview.a.a
        protected boolean b(int i, int i2, Bundle bundle) {
            if (i2 == 16 && i == 0) {
                return Chip.this.b();
            }
            return false;
        }
    }

    public ColorStateList getChipBackgroundColor() {
        if (this.c != null) {
            return this.c.e();
        }
        return null;
    }

    public void setChipBackgroundColorResource(int i) {
        if (this.c != null) {
            this.c.a(i);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        if (this.c != null) {
            this.c.a(colorStateList);
        }
    }

    public float getChipMinHeight() {
        if (this.c != null) {
            return this.c.f();
        }
        return 0.0f;
    }

    public void setChipMinHeightResource(int i) {
        if (this.c != null) {
            this.c.b(i);
        }
    }

    public void setChipMinHeight(float f) {
        if (this.c != null) {
            this.c.a(f);
        }
    }

    public float getChipCornerRadius() {
        if (this.c != null) {
            return this.c.g();
        }
        return 0.0f;
    }

    public void setChipCornerRadiusResource(int i) {
        if (this.c != null) {
            this.c.c(i);
        }
    }

    public void setChipCornerRadius(float f) {
        if (this.c != null) {
            this.c.b(f);
        }
    }

    public ColorStateList getChipStrokeColor() {
        if (this.c != null) {
            return this.c.h();
        }
        return null;
    }

    public void setChipStrokeColorResource(int i) {
        if (this.c != null) {
            this.c.d(i);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        if (this.c != null) {
            this.c.b(colorStateList);
        }
    }

    public float getChipStrokeWidth() {
        if (this.c != null) {
            return this.c.i();
        }
        return 0.0f;
    }

    public void setChipStrokeWidthResource(int i) {
        if (this.c != null) {
            this.c.e(i);
        }
    }

    public void setChipStrokeWidth(float f) {
        if (this.c != null) {
            this.c.c(f);
        }
    }

    public ColorStateList getRippleColor() {
        if (this.c != null) {
            return this.c.j();
        }
        return null;
    }

    public void setRippleColorResource(int i) {
        if (this.c != null) {
            this.c.f(i);
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.c != null) {
            this.c.c(colorStateList);
        }
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.c != null ? this.c.k() : "";
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.c == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        CharSequence a2 = androidx.core.f.a.a().a(charSequence);
        if (this.c.J()) {
            a2 = null;
        }
        super.setText(a2, bufferType);
        if (this.c != null) {
            this.c.a(charSequence);
        }
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    private b getTextAppearance() {
        if (this.c != null) {
            return this.c.l();
        }
        return null;
    }

    private void a(b bVar) {
        TextPaint paint = getPaint();
        paint.drawableState = this.c.getState();
        bVar.b(getContext(), paint, this.o);
    }

    public void setTextAppearanceResource(int i) {
        if (this.c != null) {
            this.c.g(i);
        }
        setTextAppearance(getContext(), i);
    }

    public void setTextAppearance(b bVar) {
        if (this.c != null) {
            this.c.a(bVar);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().c(getContext(), getPaint(), this.o);
            a(bVar);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.c != null) {
            this.c.g(i);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().c(context, getPaint(), this.o);
            a(getTextAppearance());
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        if (this.c != null) {
            this.c.g(i);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().c(getContext(), getPaint(), this.o);
            a(getTextAppearance());
        }
    }

    public void setChipIconVisible(int i) {
        if (this.c != null) {
            this.c.h(i);
        }
    }

    public void setChipIconVisible(boolean z) {
        if (this.c != null) {
            this.c.b(z);
        }
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    public Drawable getChipIcon() {
        if (this.c != null) {
            return this.c.o();
        }
        return null;
    }

    public void setChipIconResource(int i) {
        if (this.c != null) {
            this.c.i(i);
        }
    }

    public void setChipIcon(Drawable drawable) {
        if (this.c != null) {
            this.c.a(drawable);
        }
    }

    public ColorStateList getChipIconTint() {
        if (this.c != null) {
            return this.c.p();
        }
        return null;
    }

    public void setChipIconTintResource(int i) {
        if (this.c != null) {
            this.c.j(i);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        if (this.c != null) {
            this.c.d(colorStateList);
        }
    }

    public float getChipIconSize() {
        if (this.c != null) {
            return this.c.q();
        }
        return 0.0f;
    }

    public void setChipIconSizeResource(int i) {
        if (this.c != null) {
            this.c.k(i);
        }
    }

    public void setChipIconSize(float f) {
        if (this.c != null) {
            this.c.d(f);
        }
    }

    public void setCloseIconVisible(int i) {
        if (this.c != null) {
            this.c.l(i);
        }
    }

    public void setCloseIconVisible(boolean z) {
        if (this.c != null) {
            this.c.c(z);
        }
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    public Drawable getCloseIcon() {
        if (this.c != null) {
            return this.c.s();
        }
        return null;
    }

    public void setCloseIconResource(int i) {
        if (this.c != null) {
            this.c.m(i);
        }
    }

    public void setCloseIcon(Drawable drawable) {
        if (this.c != null) {
            this.c.b(drawable);
        }
    }

    public ColorStateList getCloseIconTint() {
        if (this.c != null) {
            return this.c.t();
        }
        return null;
    }

    public void setCloseIconTintResource(int i) {
        if (this.c != null) {
            this.c.n(i);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        if (this.c != null) {
            this.c.e(colorStateList);
        }
    }

    public float getCloseIconSize() {
        if (this.c != null) {
            return this.c.u();
        }
        return 0.0f;
    }

    public void setCloseIconSizeResource(int i) {
        if (this.c != null) {
            this.c.o(i);
        }
    }

    public void setCloseIconSize(float f) {
        if (this.c != null) {
            this.c.e(f);
        }
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        if (this.c != null) {
            this.c.b(charSequence);
        }
    }

    public CharSequence getCloseIconContentDescription() {
        if (this.c != null) {
            return this.c.v();
        }
        return null;
    }

    public void setCheckableResource(int i) {
        if (this.c != null) {
            this.c.p(i);
        }
    }

    public void setCheckable(boolean z) {
        if (this.c != null) {
            this.c.d(z);
        }
    }

    public void setCheckedIconVisible(int i) {
        if (this.c != null) {
            this.c.q(i);
        }
    }

    public void setCheckedIconVisible(boolean z) {
        if (this.c != null) {
            this.c.e(z);
        }
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    public Drawable getCheckedIcon() {
        if (this.c != null) {
            return this.c.y();
        }
        return null;
    }

    public void setCheckedIconResource(int i) {
        if (this.c != null) {
            this.c.r(i);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        if (this.c != null) {
            this.c.c(drawable);
        }
    }

    public h getShowMotionSpec() {
        if (this.c != null) {
            return this.c.z();
        }
        return null;
    }

    public void setShowMotionSpecResource(int i) {
        if (this.c != null) {
            this.c.s(i);
        }
    }

    public void setShowMotionSpec(h hVar) {
        if (this.c != null) {
            this.c.a(hVar);
        }
    }

    public h getHideMotionSpec() {
        if (this.c != null) {
            return this.c.A();
        }
        return null;
    }

    public void setHideMotionSpecResource(int i) {
        if (this.c != null) {
            this.c.t(i);
        }
    }

    public void setHideMotionSpec(h hVar) {
        if (this.c != null) {
            this.c.b(hVar);
        }
    }

    public float getChipStartPadding() {
        if (this.c != null) {
            return this.c.B();
        }
        return 0.0f;
    }

    public void setChipStartPaddingResource(int i) {
        if (this.c != null) {
            this.c.u(i);
        }
    }

    public void setChipStartPadding(float f) {
        if (this.c != null) {
            this.c.f(f);
        }
    }

    public float getIconStartPadding() {
        if (this.c != null) {
            return this.c.C();
        }
        return 0.0f;
    }

    public void setIconStartPaddingResource(int i) {
        if (this.c != null) {
            this.c.v(i);
        }
    }

    public void setIconStartPadding(float f) {
        if (this.c != null) {
            this.c.g(f);
        }
    }

    public float getIconEndPadding() {
        if (this.c != null) {
            return this.c.D();
        }
        return 0.0f;
    }

    public void setIconEndPaddingResource(int i) {
        if (this.c != null) {
            this.c.w(i);
        }
    }

    public void setIconEndPadding(float f) {
        if (this.c != null) {
            this.c.h(f);
        }
    }

    public float getTextStartPadding() {
        if (this.c != null) {
            return this.c.E();
        }
        return 0.0f;
    }

    public void setTextStartPaddingResource(int i) {
        if (this.c != null) {
            this.c.x(i);
        }
    }

    public void setTextStartPadding(float f) {
        if (this.c != null) {
            this.c.i(f);
        }
    }

    public float getTextEndPadding() {
        if (this.c != null) {
            return this.c.F();
        }
        return 0.0f;
    }

    public void setTextEndPaddingResource(int i) {
        if (this.c != null) {
            this.c.y(i);
        }
    }

    public void setTextEndPadding(float f) {
        if (this.c != null) {
            this.c.j(f);
        }
    }

    public float getCloseIconStartPadding() {
        if (this.c != null) {
            return this.c.G();
        }
        return 0.0f;
    }

    public void setCloseIconStartPaddingResource(int i) {
        if (this.c != null) {
            this.c.z(i);
        }
    }

    public void setCloseIconStartPadding(float f) {
        if (this.c != null) {
            this.c.k(f);
        }
    }

    public float getCloseIconEndPadding() {
        if (this.c != null) {
            return this.c.H();
        }
        return 0.0f;
    }

    public void setCloseIconEndPaddingResource(int i) {
        if (this.c != null) {
            this.c.A(i);
        }
    }

    public void setCloseIconEndPadding(float f) {
        if (this.c != null) {
            this.c.l(f);
        }
    }

    public float getChipEndPadding() {
        if (this.c != null) {
            return this.c.I();
        }
        return 0.0f;
    }

    public void setChipEndPaddingResource(int i) {
        if (this.c != null) {
            this.c.B(i);
        }
    }

    public void setChipEndPadding(float f) {
        if (this.c != null) {
            this.c.m(f);
        }
    }
}
