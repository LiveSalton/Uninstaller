package com.github.ybq.android.spinkit;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.github.ybq.android.spinkit.a;
import com.github.ybq.android.spinkit.b.f;

/* compiled from: source */
/* loaded from: classes.dex */
public class SpinKitView extends ProgressBar {
    private c a;
    private int b;
    private f c;

    public SpinKitView(Context context) {
        this(context, null);
    }

    public SpinKitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0054a.SpinKitViewStyle);
    }

    public SpinKitView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, a.b.SpinKitView);
    }

    @TargetApi(21)
    public SpinKitView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.SpinKitView, i, i2);
        this.a = c.values()[obtainStyledAttributes.getInt(a.c.SpinKitView_SpinKit_Style, 0)];
        this.b = obtainStyledAttributes.getColor(a.c.SpinKitView_SpinKit_Color, -1);
        obtainStyledAttributes.recycle();
        a();
        setIndeterminate(true);
    }

    private void a() {
        f a = b.a(this.a);
        a.a(this.b);
        setIndeterminateDrawable(a);
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (!(drawable instanceof f)) {
            throw new IllegalArgumentException("this d must be instanceof Sprite");
        }
        setIndeterminateDrawable((f) drawable);
    }

    public void setIndeterminateDrawable(f fVar) {
        super.setIndeterminateDrawable((Drawable) fVar);
        this.c = fVar;
        if (this.c.b() == 0) {
            this.c.a(this.b);
        }
        onSizeChanged(getWidth(), getHeight(), getWidth(), getHeight());
        if (getVisibility() == 0) {
            this.c.start();
        }
    }

    @Override // android.widget.ProgressBar
    public f getIndeterminateDrawable() {
        return this.c;
    }

    public void setColor(int i) {
        this.b = i;
        if (this.c != null) {
            this.c.a(i);
        }
        invalidate();
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        super.unscheduleDrawable(drawable);
        if (drawable instanceof f) {
            ((f) drawable).stop();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.c != null && getVisibility() == 0) {
            this.c.start();
        }
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (i != 0 || this.c == null) {
            return;
        }
        this.c.stop();
    }
}
