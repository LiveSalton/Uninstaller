package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzyl extends zzgw implements zzym {
    public zzyl() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public static zzym a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        if (queryLocalInterface instanceof zzym) {
            return (zzym) queryLocalInterface;
        }
        return new zzyo(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        a((zzvp) zzgv.a(parcel, zzvp.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
