package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzavj extends zzgu implements zzavh {
    zzavj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(zzvk zzvkVar, zzavp zzavpVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzvkVar);
        zzgv.a(y, zzavpVar);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(zzavi zzaviVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzaviVar);
        b(2, y);
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final boolean a() throws RemoteException {
        Parcel a = a(3, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final String b() throws RemoteException {
        Parcel a = a(4, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(5, y);
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(zzavq zzavqVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzavqVar);
        b(6, y);
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(zzavy zzavyVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzavyVar);
        b(7, y);
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(zzyh zzyhVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzyhVar);
        b(8, y);
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final Bundle c() throws RemoteException {
        Parcel a = a(9, y());
        Bundle bundle = (Bundle) zzgv.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, z);
        b(10, y);
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final zzavc d() throws RemoteException {
        zzavc zzaveVar;
        Parcel a = a(11, y());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzaveVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
            if (queryLocalInterface instanceof zzavc) {
                zzaveVar = (zzavc) queryLocalInterface;
            } else {
                zzaveVar = new zzave(readStrongBinder);
            }
        }
        a.recycle();
        return zzaveVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final zzyn e() throws RemoteException {
        Parcel a = a(12, y());
        zzyn a2 = zzyq.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(zzym zzymVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzymVar);
        b(13, y);
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void b(zzvk zzvkVar, zzavp zzavpVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzvkVar);
        zzgv.a(y, zzavpVar);
        b(14, y);
    }
}
