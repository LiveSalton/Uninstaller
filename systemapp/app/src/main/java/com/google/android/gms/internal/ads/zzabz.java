package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzabz extends zzgw implements zzabw {
    public zzabz() {
        super("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
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
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                c();
                parcel2.writeNoException();
                return true;
            case 5:
                d();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
