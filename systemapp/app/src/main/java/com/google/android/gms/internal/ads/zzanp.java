package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzanp extends zzgu implements zzann {
    zzanp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzvn zzvnVar, zzvk zzvkVar, String str, zzano zzanoVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzvnVar);
        zzgv.a(y, zzvkVar);
        y.writeString(str);
        zzgv.a(y, zzanoVar);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final IObjectWrapper a() throws RemoteException {
        Parcel a = a(2, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, zzano zzanoVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzvkVar);
        y.writeString(str);
        zzgv.a(y, zzanoVar);
        b(3, y);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void b() throws RemoteException {
        b(4, y());
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void c() throws RemoteException {
        b(5, y());
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzvn zzvnVar, zzvk zzvkVar, String str, String str2, zzano zzanoVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzvnVar);
        zzgv.a(y, zzvkVar);
        y.writeString(str);
        y.writeString(str2);
        zzgv.a(y, zzanoVar);
        b(6, y);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, String str2, zzano zzanoVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzvkVar);
        y.writeString(str);
        y.writeString(str2);
        zzgv.a(y, zzanoVar);
        b(7, y);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void d() throws RemoteException {
        b(8, y());
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void e() throws RemoteException {
        b(9, y());
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, zzauw zzauwVar, String str2) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzvkVar);
        y.writeString(str);
        zzgv.a(y, zzauwVar);
        y.writeString(str2);
        b(10, y);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(zzvk zzvkVar, String str) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzvkVar);
        y.writeString(str);
        b(11, y);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void f() throws RemoteException {
        b(12, y());
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final boolean g() throws RemoteException {
        Parcel a = a(13, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, String str2, zzano zzanoVar, zzadz zzadzVar, List<String> list) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzvkVar);
        y.writeString(str);
        y.writeString(str2);
        zzgv.a(y, zzanoVar);
        zzgv.a(y, zzadzVar);
        y.writeStringList(list);
        b(14, y);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzanv h() throws RemoteException {
        zzanv zzanxVar;
        Parcel a = a(15, y());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzanxVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            if (queryLocalInterface instanceof zzanv) {
                zzanxVar = (zzanv) queryLocalInterface;
            } else {
                zzanxVar = new zzanx(readStrongBinder);
            }
        }
        a.recycle();
        return zzanxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzanw i() throws RemoteException {
        zzanw zzanyVar;
        Parcel a = a(16, y());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzanyVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            if (queryLocalInterface instanceof zzanw) {
                zzanyVar = (zzanw) queryLocalInterface;
            } else {
                zzanyVar = new zzany(readStrongBinder);
            }
        }
        a.recycle();
        return zzanyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final Bundle j() throws RemoteException {
        Parcel a = a(17, y());
        Bundle bundle = (Bundle) zzgv.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final Bundle k() throws RemoteException {
        Parcel a = a(18, y());
        Bundle bundle = (Bundle) zzgv.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final Bundle l() throws RemoteException {
        Parcel a = a(19, y());
        Bundle bundle = (Bundle) zzgv.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(zzvk zzvkVar, String str, String str2) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzvkVar);
        y.writeString(str);
        y.writeString(str2);
        b(20, y);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(21, y);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final boolean m() throws RemoteException {
        Parcel a = a(22, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzauw zzauwVar, List<String> list) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzauwVar);
        y.writeStringList(list);
        b(23, y);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzaff n() throws RemoteException {
        Parcel a = a(24, y());
        zzaff a2 = zzafe.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(boolean z) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, z);
        b(25, y);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzys o() throws RemoteException {
        Parcel a = a(26, y());
        zzys a2 = zzyr.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzaob p() throws RemoteException {
        zzaob zzaodVar;
        Parcel a = a(27, y());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzaodVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            if (queryLocalInterface instanceof zzaob) {
                zzaodVar = (zzaob) queryLocalInterface;
            } else {
                zzaodVar = new zzaod(readStrongBinder);
            }
        }
        a.recycle();
        return zzaodVar;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void b(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, zzano zzanoVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzvkVar);
        y.writeString(str);
        zzgv.a(y, zzanoVar);
        b(28, y);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void b(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(30, y);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzajb zzajbVar, List<zzajj> list) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzajbVar);
        y.writeTypedList(list);
        b(31, y);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void c(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, zzano zzanoVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzvkVar);
        y.writeString(str);
        zzgv.a(y, zzanoVar);
        b(32, y);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzaqc q() throws RemoteException {
        Parcel a = a(33, y());
        zzaqc zzaqcVar = (zzaqc) zzgv.a(a, zzaqc.CREATOR);
        a.recycle();
        return zzaqcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzaqc r() throws RemoteException {
        Parcel a = a(34, y());
        zzaqc zzaqcVar = (zzaqc) zzgv.a(a, zzaqc.CREATOR);
        a.recycle();
        return zzaqcVar;
    }
}
