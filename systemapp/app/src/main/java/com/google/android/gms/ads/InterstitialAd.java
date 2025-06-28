package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzva;
import com.google.android.gms.internal.ads.zzze;

/* compiled from: source */
/* loaded from: classes.dex */
public final class InterstitialAd {
    private final zzze a;

    public InterstitialAd(Context context) {
        this.a = new zzze(context);
        Preconditions.a(context, "Context cannot be null");
    }

    public final boolean a() {
        return this.a.a();
    }

    public final void a(AdRequest adRequest) {
        this.a.a(adRequest.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(AdListener adListener) {
        this.a.a(adListener);
        if (adListener != 0 && (adListener instanceof zzva)) {
            this.a.a((zzva) adListener);
        } else if (adListener == 0) {
            this.a.a((zzva) null);
        }
    }

    public final void a(String str) {
        this.a.a(str);
    }

    public final void b() {
        this.a.c();
    }

    public final void a(RewardedVideoAdListener rewardedVideoAdListener) {
        this.a.a(rewardedVideoAdListener);
    }

    public final void a(AdMetadataListener adMetadataListener) {
        this.a.a(adMetadataListener);
    }

    public final Bundle c() {
        return this.a.b();
    }

    public final void a(boolean z) {
        this.a.a(true);
    }

    public final void b(boolean z) {
        this.a.b(z);
    }
}
