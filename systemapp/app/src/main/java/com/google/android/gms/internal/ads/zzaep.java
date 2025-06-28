package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaep extends zzgu implements zzaen {
    zzaep(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final void a(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        zzgv.a(y, iObjectWrapper);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final IObjectWrapper a(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        Parcel a = a(2, y);
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(3, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final void a() throws RemoteException {
        b(4, y());
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final void a(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        y.writeInt(i);
        b(5, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final void b(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(6, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final void c(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(7, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final void a(zzaee zzaeeVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzaeeVar);
        b(8, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final void d(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(9, y);
    }
}
