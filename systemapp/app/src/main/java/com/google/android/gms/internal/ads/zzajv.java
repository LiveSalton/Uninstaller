package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzajv extends zzgu implements zzajt {
    zzajv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzajt
    public final void a(zzajn zzajnVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzajnVar);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzajt
    public final void a(int i) throws RemoteException {
        Parcel y = y();
        y.writeInt(i);
        b(2, y);
    }

    @Override // com.google.android.gms.internal.ads.zzajt
    public final void a(zzve zzveVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzveVar);
        b(3, y);
    }
}
