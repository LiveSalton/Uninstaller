package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.a;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.e;
import com.google.ads.mediation.f;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaop<NETWORK_EXTRAS extends com.google.ads.mediation.f, SERVER_PARAMETERS extends com.google.ads.mediation.e> implements com.google.ads.mediation.c, com.google.ads.mediation.d {
    private final zzano a;

    public zzaop(zzano zzanoVar) {
        this.a = zzanoVar;
    }

    @Override // com.google.ads.mediation.c
    public final void a(MediationBannerAdapter<?, ?> mediationBannerAdapter, a.EnumC0056a enumC0056a) {
        String valueOf = String.valueOf(enumC0056a);
        StringBuilder sb = new StringBuilder(47 + String.valueOf(valueOf).length());
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(valueOf);
        zzaza.b(sb.toString());
        zzwq.a();
        if (!zzayr.b()) {
            zzaza.e("#008 Must be called on the main UI thread.", null);
            zzayr.a.post(new db(this, enumC0056a));
        } else {
            try {
                this.a.a(zzapb.a(enumC0056a));
            } catch (RemoteException e) {
                zzaza.e("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.d
    public final void a(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, a.EnumC0056a enumC0056a) {
        String valueOf = String.valueOf(enumC0056a);
        StringBuilder sb = new StringBuilder(47 + String.valueOf(valueOf).length());
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(valueOf);
        sb.append(".");
        zzaza.b(sb.toString());
        zzwq.a();
        if (!zzayr.b()) {
            zzaza.e("#008 Must be called on the main UI thread.", null);
            zzayr.a.post(new dc(this, enumC0056a));
        } else {
            try {
                this.a.a(zzapb.a(enumC0056a));
            } catch (RemoteException e) {
                zzaza.e("#007 Could not call remote method.", e);
            }
        }
    }
}
