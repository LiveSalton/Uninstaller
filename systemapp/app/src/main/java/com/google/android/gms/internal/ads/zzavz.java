package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzavz extends zzavo {
    private final RewardedAdLoadCallback a;

    public zzavz(RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.a = rewardedAdLoadCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void a() {
        if (this.a != null) {
            this.a.a();
        }
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
