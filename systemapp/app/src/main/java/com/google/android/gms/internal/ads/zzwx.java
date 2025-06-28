package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzwx extends zzgw implements zzwy {
    public zzwx() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                a((zzvk) zzgv.a(parcel, zzvk.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                String b = b();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 3:
                boolean a = a();
                parcel2.writeNoException();
                zzgv.a(parcel2, a);
                return true;
            case 4:
                String c = c();
                parcel2.writeNoException();
                parcel2.writeString(c);
                return true;
            case 5:
                a((zzvk) zzgv.a(parcel, zzvk.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
