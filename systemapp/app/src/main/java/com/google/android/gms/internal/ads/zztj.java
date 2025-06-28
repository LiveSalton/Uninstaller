package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zztj extends zzgu implements zztg {
    zztj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    @Override // com.google.android.gms.internal.ads.zztg
    public final zzta a(zztf zztfVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zztfVar);
        Parcel a = a(1, y);
        zzta zztaVar = (zzta) zzgv.a(a, zzta.CREATOR);
        a.recycle();
        return zztaVar;
    }

    @Override // com.google.android.gms.internal.ads.zztg
    public final zzta b(zztf zztfVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zztfVar);
        Parcel a = a(2, y);
        zzta zztaVar = (zzta) zzgv.a(a, zzta.CREATOR);
        a.recycle();
        return zztaVar;
    }

    @Override // com.google.android.gms.internal.ads.zztg
    public final long c(zztf zztfVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zztfVar);
        Parcel a = a(3, y);
        long readLong = a.readLong();
        a.recycle();
        return readLong;
    }
}
