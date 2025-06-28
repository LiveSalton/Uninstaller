package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzauk extends zzgu implements zzaui {
    zzauk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void a(zzauv zzauvVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzauvVar);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void a() throws RemoteException {
        b(2, y());
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void a(zzaup zzaupVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzaupVar);
        b(3, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final boolean c() throws RemoteException {
        Parcel a = a(5, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void d() throws RemoteException {
        b(6, y());
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void e() throws RemoteException {
        b(7, y());
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void f() throws RemoteException {
        b(8, y());
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void b(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(9, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void c(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(10, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void d(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(11, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final String g() throws RemoteException {
        Parcel a = a(12, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void a(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(13, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void a(zzxj zzxjVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzxjVar);
        b(14, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final Bundle b() throws RemoteException {
        Parcel a = a(15, y());
        Bundle bundle = (Bundle) zzgv.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void a(zzaug zzaugVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzaugVar);
        b(16, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void c(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(17, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(18, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void b(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(19, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void a(boolean z) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, z);
        b(34, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final boolean h() throws RemoteException {
        Parcel a = a(20, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final zzyn i() throws RemoteException {
        Parcel a = a(21, y());
        zzyn a2 = zzyq.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
