package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;

/* compiled from: source */
/* loaded from: classes.dex */
final class dg implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {
    private final /* synthetic */ zzaph a;
    private final /* synthetic */ zzano b;
    private final /* synthetic */ zzapx c;

    dg(zzapx zzapxVar, zzaph zzaphVar, zzano zzanoVar) {
        this.c = zzapxVar;
        this.a = zzaphVar;
        this.b = zzanoVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void a(String str) {
        try {
            this.a.a(str);
        } catch (RemoteException e) {
            zzaza.c("", e);
        }
    }
}
