package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* compiled from: source */
/* loaded from: classes.dex */
public interface MediationNativeListener {
    void a(MediationNativeAdapter mediationNativeAdapter);

    @Deprecated
    void a(MediationNativeAdapter mediationNativeAdapter, int i);

    void a(MediationNativeAdapter mediationNativeAdapter, AdError adError);

    void a(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd);

    void a(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd, String str);

    @Deprecated
    void a(MediationNativeAdapter mediationNativeAdapter, NativeAdMapper nativeAdMapper);

    void a(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper);

    void b(MediationNativeAdapter mediationNativeAdapter);

    void c(MediationNativeAdapter mediationNativeAdapter);

    void d(MediationNativeAdapter mediationNativeAdapter);

    void e(MediationNativeAdapter mediationNativeAdapter);
}
