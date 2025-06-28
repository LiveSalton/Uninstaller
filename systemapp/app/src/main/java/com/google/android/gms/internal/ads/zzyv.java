package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzyv extends zzgu implements zzyt {
    zzyv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void a() throws RemoteException {
        b(1, y());
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void b() throws RemoteException {
        b(2, y());
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void c() throws RemoteException {
        b(3, y());
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void d() throws RemoteException {
        b(4, y());
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void a(boolean z) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, z);
        b(5, y);
    }
}
