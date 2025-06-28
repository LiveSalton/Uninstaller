package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzauz extends zzgw implements zzauw {
    public zzauz() {
        super("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public static zzauw a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        if (queryLocalInterface instanceof zzauw) {
            return (zzauw) queryLocalInterface;
        }
        return new zzauy(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                break;
            case 2:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                b(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                break;
            case 4:
                c(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                break;
            case 5:
                d(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                break;
            case 6:
                e(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                break;
            case 7:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), (zzava) zzgv.a(parcel, zzava.CREATOR));
                break;
            case 8:
                f(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                break;
            case 9:
                b(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                g(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                break;
            case 11:
                h(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                break;
            case 12:
                a((Bundle) zzgv.a(parcel, Bundle.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
