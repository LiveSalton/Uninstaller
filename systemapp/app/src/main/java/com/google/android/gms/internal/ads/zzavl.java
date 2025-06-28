package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzavl extends zzgw implements zzavi {
    public zzavl() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzavc zzaveVar;
        switch (i) {
            case 1:
                a();
                break;
            case 2:
                b();
                break;
            case 3:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzaveVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
                    if (queryLocalInterface instanceof zzavc) {
                        zzaveVar = (zzavc) queryLocalInterface;
                    } else {
                        zzaveVar = new zzave(readStrongBinder);
                    }
                }
                a(zzaveVar);
                break;
            case 4:
                a(parcel.readInt());
                break;
            case 5:
                a((zzve) zzgv.a(parcel, zzve.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
