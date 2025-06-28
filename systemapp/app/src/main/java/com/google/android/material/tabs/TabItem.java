package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.af;
import com.google.android.material.a;

/* compiled from: source */
/* loaded from: classes.dex */
public class TabItem extends View {
    public final CharSequence a;
    public final Drawable b;
    public final int c;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        af a = af.a(context, attributeSet, a.k.TabItem);
        this.a = a.c(a.k.TabItem_android_text);
        this.b = a.a(a.k.TabItem_android_icon);
        this.c = a.g(a.k.TabItem_android_layout, 0);
        a.b();
    }
}
