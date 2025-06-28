package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzajq extends zzgu implements zzajo {
    zzajq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final void a() throws RemoteException {
        b(1, y());
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final void a(int i) throws RemoteException {
        Parcel y = y();
        y.writeInt(i);
        b(2, y);
    }
}
