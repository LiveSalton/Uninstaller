package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzyg extends zzgw implements zzyd {
    public zzyg() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    public static zzyd a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
        if (queryLocalInterface instanceof zzyd) {
            return (zzyd) queryLocalInterface;
        }
        return new zzyf(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String a = a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 2:
                String b = b();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            default:
                return false;
        }
    }
}
