package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzagx extends zzagb {
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener a;

    public zzagx(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.a = onUnifiedNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void a(zzagj zzagjVar) {
        this.a.a(new zzagk(zzagjVar));
    }
}
