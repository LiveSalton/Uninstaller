package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAd;
import java.lang.ref.WeakReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzsf extends zzsk {
    private final WeakReference<AppOpenAd.AppOpenAdLoadCallback> a;

    public zzsf(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.a = new WeakReference<>(appOpenAdLoadCallback);
    }

    @Override // com.google.android.gms.internal.ads.zzsl
    public final void a(zzsg zzsgVar) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.a.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.a(new zzsr(zzsgVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsl
    public final void a(int i) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.a.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.a(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsl
    public final void a(zzve zzveVar) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.a.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.a(zzveVar.b());
        }
    }
}
