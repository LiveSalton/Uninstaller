package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzajf extends zzgw implements zzajc {
    public zzajf() {
        super("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public static zzajc a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
        if (queryLocalInterface instanceof zzajc) {
            return (zzajc) queryLocalInterface;
        }
        return new zzaje(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        a(parcel.createTypedArrayList(zzaiz.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
