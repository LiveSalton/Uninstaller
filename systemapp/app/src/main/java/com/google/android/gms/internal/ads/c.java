package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
final class c implements Runnable {
    private final /* synthetic */ zzaaa a;

    c(zzaaa zzaaaVar) {
        this.a = zzaaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaup zzaupVar;
        zzaup zzaupVar2;
        zzaupVar = this.a.a;
        if (zzaupVar != null) {
            try {
                zzaupVar2 = this.a.a;
                zzaupVar2.a(1);
            } catch (RemoteException e) {
                zzaza.d("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
