package com.google.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;

/* compiled from: source */
/* loaded from: classes.dex */
final class g extends AdMetadataListener {
    private final /* synthetic */ AbstractAdViewAdapter a;

    g(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.a = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void k_() {
        InterstitialAd interstitialAd;
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        InterstitialAd interstitialAd2;
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener2;
        interstitialAd = this.a.e;
        if (interstitialAd != null) {
            mediationRewardedVideoAdListener = this.a.f;
            if (mediationRewardedVideoAdListener != null) {
                interstitialAd2 = this.a.e;
                Bundle c = interstitialAd2.c();
                mediationRewardedVideoAdListener2 = this.a.f;
                mediationRewardedVideoAdListener2.a(c);
            }
        }
    }
}
