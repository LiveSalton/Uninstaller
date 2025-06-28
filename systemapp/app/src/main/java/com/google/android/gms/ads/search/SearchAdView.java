package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzzc;

/* compiled from: source */
/* loaded from: classes.dex */
public final class SearchAdView extends ViewGroup {
    private final zzzc a;

    public SearchAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new zzzc(this, attributeSet, false);
    }

    public SearchAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new zzzc(this, attributeSet, false);
    }

    public final AdListener getAdListener() {
        return this.a.b();
    }

    public final AdSize getAdSize() {
        return this.a.c();
    }

    public final String getAdUnitId() {
        return this.a.e();
    }

    public final void setAdListener(AdListener adListener) {
        this.a.a(adListener);
    }

    public final void setAdSize(AdSize adSize) {
        this.a.a(adSize);
    }

    public final void setAdUnitId(String str) {
        this.a.a(str);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = ((i3 - i) - measuredWidth) / 2;
        int i6 = ((i4 - i2) - measuredHeight) / 2;
        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        } else {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzaza.c("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int b = adSize.b(context);
                i3 = adSize.a(context);
                i4 = b;
            } else {
                i3 = 0;
            }
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }
}
