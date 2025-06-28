package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzanq extends zzgu implements zzano {
    zzanq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a() throws RemoteException {
        b(1, y());
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void b() throws RemoteException {
        b(2, y());
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(int i) throws RemoteException {
        Parcel y = y();
        y.writeInt(i);
        b(3, y);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void c() throws RemoteException {
        b(4, y());
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void d() throws RemoteException {
        b(5, y());
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void e() throws RemoteException {
        b(6, y());
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(zzant zzantVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzantVar);
        b(7, y);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void f() throws RemoteException {
        b(8, y());
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(String str, String str2) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        y.writeString(str2);
        b(9, y);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(zzaff zzaffVar, String str) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzaffVar);
        y.writeString(str);
        b(10, y);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void g() throws RemoteException {
        b(11, y());
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(12, y);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void h() throws RemoteException {
        b(13, y());
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(zzava zzavaVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzavaVar);
        b(14, y);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void i() throws RemoteException {
        b(15, y());
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(zzavc zzavcVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzavcVar);
        b(16, y);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void b(int i) throws RemoteException {
        Parcel y = y();
        y.writeInt(i);
        b(17, y);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void j() throws RemoteException {
        b(18, y());
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(Bundle bundle) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, bundle);
        b(19, y);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void k() throws RemoteException {
        b(20, y());
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void b(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(21, y);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(int i, String str) throws RemoteException {
        Parcel y = y();
        y.writeInt(i);
        y.writeString(str);
        b(22, y);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(zzve zzveVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzveVar);
        b(23, y);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void b(zzve zzveVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzveVar);
        b(24, y);
    }
}
