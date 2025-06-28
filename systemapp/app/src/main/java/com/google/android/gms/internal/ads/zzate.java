package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzate extends zzgw implements zzatf {
    public zzate() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                a((ParcelFileDescriptor) zzgv.a(parcel, ParcelFileDescriptor.CREATOR));
                break;
            case 2:
                a((com.google.android.gms.ads.internal.util.zzap) zzgv.a(parcel, com.google.android.gms.ads.internal.util.zzap.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
