package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdty extends zzgu implements zzdtv {
    zzdty(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    @Override // com.google.android.gms.internal.ads.zzdtv
    public final zzdtt a(zzdtr zzdtrVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzdtrVar);
        Parcel a = a(1, y);
        zzdtt zzdttVar = (zzdtt) zzgv.a(a, zzdtt.CREATOR);
        a.recycle();
        return zzdttVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtv
    public final void a(zzdtq zzdtqVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzdtqVar);
        b(2, y);
    }

    @Override // com.google.android.gms.internal.ads.zzdtv
    public final zzdud a(zzdub zzdubVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzdubVar);
        Parcel a = a(3, y);
        zzdud zzdudVar = (zzdud) zzgv.a(a, zzdud.CREATOR);
        a.recycle();
        return zzdudVar;
    }
}
