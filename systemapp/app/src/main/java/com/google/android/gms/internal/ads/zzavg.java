package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzavg extends zzgw implements zzavh {
    public zzavg() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzavh a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        if (queryLocalInterface instanceof zzavh) {
            return (zzavh) queryLocalInterface;
        }
        return new zzavj(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzavp zzavpVar = null;
        zzavp zzavpVar2 = null;
        zzavq zzavqVar = null;
        zzavi zzaviVar = null;
        switch (i) {
            case 1:
                zzvk zzvkVar = (zzvk) zzgv.a(parcel, zzvk.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    if (queryLocalInterface instanceof zzavp) {
                        zzavpVar = (zzavp) queryLocalInterface;
                    } else {
                        zzavpVar = new zzavr(readStrongBinder);
                    }
                }
                a(zzvkVar, zzavpVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
                    if (queryLocalInterface2 instanceof zzavi) {
                        zzaviVar = (zzavi) queryLocalInterface2;
                    } else {
                        zzaviVar = new zzavk(readStrongBinder2);
                    }
                }
                a(zzaviVar);
                parcel2.writeNoException();
                return true;
            case 3:
                boolean a = a();
                parcel2.writeNoException();
                zzgv.a(parcel2, a);
                return true;
            case 4:
                String b = b();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 5:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
                    if (queryLocalInterface3 instanceof zzavq) {
                        zzavqVar = (zzavq) queryLocalInterface3;
                    } else {
                        zzavqVar = new zzavt(readStrongBinder3);
                    }
                }
                a(zzavqVar);
                parcel2.writeNoException();
                return true;
            case 7:
                a((zzavy) zzgv.a(parcel, zzavy.CREATOR));
                parcel2.writeNoException();
                return true;
            case 8:
                a(zzyk.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                Bundle c = c();
                parcel2.writeNoException();
                zzgv.b(parcel2, c);
                return true;
            case 10:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), zzgv.a(parcel));
                parcel2.writeNoException();
                return true;
            case 11:
                zzavc d = d();
                parcel2.writeNoException();
                zzgv.a(parcel2, d);
                return true;
            case 12:
                zzyn e = e();
                parcel2.writeNoException();
                zzgv.a(parcel2, e);
                return true;
            case 13:
                a(zzyl.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 14:
                zzvk zzvkVar2 = (zzvk) zzgv.a(parcel, zzvk.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    if (queryLocalInterface4 instanceof zzavp) {
                        zzavpVar2 = (zzavp) queryLocalInterface4;
                    } else {
                        zzavpVar2 = new zzavr(readStrongBinder4);
                    }
                }
                b(zzvkVar2, zzavpVar2);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
