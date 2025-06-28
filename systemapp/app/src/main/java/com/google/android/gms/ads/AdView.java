package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: source */
/* loaded from: classes.dex */
public final class AdView extends BaseAdView {
    public AdView(Context context) {
        super(context, 0);
        Preconditions.a(context, "Context cannot be null");
    }

    public AdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public AdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
    }

    public final VideoController getVideoController() {
        if (this.a != null) {
            return this.a.l();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        super.setOnPaidEventListener(onPaidEventListener);
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ ResponseInfo getResponseInfo() {
        return super.getResponseInfo();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    @Deprecated
    public final /* bridge */ /* synthetic */ String getMediationAdapterClassName() {
        return super.getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void setAdUnitId(String str) {
        super.setAdUnitId(str);
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void setAdSize(AdSize adSize) {
        super.setAdSize(adSize);
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void setAdListener(AdListener adListener) {
        super.setAdListener(adListener);
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void a(AdRequest adRequest) {
        super.a(adRequest);
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ String getAdUnitId() {
        return super.getAdUnitId();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ AdSize getAdSize() {
        return super.getAdSize();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ AdListener getAdListener() {
        return super.getAdListener();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }
}
