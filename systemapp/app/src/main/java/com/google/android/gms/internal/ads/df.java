package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

/* compiled from: source */
/* loaded from: classes.dex */
final class df implements MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> {
    private final /* synthetic */ zzapi a;
    private final /* synthetic */ zzano b;

    df(zzapx zzapxVar, zzapi zzapiVar, zzano zzanoVar) {
        this.a = zzapiVar;
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
