package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzaeh extends zzgw implements zzaee {
    public zzaeh() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    public static zzaee a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
        if (queryLocalInterface instanceof zzaee) {
            return (zzaee) queryLocalInterface;
        }
        return new zzaeg(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzafv zzafuVar;
        switch (i) {
            case 2:
                float a = a();
                parcel2.writeNoException();
                parcel2.writeFloat(a);
                return true;
            case 3:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                IObjectWrapper b = b();
                parcel2.writeNoException();
                zzgv.a(parcel2, b);
                return true;
            case 5:
                float c = c();
                parcel2.writeNoException();
                parcel2.writeFloat(c);
                return true;
            case 6:
                float d = d();
                parcel2.writeNoException();
                parcel2.writeFloat(d);
                return true;
            case 7:
                zzys e = e();
                parcel2.writeNoException();
                zzgv.a(parcel2, e);
                return true;
            case 8:
                boolean f = f();
                parcel2.writeNoException();
                zzgv.a(parcel2, f);
                return true;
            case 9:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzafuVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener");
                    if (queryLocalInterface instanceof zzafv) {
                        zzafuVar = (zzafv) queryLocalInterface;
                    } else {
                        zzafuVar = new zzafu(readStrongBinder);
                    }
                }
                a(zzafuVar);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
