package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzww extends zzgw implements zzwt {
    public zzww() {
        super("com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                a();
                break;
            case 2:
                a(parcel.readInt());
                break;
            case 3:
                b();
                break;
            case 4:
                c();
                break;
            case 5:
                d();
                break;
            case 6:
                e();
                break;
            case 7:
                f();
                break;
            case 8:
                a((zzve) zzgv.a(parcel, zzve.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
