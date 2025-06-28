package com.jumobile.manager.systemapp.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* compiled from: source */
/* loaded from: classes.dex */
public class AtMostListView extends ListView {
    public AtMostListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AtMostListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
