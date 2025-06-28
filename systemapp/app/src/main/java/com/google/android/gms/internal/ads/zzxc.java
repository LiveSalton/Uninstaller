package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzxc extends zzgw implements zzwz {
    public zzxc() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzwt zzwtVar = null;
        zzxu zzxuVar = null;
        switch (i) {
            case 1:
                zzwy a = a();
                parcel2.writeNoException();
                zzgv.a(parcel2, a);
                return true;
            case 2:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    if (queryLocalInterface instanceof zzwt) {
                        zzwtVar = (zzwt) queryLocalInterface;
                    } else {
                        zzwtVar = new zzwv(readStrongBinder);
                    }
                }
                a(zzwtVar);
                parcel2.writeNoException();
                return true;
            case 3:
                a(zzafi.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                a(zzafn.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                a(parcel.readString(), zzaft.a(parcel.readStrongBinder()), zzafo.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                a((zzadz) zzgv.a(parcel, zzadz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (queryLocalInterface2 instanceof zzxu) {
                        zzxuVar = (zzxu) queryLocalInterface2;
                    } else {
                        zzxuVar = new zzxt(readStrongBinder2);
                    }
                }
                a(zzxuVar);
                parcel2.writeNoException();
                return true;
            case 8:
                a(zzafw.a(parcel.readStrongBinder()), (zzvn) zzgv.a(parcel, zzvn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 9:
                a((PublisherAdViewOptions) zzgv.a(parcel, PublisherAdViewOptions.CREATOR));
                parcel2.writeNoException();
                return true;
            case 10:
                a(zzagb.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
            case 12:
            default:
                return false;
            case 13:
                a((zzajl) zzgv.a(parcel, zzajl.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                a(zzajs.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
        }
    }
}
