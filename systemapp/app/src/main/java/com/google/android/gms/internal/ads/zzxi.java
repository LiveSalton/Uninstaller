package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzxi extends zzgu implements zzxg {
    zzxi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final IObjectWrapper a() throws RemoteException {
        Parcel a = a(1, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void b() throws RemoteException {
        b(2, y());
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final boolean c() throws RemoteException {
        Parcel a = a(3, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final boolean a(zzvk zzvkVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzvkVar);
        Parcel a = a(4, y);
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void d() throws RemoteException {
        b(5, y());
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void e() throws RemoteException {
        b(6, y());
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzwt zzwtVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzwtVar);
        b(7, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzxo zzxoVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzxoVar);
        b(8, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void g() throws RemoteException {
        b(9, y());
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void h() throws RemoteException {
        b(10, y());
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void i() throws RemoteException {
        b(11, y());
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzvn j() throws RemoteException {
        Parcel a = a(12, y());
        zzvn zzvnVar = (zzvn) zzgv.a(a, zzvn.CREATOR);
        a.recycle();
        return zzvnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzvn zzvnVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzvnVar);
        b(13, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzart zzartVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzartVar);
        b(14, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzarz zzarzVar, String str) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzarzVar);
        y.writeString(str);
        b(15, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final String k() throws RemoteException {
        Parcel a = a(18, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzacb zzacbVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzacbVar);
        b(19, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzws zzwsVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzwsVar);
        b(20, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzxu zzxuVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzxuVar);
        b(21, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(boolean z) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, z);
        b(22, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final boolean q() throws RemoteException {
        Parcel a = a(23, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzaup zzaupVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzaupVar);
        b(24, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(25, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzys r() throws RemoteException {
        zzys zzyuVar;
        Parcel a = a(26, y());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzyuVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            if (queryLocalInterface instanceof zzys) {
                zzyuVar = (zzys) queryLocalInterface;
            } else {
                zzyuVar = new zzyu(readStrongBinder);
            }
        }
        a.recycle();
        return zzyuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzaak zzaakVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzaakVar);
        b(29, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzyy zzyyVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzyyVar);
        b(30, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final String n() throws RemoteException {
        Parcel a = a(31, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzxo o() throws RemoteException {
        zzxo zzxqVar;
        Parcel a = a(32, y());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzxqVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            if (queryLocalInterface instanceof zzxo) {
                zzxqVar = (zzxo) queryLocalInterface;
            } else {
                zzxqVar = new zzxq(readStrongBinder);
            }
        }
        a.recycle();
        return zzxqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzwt p() throws RemoteException {
        zzwt zzwvVar;
        Parcel a = a(33, y());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzwvVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            if (queryLocalInterface instanceof zzwt) {
                zzwvVar = (zzwt) queryLocalInterface;
            } else {
                zzwvVar = new zzwv(readStrongBinder);
            }
        }
        a.recycle();
        return zzwvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void b(boolean z) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, z);
        b(34, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final String l() throws RemoteException {
        Parcel a = a(35, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzxj zzxjVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzxjVar);
        b(36, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final Bundle f() throws RemoteException {
        Parcel a = a(37, y());
        Bundle bundle = (Bundle) zzgv.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void b(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(38, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzvw zzvwVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzvwVar);
        b(39, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzsl zzslVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzslVar);
        b(40, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzyn m() throws RemoteException {
        zzyn zzypVar;
        Parcel a = a(41, y());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzypVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            if (queryLocalInterface instanceof zzyn) {
                zzypVar = (zzyn) queryLocalInterface;
            } else {
                zzypVar = new zzyp(readStrongBinder);
            }
        }
        a.recycle();
        return zzypVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzym zzymVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzymVar);
        b(42, y);
    }
}
