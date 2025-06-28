package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzyr extends zzgw implements zzys {
    public zzyr() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzys a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        if (queryLocalInterface instanceof zzys) {
            return (zzys) queryLocalInterface;
        }
        return new zzyu(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzyt zzyvVar;
        switch (i) {
            case 1:
                a();
                parcel2.writeNoException();
                return true;
            case 2:
                b();
                parcel2.writeNoException();
                return true;
            case 3:
                a(zzgv.a(parcel));
                parcel2.writeNoException();
                return true;
            case 4:
                boolean d = d();
                parcel2.writeNoException();
                zzgv.a(parcel2, d);
                return true;
            case 5:
                int e = e();
                parcel2.writeNoException();
                parcel2.writeInt(e);
                return true;
            case 6:
                float f = f();
                parcel2.writeNoException();
                parcel2.writeFloat(f);
                return true;
            case 7:
                float g = g();
                parcel2.writeNoException();
                parcel2.writeFloat(g);
                return true;
            case 8:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzyvVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    if (queryLocalInterface instanceof zzyt) {
                        zzyvVar = (zzyt) queryLocalInterface;
                    } else {
                        zzyvVar = new zzyv(readStrongBinder);
                    }
                }
                a(zzyvVar);
                parcel2.writeNoException();
                return true;
            case 9:
                float i3 = i();
                parcel2.writeNoException();
                parcel2.writeFloat(i3);
                return true;
            case 10:
                boolean j = j();
                parcel2.writeNoException();
                zzgv.a(parcel2, j);
                return true;
            case 11:
                zzyt h = h();
                parcel2.writeNoException();
                zzgv.a(parcel2, h);
                return true;
            case 12:
                boolean k = k();
                parcel2.writeNoException();
                zzgv.a(parcel2, k);
                return true;
            case 13:
                c();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
