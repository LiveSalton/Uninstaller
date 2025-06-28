package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzagt extends zzafi {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener a;

    public zzagt(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.a = onAppInstallAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final void a(zzaex zzaexVar) {
        this.a.a(new zzaey(zzaexVar));
    }
}
