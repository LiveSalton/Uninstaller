package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzaqz extends zzgw implements zzaqw {
    public zzaqz() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public static zzaqw a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
        if (queryLocalInterface instanceof zzaqw) {
            return (zzaqw) queryLocalInterface;
        }
        return new zzaqy(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                a((Intent) zzgv.a(parcel, Intent.CREATOR));
                break;
            case 2:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                break;
            case 3:
                a();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
