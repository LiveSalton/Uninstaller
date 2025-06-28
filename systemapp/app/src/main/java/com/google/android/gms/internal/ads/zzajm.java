package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzajm extends zzgw implements zzajn {
    public zzajm() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzajo zzajqVar;
        switch (i) {
            case 3:
                zzys b = b();
                parcel2.writeNoException();
                zzgv.a(parcel2, b);
                return true;
            case 4:
                c();
                parcel2.writeNoException();
                return true;
            case 5:
                IObjectWrapper a = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzajqVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                    if (queryLocalInterface instanceof zzajo) {
                        zzajqVar = (zzajo) queryLocalInterface;
                    } else {
                        zzajqVar = new zzajq(readStrongBinder);
                    }
                }
                a(a, zzajqVar);
                parcel2.writeNoException();
                return true;
            case 6:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                zzaee d = d();
                parcel2.writeNoException();
                zzgv.a(parcel2, d);
                return true;
            default:
                return false;
        }
    }
}
