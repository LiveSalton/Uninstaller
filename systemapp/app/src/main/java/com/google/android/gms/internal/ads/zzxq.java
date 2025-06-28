package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzxq extends zzgu implements zzxo {
    zzxq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    @Override // com.google.android.gms.internal.ads.zzxo
    public final void a(String str, String str2) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        y.writeString(str2);
        b(1, y);
    }
}
