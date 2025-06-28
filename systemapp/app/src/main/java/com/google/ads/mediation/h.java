package com.google.ads.mediation;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;

/* compiled from: source */
/* loaded from: classes.dex */
final class h implements RewardedVideoAdListener {
    private final /* synthetic */ AbstractAdViewAdapter a;

    h(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.a = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void a() {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.a.f;
        mediationRewardedVideoAdListener.b(this.a);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void b() {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.a.f;
        mediationRewardedVideoAdListener.c(this.a);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void c() {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.a.f;
        mediationRewardedVideoAdListener.d(this.a);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void d() {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.a.f;
        mediationRewardedVideoAdListener.e(this.a);
        AbstractAdViewAdapter.a(this.a, (InterstitialAd) null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void a(RewardItem rewardItem) {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.a.f;
        mediationRewardedVideoAdListener.a(this.a, rewardItem);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void e() {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.a.f;
        mediationRewardedVideoAdListener.f(this.a);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void a(int i) {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.a.f;
        mediationRewardedVideoAdListener.a(this.a, i);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void f() {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.a.f;
        mediationRewardedVideoAdListener.g(this.a);
    }
}
