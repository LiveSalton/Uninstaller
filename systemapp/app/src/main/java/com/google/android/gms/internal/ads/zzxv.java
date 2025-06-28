package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzxv extends zzgw implements zzxw {
    public zzxv() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                a();
                parcel2.writeNoException();
                return true;
            case 2:
                a(parcel.readFloat());
                parcel2.writeNoException();
                return true;
            case 3:
                a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                a(zzgv.a(parcel));
                parcel2.writeNoException();
                return true;
            case 5:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                a(parcel.readString(), IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                float b = b();
                parcel2.writeNoException();
                parcel2.writeFloat(b);
                return true;
            case 8:
                boolean c = c();
                parcel2.writeNoException();
                zzgv.a(parcel2, c);
                return true;
            case 9:
                String d = d();
                parcel2.writeNoException();
                parcel2.writeString(d);
                return true;
            case 10:
                b(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                a(zzanl.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                a(zzajf.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                List<zzaiz> e = e();
                parcel2.writeNoException();
                parcel2.writeTypedList(e);
                return true;
            case 14:
                a((zzaae) zzgv.a(parcel, zzaae.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                f();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
