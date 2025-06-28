package com.google.android.gms.ads.appopen;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzse;
import com.google.android.gms.internal.ads.zzvn;
import com.google.android.gms.internal.ads.zzxg;

/* compiled from: source */
@Deprecated
/* loaded from: classes.dex */
public final class AppOpenAdView extends ViewGroup {
    private AppOpenAd a;
    private AppOpenAdPresentationCallback b;

    public AppOpenAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppOpenAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setAppOpenAd(AppOpenAd appOpenAd) {
        IObjectWrapper a;
        try {
            zzxg a2 = appOpenAd.a();
            if (a2 == null || (a = a2.a()) == null) {
                return;
            }
            View view = (View) ObjectWrapper.a(a);
            if (view.getParent() == null) {
                removeAllViews();
                addView(view);
                this.a = appOpenAd;
                a();
                return;
            }
            zzaza.c("Trying to set AppOpenAd which is already in use.");
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    public final void setAppOpenAdPresentationCallback(AppOpenAdPresentationCallback appOpenAdPresentationCallback) {
        this.b = appOpenAdPresentationCallback;
        a();
    }

    private final void a() {
        if (this.a == null || this.b == null) {
            return;
        }
        this.a.a(new zzse(this.b));
    }

    private final AdSize getAdSize() {
        zzxg a = this.a.a();
        if (a == null) {
            return null;
        }
        try {
            zzvn j = a.j();
            if (j != null) {
                return j.e();
            }
            return null;
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
            return null;
        }
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
