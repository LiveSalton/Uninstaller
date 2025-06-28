package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzank extends zzgu implements zzani {
    zzank(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final zzann a(String str) throws RemoteException {
        zzann zzanpVar;
        Parcel y = y();
        y.writeString(str);
        Parcel a = a(1, y);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzanpVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (queryLocalInterface instanceof zzann) {
                zzanpVar = (zzann) queryLocalInterface;
            } else {
                zzanpVar = new zzanp(readStrongBinder);
            }
        }
        a.recycle();
        return zzanpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final boolean b(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        Parcel a = a(2, y);
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final zzapo c(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        Parcel a = a(3, y);
        zzapo a2 = zzapr.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
