package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzacd extends zzgu implements zzacb {
    zzacd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzacb
    public final void a(zzabw zzabwVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzabwVar);
        b(1, y);
    }
}
