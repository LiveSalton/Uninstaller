package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzsk extends zzgw implements zzsl {
    public zzsk() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public static zzsl a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
        if (queryLocalInterface instanceof zzsl) {
            return (zzsl) queryLocalInterface;
        }
        return new zzsn(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzsg zzsiVar;
        switch (i) {
            case 1:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzsiVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
                    if (queryLocalInterface instanceof zzsg) {
                        zzsiVar = (zzsg) queryLocalInterface;
                    } else {
                        zzsiVar = new zzsi(readStrongBinder);
                    }
                }
                a(zzsiVar);
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
