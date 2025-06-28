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
public final class zzaod extends zzgu implements zzaob {
    zzaod(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String a() throws RemoteException {
        Parcel a = a(2, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final List b() throws RemoteException {
        Parcel a = a(3, y());
        ArrayList b = zzgv.b(a);
        a.recycle();
        return b;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String c() throws RemoteException {
        Parcel a = a(4, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final zzaej d() throws RemoteException {
        Parcel a = a(5, y());
        zzaej a2 = zzaei.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String e() throws RemoteException {
        Parcel a = a(6, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String f() throws RemoteException {
        Parcel a = a(7, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final double g() throws RemoteException {
        Parcel a = a(8, y());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String h() throws RemoteException {
        Parcel a = a(9, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String i() throws RemoteException {
        Parcel a = a(10, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final zzys j() throws RemoteException {
        Parcel a = a(11, y());
        zzys a2 = zzyr.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final zzaeb k() throws RemoteException {
        Parcel a = a(12, y());
        zzaeb a2 = zzaea.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final IObjectWrapper l() throws RemoteException {
        Parcel a = a(13, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final IObjectWrapper m() throws RemoteException {
        Parcel a = a(14, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final IObjectWrapper n() throws RemoteException {
        Parcel a = a(15, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final Bundle o() throws RemoteException {
        Parcel a = a(16, y());
        Bundle bundle = (Bundle) zzgv.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final boolean p() throws RemoteException {
        Parcel a = a(17, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final boolean q() throws RemoteException {
        Parcel a = a(18, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void r() throws RemoteException {
        b(19, y());
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(20, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, iObjectWrapper2);
        zzgv.a(y, iObjectWrapper3);
        b(21, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void b(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(22, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final float s() throws RemoteException {
        Parcel a = a(23, y());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final float t() throws RemoteException {
        Parcel a = a(24, y());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final float u() throws RemoteException {
        Parcel a = a(25, y());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }
}
