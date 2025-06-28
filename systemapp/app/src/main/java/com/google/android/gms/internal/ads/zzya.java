package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzya extends zzgu implements zzxx {
    zzya(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzxx
    public final IBinder a(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        y.writeInt(203404000);
        Parcel a = a(1, y);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
