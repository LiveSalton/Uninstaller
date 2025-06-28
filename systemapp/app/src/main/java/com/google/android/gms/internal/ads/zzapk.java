package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzapk extends zzgu implements zzapi {
    zzapk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzapi
    public final void a(zzaob zzaobVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzaobVar);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzapi
    public final void a(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(2, y);
    }

    @Override // com.google.android.gms.internal.ads.zzapi
    public final void a(zzve zzveVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzveVar);
        b(3, y);
    }
}
