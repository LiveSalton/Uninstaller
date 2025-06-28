package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzaxt extends zzgw implements zzaxq {
    public zzaxt() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public static zzaxq a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
        if (queryLocalInterface instanceof zzaxq) {
            return (zzaxq) queryLocalInterface;
        }
        return new zzaxs(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzaxp zzaxrVar;
        switch (i) {
            case 1:
                IObjectWrapper a = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                zzaxw zzaxwVar = (zzaxw) zzgv.a(parcel, zzaxw.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzaxrVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
                    if (queryLocalInterface instanceof zzaxp) {
                        zzaxrVar = (zzaxp) queryLocalInterface;
                    } else {
                        zzaxrVar = new zzaxr(readStrongBinder);
                    }
                }
                a(a, zzaxwVar, zzaxrVar);
                parcel2.writeNoException();
                return true;
            case 2:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                IObjectWrapper a2 = a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgv.a(parcel2, a2);
                return true;
            case 4:
                IObjectWrapper b = b(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgv.a(parcel2, b);
                return true;
            case 5:
                a(parcel.createTypedArrayList(Uri.CREATOR), IObjectWrapper.Stub.a(parcel.readStrongBinder()), zzasd.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                b(parcel.createTypedArrayList(Uri.CREATOR), IObjectWrapper.Stub.a(parcel.readStrongBinder()), zzasd.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                a((zzasl) zzgv.a(parcel, zzasl.CREATOR));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
