package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzauo extends zzgw implements zzaup {
    public zzauo() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    public static zzaup a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
        if (queryLocalInterface instanceof zzaup) {
            return (zzaup) queryLocalInterface;
        }
        return new zzaur(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzauf zzauhVar;
        switch (i) {
            case 1:
                a();
                break;
            case 2:
                b();
                break;
            case 3:
                c();
                break;
            case 4:
                d();
                break;
            case 5:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzauhVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardItem");
                    if (queryLocalInterface instanceof zzauf) {
                        zzauhVar = (zzauf) queryLocalInterface;
                    } else {
                        zzauhVar = new zzauh(readStrongBinder);
                    }
                }
                a(zzauhVar);
                break;
            case 6:
                e();
                break;
            case 7:
                a(parcel.readInt());
                break;
            case 8:
                f();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
