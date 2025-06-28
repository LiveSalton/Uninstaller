package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzajd extends zzgu implements zzajb {
    zzajd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzajb
    public final void a() throws RemoteException {
        b(2, y());
    }

    @Override // com.google.android.gms.internal.ads.zzajb
    public final void a(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(3, y);
    }
}
