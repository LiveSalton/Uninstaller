package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzauy extends zzgu implements zzauw {
    zzauy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void a(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        y.writeInt(i);
        b(2, y);
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void b(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(3, y);
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void c(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(4, y);
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void d(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(5, y);
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void e(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(6, y);
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void a(IObjectWrapper iObjectWrapper, zzava zzavaVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzavaVar);
        b(7, y);
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void f(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(8, y);
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void b(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        y.writeInt(i);
        b(9, y);
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void g(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(10, y);
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void h(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(11, y);
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void a(Bundle bundle) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, bundle);
        b(12, y);
    }
}
