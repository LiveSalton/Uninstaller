package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;

/* compiled from: source */
/* loaded from: classes.dex */
public interface MediationBannerListener {
    void a(MediationBannerAdapter mediationBannerAdapter);

    @Deprecated
    void a(MediationBannerAdapter mediationBannerAdapter, int i);

    void a(MediationBannerAdapter mediationBannerAdapter, AdError adError);

    void a(MediationBannerAdapter mediationBannerAdapter, String str, String str2);

    void b(MediationBannerAdapter mediationBannerAdapter);

    void c(MediationBannerAdapter mediationBannerAdapter);

    void d(MediationBannerAdapter mediationBannerAdapter);

    void e(MediationBannerAdapter mediationBannerAdapter);
}
