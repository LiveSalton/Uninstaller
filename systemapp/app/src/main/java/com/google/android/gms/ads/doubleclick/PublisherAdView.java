package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzxg;
import com.google.android.gms.internal.ads.zzzc;

/* compiled from: source */
/* loaded from: classes.dex */
public final class PublisherAdView extends ViewGroup {
    private final zzzc a;

    public PublisherAdView(Context context) {
        super(context);
        this.a = new zzzc(this);
    }

    @KeepForSdk
    @Deprecated
    public final void setCorrelator(Correlator correlator) {
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new zzzc(this, attributeSet, true);
        Preconditions.a(context, "Context cannot be null");
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new zzzc(this, attributeSet, true);
    }

    public final VideoController getVideoController() {
        return this.a.l();
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.a.a(videoOptions);
    }

    public final VideoOptions getVideoOptions() {
        return this.a.n();
    }

    public final AdListener getAdListener() {
        return this.a.b();
    }

    public final AdSize getAdSize() {
        return this.a.c();
    }

    public final AdSize[] getAdSizes() {
        return this.a.d();
    }

    public final String getAdUnitId() {
        return this.a.e();
    }

    public final AppEventListener getAppEventListener() {
        return this.a.f();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.a.g();
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.a.a(z);
    }

    public final void setAdListener(AdListener adListener) {
        this.a.a(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.a.b(adSizeArr);
    }

    public final void setAdUnitId(String str) {
        this.a.a(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.a.a(appEventListener);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.a.a(onCustomRenderedAdLoadedListener);
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.a.j();
    }

    public final ResponseInfo getResponseInfo() {
        return this.a.k();
    }

    public final boolean a(zzxg zzxgVar) {
        return this.a.a(zzxgVar);
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
