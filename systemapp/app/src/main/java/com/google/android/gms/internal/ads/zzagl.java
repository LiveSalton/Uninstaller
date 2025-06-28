package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzagl extends zzgu implements zzagj {
    zzagl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final String a() throws RemoteException {
        Parcel a = a(2, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final List b() throws RemoteException {
        Parcel a = a(3, y());
        ArrayList b = zzgv.b(a);
        a.recycle();
        return b;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final String c() throws RemoteException {
        Parcel a = a(4, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final zzaej d() throws RemoteException {
        zzaej zzaelVar;
        Parcel a = a(5, y());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzaelVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            if (queryLocalInterface instanceof zzaej) {
                zzaelVar = (zzaej) queryLocalInterface;
            } else {
                zzaelVar = new zzael(readStrongBinder);
            }
        }
        a.recycle();
        return zzaelVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final String e() throws RemoteException {
        Parcel a = a(6, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final String f() throws RemoteException {
        Parcel a = a(7, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final double g() throws RemoteException {
        Parcel a = a(8, y());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final String h() throws RemoteException {
        Parcel a = a(9, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final String i() throws RemoteException {
        Parcel a = a(10, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final zzys j() throws RemoteException {
        Parcel a = a(11, y());
        zzys a2 = zzyr.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final String k() throws RemoteException {
        Parcel a = a(12, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void l() throws RemoteException {
        b(13, y());
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final zzaeb m() throws RemoteException {
        zzaeb zzaedVar;
        Parcel a = a(14, y());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzaedVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            if (queryLocalInterface instanceof zzaeb) {
                zzaedVar = (zzaeb) queryLocalInterface;
            } else {
                zzaedVar = new zzaed(readStrongBinder);
            }
        }
        a.recycle();
        return zzaedVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void a(Bundle bundle) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, bundle);
        b(15, y);
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final boolean b(Bundle bundle) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, bundle);
        Parcel a = a(16, y);
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void c(Bundle bundle) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, bundle);
        b(17, y);
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final IObjectWrapper n() throws RemoteException {
        Parcel a = a(18, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final IObjectWrapper o() throws RemoteException {
        Parcel a = a(19, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final Bundle p() throws RemoteException {
        Parcel a = a(20, y());
        Bundle bundle = (Bundle) zzgv.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void a(zzage zzageVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzageVar);
        b(21, y);
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void q() throws RemoteException {
        b(22, y());
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final List r() throws RemoteException {
        Parcel a = a(23, y());
        ArrayList b = zzgv.b(a);
        a.recycle();
        return b;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final boolean s() throws RemoteException {
        Parcel a = a(24, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void a(zzyd zzydVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzydVar);
        b(25, y);
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void a(zzxz zzxzVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzxzVar);
        b(26, y);
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void t() throws RemoteException {
        b(27, y());
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void u() throws RemoteException {
        b(28, y());
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final zzaee v() throws RemoteException {
        zzaee zzaegVar;
        Parcel a = a(29, y());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzaegVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            if (queryLocalInterface instanceof zzaee) {
                zzaegVar = (zzaee) queryLocalInterface;
            } else {
                zzaegVar = new zzaeg(readStrongBinder);
            }
        }
        a.recycle();
        return zzaegVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final boolean w() throws RemoteException {
        Parcel a = a(30, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final zzyn x() throws RemoteException {
        Parcel a = a(31, y());
        zzyn a2 = zzyq.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void a(zzym zzymVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzymVar);
        b(32, y);
    }
}
