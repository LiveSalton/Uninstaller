package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzwv extends zzgu implements zzwt {
    zzwv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void a() throws RemoteException {
        b(1, y());
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void a(int i) throws RemoteException {
        Parcel y = y();
        y.writeInt(i);
        b(2, y);
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void b() throws RemoteException {
        b(3, y());
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void c() throws RemoteException {
        b(4, y());
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void d() throws RemoteException {
        b(5, y());
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void e() throws RemoteException {
        b(6, y());
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void f() throws RemoteException {
        b(7, y());
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final void a(zzve zzveVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzveVar);
        b(8, y);
    }
}
