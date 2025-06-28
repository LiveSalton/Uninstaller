package com.jumobile.manager.systemapp.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: source */
/* loaded from: classes.dex */
public class SmartMarqueeText extends TextView {
    public SmartMarqueeText(Context context) {
        this(context, null);
    }

    public SmartMarqueeText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (isInEditMode()) {
            return;
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        setSingleLine(true);
        setHorizontallyScrolling(true);
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setMarqueeRepeatLimit(-1);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (isInEditMode()) {
            super.onFocusChanged(z, i, rect);
        } else if (z) {
            super.onFocusChanged(z, i, rect);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (isInEditMode()) {
            super.onWindowFocusChanged(z);
        } else if (z) {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public boolean isFocused() {
        if (isInEditMode()) {
            return super.isFocused();
        }
        return true;
    }
}
