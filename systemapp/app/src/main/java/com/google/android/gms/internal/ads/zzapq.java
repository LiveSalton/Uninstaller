package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzapq extends zzgu implements zzapo {
    zzapq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void a(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzvn zzvnVar, zzapt zzaptVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        y.writeString(str);
        zzgv.a(y, bundle);
        zzgv.a(y, bundle2);
        zzgv.a(y, zzvnVar);
        zzgv.a(y, zzaptVar);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final zzaqc a() throws RemoteException {
        Parcel a = a(2, y());
        zzaqc zzaqcVar = (zzaqc) zzgv.a(a, zzaqc.CREATOR);
        a.recycle();
        return zzaqcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final zzaqc b() throws RemoteException {
        Parcel a = a(3, y());
        zzaqc zzaqcVar = (zzaqc) zzgv.a(a, zzaqc.CREATOR);
        a.recycle();
        return zzaqcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final zzys c() throws RemoteException {
        Parcel a = a(5, y());
        zzys a2 = zzyr.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(10, y);
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void a(String[] strArr, Bundle[] bundleArr) throws RemoteException {
        Parcel y = y();
        y.writeStringArray(strArr);
        y.writeTypedArray(bundleArr, 0);
        b(11, y);
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void a(String str, String str2, zzvk zzvkVar, IObjectWrapper iObjectWrapper, zzapc zzapcVar, zzano zzanoVar, zzvn zzvnVar) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        y.writeString(str2);
        zzgv.a(y, zzvkVar);
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzapcVar);
        zzgv.a(y, zzanoVar);
        zzgv.a(y, zzvnVar);
        b(13, y);
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void a(String str, String str2, zzvk zzvkVar, IObjectWrapper iObjectWrapper, zzaph zzaphVar, zzano zzanoVar) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        y.writeString(str2);
        zzgv.a(y, zzvkVar);
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzaphVar);
        zzgv.a(y, zzanoVar);
        b(14, y);
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final boolean b(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        Parcel a = a(15, y);
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void a(String str, String str2, zzvk zzvkVar, IObjectWrapper iObjectWrapper, zzapn zzapnVar, zzano zzanoVar) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        y.writeString(str2);
        zzgv.a(y, zzvkVar);
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzapnVar);
        zzgv.a(y, zzanoVar);
        b(16, y);
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final boolean c(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        Parcel a = a(17, y);
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void a(String str, String str2, zzvk zzvkVar, IObjectWrapper iObjectWrapper, zzapi zzapiVar, zzano zzanoVar) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        y.writeString(str2);
        zzgv.a(y, zzvkVar);
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzapiVar);
        zzgv.a(y, zzanoVar);
        b(18, y);
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void a(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(19, y);
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void b(String str, String str2, zzvk zzvkVar, IObjectWrapper iObjectWrapper, zzapn zzapnVar, zzano zzanoVar) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        y.writeString(str2);
        zzgv.a(y, zzvkVar);
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzapnVar);
        zzgv.a(y, zzanoVar);
        b(20, y);
    }
}
