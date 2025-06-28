package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* compiled from: source */
/* loaded from: classes.dex */
final class dk implements zzp {
    private final /* synthetic */ zzaqe a;

    dk(zzaqe zzaqeVar) {
        this.a = zzaqeVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void f_() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void a(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        MediationInterstitialListener mediationInterstitialListener;
        zzaza.b("AdMobCustomTabsAdapter overlay is closed.");
        mediationInterstitialListener = this.a.b;
        mediationInterstitialListener.c(this.a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void b_() {
        zzaza.b("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void g_() {
        zzaza.b("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void e_() {
        MediationInterstitialListener mediationInterstitialListener;
        zzaza.b("Opening AdMobCustomTabsAdapter overlay.");
        mediationInterstitialListener = this.a.b;
        mediationInterstitialListener.b(this.a);
    }
}
