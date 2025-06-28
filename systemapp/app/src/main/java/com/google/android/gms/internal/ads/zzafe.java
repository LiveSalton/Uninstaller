package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzafe extends zzgw implements zzaff {
    public zzafe() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public static zzaff a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        if (queryLocalInterface instanceof zzaff) {
            return (zzaff) queryLocalInterface;
        }
        return new zzafh(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String a = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 2:
                zzaej b = b(parcel.readString());
                parcel2.writeNoException();
                zzgv.a(parcel2, b);
                return true;
            case 3:
                List<String> a2 = a();
                parcel2.writeNoException();
                parcel2.writeStringList(a2);
                return true;
            case 4:
                String b2 = b();
                parcel2.writeNoException();
                parcel2.writeString(b2);
                return true;
            case 5:
                c(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                c();
                parcel2.writeNoException();
                return true;
            case 7:
                zzys d = d();
                parcel2.writeNoException();
                zzgv.a(parcel2, d);
                return true;
            case 8:
                e();
                parcel2.writeNoException();
                return true;
            case 9:
                IObjectWrapper f = f();
                parcel2.writeNoException();
                zzgv.a(parcel2, f);
                return true;
            case 10:
                boolean a3 = a(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgv.a(parcel2, a3);
                return true;
            case 11:
                IObjectWrapper g = g();
                parcel2.writeNoException();
                zzgv.a(parcel2, g);
                return true;
            case 12:
                boolean h = h();
                parcel2.writeNoException();
                zzgv.a(parcel2, h);
                return true;
            case 13:
                boolean i3 = i();
                parcel2.writeNoException();
                zzgv.a(parcel2, i3);
                return true;
            case 14:
                b(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                j();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
