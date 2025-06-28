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
public final class zzany extends zzgu implements zzanw {
    zzany(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final String a() throws RemoteException {
        Parcel a = a(2, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final List b() throws RemoteException {
        Parcel a = a(3, y());
        ArrayList b = zzgv.b(a);
        a.recycle();
        return b;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final String c() throws RemoteException {
        Parcel a = a(4, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final zzaej d() throws RemoteException {
        Parcel a = a(5, y());
        zzaej a2 = zzaei.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final String e() throws RemoteException {
        Parcel a = a(6, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final String f() throws RemoteException {
        Parcel a = a(7, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final void g() throws RemoteException {
        b(8, y());
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(9, y);
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final void b(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(10, y);
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final boolean h() throws RemoteException {
        Parcel a = a(11, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final boolean i() throws RemoteException {
        Parcel a = a(12, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final Bundle j() throws RemoteException {
        Parcel a = a(13, y());
        Bundle bundle = (Bundle) zzgv.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final void c(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(14, y);
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final IObjectWrapper k() throws RemoteException {
        Parcel a = a(15, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final zzys l() throws RemoteException {
        Parcel a = a(16, y());
        zzys a2 = zzyr.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final zzaeb m() throws RemoteException {
        Parcel a = a(19, y());
        zzaeb a2 = zzaea.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final IObjectWrapper n() throws RemoteException {
        Parcel a = a(20, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final IObjectWrapper o() throws RemoteException {
        Parcel a = a(21, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final void a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, iObjectWrapper2);
        zzgv.a(y, iObjectWrapper3);
        b(22, y);
    }
}
