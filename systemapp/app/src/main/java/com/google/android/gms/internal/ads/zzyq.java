package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzyq extends zzgw implements zzyn {
    public zzyq() {
        super("com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    public static zzyn a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
        if (queryLocalInterface instanceof zzyn) {
            return (zzyn) queryLocalInterface;
        }
        return new zzyp(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String a = a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 2:
                String b = b();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 3:
                List<zzvr> c = c();
                parcel2.writeNoException();
                parcel2.writeTypedList(c);
                return true;
            default:
                return false;
        }
    }
}
