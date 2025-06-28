package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;

/* compiled from: source */
/* loaded from: classes.dex */
public interface MediationInterstitialListener {
    void a(MediationInterstitialAdapter mediationInterstitialAdapter);

    @Deprecated
    void a(MediationInterstitialAdapter mediationInterstitialAdapter, int i);

    void a(MediationInterstitialAdapter mediationInterstitialAdapter, AdError adError);

    void b(MediationInterstitialAdapter mediationInterstitialAdapter);

    void c(MediationInterstitialAdapter mediationInterstitialAdapter);

    void d(MediationInterstitialAdapter mediationInterstitialAdapter);

    void e(MediationInterstitialAdapter mediationInterstitialAdapter);
}
