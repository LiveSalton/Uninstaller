package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zzg extends zza implements zze {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // com.google.android.gms.internal.ads_identifier.zze
    public final String a() throws RemoteException {
        Parcel a = a(1, n_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads_identifier.zze
    public final boolean a(boolean z) throws RemoteException {
        Parcel n_ = n_();
        zzc.a(n_, true);
        Parcel a = a(2, n_);
        boolean a2 = zzc.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads_identifier.zze
    public final boolean b() throws RemoteException {
        Parcel a = a(6, n_());
        boolean a2 = zzc.a(a);
        a.recycle();
        return a2;
    }
}
