package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* compiled from: source */
/* loaded from: classes.dex */
final class cz implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzano a;
    private final /* synthetic */ zzaoe b;

    cz(zzaoe zzaoeVar, zzano zzanoVar) {
        this.b = zzaoeVar;
        this.a = zzanoVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void a(String str) {
        Object obj;
        try {
            obj = this.b.a;
            String canonicalName = obj.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(31 + String.valueOf(canonicalName).length() + String.valueOf(str).length());
            sb.append(canonicalName);
            sb.append("failed to loaded mediation ad: ");
            sb.append(str);
            zzaza.b(sb.toString());
            this.a.a(0, str);
            this.a.a(0);
        } catch (RemoteException e) {
            zzaza.c("", e);
        }
    }
}
