package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: source */
/* loaded from: classes.dex */
final class aif extends AdMetadataListener {
    private final /* synthetic */ zzyh a;
    private final /* synthetic */ zzdmi b;

    aif(zzdmi zzdmiVar, zzyh zzyhVar) {
        this.b = zzdmiVar;
        this.a = zzyhVar;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void k_() {
        zzchc zzchcVar;
        zzchcVar = this.b.f;
        if (zzchcVar != null) {
            try {
                this.a.a();
            } catch (RemoteException e) {
                zzd.e("#007 Could not call remote method.", e);
            }
        }
    }
}
