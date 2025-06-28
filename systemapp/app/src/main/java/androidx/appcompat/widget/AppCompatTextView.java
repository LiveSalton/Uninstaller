package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.f.c;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: source */
/* loaded from: classes.dex */
public class AppCompatTextView extends TextView implements androidx.core.h.u, androidx.core.widget.b, androidx.core.widget.k {
    private final d a;
    private final l b;
    private final k c;
    private Future<androidx.core.f.c> e;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(ac.a(context), attributeSet, i);
        aa.a(this, getContext());
        this.a = new d(this);
        this.a.a(attributeSet, i);
        this.b = new l(this);
        this.b.a(attributeSet, i);
        this.b.b();
        this.c = new k(this);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.a != null) {
            this.a.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.a != null) {
            this.a.a(drawable);
        }
    }

    @Override // androidx.core.h.u
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            this.a.a(colorStateList);
        }
    }

    @Override // androidx.core.h.u
    public ColorStateList getSupportBackgroundTintList() {
        if (this.a != null) {
            return this.a.a();
        }
        return null;
    }

    @Override // androidx.core.h.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.a != null) {
            this.a.a(mode);
        }
    }

    @Override // androidx.core.h.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.a != null) {
            return this.a.b();
        }
        return null;
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.b != null) {
            this.b.a(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.a != null) {
            this.a.c();
        }
        if (this.b != null) {
            this.b.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.b != null) {
            this.b.a(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (d) {
            super.setTextSize(i, f);
        } else if (this.b != null) {
            this.b.a(i, f);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.b == null || d || !this.b.d()) {
            return;
        }
        this.b.c();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (d) {
            super.setAutoSizeTextTypeWithDefaults(i);
        } else if (this.b != null) {
            this.b.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (this.b != null) {
            this.b.a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException {
        if (d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (this.b != null) {
            this.b.a(iArr, i);
        }
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (d) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        if (this.b != null) {
            return this.b.e();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (d) {
            return super.getAutoSizeStepGranularity();
        }
        if (this.b != null) {
            return this.b.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (d) {
            return super.getAutoSizeMinTextSize();
        }
        if (this.b != null) {
            return this.b.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (d) {
            return super.getAutoSizeMaxTextSize();
        }
        if (this.b != null) {
            return this.b.h();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        if (this.b != null) {
            return this.b.i();
        }
        return new int[0];
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return g.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            androidx.core.widget.i.b(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            androidx.core.widget.i.c(this, i);
        }
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.i.c(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.i.d(this);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        androidx.core.widget.i.d(this, i);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.a(this, callback));
    }

    public c.a getTextMetricsParamsCompat() {
        return androidx.core.widget.i.e(this);
    }

    public void setTextMetricsParamsCompat(c.a aVar) {
        androidx.core.widget.i.a(this, aVar);
    }

    public void setPrecomputedText(androidx.core.f.c cVar) {
        androidx.core.widget.i.a(this, cVar);
    }

    private void a() {
        if (this.e != null) {
            try {
                Future<androidx.core.f.c> future = this.e;
                this.e = null;
                androidx.core.widget.i.a(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        a();
        return super.getText();
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        if (Build.VERSION.SDK_INT >= 28 || this.c == null) {
            super.setTextClassifier(textClassifier);
        } else {
            this.c.a(textClassifier);
        }
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        if (Build.VERSION.SDK_INT >= 28 || this.c == null) {
            return super.getTextClassifier();
        }
        return this.c.a();
    }

    public void setTextFuture(Future<androidx.core.f.c> future) {
        this.e = future;
        if (future != null) {
            requestLayout();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        a();
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        if (this.b != null) {
            this.b.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        if (this.b != null) {
            this.b.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        if (this.b != null) {
            this.b.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? androidx.appcompat.a.a.a.b(context, i) : null, i2 != 0 ? androidx.appcompat.a.a.a.b(context, i2) : null, i3 != 0 ? androidx.appcompat.a.a.a.b(context, i3) : null, i4 != 0 ? androidx.appcompat.a.a.a.b(context, i4) : null);
        if (this.b != null) {
            this.b.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        if (this.b != null) {
            this.b.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? androidx.appcompat.a.a.a.b(context, i) : null, i2 != 0 ? androidx.appcompat.a.a.a.b(context, i2) : null, i3 != 0 ? androidx.appcompat.a.a.a.b(context, i3) : null, i4 != 0 ? androidx.appcompat.a.a.a.b(context, i4) : null);
        if (this.b != null) {
            this.b.a();
        }
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.b.j();
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.b.a(colorStateList);
        this.b.b();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.b.k();
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.b.a(mode);
        this.b.b();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i) {
        Typeface a = (typeface == null || i <= 0) ? null : androidx.core.graphics.d.a(getContext(), typeface, i);
        if (a != null) {
            typeface = a;
        }
        super.setTypeface(typeface, i);
    }
}
