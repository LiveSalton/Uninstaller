package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaza;

/* compiled from: source */
@KeepForSdkWithMembers
@KeepName
/* loaded from: classes.dex */
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {

    @VisibleForTesting
    private static final AdError a = new AdError(0, "Could not instantiate custom event adapter", "com.google.android.gms.ads");
    private View b;

    @VisibleForTesting
    private CustomEventBanner c;

    @VisibleForTesting
    private CustomEventInterstitial d;

    @VisibleForTesting
    private CustomEventNative e;

    /* compiled from: source */
    @VisibleForTesting
    class a implements CustomEventInterstitialListener {
        private final CustomEventAdapter a;
        private final MediationInterstitialListener b;

        public a(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.a = customEventAdapter;
            this.b = mediationInterstitialListener;
        }
    }

    /* compiled from: source */
    @VisibleForTesting
    static final class b implements CustomEventBannerListener {
        private final CustomEventAdapter a;
        private final MediationBannerListener b;

        public b(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.a = customEventAdapter;
            this.b = mediationBannerListener;
        }
    }

    /* compiled from: source */
    @VisibleForTesting
    static class c implements CustomEventNativeListener {
        private final CustomEventAdapter a;
        private final MediationNativeListener b;

        public c(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.a = customEventAdapter;
            this.b = mediationNativeListener;
        }
    }

    private static <T> T a(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(46 + String.valueOf(str).length() + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzaza.e(sb.toString());
            return null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        if (this.c != null) {
            this.c.a();
        }
        if (this.d != null) {
            this.d.a();
        }
        if (this.e != null) {
            this.e.a();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        if (this.c != null) {
            this.c.b();
        }
        if (this.d != null) {
            this.d.b();
        }
        if (this.e != null) {
            this.e.b();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        if (this.c != null) {
            this.c.c();
        }
        if (this.d != null) {
            this.d.c();
        }
        if (this.e != null) {
            this.e.c();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final View getBannerView() {
        return this.b;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.c = (CustomEventBanner) a(bundle.getString("class_name"));
        if (this.c == null) {
            mediationBannerListener.a(this, a);
        } else {
            this.c.requestBannerAd(context, new b(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.d = (CustomEventInterstitial) a(bundle.getString("class_name"));
        if (this.d == null) {
            mediationInterstitialListener.a(this, a);
        } else {
            this.d.requestInterstitialAd(context, new a(this, mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public final void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.e = (CustomEventNative) a(bundle.getString("class_name"));
        if (this.e == null) {
            mediationNativeListener.a(this, a);
        } else {
            this.e.requestNativeAd(context, new c(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        this.d.showInterstitial();
    }
}
