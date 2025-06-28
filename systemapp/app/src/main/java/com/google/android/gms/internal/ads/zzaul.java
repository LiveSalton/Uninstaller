package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzaul extends zzgw implements zzaui {
    public zzaul() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public static zzaui a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        if (queryLocalInterface instanceof zzaui) {
            return (zzaui) queryLocalInterface;
        }
        return new zzauk(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 34) {
            zzaup zzaupVar = null;
            zzaug zzaugVar = null;
            switch (i) {
                case 1:
                    a((zzauv) zzgv.a(parcel, zzauv.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    a();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                        if (queryLocalInterface instanceof zzaup) {
                            zzaupVar = (zzaup) queryLocalInterface;
                        } else {
                            zzaupVar = new zzaur(readStrongBinder);
                        }
                    }
                    a(zzaupVar);
                    parcel2.writeNoException();
                    return true;
                default:
                    switch (i) {
                        case 5:
                            boolean c = c();
                            parcel2.writeNoException();
                            zzgv.a(parcel2, c);
                            return true;
                        case 6:
                            d();
                            parcel2.writeNoException();
                            return true;
                        case 7:
                            e();
                            parcel2.writeNoException();
                            return true;
                        case 8:
                            f();
                            parcel2.writeNoException();
                            return true;
                        case 9:
                            b(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 10:
                            c(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 11:
                            d(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 12:
                            String g = g();
                            parcel2.writeNoException();
                            parcel2.writeString(g);
                            return true;
                        case 13:
                            a(parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 14:
                            a(zzxm.a(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 15:
                            Bundle b = b();
                            parcel2.writeNoException();
                            zzgv.b(parcel2, b);
                            return true;
                        case 16:
                            IBinder readStrongBinder2 = parcel.readStrongBinder();
                            if (readStrongBinder2 != null) {
                                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
                                if (queryLocalInterface2 instanceof zzaug) {
                                    zzaugVar = (zzaug) queryLocalInterface2;
                                } else {
                                    zzaugVar = new zzauj(readStrongBinder2);
                                }
                            }
                            a(zzaugVar);
                            parcel2.writeNoException();
                            return true;
                        case 17:
                            c(parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 18:
                            a(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 19:
                            b(parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 20:
                            boolean h = h();
                            parcel2.writeNoException();
                            zzgv.a(parcel2, h);
                            return true;
                        case 21:
                            zzyn i3 = i();
                            parcel2.writeNoException();
                            zzgv.a(parcel2, i3);
                            return true;
                        default:
                            return false;
                    }
            }
        }
        a(zzgv.a(parcel));
        parcel2.writeNoException();
        return true;
    }
}
