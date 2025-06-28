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
public final class zzaez extends zzgu implements zzaex {
    zzaez(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaex
    public final IObjectWrapper a() throws RemoteException {
        Parcel a = a(2, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaex
    public final String b() throws RemoteException {
        Parcel a = a(3, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaex
    public final List c() throws RemoteException {
        Parcel a = a(4, y());
        ArrayList b = zzgv.b(a);
        a.recycle();
        return b;
    }

    @Override // com.google.android.gms.internal.ads.zzaex
    public final String d() throws RemoteException {
        Parcel a = a(5, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaex
    public final zzaej e() throws RemoteException {
        zzaej zzaelVar;
        Parcel a = a(6, y());
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

    @Override // com.google.android.gms.internal.ads.zzaex
    public final String f() throws RemoteException {
        Parcel a = a(7, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaex
    public final double g() throws RemoteException {
        Parcel a = a(8, y());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzaex
    public final String h() throws RemoteException {
        Parcel a = a(9, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaex
    public final String i() throws RemoteException {
        Parcel a = a(10, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaex
    public final Bundle j() throws RemoteException {
        Parcel a = a(11, y());
        Bundle bundle = (Bundle) zzgv.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzaex
    public final void k() throws RemoteException {
        b(12, y());
    }

    @Override // com.google.android.gms.internal.ads.zzaex
    public final zzys l() throws RemoteException {
        Parcel a = a(13, y());
        zzys a2 = zzyr.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaex
    public final void a(Bundle bundle) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, bundle);
        b(14, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaex
    public final boolean b(Bundle bundle) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, bundle);
        Parcel a = a(15, y);
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaex
    public final void c(Bundle bundle) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, bundle);
        b(16, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaex
    public final zzaeb m() throws RemoteException {
        zzaeb zzaedVar;
        Parcel a = a(17, y());
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

    @Override // com.google.android.gms.internal.ads.zzaex
    public final IObjectWrapper n() throws RemoteException {
        Parcel a = a(18, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaex
    public final String o() throws RemoteException {
        Parcel a = a(19, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
