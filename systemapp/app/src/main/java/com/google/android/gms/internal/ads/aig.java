package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: source */
/* loaded from: classes.dex */
final class aig extends AdMetadataListener {
    private final /* synthetic */ zzxj a;
    private final /* synthetic */ zzdmo b;

    aig(zzdmo zzdmoVar, zzxj zzxjVar) {
        this.b = zzdmoVar;
        this.a = zzxjVar;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void k_() {
        zzchc zzchcVar;
        zzchcVar = this.b.d;
        if (zzchcVar != null) {
            try {
                this.a.a();
            } catch (RemoteException e) {
                zzd.e("#007 Could not call remote method.", e);
            }
        }
    }
}
