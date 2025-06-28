package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzafh extends zzgu implements zzaff {
    zzafh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final String a(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        Parcel a = a(1, y);
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final zzaej b(String str) throws RemoteException {
        zzaej zzaelVar;
        Parcel y = y();
        y.writeString(str);
        Parcel a = a(2, y);
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

    @Override // com.google.android.gms.internal.ads.zzaff
    public final List<String> a() throws RemoteException {
        Parcel a = a(3, y());
        ArrayList<String> createStringArrayList = a.createStringArrayList();
        a.recycle();
        return createStringArrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final String b() throws RemoteException {
        Parcel a = a(4, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final void c(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(5, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final void c() throws RemoteException {
        b(6, y());
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final zzys d() throws RemoteException {
        Parcel a = a(7, y());
        zzys a2 = zzyr.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final void e() throws RemoteException {
        b(8, y());
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final IObjectWrapper f() throws RemoteException {
        Parcel a = a(9, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final boolean a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        Parcel a = a(10, y);
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final IObjectWrapper g() throws RemoteException {
        Parcel a = a(11, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final boolean h() throws RemoteException {
        Parcel a = a(12, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final boolean i() throws RemoteException {
        Parcel a = a(13, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final void b(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(14, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final void j() throws RemoteException {
        b(15, y());
    }
}
