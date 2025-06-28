package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzari extends zzgw implements zzarj {
    public zzari() {
        super("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public static zzarj a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        if (queryLocalInterface instanceof zzarj) {
            return (zzarj) queryLocalInterface;
        }
        return new zzarl(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                a((Bundle) zzgv.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                g();
                parcel2.writeNoException();
                return true;
            case 3:
                h();
                parcel2.writeNoException();
                return true;
            case 4:
                i();
                parcel2.writeNoException();
                return true;
            case 5:
                j();
                parcel2.writeNoException();
                return true;
            case 6:
                Bundle bundle = (Bundle) zzgv.a(parcel, Bundle.CREATOR);
                b(bundle);
                parcel2.writeNoException();
                zzgv.b(parcel2, bundle);
                return true;
            case 7:
                k();
                parcel2.writeNoException();
                return true;
            case 8:
                l();
                parcel2.writeNoException();
                return true;
            case 9:
                m();
                parcel2.writeNoException();
                return true;
            case 10:
                d();
                parcel2.writeNoException();
                return true;
            case 11:
                boolean f = f();
                parcel2.writeNoException();
                zzgv.a(parcel2, f);
                return true;
            case 12:
                a(parcel.readInt(), parcel.readInt(), (Intent) zzgv.a(parcel, Intent.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 14:
                e();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
