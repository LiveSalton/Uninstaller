package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* compiled from: source */
/* loaded from: classes.dex */
final class y extends zzaft {
    private final /* synthetic */ zzagp a;

    /* JADX INFO: Access modifiers changed from: private */
    y(zzagp zzagpVar) {
        this.a = zzagpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafq
    public final void a(zzaff zzaffVar) {
        NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener;
        NativeCustomTemplateAd a;
        onCustomTemplateAdLoadedListener = this.a.a;
        a = this.a.a(zzaffVar);
        onCustomTemplateAdLoadedListener.a(a);
    }

    /* synthetic */ y(zzagp zzagpVar, x xVar) {
        this(zzagpVar);
    }
}
