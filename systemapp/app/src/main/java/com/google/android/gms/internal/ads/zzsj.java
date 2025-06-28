package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzsj extends zzgw implements zzsg {
    public zzsj() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzsm zzsmVar = null;
        zzsq zzsqVar = null;
        switch (i) {
            case 2:
                zzxg a = a();
                parcel2.writeNoException();
                zzgv.a(parcel2, a);
                return true;
            case 3:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
                    if (queryLocalInterface instanceof zzsm) {
                        zzsmVar = (zzsm) queryLocalInterface;
                    } else {
                        zzsmVar = new zzso(readStrongBinder);
                    }
                }
                a(zzsmVar);
                parcel2.writeNoException();
                return true;
            case 4:
                IObjectWrapper a2 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
                    if (queryLocalInterface2 instanceof zzsq) {
                        zzsqVar = (zzsq) queryLocalInterface2;
                    } else {
                        zzsqVar = new zzss(readStrongBinder2);
                    }
                }
                a(a2, zzsqVar);
                parcel2.writeNoException();
                return true;
            case 5:
                zzyn b = b();
                parcel2.writeNoException();
                zzgv.a(parcel2, b);
                return true;
            default:
                return false;
        }
    }
}
