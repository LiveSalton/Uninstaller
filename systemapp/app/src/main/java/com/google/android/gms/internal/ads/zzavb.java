package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzavb implements MediationRewardedVideoAdListener {
    private final zzauw a;

    public zzavb(zzauw zzauwVar) {
        this.a = zzauwVar;
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void a(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onInitializationSucceeded.");
        try {
            this.a.a(ObjectWrapper.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void b(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdLoaded.");
        try {
            this.a.b(ObjectWrapper.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void c(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdOpened.");
        try {
            this.a.c(ObjectWrapper.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void d(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onVideoStarted.");
        try {
            this.a.d(ObjectWrapper.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void e(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdClosed.");
        try {
            this.a.e(ObjectWrapper.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void a(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onRewarded.");
        try {
            if (rewardItem != null) {
                this.a.a(ObjectWrapper.a(mediationRewardedVideoAdAdapter), new zzava(rewardItem));
            } else {
                this.a.a(ObjectWrapper.a(mediationRewardedVideoAdAdapter), new zzava("", 1));
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void a(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdFailedToLoad.");
        try {
            this.a.b(ObjectWrapper.a(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void f(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdLeftApplication.");
        try {
            this.a.g(ObjectWrapper.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void g(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onVideoCompleted.");
        try {
            this.a.h(ObjectWrapper.a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void a(Bundle bundle) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdMetadataChanged.");
        try {
            this.a.a(bundle);
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }
}
