package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzaei extends zzgw implements zzaej {
    public zzaei() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzaej a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        if (queryLocalInterface instanceof zzaej) {
            return (zzaej) queryLocalInterface;
        }
        return new zzael(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                IObjectWrapper a = a();
                parcel2.writeNoException();
                zzgv.a(parcel2, a);
                return true;
            case 2:
                Uri b = b();
                parcel2.writeNoException();
                zzgv.b(parcel2, b);
                return true;
            case 3:
                double c = c();
                parcel2.writeNoException();
                parcel2.writeDouble(c);
                return true;
            case 4:
                int d = d();
                parcel2.writeNoException();
                parcel2.writeInt(d);
                return true;
            case 5:
                int e = e();
                parcel2.writeNoException();
                parcel2.writeInt(e);
                return true;
            default:
                return false;
        }
    }
}
