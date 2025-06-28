package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzavm extends zzgu implements zzavn {
    zzavm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzavn
    public final IBinder a(IObjectWrapper iObjectWrapper, String str, zzani zzaniVar, int i) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        y.writeString(str);
        zzgv.a(y, zzaniVar);
        y.writeInt(203404000);
        Parcel a = a(1, y);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
