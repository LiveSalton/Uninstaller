package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzsi extends zzgu implements zzsg {
    zzsi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final zzxg a() throws RemoteException {
        Parcel a = a(2, y());
        zzxg a2 = zzxf.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void a(zzsm zzsmVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzsmVar);
        b(3, y);
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void a(IObjectWrapper iObjectWrapper, zzsq zzsqVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzsqVar);
        b(4, y);
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final zzyn b() throws RemoteException {
        Parcel a = a(5, y());
        zzyn a2 = zzyq.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
