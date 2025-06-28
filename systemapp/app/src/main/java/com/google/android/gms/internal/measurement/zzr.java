package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzr extends zzc implements zzs {
    public zzr() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzc
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                a(parcel.readString(), parcel.readString(), (Bundle) zzb.a(parcel, Bundle.CREATOR), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 2:
                int r_ = r_();
                parcel2.writeNoException();
                parcel2.writeInt(r_);
                return true;
            default:
                return false;
        }
    }
}
