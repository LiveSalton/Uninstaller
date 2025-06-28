package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* compiled from: source */
/* loaded from: classes.dex */
final class dh implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzapn a;
    private final /* synthetic */ zzano b;
    private final /* synthetic */ zzapx c;

    dh(zzapx zzapxVar, zzapn zzapnVar, zzano zzanoVar) {
        this.c = zzapxVar;
        this.a = zzapnVar;
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
