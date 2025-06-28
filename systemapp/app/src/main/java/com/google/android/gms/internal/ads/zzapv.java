package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzapv extends zzgu implements zzapt {
    zzapv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void a(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void b(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(2, y);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void a(zzve zzveVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzveVar);
        b(3, y);
    }
}
