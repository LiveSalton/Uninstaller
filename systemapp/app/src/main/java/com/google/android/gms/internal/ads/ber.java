package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
final class ber implements Runnable {
    private final /* synthetic */ zzzs a;

    ber(zzzs zzzsVar) {
        this.a = zzzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzwt zzwtVar;
        zzwt zzwtVar2;
        zzwtVar = this.a.a;
        if (zzwtVar != null) {
            try {
                zzwtVar2 = this.a.a;
                zzwtVar2.a(1);
            } catch (RemoteException e) {
                zzaza.d("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
