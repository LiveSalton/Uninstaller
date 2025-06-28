package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;

/* compiled from: source */
/* loaded from: classes.dex */
final class de implements MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> {
    private final /* synthetic */ zzapc a;
    private final /* synthetic */ zzano b;

    de(zzapx zzapxVar, zzapc zzapcVar, zzano zzanoVar) {
        this.a = zzapcVar;
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
