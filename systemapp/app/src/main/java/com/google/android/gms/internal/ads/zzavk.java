package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzavk extends zzgu implements zzavi {
    zzavk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzavi
    public final void a() throws RemoteException {
        b(1, y());
    }

    @Override // com.google.android.gms.internal.ads.zzavi
    public final void b() throws RemoteException {
        b(2, y());
    }

    @Override // com.google.android.gms.internal.ads.zzavi
    public final void a(zzavc zzavcVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzavcVar);
        b(3, y);
    }

    @Override // com.google.android.gms.internal.ads.zzavi
    public final void a(int i) throws RemoteException {
        Parcel y = y();
        y.writeInt(i);
        b(4, y);
    }

    @Override // com.google.android.gms.internal.ads.zzavi
    public final void a(zzve zzveVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzveVar);
        b(5, y);
    }
}
