package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzanx extends zzgu implements zzanv {
    zzanx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final String a() throws RemoteException {
        Parcel a = a(2, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final List b() throws RemoteException {
        Parcel a = a(3, y());
        ArrayList b = zzgv.b(a);
        a.recycle();
        return b;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final String c() throws RemoteException {
        Parcel a = a(4, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final zzaej d() throws RemoteException {
        Parcel a = a(5, y());
        zzaej a2 = zzaei.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final String e() throws RemoteException {
        Parcel a = a(6, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final double f() throws RemoteException {
        Parcel a = a(7, y());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final String g() throws RemoteException {
        Parcel a = a(8, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final String h() throws RemoteException {
        Parcel a = a(9, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final void i() throws RemoteException {
        b(10, y());
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(11, y);
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final void b(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(12, y);
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final boolean j() throws RemoteException {
        Parcel a = a(13, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final boolean k() throws RemoteException {
        Parcel a = a(14, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final Bundle l() throws RemoteException {
        Parcel a = a(15, y());
        Bundle bundle = (Bundle) zzgv.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final void c(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(16, y);
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final zzys m() throws RemoteException {
        Parcel a = a(17, y());
        zzys a2 = zzyr.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final IObjectWrapper n() throws RemoteException {
        Parcel a = a(18, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final zzaeb o() throws RemoteException {
        Parcel a = a(19, y());
        zzaeb a2 = zzaea.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final IObjectWrapper p() throws RemoteException {
        Parcel a = a(20, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final IObjectWrapper q() throws RemoteException {
        Parcel a = a(21, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final void a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, iObjectWrapper2);
        zzgv.a(y, iObjectWrapper3);
        b(22, y);
    }
}
