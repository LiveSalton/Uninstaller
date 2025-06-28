package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzanl extends zzgw implements zzani {
    public zzanl() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzani a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (queryLocalInterface instanceof zzani) {
            return (zzani) queryLocalInterface;
        }
        return new zzank(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzann a = a(parcel.readString());
                parcel2.writeNoException();
                zzgv.a(parcel2, a);
                return true;
            case 2:
                boolean b = b(parcel.readString());
                parcel2.writeNoException();
                zzgv.a(parcel2, b);
                return true;
            case 3:
                zzapo c = c(parcel.readString());
                parcel2.writeNoException();
                zzgv.a(parcel2, c);
                return true;
            default:
                return false;
        }
    }
}
