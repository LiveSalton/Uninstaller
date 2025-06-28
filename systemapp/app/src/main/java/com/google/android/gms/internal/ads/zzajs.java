package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzajs extends zzgw implements zzajt {
    public zzajs() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    public static zzajt a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
        if (queryLocalInterface instanceof zzajt) {
            return (zzajt) queryLocalInterface;
        }
        return new zzajv(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzajn zzajpVar;
        switch (i) {
            case 1:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzajpVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
                    if (queryLocalInterface instanceof zzajn) {
                        zzajpVar = (zzajn) queryLocalInterface;
                    } else {
                        zzajpVar = new zzajp(readStrongBinder);
                    }
                }
                a(zzajpVar);
                break;
            case 2:
                a(parcel.readInt());
                break;
            case 3:
                a((zzve) zzgv.a(parcel, zzve.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
