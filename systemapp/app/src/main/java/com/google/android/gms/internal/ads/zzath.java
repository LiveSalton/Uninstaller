package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzath extends zzgu implements zzatf {
    zzath(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzatf
    public final void a(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, parcelFileDescriptor);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzatf
    public final void a(com.google.android.gms.ads.internal.util.zzap zzapVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzapVar);
        b(2, y);
    }
}
