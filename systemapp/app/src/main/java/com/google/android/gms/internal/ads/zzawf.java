package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzawf extends zzavo {
    private final RewardedInterstitialAdLoadCallback a;
    private final zzawe b;

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void a() {
        if (this.a == null || this.b == null) {
            return;
        }
        this.a.a(this.b);
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void a(int i) {
        if (this.a != null) {
            this.a.a(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void a(zzve zzveVar) {
        if (this.a != null) {
            this.a.a(zzveVar.b());
        }
    }
}
