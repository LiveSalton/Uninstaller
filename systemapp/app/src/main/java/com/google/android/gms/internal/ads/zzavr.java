package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzavr extends zzgu implements zzavp {
    zzavr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void a() throws RemoteException {
        b(1, y());
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void a(int i) throws RemoteException {
        Parcel y = y();
        y.writeInt(i);
        b(2, y);
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void a(zzve zzveVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzveVar);
        b(3, y);
    }
}
