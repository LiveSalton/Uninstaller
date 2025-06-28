package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzxk extends zzgu implements zzxh {
    zzxk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final IBinder a(IObjectWrapper iObjectWrapper, zzvn zzvnVar, String str, zzani zzaniVar, int i, int i2) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzvnVar);
        y.writeString(str);
        zzgv.a(y, zzaniVar);
        y.writeInt(203404000);
        y.writeInt(i2);
        Parcel a = a(2, y);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
