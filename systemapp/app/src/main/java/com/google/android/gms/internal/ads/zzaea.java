package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzaea extends zzgw implements zzaeb {
    public zzaea() {
        super("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public static zzaeb a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
        if (queryLocalInterface instanceof zzaeb) {
            return (zzaeb) queryLocalInterface;
        }
        return new zzaed(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                String a = a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 3:
                List<zzaej> b = b();
                parcel2.writeNoException();
                parcel2.writeList(b);
                return true;
            default:
                return false;
        }
    }
}
