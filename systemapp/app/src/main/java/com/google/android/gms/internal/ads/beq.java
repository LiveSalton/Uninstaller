package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
final class beq implements Runnable {
    private final /* synthetic */ beo a;

    beq(beo beoVar) {
        this.a = beoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzwt zzwtVar;
        zzwt zzwtVar2;
        zzwtVar = this.a.a.a;
        if (zzwtVar != null) {
            try {
                zzwtVar2 = this.a.a.a;
                zzwtVar2.a(1);
            } catch (RemoteException e) {
                zzaza.d("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
