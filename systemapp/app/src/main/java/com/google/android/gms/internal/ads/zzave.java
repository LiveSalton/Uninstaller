package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzave extends zzgu implements zzavc {
    zzave(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    @Override // com.google.android.gms.internal.ads.zzavc
    public final String a() throws RemoteException {
        Parcel a = a(1, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzavc
    public final int b() throws RemoteException {
        Parcel a = a(2, y());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
