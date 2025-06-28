package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzbge extends zzgw implements zzbgf {
    public zzbge() {
        super("com.google.android.gms.ads.measurement.IAppMeasurementProxy");
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                a((Bundle) zzgv.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                Bundle b = b((Bundle) zzgv.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzgv.b(parcel2, b);
                return true;
            case 3:
                a(parcel.readString(), parcel.readString(), (Bundle) zzgv.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 4:
                a(parcel.readString(), parcel.readString(), IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                Map a = a(parcel.readString(), parcel.readString(), zzgv.a(parcel));
                parcel2.writeNoException();
                parcel2.writeMap(a);
                return true;
            case 6:
                int a2 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a2);
                return true;
            case 7:
                c((Bundle) zzgv.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 8:
                b(parcel.readString(), parcel.readString(), (Bundle) zzgv.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 9:
                List a3 = a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeList(a3);
                return true;
            case 10:
                String a4 = a();
                parcel2.writeNoException();
                parcel2.writeString(a4);
                return true;
            case 11:
                String b2 = b();
                parcel2.writeNoException();
                parcel2.writeString(b2);
                return true;
            case 12:
                long c = c();
                parcel2.writeNoException();
                parcel2.writeLong(c);
                return true;
            case 13:
                b(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 14:
                c(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 15:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
                String d = d();
                parcel2.writeNoException();
                parcel2.writeString(d);
                return true;
            case 17:
                String e = e();
                parcel2.writeNoException();
                parcel2.writeString(e);
                return true;
            case 18:
                String f = f();
                parcel2.writeNoException();
                parcel2.writeString(f);
                return true;
            default:
                return false;
        }
    }
}
