package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzajp extends zzgu implements zzajn {
    zzajp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzajn
    public final zzys b() throws RemoteException {
        Parcel a = a(3, y());
        zzys a2 = zzyr.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzajn
    public final void c() throws RemoteException {
        b(4, y());
    }

    @Override // com.google.android.gms.internal.ads.zzajn
    public final void a(IObjectWrapper iObjectWrapper, zzajo zzajoVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzajoVar);
        b(5, y);
    }

    @Override // com.google.android.gms.internal.ads.zzajn
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(6, y);
    }

    @Override // com.google.android.gms.internal.ads.zzajn
    public final zzaee d() throws RemoteException {
        Parcel a = a(7, y());
        zzaee a2 = zzaeh.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
