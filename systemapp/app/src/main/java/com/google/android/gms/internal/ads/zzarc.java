package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzarc extends zzgu implements zzarb {
    zzarc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtilsCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzarb
    public final zzaqw a(IObjectWrapper iObjectWrapper, zzani zzaniVar, int i) throws RemoteException {
        zzaqw zzaqyVar;
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzaniVar);
        y.writeInt(203404000);
        Parcel a = a(1, y);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzaqyVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
            if (queryLocalInterface instanceof zzaqw) {
                zzaqyVar = (zzaqw) queryLocalInterface;
            } else {
                zzaqyVar = new zzaqy(readStrongBinder);
            }
        }
        a.recycle();
        return zzaqyVar;
    }
}
