package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzarl extends zzgu implements zzarj {
    zzarl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void a(Bundle bundle) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, bundle);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void g() throws RemoteException {
        b(2, y());
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void h() throws RemoteException {
        b(3, y());
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void i() throws RemoteException {
        b(4, y());
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void j() throws RemoteException {
        b(5, y());
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void b(Bundle bundle) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, bundle);
        Parcel a = a(6, y);
        if (a.readInt() != 0) {
            bundle.readFromParcel(a);
        }
        a.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void k() throws RemoteException {
        b(7, y());
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void l() throws RemoteException {
        b(8, y());
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void m() throws RemoteException {
        b(9, y());
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void d() throws RemoteException {
        b(10, y());
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final boolean f() throws RemoteException {
        Parcel a = a(11, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void a(int i, int i2, Intent intent) throws RemoteException {
        Parcel y = y();
        y.writeInt(i);
        y.writeInt(i2);
        zzgv.a(y, intent);
        b(12, y);
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(13, y);
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void e() throws RemoteException {
        b(14, y());
    }
}
