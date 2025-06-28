package com.google.android.gms.ads.rewarded;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzavs;

/* compiled from: source */
/* loaded from: classes.dex */
public final class RewardedAd {
    private final zzavs a;

    public RewardedAd(Context context, String str) {
        Preconditions.a(context, "context cannot be null");
        Preconditions.a(str, (Object) "adUnitID cannot be null");
        this.a = new zzavs(context, str);
    }

    public final void a(AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.a.a(adRequest.a(), rewardedAdLoadCallback);
    }
}
